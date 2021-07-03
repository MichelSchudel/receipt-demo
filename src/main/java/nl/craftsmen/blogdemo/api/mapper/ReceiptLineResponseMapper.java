package nl.craftsmen.blogdemo.api.mapper;

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
                .order(orderModelResponseMapper.mapOrder(receiptLine.getOrder())).totalPrice(receiptLine.getTotalPrice()).build();
    }


}
