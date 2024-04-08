/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package prueba;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Prueba extends Application {


    private ArrayList<String> dataList = new ArrayList<>(); // ArrayList to hold user input data

    @Override
    public void start(Stage primaryStage) {
        // Create JavaFX components
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        Button addButton = new Button("Add");
        ListView<String> listView = new ListView<>();

        // Add action to the button
        addButton.setOnAction(event -> {
            String inputText1 = textField1.getText();
            String inputText2 = textField2.getText();
            String inputText3 = textField3.getText();
            // Check if input texts are not empty
            if (!inputText1.isEmpty() && !inputText2.isEmpty() && !inputText3.isEmpty()) {
                // Add input texts to the ArrayList
                dataList.add(inputText1);
                dataList.add(inputText2);
                dataList.add(inputText3);
                // Update the list view
                updateListView(listView);
                // Clear the text fields
                textField1.clear();
                textField2.clear();
                textField3.clear();
            }
        });

        // Create a VBox to hold the components
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(textField1, textField2, textField3, addButton, listView);

        // Set up the scene and show the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("String Input to List Example");
        primaryStage.show();
    }

    // Method to update the list view with the data from the ArrayList
    private void updateListView(ListView<String> listView) {
        ObservableList<String> items = FXCollections.observableArrayList(dataList);
        // Set the items to the list view
        listView.setItems(items);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
