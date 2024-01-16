package world.It.academy.services.user;

import world.It.academy.entities.User;

import java.util.List;

public interface UserService {
    List<User> read();
    void create(User user);
    void update(User user);
    void delete(long id);
    User getLoggedUser(String login, String password);
}
