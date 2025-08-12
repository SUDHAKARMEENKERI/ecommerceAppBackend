package controller;

import errorHandling.ErrorResponse;
import errorHandling.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import model.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users API", description = "Operations related to Users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserRegister> getAllUser(){
        return userService.getAllUser();
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public ResponseEntity<UserRegister> createUser(@Valid @RequestBody UserRegister userRegister) {
        return new ResponseEntity<UserRegister>(userService.createUsers(userRegister),HttpStatus.CREATED);
    }

    @Operation(summary = "Update users By Id")
    @PutMapping("/{id}")
    public ResponseEntity<UserRegister> updateUser(@Valid @RequestBody UserRegister userRegister, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(userRegister,id));
    }

    @Operation(summary = "Get User By Id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
        // this is traditional error handling
//       try {
//           if(ResponseEntity.ok(userService.getUserById(id)) == null){
//                return ResponseEntity.ok(userService.getUserById(id));
//           }else{
//               throw new RuntimeException("Something went wrong");
//           }
//       } catch (UserNotFoundException e){
//           ErrorResponse errorResponse = new ErrorResponse("User not found","Id" + id + "doesn't exist");
//           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//       }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse("User Not Found" , exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
