package sample.DAO;

import sample.Model.Genre;

import java.util.List;

public class GenreDAO extends  AbstractDAO<Integer, Genre>{

    public GenreDAO() {
        super();
    }

    @Override
    public void persist(Genre entity) {
        String query = "insert into GENRE (genre) values ('"+entity.getName()+"')";
        _handler.execAction(query);
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
