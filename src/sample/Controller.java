package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.awt.*;


public class Controller {

    @FXML
    LineChart<Number, Number>graph;
    @FXML
    Label lbl1;


    public void demand(ActionEvent event){
        XYChart.Series<Number,Number>series1=new XYChart.Series<Number, Number>();
        series1.getData().add(new XYChart.Data<Number, Number>(10,50));
        series1.getData().add(new XYChart.Data<Number, Number>(20,30));
        series1.getData().add(new XYChart.Data<Number, Number>(30,10));
        series1.setName("demand");

        graph.getData().add(series1);







    }
    public void supply(ActionEvent event){
        XYChart.Series<Number,Number>series2=new XYChart.Series<Number, Number>();
        series2.getData().add(new XYChart.Data<Number, Number>(10,10));
        series2.getData().add(new XYChart.Data<Number, Number>(20,30));
        series2.getData().add(new XYChart.Data<Number, Number>(30,50));
        series2.setName("supply");
        graph.getData().add(series2);



    }

}
