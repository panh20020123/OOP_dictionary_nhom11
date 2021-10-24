package com.example.demo_do_hoa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.TextFields;
import javafx.scene.media.Media;


import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.scene.control.TextField;

public class HelloController implements Initializable{
    @FXML
    private TextField tfinput;
    @FXML
    private TextField tfadd;
    @FXML
    private TextArea tfmean;
    @FXML
    private TextField tfaddspe;
    @FXML
    private BorderPane pane;
    @FXML
    private TextArea taoutput;
    @FXML
    private Label labadd;
    @FXML
    private TextArea tainput_sentence;
    @FXML
    private TextArea taoutput_sentence;
    @FXML
    private Button btnfix;
    @FXML
    private Button btnListen;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String link = "C:\\Users\\admin\\Downloads\\textwords\\textwords\\";
    Dictionary dict = new Dictionary();


    @FXML
    void Translate_sentence(ActionEvent event) {

        String input = tainput_sentence.getText();
        try {
            String translated = GoogleTranslator.translate("", "vi", input);
            taoutput_sentence.setText(translated);
        } catch (IOException e) {
            System.out.println("");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            int n = dict.listdict.size();
            String [] llist = new String[n];

            String s = tfinput.getText();
            Set<String> keySet = dict.listdict.keySet();
            int j = 0;
            for (String key : keySet) {

                llist[j++] = key;
                if (j == n) {
                    break;
                }
            }

            TextFields.bindAutoCompletion(tfinput, t -> {
                        return Arrays.asList(llist).stream().filter(
                                elem -> {
                                    return (elem).toLowerCase().startsWith(tfinput.getText().toLowerCase());
                                }
                        ).collect(Collectors.toList());
                    }
            ).setVisibleRowCount(5);
        } catch (Exception e) {
        }
    }

    @FXML
    public void exit() {
        javafx.application.Platform.exit();
    }

    @FXML
    public void listen() {
        String s = tfinput.getText();

        if(dict.listdict.containsKey(s)) {
            if (dict.listdict.get(s).getAudioLink() != null) {
                btnListen.setVisible(true);
                Media sound = new Media("https:" + dict.listdict.get(s).getAudioLink());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            } else {
                btnListen.setVisible(false);
            }

        }
    }



    @FXML
    void SwitchSentence(ActionEvent event) throws IOException{
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sentence.fxml")));
        pane.setCenter(view);
    }
    @FXML
    public void Lookup(ActionEvent event) throws IOException {
        String word = tfinput.getText();
        String s = dict.lookWord(word);
        taoutput.setText(s);
    }

    @FXML
    public void switchToAdd(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Add.fxml")));
        pane.setCenter(view);
    }
    @FXML
    public void switchTomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void insert(ActionEvent event) throws IOException {
        String word = tfadd.getText();
        String wordE = tfmean.getText();
        String wordS = tfaddspe.getText();
        if (word != "" && wordE != "" && wordS != "" && !dict.listdict.containsKey(word)) {
            dict.insertWord(word);

            try {
                FileWriter fw = new FileWriter(new File(link + word + ".txt"));
                fw.write(wordS + '\n' + wordE);
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi ghi file: " + ex);
            }
            labadd.setText("Thêm từ thành công");
            dict.saveToFile();
        }
        else {
            labadd.setText("Lỗi thêm từ");
        }
    }

    public void Delete() {
        String word  = tfinput.getText();
        dict.deleteWord(word);
        taoutput.setText("từ đã được xóa");
        dict.saveToFile();
    }

    private boolean edit = false;
    public void Fix(ActionEvent event) throws IOException {
        if (!edit) {
            btnfix.setText("Save");
            taoutput.setEditable(true);
            edit = !edit;

        }
        else {
            btnfix.setText("Fix");
            taoutput.setEditable(false);
            edit = !edit;
            try {
                FileWriter fw = new FileWriter(new File(link + tfinput.getText() + ".txt"));
                fw.write(taoutput.getText());
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi ghi file: " + ex);
            }
            taoutput.setText("Từ đã được sửa");
        }
    }
}
