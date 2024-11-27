package com.example.demo3;

import javafx.fxml.FXML;

import java.io.IOException;

public class addDeviceController {

    //switch page

    @FXML
    private void addCancel() throws IOException {
        adGuiApplication.setRoot("home-page");
    }

    //button sets and transfers from buttons and textfields to data types for sql database injections to be added here
    // =)
    void createDevice() {

    }

}
