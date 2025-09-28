package fit.se.bai1.daos.impl;

import fit.se.bai1.daos.UserDAO;
import fit.se.bai1.entities.User;
import jakarta.annotation.Resource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    //@Resource(name = "jdbc/bai1userdb")
    private DataSource dataSource;
    // Constructor để tìm kiếm DataSource từ JNDI
    public UserDAOImpl() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:comp/env/jdbc/bai1userdb");
    }
    @Override
    public void saveUser(User user) throws SQLException{
        String sql = "INSERT INTO users (first_name, last_name, email, password, birthday , gender) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setObject(5, user.getBirthday());
            pstmt.setString(6, user.getGender());
            pstmt.executeUpdate();
        }

    }
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT first_name, last_name, email, birthday, gender FROM users";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday").toLocalDate());
                user.setGender(rs.getString("gender"));
                userList.add(user);
            }
        }
        return userList;
    }

}
