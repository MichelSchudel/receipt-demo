package nl.craftsmen.blogdemo.api.model;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
public class OrderModel {

    @NotNull
    private final String product;

    @Positive
    private final int quantity;
}
