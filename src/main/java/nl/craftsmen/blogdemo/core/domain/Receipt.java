package nl.craftsmen.blogdemo.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Receipt {

    private List<ReceiptLine> receiptLines;

    private double totalReceiptPrice;
}
