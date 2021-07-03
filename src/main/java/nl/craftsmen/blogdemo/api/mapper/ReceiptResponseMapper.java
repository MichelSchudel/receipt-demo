package nl.craftsmen.blogdemo.api.mapper;

import lombok.RequiredArgsConstructor;
import nl.craftsmen.blogdemo.api.model.ReceiptModel;
import nl.craftsmen.blogdemo.core.domain.Receipt;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ReceiptResponseMapper {

    private final ReceiptLineResponseMapper receiptLineResponseMapper;

    public ReceiptModel map(Receipt receipt) {
        return ReceiptModel.builder()
                .receiptLines(receipt.getReceiptLines()
                        .stream()
                        .map(receiptLineResponseMapper::map)
                        .collect(toList()))
                .totalReceiptPrice(receipt.getTotalReceiptPrice())
                .build();
    }


}
