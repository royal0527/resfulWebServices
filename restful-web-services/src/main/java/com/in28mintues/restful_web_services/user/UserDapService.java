package com.in28mintues.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Component
public class UserDapService {

    //uerDaoService - staticList
    private static List<User> users = new ArrayList<>();
    private static Long count=0L;

    /*static {
        users.add(new User(++count, "rajusk", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "rahul", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "rose", LocalDate.now().minusYears(30)));
    }*/

    public List<User> AllUsers() {
        return users;
    }

    public User findById(Long id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }

    public boolean deleteById(Long id) {
        Predicate<? super  User> predicate = user -> user.getId().equals(id);
        return users.remove(predicate);

    }
}
