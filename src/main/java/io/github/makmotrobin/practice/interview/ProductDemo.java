package io.github.makmotrobin.practice.interview;

/** Runs the product discount exercise. */
public final class ProductDemo {

    private ProductDemo() {
    }

    public static void main(String[] args) {
        Product product = new Product(12345, "Smartphone", 599.99);

        System.out.println("Original Unit Price: " + product.getUnitPrice());
        System.out.println("Unit Price after 5% discount: " + product.applyDiscount());
        System.out.println(product);
    }
}
