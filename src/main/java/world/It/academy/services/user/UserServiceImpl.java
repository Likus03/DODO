package world.It.academy.services.user;

import world.It.academy.entities.User;
import world.It.academy.repositories.user.UserRepository;
import world.It.academy.repositories.user.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository = UserRepositoryImpl.getInstance();
    private static UserService userService;

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public List<User> read() {
        return userRepository.read();
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public User getLoggedUser(String login, String password) {
        return userRepository.getLoggedUser(login, password);
    }

}
