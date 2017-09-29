package javasummer2017.ForeignPassportClone;


import java.time.LocalDate;

public class Visa implements Cloneable {
    private static final String DEFAULT_LAND = "Unknown";
    private static final String DEFAULT_TYPE_OF_VISA = "Unknown";

    private String land;
    private String type;
    private LocalDate openingDate;
    private LocalDate closingDate;

    Visa() {
        this.land = DEFAULT_LAND;
        this.type = DEFAULT_TYPE_OF_VISA;
    }

    public Visa(String land, String type,
                int yearOpeningDate, int monthOpeningDate, int dayOpeningDay,
                int yearClosingDate, int monthClosingDate, int dayClosingDate) {
        setLand(land);
        setType(type);
        openingDate = LocalDate.of(yearOpeningDate, monthOpeningDate, dayOpeningDay);
        closingDate = LocalDate.of(yearClosingDate, monthClosingDate, dayClosingDate);
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land == null ? DEFAULT_LAND : land;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? DEFAULT_TYPE_OF_VISA : type;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    @Override
    public Visa clone() throws CloneNotSupportedException {
        Visa visaClone = (Visa) super.clone();
        return visaClone;
    }

    void printVisa() {
        System.out.printf("Land: %s   Type of visa: %s   Validity period: %s - %s%n",
                getLand(), getType(),
                openingDate.toString(), closingDate.toString());
    }
}


