package fit.se.bai2;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // 💡 Đánh dấu là một Entity được quản lý bởi JPA
@Table(name = "employee") // 💡 Ánh xạ tới bảng 'employee'
public class Employee {
    @Id // 💡 Đánh dấu khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 💡 Tự động tăng ID
    private int id;

    private String name;
    private String role;

    // Constructor dùng khi thêm mới
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
