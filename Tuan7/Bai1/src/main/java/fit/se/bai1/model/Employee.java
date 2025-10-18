package fit.se.bai1.model;


import lombok.*;

// @Data: Tự động tạo Getters, Setters, toString, equals, hashCode
// @NoArgsConstructor: Constructor không tham số
// @AllArgsConstructor: Constructor có tất cả tham số
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String role;

    // Constructor dùng khi thêm mới (DB tự tạo ID)
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
