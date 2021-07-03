package nl.craftsmen.blogdemo.api.mapper.request;

import nl.craftsmen.blogdemo.api.model.OrderModel;
import nl.craftsmen.blogdemo.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderModelRequestMapper {

    Order map(OrderModel orderModel) {
        return Order.builder()
                .product(orderModel.product())
                .quantity(orderModel.quantity())
                .build();
    }
}
