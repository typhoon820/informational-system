package sample.utils;

import sample.Exceptions.NoUserFoundException;
import sample.Model.AbstractModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetStrategy {
    public List execute(ResultSet rs) throws SQLException, NoUserFoundException;
}
