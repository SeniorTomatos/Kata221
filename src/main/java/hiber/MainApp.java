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

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("Car1", 2001);
        Car car2 = new Car("Car2", 2002);
        Car car3 = new Car("Car3", 2003);
        Car car4 = new Car("Car4", 2004);

        userService.add(user1.setUserCar(car1).setUser(user1));
        userService.add(user2.setUserCar(car2).setUser(user2));
        userService.add(user3.setUserCar(car3).setUser(user3));
        userService.add(user4.setUserCar(car4).setUser(user4));

        userService.getAllUsers();

        System.out.println(userService.getUserByCar("Car 1", 2001));
        System.out.println(userService.getUserByCar("Car 2", 2002));

        context.close();
    }
}
