package io.github.makmotrobin.practice.interview;

/** A product that can apply a 5% discount to its own unit price. */
public class Product {

    private final int barcode;
    private final String summaryDescription;
    private double unitPrice;

    public Product(int barcode, String summaryDescription, double unitPrice) {
        this.barcode = barcode;
        this.summaryDescription = summaryDescription;
        this.unitPrice = unitPrice;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getSummaryDescription() {
        return summaryDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Reduces the unit price by 5%.
     *
     * @return the new unit price
     */
    public double applyDiscount() {
        unitPrice -= unitPrice * 0.05;
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Product [Barcode: " + barcode
                + ", Summary Description: " + summaryDescription
                + ", Unit Price: " + unitPrice + "]";
    }
}
