package javasummer2017.FractionsWithEncapsul;

/* Класс Дробное число со знаком (Fractions).
Число должно быть представлено двумя полями:
целая часть - длинное целое со знаком, дробная часть - беззнаковое короткое целое.
Реализовать арифметические операции сложения, вычитания, умножения и операции сравнения.
В функции main проверить эти методы.

Добавить в домашнее задание с классом дроби инкапсуляцию.
Скрыть поля, сделать публичные гет и сет методы. Добавить конструктор(ы).
*/


public class ActionsWithFractionsC {
    public static void main(String[] args) {
        FractionC fraction1 = new FractionC(-2L, 372);
        FractionC fraction2 = new FractionC(3L, 825);

        System.out.println("Addition of two fractions: ");
        FractionC resultAddition = fractionsAddUp(fraction1, fraction2);
        printResultFraction(resultAddition);
        System.out.println();

        System.out.println("Deduction of two fractions: ");
        FractionC resultDeduction = fractionsDeduct(fraction1, fraction2);
        printResultFraction(resultDeduction);
        System.out.println();

        System.out.println("Multiplication of two fractions: ");
        FractionC resultMultiplication = fractionsMultiply(fraction1, fraction2);
        printResultFraction(resultMultiplication);
        System.out.println();

        System.out.println("Comparison of two fractions: ");
        int resultCompare = fractionsCompare(fraction1, fraction2);
        printResultCompare(fraction1, fraction2, resultCompare);


        test();
    }

    private static double convertPartToDouble(FractionC aFraction) {
        double result = (double) aFraction.getPart();
        int counterDigit = countDigits(aFraction);
        for (int i = 0; i < counterDigit; i++) {
            result /= 10;
        }
        return result;
    }

    private static double convertFractionToDouble(FractionC aFraction) {
        double fractionPart = convertPartToDouble(aFraction);
        if (aFraction.getWhole() < 0) {
            fractionPart = -fractionPart;
        }
        double result = aFraction.getWhole() + fractionPart;
        return result;
    }

    private static FractionC convertDoubleNumberToFraction(double number) {
        FractionC result = new FractionC();
        if (number < 0 && number > -1) {
            result.setNegativeNumberFromZeroToOne(true);
        }
        result.setWhole((long) number);

        if (number < 0) {
            number = -number;
        }
        long temp = (long) (number * 10000);

        int[] digitsForPart = new int[4];
        for (int i = 0; i < 4; i++) {
            digitsForPart[i] = (int) (temp % 10);
            temp /= 10;
        }

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


    private static void printResultFraction(FractionC aFraction) {
        if (aFraction.isNegativeNumberFromZeroToOne() == false) {
            if (aFraction.getPart() >= 1000) {
                System.out.println(aFraction.getWhole() + "." + aFraction.getPart());
            } else if (aFraction.getPart() >= 100) {
                System.out.println(aFraction.getWhole() + ".0" + aFraction.getPart());
            } else if (aFraction.getPart() >= 10) {
                System.out.println(aFraction.getWhole() + ".00" + aFraction.getPart());
            } else if (aFraction.getPart() < 10) {
                System.out.println(aFraction.getWhole() + ".000" + aFraction.getPart());
            }
        } else {
            if (aFraction.getPart() >= 1000) {
                System.out.println("-" + aFraction.getWhole() + "." + aFraction.getPart());
            } else if (aFraction.getPart() >= 100) {
                System.out.println("-" + aFraction.getWhole() + ".0" + aFraction.getPart());
            } else if (aFraction.getPart() >= 10) {
                System.out.println("-" + aFraction.getWhole() + ".00" + aFraction.getPart());
            } else if (aFraction.getPart() < 10) {
                System.out.println("-" + aFraction.getWhole() + ".000" + aFraction.getPart());
            }
        }
    }

    private static void test() {
        FractionC fraction1 = new FractionC();
        fraction1.setWhole(2L);
        fraction1.setPart(782);
        FractionC fraction2 = new FractionC();
        fraction2.setWhole(-3L);
        fraction2.setPart(596);

        FractionC expectedResultAddition = new FractionC();
        expectedResultAddition.setWhole(0);
        expectedResultAddition.setPart(8140);

        FractionC expectedResultDeduction = new FractionC();
        expectedResultDeduction.setWhole(6L);
        expectedResultDeduction.setPart(3780);

        FractionC expectedResultMultiplication = new FractionC();
        expectedResultMultiplication.setWhole(-10L);
        expectedResultMultiplication.setPart(40);

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

        if (resultAddition.getPart() != expectedResultAddition.getPart()) {
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








