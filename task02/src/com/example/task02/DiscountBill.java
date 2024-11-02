package com.example.task02;

public class DiscountBill extends Bill {
    private static double discount = 20;

    public DiscountBill() {}

    @Override
    public long getPrice(){
        return (long)(super.getPrice() * (1 - discount / 100));
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDiscount() {
        return String.format("%.1f%%", discount);
    }

    public long getDiscountAmount() {
        return super.getPrice() - getPrice();
    }
}
