import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.StringUtils;
//--module-path "C:\Users\Sven-Ervin.Paap\Downloads\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
import java.awt.*;
import java.io.*;
import java.util.List;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set window title
        primaryStage.setTitle("Graafikuseedija 3.0");
        //Create menubar
        MenuBar menu = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem quit = new MenuItem("Quit");
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("How-to");
        MenuItem license = new MenuItem("License");
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label secondLabel = new Label(
                        "1. Modify the .xlsx file in Excel by adding any workers that did not submit wishes\n" +
                        "and replacing the e-mail addresses with seniority (SM, SL) \n" +
                        "2. Insert the modified .xlsx file \n" +
                        "3. You can check if the file was read correctly by checking the 'Names found from XLSX' field \n" +
                        "4. Select the file name that the results will be saved as \n" +
                        "5. Adjust the shift sizes \n" +
                        "6. Click export \n" +
                        "7. If no errors show up you can open the file or open the file and close the program \n" +
                        "\n" +
                        "The employees that are displayed underneath the graph do have 40h worth of shifts assigned to them. \n" +
                        "The number show how many hours they currently have assigned \n" +
                        "\n" +
                        "If there are any errors with the schedule generation and the schedule file is not complete \n" +
                        "then the program probably did not find a suitable distribution of workers. As the program \n" +
                        "is based on RNG you can try a few times, maybe a suitable distribution exists, but is not \n" +
                        "as common as some other distributions. \n" +
                        "Generally, the less workers per shift, the easier it is to find a suitable distribution");

                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);

                Scene secondScene = new Scene(secondaryLayout, 550, 300);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("How-to");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 200);

                newWindow.show();
            }
        }); // Create a label window to display instructions
        license.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label secondLabel = new Label("This program comes as is without any guarantees \n" +
                        "\n" +
                        "\n" +
                        "Sven-Ervin Paap & Enri Täär \n" +
                        "2020");

                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);

                Scene secondScene = new Scene(secondaryLayout, 500, 250);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("License");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 200);

                newWindow.show();
            }
        }); // Create a label window to display "license"
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        menuFile.getItems().add(quit);
        menuHelp.getItems().add(about);
        menuHelp.getItems().add(license);

        /* Adding all sub menus at ones to a MenuBar. */
        menu.getMenus().addAll(menuFile, menuHelp);
        VBox menus = new VBox(menu);
        // Alert for notifying the user that they have not provided necessary inputs.
        Alert noFileSelectedAlert = new Alert(Alert.AlertType.WARNING);
        noFileSelectedAlert.setTitle("Error");
        noFileSelectedAlert.setHeaderText("Error code: 404. File not found");
        noFileSelectedAlert.setContentText("Please fill the input and output fields before continuing");
        // Fatal error alert
        Alert fatalErrorAlert = new Alert(Alert.AlertType.ERROR);
        fatalErrorAlert.setTitle("Error");
        fatalErrorAlert.setHeaderText("Fatal error. Program is unable to continue");
        fatalErrorAlert.setContentText("Please restart the program and try again");
        // Alert for successfully generating the results
        Alert jobDoneAlert = new Alert(Alert.AlertType.INFORMATION);
        jobDoneAlert.setTitle("Success");
        jobDoneAlert.setHeaderText("Graphs generated successfully");
        jobDoneAlert.setContentText("The output file is saved in the chosen location");
        // Alert for notifying the user that the generation failed.
        Alert jobFailedAlert = new Alert(Alert.AlertType.WARNING);
        jobFailedAlert.setTitle("Error");
        jobFailedAlert.setHeaderText("No suitable distributions found. Incomplete file is available to be opened");
        jobFailedAlert.setContentText("Please try to generate the graphs again. If the generation continues to fail, please check the inputs (shift sizes)");
        // Text fields for user input
        TextField fileInput = new TextField("C:\\Users\\Sven-Ervin.Paap\\OneDrive - Playtech\\Desktop\\WS02-schedule-wishes_sisendfail - Copy.xlsx");
        fileInput.setMinWidth(450.0);
        TextField fileOutput = new TextField("C:\\Users\\Sven-Ervin.Paap\\OneDrive - Playtech\\Desktop\\testOutput.xlsx");
        // Text area for displaying data found in the chosen file
        TextArea inputFromFile = new TextArea();
        inputFromFile.setMinWidth(75);
        inputFromFile.setEditable(false);
        // Ability to choose shift sizes
        //Monday
        ComboBox<String> mondayMorning = new ComboBox<String>();
        mondayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        mondayMorning.setEditable(true);
        mondayMorning.getSelectionModel().select(4);
        ComboBox<String> mondayEvening = new ComboBox<>();
        mondayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        mondayEvening.setEditable(true);
        mondayEvening.getSelectionModel().select(4);
        ComboBox<String> mondayNight = new ComboBox<>();
        mondayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        mondayNight.setEditable(true);
        mondayNight.getSelectionModel().select(2);
        //Tuesday
        ComboBox<String> tuesdayMorning = new ComboBox<>();
        tuesdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        tuesdayMorning.setEditable(true);
        tuesdayMorning.getSelectionModel().select(4);
        ComboBox<String> tuesdayEvening = new ComboBox<String>();
        tuesdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        tuesdayEvening.setEditable(true);
        tuesdayEvening.getSelectionModel().select(4);
        ComboBox<String> tuesdayNight = new ComboBox<String>();
        tuesdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        tuesdayNight.setEditable(true);
        tuesdayNight.getSelectionModel().select(2);
        //Wednesday
        ComboBox<String> wednesdayMorning = new ComboBox<>();
        wednesdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        wednesdayMorning.setEditable(true);
        wednesdayMorning.getSelectionModel().select(5);
        ComboBox<String> wednesdayEvening = new ComboBox<>();
        wednesdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        wednesdayEvening.setEditable(true);
        wednesdayEvening.getSelectionModel().select(5);
        ComboBox<String> wednesdayNight = new ComboBox<>();
        wednesdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        wednesdayNight.setEditable(true);
        wednesdayNight.getSelectionModel().select(2);
        //Thursday
        ComboBox<String> thursdayMorning = new ComboBox<String>();
        thursdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        thursdayMorning.setEditable(true);
        thursdayMorning.getSelectionModel().select(4);
        ComboBox<String> thursdayEvening = new ComboBox<String>();
        thursdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        thursdayEvening.setEditable(true);
        thursdayEvening.getSelectionModel().select(5);
        ComboBox<String> thursdayNight = new ComboBox<>();
        thursdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        thursdayNight.setEditable(true);
        thursdayNight.getSelectionModel().select(2);
        //Friday
        ComboBox<String> fridayMorning = new ComboBox<String>();
        fridayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        fridayMorning.setEditable(true);
        fridayMorning.getSelectionModel().select(4);
        ComboBox<String> fridayEvening = new ComboBox<>();
        fridayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        fridayEvening.setEditable(true);
        fridayEvening.getSelectionModel().select(5);
        ComboBox<String> fridayNight = new ComboBox<>();
        fridayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        fridayNight.setEditable(true);
        fridayNight.getSelectionModel().select(2);
        //Saturday
        ComboBox<String> saturdayMorning = new ComboBox<>();
        saturdayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        saturdayMorning.setEditable(true);
        saturdayMorning.getSelectionModel().select(2);
        ComboBox<String> saturdayEvening = new ComboBox<String>();
        saturdayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        saturdayEvening.setEditable(true);
        saturdayEvening.getSelectionModel().select(1);
        ComboBox<String> saturdayNight = new ComboBox<String>();
        saturdayNight.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        saturdayNight.setEditable(true);
        saturdayNight.getSelectionModel().select(1);
        //Sunday
        ComboBox<String> sundayMorning = new ComboBox<>();
        sundayMorning.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        sundayMorning.setEditable(true);
        sundayMorning.getSelectionModel().select(2);
        ComboBox<String> sundayEvening = new ComboBox<String>();
        sundayEvening.setEditable(true);
        sundayEvening.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        sundayEvening.getSelectionModel().select(2);
        ComboBox<String> sundayNight = new ComboBox<String>();
        sundayNight.getItems().addAll("0","1", "2", "3", "4", "5", "6", "7", "8", "9");
        sundayNight.setEditable(true);
        sundayNight.getSelectionModel().select(0);
        //Attempts
        ComboBox<String> attempts = new ComboBox<>();
        attempts.getItems().addAll("1", "5", "50", "100");
        attempts.setEditable(true);
        attempts.getSelectionModel().select(2);
        // Create buttons
        Button openFileBtn = new Button();
        openFileBtn.setText("Browse");
        openFileBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            // Open file dialog for opening the XLSX file
            @Override
            public void handle(ActionEvent event) {
                // Select the XLSX file
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                fileInput.setText(selectedFile.getAbsolutePath());
                // Display the workers found in the CSV file
                inputFromFile.clear(); // clear any previous text
                ReadFromXLSX.setFileName(selectedFile.getAbsolutePath());
                //String[] workersFromFile = new String[20];
                List<Worker> workersFromFile = ReadFromXLSX.readInput();
                int i = 1;
                for (Worker worker : workersFromFile) {
                    if (!worker.getName().equals("Name")) {
                        inputFromFile.appendText(i + ". " + worker.getName() + "\n");
                        i++;
                    }
                }

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

                        // Get read and write location
                        ReadFromXLSX.setFileName(fileInput.getText());
                        WriteToXLSX.setFileLocation(fileOutput.getText());
                        // Generate graph
                        String[][] week = Parser.parse(shiftSizes);
                        // Iterate the generation for set amount of times until a suitable distribution is found of the iterations run out
                        boolean done = false;
                        for (int i = 0; i < Integer.parseInt(attempts.getValue()); i++) {
                            if (!done) {
                                if (week.length < 4 || week[2][6].split("/", -1).length-1 < Integer.parseInt(sundayEvening.getValue())) {  //Check if the Sunday evening shift contains the amount of workers that was set in the GUI
                                    ReadFromXLSX.setFileName(fileInput.getText()); //Reset workers array (delete previous working hours)
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
                                    week = Parser.parse(shiftSizes); //Generate new distribution.
                                    //System.out.println(i);
                                } else {
                                    done = true;
                                }
                            } else {
                                break;
                            }
                        }
                        WriteToXLSX.writeInput(week); //Write the workers to Excel
                        //GUI element actions
                        openBtn.setVisible(true);
                        openAndCloseBtn.setVisible(true);
                        if (done) {
                            jobDoneAlert.showAndWait();
                        } else  {
                            jobFailedAlert.showAndWait();
                        }


                        /*
                        // Run graafikuseedija with the inputs from GUI and set some buttons visible if the genertion was successful
                        if(Graafikuseedija.main(fileInput.getText(), fileOutput.getText(), shiftSizes)) {
                        } else {
                        }

                         */

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error");
                        fatalErrorAlert.showAndWait();
                        Platform.exit();
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

        //StackPane contentPane = new StackPane();
        // Create a grid for element management
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(15);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        // Add all the elements to the grid
        grid.add(new Label("XLSX input: "), 0, 2);
        grid.add(fileInput, 1, 2, 8,1);
        grid.add(openFileBtn, 9,2);

        grid.add(new Label("Names found from XLSX: "), 11, 2);
        grid.add(inputFromFile, 11, 3, 1, 10);

        grid.add(new Label("Save to: "), 0, 4);
        grid.add(fileOutput, 1, 4, 8,1);
        grid.add(saveToBtn, 9, 4);

        grid.add(openBtn, 1, 14);
        grid.add(openAndCloseBtn, 2, 14, 3,1);

        grid.add(generateBtn, 7, 14, 3,1);
        grid.add(new Label("Ammount of generation attempts"), 11, 13);
        grid.add(attempts, 11, 14);

        grid.add(new Label("Morning"), 0, 10);
        grid.add(new Label("Evening"), 0, 11);
        grid.add(new Label("Night"), 0, 12);

        grid.add(new Label("Monday"), 1, 9);
        grid.add(new Label("Tuesday"), 2, 9);
        grid.add(new Label("Wednesday"), 3, 9);
        grid.add(new Label("Thursday"), 4, 9);
        grid.add(new Label("Friday"), 5, 9);
        grid.add(new Label("Saturday"), 6, 9);
        grid.add(new Label("Sunday"), 7, 9);

        grid.add(mondayMorning, 1, 10);
        grid.add(mondayEvening, 1, 11);
        grid.add(mondayNight, 1, 12);

        grid.add(tuesdayMorning, 2, 10);
        grid.add(tuesdayEvening, 2, 11);
        grid.add(tuesdayNight, 2, 12);

        grid.add(wednesdayMorning, 3, 10);
        grid.add(wednesdayEvening, 3, 11);
        grid.add(wednesdayNight, 3, 12);

        grid.add(thursdayMorning, 4, 10);
        grid.add(thursdayEvening, 4, 11);
        grid.add(thursdayNight, 4, 12);

        grid.add(fridayMorning, 5, 10);
        grid.add(fridayEvening, 5, 11);
        grid.add(fridayNight, 5, 12);

        grid.add(saturdayMorning, 6, 10);
        grid.add(saturdayEvening, 6, 11);
        grid.add(saturdayNight, 6, 12);

        grid.add(sundayMorning, 7, 10);
        grid.add(sundayEvening, 7, 11);
        grid.add(sundayNight, 7, 12);

        BorderPane root = new BorderPane();
        // Add grid to the scene
        root.setCenter(grid);
        // Add menu to the scene
        root.setTop(menus);
        // Add scene to stage
        primaryStage.setScene(new Scene(root, 1200, 550));
        // Show stage
        primaryStage.show();
    }
}
/*
final class Generator {
    final void Generate(){
        Graafikuseedija.main(fileInput.getText(), fileOutput.getText(), shiftSizes);
    }
}

 */