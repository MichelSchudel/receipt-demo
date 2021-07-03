package nl.craftsmen.blogdemo.core.domain;

import lombok.Builder;

@Builder
public record ReceiptLine(Order order, double totalPrice) {}
