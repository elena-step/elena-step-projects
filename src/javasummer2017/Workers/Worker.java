package javasummer2017.Workers;

public abstract class Worker implements Comparable<Worker> {
    private static int counter = 0;
    private static final String DEFAULT_FIRST_NAME = "Unknown";
    private static final String DEFAULT_LAST_NAME = DEFAULT_FIRST_NAME;

    private String firstName;
    private String lastName;
    private int id;
    private double rate;


    Worker() {
        this("Unknown", "Unknown", 0);
    }

    Worker(String firstName, String lastName, double rate) {
        setFirstName(firstName);
        setLastName(lastName);
        setRate(rate);
        setId();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? DEFAULT_FIRST_NAME : firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? DEFAULT_LAST_NAME : lastName;
    }

    public String getName() {
        return lastName + " " + firstName;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        counter++;
        this.id = counter;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    protected abstract double countMonthlySalary();

    @Override
    public int compareTo(Worker o) {
        if (this.countMonthlySalary() == o.countMonthlySalary()) {
            return this.lastName.compareTo(o.lastName);
        }
        return -Double.compare(this.countMonthlySalary(), o.countMonthlySalary());
    }

    @Override
    public String toString() {
        return "id = " + id +
                "   " +
                lastName + " " + firstName +
                "   salary = " + this.countMonthlySalary();
    }
}


