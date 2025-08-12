package service;

import dao.UserRegisterRepository;
import model.UserLogin;
import model.UserRegister;
import model.UserResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserRegisterRepository userRegisterRepository;

    @Autowired
    private UserService userService;

    public UserRegister getUserDetailByEmailId(String emailId){
        return userRegisterRepository.findByEmail(emailId);
    }

    public  UserRegister resetUserPassword(UserResetPassword userResetPassword){
        UserRegister userRegister = getUserDetailByEmailId(userResetPassword.getEmail());
        userRegister.setPassword(userResetPassword.getPassword());
        userRegister.setConfirm_password(userResetPassword.getConfirmPassword());
        return userService.updateUser(userRegister,userRegister.getId());
    }
}
