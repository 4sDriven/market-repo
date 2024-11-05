package DO;

import java.math.BigDecimal;

public class Discount {
    private String fruitId;
    private BigDecimal discount;

    public Discount(String fruitId, BigDecimal discount) {
        this.fruitId = fruitId;
        this.discount = discount;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "折扣{" +
                "水果ID='" + fruitId + '\'' +
                ", 折扣=" + discount +
                '}';
    }
}
