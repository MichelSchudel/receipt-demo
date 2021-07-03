package nl.craftsmen.blogdemo.api.model;

import lombok.Builder;

@Builder
public record ReceiptLineModel(OrderModel order, double totalPrice) {}

