package sample.utils.ResultSetStrategies;

import sample.Exceptions.NoUserFoundException;
import sample.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultSetStrategy implements ResultSetStrategy {
    @Override
    public List<User> execute(ResultSet rs) throws SQLException, NoUserFoundException {
        List<User> res = new ArrayList<>();
        User u = new User();
        while (rs.next()){
            u.setId(rs.getInt("id"));
            u.setLogin(rs.getString("login"));
            u.setPassword(rs.getString("password"));
            u.setStatus(rs.getString("status"));
            res.add(u);
        }
        if (res.size() == 0) throw new NoUserFoundException("No user found with such login");
        return res;
    }
}
