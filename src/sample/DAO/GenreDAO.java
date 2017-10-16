package sample.DAO;

import sample.Model.Genre;

import javax.management.Query;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GenreDAO extends  AbstractDAO<Integer, Genre>{

    public GenreDAO() {
        super();
    }

    @Override
    public void persist(Genre entity) {
        PreparedStatement sql = _handler.createQuery("insert into GENRE (genre) values (?)");
        try {
            sql.setString(1,entity.getName());
            boolean b = sql.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    Genre getById(Integer id) {


        return null;
    }

    @Override
    List<Genre> getAll() {
        return null;
    }

    @Override
    void delete(Genre entity) {

    }

    @Override
    void update(Genre entity) {

    }

    @Override
    void insert(Genre entity) {

    }
}
