package DO;

import java.math.BigDecimal;

public class Order {

    private String fruitId;

    private BigDecimal weight;

    public Order(String fruitId, BigDecimal weight) {
        this.fruitId = fruitId;
        this.weight = weight;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "订单： " +
                "水果ID='" + fruitId + '\'' +
                ", 重量=" + weight +
                ' ';
    }
}
