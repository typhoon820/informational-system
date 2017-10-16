package sample.DAO;

import sample.Exceptions.NoUserFoundException;
import sample.Model.Album;
import sample.utils.ResultSetStrategies.AlbumResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumDAO extends AbstractDAO<Integer,Album> {



    public AlbumDAO() {
        super();
    }

    @Override
    public void persist(Album entity) {

    }

    @Override
    public Album getById(Integer id) {
        return null;
    }

    public Album getByName(String name) throws NoUserFoundException {
        resultSetHandler.setStrategy(new AlbumResultSetHandler());
        String query = "Select * from album_info where album_name=?";
        ResultSet rs = _handler.execPreparedQuery(query, name);
        try {
            return (Album)resultSetHandler.getEntities(rs).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    List<Album> getAll() {
        return null;
    }

    @Override
    void delete(Album entity) {

    }

    @Override
    void update(Album entity) {

    }

    @Override
    void insert(Album entity) {

    }

}
