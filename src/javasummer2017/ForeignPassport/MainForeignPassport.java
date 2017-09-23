package javasummer2017.ForeignPassport;

public class MainForeignPassport {
    public static void main(String[] args) {

        ForeignPassport fp1 = new ForeignPassport("Ivanov", "Ivan",
                "AA", "123456");
        fp1.visas[0] = new Visas("SA", "tourist", "Cept 01, 2017", "Nov 30, 2017");
        fp1.visas[1] = new Visas("USA", "business", "Oct 15, 2017", "Oct 15, 2018");
        fp1.visas[2] = new Visas("Schengen", "work");
        fp1.printForeignPassport();

    }

}
