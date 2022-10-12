package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.User;

public class UserResponse {

    private String userName;
    private String email;
    private String firstName;
    private String lastName;



    public UserResponse(User u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.userName = u.getUsername();
        this.email = u.getEmail();
    }
}
