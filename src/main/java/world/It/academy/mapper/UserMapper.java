package world.It.academy.mapper;

import world.It.academy.entities.User;
import world.It.academy.entities.Worker;
import static world.It.academy.utils.Constants.*;
import world.It.academy.utils.PasswordHashing;

import javax.servlet.http.HttpServletRequest;

public class UserMapper {
    private static UserMapper userMapper;
    public static UserMapper getInstance(){
        if(userMapper == null){
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    private UserMapper() {
    }

    public User buildWorker(HttpServletRequest request, Worker worker) {
        return User.builder()
                .login(request.getParameter(LOGIN))
                .password(PasswordHashing.hash(request.getParameter(PASSWORD)))
                .worker(worker)
                .build();
    }
}
