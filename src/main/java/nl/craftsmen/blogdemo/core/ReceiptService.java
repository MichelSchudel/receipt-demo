package nl.craftsmen.blogdemo.core;

import lombok.RequiredArgsConstructor;
import nl.craftsmen.blogdemo.client.PricingClient;
import nl.craftsmen.blogdemo.core.domain.Order;
import nl.craftsmen.blogdemo.core.domain.Receipt;
import nl.craftsmen.blogdemo.core.domain.ReceiptLine;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final PricingClient pricingClient;

    public Receipt getReceipt(List<Order> orders) {
        List<ReceiptLine> receiptLines = orders.stream()
                .map(this::map)
                .collect(toList());
        double receiptPrice = receiptLines.stream()
                .map(ReceiptLine::getTotalPrice)
                .reduce(0.0, Double::sum);
        return Receipt.builder()
                .receiptLines(receiptLines)
                .totalReceiptPrice(receiptPrice)
                .build();
    }

    private ReceiptLine map(Order order) {
        double price = pricingClient.getPrice(order.getProduct());
        double totalPrice = price * order.getQuantity();
        return ReceiptLine.builder()
                .order(order)
                .totalPrice(totalPrice)
                .build();
    }

}
