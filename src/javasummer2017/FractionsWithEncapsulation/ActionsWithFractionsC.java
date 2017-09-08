package javasummer2017.FractionsWithEncapsulation;

import java.util.Scanner;

/* Класс Дробное число со знаком (Fractions).
Число должно быть представлено двумя полями:
целая часть - длинное целое со знаком, дробная часть - беззнаковое короткое целое.
Реализовать арифметические операции сложения, вычитания, умножения и операции сравнения.
В функции main проверить эти методы.

Добавить в домашнее задание с классом дроби инкапсуляцию.
Скрыть поля, сделать публичные гет и сет методы. Добавить конструктор(ы).
*/


public class ActionsWithFractionsC {

    private static final int NUMBER_DIGITS_FOR_SHORT = 4;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str;

        System.out.println("Please, input decimal fraction:");
        str = scan.nextLine();
        double number1FromUser = Double.parseDouble(str);

        System.out.println("Please, input another decimal fraction:");
        str = scan.nextLine();
        double number2FromUser = Double.parseDouble(str);

        FractionC fraction1 = convertDoubleNumberToFraction(number1FromUser);
        FractionC fraction2 = convertDoubleNumberToFraction(number2FromUser);

        System.out.println("The actions will make for two decimal fractions:");
        fraction1.printFraction();
        System.out.print("   ");
        fraction2.printFraction();
        System.out.println();

        System.out.println("Addition of two fractions: ");
        FractionC resultAddition = fractionsAddUp(fraction1, fraction2);
        resultAddition.printFraction();
        System.out.println();

        System.out.println("Deduction of two fractions: ");
        FractionC resultDeduction = fractionsDeduct(fraction1, fraction2);
        resultDeduction.printFraction();
        System.out.println();

        System.out.println("Multiplication of two fractions: ");
        FractionC resultMultiplication = fractionsMultiply(fraction1, fraction2);
        resultMultiplication.printFraction();
        System.out.println();

        System.out.println("Comparison of two fractions: ");
        int resultCompare = fractionsCompare(fraction1, fraction2);
        printResultCompare(fraction1, fraction2, resultCompare);


