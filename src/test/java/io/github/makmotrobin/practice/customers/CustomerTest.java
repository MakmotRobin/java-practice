package io.github.makmotrobin.practice.customers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    void customersAreEntitiesSoIdenticalCredentialsAreStillDifferentCustomers() {
        Customer a = new Customer("Alice", 30, "alice123", "password123");
        Customer b = new Customer("Alice", 30, "alice123", "password123");

        assertNotEquals(a, b, "each customer gets its own generated id");
        assertNotEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void aCustomerEqualsItselfAndNotOtherTypes() {
        Customer customer = new Customer("Alice", 30, "alice123", "password123");

        assertEquals(customer, customer);
        assertNotEquals(customer, null);
        assertNotEquals(customer, new Manager("Alice", 30, "alice123", "password123"));
    }

    @Test
    void peopleCompareEqualByUsername() {
        Person a = new Person("Alice", 30, "alice123", "password123");
        Person b = new Person("Alicia", 31, "alice123", "different");

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertTrue(a.hasPassword("password123"));
        assertFalse(a.hasPassword("wrong"));
    }

    @Test
    void customersWithDifferentCredentialsAreNotEqual() {
        Customer a = new Customer("Alice", 30, "alice123", "password123");
        Customer b = new Customer("Bob", 25, "bob456", "securepassword");

        assertNotEquals(a, b);
    }

    @Test
    void idsAreGeneratedMonotonically() {
        Customer first = new Customer("One", 20, "one", "pw");
        Customer second = new Customer("Two", 21, "two", "pw");

        assertTrue(second.getCustomerId() > first.getCustomerId());
    }

    @Test
    void balanceStartsAtZeroAndCanBeChanged() {
        Customer customer = new Customer("Alice", 30, "alice123", "password123");

        assertEquals(0.0, customer.getBalance(), 1e-9);

        customer.setBalance(100.0);
        assertEquals(100.0, customer.getBalance(), 1e-9);
    }

    @Test
    void managerTracksAnActionCounterAndHasItsOwnId() {
        Manager manager = new Manager("Charlie", 40, "charlie123", "password456");

        assertEquals(0, manager.getActionNumber());
        manager.setActionNumber(5);
        assertEquals(5, manager.getActionNumber());
        assertTrue(manager.getManagerId() > 0);
    }

    @Test
    void managerToStringIncludesTheGeneratedId() {
        Manager manager = new Manager("Diana", 35, "diana456", "mypassword");

        assertTrue(manager.toString().startsWith("Manager ID: " + manager.getManagerId()));
        assertTrue(manager.toString().contains("Name: Diana, Age: 35"));
    }
}
