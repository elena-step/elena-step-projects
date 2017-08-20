package javasummer2017;

import java.util.Scanner;

public class AverageWeightPeople {
        public static void main(String[] args) {
            System.out.println("The minimal group of people must have 1 fat person (weight > 100 kg)" +
                    " and 1 person with normal weight (weight <= 100 kg.");
            System.out.println("Please, input the weight of every person in the group.");
            System.out.println("Input the key \"1\" to finish the information input.");

            double[] weightPeopleInGroup = inputWeightPeopleInGroupByUser();

            checkNegativeNumbersWithExit(weightPeopleInGroup);

            double averageFat = averageWeightFatPeople(weightPeopleInGroup);
            double averageNormal = averageWeightNormalPeople(weightPeopleInGroup);

            System.out.printf("Average weight of fat people in group = %.2f", averageFat);
            System.out.println();
            System.out.printf("Average weight of normal people in group = %.2f", averageNormal);
            System.out.println();
            // test();
        }


        private static double[] inputWeightPeopleInGroupByUser() {
            Scanner scan = new Scanner(System.in);
            int counter = 0;
            double[] weightGroup = new double[1];
            while (true) {
                double number = scan.nextDouble();

                if (number == 1) {
                    System.out.println("Thank you, the information input done.");
                    break;
                } else if (!scan.hasNextDouble()) {
                    System.err.println("Input error!");
                    System.exit(0);

           /* } else if (number < 0) {
                System.err.println("Error! Weight can be positive only.");
                System.exit(0);*/

                    // проверку на отсутствие отрицательных чисел хотела сделать до ввода числа в массив
                    // но
                    // почему-то не срабатывает как нужно
                    // т.е. срабатывает с запаздыванием, после ввода положительного числа

                } else {
                    if (counter == 0) {
                        weightGroup[counter] = number;
                        counter++;
                    } else {
                        double[] wGroup = new double[counter + 1];
                        System.arraycopy(weightGroup, 0, wGroup, 0, weightGroup.length);
                        weightGroup = wGroup;
                        weightGroup[counter] = number;
                        counter++;
                    }
                }
            }
            return weightGroup;
        }


        private static void checkNegativeNumbersWithExit(double[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    System.out.println("Error! The weight can be positive number only!");
                    System.out.println("Try again!");
                    System.exit(0);
                }
            }
            System.out.println("The group of " + arr.length + " people is formed.");
        }


        private static double averageWeightFatPeople(double[] arr) {
            double weightFatPeople = 0;
            int counterFat = 0;
            double result = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 100) {
                    weightFatPeople += arr[i];
                    counterFat++;
                }
            }
            if (counterFat == 0) {
                System.out.println("Error! The group should include minimum 1 fat person.");
                System.out.println("Try again!");
                System.exit(0);
            } else {
                result = weightFatPeople / counterFat;
            }
            return result;
        }


        private static double averageWeightNormalPeople(double[] arr) {
            double weightNormalPeople = 0;
            int counterNormal = 0;
            double result = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= 100) {
                    weightNormalPeople += arr[i];
                    counterNormal++;
                }
            }
            if (counterNormal == 0) {
                System.out.println("Error! The group should include minimum 1 normal person.");
                System.out.println("Try again!");
                System.exit(0);
            } else {
                result = weightNormalPeople / counterNormal;
            }
            return result;
        }

        private static void test() {
            double[] testData = {70.1, 80.1, 90.1, 110, 120};
            double expectedAverageFat = 115;
            double expectedAverageNormal = 80.1;

            boolean passed = true;

            checkNegativeNumbersWithExit(testData);

            double testAverageFat = averageWeightFatPeople(testData);
            double testAverageNormal = averageWeightNormalPeople(testData);



            if (testAverageFat != expectedAverageFat) {
                System.out.printf("Test error: average weight of fat people = %.2f, but expected = %.2f",
                        testAverageFat, expectedAverageFat);
                System.out.println();
                passed = false;
            }

            if (testAverageNormal != expectedAverageNormal) {
                System.out.printf("Test error: average weight of normal people = %.2f, but expected = %.2f",
                        testAverageNormal, expectedAverageNormal);
                System.out.println();
                passed = false;
            }

            if (passed) {
                System.out.println("Test passed.");
            }
        }
}
