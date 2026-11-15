package io.github.makmotrobin.practice.customers;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A person with a generated id and a balance.
 *
 * <p>Customers are entities, so two of them are equal only when they carry the
 * same generated id. The original homework compared username and password
 * instead, which both leaked credentials into equality and broke the
 * equals/hashCode contract.</p>
 */
public class Customer extends Person {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int customerId;
    private double balance;

    public Customer(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.customerId = ID_GENERATOR.incrementAndGet();
        this.balance = 0.0;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d, %s", customerId, super.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return customerId == other.customerId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(customerId);
    }
}
