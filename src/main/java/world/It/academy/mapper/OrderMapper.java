package world.It.academy.mapper;

import world.It.academy.entities.Order;
import world.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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
                .describe(request.getParameter(Constants.DESCRIBE))
                .cost(Float.parseFloat(request.getParameter(Constants.COST)))
                .address(request.getParameter(Constants.ADDRESS))
                .deliveryTime(LocalDateTime.parse(request.getParameter(Constants.DELIVERY_TIME)))
                .completed(false)
                .build();
    }
}
