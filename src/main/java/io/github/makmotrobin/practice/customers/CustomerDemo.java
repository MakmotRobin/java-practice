package io.github.makmotrobin.practice.customers;

/**
 * Runs the customer/manager inheritance and equality exercise.
 *
 * <p>The original homework claimed that two people created with identical
 * credentials were equal. Once {@code equals} follows the generated id — the
 * only stable identity an entity has — that claim stops being true, so the demo
 * shows the real behaviour instead.</p>
 */
public final class CustomerDemo {

    private CustomerDemo() {
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", 30, "alice123", "password123");
        Customer customer2 = new Customer("Bob", 25, "bob456", "securepassword");
        Customer customer3 = new Customer("Alice", 30, "alice123", "password123");

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println("customer1.equals(customer3): " + customer1.equals(customer3)
                + " (identical credentials, different ids)");
        System.out.println("customer1.equals(customer2): " + customer1.equals(customer2));

        customer1.setBalance(100.0);
        System.out.println("Balance: " + customer1.getBalance());

        Manager manager1 = new Manager("Charlie", 40, "charlie123", "password456");
        Manager manager2 = new Manager("Diana", 35, "diana456", "mypassword");
        Manager manager3 = new Manager("Charlie", 40, "charlie123", "password456");

        System.out.println(manager1);
        System.out.println("manager1.equals(manager3): " + manager1.equals(manager3)
                + " (identical credentials, different ids)");
        System.out.println("manager1.equals(manager2): " + manager1.equals(manager2));

        manager1.setActionNumber(5);
        System.out.println("Action Number: " + manager1.getActionNumber());
    }
}
