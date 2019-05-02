package com.kil.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.kil.Logic;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ComActionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldVar;

    @FXML
    private TextField textFieldValue;

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonCancel;

    @FXML
    void initialize() {
        String text = (String) Logic.currentCom.getAlternativeText().get(0);
        text = text.replace(" ", "");
        String[] par = text.split("=");

        textFieldVar.setText(par[0]);
        textFieldValue.setText(par[1]);

        buttonCancel.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonSave.getScene().getWindow();
            stage.close();
        });

        buttonSave.setOnAction(actionEvent -> {
            String result = textFieldVar.getText() + " = " + textFieldValue.getText();
            List<String> list = new ArrayList<>();
            list.add(result);
            Logic.currentCom.setAlternativeText(list);

            Logic.currentCom.recombine();

            Stage stage = (Stage) buttonSave.getScene().getWindow();
            stage.close();
        });
    }
}
