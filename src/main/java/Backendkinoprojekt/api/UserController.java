package Backendkinoprojekt.api;


import Backendkinoprojekt.dto.UserResponse;
import Backendkinoprojekt.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/users")
@RestController
@CrossOrigin
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping()
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
