package by.It.academy.mapper.manager;

import by.It.academy.entities.Manager;
import by.It.academy.entities.UserType;
import by.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class ManagerMapper {
    public Manager buildUser(HttpServletRequest request){
        return Manager.builder()
                .firstname(request.getParameter(Constants.FIRSTNAME_PARAM))
                .surname(request.getParameter("surname"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .userType(UserType.USER.equals(UserType.valueOf(request.getParameter("role").toUpperCase()))?UserType.USER:UserType.ADMIN)
                .build();
    }
}
