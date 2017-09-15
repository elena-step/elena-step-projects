package javasummer2017.ForeignPassport;

public class ForeignPassport extends Passport {

    private static final String DEFAULT_FOREIN_PASSPORT_SERIAL = "Unknown";
    private static final String DEFAULT_FOREIGN_PASSPORT_NUMBER = DEFAULT_FOREIN_PASSPORT_SERIAL;


    private String foreignPassportSerial;
    private String foreignPassportNumber;
    private Visa visa;

    public ForeignPassport() {
    }

    public ForeignPassport(String firstName, String lastName) {
        super(firstName, lastName);
        setForeignPassportSerial(foreignPassportSerial);
        setForeignPassportNumber(foreignPassportNumber);
        visa = new Visa();
    }

    public ForeignPassport(String firstName, String lastName,
                           String foreignPassportSerial, String foreignPassportNumber) {
        super(firstName, lastName);
        setForeignPassportSerial(foreignPassportSerial);
        setForeignPassportNumber(foreignPassportNumber);
        visa = new Visa();
    }

    public ForeignPassport(String firstName, String lastName,
                           String foreignPassportSerial, String foreignPassportNumber,
                           String type, String openingDate, String closingDate) {
        super(firstName, lastName);
        setForeignPassportSerial(foreignPassportSerial);
        setForeignPassportNumber(foreignPassportNumber);
        visa = new Visa(type, openingDate, closingDate);
    }

    public String getForeignPassportSerial() {
        return foreignPassportSerial;
    }

    public void setForeignPassportSerial(String foreignPassportSerial) {
        this.foreignPassportSerial = foreignPassportSerial;
    }

    public String getForeignPassportNumber() {
        return foreignPassportNumber;
    }

    public void setForeignPassportNumber(String foreignPassportNumber) {
        this.foreignPassportNumber = foreignPassportNumber;
    }


}
