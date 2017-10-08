package sample.utils;

import sample.Model.AbstractModel;
import sample.Model.SongTemp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongResultSetHandler implements ResultSetStrategy {

    @Override
    public List<SongTemp> execute(ResultSet rs) throws SQLException {
        List<SongTemp> res = new ArrayList<>();
        SongTemp s = new SongTemp();
        try {
            while (rs.next()){
                if (s.getId() == rs.getInt("song_id")){
                    List<String> tmp = s.getAlbums();
                    tmp.add(rs.getString("song_album"));
                    s.setAlbums(tmp);
                }
                else {
                    if(s.getId() >0) res.add(s);
                    s = new SongTemp();
                    List<String> tmp = new ArrayList<>();
                    s.setId(rs.getInt("song_id"));
                    s.setSongName(rs.getString("song_name"));
                    s.setAuthor(rs.getString("author_name"));
                    s.setGenre(rs.getString("song_genre"));
                    tmp.add(rs.getString(rs.getString("song_album")));
                    s.setAlbums(tmp);
                    s.setCds(rs.getInt("copies"));
                    s.setVersion(rs.getString("version"));

                }
                res.add(s);

                //res.add(new Song(id,songName,author,genre,album,copies,version));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

}
