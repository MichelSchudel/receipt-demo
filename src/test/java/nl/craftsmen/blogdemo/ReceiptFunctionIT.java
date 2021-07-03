package nl.craftsmen.blogdemo;

import nl.craftsmen.blogdemo.api.ReceiptRestController;
import nl.craftsmen.blogdemo.api.model.OrderModel;
import nl.craftsmen.blogdemo.api.model.ReceiptModel;
import nl.craftsmen.blogdemo.api.model.ShoppingBasketModel;
import nl.craftsmen.blogdemo.client.PriceModel;
import nl.craftsmen.blogdemo.client.PricingRestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReceiptFunctionIT {

    @Autowired
    private ReceiptRestController receiptRestController;

    @MockBean
    private PricingRestClient pricingRestClient;

    @Test
    void test_receipt_function() {
        when(pricingRestClient.getPrice(any())).thenReturn(
                PriceModel
                        .builder()
                        .price(3.50)
                        .build());

        ShoppingBasketModel shoppingBasket = ShoppingBasketModel.builder()
                .orders(List.of(OrderModel.builder()
                        .product("coffee")
                        .quantity(2)
                        .build()))
                .build();

        ReceiptModel coffee = receiptRestController.getReceipt(shoppingBasket);

        assertThat(coffee.totalReceiptPrice()).isEqualTo(7.0);
    }

}
