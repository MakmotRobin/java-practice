package io.github.makmotrobin.practice.oop.overloading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Test
    void defaultConstructorCreatesAnUndefinedShape() {
        Shape shape = new Shape();

        assertEquals("Undefined shape", shape.getShapeName());
        assertEquals(0, shape.getNumberOfEdges());
    }

    @Test
    void singleRadiusCreatesACircleWithoutEdges() {
        Shape circle = new Shape(5.0);

        assertEquals("Circle", circle.getShapeName());
        assertEquals(0, circle.getNumberOfEdges());
    }

    @Test
    void twoArgumentsCreateASquare() {
        Shape square = new Shape(4, 10.0);

        assertEquals("Square", square.getShapeName());
        assertEquals(4, square.getNumberOfEdges());
    }

    @Test
    void threeArgumentsCreateARectangle() {
        Shape rectangle = new Shape(4, 5.0, 8.0);

        assertEquals("Rectangle", rectangle.getShapeName());
        assertEquals(4, rectangle.getNumberOfEdges());
    }

    @Test
    void fourArgumentsCreateATriangle() {
        Shape triangle = new Shape(3, 3.0, 4.0, 5.0);

        assertEquals("Triangle", triangle.getShapeName());
        assertEquals(3, triangle.getNumberOfEdges());
    }

    @Test
    void detailsIncludeNameAndEdgeCount() {
        Shape triangle = new Shape(3, 3.0, 4.0, 5.0);

        assertEquals("Shape Name: Triangle\nNumber of Edges: 3", triangle.getShapeDetails());
    }
}
