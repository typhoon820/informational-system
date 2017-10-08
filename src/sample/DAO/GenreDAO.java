package sample.DAO;

import sample.Model.Genre;

import java.util.List;

public class GenreDAO extends  AbstractDAO<Integer, Genre>{

    public GenreDAO() {
        super();
    }

    @Override
    void persist(Genre entity) {

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
