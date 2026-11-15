package io.github.makmotrobin.practice.enums;

/**
 * The twelve months, used to demonstrate enum iteration and the implicit
 * {@link Enum#name()} / {@link Enum#values()} API.
 */
public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    /**
     * @return {@code true} when the constant name ends with the letter {@code Y}
     */
    public boolean endsWithY() {
        return name().endsWith("Y");
    }
}
