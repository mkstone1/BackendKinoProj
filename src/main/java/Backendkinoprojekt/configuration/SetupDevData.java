package Backendkinoprojekt.configuration;

import Backendkinoprojekt.entity.*;
import Backendkinoprojekt.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class SetupDevData implements ApplicationRunner {


    MovieRepository movieRepository;
    TheaterRepository theaterRepository;
    TicketRepository ticketRepository;
    ScreeningRepository screeningRepository;

    UserRepository userRepository;

    public SetupDevData(MovieRepository movieRepository, TheaterRepository theaterRepository, TicketRepository ticketRepository, ScreeningRepository screeningRepository,    UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Theater t1 = new Theater(20, 12, "Lille sal");
        Theater t2 = new Theater(25, 16, "Stor sal");

        Movie m1 = new Movie("Pirates", "Adventure", 13, "Johnny", 120);
        Movie m2 = new Movie("HorrorMovie1", "Horror", 18, "HorrorActor",160);
        Movie m3 = new Movie("Lord of the rings 1", "Adventure", 10, "Viggo",170);
        Movie m4 = new Movie("Lord of the rings 2", "Adventure", 10, "Viggo",180);
        Movie m5 = new Movie("Lord of the rings 3", "Adventure", 10, "Viggo",200);
        Movie m6 = new Movie("Pulp fiction", "Tarantino", 10, "Tarantino",150);


        movieRepository.save(m1);
        movieRepository.save(m2);
        movieRepository.save(m3);
        movieRepository.save(m4);
        movieRepository.save(m5);
        movieRepository.save(m6);


        theaterRepository.save(t1);
        theaterRepository.save(t2);
        LocalDateTime ldt1 = LocalDateTime.of(2022, 10, 10, 18, 15);
        LocalDateTime ldt2 = LocalDateTime.of(2022, 10, 11, 16, 45);
        LocalDateTime ldt3 = LocalDateTime.of(2022, 10, 12, 15, 30);
        LocalDateTime ldt4 = LocalDateTime.of(2022, 10, 13, 15, 30);



        Screening s1 = new Screening(t1,m1,ldt1, 100);
        Screening s2 = new Screening(t2,m1,ldt1, 200);
        Screening s3 = new Screening(t2,m2,ldt3, 200);
        Screening s4 = new Screening(t2,m2,ldt4, 200);
        Screening s5 = new Screening(t2,m3,ldt1, 250);
        Screening s6 = new Screening(t1,m4,ldt2, 300);
        Screening s7 = new Screening(t2,m4,ldt3, 400);
        Screening s8 = new Screening(t2,m5,ldt4, 150);
        Screening s9 = new Screening(t1,m5,ldt1, 300);
        Screening s10 = new Screening(t2,m5,ldt2, 250);
        Screening s11 = new Screening(t2,m6,ldt3, 200);
        Screening s12 = new Screening(t1,m6,ldt4, 250);
        Screening s13 = new Screening(t2,m1,ldt4, 300);
        Screening s14 = new Screening(t2,m1,ldt1, 400);


        screeningRepository.save(s1);
        screeningRepository.save(s2);
        screeningRepository.save(s3);
        screeningRepository.save(s4);
        screeningRepository.save(s5);
        screeningRepository.save(s6);
        screeningRepository.save(s7);
        screeningRepository.save(s8);
        screeningRepository.save(s9);
        screeningRepository.save(s10);
        screeningRepository.save(s11);
        screeningRepository.save(s12);
        screeningRepository.save(s13);
        screeningRepository.save(s14);


        UserWithRoles u1 = new UserWithRoles("username1","password1", "firstname1","lastname1", "email1");
        UserWithRoles u2 = new UserWithRoles("username2","password1", "firstname1","lastname1", "email1");
        UserWithRoles u3 = new UserWithRoles("username3","password1", "firstname1","lastname1", "email1");
        UserWithRoles u4 = new UserWithRoles("username4","password1", "firstname1","lastname1", "email1");
        UserWithRoles u5 = new UserWithRoles("username5","password1", "firstname1","lastname1", "email1");
        UserWithRoles u6 = new UserWithRoles("username6","password1", "firstname1","lastname1", "email1");
        UserWithRoles u7 = new UserWithRoles("username7","password1", "firstname1","lastname1", "email1");

        u1.addRole(UserRoles.USER);
        u2.addRole(UserRoles.USER);
        u3.addRole(UserRoles.USER);
        u4.addRole(UserRoles.USER);
        u5.addRole(UserRoles.ADMIN);
        u6.addRole(UserRoles.ADMIN);
        u7.addRole(UserRoles.ADMIN);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);





        Ticket ticket1 = new Ticket(1, 1, s1, u1);
        Ticket ticket2 = new Ticket(2, 3, s1, u1);
        Ticket ticket3 = new Ticket(3, 4, s1, u1);
        Ticket ticket4 = new Ticket(4, 5, s1, u1);
        Ticket ticket5 = new Ticket(5, 6, s1, u1);
        Ticket ticket6 = new Ticket(6, 7, s1, u1);
        Ticket ticket7 = new Ticket(7, 8, s1, u1);
        Ticket ticket8 = new Ticket(8, 9, s8,u1);
        Ticket ticket9 = new Ticket(9, 10, s9, u2);
        Ticket ticket10 = new Ticket(10, 11, s10, u3);


        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);
        ticketRepository.save(ticket3);
        ticketRepository.save(ticket4);
        ticketRepository.save(ticket5);
        ticketRepository.save(ticket6);
        ticketRepository.save(ticket7);
        ticketRepository.save(ticket8);
        ticketRepository.save(ticket9);
        ticketRepository.save(ticket10);




    }
}
