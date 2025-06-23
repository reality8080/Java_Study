package _2_CreatingAndDestroyingObjects.Item1;

public class Point {
    private double x;
    private double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromCartesian(double x, double y) {
        return new Point(x, y);
    }

    public static Point fromPolar(double r, double angle) {
        return new Point(r * Math.cos(angle), r * Math.sin(angle));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Point))
            return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }
}
