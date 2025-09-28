package fit.se.bai1jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ten dau bat buoc")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "ten cuoi bat buoc")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = " email bat buoc")
    @Email(message = "email co gia tri")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password bat buoc")
    @Size(min = 6, message = "Password it nhất 6 ký tự")
    private String password;

    @Past(message = "Birthday nhỏ hơn hien tại")
    @NotNull(message = "Birthday bat buoc")
    private LocalDate birthday;

    @NotNull(message = "Gender bat buoc")
    private String gender;

    public  User(){

    }
    public User(LocalDate birthday, String email, String firstName, String gender, Long id, String lastName, String password) {
        this.birthday = birthday;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.lastName = lastName;
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
