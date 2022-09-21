package ru.uleev.springmvcapp.config.dao;

import org.springframework.stereotype.Component;
import ru.uleev.springmvcapp.config.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int peopleCount;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++peopleCount, "Tom",24,"tomsoyer@mail.ru"));
        users.add(new User(++peopleCount, "Bill",36,"bolokon@mail.ru"));
        users.add(new User(++peopleCount, "Mikhael",48,"iomsoyer@mail.ru"));
        users.add(new User(++peopleCount, "Robert",39,"yasaasr@mail.ru"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++peopleCount);
        users.add(user);
    }

    public void update(int id,User updateUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setAge(updateUser.getAge());
        userToBeUpdated.setEmail(updateUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(u -> u.getId()==id);
    }

}
