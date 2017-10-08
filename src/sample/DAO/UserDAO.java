package sample.DAO;

import sample.Exceptions.NoUserFoundException;
import sample.Model.User;
import sample.utils.UserResultSetStrategy;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User> {



    @Override
    public void persist(User entity) {
        String proc = "SaveNewUser(?,?,?)";
        List<Object> args = new ArrayList<>();
        args.add(entity.getLogin());
        args.add(entity.getPassword());
        args.add(entity.getStatus());
        _handler.execCallableStatement(proc, args);
    }

    public User getByLogin(String login) throws SQLException, NoUserFoundException {
        String query = "Select * from view_user_status where login=?;";
        ResultSet set = _handler.execPreparedQuery(query,login);
        resultSetHandler.setStrategy(new UserResultSetStrategy());
        List <User> res = resultSetHandler.getEntities(set);
        if (res.size() >0) return res.get(0);
        throw new NoUserFoundException("No user found with that login");
    }

    @Override
    User getById(Integer id) {
        return null;
    }

    @Override
    List<User> getAll() {
        return null;
    }

    @Override
    void delete(User entity) {

    }

    @Override
    void update(User entity) {

    }

    @Override
    void insert(User entity) {

    }
}
