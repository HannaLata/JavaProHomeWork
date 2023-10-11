package shapes;

public class ShapeMain {
    public static void main(String[] args) {
        Square square = new Square(10.0);
        Circle circle = new Circle(10.0);
        Triangle triangle = new Triangle(10.0, 15.0);

        Shape[] shapes = {square, circle, triangle};

        getShapesArea(shapes);
    }

    private static void getShapesArea(Shape[] shapes) {
        double shapesArea = 0.0;
        for ( Shape shape : shapes ) {
            shapesArea += shape.getArea();
        }
        System.out.println("The total area of all shapes in this array: " + shapesArea);
    }
}