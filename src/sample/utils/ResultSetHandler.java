package sample.utils;

import sample.Exceptions.NoUserFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResultSetHandler {
    ResultSetStrategy resultSetStrategy;

    public void setStrategy(ResultSetStrategy resultSetStrategy){
        this.resultSetStrategy = resultSetStrategy;
    }

    public List getEntities(ResultSet resultSet) throws SQLException, NoUserFoundException {
        return resultSetStrategy.execute(resultSet);
    }
}
