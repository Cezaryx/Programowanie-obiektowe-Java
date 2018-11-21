import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javax.swing.text.View;



public class main extends Application{
    ImageView Main;
    File[] listOfFiles;
    int counter =1;
    GridPane gridPane = new GridPane();
    final ScrollBar sc = new ScrollBar();
    final VBox vb = new VBox();
    @Override
    public void start(Stage stage){
        Group root = new Group();
        root.getChildren().addAll(gridPane,vb,sc);
        Scene scene = new Scene(root, 1200, 1000);

        TextField textField1 = new TextField();
        Text tx = new Text("");
        Text text1 = new Text("Podaj ścieżkę do pliku");
        Button button1 = new Button("Przeglądaj");
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1,1,0);
        gridPane.add(button1, 1, 1);
        gridPane.add(tx, 1, 2);
        //String path = "C:\\Users\\User\\Desktop\\zdjęcia";
        vb.setLayoutX(5);
        vb.setSpacing(10);
        sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(1000);
        sc.setMax(360);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                String path = textField1.getText();
                File folder;
                try {
                    folder = new File(path);
                }catch(Exception ez){
                    System.err.println("Wrong path");
                    return;
                }
                listOfFiles = folder.listFiles();
                for(final File file: listOfFiles){


                    if(file.isFile()){
                        String fileName = file.getName();
                        String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1, file.getName().length());
                        if("png".equals(fileExtension) ||"jpg".equals(fileExtension)||"gif".equals(fileExtension)||"jpeg".equals(fileExtension)){
                            FileInputStream input;
                            try {
                                input = new FileInputStream(file);
                            }catch(FileNotFoundException ez){
                                System.err.println("Invalid Path");
                                return;
                            }
                            Image image = new Image(input);
                            ImageView imageView = new ImageView(image);
                            imageView.setFitHeight(100);
                            imageView.setPreserveRatio(true);
                            imageView.setPickOnBounds(true);
                            gridPane.add(imageView,0,counter);
                            counter++;
                            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                @Override
                                public void handle(MouseEvent event) {
                                    gridPane.getChildren().remove(counter+2);
                                    Main= new ImageView(imageView.getImage());
                                    Main.setFitHeight(500);
                                    Main.setPreserveRatio(true);
                                    gridPane.add(Main, 1, 2);

                                }
                            });
                            sc.valueProperty().addListener(new ChangeListener<Number>() {
                                public void changed(ObservableValue<? extends Number> ov,
                                                    Number old_val, Number new_val) {
                                    gridPane.setLayoutY(-new_val.doubleValue());
                                }
                            });
                        }

                    }



                }
            }
        };







        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        stage.setTitle("Przeglądarka zdjęć");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}