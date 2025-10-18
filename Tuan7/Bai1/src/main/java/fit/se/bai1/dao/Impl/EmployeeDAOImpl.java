package fit.se.bai1.dao.Impl;

import fit.se.bai1.dao.EmployeeDAO;
import fit.se.bai1.model.Employee;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// @Repository: Đánh dấu đây là một Bean DAO của Spring
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private  final DataSource dataSource;

    public EmployeeDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();// Lấy Connection từ DataSource đã cấu hình trong application.properties
    }

    private  Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role")
        );
    }


    @Override
    public void save(Employee employee) {
        String sql = "insert into employee (name, role) values (?, ?)";
        try(Connection conn =getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRole());
            stmt.executeUpdate();
            System.out.println("Luu: " + employee.getName());
        }catch (SQLException e){
            System.out.println("Loi luu: " + e.getMessage());
        }
    }

    @Override
    public Employee getById(int id) {
        String SQL = "SELECT id, name, role FROM employee WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractEmployeeFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting employee by id: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String SQL = "SELECT id, name, role FROM employee";

        // Dùng PreparedStatement hoặc Statement đều được cho câu lệnh SELECT đơn giản
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                employees.add(extractEmployeeFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error getting all employees: " + e.getMessage());
        }
        return employees;
    }

    @Override
    public void update(Employee employee) {
        String SQL = "UPDATE employee SET name = ?, role = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRole());
            stmt.setInt(3, employee.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Updated ID: " + employee.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String SQL = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Deleted ID: " + id);
            } else {
                System.out.println("⚠️ ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }


}
