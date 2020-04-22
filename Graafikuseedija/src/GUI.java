import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Schedule planner 2.0");
        // Alert for notifying the user that they have not provided necessary inputs.
        Alert noFileSelectedAlert = new Alert(Alert.AlertType.WARNING);
        noFileSelectedAlert.setTitle("Error");
        noFileSelectedAlert.setHeaderText("Error code: 404. File not found");
        noFileSelectedAlert.setContentText("Please fill the input and output fields before continuing");
        // Alert for successfully generating the results
        Alert jobDoneAlert = new Alert(Alert.AlertType.INFORMATION);
        jobDoneAlert.setTitle("Success");
        jobDoneAlert.setHeaderText("Graphs generated successfully");
        jobDoneAlert.setContentText("The output file is saved in the chosen location");
        // Text fields for user input
        TextField fileInput = new TextField();
        fileInput.setMinWidth(450.0);
        TextField fileOutput = new TextField();
        // Create buttons
        Button openFileBtn = new Button();
        openFileBtn.setText("Browse");
        openFileBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Open file dialog for opening the CSV file
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                fileInput.setText(selectedFile.getAbsolutePath());

            }
        });
        Button saveToBtn = new Button();
        saveToBtn.setText("Browse");
        saveToBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Save file dialog to choose the location to save the results to
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);
                File fileToSave = fileChooser.showSaveDialog(primaryStage);
                fileOutput.setText(fileToSave.getAbsolutePath());

            }
        });
        Button openBtn = new Button();
        openBtn.setText("Open file");
        openBtn.setVisible(false);
        openBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Button to open the file after it's creation
            @Override
            public void handle(ActionEvent event) {
                try {
                    Desktop.getDesktop().open(new File(fileOutput.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        Button openAndCloseBtn = new Button();
        openAndCloseBtn.setText("Open file and exit programm");
        openAndCloseBtn.setVisible(false);
        openAndCloseBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Button to open the file after it's creation and close the program, as it is probably not needed after this
            @Override
            public void handle(ActionEvent event) {
                try {
                    Desktop.getDesktop().open(new File(fileOutput.getText()));
                    Platform.exit();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        Button generateBtn = new Button();
        generateBtn.setText("Generate");
        generateBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Button to check for inputs and call the main function
            @Override
            public void handle(ActionEvent event) {

                if (fileInput.getText().isEmpty() || fileOutput.getText().isEmpty()) {
                    //insert error message
                    noFileSelectedAlert.showAndWait();
                }
                else {
                    try {
                        Graafikuseedija.main(fileInput.getText(), fileOutput.getText());
                        openBtn.setVisible(true);
                        openAndCloseBtn.setVisible(true);
                        jobDoneAlert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error opening files");
                    }
                }
            }
        });
        Button advancedBtn = new Button();
        advancedBtn.setText("Advanced");
        advancedBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Button to show/hide any advanced features
            @Override
            public void handle(ActionEvent event) {

            }
        });


        StackPane root = new StackPane();
        // Create a grid for element management
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        // Add all the elements to the grid
        grid.add(new Label("CSV input: "), 0, 0);
        grid.add(fileInput, 1, 0);
        grid.add(openFileBtn, 2,0);

        grid.add(new Label("Save to: "), 0, 2);
        grid.add(fileOutput, 1, 2);
        grid.add(saveToBtn, 2, 2);

        grid.add(generateBtn, 20, 1);

        grid.add(openBtn, 20, 10);
        grid.add(openAndCloseBtn, 20, 11);
        // Add grid to the scene
        root.getChildren().add(grid);
        // Add scene to stage
        primaryStage.setScene(new Scene(root, 1024, 768));
        // Show stage
        primaryStage.show();
    }
}