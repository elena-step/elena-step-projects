package javasummer2017;


import java.util.Scanner;

public class ThreeSortingsWithMethods {
    public static void main(String[] args) {
        int n = 4;
        int[] arrUser = new int[n];
        int[] arr = new int[arrUser.length];
        String[] sort = {"Сортировка выбором: ", "Пузырьковая сортировка: ", "Сортировка вставками: "};
        String str;


        fillArrayByUser(n, arrUser);
        System.out.println();

        for (int i = 0; i < sort.length; i++) {
            printNameOfSorting(sort[i]);
            str = sort[i];
            System.out.println();
            printArrayWithCopying(arrUser, arr);

            if (str.equals(sort[0])) {
                SelectSorting(arr);
            }

            else if (str.equals(sort[1])) {
                BubbleSorting(arr);
            }

            else if (str.equals(sort[2])) {
                InsertSorting(arr);
            }

            else {
                System.out.println("ERROR");
            }
        }
    }

    private static void fillArrayByUser(int n, int[] arr) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter " + n + " integers:");
        for (int i = 0; i < arr.length; i++) {
            if (!scan.hasNextInt()) {
                System.out.println("You need to enter integers only!");
                System.out.println("Go on to enter!");
                scan.next();
                i--;
            } else {
                arr[i] = scan.nextInt();
            }
        }
    }

    private static void printArrayWithCopying(int[] arr, int[] arrCopy) {
        System.out.print("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            arrCopy[i] = arr[i];
        }
        System.out.println();
    }

    private static void printNameOfSorting(String s) {
        System.out.print(s);
        System.out.println();
    }


    private static void SelectSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = 0;
            for (int j = 1; j < arr.length - i; j++) {
                max = getMax(arr, max, j);
            }
            conditionSwapToEnd(arr, i, max);
            printPassNumberPlusOne(i);
            printArray(arr);
        }
        System.out.println();
    }

    private static int getMax(int[] arr, int max, int i) {
        if (arr[i] > arr[max]) {
            max = i;
        }
        return max;
    }

    private static void conditionSwapToEnd(int[] arr, int i, int max) {
        if (max != arr.length - i - 1) {
            swapToEnd(arr, i, max);
        }
    }

    private static void swapToEnd(int[] arr, int i, int max) {
        int tmp = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = arr[max];
        arr[max] = tmp;
    }

    private static void printPassNumberPlusOne(int i) {
        System.out.print((i + 1) + "-й проход: ");
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    private static void BubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            printPassNumberPlusOne(i);
            for (int j = 0; j < arr.length - 1 - i; j++) {
                alignmentPrint(j);
                conditionSwap(arr, j);
                printArray(arr);
            }
        }
        System.out.println();
    }

    private static void alignmentPrint(int i) {
        if (i > 0) {
            for(int numberOfSpaces = 0; numberOfSpaces < 12; numberOfSpaces++){
                System.out.print(" ");
            }
        }
    }

    private static void conditionSwap(int[] arr, int i) {
        if (arr[i] > arr[i + 1]) {
            swap(arr, i);
        }
    }

    private static void swap(int[] arr, int i) {
        int tmp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = tmp;
    }


    private static void InsertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            conditionShiftOfElement(arr, i, tmp);
            printPassNumber(i);
            printArray(arr);
        }
        System.out.println();
    }

    private static void conditionShiftOfElement(int[] arr, int i, int tmp) {
        int j;
        for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
            shiftOfElement(arr, j);
        }
        arr[j + 1] = tmp;
    }

    private static void shiftOfElement(int[] arr, int i) {
        arr[i + 1] = arr[i];
    }

    private static void printPassNumber(int i) {
        System.out.print((i) + "-й проход: ");
    }

}
