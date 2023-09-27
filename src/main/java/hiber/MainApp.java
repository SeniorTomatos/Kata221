package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");


        userService.add(user1.setUserCar(new Car("Car 1", 2001)).setUser(user1));
        userService.add(user2.setUserCar(new Car("Car 2", 2002)).setUser(user2));
        userService.add(user3.setUserCar(new Car("Car 3", 2003)).setUser(user3));
        userService.add(user4.setUserCar(new Car("Car 4", 2004)).setUser(user4));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.printf("%s`s car = %s\n", user.getFirstName(), user.getUserCar());
            System.out.println();
        }

        System.out.println(userService.getUserByCar("Car 1", 2001));
        System.out.println(userService.getUserByCar("Car 2", 2002));

        context.close();
    }
}
