package javasummer2017.ForeignPassport;

public class MainForeignPassport {
    public static void main(String[] args) {

        ForeignPassport fp1 = new ForeignPassport("Ivanov", "Ivan",
                "AA", "123456");
        fp1.visas[0] = new Visas("SA", "tourist", "Cept 01, 2017", "Nov 30, 2017");
        fp1.visas[1] = new Visas("USA","business", "Oct 15, 2017", "Oct 15, 2018");
        fp1.visas[2]=new Visas("Schengen", "work");
        printForeignPassport(fp1);

    }

    static void printForeignPassport(ForeignPassport fp) {
        System.out.printf("Person's name: %s %s%n" +
                        "Foreign passport Series: %s   Foreign passport Number: %s%n" +
                        "Visas: %n",
                fp.getFirstName(), fp.getLastName(),
                fp.getForeignPassportSerial(), fp.getForeignPassportNumber());
       /* System.out.println("Foreign passport Series: " + fp.getForeignPassportSerial()
                + "   Foreign passport Number: " + fp.getForeignPassportNumber());*/
        for (int i = 0; i < fp.visas.length; i++) {
            if (fp.visas[i] != null) {
                System.out.printf("%d. Land: %s   Type of visa: %s   Validity period: %s - %s%n",
                        i+1, fp.visas[i].getLand(), fp.visas[i].getType(),
                        fp.visas[i].getOpeningDate(), fp.visas[i].getClosingDate());
            }
        }


    }
}
