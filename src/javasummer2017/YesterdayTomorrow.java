package javasummer2017;

import java.util.Scanner;

/*
Дата некоторого дня характеризуется тремя натуральными числами: g (год),
m (порядковый номер месяца) и n (число). По заданным g, n и m определить:
а) дату предыдущего дня;
б) дату следующего дня.
 */

public class YesterdayTomorrow {
    static final int YEAR = 0;
    static final int MONTH = 1;
    static final int DAY = 2;
    static final int MAX_YEAR = 3000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] date = new int[3];
        int g = 0;
        int m = 0;
        int n = 0;

        System.out.println("Please, enter the date by numbers.");
        System.out.println("Year can be up to 3000 only :)");

        System.out.print("year: ");
        if (!scan.hasNextInt()) {
            messageInputError();
            System.exit(0);
        } else {
            g = scan.nextInt();
        }

        System.out.print("month: ");
        if (!scan.hasNextInt()) {
            messageInputError();
            System.exit(0);
        } else {
            m = scan.nextInt();
        }

        System.out.print("day: ");
        if (!scan.hasNextInt()) {
            messageInputError();
            System.exit(0);
        } else {
            n = scan.nextInt();
        }

        if (checkBoundaryConditions(g, m, n)) {
            System.err.println("Error! Invalid input! Try again!");
            System.exit(0);
        } else {
            date[YEAR] = g;
            date[MONTH] = m;
            date[DAY] = n;
        }

        System.out.print("You inputted the date ");
        dateToString(date);

        int[] yesterday = countYesterday(date);
        System.out.print("Yesterday was ");
        dateToString(yesterday);


        int[] tomorrow = countTomorrow(date);
        System.out.print("Tomorrow will be ");
        dateToString(tomorrow);
    }

    private static boolean checkBoundaryConditions(int g, int m, int n) {
        return g < 1 || g > MAX_YEAR || m < 1 || m > 12 || n < 1 || n > getMaxDayInMonth(m, g);
    }

    private static void messageInputError() {
        System.err.println("Input error! You need to use numbers only! Try again!");

    }

    private static int[] countYesterday(int[] date) {
        int[] result = new int[3];
        if (date[DAY] != 1) {
            result[YEAR] = date[YEAR];
            result[MONTH] = date[MONTH];
            result[DAY] = date[DAY] - 1;
        } else if (date[MONTH] != 1) {
            result[YEAR] = date[YEAR];
            result[MONTH] = date[MONTH] - 1;
            result[DAY] = getMaxDayInMonth(date[MONTH] - 1, date[YEAR]);
        } else {
            result[YEAR] = date[YEAR] - 1;
            result[MONTH] = 12;
            result[DAY] = 31;
        }
        return result;
    }

    private static int[] countTomorrow(int[] date) {
        int[] result = new int[3];
        if (date[DAY] != getMaxDayInMonth(MONTH, YEAR)) {
            result[YEAR] = date[YEAR];
            result[MONTH] = date[MONTH];
            result[DAY] = date[DAY] + 1;
        } else if (date[MONTH] != 12) {
            result[YEAR] = date[YEAR];
            result[MONTH] = date[MONTH] + 1;
            result[DAY] = 1;
        } else {
            result[YEAR] = date[YEAR] + 1;
            result[MONTH] = 1;
            result[DAY] = 1;
        }
        return result;
    }

    private static int getMaxDayInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            System.err.println("Month should be in a range [1,12]");
            System.exit(0); //выход из программы
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 30;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private static String[] dateToString(int[] date) {
        String[] stringArrayDate = new String[3];
        for (int i = date.length - 1; i >= 0; i--) {
            if (i != 0) {
                stringArrayDate[i] = Integer.toString(date[i]);
                System.out.print(stringArrayDate[i] + ".");
            } else {
                stringArrayDate[i] = Integer.toString(date[i]);
                System.out.println(stringArrayDate[i]);
            }
        }
        return stringArrayDate;
    }
}


