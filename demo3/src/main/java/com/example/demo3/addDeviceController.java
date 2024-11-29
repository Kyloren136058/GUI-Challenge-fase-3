package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.lang.annotation.Target;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Date;
import java.util.random.RandomGenerator;

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

    @FXML
    public TableView<adApparaat> adTafel;
    @FXML
    public TableColumn<adApparaat, Integer> adID;
    @FXML
    public TableColumn<adApparaat, String> installD;
    @FXML
    public TableColumn<adApparaat, String> locatie;
    @FXML
    public TableColumn<adApparaat, String> beschrijving;
    @FXML
    public TableColumn<adApparaat, Double> stofWaarde;
    @FXML
    public TableColumn<adApparaat, Boolean> gps;
    @FXML
    public TableColumn<adApparaat, Integer> gpsId;



    Random random = new Random();
    Date date = new Date();

    @FXML
    adGuiController gui = new adGuiController();

    @FXML
    ObservableList<adApparaat> list = FXCollections.observableArrayList();

    @FXML
    public void obvList() {
        list = gui.returnList();
    }




    @FXML
    public void addRow() {

        makeTableCells();
        date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String strDate = dateFormat.format(date);
        int number = random.nextInt(999999);
        double ppm = random.nextDouble(1000.0);

        adApparaat nieuwApp = new adApparaat(number,strDate, "home", "kamer", ppm, false, 0);
        list.add(nieuwApp);
        adTafel.setItems(list);
    }


    //assure new table cells are applied with data types for new row(s)
    @FXML
    void makeTableCells() {

        adID.setCellValueFactory(new PropertyValueFactory<adApparaat, Integer>("adID"));
        installD.setCellValueFactory(new PropertyValueFactory<adApparaat, String>("installD"));
        locatie.setCellValueFactory(new PropertyValueFactory<adApparaat, String>("locatie"));
        beschrijving.setCellValueFactory(new PropertyValueFactory<adApparaat, String>("beschrijving"));
        stofWaarde.setCellValueFactory(new PropertyValueFactory<adApparaat, Double>("stofWaarde"));
        gps.setCellValueFactory(new PropertyValueFactory<adApparaat, Boolean>("gps"));
        gpsId.setCellValueFactory(new PropertyValueFactory<adApparaat, Integer>("gpsId"));
    }
}
