package javasummer2017.ForeignPassport;

public class MainForeignPassport {
    public static void main(String[] args) {
        ForeignPassport fp1 = new ForeignPassport("Ivanov", "Ivan",
                "AA", "123456",
                "tourist", "Sep 01, 2017", "Nov 30, 2017");
        printForeignPassport(fp1);
    }

    static void printForeignPassport(ForeignPassport fp) {
        System.out.println("Person's name: " + fp.getFirstName()  + " " + fp.getLastName());
        System.out.println("Foreign passport Series: " + fp.getForeignPassportSerial()
                + "   Foreign passport Number: " + fp.getForeignPassportNumber());
        System.out.println("Type of visa: ");
    }
}
