package fit.se.bai1.entities;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class User {
    @NotBlank(message = "Ten dau bat buoc")
    private String firstName;
    @NotBlank(message = "Ten cuoi bat buoc")
    private String lastName;

    @NotBlank(message = "email bat buoc")
    @Email(message = "email phai hop le")
    private String email;

    @NotBlank(message = "Password bat buoc")
    @Size(min = 6, message = "it nhat 6 ky tu")
    private String password;

    @Past(message = "Birthday ở quá khứ")
    @NotNull(message = "nho hon hien tai")
    private LocalDate birthday;

    @NotBlank(message = "bat buoc")
    private String gender;


    public User() {

    }
    public User(LocalDate birthday, String email, String firstName, String gender, String password, String lastName) {
        this.birthday = birthday;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.password = password;
        this.lastName = lastName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
