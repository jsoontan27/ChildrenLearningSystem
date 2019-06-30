
/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Jsoon
 */
public class main extends Application {

    private int intrandomshape;
    private int randomIntColor;
    List<Color> colorforshape = new ArrayList<>();
    Stage mystage = new Stage();
    Scene AlphaScene1, AlphaTest, AlphaTest1, AlphaRevision;
    ArrayList<String> Score = new ArrayList<String>();

    public HBox ImageQuestion(ImageView a, ImageView b, String Answer) throws FileNotFoundException {
        HBox questionhbox = new HBox(5);
        VBox column = new VBox(5);
        HBox row = new HBox(5);
        row.setAlignment(Pos.CENTER);
        questionhbox.setAlignment(Pos.CENTER);
        column.setAlignment(Pos.CENTER);
        Label message = new Label("");

        FileInputStream questionmarkstream = new FileInputStream("questionmark.png");
        Image questionmarkimage = new Image(questionmarkstream);
        ImageView questionmarkview = new ImageView(questionmarkimage);
        questionmarkview.setFitHeight(100);
        questionmarkview.setFitWidth(100);
        questionmarkview.setPreserveRatio(true);

        row.setPrefWidth(20);
        row.setPrefHeight(20);
        row.getChildren().add(a);
        row.getChildren().add(questionmarkview);
        row.getChildren().add(b);

        Label question = new Label("What is the letter that is placed in between these two letters?");
        question.setFont(Font.font("times", FontWeight.BOLD, 20));

        TextField answer = new TextField();
        answer.setStyle("-fx-font-size: 20pt;");
        answer.setPrefColumnCount(5);

        Button check = new Button("CHECK!");

        column.getChildren().addAll(row, question, answer, check);

        check.setOnAction(e -> {
            String input;
            input = answer.getText();
            boolean checkans = false;

            if (input.equalsIgnoreCase(Answer)) {
                message.setText("You have entered the correct answer! Move On!");
                column.getChildren().add(message);
            } else {
                message.setText("You have entered the incorrect answer! Please Try Again!");
                column.getChildren().add(message);
            }

        });

        questionhbox.getChildren().add(column);

        return questionhbox;
    }

