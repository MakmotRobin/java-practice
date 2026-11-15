package io.github.makmotrobin.practice.oop.objectmethods;

/** Runs the equals/hashCode/clone exercise. */
public final class SmartphoneDemo {

    private SmartphoneDemo() {
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SmartphonePrice producerPrice1 = new SmartphonePrice("Producer", 100.0);
        SmartphonePrice producerPrice2 = new SmartphonePrice("Producer", 100.0);
        SmartphonePrice retailPrice1 = new SmartphonePrice("Retail", 150.0);
        SmartphonePrice retailPrice2 = new SmartphonePrice("Retail", 150.0);

        Smartphone smartphone1 = new Smartphone("Brand A", "Model A", 3000, producerPrice1, retailPrice1);
        Smartphone smartphone2 = new Smartphone("Brand B", "Model B", 4000, producerPrice2, retailPrice2);

        System.out.println("Smartphone 1: " + smartphone1);
        System.out.println("Smartphone 2: " + smartphone2);
        System.out.println("Smartphone 1 equals Smartphone 2: " + smartphone1.equals(smartphone2));

        Smartphone clonedSmartphone = smartphone2.clone();
        System.out.println("Cloned Smartphone: " + clonedSmartphone);
        System.out.println("Smartphone 2 equals clone: " + smartphone2.equals(clonedSmartphone));
        System.out.println("Clone shares its price objects: "
                + (clonedSmartphone.getProducerPrice() == smartphone2.getProducerPrice()));
    }
}
