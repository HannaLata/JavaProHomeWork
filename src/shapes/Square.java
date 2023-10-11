package shapes;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square() {
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
