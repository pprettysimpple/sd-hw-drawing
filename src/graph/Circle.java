package graph;

public class Circle {
    public static class Point {
        public final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public Point point;
    public double radius;

    public Circle(double x, double y, double radius) {
        this.point = new Point(x, y);
        this.radius = radius;
    }
}
