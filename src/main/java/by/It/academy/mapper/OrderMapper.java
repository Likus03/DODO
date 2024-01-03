package by.It.academy.mapper;

import by.It.academy.entities.Order;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

import static by.It.academy.utils.Constants.*;

public class OrderMapper {
    private static OrderMapper orderMapper;
    public static OrderMapper getInstance(){
        if(orderMapper == null){
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }

    private OrderMapper() {
    }

    public Order buildOrder(HttpServletRequest request){
        return Order.builder()
                .describe(request.getParameter(DESCRIBE))
                .cost(Float.parseFloat(request.getParameter(COST)))
                .address(request.getParameter(ADDRESS))
                .deliveryTime(LocalTime.parse(request.getParameter(DELIVERY_TIME)))
                .completed(false)
                .build();
    }
}
