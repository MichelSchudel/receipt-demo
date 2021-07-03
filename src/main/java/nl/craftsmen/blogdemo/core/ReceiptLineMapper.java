package nl.craftsmen.blogdemo.core;

import nl.craftsmen.blogdemo.core.domain.Order;
import nl.craftsmen.blogdemo.core.domain.ReceiptLine;
import org.springframework.stereotype.Component;

@Component
public class ReceiptLineMapper {

    public ReceiptLine map(Order order, double price) {
        double totalPrice = price * order.quantity();
        return ReceiptLine.builder()
                .order(order)
                .totalPrice(totalPrice)
                .build();
    }
}
