package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BondService {

    @Autowired
    private BondRepository bondRepository;

    public List<Bond> getAllActiveBonds() {
        return bondRepository.findAll();
    }

    // TODO: check the dateformat in database and implement

    public List<Bond> findBondsDueForMaturityInLastAndNextFiveDays() {
        java.util.Date date = new java.util.Date();
        Date currentDate = new Date(date.getTime());
        // for testing purpose
//        String dateString = "2021-08-05";
//        Date currentDate = Date.valueOf(dateString);

        Date lastFiveDays = new Date(currentDate.getTime() - 5 * 24 * 60 * 60 * 1000); // 5 days ago
        Date nextFiveDays = new Date(currentDate.getTime() + 5 * 24 * 60 * 60 * 1000); // 5 days from now
        return bondRepository.findByBondMaturityDateBetween(lastFiveDays, nextFiveDays);
    }

    public Optional<Bond> findByIsin(String isin) {
        return bondRepository.findByIsin(isin);
    }


    public Map<String, String> getBondIsinIssuerMap() {
        List<Bond> bonds = bondRepository.findAll();
        return bonds.stream().collect(Collectors.toMap(Bond::getIsin, Bond::getIssuer_name));
    }
}
