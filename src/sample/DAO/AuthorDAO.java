package sample.DAO;

import sample.Model.Author;

import java.util.List;

public class AuthorDAO extends AbstractDAO<Integer, Author> {
    public AuthorDAO() {
        super();
    }

    @Override
    void persist(Author entity) {

    }

    @Override
    Author getById(Integer id) {
        return null;
    }

    @Override
    List<Author> getAll() {
        return null;
    }



    @Override
    void delete(Author entity) {

    }

    @Override
    void update(Author entity) {

    }

    @Override
    void insert(Author entity) {

    }
}
