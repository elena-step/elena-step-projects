package javasummer2017.ForeignPassportClone;

public class Passport implements Cloneable {
    private static final String DEFAULT_FIRST_NAME = "Unknown";
    private static final String DEFAULT_LAST_NAME = DEFAULT_FIRST_NAME;
    private static final String DEFAULT_PASSPORT_SERIAL = "Unknown passport data";
    private static final String DEFAULT_PASSPORT_NUMBER = DEFAULT_PASSPORT_SERIAL;

    private String firstName;
    private String lastName;
    private String passportSerial;
    private String passportNumber;


    Passport() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
    }

    Passport(String firstName, String lastName) {
        this(firstName, lastName, DEFAULT_PASSPORT_SERIAL, DEFAULT_PASSPORT_NUMBER);
    }

    Passport(String firstName, String lastName, String passportSerial, String passportNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPassportSerial(passportSerial);
        setPassportNumber(passportNumber);
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

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial == null ? DEFAULT_PASSPORT_SERIAL : passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber == null ? DEFAULT_PASSPORT_SERIAL : passportNumber;
    }

    @Override
    public Passport clone() throws CloneNotSupportedException {
        return (Passport) super.clone();
    }
}




