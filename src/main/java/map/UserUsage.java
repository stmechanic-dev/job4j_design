package map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserUsage {
    public static void main(String[] args) {
        User user1 = new User("Petya", 2, new GregorianCalendar(2021,5, 12));
        User user2 = new User("Petya", 2, new GregorianCalendar(2021,5, 12));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(map);
    }
}
