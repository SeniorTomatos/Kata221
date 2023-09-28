package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Car 1", 2001)));
        userService.add(new User("User2", "Lastname2", "user1@mail.ru", new Car("Car 2", 2002)));
        userService.add(new User("User3", "Lastname3", "user1@mail.ru", new Car("Car 3", 2003)));

        userService.getAllUsers();

        System.out.println(userService.getUserByCar("Car 1", 2001));
        System.out.println(userService.getUserByCar("Car 2", 2002));

        context.close();
    }
}
