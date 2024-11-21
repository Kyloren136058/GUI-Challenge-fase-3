package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label ClickMeLabel;

    @FXML
    private Label locatieId;

    @FXML
    private Label sensor1;

    @FXML
    private Label sensor2;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onClickFirstBtn() {
        ClickMeLabel.setText("Zuid Holland");
    }

    @FXML
    protected void onClickSecondBtn () {
        ClickMeLabel.setText("Noord Holland");
    }
    @FXML
    protected void onClickThirdBtn () {
        ClickMeLabel.setText("Brabant");
    }

    @FXML
    protected void onClickFourthBtn () {
        ClickMeLabel.setText("Zeeland");
    }

}