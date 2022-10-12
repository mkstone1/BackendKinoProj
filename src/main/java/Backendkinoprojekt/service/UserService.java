package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.UserRequest;
import Backendkinoprojekt.dto.UserResponse;
import Backendkinoprojekt.entity.UserWithRoles;
import Backendkinoprojekt.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<UserResponse> getAllUsers() {
        List<UserWithRoles> allUserWithRoles = userRepository.findAll();
        List<UserResponse> allUsersResponse = allUserWithRoles.stream().map(user -> new UserResponse(user)).collect(Collectors.toList());
        return allUsersResponse;
    }

    public boolean checkLogin(UserRequest userRequest) {
        UserWithRoles userToCheck = userRepository.findUserWithRolesByUsername(userRequest.getUserName());
        if (!(userToCheck == null)){
            return true;
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Brugernavn findes ikke");
        }
    }
}
