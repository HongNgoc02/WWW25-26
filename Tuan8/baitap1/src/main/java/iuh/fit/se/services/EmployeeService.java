package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);

    public Employee findById(int id);

    public List<Employee> getList();
    // Thêm phương thức xóa
    public void deleteById(int id);

    // Thêm phương thức tìm kiếm
    public List<Employee> search(String keyword);
}
