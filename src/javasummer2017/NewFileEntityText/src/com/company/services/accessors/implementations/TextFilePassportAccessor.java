package javasummer2017.NewFileEntityText.src.com.company.services.accessors.implementations;

import javasummer2017.NewFileEntityText.src.com.company.entities.Passport;
import javasummer2017.NewFileEntityText.src.com.company.services.accessors.PassportAccessor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class TextFilePassportAccessor
        extends AbstractTextFileAccessor<Passport>
        implements PassportAccessor {


    public TextFilePassportAccessor(String fileName) {
        super(fileName);
    }

    protected void saveEntity(PrintStream writer, Passport passport) {
        writer.println(passport.getNumber());
        writer.println(passport.getName());
        writer.println(passport.getLastName());
    }

    @Override
    public Collection<Passport> readAll() {
        Collection<Passport> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(getFileName()))) {
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                scanner.nextLine();
                Passport readPassport = new Passport(firstName, lastName, number);
                result.add(readPassport);
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
    public Passport read() {
        return null;
    }

    @Override
    public void stopReading() {

    }
}