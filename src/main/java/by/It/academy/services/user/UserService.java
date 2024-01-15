package by.It.academy.services.user;

import by.It.academy.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> read();
    void create(User user);
    void update(User user);
    void delete(long id);
    User getLoggedUser(String login, String password);
}
