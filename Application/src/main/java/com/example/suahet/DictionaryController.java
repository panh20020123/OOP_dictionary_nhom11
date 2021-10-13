package com.example.suahet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class DictionaryController {
    @FXML
    private TextField tfinput;
    @FXML
    private TextArea tfout;
//    @FXML
//    private Button btgo;
    @FXML
    private Button btwordFix;
    @FXML
    private TextField tfadd;
    @FXML
    private TextField tfmean;
//    @FXML
//    private Button btokadd;
//    @FXML
//    private Button btdel;
    @FXML
    private TextField tfdel;

    @FXML
    private TextField tffixword;
    @FXML
    private TextField tffixmean;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Dictionary dict = new Dictionary();

    public void dictionaryLookup(ActionEvent event) throws IOException {

        String word = tfinput.getText();
        String s = dict.lookWord(word);
        tfout.setText(s);

    }

    public void switchToAdd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchTodel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFix(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Fix.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void insertFromCommandLine(ActionEvent event) throws IOException {
        String word = tfadd.getText();
        String wordE = tfmean.getText();
        dict.insertWord(word, wordE);
        dict.saveToFile();
    }

    public void wordDelete() {
        String word = tfdel.getText();
        dict.deleteWord(word);
        dict.saveToFile();
    }

    public void wordFix() {
        String word = tffixword.getText();
        if (dict.lookWord(word) == null)
            System.out.println("Khong co du lieu ");
        else {
            String wordE = tffixmean.getText();
            dict.fixWord(word, wordE);
            dict.saveToFile();
        }
    }
}