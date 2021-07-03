package nl.craftsmen.blogdemo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReceiptLine {

    private Order order;
    private double totalPrice;
}
