package controller;

import errorHandling.ErrorResponse;
import errorHandling.UserNotFoundException;
import model.UserLogin;
import model.UserRegister;
import model.UserResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.UserLoginService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/login")
    private ResponseEntity<Map<String, Object>> getUserDetailByEmailId(@RequestBody UserLogin userLogin){
        UserRegister userRegister = userLoginService.getUserDetailByEmailId(userLogin.getEmail());
        Map<String,Object> response = null;
        if(userRegister.getEmail().equals((userRegister.getEmail()))
                && userRegister.getPassword().equals(userLogin.getPassword())){
                response = new HashMap<>();
                response.put("email", userRegister.getEmail());
                response.put("isAccountActive",true);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resetUserPassword")
    private ResponseEntity<Map<String, Object>> resetUserPassword(@RequestBody UserResetPassword userResetPassword){
        UserRegister userRegister = userLoginService.resetUserPassword(userResetPassword);
        System.out.println("respond " + userRegister);
        if(userResetPassword.getPassword().equals(userResetPassword.getConfirmPassword())){
            Map<String, Object> response = null;
            response = new HashMap<>();
            response.put("status","Password reset successfully");
            response.put("email",userRegister.getEmail());
            return ResponseEntity.ok(response);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "InValid password or ConfirmPassword");
        }
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse("User Not Found" , exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
