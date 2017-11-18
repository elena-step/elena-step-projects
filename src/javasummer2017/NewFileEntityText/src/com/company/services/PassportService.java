package javasummer2017.NewFileEntityText.src.com.company.services;

import javasummer2017.NewFileEntityText.src.com.company.entities.Passport;

import java.util.Collection;

public interface PassportService {
    Collection<Passport> readAll();

    Collection<Passport> save(Collection<Passport> passports);

}