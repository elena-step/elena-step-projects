package javasummer2017.ForeignPassport;

public class ForeignPassport extends Passport {

    private static final String DEFAULT_FOREIGN_PASSPORT_SERIAL = "Unknown";
    private static final String DEFAULT_FOREIGN_PASSPORT_NUMBER = DEFAULT_FOREIGN_PASSPORT_SERIAL;


    private String foreignPassportSerial;
    private String foreignPassportNumber;
    protected Visas[] visas;

    ForeignPassport() {
        super();
    }

    ForeignPassport(String firstName, String lastName) {
        this(firstName, lastName, DEFAULT_FOREIGN_PASSPORT_SERIAL, DEFAULT_FOREIGN_PASSPORT_NUMBER);
    }

    ForeignPassport(String firstName, String lastName,
                    String foreignPassportSerial, String foreignPassportNumber) {
        super(firstName, lastName);
        setForeignPassportSerial(foreignPassportSerial);
        setForeignPassportNumber(foreignPassportNumber);
        this.visas = new Visas[10];
    }

    public String getForeignPassportSerial() {
        return foreignPassportSerial;
    }

    public void setForeignPassportSerial(String foreignPassportSerial) {
        this.foreignPassportSerial = foreignPassportSerial == null ? DEFAULT_FOREIGN_PASSPORT_SERIAL : foreignPassportSerial;
    }

    public String getForeignPassportNumber()
    {
        return foreignPassportNumber;
    }

    public void setForeignPassportNumber(String foreignPassportNumber) {
        this.foreignPassportNumber = foreignPassportNumber == null ? DEFAULT_FOREIGN_PASSPORT_NUMBER : foreignPassportNumber;
    }

}
