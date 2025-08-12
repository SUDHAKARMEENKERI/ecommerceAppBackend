package service;

import dao.UserRegisterRepository;
import model.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyAccountService {

    @Autowired
    private UserRegisterRepository userRegisterRepository;

    public UserRegister getUserDetailsByEmail(String email){
        return userRegisterRepository.findByEmail(email);
    }
}
