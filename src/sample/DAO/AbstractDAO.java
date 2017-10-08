package sample.DAO;

import sample.DB.DatabaseHandler;
import sample.Exceptions.NoUserFoundException;
import sample.Model.AbstractModel;
import sample.Model.Album;
import sample.utils.ResultSetHandler;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO <PK extends Serializable,T extends AbstractModel> {

    DatabaseHandler _handler;
    ResultSetHandler resultSetHandler;

    AbstractDAO(){
        _handler = DatabaseHandler.getInstance();
        resultSetHandler = new ResultSetHandler();
    }

    abstract void persist(T entity);
    abstract T getById(PK id);
    abstract List<T> getAll() throws NoUserFoundException;
    abstract void delete(T entity);
    abstract void update(T entity);
    abstract void insert(T entity);


}
