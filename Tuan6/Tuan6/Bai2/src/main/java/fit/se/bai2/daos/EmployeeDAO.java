package fit.se.bai2.daos;

import fit.se.bai2.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Employee (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "city VARCHAR(255), " +
                "state VARCHAR(255), " +
                "country VARCHAR(255))";
        jdbcTemplate.execute(sql);
        System.out.println("Employee table created successfully.");
    }

    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (id, name, city, state, country) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                employee.getId(),
                employee.getName(),
                employee.getAddress().getCity(),
                employee.getAddress().getState(),
                employee.getAddress().getCountry()
        );
        System.out.println("Employee " + employee.getName() + " inserted successfully.");
    }
}
