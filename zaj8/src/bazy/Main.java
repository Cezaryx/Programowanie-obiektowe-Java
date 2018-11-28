package bazy;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
    DB db = new DB();
    GridPane gridPane = new GridPane();
    TextField txf1 = new TextField("ISBN");
    TextField txf2 = new TextField("Nazwisko");
    TextField txf3 = new TextField("ISBN");
    TextField txf4 = new TextField("Tytuł");
    TextField txf5 = new TextField("Autor");
    TextField txf6 = new TextField("Rok");
    @Override
    public void start(Stage stage){
        EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gridPane.getChildren().remove(14);
                String wypisz = new String();
                wypisz =db.printAll();
                Text ttext = new Text(wypisz);
                gridPane.add(ttext,0,4);
            }
        };

        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gridPane.getChildren().remove(14);
                String wzorzec = txf1.getText();
                String wypisz = new String();
                wypisz =db.printISBN(wzorzec);
                Text ttext = new Text(wypisz);
                gridPane.add(ttext,0,4);
            }
        };

        EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gridPane.getChildren().remove(14);
                String wzorzec = txf2.getText();
                String wypisz = new String();
                wypisz =db.printnazwisko(wzorzec);
                Text ttext = new Text(wypisz);
                gridPane.add(ttext,0,4);
            }
        };

        EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gridPane.getChildren().remove(14);
                String a = txf3.getText();
                String b = txf4.getText();
                String c = txf5.getText();
                String d = txf6.getText();
                db.add_da_book(a,b,c,d);
                Text ttext = new Text("");
                gridPane.add(ttext,0,4);
            }
        };

        Text tx1 = new Text("Wypisz całą bazę danych");
        Button bt1 = new Button("Wypisz");
        bt1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
        /*pobierz mySQL builder do działania połączenia*/
        /*pooglądaj: Java tutorial 20: connect to mysql */
        /* ctrl + shift + alt +s >>> libraries >>> dodaj mysql connector */
        Text tx2 = new Text("Wyszukaj po numerze ISBN");

        Button bt2 = new Button("Wyszukaj");
        bt2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
        Text tx3 = new Text("Wyszukaj po nazwisku autora");

        Button bt3 = new Button("Wyszukaj");
        bt3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3);
        Text tx4 = new Text("Dodaj rekord");

        Button bt4 = new Button("Dodaj");
        Text ttext = new Text("");
        bt4.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler4);

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
        gridPane.add(ttext,0,4);

        Group root = new Group();
        root.getChildren().addAll(gridPane);
        Scene scene = new Scene(root, 1500, 800);
        stage.setTitle("Baza danych");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
