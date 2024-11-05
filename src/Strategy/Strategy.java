package Strategy;

import DO.Fruit;
import DO.Order;

import java.math.BigDecimal;
import java.util.List;

public interface Strategy {

    BigDecimal calculatePrice(List<Order> orderList, List<Fruit> fruits);
}
