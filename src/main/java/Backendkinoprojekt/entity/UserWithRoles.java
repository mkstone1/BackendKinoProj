package Backendkinoprojekt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserWithRoles {

    @Id
    private String username;

    private String password;
    private String firstName;

    private String lastName;

    private String email;

    private UserRoles role;

    @OneToMany(mappedBy = "userWithRoles", cascade = CascadeType.MERGE)
    List<Ticket> allTickersForUser;

    public UserWithRoles(String username, String password, String firstName, String lastName, String email){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = UserRoles.USER;
    }


    public void addRole(UserRoles role){
        this.role = role;
    }

}
