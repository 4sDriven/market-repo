package DO;

import Strategy.Strategy;
import Strategy.StrategyEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Market {

    private List<Fruit> fruits = new ArrayList<>();

    private Strategy strategy;

    public List<Fruit> getFruits() {
        return null == this.fruits ? new ArrayList<>() : this.fruits;
    }

    public void printFruits() {


        for (Fruit fruit : this.fruits) {

            String idStr = Optional.ofNullable(fruit.getId()).map(Object::toString).orElse("null");
            String nameStr = Optional.ofNullable(fruit.getName()).map(Object::toString).orElse("null");
            String price = Optional.ofNullable(fruit.getPrice()).map(Object::toString).orElse("null");

            System.out.println("水果ID: " + idStr + ", 名称: " + nameStr + ", 价格: " + price);
        }

    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public String getStrategyName() {
        return StrategyEnum.getNameByStrategyEnum(this.strategy);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategyId) {
        this.strategy = StrategyEnum.getStrategyClassByNum(strategyId);
    }

    public BigDecimal calculatePrice(List<Order> orderList) {
        return this.strategy.calculatePrice(orderList, this.fruits).setScale(2, RoundingMode.CEILING);
    }

    public void addFruit(Fruit fruit) {
        boolean isExist = false;

        if (this.fruits.size() == 0) {
            this.fruits.add(fruit);
        } else {
            for (Fruit item : this.fruits) {
                if (fruit.getId().equals(item.getId())) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("ID 不存在，请重新输入");
            } else {
                this.fruits.add(fruit);
            }
        }


    }
}
