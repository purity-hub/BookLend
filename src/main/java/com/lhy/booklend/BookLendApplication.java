package com.lhy.booklend;

import com.lhy.booklend.View.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class BookLendApplication extends AbstractJavaFxApplicationSupport {

    public static Map<String, Object> controllers = new HashMap<String, Object>();

    //设置全局变量姓名
    public static String allname=null;

    public static void main(String[] args) {
        //SpringApplication.run(BookLendApplication.class, args);
        launch(BookLendApplication.class, LoginView.class,args);
    }


    //通过调用Thread类的start()方法来启动一个线程
    @Override
    public void start(Stage stage) throws Exception {
        //设置关闭请求的监听器
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("退出？！");
                //设置对话框的 icon 图标
                alert.initOwner(stage);
                alert.setHeaderText("您确定要退出程序？");
                Optional result = alert.showAndWait();
                if (result.get() == ButtonType.CANCEL) {
                    event.consume();
                }

            }
        });

        super.start(stage);
    }
}
