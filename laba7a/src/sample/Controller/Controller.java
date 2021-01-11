package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import sample.Database.Const;
import sample.Database.DatabaseHandler;
import sample.Shop.Shop;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

public class Controller {
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private TableView<Shop> tableView;

    @FXML
    private TableColumn<Shop, Integer> cid;

    @FXML
    private TableColumn<Shop, String> cname;

    @FXML
    private TableColumn<Shop, Integer> camount;

    @FXML
    private TableColumn<Shop, Integer> ccost;

    @FXML
    private TableColumn<Shop, LocalDate> cyear;

    @FXML
    private Button send;

    @FXML
    private Button delete;

    @FXML
    private Button change;

    @FXML
    private Button download;

    
    @FXML
    void clcikChange(ActionEvent event)
    {

        try
        {
            Shop shop= tableView.getSelectionModel().getSelectedItem();
            Integer.toString(shop.getId());
            ControllerAdd controllermain = loaderSet("/sample/View/sampleAdd.fxml").getController(); //получаем контроллер для второй формы
            controllermain.SetFlag(true);
            controllermain.SetShop(shop);
        }
        catch (Exception e)
        {
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Никакое поле не выбрано для изменения");
            alert.showAndWait();
            return;
        }

        send.getScene().getWindow().hide();

        Parent root = loaderSet("/sample/View/sampleAdd.fxml").getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
        stage.setScene(send.getScene());
        stage.show();
        clickDownload(event);
    }

    @FXML
    void clickDelete(ActionEvent event)
    {
            DatabaseHandler dbHandler = new DatabaseHandler();
            try {
                Shop shop = tableView.getSelectionModel().getSelectedItem();
                dbHandler.DeleteProduct(Integer.toString(shop.getId()));
            }
            catch (Exception e)
            {
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Никакое поле не выбрано для удаления");
                alert.showAndWait();
                return;
            }
            clickDownload(event);
    }

    @FXML
    void clickDownload(ActionEvent event)
    {

        ObservableList<Shop> resSet;
        DatabaseHandler dbHandler = new DatabaseHandler();
        resSet = FXCollections.observableArrayList(dbHandler.getProduct());

        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        camount.setCellValueFactory(new PropertyValueFactory<>(Const.LABA8_AMOUNT));
        ccost.setCellValueFactory(new PropertyValueFactory<>(Const.LABA8_COST));
        cname.setCellValueFactory(new PropertyValueFactory<>(Const.LABA8_NAME));
        cyear.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(resSet);

        tableView.setEditable(true);

        send.setDisable(false);
        delete.setDisable(false);
        change.setDisable(false);
    }

    @FXML
    void clickSend(ActionEvent event)
    {
        send.getScene().getWindow().hide();

        ControllerAdd controllermain = loaderSet("/sample/View/sampleAdd.fxml").getController(); //получаем контроллер для второй формы
        controllermain.SetFlag(false);

        Parent root = loaderSet("/sample/View/sampleAdd.fxml").getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
        stage.setScene(send.getScene());
        stage.show();
        clickDownload(event);
    }

    FXMLLoader loaderSet(String path)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try
        { loader.load(); } catch (IOException e)
        {
            e.printStackTrace();
        }
        return loader;
    }
}
