package sample.utils.ResultSetStrategies;

import sample.Exceptions.NoUserFoundException;
import sample.Model.Album;
import sample.Model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreResultSetHandler implements ResultSetStrategy {
    @Override
    public List execute(ResultSet rs) throws SQLException, NoUserFoundException {
        List<Genre> res = new ArrayList<>();
        Genre g = new Genre();

        while (rs.next()) {
            while (rs.next()) {
                if (g.getId() == rs.getInt("genre_id")) {
                    List<String> tmp = g.getSongsOfGenre();
                    tmp.add(rs.getString("song_name"));
                    g.setSongsOfGenre(tmp);
                } else {
                    if (g.getId() > 0) res.add(g);
                    g = new Genre();
                    List<String> tmp = new ArrayList<>();
                    g.setId(rs.getInt("genre_id"));
                    g.setName(rs.getString("genre_name"));
                    tmp.add(rs.getString(rs.getString("song_name")));
                    g.setSongsOfGenre(tmp);
                }
                res.add(g);
            }

        }
        return res;
    }
}
