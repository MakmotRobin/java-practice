package io.github.makmotrobin.practice.oop.objectmethods;

import java.util.Objects;

/**
 * A price tag attached to a phone. Implements {@code equals}, {@code hashCode},
 * {@code toString} and a deep {@code clone}.
 */
public class SmartphonePrice implements Cloneable {

    private String priceType;
    private double priceInEuros;

    public SmartphonePrice(String priceType, double priceInEuros) {
        this.priceType = priceType;
        this.priceInEuros = priceInEuros;
    }

    public String getPriceType() {
        return priceType;
    }

    public double getPriceInEuros() {
        return priceInEuros;
    }

    @Override
    public String toString() {
        return "SmartphonePrice{"
                + "priceType='" + priceType + '\''
                + ", priceInEuros=" + priceInEuros
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SmartphonePrice that = (SmartphonePrice) o;
        return Double.compare(that.priceInEuros, priceInEuros) == 0
                && Objects.equals(priceType, that.priceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceType, priceInEuros);
    }

    @Override
    public SmartphonePrice clone() throws CloneNotSupportedException {
        return (SmartphonePrice) super.clone();
    }
}
