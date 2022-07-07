package project2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project2.domain.Animal;
import project2.domain.Data;
import project2.domain.PetCompany;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ShelterInfoController implements Initializable {
    @FXML
    private Label lbInTaking;
    @FXML
    private Label lbShelterIInfo;
    @FXML
    private TableView<Animal> tvAnimal;
    @FXML
    private TableColumn<Animal, String> animalId;
    @FXML
    private TableColumn<Animal, String> animalType;
    @FXML
    private TableColumn<Animal, String> name;
    @FXML
    private TableColumn<Animal, Date> receiptDate;
    @FXML
    private TableColumn<Animal, Float> weight;
    @FXML
    private ToggleButton tbInTaking;


    @FXML
    void onInTakingButton(ActionEvent event) {
        PetCompany petCompany = new PetCompany();
        if (tbInTaking.isSelected()) {
            lbInTaking.setText("In taking: Enabled");
//            petCompany.enableReceivingAnimal(???);
        } else {
            lbInTaking.setText("In taking: Disabled");
        }
    }

    @FXML
    void onBackClick(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project2/ui/main-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbShelterIInfo.setText("Shelter" + Data.text);
        lbInTaking.setText("In Taking: Enable");
        tbInTaking.setSelected(true);
        initCell();
        ArrayList <Animal> animalList = new ArrayList<>();
        Date date = new Date(15153);
        Float the_weight = Float.parseFloat("2.0");
        Animal animal1 = new Animal ("Hihi super long long long name to see if it work", "123",the_weight, "123", "cat", date );
        Animal animal2 = new Animal ("Haha", "124",the_weight, "123", "cat", date );
        animalList.add (animal1);
        animalList.add (animal2);
        ObservableList <Animal> list = FXCollections.observableList(animalList);
        tvAnimal.setItems(list);
    }

    private void initCell () {
        name.setCellFactory(tc -> {
            TableCell<Animal, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(name.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell ;
        });
        name.setCellValueFactory(new PropertyValueFactory<Animal, String>("name"));
        animalId.setCellValueFactory(new PropertyValueFactory<Animal, String>("animalId"));
        animalType.setCellValueFactory(new PropertyValueFactory<Animal, String>("animalType"));
        receiptDate.setCellValueFactory(new PropertyValueFactory<Animal, Date>("receiptDate"));
        weight.setCellValueFactory(new PropertyValueFactory<Animal, Float>("weight"));
    }
}
