package demo;

import practice.UserService;
import vo.User;

import java.util.Optional;

/*
 * 因為忘記 Optional ，所以透過 https://segmentfault.com/a/1190000008692522 再練習一次
 */
public class OptionalDemo {
    private static UserService service;

    public static void main(String[] args) {
        service = new UserService();
        UseIfCondition();
        UseIsPresent();
        UserIfPresent();
    }

    private static void UserIfPresent() {
        Optional<User> user = service.getUserById(2018);
        user.ifPresent(u -> System.out.println(String.format("Username is: %s", u.getUserName())));
    }

    private static void UseIsPresent() {
        Optional<User> user = service.getUserById(2018);
        if (user.isPresent()) {
            String username = user.get().getUserName();
            System.out.println(String.format("Username is: %s", username));
        }
    }

    private static void UseIfCondition() {
        User user = service.getUserByName("Angus");
        if (user != null) {
            String username = user.getUserName();
            System.out.println(String.format("Username is: %s", username));
        }
    }
}
