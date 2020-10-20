package application.controller;

import application.Main;
import code.DictionaryManagement;
import code.Word;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static application.controller.NotiWindow.openAlertWindow;

public class EditController implements Initializable{

    @FXML
    public Button btnCancel;

    @FXML
    public Button btnConfirm;

    @FXML
    public TextArea taEnglish;

    @FXML
    public TextArea taVietnamese;

    @FXML
    public Label oldWord;

    MainController application = new MainController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public EditController() {

    }

    public void setWordEdit(Word edit) {
        taEnglish.setText(edit.getWordTarget());
        taVietnamese.setText(edit.getWordExplain());
        oldWord.setText(edit.getWordTarget());
    }

    public void handleConfirmBtn(ActionEvent actionEvent) throws IOException {

        String wordTarget = taEnglish.getText();
        String wordExplain = taVietnamese.getText();

        if (wordTarget == null || wordExplain == null || wordTarget.equals("") || wordExplain.equals("")) {
            System.out.println("Edit Error!");
            openAlertWindow("Edit Error!");
        } else {
            DictionaryManagement.deleteWords(Main.mainDictionary, oldWord.getText());
            DictionaryManagement.addWords(Main.mainDictionary, wordTarget.toLowerCase(), wordExplain);
            DictionaryManagement.sortWords(Main.mainDictionary);
            System.out.println("Edit Successfully!");
            openAlertWindow("Edit " + oldWord.getText() + " Successfully!");
            DictionaryManagement.dictionaryExportToFile(Main.mainDictionary, "English-Vietnamese");
            goBack(actionEvent);
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/MainScene.fxml"));
        Parent mainParent = loader.load();
        Scene scene = new Scene(mainParent);
        stage.setScene(scene);
    }



}
