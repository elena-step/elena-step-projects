package javasummer2017;

import java.util.Scanner;

public class ReverseNaturalNumber {

    public static void main(String[] args) {

        int number = inputNaturalNumber();
        System.out.print("You input number: ");
        printNumber(number);
        System.out.println();

        System.out.print("This number in reverse order: ");
        reverseNaturalNumber(number);
    }


    private static int inputNaturalNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input natural number: ");
        if (!scan.hasNextInt()) {
            System.err.println("Input error! Try again!");
            System.exit(0);
        }
        int naturalNumber = scan.nextInt();
        if (naturalNumber <= 0) {
            System.err.println("Error! Natural number must be positive.");
            System.exit(0);
        }
        return naturalNumber;
    }


    private static void printNumber(int number) {
        System.out.print(number);
    }


    private static void reverseNaturalNumber(int naturalNumber) {
        if (naturalNumber >= 1) {
            int reverse = naturalNumber % 10;
            printNumber(reverse);
            naturalNumber /= 10;
            reverseNaturalNumber(naturalNumber);
        }
    }


}
