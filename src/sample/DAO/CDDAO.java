package sample.DAO;

import sample.Model.CD;

import java.util.List;

public class CDDAO extends AbstractDAO<Integer, CD> {
    public CDDAO() {
        super();
    }

    @Override
    void persist(CD entity) {

    }

    @Override
    CD getById(Integer id) {
        return null;
    }

    @Override
    List<CD> getAll() {
        return null;
    }

    @Override
    void delete(CD entity) {

    }

    @Override
    void update(CD entity) {

    }

    @Override
    void insert(CD entity) {

    }
}
