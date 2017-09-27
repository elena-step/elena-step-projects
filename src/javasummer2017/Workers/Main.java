package javasummer2017.Workers;

public class Main {

        public static void main(String[] args) {
            HourWorker hw1 = new HourWorker("Ivan", "Ivanov", 10);
            HourWorker hw2 = new HourWorker(("Petr"), "Petrov", 10);
            HourWorker hw3 = new HourWorker("Sidor", "Sidorov", 10);
            HourWorker hw4 = new HourWorker("Vasya", "Pupkin", 12);
            HourWorker hw5 = new HourWorker("Viktor", "Vilkin", 15);

            MonthWorker mw1 = new MonthWorker("Svetlana", "Svetlova", 2000);
            MonthWorker mw2 = new MonthWorker("Mariya", "Maryina", 2000);
            MonthWorker mw3 = new MonthWorker("Nadezhda", "Nadeshdina", 3000);
            MonthWorker mw4 = new MonthWorker("Olena", "Olenina", 5000);
            MonthWorker mw5 = new MonthWorker("Katya", "Katina", 5000);

            Worker[] workers = {hw1, hw2, hw3, hw4, hw5, mw1, mw2, mw3, mw4, mw5};

        }
    }


