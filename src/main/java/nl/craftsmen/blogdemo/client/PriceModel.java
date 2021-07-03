package nl.craftsmen.blogdemo.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PriceModel {
    private final double price;
}
