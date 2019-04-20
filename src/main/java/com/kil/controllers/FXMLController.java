package com.kil.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kil.components.ComBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

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
    private Button sizeMinusButton;

    @FXML
    private Slider sizeSlider;

    @FXML
    private Button sizePlusButton;

    @FXML
    private ListView<String> listTool;

    @FXML
    private Pane holst;

    @FXML
    private ComboBox<String> selectLanguageBox;

    @FXML
    private TextArea outPutText;

    @FXML
    void initialize() {
        //fill all lists//
        fillLists();

        holst.setOnMouseClicked(e->{
            //Logic.currentPane.setStyle("-fx-background-color: #000000");
            //Logic.classicColor = (Color) holst.getBackground().getFills().get(0).getFill();
        });


        //for tests
//        Line line = new Line();
//        line.setStartX(10.0f);
//        line.setStartY(10.0f);
//        line.setEndX(300.0f);
//        line.setEndY(70.0f);
//        line.setStroke(Color.BLUE);
//        line.setStrokeWidth(5);
//        line.setStrokeLineCap(StrokeLineCap.ROUND);
//        holst.getChildren().add(line);

        ComBase first = new ComBase();
        holst.getChildren().add(first);

    }

    private void fillLists(){
        ObservableList<String> listLanguage = FXCollections.observableArrayList("Pascal", "C++", "Java", "Python");
        ObservableList<String> listTools = FXCollections.observableArrayList
                ("Выбор", "Ввод", "Вывод", "Процесс", "Присваивание",
                        "Если...то...иначе", "Цикл FOR", "Цикл с предусловием",
                        "Цикл с постусловием", "Цикл FOR (в стиле с/с++)");
        selectLanguageBox.setItems(listLanguage);
        listTool.setItems(listTools);
    }
}
