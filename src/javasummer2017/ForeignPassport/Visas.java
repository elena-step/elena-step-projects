package javasummer2017.ForeignPassport;

import java.util.GregorianCalendar;

public class Visas {
    private static final String DEFAULT_LAND = "Unknown";
    private static final String DEFAULT_TYPE_OF_VISA = "Unknown";
    private static final String DEFAULT_OPENING_DATE = "Waiting for the date";
    private static final String DEFAULT_CLOSING_DATE = DEFAULT_OPENING_DATE;

    private String land;
    private String type;
    private String openingDate;
    private String closingDate;

    Visas() {                       //добавить дефолтные поля открытия/закрытия
        this.type = DEFAULT_TYPE_OF_VISA;
    }

    Visas(String land) {
        this(land, DEFAULT_TYPE_OF_VISA);
    }

    Visas(String land, String type) {
        this(land, type, DEFAULT_OPENING_DATE, DEFAULT_CLOSING_DATE);
    }

    public Visas(String land, String type, String openingDate, String closingDate) {
        setLand(land);
        setType(type);
        setOpeningDate(openingDate);
        setClosingDate(closingDate);
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

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate == null ? DEFAULT_OPENING_DATE : openingDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate == null ? DEFAULT_CLOSING_DATE : closingDate;
    }
}
