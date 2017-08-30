package javasummer2017.Fraction;

/* Класс Дробное число со знаком (Fractions).
Число должно быть представлено двумя полями:
целая часть - длинное целое со знаком, дробная часть - беззнаковое короткое целое.
Реализовать арифметические операции сложения, вычитания, умножения и операции сравнения.
В функции main проверить эти методы.
*/

public class ActionsWithFractions {

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        fraction1.whole = 2L;
        fraction1.part = 782;
        Fraction fraction2 = new Fraction();
        fraction2.whole = -3L;
        fraction2.part = 596;

        System.out.println("Addition of two fractions: ");
        Fraction resultAddition = fractionsAddUp(fraction1, fraction2);
        printFraction(resultAddition);
        System.out.println();

        System.out.println("Deduction of two fractions: ");
        Fraction resultDeduction = fractionsDeduct(fraction1, fraction2);
        printFraction(resultDeduction);
        System.out.println();

        System.out.println("Multiplication of two fractions: ");
        Fraction resultMultiplication = fractionsMultiply(fraction1, fraction2);
        printFraction(resultMultiplication);
        System.out.println();

        System.out.println("Comparison of two fractions: ");
        int resultCompare = fractionsCompare(fraction1, fraction2);
        printResultCompare(fraction1, fraction2, resultCompare);

        //test();
    }

    private static double convertPartToDouble(Fraction aFraction) {
        double result = (double) aFraction.part;
        int counterDigit = countDigits(aFraction);
        for (int i = 0; i < counterDigit; i++) {
            result /= 10;
        }
        return result;
    }

    private static double convertFractionToDouble(Fraction aFraction) {
        double fractionPart = convertPartToDouble(aFraction);
        if (aFraction.whole < 0) {
            fractionPart = -fractionPart;
        }
        double result = aFraction.whole + fractionPart;
        return result;
    }

    private static Fraction convertDoubleNumberToFraction(double number) {
        Fraction result = new Fraction();
        result.whole = (long) number;   // отрицательн число с 0 целой частью отражается как 0 без "минуса"

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
            tempPart = tempPart * 10 + digitsForPart[i];        //ошибка если массив содержит нули в конце
        }
        result.part = (short) tempPart;

        return result;
    }

    private static int countDigits(Fraction aFraction) {
        int result = 0;
        int aFractPart = aFraction.part;
        while (aFractPart >= 1) {
            aFractPart /= 10;
            result++;
        }
        return result;
    }

    private static Fraction fractionsAddUp(Fraction fraction1, Fraction fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        double sum = fr1 + fr2;
        Fraction result = convertDoubleNumberToFraction(sum);

        return result;
    }


    private static Fraction fractionsDeduct(Fraction fraction1, Fraction fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        double deduction = fr1 - fr2;
        Fraction result = convertDoubleNumberToFraction(deduction);

        return result;
    }

    private static Fraction fractionsMultiply(Fraction fraction1, Fraction fraction2) {
        double fr1 = convertFractionToDouble(fraction1);
        double fr2 = convertFractionToDouble(fraction2);
        double multiplication = fr1 * fr2;
        Fraction result = convertDoubleNumberToFraction(multiplication);

        return result;
    }

    private static int fractionsCompare(Fraction fraction1, Fraction fraction2) {
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

    private static void printResultCompare(Fraction fraction1, Fraction fraction2, int number) {
        switch (number) {
            case 1:
                printFraction(fraction1);
                System.out.print(" > ");
                printFraction(fraction2);
                break;
            case 0:
                printFraction(fraction1);
                System.out.print(" == ");
                printFraction(fraction2);
                break;
            case -1:
                printFraction(fraction1);
                System.out.print(" < ");
                printFraction(fraction2);
                break;
        }
    }

    private static void printFraction(Fraction aFraction)
    {
        System.out.print(aFraction.whole + "." + aFraction.part);
    }

    private static void test(){
        Fraction fraction1 = new Fraction();
        fraction1.whole = 2L;
        fraction1.part = 782;
        Fraction fraction2 = new Fraction();
        fraction2.whole = -3L;
        fraction2.part = 596;

        Fraction expectedResultAddition = new Fraction();
        expectedResultAddition.whole = -0L;          //этот минус "теряется"
        expectedResultAddition.part = 8140;

        Fraction expectedResultDeduction = new Fraction();
        expectedResultDeduction.whole = 6L;
        expectedResultDeduction.part = 3780;

        Fraction expectedResultMultiplication = new Fraction();
        expectedResultMultiplication.whole = -10L;
        expectedResultMultiplication.part = 0040;    //два первых нуля "теряются"

        int expectedResultCompare = 1;

        Fraction resultAddition = fractionsAddUp(fraction1, fraction2);
        Fraction resultDeduction = fractionsDeduct(fraction1, fraction2);
        Fraction resultMultiplication = fractionsMultiply(fraction1, fraction2);
        int resultCompare = fractionsCompare(fraction1, fraction2);

        boolean passed = true;
        if(resultAddition.whole != expectedResultAddition.whole) {
            System.out.printf("Test error: sum (whole) = %d, but expected sum (whole) = %d.",
                    resultAddition, expectedResultAddition);
            passed = false;
        }

        if(resultAddition.part != expectedResultAddition.part) {
            System.out.printf("Test error: sum (part) = %d, but expected sum (part) = %d.",
                    resultAddition, expectedResultAddition);
            passed = false;
        }

        if(resultDeduction.whole != expectedResultDeduction.whole) {
            System.out.printf("Test error: deduction (whole) = %d, but expected deduction = %d.",
                    resultDeduction, expectedResultDeduction);
            passed = false;
        }

        if(resultDeduction.part != expectedResultDeduction.part) {
            System.out.printf("Test error: deduction (part) = %d, but expected deduction = %d.",
                    resultDeduction, expectedResultDeduction);
            passed = false;
        }

        if(resultMultiplication.whole != expectedResultMultiplication.whole) {
            System.out.printf("Test error: mult (whole) = %d, but expected mult (whole) = %d.",
                    resultMultiplication, expectedResultMultiplication);
            passed = false;
        }

        if(resultMultiplication.part != expectedResultMultiplication.part) {
            System.out.printf("Test error: mult (part) = %d, but expected mult (part) = %d.",
                    resultMultiplication, expectedResultMultiplication);
            passed = false;
        }

        if(resultCompare != expectedResultCompare) {
            System.out.printf("Test error: result compare = %d, but expected result compare) = %d.",
                    resultCompare, expectedResultCompare);
            passed = false;
        }

        if (passed)
            System.out.println("Teat passed!");
    }
}


