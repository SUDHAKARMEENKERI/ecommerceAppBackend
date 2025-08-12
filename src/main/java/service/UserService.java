package service;

import dao.UserRegisterRepository;
import errorHandling.ErrorResponse;
import errorHandling.UserNotFoundException;
import model.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRegisterRepository userRegisterRepository;

    public List<UserRegister> getAllUser(){
        return userRegisterRepository.findAll();
    }

    public UserRegister createUsers(UserRegister userRegister){
        return userRegisterRepository.save(userRegister);
    }

    public UserRegister updateUser(UserRegister userRegister, Long id){
        UserRegister user = getUserById(id);
        user.setFirst_name(userRegister.getFirst_name());
        user.setLast_name(userRegister.getLast_name());
        user.setEmail(userRegister.getEmail());
        user.setPhone(userRegister.getPhone());
        user.setPassword(userRegister.getPassword());
        user.setConfirm_password(userRegister.getConfirm_password());
        user.setUserAddress(userRegister.getUserAddress());
        return userRegisterRepository.save(user);
    }

    public UserRegister getUserById(Long id){
        return userRegisterRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }

    public void deleteUser(Long id){
        userRegisterRepository.deleteById(id);
    }
}
