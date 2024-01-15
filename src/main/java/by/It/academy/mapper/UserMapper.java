package by.It.academy.mapper;

import by.It.academy.entities.User;
import by.It.academy.entities.Worker;
import by.It.academy.entities.WorkerType;

import javax.servlet.http.HttpServletRequest;

import static by.It.academy.utils.Constants.*;

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
                .password(request.getParameter(PASSWORD))
                .worker(worker)
                .build();
    }
}
