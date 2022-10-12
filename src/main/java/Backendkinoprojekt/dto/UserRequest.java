package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.User;

public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;



    public static User getUserEntity(UserRequest u){
        return new User(u.userName, u.password, u.firstName, u.lastName, u.email);
    }

    public UserRequest(User u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.userName = u.getUserName();
        this.password = u.getPassword();
        this.email = u.getEmail();

    }

}
