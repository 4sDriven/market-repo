package Strategy;

import DO.Fruit;
import DO.Order;

import java.math.BigDecimal;
import java.util.List;

public class NormalPriceStrategy implements Strategy {
    @Override
    public BigDecimal calculatePrice(List<Order> orderList, List<Fruit> fruits) {

        BigDecimal count = new BigDecimal(0);

        for (Order order : orderList) {
            for (Fruit fruit : fruits) {
                if (order.getFruitId().equals(fruit.getId())) {
                    count = count.add(fruit.getPrice().multiply(order.getWeight()));
                    break;
                }
            }
        }

        return count;
    }
}
