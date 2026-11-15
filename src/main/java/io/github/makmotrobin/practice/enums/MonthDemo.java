package io.github.makmotrobin.practice.enums;

/** Prints every {@link Month} constant and whether its name ends with a {@code y}. */
public final class MonthDemo {

    private MonthDemo() {
    }

    public static void main(String[] args) {
        for (Month month : Month.values()) {
            System.out.println(month.name() + (month.endsWithY() ? " ends with y" : " doesn't end with y"));
        }
    }
}
