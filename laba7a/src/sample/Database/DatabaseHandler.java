package sample.Database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import sample.Shop.Shop;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public ObservableList<Shop> getProduct()
    {
        ResultSet resSet = null;
        String select = "SELECT *  FROM " + Const.LABA8_TABLE;
        String name;
        Date date;
        int id, cost, amount;
        ObservableList<Shop> res = FXCollections.observableArrayList();

        try
        {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();

            while (resSet.next())
            {
                date = resSet.getDate(Const.LABA8_DATE);
                name = resSet.getString(Const.LABA8_NAME);
                id = resSet.getInt(Const.LABA8_ID);
                cost = resSet.getInt(Const.LABA8_COST);
                amount = resSet.getInt(Const.LABA8_AMOUNT);
                res.add(new Shop(id, cost, amount, name, date.toLocalDate()));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText(throwables.getMessage());
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alert.setHeaderText(null);
            alert.setTitle("Ошибка");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return res;
    }

    public void WriteProduct(String name, String cost, String amount, String date)
    {

        String insert = "INSERT INTO " + Const.LABA8_TABLE + "(" + Const.LABA8_NAME + "," +
                Const.LABA8_COST + "," + Const.LABA8_AMOUNT + "," + Const.LABA8_DATE + ")" +
                "VALUES (?,?,?,?)";

        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Добавление выполнено успешно");

        try
        {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, cost);
            prSt.setString(3, amount);
            prSt.setString(4, date);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(throwables.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(e.getMessage());
        }
        alert.showAndWait();
    }

    public void ChangeProduct(String name, String cost, String amount, String date, int id)
    {
        String change = "UPDATE " + Const.LABA8_TABLE +
                " SET " + Const.LABA8_NAME +" = ?, "
                + Const.LABA8_AMOUNT +" = ?, "
                + Const.LABA8_DATE + " = ?, "
                + Const.LABA8_COST + " = ? "
                +  " WHERE " + Const.LABA8_ID + " = ?";
        try
        {
            PreparedStatement prSt = getDbConnection().prepareStatement(change);
            prSt.setString(1, name);
            prSt.setString(2, amount);
            prSt.setString(3, date);
            prSt.setString(4, cost);
            prSt.setInt(5, id);
            prSt.executeUpdate();

            alert.setTitle("Информация");
            alert.setHeaderText(null);
            alert.setContentText("Обновление выполнено успешно");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(throwables.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(e.getMessage());
        }

        alert.showAndWait();
    }

    public void DeleteProduct(String id) {
        String delete = "DELETE FROM  " + Const.LABA8_TABLE + " WHERE " + Const.LABA8_ID +
                " = " + id;
        try
        {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
            alert.setTitle("Информация");
            alert.setHeaderText(null);
            alert.setContentText("Удаление выполнено успешно");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(throwables.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(e.getMessage());
        }
            alert.showAndWait();
    }

};