package javasummer2017.ForeignPassport;

public class ForeignPassport extends Passport {

    private static final String DEFAULT_FOREIGN_PASSPORT_SERIAL = "Unknown";
    private static final String DEFAULT_FOREIGN_PASSPORT_NUMBER = DEFAULT_FOREIGN_PASSPORT_SERIAL;
    private static final int NUMBER_OF_VISAS = 100;

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
        this.visas = new Visas[NUMBER_OF_VISAS];
    }

    public String getForeignPassportSerial() {
        return foreignPassportSerial;
    }

    public void setForeignPassportSerial(String foreignPassportSerial) {
        this.foreignPassportSerial = foreignPassportSerial == null ? DEFAULT_FOREIGN_PASSPORT_SERIAL : foreignPassportSerial;
    }

    public String getForeignPassportNumber() {
        return foreignPassportNumber;
    }

    public void setForeignPassportNumber(String foreignPassportNumber) {
        this.foreignPassportNumber = foreignPassportNumber == null ? DEFAULT_FOREIGN_PASSPORT_NUMBER : foreignPassportNumber;
    }

    void printForeignPassport() {
        System.out.printf("Person's name: %s %s%n" +
                        "Foreign passport Series: %s   Foreign passport Number: %s%n" +
                        "Visas: %n",
                getFirstName(), getLastName(),
                getForeignPassportSerial(), getForeignPassportNumber());

        for (int i = 0; i < visas.length; i++) {
            if (visas[i] != null) {
                System.out.printf("%d. Land: %s   Type of visa: %s   Validity period: %s - %s%n",
                        i + 1, visas[i].getLand(), visas[i].getType(),
                        visas[i].getOpeningDate(), visas[i].getClosingDate());
            }
        }
    }
}
