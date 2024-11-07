package by.itclass.model.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static Connection cn;
    public static final String URL = "jdbc:mysql://localhost:3306/po_2309";

    @SneakyThrows
    public static void init() {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @SneakyThrows
    public static Connection getConnection() {
        if (cn == null || cn.isClosed()) {
            cn = DriverManager.getConnection(URL, "root", "");
        }
        return cn;
    }
}
