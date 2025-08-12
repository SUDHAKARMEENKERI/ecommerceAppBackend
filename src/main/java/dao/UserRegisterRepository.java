package dao;

import model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Long> {
    UserRegister findByEmail(String email);
}
