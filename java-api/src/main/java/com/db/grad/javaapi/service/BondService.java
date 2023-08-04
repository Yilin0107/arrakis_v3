package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BondService {

    List<Bond> getAllActiveBonds();

    List<Bond> findBondsDueForMaturityInLastAndNextFiveDays();

    List<Bond> findBondsDueForMaturityInLastAndNextFiveDaysByDate(String givenDate);

    List<Bond> findBondsDueForMaturityInLastAndNextFiveWorkDaysByDate(String givenDate);

    Optional<Bond> findByIsin(String isin);

    Map<String, String> getBondIsinIssuerMap();
}
