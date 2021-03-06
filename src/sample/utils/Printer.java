package sample.utils;


import javafx.scene.layout.GridPane;
import sample.Model.AbstractModel;
import sample.utils.PrintStrategies.Strategy;

public class Printer{
    Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }


    public void print (GridPane gridPane, AbstractModel model){
        strategy.execute(gridPane, model);
    }
}
