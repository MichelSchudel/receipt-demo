package nl.craftsmen.blogdemo.api.mapper.response;

import lombok.RequiredArgsConstructor;
import nl.craftsmen.blogdemo.api.model.ReceiptLineModel;
import nl.craftsmen.blogdemo.core.domain.ReceiptLine;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiptLineResponseMapper {

    private final OrderModelResponseMapper orderModelResponseMapper;

    ReceiptLineModel map(ReceiptLine receiptLine) {
        return ReceiptLineModel.builder()
                .order(orderModelResponseMapper
                        .mapOrder(receiptLine.order()))
                .totalPrice(receiptLine.totalPrice())
                .build();
    }


}
