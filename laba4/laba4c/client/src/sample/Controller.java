package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.Socket;

public class Controller
{
    Socket clientSocket = null;
    OutputStream coos = null;
    InputStream cois = null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private Button bConnect;

    @FXML
    private Button bDisconnect;

    @FXML
    private Button bSend;

    @FXML
    private TextField eip;

    @FXML
    private TextField ePort;

    @FXML
    private TextArea eServer;

    @FXML
    private TextField eString1;

    @FXML
    private TextField eString2;

    @FXML
    void ClickConnect(ActionEvent event)
    {
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Подключение выполнено успешно");

        String port = ePort.getText();

        try
        {
            clientSocket = new Socket(eip.getText(), Integer.parseInt(port));//установление //соединения между локальной машиной и указанным портом узла сети
            cois = clientSocket.getInputStream();//создание //потока ввода
            coos = clientSocket.getOutputStream();//создание //потока вывода
            bConnect.setDisable(true);
            bDisconnect.setDisable(false);
            bSend.setDisable(false);
            eString1.setDisable(false);
            eString2.setDisable(false);
            ePort.setDisable(true);
            eip.setDisable(true);
        }

        catch(Exception e)
        {
            e.printStackTrace();//выполнение метода исключения е
            alert.setTitle("Ошибка");
            alert.setContentText(e.getMessage());
        }

        alert.showAndWait();
    }


    @FXML
    void ClickDisconnect(ActionEvent event)
    {
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Отключение выполнено успешно");

        try
        {
        coos.write("quit".getBytes());
        coos.close();//закрытие потока вывода
        cois.close();//закрытие потока ввода
        clientSocket.close();//закрытие сокета

        bConnect.setDisable(false);
        bDisconnect.setDisable(true);
        bSend.setDisable(true);
        eString1.setDisable(true);
        eString2.setDisable(true);
        ePort.setDisable(false);
        eip.setDisable(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();//вызывается метод исключения е
            alert.setContentText(e.getMessage());
        }
        alert.showAndWait();
    }

    @FXML
    void ClickSend(ActionEvent event)
    {
        try
        {
        String strings = "";
        byte [] buf = new byte[1024];

        strings = eString1.getText() + " " + eString2.getText();

        coos.write(strings.getBytes());//потоку вывода присваивается //значение строковой переменной (передается серверу)
        cois.read(buf);

        String serverMessageRecieved = new String(buf, "UTF-8");
        eServer.appendText( serverMessageRecieved + "\n");

        for (int i = 0; i<buf.length; i++) buf[i] = ' ';
        }

        catch(Exception e)
        {
            e.printStackTrace();//вызывается метод исключения е
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
