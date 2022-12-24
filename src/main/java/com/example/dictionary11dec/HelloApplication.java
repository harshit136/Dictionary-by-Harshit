package com.example.dictionary11dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



import java.io.IOException;

public class HelloApplication extends Application {

    Label meaningLabel;
    Button searchButton;
    TextField wordTextField;

    DictionaryUsingHashMap dictionaryUsingHashMap = new DictionaryUsingHashMap();

    ListView<String> suggestionList;
    Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(400,600);
        wordTextField=new TextField();
        wordTextField.setTranslateX(20);
        wordTextField.setTranslateY(30);
        searchButton=new Button("search");
        searchButton.setTranslateX(200);
        searchButton.setTranslateY(30);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               // meaningLabel.setText("Button is Clicked.");
               // wordTextField.getText();
                String word=wordTextField.getText();
                if(word.isBlank() || word.isEmpty()){
                    meaningLabel.setText("Please enter a word");
                    meaningLabel.setTextFill(Color.RED);
                }
                else{
                    String meaning=dictionaryUsingHashMap.getMeaning(word);
                    meaningLabel.setText(meaning);
                    meaningLabel.setTextFill(Color.BLACK);
                }
            }
        });
        meaningLabel=new Label("I am meaning");
        meaningLabel.setTranslateX(20);
        meaningLabel.setTranslateY(60);

        suggestionList=new ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(100);
        suggestionList.setMinSize(330,50);
        suggestionList.setMaxSize(300,50);
//        suggestionList.setsi
        String[] wordList={"start","honesty","shubh","phase","project"};
//        fetch
        suggestionList.getItems().addAll(wordList);
        suggestionList.setOrientation(Orientation.HORIZONTAL);

        suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selectedWord = suggestionList.getSelectionModel().getSelectedItem();
            }
        });
        root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggestionList);

        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}