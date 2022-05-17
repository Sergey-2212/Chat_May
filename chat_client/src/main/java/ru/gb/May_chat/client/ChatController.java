package ru.gb.May_chat.client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    private Button btnClick;

    @FXML
    private Label labelText;

    @FXML
    private TextArea chatArea;

    @FXML
    private ListView<String> contacts;

    @FXML
    private TextField inputField;

    @FXML
    private Button btnSend;

    private String choosenContact = null;


    public void click(ActionEvent actionEvent) {
        System.out.println("Button clicked");
        labelText.setText("Hello JavaFX");
        btnClick.setText("Clicked");
        btnClick.setScaleX(2);
        btnClick.setScaleY(2);
    }

    @FXML
    public void mockAction(ActionEvent actionEvent) {
    }

    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        String text = inputField.getText();
        if (text == null || text.isBlank() || choosenContact == null) {
            return;
        }
        chatArea.appendText(choosenContact + text + System.lineSeparator());
        inputField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> contnames = List.of("Сorben Dallas", "Lilu Dallas", "Tuzick", "Broadcast");
        contacts.setItems(FXCollections.observableList(contnames));
        contacts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                choosenContact = contacts.getSelectionModel().getSelectedItem() + ": ";
                //inputField.setText(choosenContact + ": ");
            }
        });
    }
}
