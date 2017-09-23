package javasummer2017.ForeignPassport;

public class MainForeignPassport {
    public static void main(String[] args) {

        ForeignPassport fp1 = new ForeignPassport("Ivanov", "Ivan",
                "AA", "123456");
        fp1.visas[0] = new Visas("SA", "tourist",
                2017, 9, 1,
                2017, 12,31);
        fp1.visas[1] = new Visas("USA", "business",
                2017,10,15,
                2018, 10,14);
        fp1.visas[2] = new Visas("Schengen", "work",
                2017, 11, 20,
                2018,11,19);
        fp1.printForeignPassport();

    }

}
