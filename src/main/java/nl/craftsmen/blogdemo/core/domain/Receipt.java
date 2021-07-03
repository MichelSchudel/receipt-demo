package nl.craftsmen.blogdemo.core.domain;

import lombok.Builder;

import java.util.List;

@Builder
public record Receipt(List<ReceiptLine> receiptLines, double totalPrice) {}

