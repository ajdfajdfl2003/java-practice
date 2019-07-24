package demo;

import practice.UserService;
import vo.User;

public class OptionalDemo {
    public static void main(String[] args) {
        UseIfCondition();
    }

    private static void UseIfCondition() {
        UserService service = new UserService();
        User user = service.getUserById("aaa");
        if (user != null) {
            String username = user.getUserName();
            System.out.println("Username is: " + username);
        }
    }
}
