package Strategy;


import java.util.Arrays;
import java.util.List;

public enum StrategyEnum {

    NORMAL("1", "正常价格", new NormalPriceStrategy()),
    DISCOUNT("2", "折扣", new DiscountStrategy()),
    PROMOTION("3", "满减", new PromotionStrategy());

    private String num;
    private String name;
    private Strategy strategy;


    StrategyEnum(String num, String name, Strategy strategy) {
        this.num = num;
        this.name = name;
        this.strategy = strategy;
    }

    public static void print() {
        for (StrategyEnum strategyEnum : StrategyEnum.values()) {
            System.out.println(strategyEnum.num + "." + strategyEnum.name);
        }
    }

    // 获取包含所有枚举对象的 List
    public static List<StrategyEnum> getAllStrategies() {
        return Arrays.asList(StrategyEnum.values());
    }

    // 通过枚举实例获取对应的名称
    public static String getNameByStrategyEnum(Strategy strategy) {

        for (StrategyEnum strategyEnum : StrategyEnum.values()) {
            if (strategyEnum.strategy.equals(strategy)) {
                return strategyEnum.name;
            }
        }

        throw new RuntimeException("该策略不存在");
    }

    // 根据数字获取对应的策略
    public static Strategy getStrategyClassByNum(String num) {

        for (StrategyEnum strategyEnum : StrategyEnum.values()) {
            if (strategyEnum.num.equals(num)) {
                return strategyEnum.strategy;
            }
        }

        throw new RuntimeException("该策略不存在");
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}
