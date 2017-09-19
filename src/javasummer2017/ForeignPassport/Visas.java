package javasummer2017.ForeignPassport;

public class Visas {
    private static final String DEFAULT_TYPE_OF_VISA = "Unknown";

    private String type;
    private String openingDate;
    private String closingDate;

     Visas() {                       //добавить дефолтные поля открытия/закрытия
        this.type = DEFAULT_TYPE_OF_VISA;
    }
    public Visas(String type) {
        setType(type);
        //setOpeningDate(openingDate);  // добавить по умолчанию
        //setClosingDate(closingDate);
    }

    public Visas(String type, String openingDate, String closingDate) {
        setType(type);
        setOpeningDate(openingDate);
        setClosingDate(closingDate);
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
        this.openingDate = openingDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }
}
