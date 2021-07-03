package nl.craftsmen.blogdemo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {

    private String product;
    private int quantity;
}
