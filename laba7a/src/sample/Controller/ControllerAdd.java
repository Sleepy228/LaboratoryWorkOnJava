package sample.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.Shop.Shop;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class ControllerAdd {

    private static boolean flag;
    private static Shop shop;

    @FXML
    private Button send;

    @FXML
    private DatePicker eDate;

    @FXML
    private TextField eName;

    @FXML
    private TextField eAmount;

    @FXML
    private TextField eCost;


    @FXML
    private Label labelAdd;

    @FXML
    void initialize()
    {
        if(flag)
        {
            labelAdd.setText("Изменение записей");
            send.setText("Изменить");
            eAmount.setText(Integer.toString(shop.getAmount()));
            eCost.setText(Integer.toString(shop.getCost()));
            eDate.setValue(shop.getDate());
            eName.setText(shop.getName());
        }
        else
        {
            labelAdd.setText("Добавление записей");
            send.setText("Добавить");
        }
    }

    @FXML
    void clickSend(ActionEvent event)
    {
        DatabaseHandler dbHandler = new DatabaseHandler();

        if(!flag)
        {
            dbHandler.WriteProduct(eName.getText(), eCost.getText(), eAmount.getText(), eDate.getValue().toString());
        }
        else
        {
            dbHandler.ChangeProduct(eName.getText(), eCost.getText(), eAmount.getText(), eDate.getValue().toString(), shop.getId());
        }
    }


    void SetFlag(boolean flagreq)
    {
        flag = flagreq;
    }

    void SetShop(Shop shopbuuf)
    {
        shop = shopbuuf;
    }
}




