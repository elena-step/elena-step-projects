package javasummer2017.cardatabase;

import javasummer2017.cardatabase.entities.CarNumber;
import javasummer2017.cardatabase.entities.Driver;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        testDriverMethodClone();
        testCarNumberMethodClone();

    }

    private static void testDriverMethodClone() throws CloneNotSupportedException {
        Driver driver = new Driver("Ivan", "Ivanov");
        System.out.println(driver);

        Driver driverClone = driver.clone();
        System.out.println("driverClone before modification:");
        System.out.println(driverClone);

        driverClone.setFirstName("Svetlana");
        driverClone.setLastName("Svetlova");

        System.out.println("driver after modification:");
        System.out.println(driver);
        System.out.println("driverClone after modification:");
        System.out.println(driverClone);
    }

    private static void testCarNumberMethodClone()throws CloneNotSupportedException{
        CarNumber carNumber = new CarNumber("AA", 1, "BB");
        System.out.println(carNumber);

        CarNumber carNumberClone = carNumber.clone();
        System.out.println("carNumber clone:");
        System.out.println(carNumberClone);
    }


}

