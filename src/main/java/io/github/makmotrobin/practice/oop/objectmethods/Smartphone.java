package io.github.makmotrobin.practice.oop.objectmethods;

import java.util.Objects;

/**
 * A phone composed of two prices. {@link #clone()} is a <em>deep</em> copy: the
 * cloned phone gets its own price objects, so mutating one clone cannot leak
 * into the other.
 */
public class Smartphone implements Cloneable {

    private String brandName;
    private String modelName;
    private int batterymAh;
    private SmartphonePrice producerPrice;
    private SmartphonePrice retailPrice;

    public Smartphone(String brandName,
                      String modelName,
                      int batterymAh,
                      SmartphonePrice producerPrice,
                      SmartphonePrice retailPrice) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.batterymAh = batterymAh;
        this.producerPrice = producerPrice;
        this.retailPrice = retailPrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getBatterymAh() {
        return batterymAh;
    }

    public SmartphonePrice getProducerPrice() {
        return producerPrice;
    }

    public SmartphonePrice getRetailPrice() {
        return retailPrice;
    }

    @Override
    public String toString() {
        return "Smartphone{"
                + "brandName='" + brandName + '\''
                + ", modelName='" + modelName + '\''
                + ", batterymAh=" + batterymAh
                + ", producerPrice=" + producerPrice
                + ", retailPrice=" + retailPrice
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
        Smartphone smartphone = (Smartphone) o;
        return batterymAh == smartphone.batterymAh
                && Objects.equals(brandName, smartphone.brandName)
                && Objects.equals(modelName, smartphone.modelName)
                && Objects.equals(producerPrice, smartphone.producerPrice)
                && Objects.equals(retailPrice, smartphone.retailPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, batterymAh, producerPrice, retailPrice);
    }

    @Override
    public Smartphone clone() throws CloneNotSupportedException {
        Smartphone clonedSmartphone = (Smartphone) super.clone();
        clonedSmartphone.producerPrice = producerPrice.clone();
        clonedSmartphone.retailPrice = retailPrice.clone();
        return clonedSmartphone;
    }
}
