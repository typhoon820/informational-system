package sample.DAO;

import sample.Exceptions.NoUserFoundException;
import sample.Model.SongTemp;
import sample.utils.ResultSetStrategies.SongResultSetHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongDAO extends AbstractDAO<Integer, SongTemp> {



    public SongDAO() {
        super();
    }



    @Override
    void persist(SongTemp entity) {


    }

    @Override
    SongTemp getById(Integer id) {
        return null;
    }

    @Override
    public List<SongTemp> getAll() throws NoUserFoundException {
        resultSetHandler.setStrategy(new SongResultSetHandler());
        String query = "Select * from song_info";
        ResultSet rs = _handler.execQuery(query);
        try {
            return (List<SongTemp>)resultSetHandler.getEntities(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SongTemp> getByName(String name) throws NoUserFoundException {
        resultSetHandler.setStrategy(new SongResultSetHandler());
        PreparedStatement query =  _handler.createQuery("Select * from song_info where song_name=?");
        //String query = "Select * from song_info where song_name=?";
        //ResultSet rs = _handler.execPreparedQuery(query,name);
        try {
            query.setString(1,name);
            ResultSet rs = query.executeQuery();
            return (List<SongTemp>)resultSetHandler.getEntities(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    void delete(SongTemp entity) {

    }

    @Override
    void update(SongTemp entity) {

    }

    @Override
    void insert(SongTemp entity) {

    }
}
