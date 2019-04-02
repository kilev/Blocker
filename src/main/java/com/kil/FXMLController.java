package com.kil;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.input.InputMethodEvent;
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
    private MenuItem itemUndo;

    @FXML
    private MenuItem itemRedo;

    @FXML
    private MenuItem itemCut;

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
    private Button buttonUndo;

    @FXML
    private Button buttonRedo;

    @FXML
    private Button buttonCut;

    @FXML
    private Button buttonCopy;

    @FXML
    private Button buttonPast;

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

        //load language and tools lists
        ObservableList<String> listLanguage = FXCollections.observableArrayList("Pascal", "C++", "Java", "Python");
        ObservableList<String> listTools = FXCollections.observableArrayList("select", "zikl", "eshe zikl", "and eshe");
        selectLanguageBox.setItems(listLanguage);
        listTool.setItems(listTools);
        //load language and tools lists


        selectLanguageBox.setOnAction(event-> {
            labelTest.setText("test successful");
        });
    }
}
