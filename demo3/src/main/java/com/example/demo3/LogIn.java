package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class LogIn {

    @FXML
    private PasswordField inputPassword;
    @FXML
    private Label wwLabel;

    @FXML
    private void addCancel() throws IOException {
        adGuiApplication.setRoot("home-page");
    }

    private String password = "milan";

    @FXML
    public void vergelijk() throws IOException {
        String inputP = inputPassword.getText();
        if (password.equals(inputP)) {
            System.out.println("Acces granted.");
            adGuiApplication.setRoot("addDevice");
        }

        else
            wwLabel.setText("Wrong, please try again.");
    }

}
