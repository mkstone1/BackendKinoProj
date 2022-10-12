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
public class UserResponse {

    private String userName;
    private String email;
    private String firstName;
    private String lastName;



    public UserResponse(UserWithRoles u){
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.userName = u.getUsername();
        this.email = u.getEmail();
    }
}
