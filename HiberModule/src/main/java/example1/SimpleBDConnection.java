package example1;

import example1.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleBDConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String SQL = "insert into users(id,name) values (?,?)";

    public static void main(String[] args) {
        System.out.println("Test connection");

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(SQL);
            List<User> userList = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                userList.add(new User(i, "Hello " + i));
            }

            for (User user :
                    userList) {
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                int i = statement.executeUpdate();

            }
            statement.close();
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }

    }
}
