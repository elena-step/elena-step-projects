package javasummer2017;

import java.util.Scanner;

public class Deposit {

    public static void main(String[] args) {

        System.out.println("Please, input data. ");
        System.out.print("Deposit, USD: ");
        double bodyDepositUser = inputDataUser();

        System.out.print("Persent, USD: ");
        double persentUser = inputDataUser();

        System.out.print("Amount of monthly interest, USD: ");
        double monthlyInterestUser = inputDataUser();

        System.out.print("Amount deposit with interest, USD: ");
        double depositWithInterestUser = inputDataUser();

        System.out.println();
        System.out.println("Data inputed: ");
        System.out.print("Deposit, USD: ");
        printData(bodyDepositUser);
        System.out.print("Persent, USD: ");
        printData(persentUser);
        System.out.print("Amount of monthly interest, USD: ");
        printData(monthlyInterestUser);
        System.out.print("Amount deposit with interest, USD: ");
        printData(depositWithInterestUser);

        int monthFromDepositOpening_ForExceedingInterest = numberOfMonthExceedingInterest(bodyDepositUser,
                persentUser, monthlyInterestUser);
        System.out.println();
        System.out.printf("The value of the monthly interest will exceed %.2f USD on the %d th month " +
                "from the deposit opening.", monthlyInterestUser, monthFromDepositOpening_ForExceedingInterest);

        int monthFromDepositOpening_ForExceedingDeposit = numberOfMonthExceedingDeposit(bodyDepositUser,
                persentUser, depositWithInterestUser);
        System.out.println();
        System.out.printf("The value of the deposit with interest will exceed %.2f USD in %d months " +
                "from the deposit opening.", depositWithInterestUser, monthFromDepositOpening_ForExceedingDeposit);
        //test();
    }

    private static double inputDataUser() {
        Scanner scan = new Scanner(System.in);
        double data = 0;
        if (!scan.hasNextDouble()) {
            System.err.println("Input error!");
            System.exit(0);
        } else {
            data = scan.nextDouble();
        }
        //scan.close();
        return data;
    }

    private static void printData(double data) {
        System.out.printf("%.2f%n", data);
    }


    private static int numberOfMonthExceedingInterest(double deposit, double persent, double monthlyInterestUser) {
        int month = 0;
        double monthlyInterest = 0;
        while (monthlyInterest < monthlyInterestUser) {
            monthlyInterest = deposit * persent / 100;
            deposit += monthlyInterest;
            month++;
        }
        return month;
    }

    private static int numberOfMonthExceedingDeposit(double deposit, double persent, double depositWithInterestUser) {
        int month = 0;
        double depositWithInterest = deposit;
        while (depositWithInterest < depositWithInterestUser) {
            depositWithInterest += depositWithInterest * persent / 100;
            month++;
        }
        return month;
    }

    private static void test() {
        double bodyDeposit = 1000.00;
        double persent = 2.00;
        double monthlyInterest = 30.00;
        double depositWithInterest = 1200.00;

        int expectedMonth_ForExceedingInterest = 22;
        int expectedMonth_ForExceedingDeposit = 10;

        int month_ForExceedingInterest = numberOfMonthExceedingInterest(bodyDeposit, persent, monthlyInterest);
        int month_ForExceedingDeposit = numberOfMonthExceedingDeposit(bodyDeposit, persent, depositWithInterest);

        boolean passed = true;
        if (month_ForExceedingInterest != expectedMonth_ForExceedingInterest) {
            System.out.printf("Test error: month (exceeding interest) = %d, but expected = %d .%n",
                    month_ForExceedingInterest, expectedMonth_ForExceedingInterest);
            passed = false;
        }

        if (month_ForExceedingDeposit != expectedMonth_ForExceedingDeposit) {
            System.out.printf("Test error: month (exceeding deposit) = %d, but expected = %d .%n",
                    month_ForExceedingDeposit, expectedMonth_ForExceedingDeposit);
            passed = false;
        }

        if (passed) {
            System.out.println("Test passed.");
        }
    }

}
