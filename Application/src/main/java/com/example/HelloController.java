package com.example.demo_do_hoa;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
//import edu.princeton.cs.algs4.StdAudio;
import javafx.scene.media.Media;

import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.scene.control.TextField;

public class HelloController  {
    @FXML
    private TextField tfinput;
    @FXML
    private TextArea tfout;
    @FXML
    private Button btgo;
    @FXML
    private Button btwordFix;
    @FXML
    private TextField tfadd;
    @FXML
    private TextArea tfmean;
    @FXML
    private Button btokadd;
    @FXML
    private Button btdel;
    @FXML
    private TextField tfdel;
    @FXML
    private TextField tffixword;
    @FXML
    private TextField tfaddspe;
    @FXML
    private TextArea tffixmean;
    @FXML
    private TextField tffixspe;
    @FXML
    private BorderPane pane;
    @FXML
    private TextArea taoutput;
    @FXML
    private Label labadd;
    @FXML
    private Label labfix;


    private Stage stage;
    private Scene scene;
    private Parent root;



    Dictionary dict = new Dictionary();
    @FXML
    public void exit() {
        javafx.application.Platform.exit();
    }
    @FXML
    public void listen() {
        String s = tfinput.getText();
        if(dict.listdict.containsKey(s)) {
            String bip = s + ".mp3";
            Media hit = new Media(new File(bip).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        }
    }
    @FXML
    public void Lookup() throws IOException {
        String word = tfinput.getText();
        String s = dict.lookWord(word);
        taoutput.setText(s);
    }



    @FXML
    public void switchToAdd(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("Add.fxml"));
        pane.setCenter(view);
    }
    @FXML
    public void switchTomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchTodel(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        pane.setCenter(view);
    }
    @FXML
    public void switchToFix(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("Fix.fxml"));
        pane.setCenter(view);
    }

    public void insert(ActionEvent event) throws IOException {
        String word = tfadd.getText();
        String wordspe = tfaddspe.getText();
        String wordE = tfmean.getText();
        dict.insertWord(word, wordspe);
        try {
            FileWriter fw = new FileWriter(new File(word + ".txt"));
            fw.write(wordE);
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
        labadd.setText("Từ đã được thêm");
        dict.saveToFile();
    }

    public void Delete() {
        String word  = tfinput.getText();
        dict.deleteWord(word);
        taoutput.setText("từ đã được xóa");
        dict.saveToFile();
    }

    public void Fix() {
       String word = tffixword.getText();
        if (Objects.equals(dict.lookWord(word), "ko có dữ liệu"))
            labfix.setText("Từ này không có trong từ điển");
            //tfout.setText("ko có");
        else {
            String spe = tffixspe.getText();
            String wordE = tffixmean.getText();
            dict.fixWord(word,spe,wordE);
            labfix.setText("Sửa từ thành công");
            dict.saveToFile();
        }
    }
}
