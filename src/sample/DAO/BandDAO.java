package sample.DAO;

import sample.Model.Band;

import java.util.List;

public class BandDAO extends AbstractDAO<Integer, Band> {

    public BandDAO() {
        super();
    }

    @Override
    void persist(Band entity) {

    }

    @Override
    Band getById(Integer id) {
        return null;
    }

    @Override
    List<Band> getAll() {
        return null;
    }

    @Override
    void delete(Band entity) {

    }

    @Override
    void update(Band entity) {

    }

    @Override
    void insert(Band entity) {

    }
}