       // test();

    }


    private static double convertPartToDouble(FractionC aFraction) {
        double result = (double) aFraction.getPart();
        int counterDigit = countDigits(aFraction);
        for (int i = 0; i < counterDigit; i++) {
            result /= 10;
        }
        if (aFraction.getCounterOfZero() != 0) {
            for (int i = 0; i < aFraction.getCounterOfZero(); i++) {
                result /= 10;
            }
        }
        return result;
    }

    private static double convertFractionToDouble(FractionC aFraction) {
        double fractionPart = convertPartToDouble(aFraction);
        double result = aFraction.getWhole() + fractionPart;
        if (aFraction.isNegativeNumber()) {
            result = -result;
        }
        return result;
    }

    private static FractionC convertDoubleNumberToFraction(double number) {
        FractionC result = new FractionC();

        if (number < 0) {
            result.setNegativeNumber(true);
            number = -number;
        }
        result.setWhole((long) number);

        long temp = (long) (number * 10000);

        int[] digitsForPart = new int[NUMBER_DIGITS_FOR_SHORT];

        for (int i = 0; i < NUMBER_DIGITS_FOR_SHORT; i++) {
            digitsForPart[i] = (int) (temp % 10);
            temp /= 10;
        }

        int counter = 0;
        for (int i = digitsForPart.length - 1; i >= 0; i--) {
            if (digitsForPart[i] == 0) {
                counter++;
            } else {
                break;
            }
        }
        result.setCounterOfZero(counter);

        int tempPart = 0;
        for (int i = digitsForPart.length - 1; i >= 0; i--) {
            tempPart = tempPart * 10 + digitsForPart[i];
        }
        result.setPart((short) tempPart);

        return result;
    }


    private static int countDigits(FractionC aFraction) {
        int result = 0;
        int aFractPart = aFraction.getPart();
        while (aFractPart >= 1) {
            aFractPart /= 10;
            result++;
        }
        return result;
    }


    private static FractionC fractionsAddUp(FractionC fraction1, FractionC fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        double sum = fr1 + fr2;
        FractionC result = convertDoubleNumberToFraction(sum);

        return result;
    }


    private static FractionC fractionsDeduct(FractionC fraction1, FractionC fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        double deduction = fr1 - fr2;
        FractionC result = convertDoubleNumberToFraction(deduction);

        return result;
    }

    private static FractionC fractionsMultiply(FractionC fraction1, FractionC fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        double multiplication = fr1 * fr2;
        FractionC result = convertDoubleNumberToFraction(multiplication);

        return result;
    }

    private static int fractionsCompare(FractionC fraction1, FractionC fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        if (fr1 > fr2) {
            return 1;
        } else if (fr1 == fr2) {
            return 0;
        } else {
            return -1;
        }
    }

    private static void printResultCompare(FractionC fraction1, FractionC fraction2, int number) {
        switch (number) {
            case 1:
                fraction1.printFraction();
                System.out.print(" > ");
                fraction2.printFraction();
                break;
            case 0:
                fraction1.printFraction();
                System.out.print(" == ");
                fraction2.printFraction();
                break;
            case -1:
                fraction1.printFraction();
                System.out.print(" < ");
                fraction2.printFraction();
                break;
        }
    }


    private static void test() {
        FractionC fraction1 = new FractionC(2L, 12345);
        FractionC fraction2 = new FractionC(-3L, 0001);

        FractionC expectedResultAddition = new FractionC();
        expectedResultAddition.setWhole(0);
        expectedResultAddition.setPart(8767);
        expectedResultAddition.setNegativeNumber(true);

        FractionC expectedResultDeduction = new FractionC();
        expectedResultDeduction.setWhole(5L);
        expectedResultDeduction.setPart(1235);

        FractionC expectedResultMultiplication = new FractionC();
        expectedResultMultiplication.setWhole(6L);
        expectedResultMultiplication.setPart(3704);
        expectedResultMultiplication.setNegativeNumber(true);

        int expectedResultCompare = 1;

        FractionC resultAddition = fractionsAddUp(fraction1, fraction2);
        FractionC resultDeduction = fractionsDeduct(fraction1, fraction2);
        FractionC resultMultiplication = fractionsMultiply(fraction1, fraction2);
        int resultCompare = fractionsCompare(fraction1, fraction2);

        System.out.println();

        boolean passed = true;
        if (resultAddition.getWhole() != expectedResultAddition.getWhole()) {
            System.out.printf("Test error: sum (whole) = %d, but expected sum (whole) = %d.",
                    resultAddition, expectedResultAddition);
            passed = false;
        }

        if ((int)(resultAddition.getPart()) != ((int)expectedResultAddition.getPart())) {
            System.out.printf("Test error: sum (part) = %d, but expected sum (part) = %d.",
                    resultAddition, expectedResultAddition);
            passed = false;
        }

        if (resultDeduction.getWhole() != expectedResultDeduction.getWhole()) {
            System.out.printf("Test error: deduction (whole) = %d, but expected deduction = %d.",
                    resultDeduction, expectedResultDeduction);
            passed = false;
        }

        if (resultDeduction.getPart() != expectedResultDeduction.getPart()) {
            System.out.printf("Test error: deduction (part) = %d, but expected deduction = %d.",
                    resultDeduction, expectedResultDeduction);
            passed = false;
        }

        if (resultMultiplication.getWhole() != expectedResultMultiplication.getWhole()) {
            System.out.printf("Test error: mult (whole) = %d, but expected mult (whole) = %d.",
                    resultMultiplication, expectedResultMultiplication);
            passed = false;
        }

        if (resultMultiplication.getPart() != expectedResultMultiplication.getPart()) {
            System.out.printf("Test error: mult (part) = %d, but expected mult (part) = %d.",
                    resultMultiplication, expectedResultMultiplication);
            passed = false;
        }

        if (resultCompare != expectedResultCompare) {
            System.out.printf("Test error: result compare = %d, but expected result compare = %d.",
                    resultCompare, expectedResultCompare);
            passed = false;
        }

        if (passed)
            System.out.println("Test passed!");
    }
}



