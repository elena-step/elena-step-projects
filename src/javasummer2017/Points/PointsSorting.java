package javasummer2017.Points;

public class PointsSorting {
    public static void main(String[] args) {
        Point one = new Point();
        one.name = "One";
        one.coordX = 5;
        one.coordY = 4;

        Point two = new Point();
        two.name = "Two";
        two.coordX = 2;
        two.coordY = 2;

        Point three = new Point();
        three.name = "Three";
        three.coordX = 2;
        three.coordY = 3;

        Point[] pointsOnSheet = {one, two, three};

        sortPoints(pointsOnSheet);
        printPoints(pointsOnSheet);
    }


    private static double diagonal(Point aPoint) {
        double result = Math.sqrt(aPoint.coordX * aPoint.coordX + aPoint.coordY * aPoint.coordY);
        return result;
    }


    private static void sortPoints(Point[] pointsOnSheet) {
        int n = pointsOnSheet.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (diagonal(pointsOnSheet[j - 1]) > diagonal(pointsOnSheet[j])) {
                    Point temp = pointsOnSheet[j - 1];
                    pointsOnSheet[j - 1] = pointsOnSheet[j];
                    pointsOnSheet[j] = temp;
                }
            }
        }
    }


    private static void printPoints(Point[] pointsOnSheet) {
        System.out.println("Name\t\tCoord_X\t\tCoord_Y");
        for (int i = 0; i < pointsOnSheet.length; i++) {
            System.out.printf("%s\t\t%.2f\t\t%.2f%n",
                    pointsOnSheet[i].name,
                    pointsOnSheet[i].coordX,
                    pointsOnSheet[i].coordY);
        }

    }

}
