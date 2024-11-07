package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public static final String QUERY_FIO = "SELECT id, fio, age, email FROM user WHERE fio = ?";

    public UserDao() {
        ConnectionManager.init();
    }

    public User selectByFio(String fio) {
        try (var cn = ConnectionManager.getConnection();
             var ps = cn.prepareStatement(QUERY_FIO)){
            ps.setString(1, fio);
            var rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("fio"),
                        rs.getInt("age"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> selectById(int from, int to) {
        return null;
    }
}
