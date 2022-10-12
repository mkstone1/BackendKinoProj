package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Bruger;

public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;



    public static Bruger getUserEntity(UserRequest u){
        return new Bruger(u.userName, u.password, u.firstName, u.lastName, u.email);
    }

    public UserRequest(Bruger u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.userName = u.getUsername();
        this.password = u.getPassword();
        this.email = u.getEmail();

    }

}
