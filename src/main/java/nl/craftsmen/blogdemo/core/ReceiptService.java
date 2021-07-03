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

    private final ReceiptLineMapper receiptLineMapper;

    public Receipt getReceipt(List<Order> orders) {
        List<ReceiptLine> receiptLines = generateReceiptLines(orders);
        double receiptPrice = calculateTotalPrice(receiptLines);
        return Receipt.builder()
                .receiptLines(receiptLines)
                .totalPrice(receiptPrice)
                .build();
    }

    private List<ReceiptLine> generateReceiptLines(List<Order> orders) {
        return orders.stream()
                .map(order -> receiptLineMapper.map(order, pricingClient.getPrice(order.product())))
                .collect(toList());
    }

    private Double calculateTotalPrice(List<ReceiptLine> receiptLines) {
        return receiptLines.stream()
                .map(ReceiptLine::totalPrice)
                .reduce(0.0, Double::sum);
    }


}
