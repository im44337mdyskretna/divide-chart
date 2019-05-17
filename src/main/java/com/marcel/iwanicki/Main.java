package com.marcel.iwanicki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("LICZBY PIERWSZE CZESC II");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("y");

        //creating the chart
        final XYChart<Number,Number> scatterChart =
                new ScatterChart<Number, Number>(xAxis,yAxis);

        scatterChart.setTitle("Wykres relacji podzielności");

        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("y | x");

        //populating chart
        for(int x=1; x<=100; x++)
            for(int y=1; y<=100; y++)
                if(x % y == 0)
                    series.getData().add(new XYChart.Data(x, y));

        Scene scene  = new Scene(scatterChart,800,600);
        scatterChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

}
