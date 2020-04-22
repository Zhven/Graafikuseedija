import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Schedule planner 2.0");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Error code: 404. File not found");
        alert.setContentText("Please fill the input and output fields before continuing");

        TextField fileInput = new TextField();
        fileInput.setMinWidth(450.0);
        TextField fileOutput = new TextField();

        Button openFileBtn = new Button();
        openFileBtn.setText("Browse");
        openFileBtn.setOnAction(new EventHandler<ActionEvent>()
        {

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

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);
                File fileToSave = fileChooser.showSaveDialog(primaryStage);
                fileOutput.setText(fileToSave.getAbsolutePath());

            }
        });
        Button generateBtn = new Button();
        generateBtn.setText("Generate");
        generateBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event) {
                if (fileInput.getText().isEmpty() || fileOutput.getText().isEmpty()) {
                    //insert error message
                    alert.showAndWait();
                    System.out.println("Jou pane mingi sisend ka ikka");
                }
                else {
                    try {
                        Graafikuseedija.main(fileInput.getText(), fileOutput.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error opening files");
                    }
                }

            }
        });

        Button advancedBtn = new Button();
        advancedBtn.setText("Generate");
        advancedBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event) {
                if (fileInput.getText().isEmpty() || fileOutput.getText().isEmpty()) {
                    //insert error message
                    alert.showAndWait();
                    System.out.println("Jou pane mingi sisend ka ikka");
                }
                else {
                    try {
                        Graafikuseedija.main(fileInput.getText(), fileOutput.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error opening files");
                    }
                }

            }
        });

        StackPane root = new StackPane();
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        grid.add(new Label("CSV input: "), 0, 0);
        grid.add(fileInput, 1, 0);
        grid.add(openFileBtn, 2,0);

        grid.add(new Label("Save to: "), 0, 2);
        grid.add(fileOutput, 1, 2);
        grid.add(saveToBtn, 2, 2);

        grid.add(generateBtn, 9, 1);

        root.getChildren().add(grid);
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }
}