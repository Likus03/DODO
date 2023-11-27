package by.It.academy.mapper.manager;

import by.It.academy.entities.Manager;
import by.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class ManagerMapper {
    public Manager buildUser(HttpServletRequest request){
        return Manager.builder()
                .firstname(request.getParameter(Constants.FIRSTNAME_PARAM))
                .surname(request.getParameter("surname"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .build();
    }
}
