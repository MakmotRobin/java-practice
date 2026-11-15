package io.github.makmotrobin.practice.oop.objectmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartphoneTest {

    private static Smartphone phone(String brand, String model, int battery) {
        return new Smartphone(brand, model, battery,
                new SmartphonePrice("Producer", 100.0),
                new SmartphonePrice("Retail", 150.0));
    }

    @Test
    void equalFieldsProduceEqualObjectsAndHashes() {
        Smartphone a = phone("Brand A", "Model A", 3000);
        Smartphone b = phone("Brand A", "Model A", 3000);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void differingFieldsProduceUnequalObjects() {
        Smartphone a = phone("Brand A", "Model A", 3000);
        Smartphone b = phone("Brand B", "Model B", 4000);

        assertNotEquals(a, b);
    }

    @Test
    void cloneIsEqualButNotTheSameInstance() throws CloneNotSupportedException {
        Smartphone original = phone("Brand A", "Model A", 3000);

        Smartphone clone = original.clone();

        assertEquals(original, clone);
        assertNotSame(original, clone);
    }

    @Test
    void cloneDeepCopiesThePriceObjects() throws CloneNotSupportedException {
        Smartphone original = phone("Brand A", "Model A", 3000);

        Smartphone clone = original.clone();

        assertNotSame(original.getProducerPrice(), clone.getProducerPrice());
        assertNotSame(original.getRetailPrice(), clone.getRetailPrice());
        assertEquals(original.getProducerPrice(), clone.getProducerPrice());
    }

    @Test
    void pricesCompareByValueAndType() {
        SmartphonePrice a = new SmartphonePrice("Producer", 100.0);
        SmartphonePrice b = new SmartphonePrice("Producer", 100.0);
        SmartphonePrice c = new SmartphonePrice("Retail", 100.0);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, c);
    }

    @Test
    void letsSubtypesShareBookkeeping() {
        Smartphone a = phone("Brand A", "Model A", 3000);
        Smartphone b = phone("Brand A", "Model A", 3000);

        assertSame(a.getProducerPrice(), a.getProducerPrice(), "getter returns the same object");
        assertTrue(a.equals(b) && b.equals(a), "equals stays symmetric");
    }
}
