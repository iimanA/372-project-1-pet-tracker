package project2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project2.domain.Animal;
import project2.domain.PetCompany;
import project2.domain.Data;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    private Label lbAnimalInfo;

    @FXML
    private TextField tfAnimalId;

    @FXML
    private TextField tfShelterId;

    @FXML
    private Label lbResult;

    @FXML
    void onAddAnimalClick(ActionEvent event) {
        fxmlLoader = new FXMLLoader(getClass().getResource("/project2/ui/add-animal-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onGetInfoClick(ActionEvent event) {
        Data.text = tfShelterId.getText();
        fxmlLoader = new FXMLLoader(getClass().getResource("/project2/ui/shelter-info-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSearchAnimalClick(ActionEvent event) {
        PetCompany petCompany = new PetCompany();
        Animal animal = petCompany.getAnimalInfo(tfAnimalId.getText());
        if (animal == null) {
            lbAnimalInfo.setText("Invalid animal ID");
        } else {
            String animalInfo = String.format("Animal name: %s\nAnimal id: %s\n, Shelter id: %s\n, Animal type: %s\n",
                    animal.getName(), animal.getAnimalId(), animal.getShelterId(), animal.getAnimalType());
        }
    }

    @FXML
    void onExportJSONClick(ActionEvent event) {
        PetCompany petCompany = new PetCompany();
        int result = petCompany.exportAnimalList(tfShelterId.getText(), "JSON");
        if (result == -1) {
            lbResult.setText("Export Error, please check your shelter ID");
        } else {
            lbResult.setText("Export Succeed");
        }
    }

    @FXML
    void onExportXMLClick(ActionEvent event) {
        PetCompany petCompany = new PetCompany();
        int result = petCompany.exportAnimalList(tfShelterId.getText(), "XML");
        if (result == -1) {
            lbResult.setText("Export Error, please check your shelter ID");
        } else {
            lbResult.setText("Export Succeed");
        }
    }
}
