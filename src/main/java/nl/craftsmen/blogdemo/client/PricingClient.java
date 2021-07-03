package nl.craftsmen.blogdemo.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PricingClient {

    private final PricingRestClient pricingRestClient;

    public double getPrice(String productName) {
        return pricingRestClient.getPrice(productName).price();
    }
}
