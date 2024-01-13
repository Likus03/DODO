package by.It.academy.mapper;

import by.It.academy.entities.CompletedOrder;

import javax.servlet.http.HttpServletRequest;

public class CompletedOrderMapper {
    private static CompletedOrderMapper completedOrderMapper;
    public static CompletedOrderMapper getInstance(){
        if(completedOrderMapper == null){
            completedOrderMapper = new CompletedOrderMapper();
        }
        return completedOrderMapper;
    }

    private CompletedOrderMapper() {
    }

    public CompletedOrder buildCompletedOrder(HttpServletRequest request){
        return CompletedOrder.builder()
                .idCourier((Long) request.getSession().getAttribute("idWorker"))
                .idOrder(Long.parseLong(request.getParameter("idOrder")))
                .build();
    }
}
