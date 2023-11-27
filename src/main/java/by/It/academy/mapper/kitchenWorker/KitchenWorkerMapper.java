package by.It.academy.mapper.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;
import by.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class KitchenWorkerMapper {
    public KitchenWorker buildUser(HttpServletRequest request){
        return KitchenWorker.builder()
                .firstname(request.getParameter(Constants.FIRSTNAME_PARAM))
                .surname(request.getParameter("surname"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .typeEmployee(request.getParameter("typeEmployee"))
                .build();
    }
}
