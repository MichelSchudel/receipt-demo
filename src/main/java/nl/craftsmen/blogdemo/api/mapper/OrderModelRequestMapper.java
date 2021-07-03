package nl.craftsmen.blogdemo.api.mapper;

import nl.craftsmen.blogdemo.api.model.OrderModel;
import nl.craftsmen.blogdemo.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderModelRequestMapper {

    Order map(OrderModel orderModel) {
        return Order.builder()
                .product(orderModel.getProduct())
                .quantity(orderModel.getQuantity())
                .build();
    }
}
