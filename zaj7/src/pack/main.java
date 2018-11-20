package pack;

import javafx.application.Application;

import static java.lang.Math.abs;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class main extends Application {
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();
    TextField textField4 = new TextField();
    TextField textField5 = new TextField();
    TextField textField6 = new TextField();
    TextField textField7 = new TextField();



    GridPane gridPane = new GridPane();
    public void start(Stage stage) {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                gridPane.getChildren().remove(15);
                final NumberAxis xAxis = new NumberAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("X");
                yAxis.setLabel("f(x)");
                final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                lineChart.setTitle("wielomian");
                XYChart.Series series = new XYChart.Series();
                series.setName("wielomian");

                int a = Integer.parseInt(textField1.getText());
                int b = Integer.parseInt(textField2.getText());
                int c = Integer.parseInt(textField3.getText());
                int d = Integer.parseInt(textField4.getText());
                int z1 = Integer.parseInt(textField5.getText());
                int z2 = Integer.parseInt(textField6.getText());
                int p = Integer.parseInt(textField7.getText());
                int[] y= new int [p];
                int[] x= new int [p];
                for (int i = 0; i < p; i++) {
                    x [i] = z1 +i*abs(z2-z1)/p;
                    y [i] = (a*x[i]*x[i]*x[i]+ b*x[i]*x[i] + c*x[i] +d);
                    series.getData().add(new XYChart.Data(x[i], y[i]));
                }
                series.setName("f(x)");
                lineChart.getData().add(series);
                gridPane.add(lineChart, 0,8);
            }
        };
        Text tx = new Text("");
        Text text1 = new Text("Współczynnik przy x^3");
        Text text2 = new Text("Współczynnik przy x^2");
        Text text3 = new Text("Współczynnik przy x");
        Text text4 = new Text("Współczynnik wolny");
        Text text5 = new Text("Początek układu");
        Text text6 = new Text("Koniec układu");
        Text text7 = new Text("Próbkowanie");
        Button button1 = new Button("Rysuj");
        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);


        gridPane.setMinSize(500, 300);
        gridPane.setVgap(5);
        gridPane.setHgap(5);


        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(text4, 0, 3);
        gridPane.add(textField4, 1, 3);
        gridPane.add(text5, 0, 4);
        gridPane.add(textField5, 1, 4);
        gridPane.add(text6, 0, 5);
        gridPane.add(textField6, 1, 5);
        gridPane.add(text7, 0, 6);
        gridPane.add(textField7, 1, 6);
        gridPane.add(button1, 1,7);

        gridPane.add(tx, 0,8);
        Scene scene = new Scene(gridPane, 600, 800);
        stage.setTitle("wielomians");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String args[]){
        launch(args);
    }
}
