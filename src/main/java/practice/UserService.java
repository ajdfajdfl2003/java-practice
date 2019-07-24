package practice;

import vo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class UserService {
    private Map<Integer, User> userCache = new HashMap<>();

    public UserService() {
        User user = generateUser(2018, "Angus");
        userCache.put(user.getUserId(), user);
    }

    private User generateUser(int userId, String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        return user;
    }

    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(userCache.get(userId));
    }

    public User getUserByName(String userName) {
        Integer userId = findByUserName(userName);
        return userCache.get(userId);
    }

    private Integer findByUserName(String userName) {
        for (Entry<Integer, User> entry : userCache.entrySet()) {
            if (userName.equals(entry.getValue().getUserName())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
