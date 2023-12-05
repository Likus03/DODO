package by.It.academy.mapper.courier;

import by.It.academy.controllers.courier.CreateCourierController;
import by.It.academy.entities.Courier;
import by.It.academy.entities.UserType;
import by.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class CourierMapper {
    public Courier buildUser(HttpServletRequest request){
        return Courier.builder()
                .firstname(request.getParameter(Constants.FIRSTNAME_PARAM))
                .surname(request.getParameter("surname"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .deliveryType(request.getParameter("deliveryType"))
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .userType(UserType.USER.equals(UserType.valueOf(request.getParameter("role")))?UserType.USER:UserType.ADMIN)
                .build();
    }
}
