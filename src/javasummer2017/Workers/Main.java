package javasummer2017.Workers;

import java.util.Arrays;

/**
 * Построить три класса (базовый и 2 потомка), описывающих
 * некоторых работников с почасовой оплатой (один из потомков) и
 * фиксированной оплатой (второй потомок).
 * Описать в базовом классе абстрактный метод
 * для расчета среднемесячной заработной платы.
 * Для «повременщиков» формула для расчета такова:
 * «среднемесячная заработная плата = 20.8 * 8 * почасовую ставку»,
 * для работников с фиксированной оплатой
 * «среднемесячная заработная плата = фиксированной месячной оплате».
 * <p>
 * a) Упорядочить всю последовательность работников
 * по убыванию среднемесячного заработка.
 * При совпадении зарплаты – упорядочивать данные по алфавиту по имени.
 * Вывести идентификатор работника, имя и среднемесячный заработок для всех элементов списка.
 * <p>
 * b) Вывести первые 5 имен работников из полученного в пункте а) списка.
 * <p>
 * c) Вывести последние 3 идентификатора работников из полученного в пункте а) списка.
 */

public class Main {

    public static void main(String[] args) {
        HourWorker hw1 = new HourWorker("Ivan", "Ivanov", 10);
        HourWorker hw2 = new HourWorker(("Petr"), "Petrov", 10);
        HourWorker hw3 = new HourWorker("Sidor", "Sidorov", 10);
        HourWorker hw4 = new HourWorker("Vasya", "Pupkin", 12);
        HourWorker hw5 = new HourWorker("Viktor", "Viktorov", 15);

        MonthWorker mw1 = new MonthWorker("Svetlana", "Svetlova", 2000);
        MonthWorker mw2 = new MonthWorker("Mariya", "Maryina", 2000);
        MonthWorker mw3 = new MonthWorker("Nadezhda", "Nadeshdina", 3000);
        MonthWorker mw4 = new MonthWorker("Olena", "Olenina", 5000);
        MonthWorker mw5 = new MonthWorker("Katya", "Katina", 5000);

        Worker[] workers = {hw1, hw2, hw3, hw4, hw5, mw1, mw2, mw3, mw4, mw5};

        //sortSalaryOfWorkers(workers);  //выполнено до изучения Comparable

        Arrays.sort(workers);

        int n = workers.length;

        for (int i = 0; i < n; i++) {
            System.out.println(workers[i]);
        }
        System.out.println();

        for (int i = 0; i < 5 && i < n; i++) {
            System.out.println(workers[i].getName());
        }
        System.out.println();

        for (int i = n - 3 < 0 ? 0 : n - 3; i < n; i++) {
            System.out.println(workers[i].getId());
        }

    }

   /* private static void sortSalaryOfWorkers(Worker[] workers) {  //выполнено до изучения Comparable
        int n = workers.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (workers[j - 1].countMonthlySalary() < (workers[j].countMonthlySalary())) {
                    Worker temp = workers[j - 1];
                    workers[j - 1] = workers[j];
                    workers[j] = temp;
                }
                if (workers[j - 1].countMonthlySalary() == (workers[j].countMonthlySalary())) {
                    if (workers[j - 1].getLastName().compareTo(workers[j].getLastName()) > 0) {
                        Worker temp = workers[j - 1];
                        workers[j - 1] = workers[j];
                        workers[j] = temp;
                    }
                }
            }
        }
    }*/
//добавить округление

}


