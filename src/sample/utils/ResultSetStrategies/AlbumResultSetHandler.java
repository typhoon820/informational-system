package sample.utils.ResultSetStrategies;

import sample.Model.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumResultSetHandler implements ResultSetStrategy {
    @Override
    public List execute(ResultSet rs) throws SQLException {
        List<Album> res = new ArrayList<>();
        Album a = new Album();
        try {
            while (rs.next()){
                if (a.getId() == rs.getInt("album_id")){
                    List<String> tmp = a.getSongsInAlbum();
                    tmp.add(rs.getString("song_name"));
                    a.setSongsInAlbum(tmp);
                }
                else {
                    if(a.getId() >0) res.add(a);
                    a = new Album();
                    List<String> tmp = new ArrayList<>();
                    a.setId(rs.getInt("album_id"));
                    a.setName(rs.getString("album_name"));
                    tmp.add(rs.getString(rs.getString("song_name")));
                    a.setSongsInAlbum(tmp);
                }
                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
