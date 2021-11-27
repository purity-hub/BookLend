package com.lhy.booklend.book.controller;

import com.lhy.booklend.BookLendApplication;
import com.lhy.booklend.book.entity.Book;
import com.lhy.booklend.book.entity.Booklist;
import com.lhy.booklend.book.entity.Public;
import com.lhy.booklend.book.entity.Reader;
import com.lhy.booklend.book.service.BookService;
import com.lhy.booklend.book.service.BuyService;
import com.lhy.booklend.book.service.PublicService;
import com.lhy.booklend.book.service.ReaderService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class BookController implements Initializable {

    @Autowired
    BookService bookService;

    @Autowired
    BuyService buyService;

    @Autowired
    PublicService publicService;

    @Autowired
    ReaderService readerService;

    @FXML
    TableColumn bNo;

    @FXML
    TableColumn ISBN;

    @FXML
    TableColumn bDamaged;

    @FXML
    TableColumn bLocation;

    @FXML
    TableColumn bPrice;

    @FXML
    TableColumn booknums;

    @FXML
    TextField bNoAuto;

    @FXML
    ChoiceBox ISBNAuto;

    @FXML
    TableView<Book> books;

    @FXML
    ChoiceBox choicebox;

    @FXML
    TextField bLocationAuto;

    @FXML
    TextField bPriceAuto;

    @FXML
    TableView booklist2;

    @FXML
    TableColumn buyisbn;

    @FXML
    TableColumn bName;

    @FXML
    TableColumn bClass;

    @FXML
    TableColumn bPublic;

    @FXML
    TableColumn bAuthor;

    @FXML
    ListView publics;

    @FXML
    TableView publicreal;

    @FXML
    TableColumn publicname;

    @FXML
    TableColumn telegraph;

    @FXML
    TableColumn phone;

    @FXML
    TableColumn zip;

    @FXML
    TableColumn address;

    @FXML
    TableView readers;

    @FXML
    TableColumn rNo;

    @FXML
    TableColumn rIdcard;

    @FXML
    TableColumn rName;

    @FXML
    TableColumn rSex;

    @FXML
    TableColumn rBirthday;

    @FXML
    TableColumn rTel;

    @FXML
    TableColumn category;

    @FXML
    TableColumn bookname;

    @FXML
    TextField addpName;

    @FXML
    TextField addtelegraph;

    @FXML
    TextField addphone;

    @FXML
    TextField addzip;

    @FXML
    TextField addaddress;

    @FXML
    TextField bisbn;

    @FXML
    TextField buyname;

    @FXML
    TextField buyclass;

    @FXML
    TextField buypublic;

    @FXML
    TextField buyauthor;

    @FXML
    TextField buyprice;

    @FXML
    Label nowtime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //下面是显示时间的功能
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        //System.out.println(simpleDateFormat);
        EventHandler<ActionEvent> eventHandler = e -> {
            nowtime.setText(simpleDateFormat.format(new Date()));
            //System.out.println(simpleDateFormat.format(new Date()));
        };
        //设置时间线触发事件
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        //设置可编辑
        readers.setEditable(true);
        rIdcard.setCellFactory(TextFieldTableCell.forTableColumn());
        rName.setCellFactory(TextFieldTableCell.forTableColumn());
        rSex.setCellFactory(TextFieldTableCell.forTableColumn());
        //rBirthday.setCellFactory(TextFieldTableCell.forTableColumn());
        rTel.setCellFactory(TextFieldTableCell.forTableColumn());
        category.setCellFactory(TextFieldTableCell.forTableColumn());

        //初始化
        List<Book> bookList=bookService.findAllBooks();
        //System.out.println(bookList);//连接查询加了属性bName
        List<Booklist> booklists=buyService.findAll();
        List<String> publicss=publicService.findAll();//查询所有的出版社
        publicss.add(0,"全部");
        List<Public> publicList=publicService.findAllPublic();//出版社实体
        List<Reader> readerList=readerService.findAll();

        //设置完好程度的下拉框，应为fxml文件好像不能直接加了
        ObservableList<String> observableList = FXCollections.observableArrayList("破损", "完好");
        choicebox.setItems(observableList);
        //添加isbn
        ObservableList<String> observableList1=FXCollections.observableArrayList(buyService.findByIsbn());
        ISBNAuto.setItems(observableList1);
        //System.out.println(bookList.size());
        //设置列取值对应的属性名称,对应于实体类的命名
        setCell();
        setCell2();
        setCell3();
        setCell4();
        ObservableList<Book> items = FXCollections.observableArrayList(bookList);
        //System.out.println(items);
        ObservableList<Booklist> items2=FXCollections.observableArrayList(booklists);
        ObservableList<String> item3=FXCollections.observableArrayList(publicss);
        ObservableList<Public> item4=FXCollections.observableArrayList(publicList);
        ObservableList<Reader> item5=FXCollections.observableArrayList(readerList);
        //System.out.println(items);
        //设置表格视图的数据来源
        booklist2.setItems(items2);
        booklist2.setRowFactory(new Callback<TableView<Booklist>, TableRow<Booklist>>() {
            @Override
            public TableRow<Booklist> call(TableView<Booklist> param) {
                TableRow<Booklist> row=new TableRow<Booklist>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(mouseEvent.getClickCount()==2 && !row.isEmpty()){
                            Booklist item=row.getItem();
                            bisbn.setText(item.getIsbn());
                            buyname.setText(item.getBName());
                            buyclass.setText(item.getBClass());
                            buypublic.setText(item.getBPublic());
                            buyauthor.setText(item.getBAuthor());
                        }
                    }
                });
                return row;
            }
        });
        books.setItems(items);
        publics.setItems(item3);
        //出版社的监听事件
        publics.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                //监听选择的新旧值
                //System.out.println(newValue);
                if(newValue.equals("全部")){
                    List<Booklist> all = buyService.findAll();
                    ObservableList<Booklist> booklists1 = FXCollections.observableArrayList(all);
                    booklist2.setItems(booklists1);
                }else{
                    List<Booklist> byPublic = buyService.findByPublic(newValue);
                    ObservableList<Booklist> booklists1 = FXCollections.observableArrayList(byPublic);
                    booklist2.setItems(booklists1);
                }
            }
        });
        publicreal.setItems(item4);
        //读者
        readers.setItems(item5);
        //官方文档是setOnEditCommit
        //修改读者表的性别
        rSex.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                String newValue = String.valueOf(cellEditEvent.getNewValue());
                Reader rowValue = (Reader) cellEditEvent.getRowValue();
                readerService.updaterSex(rowValue.getRNo(),newValue);
                List<Reader> all = readerService.findAll();
                ObservableList<Reader> readersList = FXCollections.observableArrayList(all);
                readers.setItems(readersList);
            }
        });
        //修改读者表的rIdcard
        rIdcard.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                String newValue = String.valueOf(cellEditEvent.getNewValue());
                Reader rowValue = (Reader) cellEditEvent.getRowValue();
                readerService.updaterIdcard(rowValue.getRNo(),newValue);
                List<Reader> all = readerService.findAll();
                ObservableList<Reader> readersList = FXCollections.observableArrayList(all);
                readers.setItems(readersList);
            }
        });
        //修改读者表的姓名
        rName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                String newValue = String.valueOf(cellEditEvent.getNewValue());
                Reader rowValue = (Reader) cellEditEvent.getRowValue();
                readerService.updaterName(rowValue.getRNo(),newValue);
                List<Reader> all = readerService.findAll();
                ObservableList<Reader> readersList = FXCollections.observableArrayList(all);
                readers.setItems(readersList);
            }
        });
        //修改读者表电话
        rTel.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                String newValue = String.valueOf(cellEditEvent.getNewValue());
                Reader rowValue = (Reader) cellEditEvent.getRowValue();
                readerService.updaterTel(rowValue.getRNo(),newValue);
                List<Reader> all = readerService.findAll();
                ObservableList<Reader> readersList = FXCollections.observableArrayList(all);
                readers.setItems(readersList);
            }
        });
        //修改读者表类别
        category.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent cellEditEvent) {
                String newValue = String.valueOf(cellEditEvent.getNewValue());
                Reader rowValue = (Reader) cellEditEvent.getRowValue();
                readerService.updatecategory(rowValue.getRNo(),newValue);
                List<Reader> all = readerService.findAll();
                ObservableList<Reader> readersList = FXCollections.observableArrayList(all);
                readers.setItems(readersList);
            }
        });
        /**
         * 图书列表双击事件
         */
        books.setRowFactory(new Callback<TableView<Book>, TableRow<Book>>() {
            @Override
            public TableRow<Book> call(TableView<Book> param) {
                TableRow<Book> row = new TableRow<Book>();
                //每一行设置监听
                row.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        if (event.getClickCount() == 2 && (! row.isEmpty()) )
                        {
                            //System.out.println(row.getIndex());
                            Book item = row.getItem();
                            //System.out.println(item);
                            bNoAuto.setText(item.getBNo());
                            ISBNAuto.setValue(item.getIsbn());
                            choicebox.setValue(item.getBDamaged());
                            bLocationAuto.setText(item.getBLocation());
                            bPriceAuto.setText(String.valueOf(item.getBPrice()));
                        }
                    }
                });
                return row;
            }
        });
        /**
         * 读者修改监听
         */
