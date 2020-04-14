package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Flow;

import static javafx.scene.paint.Color.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //FlowPane root = new FlowPane(50,50);
        VBox root = new VBox(25);
       // GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().addAll("vbox");

        primaryStage.setTitle("System Monitor");



        Text name = new Text ("SYSTEM MONITOR");
        name.setFill(MAROON);
        name.setFont(Font.font( "",FontWeight.BOLD,30));
        Label response = new Label("Select a feature");

        Image proi = new Image("file:process.jpeg",50,50,true,true);
        Image powi = new Image("file:power.jpeg",50,50,true,true);
        Image memi = new Image("file:memory.png",50,50,true,true);
        Image disi = new Image("file:disk.jpeg",50,50,true,true);
        Image devi = new Image("file:io.png",50,50,true,true);
        Image scen = new Image ("file:usagemonitor.png",100,100,true,true);

        ImageView sceni = new ImageView(scen);
        /*sceni.setLayoutX(500);
        sceni.setLayoutY(250);
        sceni.setX(500);
        sceni.setY(250);*/

        Button pro = new Button("Process",new ImageView(proi));
        Button pow = new Button ("Power",new ImageView(powi));
        Button mem = new Button("Memory",new ImageView(memi));
        Button dis = new Button("Disk Usage",new ImageView(disi));
        Button dev = new Button("Input/Output",new ImageView(devi));

        /*pro.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
        pro.setStyle("-fx-background-color: #00ff00");
        pro.setStyle("-fx-font-size: 35; ");*/
        pro.setStyle("-fx-text-fill: #0000ff");

        /*pow.setStyle("-fx-border-color: #FF21DA; -fx-border-width: 5px;");
        pow.setStyle("-fx-background-color: #FF21DA");
        pow.setStyle("-fx-font-size: 5em; ");*/
        pow.setStyle("-fx-text-fill: #FF1C9D");

        /*mem.setStyle("-fx-border-color: #AFFF0F; -fx-border-width: 5px;");
        mem.setStyle("-fx-background-color: #00ff00");
        mem.setStyle("-fx-font-size: 5em; ");*/
        mem.setStyle("-fx-text-fill: #804D4D");

        /*dis.setStyle("-fx-border-color: #5252FF; -fx-border-width: 5px;");
        dis.setStyle("-fx-background-color: #00ff00");
        dis.setStyle("-fx-font-size: 5em; ");*/
        dis.setStyle("-fx-text-fill: #2A2E2E");

        /*dev.setStyle("-fx-border-color: #FFB99C; -fx-border-width: 5px;");
        dev.setStyle("-fx-background-color: #00ff00");
        dev.setStyle("-fx-font-size: 5em; ");*/
        dev.setStyle("-fx-text-fill: #FF7066");

        Scene s = new Scene(root, 600, 600);
       // s.getStylesheets().add("vbox.css");
        primaryStage.setScene(s);

        pro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                response.setText("Pressed "+pro.getText());
                TextArea tf = new TextArea();
                tf.setPrefColumnCount(60);
                tf.setPrefRowCount(50);



                    try {
                        Process p = Runtime.getRuntime().exec("top -b -n 1");
                        String s, str = "";
                        // TextField tf =new TextField("HellO");
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
                        while ((s = br.readLine()) != null) {
                            //System.out.println(s);
                            str = str + "\n" + s;
                        }
                        tf.setText(str);
                        System.out.println("Hi");

                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {

                        /*Group root2 = new Group();
                        Scene s2 = new Scene(root2, 850, 800);
                        primaryStage.setScene(s2);
                        root2.getChildren().addAll(tf);
                        primaryStage.show();*/
                        Text header= new Text("Active Process status");
                        header.setFill(BROWN);
                        header.setFont(Font.font( "",FontWeight.BOLD,25));

                        Stage st =new Stage();
                        //FlowPane root2 = new FlowPane(15,15);
                        VBox root2 = new VBox(20);
                        root2.setAlignment(Pos.CENTER);
                        Scene s2 = new Scene(root2, 850, 800);
                        st.setScene(s2);
                        root2.getChildren().addAll(header,tf);
                        st.show();
                    }
                }


        });

        mem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                response.setText("Pressed "+mem.getText());
                TextArea tf = new TextArea();
                tf.setPrefColumnCount(60);
                tf.setPrefRowCount(50);


                try {
                    Process p = Runtime.getRuntime().exec("cat /proc/meminfo");
                    String s, str = "";
                    // TextField tf =new TextField("HellO");
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(p.getInputStream()));
                    while ((s = br.readLine()) != null) {
                        //System.out.println(s);
                        str = str + "\n" + s;
                    }
                    tf.setText(str);
                    System.out.println("Hi");

                } catch (Exception e) {
                    System.out.println(e);
                } finally {

                    /*Group root2 = new Group();
                    Scene s2 = new Scene(root2, 850, 800);
                    primaryStage.setScene(s2);
                    root2.getChildren().addAll(tf);
                    primaryStage.show();*/
                    Text header= new Text("Memory status");
                    header.setFill(BLUE);
                    header.setFont(Font.font( "",FontWeight.BOLD,25));

                    Stage st =new Stage();
                    VBox root2 = new VBox(20);
                    root2.setAlignment(Pos.CENTER);
                    Scene s2 = new Scene(root2, 850, 800);
                    st.setScene(s2);
                    root2.getChildren().addAll(header,tf);
                    st.show();
                }
            }


        });

        pow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                response.setText("Pressed "+pow.getText());
                /*TextArea tf = new TextArea();
                tf.setPrefColumnCount(60);
                tf.setPrefRowCount(50);*/
                Text tf = new Text();

                try {
                    Process p = Runtime.getRuntime().exec("acpi -V");
                    String s, str = "";
                    // TextField tf =new TextField("HellO");
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(p.getInputStream()));
                    while ((s = br.readLine()) != null) {
                        //System.out.println(s);
                        str = str + "\n" + s;
                    }
                    tf.setText(str);
                    System.out.println("Hi");

                } catch (Exception e) {
                    System.out.println(e);
                } finally {

                   /* Group root2 = new Group();
                    Scene s2 = new Scene(root2, 850, 800);
                    primaryStage.setScene(s2);
                    root2.getChildren().addAll(tf);
                    primaryStage.show();*/
                    Text header= new Text("Battery status");
                    header.setFill(DARKGREEN);
                    header.setFont(Font.font( "",FontWeight.BOLD,25));

                   Stage st =new Stage();
                   VBox root2 = new VBox(20);
                   root2.setAlignment(Pos.CENTER);
                   Scene s2 = new Scene(root2, 550, 400);
                   st.setScene(s2);
                   root2.getChildren().addAll(header,tf);
                   st.show();
                }
            }


        });

        dis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                response.setText("Pressed "+dis.getText());
                /*TextArea tf = new TextArea();
                tf.setPrefColumnCount(60);
                tf.setPrefRowCount(50);*/
                Text tf = new Text();

                try {
                    Process p = Runtime.getRuntime().exec("df -hl");
                    String s, str = "";
                    // TextField tf =new TextField("HellO");
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(p.getInputStream()));
                    while ((s = br.readLine()) != null) {
                        //System.out.println(s);
                        str = str + "\n" + s;
                    }
                    tf.setText(str);
                    System.out.println("Hi");

                } catch (Exception e) {
                    System.out.println(e);
                } finally {

                    /*Group root2 = new Group();
                    Scene s2 = new Scene(root2, 850, 800);
                    primaryStage.setScene(s2);
                    root2.getChildren().addAll(tf);
                    primaryStage.show();*/
                    Text header= new Text("Disk usage status");
                    header.setFill(BLUEVIOLET);
                    header.setFont(Font.font( "",FontWeight.BOLD,25));

                    Stage st =new Stage();
                    VBox root2 = new VBox(20);
                    root2.setAlignment(Pos.CENTER);
                    Scene s2 = new Scene(root2, 600, 600);
                    st.setScene(s2);
                    root2.getChildren().addAll(header,tf);
                    st.show();
                }
            }


        });

        dev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                response.setText("Pressed "+dev.getText());
                /*TextArea tf = new TextArea();
                tf.setPrefColumnCount(60);
                tf.setPrefRowCount(50);*/
                Text tf = new Text();

                try {
                    Process p = Runtime.getRuntime().exec("iostat -hs");
                    String s, str = "";
                    // TextField tf =new TextField("HellO");
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(p.getInputStream()));
                    while ((s = br.readLine()) != null) {
                        //System.out.println(s);
                        str = str + "\n" + s;
                    }
                    tf.setText(str);
                    System.out.println("Hi");

                } catch (Exception e) {
                    System.out.println(e);
                } finally {

                    /*Group root2 = new Group();
                    Scene s2 = new Scene(root2, 850, 800);
                    primaryStage.setScene(s2);
                    root2.getChildren().addAll(tf);
                    primaryStage.show();*/
                    Text header= new Text("CPU and DEVICE status");
                    header.setFill(RED);
                    header.setFont(Font.font( "",FontWeight.BOLD,25));

                    Stage st =new Stage();
                    VBox root2 = new VBox(20);
                    root2.setAlignment(Pos.CENTER);
                    Scene s2 = new Scene(root2, 750, 860);
                    st.setScene(s2);
                    root2.getChildren().addAll(header,tf);
                    st.show();
                }
            }


        });

        root.getChildren().addAll(sceni,name,pro,pow,mem,dis,dev,response);
        /*root.add(sceni, 1, 0);
        root.add(name, 1, 1);
        root.add(pro, 0, 2);
        root.add(pow, 2, 2);
        root.add(mem, 0, 3);
        root.add(dis, 2, 3);
        root.add(dev, 1, 4);
        root.add(response, 1, 5);*/
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
