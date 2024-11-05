package Strategy;

import DO.Discount;
import DO.Fruit;
import DO.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DiscountStrategy implements Strategy {

    private List<Discount> discounts = new ArrayList<>();

    @Override
    public BigDecimal calculatePrice(List<Order> orderList, List<Fruit> fruits) {
        BigDecimal count = new BigDecimal(0);

        for (Order order : orderList) {
            for (Fruit fruit : fruits) {
                if (order.getFruitId().equals(fruit.getId())) {
                    BigDecimal singlePrice = fruit.getPrice().multiply(order.getWeight());
                    for (Discount distcount : discounts) {
                        if (distcount.getFruitId().equals(fruit.getId())) {
                            singlePrice = singlePrice.multiply(distcount.getDiscount());
                        }
                    }
                    count = count.add(singlePrice);
                    break;
                }
            }
        }

        return count;
    }

    public void addDiscounts(Discount discount) {
        boolean isExist = false;

        if (this.discounts.size() == 0) {
            this.discounts.add(discount);
        } else {
            for (Discount item : this.discounts) {
                if (discount.getFruitId().equals(item.getFruitId())) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("ID 不存在，请重新输入");
            } else {
                this.discounts.add(discount);
            }
        }
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
