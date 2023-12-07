package by.It.academy.mapper;

import by.It.academy.entities.UserType;
import by.It.academy.entities.Worker;
import by.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class WorkerMapper {
    public Worker buildUser(HttpServletRequest request){
        return Worker.builder()
                .firstname(request.getParameter(Constants.FIRSTNAME_PARAM))
                .surname(request.getParameter("surname"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .userType(UserType.valueOf(request.getParameter("role").toUpperCase()))
                .build();
    }
}
