package nl.craftsmen.blogdemo.api.mapper;

import lombok.RequiredArgsConstructor;
import nl.craftsmen.blogdemo.api.model.ShoppingBasketModel;
import nl.craftsmen.blogdemo.core.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ShoppingBasketRequestMapper {

    private final OrderModelRequestMapper orderModelRequestMapper;

    public List<Order> map(ShoppingBasketModel shoppingBasketModel) {
        return shoppingBasketModel.getOrders().stream()
                .map(orderModelRequestMapper::map)
                .collect(toList());
    }

}
