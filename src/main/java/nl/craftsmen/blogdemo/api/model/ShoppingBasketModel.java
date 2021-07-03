package nl.craftsmen.blogdemo.api.model;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
public class ShoppingBasketModel {

    @NotNull
    private final List<OrderModel> orders;
}
