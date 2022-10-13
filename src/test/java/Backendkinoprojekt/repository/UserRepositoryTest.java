package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.UserWithRoles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest
{
    @Autowired
    UserRepository userRepository;

    @BeforeAll
    public static void setUpData(@Autowired UserRepository userRepository){
        UserWithRoles u1 = new UserWithRoles("asd","asd","asd","asd","asd");
        UserWithRoles u2 = new UserWithRoles("asdf","asdf","asdf","asdf","asdf");

        userRepository.save(u1);
        userRepository.save(u2);
    }

    @Test
    void findUserWithRolesByUsername()
    {
        assertEquals("asd", userRepository.findUserWithRolesByUsername("asd").getUsername());
    }

    @Test
    public void testGetAllUsers(){
        assertEquals(2,userRepository.findAll().size());
    }

    @Test
    public void testAddUser(){
        UserWithRoles userToBeAdded = new UserWithRoles("asde","asde","asde","asde","asde");
        userRepository.save(userToBeAdded);
        assertEquals(3, userRepository.findAll().size());
    }

    @Test
    public void testDeleteUser(){
        UserWithRoles userToBeDeleted = userRepository.findUserWithRolesByUsername("asd");
        userRepository.delete(userToBeDeleted);
        assertEquals(1, userRepository.findAll().size());
    }
}