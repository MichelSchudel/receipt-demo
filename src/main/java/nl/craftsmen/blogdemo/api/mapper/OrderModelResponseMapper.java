package nl.craftsmen.blogdemo.api.mapper;

import nl.craftsmen.blogdemo.api.model.OrderModel;
import nl.craftsmen.blogdemo.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderModelResponseMapper {

    OrderModel mapOrder(Order order) {
        return OrderModel.builder()
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .build();
    }
}
