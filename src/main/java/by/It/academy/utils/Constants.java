package by.It.academy.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class Constants {
    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String DESCRIBE = "describe";
    public static final String COST = "cost";
    public static final String ADDRESS = "address";
    public static final String DELIVERY_TIME = "deliveryTime";

    public static void russianLang(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
    }
}
