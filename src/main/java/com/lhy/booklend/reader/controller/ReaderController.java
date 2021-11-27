package com.lhy.booklend.reader.controller;

import com.lhy.booklend.BookLendApplication;
import com.lhy.booklend.book.entity.Book;
import com.lhy.booklend.book.service.BookService;
import com.lhy.booklend.book.service.ReaderService;
import com.lhy.booklend.book.service.impl.BookServiceImpl;
import com.lhy.booklend.reader.entity.Borrow;
import com.lhy.booklend.reader.service.BorrowService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ReaderController implements Initializable {

    //没有Controller则不会装配
    @Autowired
    BookService bookService;

    @Autowired
    BorrowService borrowService;

    @Autowired
    ReaderService readerService;

    @FXML
    TableColumn bNo;

    @FXML
    TableColumn bookname;

    @FXML
    TableColumn ISBN;

    @FXML
    TableColumn bDamaged;

    @FXML
    TableColumn bLocation;

    @FXML
    TableColumn booknums;

    @FXML
    TableView books;

    @FXML
    TableView borrow;

    @FXML
    TableColumn sNumber;

    @FXML
    TableColumn brNo;

    @FXML
    TableColumn bbNo;

    @FXML
    TableColumn bdate;

    @FXML
    TableColumn rdate;

    @FXML
    TableColumn fine;

    @FXML
    TableColumn reason;

    @FXML
    ListView borrowing;

    @FXML
    TableView rlend;

    @FXML
    TableColumn rsNumber;

    @FXML
    TableColumn rrNo;

    @FXML
    TableColumn rbNo;

    @FXML
    TableColumn rbName;

    @FXML
    TableColumn rbLocation;

    @FXML
    TableColumn rbdate;

    @FXML
    TextField gsNumber;

    @FXML
    TextField gbNo;

    @FXML
    TextField gbName;

    @FXML
    TextField gbLocation;

    @FXML
    ChoiceBox gbDamaged;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //初始化选择框
        ObservableList<String> objects = FXCollections.observableArrayList("完好","破损");
        gbDamaged.setItems(objects);
        //初始化图书列表
        List<Book> bookList=bookService.findAllBooks();
        //查询登录用户的借阅信息
        //根据名字查询相应的bNo
        String searchbyname = readerService.searchbyname(BookLendApplication.allname);
        List<Borrow> BorrowList = borrowService.findAll(searchbyname);
        List<Borrow> findnotread = borrowService.findnotread(searchbyname);
        setCell();
        setCell2();
        setCell3();
        ObservableList<Book> items = FXCollections.observableArrayList(bookList);
        ObservableList<Borrow> items2 = FXCollections.observableArrayList(BorrowList);
        ObservableList<Borrow> items3 = FXCollections.observableArrayList(findnotread);
        books.setItems(items);
        borrow.setItems(items2);
        rlend.setItems(items3);
        rlend.setRowFactory(new Callback<TableView<Borrow>, TableRow<Borrow>>() {
            @Override
            public TableRow<Borrow> call(TableView<Borrow> tableView) {
                TableRow row =new TableRow();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(mouseEvent.getClickCount()==2 &&(!row.isEmpty())){
                            Borrow item =(Borrow) row.getItem();
                            gsNumber.setText(item.getSNumber());
                            gbNo.setText(item.getBNo());
                            gbName.setText(item.getBName());
                            gbLocation.setText(item.getBLocation());
                        }
                    }
                });
                return row;
            }
        });
        //System.out.println(BookLendApplication.allname);//可以传递值
        //全局变量要指定对象，不然会被垃圾回收
        List<String> booknameList=new ArrayList<>();
        books.setRowFactory(new Callback<TableView<Borrow>, TableRow<Borrow>>() {
            @Override
            public TableRow<Borrow> call(TableView<Borrow> tableView) {
                TableRow row=new TableRow();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(mouseEvent.getClickCount()==2 && (!row.isEmpty())){
                            //System.out.println(row.getItem());
                            Book item =(Book) row.getItem();
                            String bNo = item.getBNo();
                            String bookname = item.getBookname();
                            String borrowbook=bNo+":"+bookname;
                            if(borrowing.getItems().contains(borrowbook)){
                                Alert a = new Alert(Alert.AlertType.ERROR);
                                a.initOwner(BookLendApplication.getStage());
                                a.setHeaderText("不能重复借阅！");
                                a.showAndWait();
                            }else{
                                borrowing.getItems().add(borrowbook);
                            }
//                            if(booknameList.contains(borrowbook)){
//                                Alert a = new Alert(Alert.AlertType.ERROR);
//                                a.initOwner(BookLendApplication.getStage());
//                                a.setHeaderText("不能重复借阅！");
//                                a.showAndWait();
//                            }else{
//                                booknameList.add(borrowbook);
//                            }
//                            ObservableList<String> books = FXCollections.observableArrayList(booknameList);
//                            borrowing.setItems(books);
                        }
                    }
                });
                return row;
            }
        });
        //按住Ctrl可以多选
        borrowing.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    //设置图书列表绑定
    public void setCell(){
        bNo.setCellValueFactory(new PropertyValueFactory<>("bNo"));
        bookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        bDamaged.setCellValueFactory(new PropertyValueFactory<>("bDamaged"));
        bLocation.setCellValueFactory(new PropertyValueFactory<>("bLocation"));
        booknums.setCellValueFactory(new PropertyValueFactory<>("booknums"));
    }
    //设置借阅表的绑定
    public void setCell2(){
        sNumber.setCellValueFactory(new PropertyValueFactory<>("sNumber"));
        brNo.setCellValueFactory(new PropertyValueFactory<>("rNo"));
        bbNo.setCellValueFactory(new PropertyValueFactory<>("bNo"));
        bdate.setCellValueFactory(new PropertyValueFactory<>("bdate"));
        rdate.setCellValueFactory(new PropertyValueFactory<>("rdate"));
        fine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }
    public void setCell3(){
        rsNumber.setCellValueFactory(new PropertyValueFactory<>("sNumber"));
        rrNo.setCellValueFactory(new PropertyValueFactory<>("rNo"));
        rbNo.setCellValueFactory(new PropertyValueFactory<>("bNo"));
        rbName.setCellValueFactory(new PropertyValueFactory<>("bName"));
        rbLocation.setCellValueFactory(new PropertyValueFactory<>("bLocation"));
        rbdate.setCellValueFactory(new PropertyValueFactory<>("bdate"));
    }
    @FXML
    public void delete(){
        //System.out.println(borrowing.getSelectionModel().getSelectedItems());//打印选择的书籍
        borrowing.getItems().removeAll(borrowing.getSelectionModel().getSelectedItems());
    }
    public void lend(){
        for (int i = 0; i < borrowing.getItems().size(); i++) {
            //System.out.println(borrowing.getItems().get(i));
            String[] split = String.valueOf(borrowing.getItems().get(i)).split(":");
            //System.out.println(split[0]);
            //生成流水号
            String sNumber="L";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            sNumber=sNumber+simpleDateFormat.format(new Date());
            String rNo=readerService.searchbyname(BookLendApplication.allname);
            /*
            System.out.println(sNumber);
            System.out.println(rNo);
            System.out.println(split[0]);
            System.out.println(simpleDateFormat1.format(new Date()));
            */
            String format = simpleDateFormat1.format(new Date());
            //System.out.println(java.sql.Date.valueOf(format));
            borrowService.insertBorrow(sNumber,rNo,split[0], java.sql.Date.valueOf(format));
        }
        String searchbyname = readerService.searchbyname(BookLendApplication.allname);
        List<Borrow> BorrowList = borrowService.findAll(searchbyname);
        List<Borrow> findnotread = borrowService.findnotread(searchbyname);
        ObservableList<Borrow> items2 = FXCollections.observableArrayList(BorrowList);
        ObservableList<Borrow> borrows = FXCollections.observableArrayList(findnotread);
        borrow.setItems(items2);
        rlend.setItems(borrows);
        borrowing.getItems().clear();
    }
    public void bookreturn(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        String text = gsNumber.getText();
        String text1 = gbNo.getText();
        String searchbyname = readerService.searchbyname(BookLendApplication.allname);
        //破损情况
        String value = String.valueOf(gbDamaged.getValue());
        if(value.equals("完好")||value.equals("破损")){
            bookService.updatebDamaged(text1,value);//更新破损情况
        }
        //bookService.updatebDamaged(text1,value);//更新破损情况
        double fine=0.0;//罚款
        borrowService.updaterdate(text,searchbyname,text1, java.sql.Date.valueOf(format));
        int fineday = java.sql.Date.valueOf(format).getDate() - borrowService.searchbdate(text, searchbyname, text1).getDate();
        String reason="";
        if(value.equals("破损")){
            fine=fine+1;
            reason=reason+"破损 ";
        }
        if(java.sql.Date.valueOf(format).getDate()-borrowService.searchbdate(text,searchbyname,text1).getDate()>=60){
            //System.out.println("罚款");
            //System.out.println(fineday);
            fineday=fineday-60;
            fine=fine+fineday*0.5;
            reason=reason+"超期 ";
        }
        borrowService.updatefine(text,searchbyname,text1,fine);//更新罚款
        borrowService.updatereason(text,searchbyname,text1,reason);//更新原因
        List<Borrow> BorrowList = borrowService.findAll(searchbyname);
        List<Borrow> findnotread = borrowService.findnotread(searchbyname);
        List<Book> bookList=bookService.findAllBooks();
        ObservableList<Borrow> borrows = FXCollections.observableArrayList(BorrowList);
        ObservableList<Borrow> borrows1 = FXCollections.observableArrayList(findnotread);
        ObservableList<Book> books1 = FXCollections.observableArrayList(bookList);
        borrow.setItems(borrows);
        rlend.setItems(borrows1);
        books.setItems(books1);
    }
}
