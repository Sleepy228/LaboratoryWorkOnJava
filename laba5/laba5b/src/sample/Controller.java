package  sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.nio.file.*;


public class Controller {

    @FXML
    private Button button;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton radioMan;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton radioWoman;

    @FXML
    private Label tName;

    @FXML
    private TextField editName;

    @FXML
    private Label tFname;

    @FXML
    private Label tPol;

    @FXML
    private Label tStatus;

    @FXML
    private TextField editFname;

    @FXML
    private Label tName12;

    @FXML
    private Label tAbout;

    @FXML
    private TextArea eAbout;

    @FXML
    void clickButton(ActionEvent event)
    {
        String radioText;

        if (editName.getText().equals("") || editFname.getText().equals("") || eAbout.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Введены не все данные");

            alert.showAndWait();
            return;
        }

        if (radioMan.isSelected()) radioText = radioMan.getText();
        else  radioText = radioWoman.getText();

        File file = new File("D:\\java\\laba5\\laba5b\\src\\sample\\data.txt");

        StringBuilder sb = new StringBuilder();

        file.exists();

        try {
            if(!file.exists()){
                file.createNewFile();
            }
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                if (sb.toString().equals(""))
                out.print("Фамилия: " + editFname.getText() + " Имя: " + editName.getText() + " Семейное положение: "
                +  comboBox.getValue() + " Пол: " + radioText + " О себе: " + eAbout.getText());
                else out.print(sb.toString()  + "Фамилия: " + editFname.getText() + " Имя: " + editName.getText() + " Семейное положение: "
                            +  comboBox.getValue() + " Пол: " + radioText + " О себе: " + eAbout.getText());
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void clickCombobox(ActionEvent event)
    {

    }

}
