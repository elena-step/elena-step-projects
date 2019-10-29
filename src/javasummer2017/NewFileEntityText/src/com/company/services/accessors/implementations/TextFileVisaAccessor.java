package javasummer2017.NewFileEntityText.src.com.company.services.accessors.implementations;


import javasummer2017.NewFileEntityText.src.com.company.entities.Visa;
import javasummer2017.NewFileEntityText.src.com.company.services.accessors.VisaAccessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class TextFileVisaAccessor
        extends AbstractTextFileAccessor<Visa>
        implements VisaAccessor {

    //private String _fileName;

    public TextFileVisaAccessor(String fileName) {
        super(fileName);
      //  _fileName = fileName;
    }

    @Override
    protected void saveEntity(PrintStream writer, Visa visa) {
        writer.println(visa.getPassportNumber());
        writer.println(visa.getCountry());
        writer.println(visa.getFrom().getTime().getTime());
        writer.println(visa.getTo().getTime().getTime());
    }

    @Override
    public Collection<Visa> readAll() {
        Collection<Visa> result = new ArrayList<>();
        //try (Scanner scanner = new Scanner(new File(_fileName))) {
        try (Scanner scanner = new Scanner(new File(getFileName()))) {
            while (scanner.hasNextLine()) {
                String passportNumber = scanner.nextLine();
                String country = scanner.nextLine();
                String fromString = scanner.nextLine();
                String toString = scanner.nextLine();
                scanner.nextLine();

                long fromLong = Long.parseLong(fromString);
                long toLong = Long.parseLong(toString);
                Date fromDate = new Date();
                Date toDate = new Date();
                fromDate.setTime(fromLong);
                toDate.setTime(toLong);
                Calendar from = new GregorianCalendar();
                Calendar to = new GregorianCalendar();
                from.setTime(fromDate);
                to.setTime(toDate);


                Visa readVisa = new Visa(passportNumber, country, from, to);
                result.add(readVisa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void startReading() {

    }

    @Override
    public Visa read() {
        return null;
    }

    @Override
    public void stopReading() {

    }
}