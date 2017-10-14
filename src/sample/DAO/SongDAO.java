package sample.DAO;

import sample.Exceptions.NoUserFoundException;
import sample.Model.Album;
import sample.Model.Song;
import sample.Model.SongTemp;
import sample.utils.ResultSetHandler;
import sample.utils.SongResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String query = "Select * from song_info where song_name=?";
        ResultSet rs = _handler.execPreparedQuery(query,name);
        try {
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