//        readers.setRowFactory(new Callback<TableView<Reader>, TableRow<Reader>>() {
//            @Override
//            public TableRow<Reader> call(TableView<Reader> param) {
//                TableRow<Reader> row=new TableRow<>();
//                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent mouseEvent) {
//                        if(mouseEvent.getClickCount()==1 && (! row.isEmpty())){
//                            rName.setCellFactory(new Callback<TableColumn, TableCell>() {
//                                @Override
//                                public TableCell call(TableColumn tableColumn) {
//                                    return null;
//                                }
//                            });
//                        }
//                    }
//                });
//                return row;
//            }
//        });
    }
    //设置列取值对应的属性名称,对应于实体类的命名
    public void setCell(){
        bNo.setCellValueFactory(new PropertyValueFactory<>("bNo"));
        bookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        bDamaged.setCellValueFactory(new PropertyValueFactory<>("bDamaged"));
        bLocation.setCellValueFactory(new PropertyValueFactory<>("bLocation"));
        bPrice.setCellValueFactory(new PropertyValueFactory<>("bPrice"));
        booknums.setCellValueFactory(new PropertyValueFactory<>("booknums"));
    }
    public void setCell2(){
        buyisbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        bName.setCellValueFactory(new PropertyValueFactory<>("bName"));
        bClass.setCellValueFactory(new PropertyValueFactory<>("bClass"));
        bPublic.setCellValueFactory(new PropertyValueFactory<>("bPublic"));
        bAuthor.setCellValueFactory(new PropertyValueFactory<>("bAuthor"));
    }
    public void setCell3(){
        publicname.setCellValueFactory(new PropertyValueFactory<>("pName"));
        telegraph.setCellValueFactory(new PropertyValueFactory<>("telegraph"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        zip.setCellValueFactory(new PropertyValueFactory<>("zip"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    public void setCell4(){
        rNo.setCellValueFactory(new PropertyValueFactory<>("rNo"));
        rIdcard.setCellValueFactory(new PropertyValueFactory<>("rIdcard"));
        rName.setCellValueFactory(new PropertyValueFactory<>("rName"));
        rSex.setCellValueFactory(new PropertyValueFactory<>("rSex"));
        rBirthday.setCellValueFactory(new PropertyValueFactory<>("rBirthday"));
        rTel.setCellValueFactory(new PropertyValueFactory<>("rTel"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
    }
    public void getData(){
        String bNoEdit=bNoAuto.getText();
        String isbnEdit= String.valueOf(ISBNAuto.getValue());
        String bDamagedEdit= String.valueOf(choicebox.getValue());
        String bLocationEdit=bLocationAuto.getText();
        Double bPriceEdit= Double.valueOf(bPriceAuto.getText());
    }
    @FXML
    public void edit(){
        //按钮修改
        String bNoEdit=bNoAuto.getText();
        String isbnEdit= String.valueOf(ISBNAuto.getValue());
        String bDamagedEdit= String.valueOf(choicebox.getValue());
        String bLocationEdit=bLocationAuto.getText();
        Double bPriceEdit= Double.valueOf(bPriceAuto.getText());
        bookService.edit(bNoEdit,isbnEdit,bDamagedEdit,bLocationEdit,bPriceEdit);
        List<Book> bookList=bookService.findAllBooks();
        setCell();
        ObservableList<Book> items = FXCollections.observableArrayList(bookList);
        //System.out.println(items);
        //设置表格视图的数据来源
        books.setItems(items);
    }
    @FXML
    public void add(){
        String bNoEdit=bNoAuto.getText();
        String isbnEdit= String.valueOf(ISBNAuto.getValue());
        String bDamagedEdit= String.valueOf(choicebox.getValue());
        String bLocationEdit=bLocationAuto.getText();
        Double bPriceEdit= Double.valueOf(bPriceAuto.getText());
        if(bookService.add(bNoEdit,isbnEdit,bDamagedEdit,bLocationEdit,bPriceEdit).equals(false)){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(BookLendApplication.getStage());
            a.setHeaderText("书号重复！");
            a.showAndWait();
        }else{
            bookService.add(bNoEdit,isbnEdit,bDamagedEdit,bLocationEdit,bPriceEdit);
        }
        List<Book> bookList=bookService.findAllBooks();
        setCell();
        ObservableList<Book> items = FXCollections.observableArrayList(bookList);
        //System.out.println(items);
        //设置表格视图的数据来源
        books.setItems(items);
    }
    @FXML
    public void delete(){
        //按钮删除
        String bNoEdit=bNoAuto.getText();
        bookService.delete(bNoEdit);
        List<Book> bookList=bookService.findAllBooks();
        setCell();
        ObservableList<Book> items = FXCollections.observableArrayList(bookList);
        //System.out.println(items);
        //设置表格视图的数据来源
        books.setItems(items);
    }
    @FXML
    public void clear(){
        bNoAuto.setText("");
        ISBNAuto.setValue("");
        choicebox.setValue("");
        bLocationAuto.setText("");
        bPriceAuto.setText("");
    }
    //增加出版社
    @FXML
    public void addPublic(){
        String text = addpName.getText();
        String text1 = addtelegraph.getText();
        String text2 = addphone.getText();
        String text3 = addzip.getText();
        String text4 = addaddress.getText();
        if(text.equals("")||text1.equals("")||text2.equals("")||text3.equals("")||text4.equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(BookLendApplication.getStage());
            a.setHeaderText("出版社信息不能为空");
            a.showAndWait();
        }else{
            publicService.addPublic(text, Long.parseLong(text1),text2,text3,text4);
            List<Public> publicList=publicService.findAllPublic();
            ObservableList<Public> publics = FXCollections.observableArrayList(publicList);
            publicreal.setItems(publics);
        }
    }
    @FXML
    public void buybook(){
        //不怕困难，没有什么是算法解决不了的
        String bisbnText = bisbn.getText();//isbn
        String buynameText = buyname.getText();//bName
        String buypriceText = buyprice.getText();//bPrice
        //下面是生成bNo的规则
        int size = bookService.findAllBooks().size()+1;
        //模板 'b00001'
        String bNo="b";
        //判断是几位数，直接转化为字符串形式，但是效率好像说不高
        //int length=(""+size).length();
        //或者
        int length=0;
        for (int temp = size; temp!=0 ; temp/=10) {
            length++;
        }
        for(int i=0;i<5-length;i++){
            bNo=bNo+"0";
        }
        bNo=bNo+size;//每点击一次按钮都会重新刷新bNo的生成的数据
        //System.out.println(bNo);
        //判断图书表中是否已经存在该数据isbn
        List<String> isbnList=bookService.findisbn();
        List<Double> priceList=bookService.findprice(bisbnText);
        //isbn存在且价格相同视为同一个bNo下的书籍
        //一个bNo对应一个价格
        if(buypriceText.equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(BookLendApplication.getStage());
            a.setHeaderText("必须输入价格");
            a.showAndWait();
        }else{
            if(isbnList.contains(bisbnText)){
                //存在相同的isbn，下面判断价格是否相同
                if(priceList.contains(Double.parseDouble(buypriceText))){
                    //更新相应的图书数量通过isbn和价格
                    int getbooknums = bookService.getbooknums(bisbnText, Double.parseDouble(buypriceText));
                    //这里++运算符在前面还是后面真的服了
                    int setbooknums =getbooknums+1;
                    bookService.updatenums(bisbnText, Double.parseDouble(buypriceText),setbooknums);
                    List<Book> allBooks = bookService.findAllBooks();
                    ObservableList<Book> bookss = FXCollections.observableArrayList(allBooks);
                    books.setItems(bookss);
                }else{
                    bookService.add(bNo,bisbnText,"完好","", Double.parseDouble(buypriceText));
                    List<Book> allBooks = bookService.findAllBooks();
                    ObservableList<Book> bookss = FXCollections.observableArrayList(allBooks);
                    books.setItems(bookss);
                }
            }else{
                bookService.add(bNo,bisbnText,"完好","", Double.parseDouble(buypriceText));
                List<Book> allBooks = bookService.findAllBooks();
                ObservableList<Book> bookss = FXCollections.observableArrayList(allBooks);
                books.setItems(bookss);
            }
        }
    }
}
