package nl.craftsmen.blogdemo.api.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReceiptModel {

    private final List<ReceiptLineModel> receiptLines;

    private final double totalReceiptPrice;
}
