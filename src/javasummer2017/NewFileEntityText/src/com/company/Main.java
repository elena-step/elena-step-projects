package javasummer2017.NewFileEntityText.src.com.company;


import javasummer2017.NewFileEntityText.src.com.company.entities.Passport;
import javasummer2017.NewFileEntityText.src.com.company.entities.Visa;
import javasummer2017.NewFileEntityText.src.com.company.services.accessors.PassportAccessor;
import javasummer2017.NewFileEntityText.src.com.company.services.accessors.VisaAccessor;
import javasummer2017.NewFileEntityText.src.com.company.services.accessors.implementations.TextFilePassportAccessor;
import javasummer2017.NewFileEntityText.src.com.company.services.accessors.implementations.TextFileVisaAccessor;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        testWritePassports();
//        testWriteVisas();
//        testReadPassports();
        testReadVisas();



//-------------------------------------------------------------
//        List list = new ArrayList();
//        list.add("");
//        list.clear();
//
//        if (list instanceof ArrayList) {
//            ArrayList arrayList = (ArrayList) list;
//            arrayList.ensureCapacity(5);
//        }

    }

   protected static void testReadVisas(){
        VisaAccessor visaAccessor = new TextFileVisaAccessor("visas.psp");
        Collection<Visa> visas = visaAccessor.readAll();
       System.out.println(visas);

   }


    protected static void testReadPassports() {
        PassportAccessor passportAccessor = new TextFilePassportAccessor("passports.psp");
        Collection<Passport> passports = passportAccessor.readAll();
        System.out.println(passports);
    }

    private static void testWriteVisas() {
        VisaAccessor visaAccessor = new TextFileVisaAccessor("visas.psp");
        Visa[] visas = {
                new Visa("AA213654",
                        "Gonduras",
                        new GregorianCalendar(2017, 11, 3),
                        new GregorianCalendar(2017,12,3)),

                new Visa("AA213654",
                        "Zimbabwe",
                        new GregorianCalendar(2017, 11, 3),
                        new GregorianCalendar(2019,1,1)),

                new Visa("AE154789",
                        "Zimbabwe",
                        new GregorianCalendar(2017, 11, 3),
                        new GregorianCalendar(2019,1,1)),

        };

        visaAccessor.save(Arrays.asList(visas));
    }

    private static void testWritePassports() {
        PassportAccessor passportAccessor = new TextFilePassportAccessor("passports.psp");
        Passport[] passports = {
                new Passport("Vasya", "Pupov", "AA213654"),
                new Passport("Petya", "Pupov", "AE154789"),
                new Passport("Grisha", "Pupov", "CA778877"),
                new Passport("Lisa", "Pupova", "KK998877")
        };

        passportAccessor.save(Arrays.asList(passports));
    }
}