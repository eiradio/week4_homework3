package practice3;


import java.math.BigDecimal;
import java.util.List;

public class OrderCalculate{

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public OrderCalculate(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts){
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    // Total up line items
    public BigDecimal calculateSubTotal(){
        BigDecimal subTotal = new BigDecimal(0);
        for (OrderLineItem lineItem : orderLineItemList){
            subTotal = subTotal.add(lineItem.getPrice());
        }
        return subTotal;
    }

    // Subtract discounts
    public BigDecimal subtractDiscount() {
        BigDecimal subTotal = calculateSubTotal();
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
        return subTotal;
    }



    // calculate GrandTotal
    public BigDecimal calculateGrandTotal() {
        BigDecimal subTotal = subtractDiscount();
        return subTotal.add(subTotal.multiply(tax));
    }



}
