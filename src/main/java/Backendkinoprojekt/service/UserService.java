package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.UserRequest;
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

    public boolean checkLogin(UserRequest userRequest) {
        UserWithRoles userToCheck = userRepository.findUserWithRolesByUsername(userRequest.getUserName());
        return true;
    }

    public boolean addUser(UserRequest userRequest){
        try{
            UserWithRoles newUser = UserRequest.getUserEntity(userRequest);
            userRepository.save(newUser);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }









}
