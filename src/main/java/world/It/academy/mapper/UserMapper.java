package world.It.academy.mapper;

import world.It.academy.entities.User;
import world.It.academy.entities.Worker;
import world.It.academy.utils.Constants;

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
                .login(request.getParameter(Constants.LOGIN))
                .password(request.getParameter(Constants.PASSWORD))
                .worker(worker)
                .build();
    }
}
