package javasummer2017.ComparableAndComparator;


public class Point implements Comparable<Point> {
    private static final String DEFAULT_NAME = "Unnamed";

    String name;
    double coordX;
    double coordY;

    Point() {
        this(DEFAULT_NAME, 0, 0);
    }

    Point(String name, double coordX, double coordY) {
        setName(name);
        setCoordX(coordX);
        setCoordY(coordY);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? DEFAULT_NAME : name;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    Double diagonal() {
        return Math.sqrt(coordX * coordX + coordY * coordY);
    }

    @Override
    public int compareTo(Point o) {
        return this.diagonal().compareTo(o.diagonal());
    }

    @Override
    public String toString() {
        return "Point " + name +
                " coord x = " + coordX +
                " coord y = " + coordY;
    }
}


