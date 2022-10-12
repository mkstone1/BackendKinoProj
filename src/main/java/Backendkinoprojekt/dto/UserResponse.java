package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Bruger;

public class UserResponse {

    private String userName;
    private String email;
    private String firstName;
    private String lastName;



    public UserResponse(Bruger u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.userName = u.getUsername();
        this.email = u.getEmail();
    }
}
