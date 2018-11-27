package bazy;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        Text tx1 = new Text("Wypisz całą bazę danych");
        Button bt1 = new Button("Wypisz");
        /*pobierz mySQL builder do działania połączenia*/
        /*pooglądaj: Java tutorial 20: connect to mysql */
        /* ctrl + shift + alt +s >>> libraries >>> dodaj mysql connector */
        Text tx2 = new Text("Wyszukaj po numerze ISBN");
        TextField txf1 = new TextField("ISBN");
        Button bt2 = new Button("Wyszukaj");

        Text tx3 = new Text("Wyszukaj po nazwisku autora");
        TextField txf2 = new TextField("Nazwisko");
        Button bt3 = new Button("Wyszukaj");

        Text tx4 = new Text("Dodaj rekord");
        TextField txf3 = new TextField("ISBN");
        TextField txf4 = new TextField("Tytuł");
        TextField txf5 = new TextField("Autor");
        TextField txf6 = new TextField("Rok");
        Button bt4 = new Button("Dodaj");

        GridPane gridPane = new GridPane();
        gridPane.add(tx1,0,0);
        gridPane.add(bt1,1,0);

        gridPane.add(tx2,0,1);
        gridPane.add(txf1,1,1);
        gridPane.add(bt2,2,1);

        gridPane.add(tx3,0,2);
        gridPane.add(txf2,1,2);
        gridPane.add(bt3,2,2);

        gridPane.add(tx4,0,3);
        gridPane.add(txf3,1,3);
        gridPane.add(txf4,2,3);
        gridPane.add(txf5,3,3);
        gridPane.add(txf6,4,3);
        gridPane.add(bt4,5,3);


        Group root = new Group();
        root.getChildren().addAll(gridPane);
        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle("Baza danych");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
