package Backendkinoprojekt.api;


import Backendkinoprojekt.dto.UserRequest;
import Backendkinoprojekt.dto.UserResponse;
import Backendkinoprojekt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("api/users")
@RestController
@CrossOrigin
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public boolean checkLogin(@RequestBody UserRequest userRequest){
        return userService.checkLogin(userRequest);

    }

    @PostMapping()
    public boolean addUser(@RequestBody UserRequest userRequest){
        try{
            return userService.addUser(userRequest);
        }
        catch (Exception e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
