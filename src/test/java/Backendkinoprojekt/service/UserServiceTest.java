package Backendkinoprojekt.service;

import Backendkinoprojekt.repository.UserRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserServiceTest {

    UserService userService;

    public static UserRepository userRepository;

/*    @BeforeAll
    public static void setUpData(@Autowired UserRepository user_Repository) {
        userRepository = user_Repository;
        UserWithRoles u1 = new UserWithRoles("username1","password1", "firstname1","lastname1", "email1");
        UserWithRoles u2 = new UserWithRoles("username2","password1", "firstname1","lastname1", "email1");

        u1.addRole(UserRoles.USER);
        u2.addRole(UserRoles.ADMIN);

        userRepository.save(u1);
        userRepository.save(u2);
    }

    @BeforeEach
    public void setUserService(){
        userService = new UserService(userRepository);
    }

    @Test
    void getAllUsers() {
        assertEquals(2,userService.getAllUsers().size());
    }

    @Test
    void checkLogin() throws Exception{
        UserWithRoles u1 = userRepository.findUserWithRolesByUsername("username1");
        UserRequest ur1 = new UserRequest(u1);
        assertTrue(userService.checkLogin(ur1));
        ur1.setPassword("test");
        ResponseStatusException error = assertThrows(ResponseStatusException.class, ()-> userService.checkLogin(ur1));
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
        ur1.setUsername("æsdfjghnpsdfn");
        ResponseStatusException error2 = assertThrows(ResponseStatusException.class, ()-> userService.checkLogin(ur1));
        assertEquals(HttpStatus.BAD_REQUEST, error2.getStatus());
    }

    @Test
    void addUser() {
        UserWithRoles u3 = new UserWithRoles("username13","password1", "firstname1","lastname1", "email1");
        UserRequest ur1 = new UserRequest(u3);
        assertTrue(userService.addUser(ur1));
        assertFalse(userService.addUser(ur1));
    }

    @Test
    void getUserByUsername() {
        UserResponse u3 = userService.getUserByUsername("username1");
        assertEquals("username1", u3.getUsername());
    }*/
}