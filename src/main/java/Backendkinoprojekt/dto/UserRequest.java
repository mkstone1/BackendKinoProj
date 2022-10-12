package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.UserWithRoles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;



    public static UserWithRoles getUserEntity(UserRequest u){
        return new UserWithRoles(u.userName, u.password, u.firstName, u.lastName, u.email);
    }

    public UserRequest(UserWithRoles u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.userName = u.getUsername();
        this.password = u.getPassword();
        this.email = u.getEmail();

    }

}
