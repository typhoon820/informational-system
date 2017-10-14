package sample.Model;

/**
 * Created by Никита on 29.09.2017.
 */
public abstract class AbstractModel {

    @Override
    public String toString(){

        return this.getClass().getSimpleName();

    }
}
