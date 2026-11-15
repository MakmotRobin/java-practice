package io.github.makmotrobin.practice.customers;

/**
 * Common identity for customers and managers.
 *
 * <p><strong>Note:</strong> the plaintext password exists only because the
 * exercise is about inheritance. The field is never readable from outside;
 * {@link #hasPassword(String)} is the only way to check it, and a real
 * application would store a salted hash instead.</p>
 *
 * <p>People compare equal when they share a username, so {@link #hashCode()} is
 * derived from the username to keep the equals/hashCode contract intact.</p>
 */
public class Person {

    private final String name;
    private final int age;
    private final String username;
    private final String password;

    public Person(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    /** @return {@code true} when {@code candidate} matches the stored password */
    public boolean hasPassword(String candidate) {
        return password.equals(candidate);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return username.equals(other.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
