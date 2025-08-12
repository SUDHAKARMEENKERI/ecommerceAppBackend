package controller;

import errorHandling.ErrorResponse;
import errorHandling.UserNotFoundException;
import model.UserRegister;
import model.VerifyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.VerifyAccountService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("user/accountVerify")
@RestController
public class VerifyAccountController {
    @Autowired
    private VerifyAccountService verifyAccountService;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> getUserDetailsByEmail(@RequestBody VerifyAccount userVerifyDetails) {
        UserRegister userDetails = verifyAccountService.getUserDetailsByEmail(userVerifyDetails.getEmail());
        Map<String, Object> response = null;
        if (userDetails != null && userDetails.getEmail().equals(userVerifyDetails.getEmail())) {
            response = new HashMap<>();
            response.put("email", userDetails.getEmail());
            response.put("phone", userDetails.getPhone());
            response.put("isAccountActive", true);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse("User Not Found" , exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
