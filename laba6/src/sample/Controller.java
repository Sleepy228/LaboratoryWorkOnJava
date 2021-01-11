package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Controller {
    private Boolean flag = true;
    private double snowx1, snowx2, snowx3, snowx4, snowx5, snowx6, snowx7, snowy1, snowy2, snowy3, snowy4, snowy5, snowy6, snowy7,
    cloudx, cloudWidth;
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @FXML
    private ImageView snow4;

    @FXML
    private ImageView snow3;

    @FXML
    private ImageView snow6;

    @FXML
    private ImageView snow5;

    @FXML
    private ImageView snow7;

    @FXML
    private ImageView snow2;

    @FXML
    private ImageView snow1;

    @FXML
    private ImageView snowdrift;

    @FXML
    private ImageView cloud;

    @FXML
    private Button bstart;

    @FXML
    private Button bstop;

    @FXML
    private ImageView sun;

    private void StartSnow() {
        if (snow1.getLayoutY() > 390)
        {
            if (!snow7.isVisible())
                {
                    snow2.setVisible(false);
                    snow6.setVisible(false);
                }

                snow1.setLayoutX(snowx1);
                snow1.setLayoutY(snowy1);
                snow2.setLayoutX(snowx2);
                snow2.setLayoutY(snowy2);
                snow3.setLayoutX(snowx3);
                snow3.setLayoutY(snowy3);
                snow4.setLayoutX(snowx4);
                snow4.setLayoutY(snowy4);
                snow5.setLayoutX(snowx5);
                snow5.setLayoutY(snowy5);
                snow6.setLayoutX(snowx6);
                snow6.setLayoutY(snowy6);
                snow7.setLayoutX(snowx7);
                snow7.setLayoutY(snowy7);
                snow1.setVisible(false);
                snow7.setVisible(false);
            }

            snow1.setLayoutX(snow1.getLayoutX() + getRandomNumber(-20, 20));
            snow1.setLayoutY(snow1.getLayoutY() + 10);
            snow2.setLayoutX(snow2.getLayoutX() + getRandomNumber(-20, 20));
            snow2.setLayoutY(snow2.getLayoutY() + 10);
            snow3.setLayoutX(snow3.getLayoutX() + getRandomNumber(-20, 20));
            snow3.setLayoutY(snow3.getLayoutY() + 10);
            snow4.setLayoutX(snow4.getLayoutX() + getRandomNumber(-20, 20));
            snow4.setLayoutY(snow4.getLayoutY() + 10);
            snow5.setLayoutX(snow5.getLayoutX() + getRandomNumber(-20, 20));
            snow5.setLayoutY(snow5.getLayoutY() + 10);
            snow6.setLayoutX(snow6.getLayoutX() + getRandomNumber(-20, 20));
            snow6.setLayoutY(snow6.getLayoutY() + 10);
            snow7.setLayoutX(snow7.getLayoutX() + getRandomNumber(-20, 20));
            snow7.setLayoutY(snow7.getLayoutY() + 10);
        }

    void setStarValue ()
    {
                snowx1 = snow1.getLayoutX(); snowy1 = snow1.getLayoutY();
                snowx2 = snow2.getLayoutX(); snowy2 = snow2.getLayoutY();
                snowx3 = snow3.getLayoutX(); snowy3 = snow3.getLayoutY();
                snowx4 = snow4.getLayoutX(); snowy4 = snow4.getLayoutY();
                snowx5 = snow5.getLayoutX(); snowy5 = snow5.getLayoutY();
                snowx6 = snow6.getLayoutX(); snowy6 = snow6.getLayoutY();
                snowx7 = snow7.getLayoutX(); snowy7 = snow7.getLayoutY();
                cloudWidth = cloud.getFitWidth(); cloudx = cloud.getLayoutX();
    }

    private void StartCloud()
    {
        if(cloud.getFitWidth() <30)
        {
            cloud.setVisible(false);
            bstop.setDisable(true);
            flag = false;
            snow1.setVisible(false);
            snow2.setVisible(false);
            snow3.setVisible(false);
            snow4.setVisible(false);
            snow5.setVisible(false);
            snow6.setVisible(false);
            snow7.setVisible(false);
            sun.setVisible(true);
            return;
        }
     cloud.setFitWidth(cloud.getFitWidth()-10);
     cloud.setLayoutX(cloud.getLayoutX()+10);
     cloud.setFitWidth(cloud.getFitWidth()-10);
    }

    private void StartSnowDrift()
    {
        snowdrift.setFitHeight(snowdrift.getFitHeight()+10);
        snowdrift.setLayoutY(snowdrift.getLayoutY()-10);
    }


    @FXML
    void clickStart(ActionEvent event)
    {
        if(snowx1 == 0) setStarValue();
        flag = true;
        bstart.setDisable(true);
        bstop.setDisable(false);
        bstart.setText("Продолжить");
        snow1.setVisible(true);
        snow2.setVisible(true);
        snow3.setVisible(true);
        snow4.setVisible(true);
        snow5.setVisible(true);
        snow6.setVisible(true);
        snow7.setVisible(true);

        Thread snow = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        StartSnow();
                    }
                };

                while (flag) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                    }
                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown

        Thread tcloud = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        StartCloud();
                    }
                };

                while (flag) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });

        Thread snowdrift = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        StartSnowDrift();
                    }
                };

                while (flag) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });

        snow.setDaemon(true);
        snow.start();

        tcloud.setDaemon(true);
        tcloud.start();

        snowdrift.setDaemon(true);
        snowdrift.start();
    }

    @FXML
    void clickStop(ActionEvent event)
    {
        flag = false;
        bstart.setDisable(false);
        bstop.setDisable(true);
    }

}
