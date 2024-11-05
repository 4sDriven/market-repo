import DO.*;
import Strategy.DiscountStrategy;
import Strategy.StrategyEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Market market = new Market();


        boolean enterFruit = true;
        boolean enterOrder = true;
        boolean enterDiscount = true;
        boolean flag = true;

        System.out.println("请录入水果");


        do {
            //录入信息
            System.out.println("录入水果ID：");
            String fruitId = scanner.nextLine();

            System.out.println("录入水果名称：");
            String fruitName = scanner.nextLine();

            System.out.println("录入水果每斤价格：");
            BigDecimal price = new BigDecimal(scanner.nextLine());

            Fruit fruit = new Fruit(fruitId, fruitName, price);

            market.addFruit(fruit);
            market.printFruits();

            System.out.println("是否停止录入? Y/N");
            String confirm = scanner.nextLine();

            if ("Y".equals(confirm)) {

                enterFruit = false;

                //选择策略
                System.out.println("请选择策略");
                StrategyEnum.print();
                market.setStrategy(scanner.nextLine());

                if (market.getStrategy() instanceof DiscountStrategy) {

                    //折扣特殊处理
                    System.out.println("请录入折扣策略");

                    do {
                        System.out.println("请录入水果ID");
                        String fruitIdForDisCount = scanner.nextLine();

                        System.out.println("请录入折扣(例如: 0.8)：");
                        BigDecimal disCount = new BigDecimal(scanner.nextLine());

                        Discount discount = new Discount(fruitIdForDisCount, disCount);
                        DiscountStrategy strategy = (DiscountStrategy) market.getStrategy();
                        strategy.addDiscounts(discount);

                        System.out.print(strategy.getDiscounts());

                        System.out.println("是否停止录入? Y/N");

                        if ("Y".equals(scanner.nextLine())) {

                            enterDiscount = false;
                        }


                    } while (enterDiscount);
                }

            }

        } while (enterFruit);

        do {

            List<Order> orderList = new ArrayList<>();
            enterOrder = true;

            do {
                System.out.println("请录入订单");

                System.out.println("当前水果：");
                market.printFruits();
                System.out.println("当前策略：" + market.getStrategyName());

                //录入订单
                System.out.println("请录入水果ID：");
                String fruitId = scanner.nextLine();

                System.out.println("请录入购买斤数：");
                BigDecimal weight = new BigDecimal(scanner.nextLine());

                Order order = new Order(fruitId, weight);
                orderList.add(order);

                System.out.println("当前订单：");
                System.out.print(orderList);

                System.out.println("是否停止录入并计算价格? Y/N");

                if ("Y".equals(scanner.nextLine())) {

                    enterOrder = false;

                    //价格计算
                    System.out.println("总价：" + market.calculatePrice(orderList).toString());


                }
            } while (enterOrder);

        } while (flag);


    }
}
