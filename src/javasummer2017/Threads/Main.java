package javasummer2017.Threads;

/** Программа должна запустить 5 потоков с именами Т1, Т2, Т3, Т4 и Т5.
 * Каждый поток при старте должен вывести на экран текст "Поток <имя потока> запустился"
 * После старта потоков приложение должно спросить пользователя,
 * какой поток он хочет остановить. Пользователь вводит имя потока.
 * Если имя введено верно и такой поток еще работает - это поток нужно остановить.
 * При остановке поток пишет в консоль "Поток <имя потока> остановлен".
 * Приложение завершается когда пользователь остановил таким образом все 5 потоков.
  */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*Thread bT1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " started.");
                try {
                    while (true) {
                        Thread.currentThread();
                        Thread.sleep(100000);
                    }
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
            }
        }, "T1");


        Thread bT2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " started.");
                try {
                    while (true) {
                        Thread.currentThread();
                        Thread.sleep(100000);
                    }
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
            }
        }, "T2");


        Thread bT3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " started.");
                try {
                    while (true) {
                        Thread.currentThread();
                        Thread.sleep(100000);
                    }
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
            }
        }, "T3");


        Thread bT4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " started.");
                try {
                    while (true) {
                        Thread.currentThread();
                        Thread.sleep(100000);
                    }
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
            }
        }, "T4");


        Thread bT5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " started.");
                try {
                    while (true) {
                        Thread.currentThread();
                        Thread.sleep(100000);
                    }
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
            }
        }, "T5");*/

        MyThread bT1 = new MyThread("T1");
        MyThread bT2 = new MyThread("T2");
        MyThread bT3 = new MyThread("T3");
        MyThread bT4 = new MyThread("T4");
        MyThread bT5 = new MyThread("T5");

        bT1.start();
        bT2.start();
        bT3.start();
        bT4.start();
        bT5.start();

        Scanner scan = new Scanner(System.in);
        String choice;
        int counter = 0;

        while (counter < 5) {
            Thread.currentThread().sleep(1000);
            System.out.println("Please, input Thread's name for stop it.");
            choice = scan.nextLine();

            switch (choice) {
                case "T1":
                    if (bT1.isAlive()) {
                        bT1.interrupt();
                        counter++;
                    }
                    break;
                case "T2":
                    if (bT2.isAlive()) {
                        bT2.interrupt();
                        counter++;
                    }
                    break;
                case "T3":
                    if (bT3.isAlive()) {
                        bT3.interrupt();
                        counter++;
                    }
                    break;
                case "T4":
                    if (bT4.isAlive()) {
                        bT4.interrupt();
                        counter++;
                    }
                    break;
                case "T5":
                    if (bT5.isAlive()) {
                        bT5.interrupt();
                        counter++;
                    }
                default:
                    System.out.println("Error. Try again.");
            }
        }


    }
}
