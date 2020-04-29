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
        // Ability to choose shift sizes
        //Monday
        ComboBox<String> mondayMorning = new ComboBox<String>();
        mondayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        mondayMorning.getSelectionModel().select(5);
        ComboBox<String> mondayEvening = new ComboBox<>();
        mondayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        mondayEvening.getSelectionModel().select(5);
        ComboBox<String> mondayNight = new ComboBox<>();
        mondayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        mondayNight.getSelectionModel().select(2);
        //Tuesday
        ComboBox<String> tuesdayMorning = new ComboBox<>();
        tuesdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        tuesdayMorning.getSelectionModel().select(5);
        ComboBox<String> tuesdayEvening = new ComboBox<String>();
        tuesdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        tuesdayEvening.getSelectionModel().select(5);
        ComboBox<String> tuesdayNight = new ComboBox<String>();
        tuesdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        tuesdayNight.getSelectionModel().select(2);
        //Wednesday
        ComboBox<String> wednesdayMorning = new ComboBox<>();
        wednesdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        wednesdayMorning.getSelectionModel().select(5);
        ComboBox<String> wednesdayEvening = new ComboBox<>();
        wednesdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        wednesdayEvening.getSelectionModel().select(5);
        ComboBox<String> wednesdayNight = new ComboBox<>();
        wednesdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        wednesdayNight.getSelectionModel().select(2);
        //Thursday
        ComboBox<String> thursdayMorning = new ComboBox<String>();
        thursdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        thursdayMorning.getSelectionModel().select(5);
        ComboBox<String> thursdayEvening = new ComboBox<String>();
        thursdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        thursdayEvening.getSelectionModel().select(5);
        ComboBox<String> thursdayNight = new ComboBox<>();
        thursdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        thursdayNight.getSelectionModel().select(2);
        //Friday
        ComboBox<String> fridayMorning = new ComboBox<String>();
        fridayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        fridayMorning.getSelectionModel().select(5);
        ComboBox<String> fridayEvening = new ComboBox<>();
        fridayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        fridayEvening.getSelectionModel().select(5);
        ComboBox<String> fridayNight = new ComboBox<>();
        fridayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        fridayNight.getSelectionModel().select(2);
        //Saturday
        ComboBox<String> saturdayMorning = new ComboBox<>();
        saturdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        saturdayMorning.getSelectionModel().select(2);
        ComboBox<String> saturdayEvening = new ComboBox<String>();
        saturdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        saturdayEvening.getSelectionModel().select(2);
        ComboBox<String> saturdayNight = new ComboBox<String>();
        saturdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        saturdayNight.getSelectionModel().select(1);
        //Sunday
        ComboBox<String> sundayMorning = new ComboBox<>();
        sundayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        sundayMorning.getSelectionModel().select(2);
        ComboBox<String> sundayEvening = new ComboBox<String>();
        sundayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        sundayEvening.getSelectionModel().select(2);
        ComboBox<String> sundayNight = new ComboBox<String>();
        sundayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        sundayNight.getSelectionModel().select(1);
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
                        // Get shift sizes array
                        String[][] shiftSizes = new String[7][3];
                        shiftSizes[0][0] = mondayMorning.getValue();
                        shiftSizes[0][1] = mondayEvening.getValue();
                        shiftSizes[0][2] = mondayNight.getValue();
                        shiftSizes[1][0] = tuesdayMorning.getValue();
                        shiftSizes[1][1] = tuesdayEvening.getValue();
                        shiftSizes[1][2] = tuesdayNight.getValue();
                        shiftSizes[2][0] = wednesdayMorning.getValue();
                        shiftSizes[2][1] = wednesdayEvening.getValue();
                        shiftSizes[2][2] = wednesdayNight.getValue();
                        shiftSizes[3][0] = thursdayMorning.getValue();
                        shiftSizes[3][1] = thursdayEvening.getValue();
                        shiftSizes[3][2] = thursdayNight.getValue();
                        shiftSizes[4][0] = fridayMorning.getValue();
                        shiftSizes[4][1] = fridayEvening.getValue();
                        shiftSizes[4][2] = fridayNight.getValue();
                        shiftSizes[5][0] = saturdayMorning.getValue();
                        shiftSizes[5][1] = saturdayEvening.getValue();
                        shiftSizes[5][2] = saturdayNight.getValue();
                        shiftSizes[6][0] = sundayMorning.getValue();
                        shiftSizes[6][1] = sundayEvening.getValue();
                        shiftSizes[6][2] = sundayNight.getValue();

                        // Run graafikuseedija with the inputs from GUI and set some buttons visible
                        Graafikuseedija.main(fileInput.getText(), fileOutput.getText(), shiftSizes);
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
        grid.setHgap(15);
        grid.setPadding(new Insets(10, 10, 10, 10));
        // Add all the elements to the grid
        grid.add(new Label("CSV input: "), 0, 0);
        grid.add(fileInput, 1, 0, 8,1);
        grid.add(openFileBtn, 9,0);

        grid.add(new Label("Save to: "), 0, 2);
        grid.add(fileOutput, 1, 2, 8,1);
        grid.add(saveToBtn, 9, 2);

        grid.add(generateBtn, 20, 1);

        grid.add(openBtn, 20, 10);
        grid.add(openAndCloseBtn, 20, 11);

        grid.add(new Label("Morning"), 0, 15);
        grid.add(new Label("Evening"), 0, 16);
        grid.add(new Label("Night"), 0, 17);

        grid.add(new Label("Monday"), 1, 14);
        grid.add(new Label("Tuesday"), 2, 14);
        grid.add(new Label("Wednesday"), 3, 14);
        grid.add(new Label("Thursday"), 4, 14);
        grid.add(new Label("Friday"), 5, 14);
        grid.add(new Label("Saturday"), 6, 14);
        grid.add(new Label("Sunday"), 7, 14);

        grid.add(mondayMorning, 1, 15);
        grid.add(mondayEvening, 1, 16);
        grid.add(mondayNight, 1, 17);

        grid.add(tuesdayMorning, 2, 15);
        grid.add(tuesdayEvening, 2, 16);
        grid.add(tuesdayNight, 2, 17);

        grid.add(wednesdayMorning, 3, 15);
        grid.add(wednesdayEvening, 3, 16);
        grid.add(wednesdayNight, 3, 17);

        grid.add(thursdayMorning, 4, 15);
        grid.add(thursdayEvening, 4, 16);
        grid.add(thursdayNight, 4, 17);

        grid.add(fridayMorning, 5, 15);
        grid.add(fridayEvening, 5, 16);
        grid.add(fridayNight, 5, 17);

        grid.add(saturdayMorning, 6, 15);
        grid.add(saturdayEvening, 6, 16);
        grid.add(saturdayNight, 6, 17);

        grid.add(sundayMorning, 7, 15);
        grid.add(sundayEvening, 7, 16);
        grid.add(sundayNight, 7, 17);
        // Add grid to the scene
        root.getChildren().add(grid);
        // Add scene to stage
        primaryStage.setScene(new Scene(root, 1024, 768));
        // Show stage
        primaryStage.show();
    }
}