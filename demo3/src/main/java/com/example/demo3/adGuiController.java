package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.jfr.Period;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class adGuiController implements Initializable {
    //initialize fxml "fx:id's" to the tableview and columns.
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

    @FXML
    private Label welcomeText;

    @FXML
    public PasswordField inputPassword;


    //check Password string. ---
    @FXML
    public void vergelijk() {
        String inputP = inputPassword.getText();
        String password = "milan";
        if (password.equals(inputP))
            System.out.println("Correct!");

        else
            System.out.println("Wrong, please try again.");

    }

    @FXML
    public void logInPage() throws IOException {
        adGuiApplication.setRoot("logIn");
    }


    //search bar
    @FXML
    public TextField searchBar;

    //search btn
    public void searchBtn() {
        //user input uit de search bar
        String inputText = searchBar.getText().toLowerCase();

        //filter lijst gebasseerd op locatie
        ObservableList<adApparaat> filteredList = FXCollections.observableArrayList();
        for (adApparaat apparaat : list) {
            if (apparaat.getLocatie().toLowerCase().contains(inputText)) {
                filteredList.add(apparaat);
            }
        }

        // Update the TableView with the filtered list
        adTafel.setItems(filteredList);
    }

    Random random = new Random();
    Date date = new Date();

    //setting the device rows "at some point with database convertion"
    adApparaat sqlRow1 = new adApparaat(1, "2024-25-11", "zoetermeer", "ergens", 128.94, false, 0);
    adApparaat sqlRow2 = new adApparaat(2, "2024-25-11", "zoetermeer", "ergens2", 29.34, false, 0);
    adApparaat sqlRow3 = new adApparaat(3, "2024-25-11", "zoetermeer", "ergens3", 0.00, false, 0);
    adApparaat sqlRow4 = new adApparaat(4, "2024-26-11", "zoetermeer", "ergens4", 394.32, true, 0);
    adApparaat sqlRow5 = new adApparaat(5, "2024-26-11", "zoetermeer", "ergens5", 65.20, false, 0);
    adApparaat sqlRow6 = new adApparaat(6, "2024-29-11", "zoetermeer", "ergens", 23.0, false, 0);
    adApparaat sqlRow7 = new adApparaat(7, "2024-28-11", "den haag", "12345", 483.21, true,0);
    adApparaat sqlRow8 = new adApparaat(8, "2024-27-11", "zoetermeer", "okedos3", 329.30, false, 0);
    adApparaat sqlRow9 = new adApparaat(9, "2024-26-11", "zoetermeer", "ergens4", 80.23, false, 0);
    adApparaat sqlRow10 = new adApparaat(10, "2025-17-02", "thuis", "welcome to dreamland", 420.69, true, 0);

    //observablearraylist with objects as rows for tableview
    @FXML
    ObservableList<adApparaat> list = FXCollections.observableArrayList(
            sqlRow1,sqlRow2,sqlRow3,sqlRow4,sqlRow5,sqlRow6,sqlRow7,sqlRow8, sqlRow9, sqlRow10
    );

    @FXML
    ObservableList<adApparaat> returnList(){
        return this.list;
    }

    //addDevice connect to #adminButton > goes to addDevice page
    @FXML
    private void addDevice() throws IOException {
        adGuiApplication.setRoot("addDevice");
    }

    //button add row implemenation with random nr and current date generators
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

    @FXML
    private Label ClickMeLabel;

    @FXML
    private Label ClickMeLabel2;

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
        ClickMeLabel2.setText("Noord Holland");
    }
    @FXML
    protected void onClickThirdBtn () {
        ClickMeLabel.setText("Brabant");
    }

    @FXML
    protected void onClickFourthBtn () {
        ClickMeLabel.setText("Zeeland");
    }

    //any java initializations implemented right below
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeTableCells();
        adApparaat appaTest = new adApparaat(99,"2024TEST", "T", "", 20.2, false, 0);
        list.add(appaTest);
        adTafel.setItems(list);
    }
}