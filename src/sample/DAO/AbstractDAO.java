package sample.DAO;

import sample.DB.DatabaseHandler;
import sample.Model.AbstractModel;

import java.io.Serializable;

public abstract class AbstractDAO <PK extends Serializable,T extends AbstractModel> {

    DatabaseHandler _handler;

    AbstractDAO(){
        _handler = DatabaseHandler.getInstance();
    }

    void persist(T entity) {
        _handler.execQuery("");//call database procedure
    }
}
