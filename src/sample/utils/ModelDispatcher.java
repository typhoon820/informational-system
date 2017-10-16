package sample.utils;

import sample.Model.AbstractModel;
import sample.utils.PrintStrategies.GenrePrintStrategy;
import sample.utils.PrintStrategies.LogoPringStrategy;
import sample.utils.PrintStrategies.SongPrintStrategy;
import sample.utils.PrintStrategies.Strategy;

public class ModelDispatcher {

    public Strategy dispatch(AbstractModel model){
        switch (model.getClass().getSimpleName()){
            case "Genre":
                return new GenrePrintStrategy();
            case "SongTemp":
                return new SongPrintStrategy();
            default:
                return new LogoPringStrategy();
        }
    }
}
