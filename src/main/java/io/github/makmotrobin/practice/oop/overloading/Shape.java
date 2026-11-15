package io.github.makmotrobin.practice.oop.overloading;

/**
 * Demonstrates constructor overloading: every shape is created through a
 * different argument list, and each constructor records the name and number of
 * edges that describe it.
 */
public class Shape {

    private final String shapeName;
    private final int numberOfEdges;

    /** Undefined shape, kept for the default constructor demo. */
    public Shape() {
        System.out.println("Creating a Shape object.");
        shapeName = "Undefined shape";
        numberOfEdges = 0;
    }

    /** Circle: a single radius argument. */
    public Shape(double radius) {
        System.out.println("Creating a Circle object.");
        shapeName = "Circle";
        numberOfEdges = 0;
    }

    /** Square: edge count plus the shared edge length. */
    public Shape(int edges, double edgeLength) {
        System.out.println("Creating a Square object.");
        shapeName = "Square";
        numberOfEdges = edges;
    }

    /** Rectangle: edge count plus two side lengths. */
    public Shape(int edges, double e1, double e2) {
        System.out.println("Creating a Rectangle object.");
        shapeName = "Rectangle";
        numberOfEdges = edges;
    }

    /** Triangle: edge count plus three side lengths. */
    public Shape(int edges, double e1, double e2, double e3) {
        System.out.println("Creating a Triangle object.");
        shapeName = "Triangle";
        numberOfEdges = edges;
    }

    public String getShapeName() {
        return shapeName;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public String getShapeDetails() {
        return "Shape Name: " + shapeName + "\nNumber of Edges: " + numberOfEdges;
    }
}
