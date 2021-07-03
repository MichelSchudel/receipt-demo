package nl.craftsmen.blogdemo.api.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReceiptLineModel {

    private final OrderModel order;
    private final double totalPrice;
}
