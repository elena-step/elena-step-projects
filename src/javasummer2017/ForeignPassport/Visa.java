package javasummer2017.ForeignPassport;

public class Visa {
    private String type;
    private String openingDate;
    private String closingDate;

    public Visa(){

    }

    public Visa(String type, String openingDate, String closingDate) {
        this.type = type;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
