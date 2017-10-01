package javasummer2017.Workers;


    public class HourWorker extends Worker {

        HourWorker(String firstName, String lastName, double rate) {
            super(firstName, lastName, rate);
        }

        @Override
        protected double countMonthlySalary() {
            double salary = 20.8 * 8 * getRate();
            return salary;
        }
    }


