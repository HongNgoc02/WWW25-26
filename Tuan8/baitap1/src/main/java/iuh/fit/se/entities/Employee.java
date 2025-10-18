package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First Name Khong duoc phep rong")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last Name Khong duoc phep rong")
    @Column(name = "last_name")
    private String lastName;
    @Email(message = "Email không hợp lệ")
    @NotEmpty(message = "Email không được để trống")
    @Column(unique = true)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Số điện thoại không được để trống")
    private String phone;

    @NotEmpty(message = "Giới tính không được để trống")
    private String gender;

    private String address;
}
