package ua.opnu;

public class DiscountBill2 {

    private GroceryBill bill;
    private boolean regularCustomer;

    private int discountCount = 0;
    private double discountAmount = 0.0;
    private double totalNoDiscount = 0.0;
    private double totalWithDiscount = 0.0;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item i) {
        bill.add(i);

        double price = i.getPrice();
        double discount = i.getDiscount();

        totalNoDiscount += price;

        if (regularCustomer && discount > 0) {
            discountCount++;
            discountAmount += discount;
            totalWithDiscount += price - discount;
        } else {
            totalWithDiscount += price;
        }
    }

    public double getTotal() {
        return regularCustomer ? totalWithDiscount : totalNoDiscount;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || totalNoDiscount == 0) return 0.0;
        return 100 - (totalWithDiscount * 100.0 / totalNoDiscount);
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}
