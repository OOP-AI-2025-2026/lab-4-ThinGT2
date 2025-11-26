package ua.opnu;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double totalNoDiscount;  
    private double totalWithDiscount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.totalNoDiscount = 0.0;
        this.totalWithDiscount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);

        double price = i.getPrice();
        double discount = i.getDiscount();

        totalNoDiscount += price;

        if (regularCustomer && discount > 0.0) {
            discountCount++;
            discountAmount += discount;
            totalWithDiscount += price - discount;
        } else {
    
            totalWithDiscount += price;
        }
    }

    @Override
    public double getTotal() {

        if (!regularCustomer) {
            return totalNoDiscount;
        }
        return totalWithDiscount;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || totalNoDiscount == 0) {
            return 0.0;
        }

        return 100 - (totalWithDiscount * 100.0 / totalNoDiscount);
    }
}
