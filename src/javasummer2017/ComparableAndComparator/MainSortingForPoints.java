package javasummer2017.ComparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

public class MainSortingForPoints {

    /**
     * Есть класс Точка, состоящая из координат x и y.
     * Сделать этот класс Comperable, и отсортировать массив точек
     * по возрастанию расстояния от начала координат.
     * При помощи компаратора выполнить сортировку в обратном порядке.
     */


    public static void main(String[] args) {
        Point one = new Point("One", 5, 4);
        Point two = new Point("Two", 2, 2);
        Point three = new Point("Three", 2, 3);
        Point four = new Point();
        Point five = new Point("Five", 3, 4);

        Point[] pointsOnSheet = {one, two, three, four, five};

        Arrays.sort(pointsOnSheet);
        for (int i = 0; i < pointsOnSheet.length; i++) {
            System.out.println(i + 1 + ". " + pointsOnSheet[i]);
        }

        System.out.println();
        Arrays.sort(pointsOnSheet, new PointsByDiagonalComparator());
        for (int i = 0; i < pointsOnSheet.length; i++) {
            System.out.println(i + 1 + ". " + pointsOnSheet[i]);
        }
    }


}

class PointsByDiagonalComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return -o1.diagonal().compareTo(o2.diagonal());
        //return Double.compare(o1.diagonal(), o2.diagonal());  //второй вариант
    }
}

