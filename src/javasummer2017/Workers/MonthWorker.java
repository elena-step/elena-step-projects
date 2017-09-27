package javasummer2017.Workers;

public class MonthWorker extends Worker {

        MonthWorker(String firstName, String lastName, double rate) {
            super(firstName, lastName, rate);
        }


        @Override
        protected double countMonthlySalary() {
            double salary = getRate();
            return salary;
        }
    }


