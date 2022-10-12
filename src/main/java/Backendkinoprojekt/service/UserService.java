package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.UserResponse;
import Backendkinoprojekt.entity.UserWithRoles;
import Backendkinoprojekt.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
