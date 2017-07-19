package javasummer2017;


import java.util.Scanner;

public class ThreeSortings {
    public static void main(String[] args) {
        int n = 4;
        int[] arrFirst = new int[n];
        int[] arr = new int[arrFirst.length];
        String[] sort = {"Сортировка выбором: ", "Пузырьковая сортировка: ", "Сортировка вставками: "};
        Scanner scan = new Scanner(System.in);
        String str;
        int count = 0;

        System.out.println("Please, enter " + n + " integers:");
        for (int i = 0; i < arrFirst.length; i++) {
            if (!scan.hasNextInt()) {
                System.out.println("You need to enter integers only!");
                System.out.println("Go on to enter!");
                scan.next();
                i--;
            } else {
                arrFirst[count] = scan.nextInt();
                count++;
            }
        }
        System.out.println();

        for (int k = 0; k < sort.length; k++) {
            System.out.print(sort[k]);
            str = sort[k];
            System.out.println();
            System.out.println();
            System.out.print("Исходный массив: ");
            for (int i = 0; i < arrFirst.length; i++) {
                System.out.print(arrFirst[i] + " ");
                arr[i] = arrFirst[i];
            }
            System.out.println();

            if (str.equals(sort[0])) {
                for (int i = 0; i < arr.length - 1; i++) {
                    int max = 0;
                    int len = arr.length - i;
                    for (int j = 1; j < len; j++) {
                        if (arr[j] > arr[max]) {
                            max = j;
                        }
                    }
                    if (max != len - 1) {
                        int tmp = arr[len - 1];
                        arr[len - 1] = arr[max];
                        arr[max] = tmp;
                    }
                    System.out.print((i + 1) + "-й проход: ");
                    for (int m = 0; m < arr.length; m++) {
                        System.out.print(arr[m] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            } else if (str.equals(sort[1])) {
                for (int i = 0; i < arr.length - 1; i++) {
                    System.out.print((i + 1) + "-й проход: ");
                    for (int j = 0; j < arr.length - 1 - i; j++) {
                        if (j > 0) {
                            System.out.print("            ");
                        }
                        if (arr[j] > arr[j + 1]) {
                            int tmp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = tmp;
                        }
                        for (int m = 0; m < arr.length; m++) {
                            System.out.print(arr[m] + " ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            } else if (str.equals(sort[2])) {
                for (int i = 1; i < arr.length; i++) {
                    int tmp = arr[i];
                    int j;
                    for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j + 1] = tmp;
                    System.out.print((i) + "-й проход: ");
                    for (int m = 0; m < arr.length; m++) {
                        System.out.print(arr[m] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            } else
                System.out.println("ERROR");
        }
    }
}
