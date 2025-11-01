package model;

import converter.UserAddressConverter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "user_register")
public class UserRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    @NotBlank(message = "First name required")
    private String first_name;
    @Column
    @NotBlank(message = "Last name required")
    private String last_name;
    @Column
    @NotBlank(message = "Email required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    @Size(min = 10, max = 10)
    @NotBlank(message = "Phone number required")
    @Column
    private String phone;
    @Column
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain uppercase, lowercase, digit, special character and length should be 8"
    )
    private String password;
    @Column
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain uppercase, lowercase, digit, special character and length should be 8"
    )
    private String confirm_password;

    @NotNull(message = "address required")
    @Column(columnDefinition = "json")
    @Valid
    @Convert(converter = UserAddressConverter.class)
    private UserAddress address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public UserAddress getUserAddress() {
        return address;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.address = userAddress;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", confirm_password='" + confirm_password + '\'' +
                ", userAddress=" + address +
                '}';
    }
}