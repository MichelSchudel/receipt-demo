package nl.craftsmen.blogdemo.api;

import lombok.RequiredArgsConstructor;
import nl.craftsmen.blogdemo.api.mapper.ReceiptResponseMapper;
import nl.craftsmen.blogdemo.api.mapper.ShoppingBasketRequestMapper;
import nl.craftsmen.blogdemo.api.model.ReceiptModel;
import nl.craftsmen.blogdemo.api.model.ShoppingBasketModel;
import nl.craftsmen.blogdemo.core.ReceiptService;
import nl.craftsmen.blogdemo.core.domain.Order;
import nl.craftsmen.blogdemo.core.domain.Receipt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReceiptRestController {

    private final ShoppingBasketRequestMapper shoppingBasketRequestMapper;
    private final ReceiptResponseMapper receiptResponseMapper;

    private final ReceiptService receiptService;
    @PostMapping("/receipt")
    ReceiptModel getReceipt(@Valid @RequestBody ShoppingBasketModel shoppingBasketModel) {
        List<Order> orders = shoppingBasketRequestMapper.map(shoppingBasketModel);
        Receipt receipt = receiptService.getReceipt(orders);
        return receiptResponseMapper.map(receipt);
    }


}