    @Override
    public void start(Stage primaryStage) throws IOException, FileNotFoundException {

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        Text usernameLabel = new Text("Username:");
        Text passwordLabel = new Text("Password:");
        String usernameTitle = new String("");

        GridPane loginPage = new GridPane();
        loginPage.add(usernameLabel, 0, 1);
        loginPage.add(passwordLabel, 0, 2);
        loginPage.add(username, 1, 1);
        loginPage.add(password, 1, 2);
        loginPage.add(loginButton, 1, 3);
        loginPage.add(registerButton, 1, 4);

        loginPage.setPadding(new Insets(150, 150, 150, 150));
        loginPage.setHgap(15);
        loginPage.setVgap(15);
        loginPage.setHalignment(loginButton, HPos.RIGHT);
        loginPage.setAlignment(Pos.CENTER_LEFT);
        loginPage.setStyle("-fx-font: 16 arial;");

        usernameLabel.setStyle("-fx-font-weight:bold");
        passwordLabel.setStyle("-fx-font-weight:bold");
        loginButton.setStyle("-fx-font-size: 18 ");
        registerButton.setStyle("-fx-font-size: 20 ");

        //Initialising path of the media file, replace this with your file path   
        String path = "src/music.mp3";

        //Instantiating Media class  
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played   
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        DropShadow dsTitle = new DropShadow();
        dsTitle.setOffsetX(6.0);
        dsTitle.setOffsetY(4.0);

        Text titleName = new Text();
        titleName.setText("Welcome! Please select a game");
        titleName.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 55));
        titleName.setEffect(dsTitle);
        titleName.setFill(Color.LIGHTCORAL);

        HBox selectionTitle = new HBox();
        selectionTitle.setAlignment(Pos.CENTER);
        selectionTitle.getChildren().addAll(titleName);
        selectionTitle.setPadding(new Insets(10, 50, 50, 50));
        selectionTitle.setSpacing(10);

        //Set Image here
        ImageView alphabetImage = new ImageView("alphabetBUTTON.png");
        ImageView shapeImage = new ImageView("shapeBUTTON.png");
        ImageView mathImage = new ImageView("mathBUTTON.png");
        ImageView animalImage = new ImageView("animalBUTTON.jpg");
        ImageView geographyImage = new ImageView("geographyBUTTON.jpg");

        //Buttons for All Games
        Button alphabetButton = new Button();
        alphabetImage.setFitWidth(230);
        alphabetImage.setFitHeight(160);
        alphabetButton.setGraphic(alphabetImage);
        alphabetButton.setStyle("-fx-background-color:transparent;");

        Button shapeButton = new Button();
        shapeImage.setFitWidth(230);
        shapeImage.setFitHeight(160);
        shapeButton.setGraphic(shapeImage);
        shapeButton.setStyle("-fx-background-color:transparent;");

        Button mathButton = new Button();
        mathImage.setFitWidth(230);
        mathImage.setFitHeight(180);
        mathButton.setGraphic(mathImage);
        mathButton.setStyle("-fx-background-color:transparent;");

        Button animalButton = new Button();
        animalImage.setFitWidth(230);
        animalImage.setFitHeight(160);
        animalButton.setGraphic(animalImage);
        animalButton.setStyle("-fx-background-color:transparent;");

        Button geographyButton = new Button();
        geographyImage.setFitWidth(230);
        geographyImage.setFitHeight(160);
        geographyButton.setGraphic(geographyImage);
        geographyButton.setStyle("-fx-background-color:transparent;");

        BorderPane Mpane = new BorderPane();
        Mpane.setPadding(new Insets(50, 50, 50, 50));
        VBox MLvBox = new VBox(10);
        MLvBox.setAlignment(Pos.CENTER);
        TextArea taTable = new TextArea();
        taTable.setPrefRowCount(15);
        taTable.setPrefColumnCount(20);
        taTable.setEditable(false);
        BackgroundImage MBI = new BackgroundImage(new Image("bg1.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Mpane.setBackground(new Background(MBI));
        MLvBox.getChildren().addAll(new ScrollPane(taTable));
        Mpane.setCenter(MLvBox);
        MLvBox.setPadding(new Insets(10, 162, 40, 21));
        MLvBox.setAlignment(Pos.CENTER);

        Button MHS = new Button("Selection Screen");
        MHS.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        MHS.setStyle("-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, yellow,white);");
        //MHS.setAlignment(Pos.TOP_LEFT);
        ImageView mgb = new ImageView("bthb.png");
        MHS.setGraphic(mgb);
        mgb.setFitHeight(50);
        mgb.setFitWidth(50);
        Mpane.setLeft(MHS);

        taTable.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        DropShadow Mds = new DropShadow();
        Mds.setOffsetY(3.0f);
        Mds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        taTable.setEffect(Mds);

        TextField number = new TextField("1");
        number.setPrefColumnCount(2);
        number.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField operator = new TextField("+");
        operator.setPrefColumnCount(2);
        operator.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

        Button btShowTable = new Button("Show Table");
        btShowTable.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        btShowTable.setStyle("-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, orange, yellow);");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Integer Number"),
                number, new Label("Operator"),
                operator, btShowTable);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: linear-gradient(to right, red,orange,yellow,green,blue,indigo,violet);-fx-font-size: 20px; -fx-font-weight:bold; -fx-font-family: Comic Sans MS;");
        Mpane.setBottom(hBox);

        btShowTable.setOnAction(e -> {

            if (number.getText().trim().isEmpty()) {
                taTable.setText("Please enter the number!\n");
            }

            int Mnum = Integer.parseInt(number.getText().trim());
            String opr = operator.getText();

            if (opr.isEmpty()) {
                taTable.setText("Please enter the operator!\n");
            }

            if ((!opr.equals("+")) || (!opr.equals("-")) || (!opr.equals("x")) || (!opr.equals("/"))) {
                taTable.setText("Please enter + or - or x or /\n" + "in the operator textfield at below!\n");

            }

            if (opr.equals("x")) {
                taTable.setText("Multiplication Table of " + Mnum + "\n");

                for (int i = 1; i <= 12; i++) {
                    taTable.appendText(i + "\t" + opr + "\t" + Mnum + "\t=\t" + i * Mnum + "\n");
                }
            }

            if (Mnum < 0) {
                taTable.setText("Please enter the positive number!\n");
            }

            if (opr.equals("+")) {
                taTable.setText("Addition Table of " + Mnum + "\n");

                for (int i = 1; i <= 12; i++) {
                    taTable.appendText(i + "\t" + opr + "\t" + Mnum + "\t=\t" + (i + Mnum) + "\n");
                }
            }

            if (opr.equals("-")) {
                taTable.setText("Subtraction Table of " + Mnum + "\n");

                for (int i = 1; i <= 12; i++) {
                    if (i - Mnum >= 0) {
                        taTable.appendText(i + "\t" + opr + "\t" + Mnum + "\t=\t" + (i - Mnum) + "\n");
                    } else if (Mnum > 12) {
                        taTable.appendText("Please enter integer number between 1 - 12. ");
                    }
                }
            }

            if (opr.equals("/")) {
                try {
                    taTable.setText("Division Table of " + Mnum + "\n");

                    for (int i = 1; i <= 12; i++) {
                        if (i % Mnum == 0) {
                            taTable.appendText(i + "\t" + "÷" + "\t" + Mnum + "\t=\t" + (i / Mnum) + "\n");
                        } else {
                            taTable.appendText(i + "\t" + "÷" + "\t" + Mnum + "\t=\t" + i + "/" + Mnum + "\n");
                        }
                    }
                } catch (ArithmeticException | NumberFormatException ex) {
                    taTable.appendText("Oops, you can’t divide by zero. \n");
                    taTable.appendText("Please enter integer number! \n");
                }
            }
        });

        BorderPane Mpane1 = new BorderPane();
        Mpane1.setPadding(new Insets(50, 50, 50, 50));
        BackgroundImage MBI1 = new BackgroundImage(new Image("bg10.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Mpane1.setBackground(new Background(MBI1));

        Button MHS1 = new Button("Selection Screen");
        MHS1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        MHS1.setStyle("-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, yellow,white);");
        Mpane1.setTop(MHS1);
        ImageView mgb1 = new ImageView("bthb.png");
        MHS1.setGraphic(mgb1);
        mgb1.setFitHeight(50);
        mgb1.setFitWidth(50);

        Button MGSubmit = new Button("Submit");
        MGSubmit.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        MGSubmit.setStyle("-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, pink,white);");
        Mpane1.setRight(MGSubmit);

        VBox MGvBox = new VBox(10);
        Random rnd = new Random();
        int randomNumber1 = rnd.nextInt(12) + 1;
        int randomNumber2 = rnd.nextInt(12) + 1;
        int randomNumber3 = rnd.nextInt(12) + 1;
        int randomNumber4 = rnd.nextInt(12) + 1;
        int randomNumber5 = rnd.nextInt(12) + 1;
        int randomNumber6 = rnd.nextInt(12) + 1;
        int randomNumber7 = rnd.nextInt(12) + 1;
        int randomNumber8 = rnd.nextInt(12) + 1;

        Text RN1 = new Text(Integer.toString(randomNumber1));
        RN1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN2 = new Text(Integer.toString(randomNumber2));
        RN2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN3 = new Text(Integer.toString(randomNumber3));
        RN3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN4 = new Text(Integer.toString(randomNumber4));
        RN4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN5 = new Text(Integer.toString(randomNumber5));
        RN5.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN6 = new Text(Integer.toString(randomNumber6));
        RN6.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN7 = new Text(Integer.toString(randomNumber7));
        RN7.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Text RN8 = new Text(Integer.toString(randomNumber8));
        RN8.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

        TextField UMGansA = new TextField();
        UMGansA.setPrefColumnCount(2);
        UMGansA.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField UMGansM = new TextField();
        UMGansM.setPrefColumnCount(2);
        UMGansM.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField UMGansS = new TextField();
        UMGansS.setPrefColumnCount(2);
        UMGansS.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField UMGansD = new TextField();
        UMGansD.setPrefColumnCount(2);
        UMGansD.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

        Label MGQ = new Label("Please answer the following questions: ");
        MGQ.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label AM = new Label("+");
        AM.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label SM = new Label("-");
        SM.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label MM = new Label("x");
        MM.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label DM = new Label("÷");
        DM.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label EM1 = new Label("=");
        EM1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label EM2 = new Label("=");
        EM2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label EM3 = new Label("=");
        EM3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Label EM4 = new Label("=");
        EM4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

        HBox MGQ1hBox = new HBox(10);
        MGQ1hBox.getChildren().addAll(RN1, AM, RN2, EM1, UMGansA);
        MGQ1hBox.setAlignment(Pos.CENTER);

        HBox MGQ2hBox = new HBox(10);
        if (randomNumber3 >= randomNumber4) {
            MGQ2hBox.getChildren().addAll(RN3, SM, RN4, EM2, UMGansS);
        } else if (randomNumber4 >= randomNumber3) {
            MGQ2hBox.getChildren().addAll(RN4, SM, RN3, EM2, UMGansS);
        }
        MGQ2hBox.setAlignment(Pos.CENTER);

        HBox MGQ3hBox = new HBox(10);
        MGQ3hBox.getChildren().addAll(RN5, MM, RN6, EM3, UMGansM);
        MGQ3hBox.setAlignment(Pos.CENTER);

        HBox MGQ4hBox = new HBox(10);
        MGQ4hBox.getChildren().addAll(RN7, DM, RN8, EM4, UMGansD);
        MGQ4hBox.setAlignment(Pos.CENTER);

        MGvBox.getChildren().addAll(MGQ, MGQ1hBox, MGQ2hBox, MGQ3hBox, MGQ4hBox);
        MGvBox.setAlignment(Pos.CENTER);
        Mpane1.setLeft(MGvBox);

        int MAans = randomNumber1 + randomNumber2;
        String TMAans = Integer.toString(MAans);
        Text TTMAans = new Text(TMAans);
        TTMAans.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

        int MSans = 0;

        if (randomNumber3 >= randomNumber4) {
            MSans = randomNumber3 - randomNumber4;
        } else if (randomNumber4 >= randomNumber3) {
            MSans = randomNumber4 - randomNumber3;
        }
        String TMSans = Integer.toString(MSans);
        Text TTMSans = new Text(TMSans);
        TTMSans.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

        int MMans = randomNumber5 * randomNumber6;
        String TMMans = Integer.toString(MMans);
        Text TTMMans = new Text(TMMans);
        TTMMans.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        int MDans = 0;
        if (randomNumber7 % randomNumber8 == 0) {
            MDans = randomNumber7 / randomNumber8;
        } else if (randomNumber8 % randomNumber7 == 0) {
            MDans = randomNumber8 / randomNumber7;
        }

        String TMDans = Integer.toString(MDans);
        Text TTMDans = new Text(TMDans);
        TTMDans.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        String rrn7 = Integer.toString(randomNumber7);
        Text rrrn7 = new Text(rrn7);
        String rrn8 = Integer.toString(randomNumber8);
        Text rrrn8 = new Text(rrn8);

        if (randomNumber8 == randomNumber7) {
            MDans = 0;
        } else {
            TMDans = randomNumber7 + "/" + randomNumber8;
        }

        TTMAans.setFill(Color.RED);
        TTMSans.setFill(Color.RED);
        TTMMans.setFill(Color.RED);
        TTMDans.setFill(Color.RED);

        GridPane MGAnS = new GridPane();
        MGSubmit.setOnAction(e -> {
            double correct = 0;
            UMGansA.setEditable(false);
            UMGansM.setEditable(false);
            UMGansS.setEditable(false);
            UMGansD.setEditable(false);

            if (UMGansA.getText().equals(TMAans)) {
                MGAnS.add(new Label("Correct!"), 0, 0);
                correct++;
            } else if (UMGansA.getText().isEmpty()) {
                MGAnS.add(new Label("Please enter the answer!"), 0, 0);
            } else {
                MGAnS.add(new Label("The correct answer is "), 0, 0);
                MGAnS.add(TTMAans, 0, 1);
            }

            if (UMGansS.getText().equals(TMSans)) {
                MGAnS.add(new Label("Correct!"), 0, 2);
                correct++;
            } else if (UMGansS.getText().isEmpty()) {
                MGAnS.add(new Label("Please enter the answer!"), 0, 2);
            } else {
                MGAnS.add(new Label("The correct answer is "), 0, 2);
                MGAnS.add(TTMSans, 0, 3);
            }

            if (UMGansM.getText().equals(TMMans)) {
                MGAnS.add(new Label("Correct!"), 0, 4);
                correct++;
            } else if (UMGansM.getText().isEmpty()) {
                MGAnS.add(new Label("Please enter the answer!"), 0, 4);
            } else {
                MGAnS.add(new Label("The correct answer is "), 0, 4);
                MGAnS.add(TTMMans, 0, 5);
            }

            if (UMGansD.getText().equals(TTMDans)) {
                MGAnS.add(new Label("Correct!"), 0, 6);
                correct++;
            } else if (UMGansD.getText().equals(randomNumber7 + "/" + randomNumber8)) {
                MGAnS.add(new Label("Correct!"), 0, 6);
                correct++;
            } else if (UMGansD.getText().isEmpty()) {
                MGAnS.add(new Label("Please enter the answer!"), 0, 6);
            } else {

                MGAnS.add(new Label("The correct answer is "), 0, 6);
                TTMDans.setText(rrn7 + "/" + rrn8);
                MGAnS.add(TTMDans, 0, 7);
            }

            double percentageCorrect = correct * 25;

            Label TT = new Label("You got " + correct + " correct answers." + "That's " + percentageCorrect + "%! Keep it up!");
            TT.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
            MGAnS.add(TT, 0, 9);

            MGAnS.setStyle("-fx-font-size: 20px; -fx-font-weight:bold; -fx-font-family: Comic Sans MS;");

            try {
                Image image = new Image(new FileInputStream("mn.gif"));
                ImageView imageView1 = new ImageView(image);
                MGAnS.add(imageView1, 0, 10);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Math.class.getName()).log(Level.SEVERE, null, ex);
            }

            MGAnS.setAlignment(Pos.BOTTOM_CENTER);
            Mpane1.setRight(MGAnS);
        });

        Button redo = new Button("Redo");
        redo.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        redo.setStyle("-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, orange,red);");

        redo.setOnAction(e -> {
            UMGansA.setEditable(true);
            UMGansM.setEditable(true);
            UMGansS.setEditable(true);
            UMGansD.setEditable(true);

            MGvBox.getChildren().clear();
            MGAnS.getChildren().clear();
            MGvBox.getChildren().addAll(MGQ, MGQ1hBox, MGQ2hBox, MGQ3hBox, MGQ4hBox);
            Mpane1.getChildren().addAll(MGSubmit);

        });

        Mpane1.setBottom(redo);

        BorderPane MSelectionScreen = new BorderPane();
        BackgroundImage MSS = new BackgroundImage(new Image("bg4.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        MSelectionScreen.setBackground(new Background(MSS));
        MSelectionScreen.setPadding(new Insets(50, 50, 50, 50));

        HBox msshbox = new HBox(50);
        HBox msshbox1 = new HBox(50);

        Button MSS1 = new Button();
        MSS1.setStyle("-fx-background-color: transparent;-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");

        ImageView mh = new ImageView("mhome-icon.png");
        MSS1.setGraphic(mh);
        mh.setFitHeight(100);
        mh.setFitWidth(100);

        Button MSS2 = new Button("Math Learning");
        MSS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        MSS2.setStyle("-fx-cursor: hand;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, yellow,red);");
        ImageView lb = new ImageView("lb.gif");
        MSS2.setGraphic(lb);
        lb.setFitHeight(100);
        lb.setFitWidth(100);

        Button MSS3 = new Button("Math Gaming");
        MSS3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        MSS3.setStyle("-fx-cursor: hand;-fx-text-fill:white;-fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-background-color: linear-gradient(to right, violet,blue);");
        ImageView mgm = new ImageView("mgm.gif");
        MSS3.setGraphic(mgm);
        mgm.setFitHeight(100);
        mgm.setFitWidth(100);

        msshbox1.getChildren().addAll(MSS1);
        msshbox1.setAlignment(Pos.TOP_CENTER);
        msshbox.getChildren().addAll(MSS2, MSS3);
        msshbox.setAlignment(Pos.CENTER);

        MSelectionScreen.setCenter(msshbox);
        MSelectionScreen.setTop(msshbox1);

        Scene Math = new Scene(Mpane, 1000, 650);
        Scene Math2 = new Scene(Mpane1, 1000, 650);
        Scene Math3 = new Scene(MSelectionScreen, 1000, 650);

        MSS2.setOnAction(e -> {
            primaryStage.setScene(Math);
        });

        MSS3.setOnAction(e -> {
            primaryStage.setScene(Math2);
        });

        MHS.setOnAction(e -> {
            primaryStage.setScene(Math3);
        });

        MHS1.setOnAction(e -> {
            primaryStage.setScene(Math3);
        });

        colorforshape.add(0, Color.CYAN);
        colorforshape.add(1, Color.BLUE);
        colorforshape.add(2, Color.WHITE);
        colorforshape.add(3, Color.RED);
        colorforshape.add(4, Color.GREEN);
        colorforshape.add(5, Color.YELLOW);
        colorforshape.add(6, Color.MAGENTA);
        Random rand = new Random();
        randomIntColor = rand.nextInt(7);
        //dropshadow sceneshape
        DropShadow dshr2 = new DropShadow();
        dshr2.setOffsetY(3.0f);
        dshr2.setColor(Color.color(0.4f, 0.4f, 0.4f));
        //dropshadow selection
        DropShadow dshr = new DropShadow();
        dshr.setOffsetY(3.0f);
        dshr.setColor(Color.color(0.9, 0.9, 0.5));
        dshr.setColor(Color.GREEN);
        //scene selection 
        BorderPane gridselectionhrs = new BorderPane();
        HBox selectionbox = new HBox();
        HBox selectionbox2 = new HBox();
        HBox selectionbox3 = new HBox();
        HBox titlebox = new HBox();
        Text Textselection = new Text("Welcome to the Land of Shapes and Color");
        Textselection.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        Textselection.setFill(Color.CORAL);
        //pictures for selection
        Button learningshapebtn = new Button();
        Button examshapebtn = new Button();
        Button shapemainmenu = new Button();
        Image imagehomemenu = new Image("home.jpg");
        shapemainmenu.setGraphic(new ImageView(imagehomemenu));

        learningshapebtn.setEffect(dshr);
        examshapebtn.setEffect(dshr);
        Image imageDecline2 = new Image("learningbtnshape.png");
        Image imageDecline3 = new Image("testbtn2.jpg");
        learningshapebtn.setGraphic(new ImageView(imageDecline2));
        examshapebtn.setGraphic(new ImageView(imageDecline3));
        titlebox.getChildren().add(Textselection);
        selectionbox.getChildren().add(learningshapebtn);
        selectionbox.setPadding(new Insets(40));
        selectionbox2.setPadding(new Insets(40));
        selectionbox2.getChildren().add(examshapebtn);
        selectionbox2.setPadding(new Insets(20));
        selectionbox3.setPadding(new Insets(40));
        selectionbox3.getChildren().add(shapemainmenu);
        selectionbox3.setAlignment(Pos.BOTTOM_CENTER);
        selectionbox3.setPadding(new Insets(20));
        gridselectionhrs.setPadding(new Insets(55));
        gridselectionhrs.setTop(titlebox);
        gridselectionhrs.setBottom(shapemainmenu);
        gridselectionhrs.setLeft(selectionbox);
        gridselectionhrs.setRight(examshapebtn);
        Scene Selectionshape = new Scene(gridselectionhrs, 1000, 650);

        //test scene 
        Image imageDecline4 = new Image("testbtn2.jpg");
        Button examshapebtn4 = new Button();
        Label tittleexam = new Label("Quiz is Alive");
        tittleexam.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 40));
        tittleexam.setTextFill(Color.PEACHPUFF);
        examshapebtn4.setGraphic(new ImageView(imageDecline4));
        //color options 
        ComboBox<String> coloroptions = new ComboBox<String>();
        coloroptions.getItems().addAll(
                "CYAN", "BLUE", "WHITE", "RED", "GREEN", "YELLOW", "MAGENTA"
        );

        ComboBox<String> shapeoptions = new ComboBox<String>();
        shapeoptions.getItems().addAll(
                "SQUARE", "ELLIPSE", "POLYGON"
        );

        HBox boxcolorwshape = new HBox();
        boxcolorwshape.getChildren().addAll(coloroptions, shapeoptions);

        //correctimage
        Button correctbutton = new Button("Check Answer ");
        VBox combobox1 = new VBox();
        combobox1.getChildren().add(coloroptions);
        VBox combobox2 = new VBox();
        combobox2.getChildren().add(shapeoptions);
        GridPane panecorrect = new GridPane();
        panecorrect.add(correctbutton, 4, 1);
        //selections for shapes and color
        VBox selBoxWrapper = new VBox();
        HBox selectionboxhrs = new HBox();
        selectionboxhrs.getChildren().addAll(combobox1);
        selectionboxhrs.getChildren().addAll(combobox2);
        selectionboxhrs.setPadding(new Insets(20, 20, 20, 20));
        selectionboxhrs.setSpacing(10);
        selectionboxhrs.setAlignment(Pos.TOP_CENTER);
        BorderPane paneexamhrs = new BorderPane();
        BorderPane.setAlignment(combobox1, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(tittleexam, Pos.CENTER);

        //setting shapes
        BorderPane.setAlignment(selectionboxhrs, Pos.TOP_CENTER);

        //scene shapes
        FlowPane fpf = new FlowPane();
        HBox hboxf = new HBox();
        RadioButton rbSquare = new RadioButton("Square");
        RadioButton rbEllipse = new RadioButton("Ellipse");
        RadioButton rbhexagon = new RadioButton("Hexagon");

        CheckBox colorgreen = new CheckBox("");
        colorgreen.setStyle("-fx-background-color: GREEN");

        CheckBox colorblue = new CheckBox("");
        colorblue.setStyle("-fx-background-color: BLUE");

        CheckBox colorred = new CheckBox("");
        colorred.setStyle("-fx-background-color: RED");
        Text wfhrs = new Text(10, 20, "Shapes and Color Mixer");

        Text wfhrS2 = new Text();
        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        wfhrs.setFill(Color.PEACHPUFF);

        HBox boxhrs = new HBox();
        boxhrs.setPadding(new Insets(40, 10, 10, 10));
        boxhrs.getChildren().addAll(wfhrS2, wfhrs);
        HBox overallbox = new HBox();
        overallbox.setAlignment(Pos.TOP_CENTER);
        overallbox.getChildren().addAll(boxhrs);

        final ToggleGroup tg = new ToggleGroup();
        rbSquare.setToggleGroup(tg);
        rbEllipse.setToggleGroup(tg);
        rbhexagon.setToggleGroup(tg);

        rbhexagon.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        rbSquare.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        rbEllipse.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));

        fpf.setAlignment(Pos.CENTER);
        CheckBox cbFill = new CheckBox("Fill");
        Rectangle square = new Rectangle(80, 80, 200, 200);
        Ellipse ellipse = new Ellipse(90, 90, 150, 150);

        Polygon polygonhrsc = new Polygon();
        polygonhrsc.getPoints().addAll(new Double[]{
            200.0, 50.0,
            400.0, 50.0,
            450.0, 150.0,
            400.0, 250.0,
            200.0, 250.0,
            150.0, 150.0,});

        square.setFill(Color.WHITE);
        square.setStroke(Color.BLACK);
        square.setStrokeWidth(2);

        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(2);

        polygonhrsc.setStrokeWidth(2);
        polygonhrsc.setStroke(Color.BLACK);
        polygonhrsc.setFill(Color.WHITE);

        fpf.setMinSize(250, 250);

        final EventHandler<ActionEvent> drawShape = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (colorred.isSelected() && colorgreen.isSelected() && colorblue.isSelected()) {
                    polygonhrsc.setFill(Color.WHITE);
                    ellipse.setFill(Color.WHITE);
                    square.setFill(Color.WHITE);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("WHITE ");
                    wfhrS2.setFill(Color.WHITE);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    if (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorred.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        polygonhrsc.setStrokeWidth(2);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setFill(Color.WHITE);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }
                } else if (colorblue.isSelected() && colorred.isSelected()) {

                    square.setFill(Color.MAGENTA);
                    polygonhrsc.setFill(Color.MAGENTA);
                    ellipse.setFill(Color.MAGENTA);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("MAGENTA ");
                    wfhrS2.setFill(Color.MAGENTA);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    while (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorred.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }
                } else if (colorred.isSelected() && colorgreen.isSelected()) {
                    polygonhrsc.setFill(Color.YELLOW);
                    ellipse.setFill(Color.YELLOW);
                    square.setFill(Color.YELLOW);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("YELLOW ");
                    wfhrS2.setFill(Color.YELLOW);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    if (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorred.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }

                } else if (colorblue.isSelected() && colorgreen.isSelected()) {
                    square.setFill(Color.CYAN);
                    polygonhrsc.setFill(Color.CYAN);
                    ellipse.setFill(Color.CYAN);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("CYAN ");
                    wfhrS2.setFill(Color.CYAN);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    if (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorred.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }

                } else if (colorred.isSelected()) {
                    square.setFill(Color.RED);
                    polygonhrsc.setFill(Color.RED);
                    ellipse.setFill(Color.RED);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("RED ");
                    wfhrS2.setFill(Color.RED);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));

                    if (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorred.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }

                } else if (colorgreen.isSelected()) {
                    square.setFill(Color.GREEN);
                    polygonhrsc.setFill(Color.GREEN);
                    ellipse.setFill(Color.GREEN);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("GREEN ");
                    wfhrS2.setFill(Color.GREEN);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    if (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorgreen.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }
                } else if (colorblue.isSelected()) {
                    square.setFill(Color.BLUE);
                    polygonhrsc.setFill(Color.BLUE);
                    ellipse.setFill(Color.BLUE);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    wfhrS2.setText("BLUE ");
                    wfhrS2.setFill(Color.BLUE);
                    wfhrs.setText("");
                    wfhrS2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    if (tg.getSelectedToggle() == null) {

                        wfhrs.setText("Select a Shape first ");
                        wfhrS2.setText("");
                        colorblue.setSelected(false);

                        square.setFill(Color.WHITE);
                        square.setStroke(Color.BLACK);
                        square.setStrokeWidth(2);

                        polygonhrsc.setFill(Color.WHITE);
                        polygonhrsc.setStroke(Color.BLACK);
                        polygonhrsc.setStrokeWidth(2);

                        ellipse.setFill(Color.WHITE);
                        ellipse.setStroke(Color.BLACK);
                        ellipse.setStrokeWidth(2);

                        wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                        wfhrs.setFill(Color.PEACHPUFF);

                    }

                } else {
                    square.setFill(Color.WHITE);
                    square.setStroke(Color.BLACK);
                    square.setStrokeWidth(2);
                    square.setEffect(dshr2);
                    ellipse.setEffect(dshr2);
                    polygonhrsc.setEffect(dshr2);
                    polygonhrsc.setFill(Color.WHITE);
                    polygonhrsc.setStroke(Color.BLACK);
                    polygonhrsc.setStrokeWidth(2);

                    ellipse.setFill(Color.WHITE);
                    ellipse.setStroke(Color.BLACK);
                    ellipse.setStrokeWidth(2);

                    wfhrs.setText("Shapes and Color Mixer");
                    wfhrS2.setText("");
                    wfhrs.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
                    wfhrs.setFill(Color.PEACHPUFF);

                }
            }

        };

        rbSquare.setOnAction(e -> {
            fpf.getChildren().clear();
            fpf.getChildren().add(square);
        });
        rbEllipse.setOnAction(e -> {
            fpf.getChildren().clear();
            fpf.getChildren().add(ellipse);

        });

        rbhexagon.setOnAction(e -> {
            fpf.getChildren().clear();
            fpf.getChildren().add(polygonhrsc);

        });

        cbFill.setOnAction(drawShape);
        colorred.setOnAction(drawShape);
        colorgreen.setOnAction(drawShape);
        colorblue.setOnAction(drawShape);

        Image imageDecline = new Image("btnquiz.jpg");
        Button quiz = new Button();
        quiz.setGraphic(new ImageView(imageDecline));

        Image imagehomehrs = new Image("home.jpg");
        Button home = new Button("Selection Screen");
        HBox boxhrs1 = new HBox();
        boxhrs1.getChildren().addAll(home);
        home.setMinSize(130, 55);
        home.setStyle(" -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 16;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 3;");

        hboxf.getChildren().addAll(rbhexagon, rbSquare, rbEllipse, colorred, colorgreen, colorblue);

        hboxf.setPadding(new Insets(10, 10, 10, 10));
        hboxf.setSpacing(30);
        hboxf.setAlignment(Pos.CENTER);
        VBox vboxh = new VBox();
        vboxh.getChildren().addAll(fpf);
        HBox boxhrshome = new HBox();
        boxhrshome.getChildren().addAll(home);
        GridPane panehrs = new GridPane();
        panehrs.setAlignment(Pos.CENTER);
        panehrs.setPadding(new Insets(5, 5, 5, 5));
        overallbox.setAlignment(Pos.CENTER);
        boxhrshome.setAlignment(Pos.CENTER);
        hboxf.setAlignment(Pos.CENTER);
        vboxh.setAlignment(Pos.CENTER);
        panehrs.add(boxhrshome, 2, 0);
        panehrs.add(overallbox, 2, 1);
        panehrs.add(hboxf, 2, 2);
        panehrs.add(vboxh, 2, 3);

        Scene sceneshape = new Scene(panehrs, 1000, 650);

        //exam scene
        HBox questions = new HBox();
        VBox selBoxWrapper2 = new VBox();
        selBoxWrapper2.setPadding(new Insets(20, 20, 20, 20));
        questions.getChildren().addAll(randomshape());

        questions.setPadding(new Insets(15, 15, 15, 15));
        questions.setSpacing(10);
        questions.setAlignment(Pos.CENTER);
        selBoxWrapper2.getChildren().add(questions);
        correctbutton.setOnAction(e -> {
            String[] color = {"CYAN", "BLUE", "WHITE", "RED", "GREEN", "YELLOW", "MAGENTA"};
            String[] shapes = {"SQUARE", "ELLIPSE", "POLYGON"};
            if (coloroptions.getValue() == color[randomIntColor] && shapeoptions.getValue() == shapes[intrandomshape]) {
                tittleexam.setText("CORRECT ABSOULUTELY SUBLIME");
            } else {
                tittleexam.setText("Wrong Answer");
            }

        });

        Button generateRandom = new Button("Random Button");
        generateRandom.setOnAction(e -> {
            randomIntColor = rand.nextInt(7);
            questions.getChildren().clear();
            questions.getChildren().addAll(randomshape());
            tittleexam.setText("Quiz is Alive");

        });
        Button home2 = new Button("Selection Screen");
        HBox boxhrs2 = new HBox();
        boxhrs2.getChildren().addAll(home2);
        home2.setMinSize(130, 55);
        home2.setStyle(" -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 16;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 3;");

        selBoxWrapper.getChildren().addAll(boxhrs2, selectionboxhrs, correctbutton, generateRandom);
        selBoxWrapper.setPadding(new Insets(50, 50, 50, 50));
        selBoxWrapper.setAlignment(Pos.CENTER);
        paneexamhrs.setTop(tittleexam);
        paneexamhrs.setCenter(selBoxWrapper2);
        paneexamhrs.setBottom(selBoxWrapper);

        Scene sceneexamhrs = new Scene(paneexamhrs, 1000, 650);

        //Button for scenes 
        learningshapebtn.setOnAction(e -> primaryStage.setScene(sceneshape));
        examshapebtn.setOnAction(e -> primaryStage.setScene(sceneexamhrs));
        home.setOnAction(e -> primaryStage.setScene(Selectionshape));
        home2.setOnAction(e -> primaryStage.setScene(Selectionshape));

        //background Images 
        BackgroundImage shapeBI = new BackgroundImage(new Image("shapecolor1.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        panehrs.setBackground(new Background(shapeBI));

        BackgroundImage shsecBI = new BackgroundImage(new Image("Selectionbackgroundshape.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        gridselectionhrs.setBackground(new Background(shsecBI));

        BackgroundImage shexamBI = new BackgroundImage(new Image("exambackgroundshape.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        paneexamhrs.setBackground(new Background(shexamBI));

        mystage = primaryStage;

        BorderPane AlphabetPane1 = new BorderPane();
        Label Alphabettitle = new Label("Alphabet Game");
        HBox AlphabetHbox = new HBox();

        Alphabettitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        Alphabettitle.setStyle("-fx-text-fill: indigo");
        AlphabetHbox.getChildren().add(Alphabettitle);
        AlphabetHbox.setAlignment(Pos.TOP_CENTER);
        AlphabetPane1.setTop(AlphabetHbox);
        Button RevisionreturnMenuButton = new Button("Return to Main Menu");
        RevisionreturnMenuButton.setMinSize(150, 75);
        String RevisionreturnMenuButtondefault = " -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 16;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 3;";
        String hoveredmenubutton = "-fx-font-weight: bold;\n"
                + "-fx-background-color: #2196f3;\n"
                + "-fx-background-radius: 22;\n"
                + "-fx-font-size: 16;\n"
                + "-fx-text-fill: white;\n"
                + "-fx-border-color: #2196f3;\n"
                + "-fx-border-radius: 20;\n"
                + "-fx-border-width: 3 ;";
        RevisionreturnMenuButton.setStyle(RevisionreturnMenuButtondefault);
        RevisionreturnMenuButton.setOnMouseEntered(e -> RevisionreturnMenuButton.setStyle(hoveredmenubutton));
        RevisionreturnMenuButton.setOnMouseExited(e -> RevisionreturnMenuButton.setStyle(RevisionreturnMenuButtondefault));
        HBox AlphaReturnToMenu = new HBox();
        AlphaReturnToMenu.getChildren().add(RevisionreturnMenuButton);
        AlphaReturnToMenu.setAlignment(Pos.CENTER);
        AlphabetPane1.setBottom(AlphaReturnToMenu);

        HBox AlphaSelect = new HBox(70);
        AlphaSelect.setPadding(new Insets(50, 30, 50, 30));
        Button Revision = new Button("REVISION");
        Button Test = new Button("TEST");
        Revision.setShape(new Circle(1.5));
        Test.setShape(new Circle(1.5));
        Revision.setFont(Font.font("Tahoma", 48));
        Revision.setTextFill(Color.INDIGO);
        Revision.setStyle("-fx-border: 15px solid");
        Revision.setStyle("-fx-border-color: green");
        Revision.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        Revision.setPadding(new Insets(100, 100, 100, 100));
        Test.setFont(Font.font("Tahoma", 48));
        Test.setTextFill(Color.INDIGO);
        Test.setStyle("-fx-border: 15px solid");
        Test.setStyle("-fx-border-color: green");
        Test.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        Test.setPadding(new Insets(100, 100, 100, 100));
        AlphaSelect.getChildren().add(Revision);
        AlphaSelect.getChildren().add(Test);
        AlphaSelect.setAlignment(Pos.CENTER);
        AlphabetPane1.setCenter(AlphaSelect);

        //REVISION
        Revision.setOnAction(e -> {
            mystage.setScene(AlphaRevision);
        });

        BorderPane AlphabetPane2 = new BorderPane();
        GridPane RevisionGrid1 = new GridPane();
        RevisionGrid1.setPadding(new Insets(30, 30, 30, 30));
        RevisionGrid1.setHgap(4);
        RevisionGrid1.setVgap(4);
        HBox firstrowrevision = new HBox(5);
        HBox secondrowrevision = new HBox(5);
        HBox thirdrowrevision = new HBox(5);
        HBox fourthrowrevision = new HBox(5);
        //Initialising path of the media file, replace this with your file path   
        String path2 = "ABCsong.mp3";
        //Instantiating Media class  
        Media Revisionmedia = new Media(new File(path2).toURI().toString());
        //Instantiating MediaPlayer class   
        MediaPlayer RevisionMediaPlayer = new MediaPlayer(Revisionmedia);
        RevisionMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        //by setting this property to true, the audio will be played   
        Button PlayRevisionMusic = new Button("Play");
        Button PauseRevisionMusic = new Button("Pause");
        String DefaultRevisionStyle = "-fx-font-size: 25;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-padding: 10,10,10,10;\n"
                + "-fx-background-color:  darkgreen;\n"
                + "-fx-text-fill: orange;\n";
        String DefaultHoveredStyle = "-fx-font-size: 25;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-padding: 10,10,10,10;\n"
                + "-fx-background-color:  white;\n"
                + "-fx-text-fill: orange;\n";
        //Play Music
        PlayRevisionMusic.setStyle(DefaultRevisionStyle);
        PlayRevisionMusic.setOnMouseEntered(e -> PlayRevisionMusic.setStyle(DefaultHoveredStyle));
        PlayRevisionMusic.setOnMouseExited(e -> PlayRevisionMusic.setStyle(DefaultRevisionStyle));
        //Pause Music
        PauseRevisionMusic.setStyle(DefaultRevisionStyle);
        PauseRevisionMusic.setOnMouseEntered(e -> PauseRevisionMusic.setStyle(DefaultHoveredStyle));
        PauseRevisionMusic.setOnMouseExited(e -> PauseRevisionMusic.setStyle(DefaultRevisionStyle));

        PlayRevisionMusic.setOnAction(e -> {
            RevisionMediaPlayer.play();
            mediaPlayer.pause();
        });
        PauseRevisionMusic.setOnAction(e -> {
            RevisionMediaPlayer.pause();
        });

        FileInputStream streamA = new FileInputStream("1.png");
        Image imageA = new Image(streamA);
        ImageView viewA = new ImageView(imageA);
        viewA.setFitHeight(100);
        viewA.setFitWidth(100);
        viewA.setPreserveRatio(true);

        FileInputStream streamB = new FileInputStream("2.png");
        Image imageB = new Image(streamB);
        ImageView viewB = new ImageView(imageB);
        viewB.setFitHeight(100);
        viewB.setFitWidth(100);
        viewB.setPreserveRatio(true);

        FileInputStream streamC = new FileInputStream("3.png");
        Image imageC = new Image(streamC);
        ImageView viewC = new ImageView(imageC);
        viewC.setFitHeight(100);
        viewC.setFitWidth(100);
        viewC.setPreserveRatio(true);

        FileInputStream streamD = new FileInputStream("4.png");
        Image imageD = new Image(streamD);
        ImageView viewD = new ImageView(imageD);
        viewD.setFitHeight(100);
        viewD.setFitWidth(100);
        viewD.setPreserveRatio(true);

        FileInputStream streamE = new FileInputStream("5.png");
        Image imageE = new Image(streamE);
        ImageView viewE = new ImageView(imageE);
        viewE.setFitHeight(100);
        viewE.setFitWidth(100);
        viewE.setPreserveRatio(true);

        FileInputStream streamF = new FileInputStream("6.png");
        Image imageF = new Image(streamF);
        ImageView viewF = new ImageView(imageF);
        viewF.setFitHeight(100);
        viewF.setFitWidth(100);
        viewF.setPreserveRatio(true);

        FileInputStream streamG = new FileInputStream("7.png");
        Image imageG = new Image(streamG);
        ImageView viewG = new ImageView(imageG);
        viewG.setFitHeight(100);
        viewG.setFitWidth(100);
        viewG.setPreserveRatio(true);

        FileInputStream streamH = new FileInputStream("8.png");
        Image imageH = new Image(streamH);
        ImageView viewH = new ImageView(imageH);
        viewH.setFitHeight(100);
        viewH.setFitWidth(100);
        viewH.setPreserveRatio(true);

        FileInputStream streamI = new FileInputStream("9.png");
        Image imageI = new Image(streamI);
        ImageView viewI = new ImageView(imageI);
        viewI.setFitHeight(100);
        viewI.setFitWidth(100);
        viewI.setPreserveRatio(true);

        FileInputStream streamJ = new FileInputStream("10.png");
        Image imageJ = new Image(streamJ);
        ImageView viewJ = new ImageView(imageJ);
        viewJ.setFitHeight(100);
        viewJ.setFitWidth(100);
        viewJ.setPreserveRatio(true);

        FileInputStream streamK = new FileInputStream("11.png");
        Image imageK = new Image(streamK);
        ImageView viewK = new ImageView(imageK);
        viewK.setFitHeight(100);
        viewK.setFitWidth(100);
        viewK.setPreserveRatio(true);

        FileInputStream streamL = new FileInputStream("12.png");
        Image imageL = new Image(streamL);
        ImageView viewL = new ImageView(imageL);
        viewL.setFitHeight(100);
        viewL.setFitWidth(100);
        viewL.setPreserveRatio(true);

        FileInputStream streamM = new FileInputStream("13.png");
        Image imageM = new Image(streamM);
        ImageView viewM = new ImageView(imageM);
        viewM.setFitHeight(100);
        viewM.setFitWidth(100);
        viewM.setPreserveRatio(true);

        FileInputStream streamN = new FileInputStream("14.png");
        Image imageN = new Image(streamN);
        ImageView viewN = new ImageView(imageN);
        viewN.setFitHeight(100);
        viewN.setFitWidth(100);
        viewN.setPreserveRatio(true);

        FileInputStream streamO = new FileInputStream("15.png");
        Image imageO = new Image(streamO);
        ImageView viewO = new ImageView(imageO);
        viewO.setFitHeight(100);
        viewO.setFitWidth(100);
        viewO.setPreserveRatio(true);

        FileInputStream streamP = new FileInputStream("16.png");
        Image imageP = new Image(streamP);
        ImageView viewP = new ImageView(imageP);
        viewP.setFitHeight(100);
        viewP.setFitWidth(100);
        viewP.setPreserveRatio(true);

        FileInputStream streamQ = new FileInputStream("17.png");
        Image imageQ = new Image(streamQ);
        ImageView viewQ = new ImageView(imageQ);
        viewQ.setFitHeight(100);
        viewQ.setFitWidth(100);
        viewQ.setPreserveRatio(true);

        FileInputStream streamR = new FileInputStream("18.png");
        Image imageR = new Image(streamR);
        ImageView viewR = new ImageView(imageR);
        viewR.setFitHeight(100);
        viewR.setFitWidth(100);
        viewR.setPreserveRatio(true);

        FileInputStream streamS = new FileInputStream("19.png");
        Image imageS = new Image(streamS);
        ImageView viewS = new ImageView(imageS);
        viewS.setFitHeight(100);
        viewS.setFitWidth(100);
        viewS.setPreserveRatio(true);

        FileInputStream streamT = new FileInputStream("20.png");
        Image imageT = new Image(streamT);
        ImageView viewT = new ImageView(imageT);
        viewT.setFitHeight(100);
        viewT.setFitWidth(100);
        viewT.setPreserveRatio(true);

        FileInputStream streamU = new FileInputStream("21.png");
        Image imageU = new Image(streamU);
        ImageView viewU = new ImageView(imageU);
        viewU.setFitHeight(100);
        viewU.setFitWidth(100);
        viewU.setPreserveRatio(true);

        FileInputStream streamV = new FileInputStream("22.png");
        Image imageV = new Image(streamV);
        ImageView viewV = new ImageView(imageV);
        viewV.setFitHeight(100);
        viewV.setFitWidth(100);
        viewV.setPreserveRatio(true);

        FileInputStream streamW = new FileInputStream("23.png");
        Image imageW = new Image(streamW);
        ImageView viewW = new ImageView(imageW);
        viewW.setFitHeight(100);
        viewW.setFitWidth(100);
        viewW.setPreserveRatio(true);

        FileInputStream streamX = new FileInputStream("24.png");
        Image imageX = new Image(streamX);
        ImageView viewX = new ImageView(imageX);
        viewX.setFitHeight(100);
        viewX.setFitWidth(100);
        viewX.setPreserveRatio(true);

        FileInputStream streamY = new FileInputStream("25.png");
        Image imageY = new Image(streamY);
        ImageView viewY = new ImageView(imageY);
        viewY.setFitHeight(100);
        viewY.setFitWidth(100);

        FileInputStream streamZ = new FileInputStream("26.png");
        Image imageZ = new Image(streamZ);
        ImageView viewZ = new ImageView(imageZ);
        viewZ.setFitHeight(100);
        viewZ.setFitWidth(100);

        firstrowrevision.getChildren().addAll(viewA, viewB, viewC, viewD, viewE, viewF, viewG);
        secondrowrevision.getChildren().addAll(viewH, viewI, viewJ, viewK, viewL, viewM, viewN);
        thirdrowrevision.getChildren().addAll(viewO, viewP, viewQ, viewR, viewS, viewT, viewU);
        fourthrowrevision.getChildren().addAll(viewV, viewW, viewX, viewY, viewZ, PlayRevisionMusic,
                PauseRevisionMusic);

        RevisionGrid1.add(firstrowrevision, 0, 0);
        RevisionGrid1.add(secondrowrevision, 0, 1);
        RevisionGrid1.add(thirdrowrevision, 0, 2);
        RevisionGrid1.add(fourthrowrevision, 0, 3);

        AlphabetPane2.setCenter(RevisionGrid1);

        //Back Button for Revision
        Button BackfromPane2 = new Button("RETURN TO MAIN PAGE");
        BackfromPane2.setPadding(new Insets(20, 20, 20, 20));
        BackfromPane2.setOpacity(0.890);
        String BackfromPane2default = " -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 13;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 2;";
        String BackfromPane2Hovered = " -fx-font-weight: bold;\n"
                + "    -fx-background-color: #2196f3;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 13;\n"
                + "    -fx-text-fill: white;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 2;";
        BackfromPane2.setStyle(BackfromPane2default);
        BackfromPane2.setOnMouseEntered(e -> BackfromPane2.setStyle(BackfromPane2Hovered));
        BackfromPane2.setOnMouseExited(e -> BackfromPane2.setStyle(BackfromPane2default));
        BackfromPane2.setOnAction(e -> {
            mystage.setScene(AlphaScene1);
            mediaPlayer.play();
            RevisionMediaPlayer.pause();
        });
        HBox RevisionTitlehbox = new HBox();
        Label RevisionTitle = new Label("Revision");
        RevisionTitle.setStyle("-fx-text-fill: indigo");
        RevisionTitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        RevisionTitlehbox.getChildren().add(RevisionTitle);
        RevisionTitlehbox.setAlignment(Pos.TOP_CENTER);
        AlphabetPane2.setTop(RevisionTitlehbox);

        HBox Pane2Back = new HBox();
        Pane2Back.setPadding(new Insets(20, 20, 20, 10));
        Pane2Back.getChildren().add(BackfromPane2);
        Pane2Back.setAlignment(Pos.TOP_LEFT);
        AlphabetPane2.setLeft(Pane2Back);

        //TEST
        Test.setOnAction(e -> {
            mystage.setScene(AlphaTest);
        });
        BorderPane AlphabetPane3 = new BorderPane();

        FileInputStream streamA1 = new FileInputStream("1.png");
        Image imageA1 = new Image(streamA1);
        ImageView viewA1 = new ImageView(imageA1);
        viewA1.setFitHeight(80);
        viewA1.setFitWidth(80);
        viewA1.setPreserveRatio(true);

        FileInputStream streamB1 = new FileInputStream("2.png");
        Image imageB1 = new Image(streamB1);
        ImageView viewB1 = new ImageView(imageB1);
        viewB1.setFitHeight(80);
        viewB1.setFitWidth(80);
        viewB1.setPreserveRatio(true);

        FileInputStream streamC1 = new FileInputStream("3.png");
        Image imageC1 = new Image(streamC1);
        ImageView viewC1 = new ImageView(imageC1);
        viewC1.setFitHeight(80);
        viewC1.setFitWidth(80);
        viewC1.setPreserveRatio(true);

        FileInputStream streamD1 = new FileInputStream("4.png");
        Image imageD1 = new Image(streamD1);
        ImageView viewD1 = new ImageView(imageD1);
        viewD1.setFitHeight(80);
        viewD1.setFitWidth(80);
        viewD1.setPreserveRatio(true);

        VBox Question12 = new VBox(10);
        Question12.getChildren().add(ImageQuestion(viewA1, viewC1, "B"));
        Question12.getChildren().add(ImageQuestion(viewB1, viewD1, "C"));
        AlphabetPane3.setCenter(Question12);

        Button nextbutton = new Button("Next Page");
        nextbutton.setStyle("-fx-padding: 30px;\n"
                + "-fx-text-alignment: center;\n");

        nextbutton.setOnAction(e -> {
            mystage.setScene(AlphaTest1);
        });
        HBox NextHbox = new HBox(5);
        NextHbox.setAlignment(Pos.BOTTOM_RIGHT);
        NextHbox.getChildren().add(nextbutton);
        AlphabetPane3.setBottom(NextHbox);

        BorderPane AlphabetPane31 = new BorderPane();
        Button previousbutton = new Button("Previous Page");
        previousbutton.setStyle("-fx-padding: 30px;\n"
                + "-fx-text-alignment: center;\n");
        previousbutton.setOnAction(e -> {
            mystage.setScene(AlphaTest);
        });
        HBox PreviousHbox = new HBox(5);
        PreviousHbox.getChildren().add(previousbutton);
        AlphabetPane31.setBottom(PreviousHbox);

        FileInputStream streamH1 = new FileInputStream("8.png");
        Image imageH1 = new Image(streamH1);
        ImageView viewH1 = new ImageView(imageH1);
        viewH1.setFitHeight(80);
        viewH1.setFitWidth(80);
        viewH1.setPreserveRatio(true);

        FileInputStream streamI1 = new FileInputStream("9.png");
        Image imageI1 = new Image(streamI1);
        ImageView viewI1 = new ImageView(imageI1);
        viewI1.setFitHeight(80);
        viewI1.setFitWidth(80);
        viewI1.setPreserveRatio(true);

        FileInputStream streamJ1 = new FileInputStream("10.png");
        Image imageJ1 = new Image(streamJ1);
        ImageView viewJ1 = new ImageView(imageJ1);
        viewJ1.setFitHeight(80);
        viewJ1.setFitWidth(80);
        viewJ1.setPreserveRatio(true);

        FileInputStream streamK1 = new FileInputStream("11.png");
        Image imageK1 = new Image(streamK1);
        ImageView viewK1 = new ImageView(imageK1);
        viewK1.setFitHeight(80);
        viewK1.setFitWidth(80);
        viewK1.setPreserveRatio(true);

        VBox Question34 = new VBox(10);
        Question34.getChildren().add(ImageQuestion(viewH1, viewJ1, "I"));
        Question34.getChildren().add(ImageQuestion(viewI1, viewK1, "J"));
        AlphabetPane31.setCenter(Question34);

        //Back Button for Test
        Button BackfromPane3 = new Button("RETURN TO MAIN PAGE");
        BackfromPane3.setPadding(new Insets(20, 20, 20, 20));
        BackfromPane3.setOpacity(0.890);
        BackfromPane3.setOnAction(e -> {
            mystage.setScene(AlphaScene1);
        });
        String BackfromPane3default = " -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 13;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 2;";
        String BackfromPane3Hovered = " -fx-font-weight: bold;\n"
                + "    -fx-background-color: #2196f3;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 13;\n"
                + "    -fx-text-fill: white;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 2;";
        BackfromPane3.setStyle(BackfromPane3default);
        BackfromPane3.setOnMouseEntered(e -> BackfromPane3.setStyle(BackfromPane2Hovered));
        BackfromPane3.setOnMouseExited(e -> BackfromPane3.setStyle(BackfromPane2default));
        BackfromPane3.setOnAction(e -> {
            mystage.setScene(AlphaScene1);
            RevisionMediaPlayer.pause();
        });

        Button BackfromPane31 = new Button("RETURN TO MAIN PAGE");
        BackfromPane31.setPadding(new Insets(20, 20, 20, 20));
        BackfromPane31.setOpacity(0.890);
        BackfromPane31.setOnAction(e -> {
            mystage.setScene(AlphaScene1);
        });
        BackfromPane31.setStyle(BackfromPane3default);
        BackfromPane31.setOnMouseEntered(e -> BackfromPane31.setStyle(BackfromPane2Hovered));
        BackfromPane31.setOnMouseExited(e -> BackfromPane31.setStyle(BackfromPane2default));
        BackfromPane31.setOnAction(e -> {
            mystage.setScene(AlphaScene1);
            RevisionMediaPlayer.pause();
        });
        HBox TestTitlehbox = new HBox();
        Label TestTitle = new Label("Test");
        TestTitle.setStyle("-fx-text-fill: indigo");
        TestTitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        TestTitlehbox.getChildren().add(TestTitle);
        TestTitlehbox.setAlignment(Pos.TOP_CENTER);
        AlphabetPane3.setTop(TestTitlehbox);

        HBox TestTitlehbox2 = new HBox();
        Label TestTitle2 = new Label("Test");
        TestTitle2.setStyle("-fx-text-fill: indigo");
        TestTitle2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        TestTitlehbox2.getChildren().add(TestTitle2);
        TestTitlehbox2.setAlignment(Pos.TOP_CENTER);
        AlphabetPane31.setTop(TestTitlehbox2);

        HBox Pane3Back = new HBox();
        Pane3Back.setPadding(new Insets(20, 20, 20, 20));
        Pane3Back.setAlignment(Pos.TOP_LEFT);
        Pane3Back.getChildren().add(BackfromPane3);
        AlphabetPane3.setLeft(Pane3Back);

        HBox Pane31Back = new HBox();
        Pane31Back.setPadding(new Insets(20, 20, 20, 20));
        Pane31Back.setAlignment(Pos.TOP_LEFT);
        Pane31Back.getChildren().add(BackfromPane31);
        AlphabetPane31.setLeft(Pane31Back);

        //Background
        FileInputStream AlphabetStream = new FileInputStream("wallpaper.jpg");
        Image AlphabetImage = new Image(AlphabetStream);
        BackgroundImage AlphabetBackgroundImage = new BackgroundImage(AlphabetImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background AlphabetBackground = new Background(AlphabetBackgroundImage);
        AlphabetPane1.setBackground(AlphabetBackground);
        AlphabetPane2.setBackground(AlphabetBackground);
        AlphabetPane3.setBackground(AlphabetBackground);
        AlphabetPane31.setBackground(AlphabetBackground);

        //BaseScene
        AlphaScene1 = new Scene(AlphabetPane1, 1000, 650);
        AlphaRevision = new Scene(AlphabetPane2, 1000, 650);
        AlphaTest = new Scene(AlphabetPane3, 1000, 650);
        AlphaTest1 = new Scene(AlphabetPane31, 1000, 650);

        BorderPane fs = new BorderPane();
        fs.setPadding(new Insets(100, 30, 30, 20));

        FileInputStream learnlogoflag1 = new FileInputStream("f12.png");
        Image learnlogoflag11 = new Image(learnlogoflag1);
        ImageView learnlogoflag111 = new ImageView(learnlogoflag11);
        learnlogoflag111.setFitHeight(150);
        learnlogoflag111.setFitWidth(150);
        learnlogoflag111.setPreserveRatio(true);
        Button learnbtn = new Button("\n Learn");
        learnbtn.setStyle("-fx-font-weight: bold; -fx-background-color:transparent;");
        learnbtn.setGraphic(learnlogoflag111);

        FileInputStream learnlogoflag2 = new FileInputStream("f13.png");
        Image learnlogoflag22 = new Image(learnlogoflag2);
        ImageView learnlogoflag222 = new ImageView(learnlogoflag22);
        learnlogoflag222.setFitHeight(150);
        learnlogoflag222.setFitWidth(150);
        learnlogoflag222.setPreserveRatio(true);
        Button gamebtn = new Button("Game");
        gamebtn.setStyle("-fx-font-weight: bold;\n -fx-background-color:transparent;");
        gamebtn.setGraphic(learnlogoflag222);

        Label flagTitle = new Label("Geography Game");
        flagTitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        flagTitle.setStyle("-fx-text-fill: indigo");

        HBox flagTop = new HBox();
        flagTop.getChildren().add(flagTitle);
        flagTop.setAlignment(Pos.CENTER);

        Button flagToSelection = new Button("Return to Main Menu");
        flagToSelection.setStyle(" -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 16;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 3;");

        HBox flagBottom = new HBox();
        flagBottom.getChildren().add(flagToSelection);
        flagBottom.setAlignment(Pos.CENTER);

        HBox selectionhbox = new HBox();
        selectionhbox.setPadding(new Insets(20, 20, 20, 10));
        selectionhbox.setSpacing(50);
        selectionhbox.getChildren().add(learnbtn);
        selectionhbox.getChildren().add(gamebtn);
        selectionhbox.setAlignment(Pos.CENTER);

        Scene flagscene = new Scene(fs, 1000, 650); //length & height

        fs.setTop(flagTop);
        fs.setCenter(selectionhbox);
        fs.setBottom(flagBottom);
        //End of Selection Scene

        //Learning Scene
        FileInputStream backimage0 = new FileInputStream("flagback.png");
        Image backimage00 = new Image(backimage0);
        ImageView backimage000 = new ImageView(backimage00);
        backimage000.setFitHeight(100);
        backimage000.setFitWidth(100);
        backimage000.setPreserveRatio(true);
        Button flbackbtn = new Button("");
        flbackbtn.setGraphic(backimage000);
        flbackbtn.setStyle("-fx-background-color: transparent;");

        BorderPane fls = new BorderPane();
        fls.setPadding(new Insets(30, 30, 30, 20));

        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(15);
        gridPane2.setVgap(15);

        Scene flaglearnscene = new Scene(fls, 1000, 650); //set length and heights of learning scene

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(10, 10, 10, 10));

        //Malaysia Flag
        FileInputStream imagemy = new FileInputStream("Malaysia.png");
        Image my = new Image(imagemy);
        ImageView imageView = new ImageView(my);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        Label myflag = new Label("Malaysia");
        myflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView, 1, 0);
        gridPane2.add(myflag, 1, 1);

        //SG Flag
        FileInputStream imagesg = new FileInputStream("Singapore.png");
        Image sg = new Image(imagesg);
        ImageView imageView2 = new ImageView(sg);
        imageView2.setFitHeight(200);
        imageView2.setFitWidth(200);
        imageView2.setPreserveRatio(true);
        Label sgflag = new Label("Singapore");
        sgflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView2, 2, 0);
        gridPane2.add(sgflag, 2, 1);

        //Indonesia Flag
        FileInputStream imageindo = new FileInputStream("Indonesia.png");
        Image indo = new Image(imageindo);
        ImageView imageView3 = new ImageView(indo);
        imageView3.setFitHeight(200);
        imageView3.setFitWidth(200);
        imageView3.setPreserveRatio(true);
        Label indoflag = new Label("Indonesia");
        indoflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView3, 3, 0);
        gridPane2.add(indoflag, 3, 1);

        //Vietnam Flag
        FileInputStream imagevietnam = new FileInputStream("Vietnam.png");
        Image vietnam = new Image(imagevietnam);
        ImageView imageView4 = new ImageView(vietnam);
        imageView4.setFitHeight(200);
        imageView4.setFitWidth(200);
        imageView4.setPreserveRatio(true);
        Label vietflag = new Label("Vietnam");
        vietflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView4, 4, 0);
        gridPane2.add(vietflag, 4, 1);

        //Philippines Flag
        FileInputStream imagephil = new FileInputStream("Philippines.png");
        Image phil = new Image(imagephil);
        ImageView imageView6 = new ImageView(phil);
        imageView6.setFitHeight(200);
        imageView6.setFitWidth(200);
        imageView6.setPreserveRatio(true);
        Label pflag = new Label("Philippines");
        pflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView6, 1, 2);
        gridPane2.add(pflag, 1, 3);

        //Japan Flag
        FileInputStream imagejapan = new FileInputStream("Japan.png");
        Image japan = new Image(imagejapan);
        ImageView imageView7 = new ImageView(japan);
        imageView7.setFitHeight(200);
        imageView7.setFitWidth(200);
        imageView7.setPreserveRatio(true);
        Label japanflag = new Label("Japan");
        japanflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView7, 2, 2);
        gridPane2.add(japanflag, 2, 3);

        //Korea Flag
        FileInputStream imagekorea = new FileInputStream("Korea.png");
        Image korea = new Image(imagekorea);
        ImageView imageView8 = new ImageView(korea);
        imageView8.setFitHeight(200);
        imageView8.setFitWidth(200);
        imageView8.setPreserveRatio(true);
        Label koreaflag = new Label("Korea");
        koreaflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView8, 3, 2);
        gridPane2.add(koreaflag, 3, 3);

        //US Flag
        FileInputStream imageus = new FileInputStream("US.png");
        Image us = new Image(imageus);
        ImageView imageView9 = new ImageView(us);
        imageView9.setFitHeight(200);
        imageView9.setFitWidth(200);
        imageView9.setPreserveRatio(true);
        Label usflag = new Label("United States");
        usflag.setStyle("-fx-text-fill:black; -fx-font-weight: bold;");
        gridPane2.add(imageView9, 4, 2);
        gridPane2.add(usflag, 4, 3);

        gridPane2.add(flbackbtn, 3, 10);
        VBox rts = new VBox();
        rts.getChildren().add(flbackbtn);
        rts.setAlignment(Pos.TOP_LEFT);
        fls.setTop(rts);

        fls.setCenter(gridPane2);

        gridPane2.setAlignment(Pos.CENTER);
        //end of learning scene

        //Game Scene 1
        FileInputStream backimage1 = new FileInputStream("flagback.png");
        Image backimage11 = new Image(backimage1);
        ImageView backimage111 = new ImageView(backimage11);
        backimage111.setFitHeight(100);
        backimage111.setFitWidth(100);
        backimage111.setPreserveRatio(true);
        Button fgbackbtn1 = new Button("");
        fgbackbtn1.setGraphic(backimage111);
        fgbackbtn1.setStyle("-fx-background-color: transparent;");

        Label flagquestion1 = new Label("What flag is this?");
        flagquestion1.setStyle("-fx-font-size:50px;");

        Label flagcorrect1 = new Label("Correct!");
        flagcorrect1.setStyle("-fx-font-size:30px; -fx-text-fill: green;");

        Label flagwrong1 = new Label("Wrong, try again.");
        flagwrong1.setStyle("-fx-font-size:30px; -fx-text-fill: red;");

        FileInputStream boximage1 = new FileInputStream("blue.png");
        Image boximage11 = new Image(boximage1);
        ImageView boximage111 = new ImageView(boximage11);
        boximage111.setFitHeight(100);
        boximage111.setFitWidth(300);
        boximage111.setPreserveRatio(true);

        Button flagbutton11 = new Button("United States");
        flagbutton11.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton12 = new Button("Malaysia");
        flagbutton12.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton13 = new Button("Indonesia");
        flagbutton13.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton14 = new Button("Singapore");
        flagbutton14.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        FileInputStream game1us = new FileInputStream("US.png");
        Image gameflag1 = new Image(game1us);

        //Next Button
        FileInputStream nextimage1 = new FileInputStream("flagnext.png");
        Image nextimage11 = new Image(nextimage1);
        ImageView nextimage111 = new ImageView(nextimage11);
        nextimage111.setFitHeight(100);
        nextimage111.setFitWidth(100);
        nextimage111.setPreserveRatio(true);

        Button flagnext1 = new Button();
        flagnext1.setGraphic(nextimage111);
        flagnext1.setStyle("-fx-background-color: transparent;");

        BorderPane gameq1 = new BorderPane();
        gameq1.setPadding(new Insets(30, 30, 150, 20));

        //Display Flag & Questions
        VBox displayFlag = new VBox();
        displayFlag.getChildren().add(new ImageView(gameflag1));
        displayFlag.getChildren().add(flagquestion1);

        //Display correct or false message
        displayFlag.getChildren().add(flagcorrect1);

        flagcorrect1.setVisible(false);
        displayFlag.getChildren().add(flagwrong1);
        flagwrong1.setVisible(false);
        displayFlag.setAlignment(Pos.CENTER);

        //Display Buttons
        GridPane gridPane3 = new GridPane();
        gridPane3.setHgap(15);
        gridPane3.setVgap(15);
        gridPane3.add(flagbutton11, 0, 0);
        gridPane3.add(flagbutton12, 1, 0);
        gridPane3.add(flagbutton13, 0, 1);
        gridPane3.add(flagbutton14, 1, 1);
        gridPane3.setAlignment(Pos.CENTER);

        //Scene Name
        Scene flaggamescene = new Scene(gameq1, 1000, 650); //set length and heights of learning scene, fgs=flag game scene

        //Button back to selection page
        VBox gbs1 = new VBox(); //gbs = game button scene
        gbs1.getChildren().add(fgbackbtn1);
        gbs1.setAlignment(Pos.TOP_LEFT);

        //Button to next question
        VBox ngs = new VBox();
        ngs.getChildren().add(flagnext1);
        flagnext1.setVisible(false);
        ngs.setAlignment(Pos.BOTTOM_RIGHT);

        gameq1.setLeft(gbs1);
        gameq1.setCenter(displayFlag);
        gameq1.setBottom(gridPane3);
        gameq1.setRight(ngs);
        //End of game scene 1====================================================

        //Game Scene 2============================================================
        FileInputStream backimage2 = new FileInputStream("flagback.png");
        Image backimage21 = new Image(backimage2);
        ImageView backimage221 = new ImageView(backimage21);
        backimage221.setFitHeight(100);
        backimage221.setFitWidth(100);
        backimage221.setPreserveRatio(true);
        Button fgbackbtn2 = new Button("");
        fgbackbtn2.setGraphic(backimage221);
        fgbackbtn2.setStyle("-fx-background-color: transparent;");

        Label flagquestion2 = new Label("What flag is this?");
        flagquestion2.setStyle("-fx-font-size:50px;");

        Label flagcorrect2 = new Label("Correct!");
        flagcorrect2.setStyle("-fx-font-size:30px; -fx-text-fill: green;");

        Label flagwrong2 = new Label("Wrong, try again.");
        flagwrong2.setStyle("-fx-font-size:30px; -fx-text-fill: red;");

        Button flagbutton21 = new Button("Vietnam");
        flagbutton21.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton22 = new Button("Korea");
        flagbutton22.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton23 = new Button("Malaysia");
        flagbutton23.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton24 = new Button("United States");
        flagbutton24.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        FileInputStream game2my = new FileInputStream("Malaysia.png");
        Image gameflag2 = new Image(game2my);

        FileInputStream nextimage2 = new FileInputStream("flagnext.png");
        Image nextimage21 = new Image(nextimage2);
        ImageView nextimage221 = new ImageView(nextimage21);
        nextimage221.setFitHeight(100);
        nextimage221.setFitWidth(100);
        nextimage221.setPreserveRatio(true);

        Button flagnext2 = new Button();
        flagnext2.setGraphic(nextimage221);
        flagnext2.setStyle("-fx-background-color: transparent;");

        //Button back to main menu
        BorderPane gameq2 = new BorderPane();

        gameq2.setPadding(new Insets(30, 30, 150, 20));

        //Display Questions and Flag
        VBox displayFlag2 = new VBox();
        displayFlag2.getChildren().add(new ImageView(gameflag2));
        displayFlag2.getChildren().add(flagquestion2);
        displayFlag2.setAlignment(Pos.CENTER);

        //Display Right or Wrong
        displayFlag2.getChildren().add(flagcorrect2);
        flagcorrect2.setVisible(false);
        displayFlag2.getChildren().add(flagwrong2);
        flagwrong2.setVisible(false);
        displayFlag2.setAlignment(Pos.CENTER);

        //Button to next question
        VBox ngs2 = new VBox();
        ngs2.getChildren().add(flagnext2);
        flagnext2.setVisible(false);
        ngs2.setAlignment(Pos.BOTTOM_RIGHT);

        //Scene name
        Scene flaggamescene2 = new Scene(gameq2, 1000, 650);

        VBox gbs2 = new VBox(); //gbs = game button scene
        gbs2.getChildren().add(fgbackbtn2);
        gbs2.setAlignment(Pos.TOP_LEFT);

        GridPane gridpaneq2 = new GridPane();
        gridpaneq2.setVgap(15);
        gridpaneq2.setHgap(15);
        gridpaneq2.add(flagbutton21, 0, 0);
        gridpaneq2.add(flagbutton22, 1, 0);
        gridpaneq2.add(flagbutton23, 0, 1);
        gridpaneq2.add(flagbutton24, 1, 1);
        gridpaneq2.setAlignment(Pos.CENTER);

        gameq2.setLeft(gbs2);
        gameq2.setCenter(displayFlag2);
        gameq2.setBottom(gridpaneq2);
        gameq2.setRight(ngs2);
        //End of Game Scene 2

        //Game Scene 3 =============================================================================================
        BorderPane gameq3 = new BorderPane();
        gameq3.setPadding(new Insets(30, 30, 150, 20));

        //Button back to main menu
        FileInputStream backimage3 = new FileInputStream("flagback.png");
        Image backimage31 = new Image(backimage3);
        ImageView backimage331 = new ImageView(backimage31);
        backimage331.setFitHeight(100);
        backimage331.setFitWidth(100);
        backimage331.setPreserveRatio(true);
        Button fgbackbtn3 = new Button("");
        fgbackbtn3.setGraphic(backimage331);
        fgbackbtn3.setStyle("-fx-background-color: transparent;");

        // flag
        FileInputStream game3korea = new FileInputStream("Korea.png");
        Image gameflag3 = new Image(game3korea);

        //4 answers
        Button flagbutton31 = new Button("United States");
        flagbutton31.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton32 = new Button("Japan");
        flagbutton32.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton33 = new Button("Indonesia");
        flagbutton33.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton34 = new Button("Korea");
        flagbutton34.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        //next button
        FileInputStream nextimage3 = new FileInputStream("flagnext.png");
        Image nextimage31 = new Image(nextimage3);
        ImageView nextimage331 = new ImageView(nextimage31);
        nextimage331.setFitHeight(100);
        nextimage331.setFitWidth(100);
        nextimage331.setPreserveRatio(true);
        Button flagnext3 = new Button();
        flagnext3.setGraphic(nextimage331);
        flagnext3.setStyle("-fx-background-color: transparent;");

        //Scene
        Scene flaggamescene3 = new Scene(gameq3, 1000, 650);

        //Labels 
        Label flagquestion3 = new Label("What flag is this?");
        flagquestion3.setStyle("-fx-font-size:50px;");

        Label flagcorrect3 = new Label("Correct!");
        flagcorrect3.setStyle("-fx-font-size:30px; -fx-text-fill: green;");

        Label flagwrong3 = new Label("Wrong, try again.");
        flagwrong3.setStyle("-fx-font-size:30px; -fx-text-fill: red;");

        //Display Questions and Flag
        VBox displayFlag3 = new VBox();
        displayFlag3.getChildren().add(new ImageView(gameflag3));
        displayFlag3.getChildren().add(flagquestion3);
        displayFlag3.setAlignment(Pos.CENTER);

        //Display Right or Wrong
        displayFlag3.getChildren().add(flagcorrect3);
        flagcorrect3.setVisible(false);
        displayFlag3.getChildren().add(flagwrong3);
        flagwrong3.setVisible(false);
        displayFlag3.setAlignment(Pos.CENTER);

        //Button to next question
        VBox ngs3 = new VBox();
        ngs3.getChildren().add(flagnext3);
        flagnext3.setVisible(false);
        ngs3.setAlignment(Pos.BOTTOM_RIGHT);

        //Button to main menu
        VBox gbs3 = new VBox(); //gbs = game button scene
        gbs3.getChildren().add(fgbackbtn3);
        gbs3.setAlignment(Pos.TOP_LEFT);

        GridPane gridpaneq3 = new GridPane();
        gridpaneq3.setVgap(15);
        gridpaneq3.setHgap(15);
        gridpaneq3.add(flagbutton31, 0, 0);
        gridpaneq3.add(flagbutton32, 1, 0);
        gridpaneq3.add(flagbutton33, 0, 1);
        gridpaneq3.add(flagbutton34, 1, 1);
        gridpaneq3.setAlignment(Pos.CENTER);

        gameq3.setLeft(gbs3);
        gameq3.setCenter(displayFlag3);
        gameq3.setBottom(gridpaneq3);
        gameq3.setRight(ngs3);
        //End of game 3

        //Game Scene 4 =============================================================================================
        BorderPane gameq4 = new BorderPane();
        gameq4.setPadding(new Insets(30, 30, 150, 20));

        //Button back to main menu
        FileInputStream backimage4 = new FileInputStream("flagback.png");
        Image backimage41 = new Image(backimage4);
        ImageView backimage441 = new ImageView(backimage41);
        backimage441.setFitHeight(100);
        backimage441.setFitWidth(100);
        backimage441.setPreserveRatio(true);
        Button fgbackbtn4 = new Button("");
        fgbackbtn4.setGraphic(backimage441);
        fgbackbtn4.setStyle("-fx-background-color: transparent;");

        // flag
        FileInputStream game4japan = new FileInputStream("Japan.png");
        Image gameflag4 = new Image(game4japan);

        //4 answers
        Button flagbutton41 = new Button("Malaysia");
        flagbutton41.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton42 = new Button("Japan");
        flagbutton42.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton43 = new Button("Singapore");
        flagbutton43.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        Button flagbutton44 = new Button("Philippines");
        flagbutton44.setStyle("-fx-background-color: cyan; -fx-pref-width: 120px; -fx-pref-height: 25px; -fx-border-color:black;");

        //next button
        FileInputStream nextimage4 = new FileInputStream("flagnext.png");
        Image nextimage41 = new Image(nextimage4);
        ImageView nextimage441 = new ImageView(nextimage41);
        nextimage441.setFitHeight(100);
        nextimage441.setFitWidth(100);
        nextimage441.setPreserveRatio(true);
        Button flagnext4 = new Button();
        flagnext4.setGraphic(nextimage441);
        flagnext4.setStyle("-fx-background-color: transparent;");

        //Scene
        Scene flaggamescene4 = new Scene(gameq4, 1000, 650);

        //Labels 
        Label flagquestion4 = new Label("What flag is this?");
        flagquestion4.setStyle("-fx-font-size:50px;");

        Label flagcorrect4 = new Label("Correct!");
        flagcorrect4.setStyle("-fx-font-size:30px; -fx-text-fill: green;");

        Label flagwrong4 = new Label("Wrong, try again.");
        flagwrong4.setStyle("-fx-font-size:30px; -fx-text-fill: red;");

        //Display Questions and Flag
        VBox displayFlag4 = new VBox();
        displayFlag4.getChildren().add(new ImageView(gameflag4));
        displayFlag4.getChildren().add(flagquestion4);
        displayFlag4.setAlignment(Pos.CENTER);

        //Display Right or Wrong
        displayFlag4.getChildren().add(flagcorrect4);
        flagcorrect4.setVisible(false);
        displayFlag4.getChildren().add(flagwrong4);
        flagwrong4.setVisible(false);
        displayFlag4.setAlignment(Pos.CENTER);

        //Button to next question
        VBox ngs4 = new VBox();
        ngs4.getChildren().add(flagnext4);
        flagnext4.setVisible(false);
        ngs4.setAlignment(Pos.BOTTOM_RIGHT);

        //Button to main menu
        VBox gbs4 = new VBox(); //gbs = game button scene
        gbs4.getChildren().add(fgbackbtn4);
        gbs4.setAlignment(Pos.TOP_LEFT);

        GridPane gridpaneq4 = new GridPane();
        gridpaneq4.setVgap(15);
        gridpaneq4.setHgap(15);
        gridpaneq4.add(flagbutton41, 0, 0);
        gridpaneq4.add(flagbutton42, 1, 0);
        gridpaneq4.add(flagbutton43, 0, 1);
        gridpaneq4.add(flagbutton44, 1, 1);
        gridpaneq4.setAlignment(Pos.CENTER);

        gameq4.setLeft(gbs4);
        gameq4.setCenter(displayFlag4);
        gameq4.setBottom(gridpaneq4);
        gameq4.setRight(ngs4);
        //End of game 4

        //End Scene======================================================
        Label finishgame = new Label("Congratulations!");
        finishgame.setStyle("-fx-font-size:50px; -fx-text-fill: green;");

        Label finishgame2 = new Label("You have completed all the games.");
        finishgame2.setStyle("-fx-font-size:40px; -fx-text-fill: blue;");

        Button endselection1 = new Button("Return to selection page");
        endselection1.setStyle("-fx-background-color: yellow; -fx-pref-width: 200px; -fx-pref-height: 50px; -fx-border-color:black;");

        Button endselection2 = new Button("Repeat exercise");
        endselection2.setStyle("-fx-background-color: yellow; -fx-pref-width: 200px; -fx-pref-height: 50px; -fx-border-color:black;");

        //Scene name
        BorderPane gameend = new BorderPane();
        gameend.setPadding(new Insets(100, 30, 30, 20)); //Top,

        Scene endscene = new Scene(gameend, 1000, 650);

        //Label for finishing the game
        VBox gameendselection1 = new VBox();
        gameendselection1.getChildren().add(finishgame);
        gameendselection1.getChildren().add(finishgame2);
        gameendselection1.setAlignment(Pos.BOTTOM_CENTER);

        //Button for end scene
        HBox gameendselection2 = new HBox();
        gameendselection2.setSpacing(20);
        gameendselection2.getChildren().add(endselection1);
        gameendselection2.getChildren().add(endselection2);
        gameendselection2.setAlignment(Pos.CENTER);

        gameend.setTop(gameendselection1);
        gameend.setCenter(gameendselection2);
        //===Action scene========================================

        //From Flag Selection to Learning
        learnbtn.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(flaglearnscene);
        });

        //From Learning to Selection
        flbackbtn.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(flagscene);
        });

        //From Flag Selection to Game 1
        gamebtn.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(flaggamescene);
        });

        //From Game 1 to Selection
        fgbackbtn1.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(false);
            flagnext1.setVisible(false);
            primaryStage.setScene(flagscene);
        });

        //Game 1 Button 1
        flagbutton11.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(true);
            flagnext1.setVisible(true);
            flagwrong1.setVisible(false);
        });

        //Game 1 Button 2 
        flagbutton12.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(true);
            flagnext1.setVisible(false);
        });

        //Game 1 Button 3
        flagbutton13.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(true);
            flagnext1.setVisible(false);
        });

        //Game 1 Button 4
        flagbutton14.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(true);
            flagnext1.setVisible(false);
        });

        //Game 1 to Game 2
        flagnext1.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(flaggamescene2);
        });

        //Game 2 to Selection page
        fgbackbtn2.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(false);
            flagnext1.setVisible(false);
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(false);
            flagnext2.setVisible(false);
            primaryStage.setScene(flagscene);
        });

        //Game 2 Button 1
        flagbutton21.setOnAction((ActionEvent e) -> {
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(true);
            flagnext2.setVisible(false);
        });

        //Game 2 Button 2
        flagbutton22.setOnAction((ActionEvent e) -> {
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(true);
            flagnext2.setVisible(false);
        });

        //Game 2 Button 3
        flagbutton23.setOnAction((ActionEvent e) -> {
            flagcorrect2.setVisible(true);
            flagnext2.setVisible(true);
            flagwrong2.setVisible(false);
        });

        //Game 2 Button 4
        flagbutton24.setOnAction((ActionEvent e) -> {
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(true);
            flagnext2.setVisible(false);
        });

        //Game 2 to Game 3
        flagnext2.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(flaggamescene3);
        });

        //Game 3 to selection page
        fgbackbtn3.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(false);
            flagnext1.setVisible(false);
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(false);
            flagnext2.setVisible(false);
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(false);
            flagnext3.setVisible(false);
            primaryStage.setScene(flagscene);
        });

        //Game 3 Button 1
        flagbutton31.setOnAction((ActionEvent e) -> {
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(true);
            flagnext3.setVisible(false);
        });

        //Game 3 Button 2
        flagbutton32.setOnAction((ActionEvent e) -> {
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(true);
            flagnext3.setVisible(false);
        });

        //Game 3 Button 3
        flagbutton33.setOnAction((ActionEvent e) -> {
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(true);
            flagnext3.setVisible(false);
        });

        //Game 3 Button 4
        flagbutton34.setOnAction((ActionEvent e) -> {
            flagcorrect3.setVisible(true);
            flagwrong3.setVisible(false);
            flagnext3.setVisible(true);
        });

        //Game 3 to Game 4
        flagnext3.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(flaggamescene4);
        });

        //Game 4 to selection page
        fgbackbtn3.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(false);
            flagnext1.setVisible(false);
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(false);
            flagnext2.setVisible(false);
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(false);
            flagnext3.setVisible(false);
            flagcorrect4.setVisible(false);
            flagwrong4.setVisible(false);
            flagnext4.setVisible(false);
            primaryStage.setScene(flagscene);
        });

        //Game 4 Button 1
        flagbutton41.setOnAction((ActionEvent e) -> {
            flagcorrect4.setVisible(false);
            flagwrong4.setVisible(true);
            flagnext4.setVisible(false);
        });

        //Game 4 Button 2
        flagbutton42.setOnAction((ActionEvent e) -> {
            flagcorrect4.setVisible(true);
            flagwrong4.setVisible(false);
            flagnext4.setVisible(true);
        });

        //Game 4 Button 3
        flagbutton43.setOnAction((ActionEvent e) -> {
            flagcorrect4.setVisible(false);
            flagwrong4.setVisible(true);
            flagnext4.setVisible(false);
        });

        //Game 4 Button 4
        flagbutton44.setOnAction((ActionEvent e) -> {
            flagcorrect4.setVisible(false);
            flagwrong4.setVisible(true);
            flagnext4.setVisible(false);
        });

        //Game 4 to end scene
        flagnext4.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(endscene);
        });

        //From game end scene to selection page
        endselection1.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(false);
            flagnext1.setVisible(false);
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(false);
            flagnext2.setVisible(false);
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(false);
            flagnext3.setVisible(false);
            flagcorrect4.setVisible(false);
            flagwrong4.setVisible(false);
            flagnext4.setVisible(false);
            primaryStage.setScene(flagscene);
        });

        //Repeat game
        endselection2.setOnAction((ActionEvent e) -> {
            flagcorrect1.setVisible(false);
            flagwrong1.setVisible(false);
            flagnext1.setVisible(false);
            flagcorrect2.setVisible(false);
            flagwrong2.setVisible(false);
            flagnext2.setVisible(false);
            flagcorrect3.setVisible(false);
            flagwrong3.setVisible(false);
            flagnext3.setVisible(false);
            flagcorrect4.setVisible(false);
            flagwrong4.setVisible(false);
            flagnext4.setVisible(false);
            primaryStage.setScene(flaggamescene);
        });

        //Background 
        BackgroundImage learnbg1 = new BackgroundImage(new Image("bgf3.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        fs.setBackground(new Background(learnbg1));
        fls.setBackground(new Background(learnbg1));
        gameend.setBackground(new Background(learnbg1));
        gameq1.setBackground(new Background(learnbg1));
        gameq2.setBackground(new Background(learnbg1));
        gameq3.setBackground(new Background(learnbg1));
        gameq4.setBackground(new Background(learnbg1));

        //All Buttons
        Button zsGoToGameSS = new Button("Go To Game");
        zsGoToGameSS.setMinSize(150, 75);
        zsGoToGameSS.setStyle("-fx-font-weight: bold;\n" + "-fx-background-color: FBDCBF;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToGameSS.setPadding(new Insets(10, 10, 10, 10));

        /*Button zsGoToGameLS = new Button("Go To Game");
        zsGoToGameLS.setMinSize(150, 75);
        zsGoToGameLS.setStyle(" -fx-font-weight: bold;\n" + "-fx-background-color: FFF152;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToGameLS.setPadding(new Insets(10, 10, 10, 10));*/
        Button zsGoToMainSS = new Button("Return to Main Menu");
        zsGoToMainSS.setMinSize(150, 75);
        zsGoToMainSS.setStyle("-fx-font-weight: bold;\n" + "-fx-background-color: FBDCBF;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToMainSS.setPadding(new Insets(10, 10, 10, 10));

        Button zsGoToMainLS = new Button("Home");
        zsGoToMainLS.setMinSize(150, 75);
        zsGoToMainLS.setStyle(" -fx-font-weight: bold;\n" + "-fx-background-color: FFF152;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToMainLS.setPadding(new Insets(10, 10, 10, 10));

        Button zsGoToSelectionScreenGS = new Button("Selection Screen");
        zsGoToSelectionScreenGS.setMinSize(150, 75);
        zsGoToSelectionScreenGS.setStyle("-fx-font-weight: bold;\n" + "-fx-background-color: FBDCBF;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToSelectionScreenGS.setPadding(new Insets(10, 10, 10, 10));

        Button zsGoToSelectionScreenLS = new Button("Selection Screen");
        zsGoToSelectionScreenLS.setMinSize(150, 75);
        zsGoToSelectionScreenLS.setStyle(" -fx-font-weight: bold;\n" + "-fx-background-color: FFF152;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToSelectionScreenLS.setPadding(new Insets(10, 10, 10, 10));

        Button zsGoToLearningSS = new Button("Go To Learning Page");
        zsGoToLearningSS.setMinSize(150, 75);
        zsGoToLearningSS.setStyle("-fx-font-weight: bold;\n" + "-fx-background-color: FBDCBF;\n"
                + "-fx-background-radius: 22;\n" + "-fx-font-size: 16;\n" + "-fx-text-fill: #2196f3;\n"
                + "-fx-border-color:#2196f3;\n" + "-fx-border-radius: 20;\n" + "-fx-border-width: 3;");
        zsGoToLearningSS.setPadding(new Insets(10, 10, 10, 10));

//All image imports
        //Lion Image import
        Image zsLion = new Image("Lion.png");
        ImageView zsLionView = new ImageView(zsLion);
        zsLionView.setFitHeight(150);
        zsLionView.setFitWidth(150);

        Image zsActualLion = new Image("actualLion.png");
        ImageView zsLionView2 = new ImageView(zsActualLion);
        zsLionView2.setFitHeight(150);
        zsLionView2.setFitWidth(150);

        //Dog Image import
        Image zsDog = new Image("dog.png");
        ImageView zsDogView = new ImageView(zsDog);
        zsDogView.setFitHeight(150);
        zsDogView.setFitWidth(150);

        Image zsActualDog = new Image("actualDog.png");
        ImageView zsDogView2 = new ImageView(zsActualDog);
        zsDogView2.setFitHeight(150);
        zsDogView2.setFitWidth(150);

        //Giraffe Image import
        Image zsGiraffe = new Image("giraffe.png");
        ImageView zsGiraffeView = new ImageView(zsGiraffe);
        zsGiraffeView.setFitHeight(150);
        zsGiraffeView.setFitWidth(150);

        Image zsActualGiraffe = new Image("actualGiraffe.png");
        ImageView zsGiraffeView2 = new ImageView(zsActualGiraffe);
        zsGiraffeView2.setFitHeight(150);
        zsGiraffeView2.setFitWidth(150);

        //Horse Image import
        Image zsHorse = new Image("horse.png");
        ImageView zsHorseView = new ImageView(zsHorse);
        zsHorseView.setFitHeight(150);
        zsHorseView.setFitWidth(150);

        Image zsActualHorse = new Image("actualHorse.png");
        ImageView zsHorseView2 = new ImageView(zsActualHorse);
        zsHorseView2.setFitHeight(150);
        zsHorseView2.setFitWidth(150);

        //Snake Image import
        Image zsSnake = new Image("snake.png");
        ImageView zsSnakeView = new ImageView(zsSnake);
        zsSnakeView.setFitHeight(150);
        zsSnakeView.setFitWidth(150);

        Image zsActualSnake = new Image("actualSnake.png");
        ImageView zsSnakeView2 = new ImageView(zsActualSnake);
        zsSnakeView2.setFitHeight(150);
        zsSnakeView2.setFitWidth(150);

//Selection screen
        HBox selectionButtonCenter = new HBox(15);
        selectionButtonCenter.getChildren().addAll(zsGoToGameSS, zsGoToLearningSS);
        selectionButtonCenter.setAlignment(Pos.CENTER);

        HBox selectionButtonBot = new HBox();
        selectionButtonBot.getChildren().addAll(zsGoToMainSS);
        selectionButtonBot.setAlignment(Pos.CENTER);

        BorderPane selectionPane = new BorderPane();
        selectionPane.setCenter(selectionButtonCenter);
        selectionPane.setBottom(selectionButtonBot);

        FileInputStream selectionScreenStream = new FileInputStream("src/bgPicture.jpg");
        Image selectionScreenImage = new Image(selectionScreenStream);
        BackgroundImage selectionScreenBackgroundImage = new BackgroundImage(selectionScreenImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background selectionScreenBackground = new Background(selectionScreenBackgroundImage);
        selectionPane.setBackground(selectionScreenBackground);

//Animal Quiz
        Text zsHeading = new Text("ANIMAL QUIZ!");
        zsHeading.setText("ANIMAL QUIZ");
        zsHeading.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        zsHeading.setTextAlignment(TextAlignment.CENTER);

        Text question = new Text("Select the correct animals!");
        question.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        question.setTextAlignment(TextAlignment.CENTER);

        VBox zsHeadingHBox = new VBox(10);
        zsHeadingHBox.getChildren().addAll(zsHeading, question);
        zsHeadingHBox.setAlignment(Pos.CENTER);
        zsHeadingHBox.setPadding(new Insets(10, 10, 10, 10));

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        question.setEffect(ds);
        zsHeading.setEffect(ds);

//QUESTION 1 (lion)
        RadioButton zsLionToggleQnOne = new RadioButton(" Lion");
        RadioButton zsRhinoToggleQnOne = new RadioButton(" Rhino");
        RadioButton zsSnakeToggleQnOne = new RadioButton(" Snake");
        RadioButton zsDogToggleQnOne = new RadioButton(" Dog");

        ToggleGroup questionOne = new ToggleGroup();
        zsLionToggleQnOne.setToggleGroup(questionOne);
        zsRhinoToggleQnOne.setToggleGroup(questionOne);
        zsSnakeToggleQnOne.setToggleGroup(questionOne);
        zsDogToggleQnOne.setToggleGroup(questionOne);

        Label questionOneAnswer = new Label();
        questionOneAnswer.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox questionOneAnswerHBox = new HBox();
        questionOneAnswerHBox.getChildren().add(questionOneAnswer);
        questionOneAnswerHBox.setAlignment(Pos.CENTER);

        zsLionToggleQnOne.setOnAction(e -> {
            questionOneAnswer.setText("Correct!");
            questionOneAnswer.setStyle("-fx-text-fill: green;");
        });

        zsRhinoToggleQnOne.setOnAction(e -> {
            questionOneAnswer.setText("Incorrect, Try Again!");
            questionOneAnswer.setStyle("-fx-text-fill: red;");
        });

        zsSnakeToggleQnOne.setOnAction(e -> {
            questionOneAnswer.setText("Incorrect, Try Again!");
            questionOneAnswer.setStyle("-fx-text-fill: red;");
        });

        zsDogToggleQnOne.setOnAction(e -> {
            questionOneAnswer.setText("Incorrect, Try Again!");
            questionOneAnswer.setStyle("-fx-text-fill: red;");
        });

        VBox zsQuestionOneOptions = new VBox(10);
        zsQuestionOneOptions.getChildren().addAll(zsLionToggleQnOne, zsRhinoToggleQnOne, zsSnakeToggleQnOne, zsDogToggleQnOne);
        zsQuestionOneOptions.setAlignment(Pos.BASELINE_LEFT);

        HBox zsQuestionOne = new HBox(10);
        zsQuestionOne.getChildren().addAll(zsQuestionOneOptions, zsLionView);
        zsQuestionOne.setPadding(new Insets(10, 10, 10, 10));

        VBox zsQ1A = new VBox(10);
        zsQ1A.getChildren().addAll(zsQuestionOne, questionOneAnswerHBox);

        //End of QUESTION 1 
//QUESTION 2 (Snake)
        RadioButton zsLionToggleQnTwo = new RadioButton(" Lion");
        RadioButton zsFrogToggleQnTwo = new RadioButton(" Frog");
        RadioButton zsSnakeToggleQnTwo = new RadioButton(" Snake");
        RadioButton zsDogToggleQnTwo = new RadioButton(" Dog");

        ToggleGroup questionTwo = new ToggleGroup();
        zsLionToggleQnTwo.setToggleGroup(questionTwo);
        zsFrogToggleQnTwo.setToggleGroup(questionTwo);
        zsSnakeToggleQnTwo.setToggleGroup(questionTwo);
        zsDogToggleQnTwo.setToggleGroup(questionTwo);

        Label questionTwoAnswer = new Label();
        questionTwoAnswer.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox questionTwoAnswerHBox = new HBox();
        questionTwoAnswerHBox.getChildren().add(questionTwoAnswer);
        questionTwoAnswerHBox.setAlignment(Pos.CENTER);

        zsLionToggleQnTwo.setOnAction(e -> {
            questionTwoAnswer.setText("Incorrect, Try Again!");
            questionTwoAnswer.setStyle("-fx-text-fill: red;");
        });

        zsSnakeToggleQnTwo.setOnAction(e -> {
            questionTwoAnswer.setText("Correct!");
            questionTwoAnswer.setStyle("-fx-text-fill: green;");
        });

        zsFrogToggleQnTwo.setOnAction(e -> {
            questionTwoAnswer.setText("Incorrect, Try Again!");
            questionTwoAnswer.setStyle("-fx-text-fill: red;");
        });

        zsDogToggleQnTwo.setOnAction(e -> {
            questionTwoAnswer.setText("Incorrect, Try Again!");
            questionTwoAnswer.setStyle("-fx-text-fill: red;");
        });

        VBox zsQuestionTwoOptions = new VBox(10);
        zsQuestionTwoOptions.getChildren().addAll(zsLionToggleQnTwo, zsFrogToggleQnTwo, zsSnakeToggleQnTwo, zsDogToggleQnTwo);
        zsQuestionTwoOptions.setAlignment(Pos.BASELINE_LEFT);

        HBox zsQuestionTwo = new HBox(10);
        zsQuestionTwo.getChildren().addAll(zsQuestionTwoOptions, zsSnakeView);

        VBox zsQ2A = new VBox(10);
        zsQ2A.getChildren().addAll(zsQuestionTwo, questionTwoAnswerHBox);
        zsQ2A.setPadding(new Insets(10, 10, 10, 10));

        HBox combineQ1Q2 = new HBox();
        combineQ1Q2.getChildren().addAll(zsQ1A, zsQ2A);
        combineQ1Q2.setAlignment(Pos.CENTER);

        //End of QUESTION 2
//QUESTION 3 (Dog)
        RadioButton zsCatToggleQnThree = new RadioButton(" Cat");
        RadioButton zsHorseToggleQnThree = new RadioButton(" Horse");
        RadioButton zsDogToggleQnThree = new RadioButton(" Dog");
        RadioButton zsSnakeToggleQnThree = new RadioButton(" Snake");

        ToggleGroup questionThree = new ToggleGroup();
        zsCatToggleQnThree.setToggleGroup(questionThree);
        zsHorseToggleQnThree.setToggleGroup(questionThree);
        zsDogToggleQnThree.setToggleGroup(questionThree);
        zsSnakeToggleQnThree.setToggleGroup(questionThree);

        Label questionThreeAnswer = new Label();
        questionThreeAnswer.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox questionThreeAnswerHBox = new HBox();
        questionThreeAnswerHBox.getChildren().add(questionThreeAnswer);
        questionThreeAnswerHBox.setAlignment(Pos.CENTER);

        zsCatToggleQnThree.setOnAction(e -> {
            questionThreeAnswer.setText("Incorrect, Try Again!");
            questionThreeAnswer.setStyle("-fx-text-fill: red;");
        });

        zsHorseToggleQnThree.setOnAction(e -> {
            questionThreeAnswer.setText("Incorrect, Try Again!");
            questionThreeAnswer.setStyle("-fx-text-fill: red;");
        });

        zsDogToggleQnThree.setOnAction(e -> {
            questionThreeAnswer.setText("Correct!");
            questionThreeAnswer.setStyle("-fx-text-fill: green;");
        });

        zsSnakeToggleQnThree.setOnAction(e -> {
            questionThreeAnswer.setText("Incorrect, Try Again!");
            questionThreeAnswer.setStyle("-fx-text-fill: red;");
        });

        VBox zsQuestionThreeOptions = new VBox(10);
        zsQuestionThreeOptions.getChildren().addAll(zsCatToggleQnThree, zsHorseToggleQnThree, zsDogToggleQnThree, zsSnakeToggleQnThree);
        zsQuestionThreeOptions.setAlignment(Pos.BASELINE_LEFT);

        HBox zsQuestionThree = new HBox(10);
        zsQuestionThree.getChildren().addAll(zsQuestionThreeOptions, zsDogView);

        VBox zsQ3A = new VBox(10);
        zsQ3A.getChildren().addAll(zsQuestionThree, questionThreeAnswerHBox);
        zsQ3A.setPadding(new Insets(10, 10, 10, 10));

        //End of QUESTION 3
//QUESTION 4 (horse)
        RadioButton zsElephantToggleQnFour = new RadioButton(" Elephant");
        RadioButton zsFrogToggleQnFour = new RadioButton(" Frog");
        RadioButton zsGiraffeToggleQnFour = new RadioButton(" Giraffe");
        RadioButton zsHorseToggleQnFour = new RadioButton(" Horse");

        ToggleGroup questionNumber = new ToggleGroup();
        zsGiraffeToggleQnFour.setToggleGroup(questionNumber);
        zsHorseToggleQnFour.setToggleGroup(questionNumber);
        zsElephantToggleQnFour.setToggleGroup(questionNumber);
        zsFrogToggleQnFour.setToggleGroup(questionNumber);

        Label questionFourAnswer = new Label();
        questionFourAnswer.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox questionFourAnswerHBox = new HBox();
        questionFourAnswerHBox.getChildren().add(questionFourAnswer);
        questionFourAnswerHBox.setAlignment(Pos.CENTER);

        zsElephantToggleQnFour.setOnAction(e -> {
            questionFourAnswer.setText("Incorrect, Try Again!");
            questionFourAnswer.setStyle("-fx-text-fill: red;");
        });

        zsFrogToggleQnFour.setOnAction(e -> {
            questionFourAnswer.setText("Incorrect, Try Again!");
            questionFourAnswer.setStyle("-fx-text-fill: red;");
        });

        zsGiraffeToggleQnFour.setOnAction(e -> {
            questionFourAnswer.setText("Incorrect, Try Again!");
            questionFourAnswer.setStyle("-fx-text-fill: red;");
        });

        zsHorseToggleQnFour.setOnAction(e -> {
            questionFourAnswer.setText("Correct!");
            questionFourAnswer.setStyle("-fx-text-fill: green;");
        });

        VBox zsQuestionFourOptions = new VBox(10);
        zsQuestionFourOptions.getChildren().addAll(zsElephantToggleQnFour, zsFrogToggleQnFour, zsGiraffeToggleQnFour, zsHorseToggleQnFour);
        zsQuestionFourOptions.setAlignment(Pos.BASELINE_LEFT);

        HBox zsQuestionFour = new HBox();
        zsQuestionFour.getChildren().addAll(zsQuestionFourOptions, zsHorseView);

        VBox zsQ4A = new VBox();
        zsQ4A.getChildren().addAll(zsQuestionFour, questionFourAnswerHBox);
        zsQ4A.setPadding(new Insets(10, 10, 10, 10));

        HBox combineQ3Q4 = new HBox();
        combineQ3Q4.getChildren().addAll(
                zsQ3A,
                zsQ4A
        );
        combineQ3Q4.setAlignment(Pos.CENTER);

        //End of QUESTION 4
//QUESTION 5 (Giraffe)
        RadioButton zsElephantToggleQnFive = new RadioButton(" Elephant");
        RadioButton zsSnakeToggleQnFive = new RadioButton(" Snake");
        RadioButton zsGiraffeToggleQnFive = new RadioButton(" Giraffe");
        RadioButton zsHorseToggleQnFive = new RadioButton(" Horse");

        ToggleGroup questionFive = new ToggleGroup();
        zsElephantToggleQnFive.setToggleGroup(questionFive);
        zsSnakeToggleQnFive.setToggleGroup(questionFive);
        zsGiraffeToggleQnFive.setToggleGroup(questionFive);
        zsHorseToggleQnFive.setToggleGroup(questionFive);

        Label questionFiveAnswer = new Label();
        questionFiveAnswer.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox questionFiveAnswerHBox = new HBox();
        questionFiveAnswerHBox.getChildren().add(questionFiveAnswer);
        questionFiveAnswerHBox.setAlignment(Pos.CENTER);

        zsElephantToggleQnFive.setOnAction(e -> {
            questionFiveAnswer.setText("Incorrect \nTry Again!");
            questionFiveAnswer.setStyle("-fx-text-fill: red;");
        });

        zsSnakeToggleQnFive.setOnAction(e -> {
            questionFiveAnswer.setText("Incorrect \nTry Again!");
            questionFiveAnswer.setStyle("-fx-text-fill: red;");
        });

        zsGiraffeToggleQnFive.setOnAction(e -> {
            questionFiveAnswer.setText("Correct!");
            questionFiveAnswer.setStyle("-fx-text-fill: green;");

        });

        zsHorseToggleQnFive.setOnAction(e -> {
            questionFiveAnswer.setText("Incorrect \nTry Again!");
            questionFiveAnswer.setStyle("-fx-text-fill: red;");
        });

        VBox zsQuestionFiveOptions = new VBox(10);
        zsQuestionFiveOptions.getChildren().addAll(zsElephantToggleQnFive, zsSnakeToggleQnFive, zsGiraffeToggleQnFive, zsHorseToggleQnFive);
        zsQuestionFiveOptions.setAlignment(Pos.BASELINE_LEFT);

        HBox zsQuestionFive = new HBox(10);
        zsQuestionFive.getChildren().addAll(zsQuestionFiveOptions, zsGiraffeView);

        VBox zsQ5A = new VBox(10);
        zsQ5A.getChildren().addAll(zsQuestionFive, questionFiveAnswerHBox);
        zsQ5A.setPadding(new Insets(10, 10, 10, 10));

        //End of QUESTION 5   
//UI for animal quiz
        VBox combineAllQuestions = new VBox();
        combineAllQuestions.getChildren().addAll(combineQ1Q2, combineQ3Q4);
        combineAllQuestions.setAlignment(Pos.CENTER);

        GridPane zsQA = new GridPane();
        zsQA.setAlignment(Pos.CENTER);
        zsQA.add(combineAllQuestions, 0, 0);
        zsQA.add(zsQ5A, 0, 1);
        zsQA.setStyle("-fx-background-color: #FBDCBF;");

        HBox zsCenterGamePane = new HBox();
        zsCenterGamePane.getChildren().addAll(new ScrollPane(zsQA));
        zsCenterGamePane.setAlignment(Pos.CENTER);

        HBox zsBottomGameScene = new HBox(10);
        zsBottomGameScene.getChildren().addAll(zsGoToSelectionScreenGS);
        zsBottomGameScene.setAlignment(Pos.CENTER);
        zsBottomGameScene.setPadding(new Insets(10, 10, 10, 10));

        BorderPane gamePane = new BorderPane();
        gamePane.setPadding(new Insets(10, 10, 10, 10));
        gamePane.setTop(zsHeadingHBox);
        gamePane.setCenter(zsCenterGamePane);
        gamePane.setBottom(zsBottomGameScene);

        FileInputStream gameScreenBG = new FileInputStream("src/bgPicture2.jpg");
        Image gameScreenBGImage = new Image(gameScreenBG);
        BackgroundImage animalBackgroundImage2 = new BackgroundImage(gameScreenBGImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background gameScreenBGimage = new Background(animalBackgroundImage2);
        gamePane.setBackground(gameScreenBGimage);

//Learning Page
        Text zsHeadingLearning = new Text("Welcome To  \n Fun Facts about Animals!");
        zsHeadingLearning.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        zsHeadingLearning.setTextAlignment(TextAlignment.CENTER);
        zsHeadingLearning.setEffect(ds);

        HBox zsLearnHeadingHBox = new HBox(10);
        zsLearnHeadingHBox.getChildren().add(zsHeadingLearning);
        zsLearnHeadingHBox.setAlignment(Pos.TOP_CENTER);
        zsLearnHeadingHBox.setPadding(new Insets(10, 10, 10, 10));

//Dogs
        Text headingDogs = new Text("Dogs");
        headingDogs.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        headingDogs.setTextAlignment(TextAlignment.CENTER);
        headingDogs.setEffect(ds);

        Text dogsInfo = new Text();
        dogsInfo.setEffect(ds);
        dogsInfo.setFont(Font.font("Arial", 14));
        dogsInfo.setTextAlignment(TextAlignment.CENTER);
        dogsInfo.setText("Dogs are good companions for humans"
                + "\n" + "Dogs can provide emotional security."
                + "\n" + "Dogs can provide emotional security."
                + "\n" + "Dogs can eat grains, veg & meat."
                + "\n" + "Lifespan of a dog can vary from 10 to 14 years.");

        VBox aboutDogs = new VBox(10);
        aboutDogs.getChildren().addAll(headingDogs, zsDogView2, dogsInfo);
        aboutDogs.setAlignment(Pos.CENTER);
        aboutDogs.setPadding(new Insets(10, 10, 10, 10));

//Lion
        Text headingLion = new Text("Lions");
        headingLion.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        headingLion.setTextAlignment(TextAlignment.CENTER);
        headingLion.setEffect(ds);

        Text lionInfo = new Text();
        lionInfo.setEffect(ds);
        lionInfo.setFont(Font.font("Arial", 14));
        lionInfo.setTextAlignment(TextAlignment.CENTER);
        lionInfo.setText("Male lion weighs around 180 kilograms "
                + "\n" + "Female lion can weigh up to 130 kilograms. "
                + "\n" + "A lion’s roar can be heard from 8 kilometres away."
                + "\n" + "Lions are known to rest for around 20 hours a day."
                + "\n" + "Lions have a lifespan of about 12 years.");

        VBox aboutLions = new VBox(10);
        aboutLions.getChildren().addAll(headingLion, zsLionView2, lionInfo);
        aboutLions.setAlignment(Pos.CENTER);
        aboutLions.setPadding(new Insets(10, 10, 10, 10));

//Giraffe
        Text headingGiraffes = new Text("Giraffes");

        headingGiraffes.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        headingGiraffes.setTextAlignment(TextAlignment.CENTER);
        headingGiraffes.setEffect(ds);

        Text giraffeInfo = new Text();
        giraffeInfo.setEffect(ds);
        giraffeInfo.setFont(Font.font("Arial", 14));
        giraffeInfo.setTextAlignment(TextAlignment.CENTER);
        giraffeInfo.setText("Male Giraffe can weigh up to 1400 kilograms"
                + "\n" + "Giraffe’s long neck measures between 1.5 to 1.8 metres."
                + "\n" + "A Giraffe has four stomachs"
                + "\n" + "Horns are present on male and female giraffes");

        VBox aboutGiraffes = new VBox(10);
        aboutGiraffes.getChildren().addAll(headingGiraffes, zsGiraffeView2, giraffeInfo);
        aboutGiraffes.setAlignment(Pos.CENTER);
        aboutGiraffes.setPadding(new Insets(10, 10, 10, 10));

//Horse
        Text headingHorse = new Text("Horse");
        headingHorse.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        headingHorse.setTextAlignment(TextAlignment.CENTER);
        headingHorse.setEffect(ds);

        Text horseInfo = new Text();
        horseInfo.setEffect(ds);
        horseInfo.setFont(Font.font("Arial", 14));
        horseInfo.setTextAlignment(TextAlignment.CENTER);
        horseInfo.setText("Horses can sleep both lying down and standing up"
                + "\n" + "Horses can run shortly after birth"
                + "\n" + "horses have a lifespan of around 25 years"
                + "\n" + "Horses are herbivores (plant eaters)");

        VBox aboutHorses = new VBox(10);
        aboutHorses.getChildren().addAll(headingHorse, zsHorseView2, horseInfo);
        aboutHorses.setAlignment(Pos.CENTER);
        aboutHorses.setPadding(new Insets(10, 10, 10, 10));

//Snake
        Text headingSnake = new Text("Snake");
        headingSnake.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        headingSnake.setTextAlignment(TextAlignment.CENTER);
        headingSnake.setEffect(ds);

        Text snakeInfo = new Text();
        snakeInfo.setEffect(ds);
        snakeInfo.setFont(Font.font("Arial", 14));
        snakeInfo.setTextAlignment(TextAlignment.CENTER);
        snakeInfo.setText("Horses can sleep both lying down and standing up"
                + "\n" + "Horses can run shortly after birth"
                + "\n" + "horses have a lifespan of around 25 years"
                + "\n" + "Horses are herbivores (plant eaters)");

        VBox aboutSnake = new VBox(10);
        aboutSnake.getChildren().addAll(headingSnake, zsSnakeView2, snakeInfo);
        aboutSnake.setAlignment(Pos.CENTER);
        aboutSnake.setPadding(new Insets(10, 10, 10, 10));

//UI
        HBox lionDogCombined = new HBox();
        lionDogCombined.getChildren().addAll(aboutLions, aboutDogs);
        lionDogCombined.setAlignment(Pos.CENTER);

        HBox giraffeHorseCombined = new HBox();
        giraffeHorseCombined.getChildren().addAll(aboutGiraffes, aboutHorses, aboutSnake);
        giraffeHorseCombined.setAlignment(Pos.CENTER);

        VBox allCombined = new VBox();
        allCombined.getChildren().addAll(lionDogCombined, giraffeHorseCombined);
        allCombined.setAlignment(Pos.CENTER);

        GridPane zsLP = new GridPane();
        zsLP.setAlignment(Pos.CENTER);
        zsLP.add(allCombined, 0, 0);
        zsLP.add(aboutSnake, 0, 1);
        zsLP.setStyle("-fx-background-color: #FFF152;");

        HBox zsCenterLearningPage = new HBox();
        zsCenterLearningPage.getChildren().addAll(new ScrollPane(zsLP));
        zsCenterLearningPage.setAlignment(Pos.CENTER);

        HBox zsBottomLearningPage = new HBox(10);
        zsBottomLearningPage.getChildren().addAll(zsGoToSelectionScreenLS);
        zsBottomLearningPage.setAlignment(Pos.CENTER);
        zsBottomLearningPage.setPadding(new Insets(10, 10, 10, 10));

        BorderPane learningPane = new BorderPane();
        learningPane.setTop(zsLearnHeadingHBox);
        learningPane.setCenter(zsCenterLearningPage);
        learningPane.setBottom(zsBottomLearningPage);

        FileInputStream animalStream = new FileInputStream("src/bgPicture3.jpg");
        Image zsAnimalImage = new Image(animalStream);
        BackgroundImage animalBackgroundImage = new BackgroundImage(zsAnimalImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background animalBackground = new Background(animalBackgroundImage);
        learningPane.setBackground(animalBackground);

//End of Learning Page
        Scene zsSelectionScene = new Scene(selectionPane, 1000, 650);
        Scene zsGameScene = new Scene(gamePane, 1000, 650);
        Scene zsLearningScene = new Scene(learningPane, 1000, 650);

        //Set on action for Buttons
        zsGoToGameSS.setOnAction(e -> {
            primaryStage.setScene(zsGameScene);
        });

        zsGoToLearningSS.setOnAction(e -> {
            primaryStage.setScene(zsLearningScene);
        });

        zsGoToSelectionScreenLS.setOnAction(e -> {
            primaryStage.setScene(zsSelectionScene);
        });

        zsGoToSelectionScreenGS.setOnAction(e -> {
            primaryStage.setScene(zsSelectionScene);
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setMinSize(130, 55);
        logoutButton.setStyle(" -fx-font-weight: bold;\n"
                + "    -fx-background-color: white;\n"
                + "    -fx-background-radius: 22;\n"
                + "    -fx-font-size: 16;\n"
                + "    -fx-text-fill: #2196f3;\n"
                + "    -fx-border-color:#2196f3;\n"
                + "    -fx-border-radius: 20;\n"
                + "    -fx-border-width: 3;");

        //Selection Buttons
        VBox selectionLeft = new VBox();
        selectionLeft.getChildren().addAll(
                alphabetButton,
                shapeButton
        );

        VBox selectionCenter = new VBox();
        selectionCenter.getChildren().addAll(
                mathButton
        );

        VBox selectionRight = new VBox();
        selectionRight.getChildren().addAll(
                animalButton,
                geographyButton
        );

        HBox selectionBottom = new HBox();
        selectionBottom.getChildren().addAll(
                logoutButton
        );

        selectionLeft.setAlignment(Pos.CENTER);
        selectionLeft.setPadding(new Insets(10, 50, 50, 50));
        selectionLeft.setSpacing(10);

        selectionCenter.setAlignment(Pos.CENTER);
        selectionCenter.setPadding(new Insets(10, 50, 50, 50));
        selectionCenter.setSpacing(10);

        selectionRight.setAlignment(Pos.CENTER);
        selectionRight.setPadding(new Insets(10, 50, 50, 50));
        selectionRight.setSpacing(10);

        selectionBottom.setAlignment(Pos.CENTER);
        selectionBottom.setPadding(new Insets(10, 50, 50, 50));
        selectionBottom.setSpacing(100);

        BorderPane selectionScreen = new BorderPane();

        selectionScreen.setTop(selectionTitle);
        selectionScreen.setLeft(selectionLeft);
        selectionScreen.setCenter(selectionCenter);
        selectionScreen.setRight(selectionRight);
        selectionScreen.setBottom(selectionBottom);

        Scene loginScene = new Scene(loginPage, 1000, 650);
        Scene selectionScene = new Scene(selectionScreen, 1000, 650);

        primaryStage.setTitle("Children Learning System");
        primaryStage.setScene(loginScene);
        primaryStage.show();

        BackgroundImage selectionBI = new BackgroundImage(new Image("selectionimage.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        selectionScreen.setBackground(new Background(selectionBI));

        BackgroundImage loginBI = new BackgroundImage(new Image("login.jpg", 1000, 650, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        loginPage.setBackground(new Background(loginBI));

        alphabetButton.setOnAction(e -> {
            primaryStage.setScene(AlphaScene1);
        });

        shapeButton.setOnAction(e -> {
            primaryStage.setScene(Selectionshape);
        });

        mathButton.setOnAction(e -> {
            primaryStage.setScene(Math3);
        });

        animalButton.setOnAction(e -> {
            primaryStage.setScene(zsSelectionScene);
        });

        geographyButton.setOnAction(e -> {
            primaryStage.setScene(flagscene);
        });

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, loginPage.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if (password.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, loginPage.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                } else {
                    File checkFile = new File(username.getText() + ".txt");
                    boolean exists = checkFile.exists();
                    if (checkFile.exists()) {
                        showAlert(Alert.AlertType.ERROR, loginPage.getScene().getWindow(), "Registration Failed", "Username is already taken");
                    } else {
                        try (FileWriter fileWriter = new FileWriter(username.getText() + ".txt", true);) {
                            PrintWriter write = new PrintWriter(fileWriter);
                            write.println(username.getText() + " " + password.getText());
                            showAlert(Alert.AlertType.CONFIRMATION, loginPage.getScene().getWindow(), "Registration Successful!", "Welcome " + username.getText() + ", your account have been successfully created.");
                            username.clear();
                            password.clear();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, loginPage.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if (password.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, loginPage.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                } else {
                    File loginFile = new File(username.getText() + ".txt");
                    Scanner read;

                    try {
                        read = new Scanner(loginFile);

                        while (read.hasNext()) {
                            String line = read.nextLine();
                            String[] tokens = line.split(" ");

                            if ((tokens[0].equals(username.getText())) && (tokens[1].equals(password.getText()))) {
                                username.getText().equals(usernameTitle);
                                primaryStage.setScene(selectionScene);
                                return;
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                }
                showAlert(Alert.AlertType.ERROR, loginPage.getScene().getWindow(), "Login Failed", "Wrong Username or Password Entered");
            }
        });

        logoutButton.setOnAction(e -> {
            primaryStage.setScene(loginScene);
            username.clear();
            password.clear();
        });

        shapemainmenu.setOnAction(e -> primaryStage.setScene(selectionScene));
        MSS1.setOnAction(e -> primaryStage.setScene(selectionScene));
        RevisionreturnMenuButton.setOnAction(e -> primaryStage.setScene(selectionScene));
        flagToSelection.setOnAction(e -> primaryStage.setScene(selectionScene));
        zsGoToMainSS.setOnAction(e -> primaryStage.setScene(selectionScene));

        //Button Effects 
        alphabetButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                alphabetButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: white;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: #2196f3;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

        alphabetButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                alphabetButton.setStyle("-fx-background-color:transparent;");
            }
        });

        shapeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                shapeButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: white;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: #2196f3;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

        shapeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                shapeButton.setStyle("-fx-background-color:transparent;");
            }
        });

        mathButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                mathButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: white;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: #2196f3;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

        mathButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                mathButton.setStyle("-fx-background-color:transparent;");
            }
        });

        animalButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                animalButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: white;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: #2196f3;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

        animalButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                animalButton.setStyle("-fx-background-color:transparent;");
            }
        });

        geographyButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                geographyButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: white;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: #2196f3;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

        geographyButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                geographyButton.setStyle("-fx-background-color:transparent;");
            }
        });

        logoutButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                logoutButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: #2196f3;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: white;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

        logoutButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                logoutButton.setStyle(" -fx-font-weight: bold;\n"
                        + "    -fx-background-color: white;\n"
                        + "    -fx-background-radius: 22;\n"
                        + "    -fx-font-size: 16;\n"
                        + "    -fx-text-fill: #2196f3;\n"
                        + "    -fx-border-color:#2196f3;\n"
                        + "    -fx-border-radius: 20;\n"
                        + "    -fx-border-width: 3;");
            }
        });

    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Paint randomColor() {
        Random randomcolor = new Random();
        return colorforshape.get(randomIntColor);
    }

    public Shape randomshape() {

        Rectangle square2 = new Rectangle(80, 80, 200, 200);
        Ellipse ellipse2 = new Ellipse(90, 90, 150, 150);

        Polygon polygonhrsc2 = new Polygon();
        polygonhrsc2.getPoints().addAll(new Double[]{
            200.0, 50.0,
            400.0, 50.0,
            450.0, 150.0,
            400.0, 250.0,
            200.0, 250.0,
            150.0, 150.0,});

        Random rand = new Random();
        intrandomshape = rand.nextInt(3);
        square2.setStrokeWidth(2);
        ellipse2.setStrokeWidth(2);
        polygonhrsc2.setStrokeWidth(2);
        square2.setFill(randomColor());
        ellipse2.setFill(randomColor());
        polygonhrsc2.setFill(randomColor());
        List<Shape> shapeswithcolor = new ArrayList<>();
        shapeswithcolor.add(square2);
        shapeswithcolor.add(ellipse2);
        shapeswithcolor.add(polygonhrsc2);
        return shapeswithcolor.get(intrandomshape);
    }

    public ArrayList<String> getScore() {
        return Score;
    }

    public void setScore(ArrayList<String> Score) {
        this.Score = Score;
    }

}
