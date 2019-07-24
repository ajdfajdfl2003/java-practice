package demo;

import practice.UserService;
import vo.User;

import java.util.Optional;

/*
 * 因為忘記 Optional ，所以透過 https://segmentfault.com/a/1190000008692522 再練習一次
 */
public class OptionalDemo {
    public static void main(String[] args) {
        UseIfCondition();
        UseIsPresent();
    }

    private static void UseIsPresent() {
        UserService service = new UserService();
        Optional<User> user = service.getUserById(2018);
        if (user.isPresent()) {
            String username = user.get().getUserName();
            System.out.println("Username is: " + username);
        }
    }

    private static void UseIfCondition() {
        UserService service = new UserService();
        User user = service.getUserByName("Angus");
        if (user != null) {
            String username = user.getUserName();
            System.out.println("Username is: " + username);
        }
    }
}
