package nl.craftsmen.blogdemo.api.model;

import lombok.Builder;

import java.util.List;

@Builder
public record ReceiptModel(List<ReceiptLineModel> receiptLines, double totalReceiptPrice) {
}

