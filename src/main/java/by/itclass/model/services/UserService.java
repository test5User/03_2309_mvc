package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;
import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    private UserDao dao;

    public UserService() {
        this.dao = new UserDao();
    }

    public List<User> getByConditions(Map<String, String[]> params) {
        List<User> users = new ArrayList<>();
        var condition = params.get("condition")[0];
        switch (condition) {
            case "fio" -> {
                var fio = params.get("fio")[0];
                var user = DbInMemory.findByFio(fio);
                if (user != null) {
                    users.add(user);
                }
            }
            case "id" -> {
                int from = Integer.parseInt(params.get("from")[0]);
                int to = Integer.parseInt(params.get("to")[0]);
                users = DbInMemory.findById(from, to);
            }
        }
        return users;
    }

    public List<User> getByConditionsFomDb(Map<String, String[]> params) {
        List<User> users = new ArrayList<>();
        switch (params.get("condition")[0]) {
            case "fio" -> users.add(dao.selectByFio(params.get("fio")[0]));
            case "id" -> users = dao.selectById(Integer.parseInt(params.get("from")[0]),
                    Integer.parseInt(params.get("to")[0]));
        }
        return users.stream().filter(Objects::nonNull).toList();
    }
}
