package com.kil.controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.kil.Logic;
import com.kil.components.*;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem itemNew;

    @FXML
    private MenuItem itemOpen;

    @FXML
    private MenuItem itemSave;

    @FXML
    private MenuItem itemSaveAs;

    @FXML
    private MenuItem itemExit;

    @FXML
    private MenuItem itemCopy;

    @FXML
    private MenuItem itemPast;

    @FXML
    private MenuItem itemDelete;

    @FXML
    private MenuItem itemReference;

    @FXML
    private MenuItem itemAbout;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button buttonNew;

    @FXML
    private Button buttonOpne;

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonCopy;

    @FXML
    private Button buttonPast;

    @FXML
    private Button buttonDelete;

    @FXML
    private Label labelTest;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button sizeMinusButton;

    @FXML
    private Slider sizeSlider;

    @FXML
    private Button sizePlusButton;

    @FXML
    private ListView<String> listTool;

    @FXML
    private ComboBox<String> selectLanguageBox;

    @FXML
    private TextArea outPutText;

    static ComBase base;

    @FXML
    void initialize() {
        //timer for cod generation
        outPutText.setEditable(false);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                List<String> listCod = base.getCod();
                String totalCod = "";
                for (String str : listCod) {
                    totalCod += str;
                }

                outPutText.setText(totalCod);
            }
        };
        timer.start();

        //fill all lists//
        fillLists();

        base = new ComBase(null);
        scrollPane.setContent(base);

        buttonDelete.setOnAction(actionEvent -> {
            if (Logic.currentCom != null)
                Logic.currentCom.delete();
        });

        buttonEdit.setOnAction(this::showDialog);
    }


    //show window for widget refactoring
    private void showDialog(javafx.event.ActionEvent actionEvent) {
        if (Logic.currentCom == null)
            return;

        Parent root = null;
        try {
            if (Logic.currentCom instanceof ComInPut || Logic.currentCom instanceof ComOutPut || Logic.currentCom instanceof ComFunc)
                root = FXMLLoader.load(getClass().getResource("/fxml/BasicCom.fxml"));
            else if(Logic.currentCom instanceof ComAction)
                root = FXMLLoader.load(getClass().getResource("/fxml/ComAction.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }


    //
    //
    //
    //fill lists and setup listener for them
    private void fillLists() {
        //for language
        ObservableList<String> listLanguage = FXCollections.observableArrayList("BASIC-256", "C", "C++", "Python");
        selectLanguageBox.setItems(listLanguage);
        selectLanguageBox.getSelectionModel().select(0);
        Logic.currentLanguage = selectLanguageBox.getSelectionModel().getSelectedItem();
        selectLanguageBox.getSelectionModel().selectedItemProperty()
                .addListener((observable -> Logic.currentLanguage = selectLanguageBox.getSelectionModel().getSelectedItem()));

        //for tools
        ObservableList<String> listTools = FXCollections.observableArrayList
                ("Ввод", "Вывод", "Процесс", "Присваивание",
                        "Если...то...иначе", "Цикл FOR", "Цикл с предусловием",
                        "Цикл с постусловием", "Цикл FOR (в стиле с/с++)");
        listTool.setItems(listTools);
        listTool.getSelectionModel().select(0);
        Logic.currentTool = listTool.getSelectionModel().getSelectedItem();
        listTool.getSelectionModel().selectedItemProperty()
                .addListener((observable) -> Logic.currentTool = listTool.getSelectionModel().getSelectedItem());
    }
}
