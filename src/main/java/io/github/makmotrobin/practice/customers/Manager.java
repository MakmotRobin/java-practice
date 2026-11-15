package io.github.makmotrobin.practice.customers;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A person with a generated manager id and an action counter.
 *
 * <p>Like {@link Customer}, a manager is an entity: equality follows the
 * generated id, not the credentials.</p>
 */
public class Manager extends Person {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int managerId;
    private int actionNumber;

    public Manager(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.managerId = ID_GENERATOR.incrementAndGet();
        this.actionNumber = 0;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getActionNumber() {
        return actionNumber;
    }

    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    @Override
    public String toString() {
        return String.format("Manager ID: %d, %s", managerId, super.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Manager other = (Manager) obj;
        return managerId == other.managerId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(managerId);
    }
}
