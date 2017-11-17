package com.company.services;


import com.company.entities.Passport;

import java.util.Collection;

public interface PassportService {
    Collection<Passport> readAll();
    Collection<Passport> save(Collection<Passport> passports);

}
