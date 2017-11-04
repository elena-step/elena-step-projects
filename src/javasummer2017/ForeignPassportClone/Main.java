package javasummer2017.ForeignPassportClone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        ForeignPassport fp1 = new ForeignPassport("Ivan", "Ivanov",
                "AA", "111111");
        fp1.visas[0] = new Visa("SA", "tourist",
                2017, 9, 1,
                2017, 12, 31);
        fp1.visas[1] = new Visa("USA", "business",
                2017, 10, 15,
                2018, 10, 14);
        fp1.visas[2] = new Visa("Schengen", "work",
                2017, 11, 20,
                2018, 11, 19);
        System.out.println("fp1 (original):");
        fp1.printForeignPassport();

        ForeignPassport fp1Clone = fp1.clone();
        System.out.println("fp1Clone before modification:");
        fp1Clone.printForeignPassport();

        fp1Clone.setForeignPassportSerial("BB");
        fp1Clone.setForeignPassportNumber("222222");
        fp1Clone.setFirstName("Svetlana");
        fp1Clone.setLastName("Svetlova");
        fp1Clone.visas[0] = new Visa("USA", "work",
                2018, 1, 30,
                2019, 1, 29);
        fp1Clone.visas[1] = new Visa("Schengen", "tourist",
                2018, 11, 15,
                2021, 11, 14);
        fp1Clone.visas[2] = null;
        System.out.println("fp1 (original) after modification:");
        fp1.printForeignPassport();
        System.out.println("fp1Clone after modification:");
        fp1Clone.printForeignPassport();


    }
}


