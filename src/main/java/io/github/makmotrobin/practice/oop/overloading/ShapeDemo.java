package io.github.makmotrobin.practice.oop.overloading;

/** Runs the constructor-overloading exercise. */
public final class ShapeDemo {

    private ShapeDemo() {
    }

    public static void main(String[] args) {
        Shape circle = new Shape(5.0);
        Shape square = new Shape(4, 10.0);
        Shape rectangle = new Shape(4, 5.0, 8.0);
        Shape triangle = new Shape(3, 3.0, 4.0, 5.0);
        Shape undefinedShape = new Shape();

        System.out.println("Circle Details:\n" + circle.getShapeDetails());
        System.out.println("Square Details:\n" + square.getShapeDetails());
        System.out.println("Rectangle Details:\n" + rectangle.getShapeDetails());
        System.out.println("Triangle Details:\n" + triangle.getShapeDetails());
        System.out.println("Undefined Shape Details:\n" + undefinedShape.getShapeDetails());
    }
}
