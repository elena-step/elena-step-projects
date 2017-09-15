package javasummer2017.ForeignPassport;

public class Passport {

    private static final String DEFAULT_PASSPORT_SERIAL = "Unknown";
    private static final String DEFAULT_PASSPORT_NUMBER = DEFAULT_PASSPORT_SERIAL;

    private String firstName;
    private String lastName;
    private String passportSerial;
    private String passportNumber;


    public Passport() {

    }

    public Passport(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportSerial = DEFAULT_PASSPORT_SERIAL;
        this.passportNumber = DEFAULT_PASSPORT_NUMBER;

    }

    public Passport(String firstName, String lastName, String passportSerial, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


}


