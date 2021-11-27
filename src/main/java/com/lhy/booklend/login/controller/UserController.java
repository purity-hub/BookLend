package com.lhy.booklend.login.controller;

import com.lhy.booklend.BookLendApplication;
import com.lhy.booklend.View.AdminView;
import com.lhy.booklend.View.LoginView;
import com.lhy.booklend.View.ReaderView;
import com.lhy.booklend.login.entity.User;
import com.lhy.booklend.login.mapper.LoginMapper;
import com.lhy.booklend.login.service.LoginService;
import com.lhy.booklend.login.service.UserService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class UserController implements Initializable {

    @Autowired
    LoginService loginService;
    @Autowired
    LoginMapper loginMapper;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;
    @FXML
    public void login(){
        //System.out.println("HelloWorld!");
        //System.out.println(username.getText());
        String name=username.getText();
        String pwd=password.getText();
        if(name.equals("")||pwd.equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(BookLendApplication.getStage());
            a.setHeaderText("用户名、密码必填！");
            a.showAndWait();
        }else if(loginService.login(name,pwd)){
            //用户名和密码正确，关闭登录窗口
            BookLendApplication.getStage().close();
            User user = loginMapper.selectByname(name);
            if(user.getType().equals("管理员")){//获取用户类型
                //管理员
                BookLendApplication.showView(AdminView.class);
            }else{
                //读者
                BookLendApplication.allname=user.getName();
                BookLendApplication.showView(ReaderView.class);
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.initOwner(BookLendApplication.getStage());
            a.setHeaderText("用户名或密码错误！");
            a.showAndWait();
            //清空输入的数据
            username.clear();
            password.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookLendApplication.controllers.put(this.getClass().getSimpleName(),this);

    }
}
