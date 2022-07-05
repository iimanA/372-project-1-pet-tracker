package project2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    }

    @FXML
    void onSearchAnimalClick(ActionEvent event) {
        lbAnimalInfo.setText(tfAnimalId.getText());
    }

    @FXML
    void onExportJSONClick(ActionEvent event) {
        lbResult.setText(tfShelterId.getText());
    }

    @FXML
    void onExportXMLClick(ActionEvent event) {
        lbResult.setText(tfShelterId.getText());
    }

}
