package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    private OrderCalculate orderCalculate;

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
        orderCalculate = new OrderCalculate(orderLineItemList, discounts);
    }

    public BigDecimal calculate() {
        BigDecimal subTotal = new BigDecimal(0);
        return orderCalculate.calculateGrandTotal();
    }
}