package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private double number1 = 0;
           double number2 = 0;
            String number3 = "";
           double operation = 0;
           boolean flag = false;

    @FXML
    private TextField editField;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonFave;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonDivision;

    @FXML
    private Button buttonZero;

    @FXML
    private Button buttonEqually;

    @FXML
    private Button buttonMs;

    @FXML
    private Button buttonMultiplication;

    @FXML
    void  clickZero(ActionEvent event)
    {
        editField.appendText("0");
        flag = false;
    }

    @FXML
    void  clickOne(ActionEvent event)
    {
        editField.appendText("1");
        flag = false;
    }

    @FXML
    void  clickTwo(ActionEvent event)
    {
        editField.appendText("2");
    }

    @FXML
    void  clickThree(ActionEvent event)
    {
        editField.appendText("3");
        flag = false;
    }

    @FXML
    void  clickFour(ActionEvent event)
    {
        editField.appendText("4");
        flag = false;
    }

    @FXML
    void  clickFave(ActionEvent event)
    {
        editField.appendText("5");
        flag = false;
    }

    @FXML
    void  clickSix(ActionEvent event)
    {
        editField.appendText("6");
        flag = false;
    }

    @FXML
    void  clickSeven(ActionEvent event)
    {
        editField.appendText("7");
        flag = false;
    }

    @FXML
    void  clickEight(ActionEvent event)
    {
        editField.appendText("8");
        flag = false;
    }

    @FXML
    void  clickNine(ActionEvent event)
    {
        editField.appendText("9");
        flag = false;
    }

    @FXML
    void  clickPlus(ActionEvent event)
    {
        if (editField.getText().equals("")) return;

        number1 = Double.parseDouble(editField.getText());
        operation = 1;
        flag = false;

        editField.clear();
    }

    @FXML
    void  clickMinus(ActionEvent event)
    {
        if (editField.getText().equals("")) return;

        flag = false;
        number1 = Double.parseDouble(editField.getText());
        operation = 2;

        editField.clear();
    }

    @FXML
    void  clickMultiplication(ActionEvent event)
    {
        if (editField.getText().equals("")) return;

        flag = false;
        number1 = Double.parseDouble(editField.getText());
        operation = 3;

        editField.clear();
    }

    @FXML
    void  clickDivision(ActionEvent event)
    {
        if (editField.getText().equals("")) return;

        flag = false;
        number1 = Double.parseDouble(editField.getText());
        operation = 4;
        editField.clear();
    }

    @FXML
    void  clickEqually(ActionEvent event) {

        if (editField.getText().equals("")) return;

        if (flag == true)
            number1 = Double.parseDouble(editField.getText());
        else number2 = Double.parseDouble(editField.getText());


        editField.clear();
        flag = true;

        if (operation == 1) editField.appendText(Double.toString(number1 + number2));
        if (operation == 2) editField.appendText(Double.toString(number1 - number2));
        if (operation == 3) editField.appendText(Double.toString(number1 * number2));
        if (operation == 4) editField.appendText(Double.toString(number1 / number2));
    }

    @FXML
    void  clickMs(ActionEvent event)
    {
        flag = false;

        if(buttonMs.getText().equals("MS"))
        {
            number3 = editField.getText();
            buttonMs.setText("MR");
        }
        else
        {
            editField.clear();
            editField.appendText(number3);
            buttonMs.setText("MS");
        }

    }
}




