package world.It.academy.mapper;

import world.It.academy.entities.Order;
import static world.It.academy.utils.Constants.*;

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
                .describe(request.getParameter(DESCRIBE))
                .cost(Float.parseFloat(request.getParameter(COST)))
                .address(request.getParameter(ADDRESS))
                .deliveryTime(LocalDateTime.parse(request.getParameter(DELIVERY_TIME)))
                .completed(false)
                .build();
    }
}
