package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BondServiceImpl implements BondService{
    private final BondRepository bondRepository;

    @Autowired
    public BondServiceImpl(final BondRepository bondRepository) {
        this.bondRepository = bondRepository;
    }

    @Override
    public List<Bond> getAllActiveBonds() {

        return bondRepository.findAll();
    }

    @Override
    public List<Bond> findBondsDueForMaturityInLastAndNextFiveDays() {
        final java.util.Date date = new java.util.Date();
        final Date currentDate = new Date(date.getTime());
        final Date lastFiveDays = new Date(currentDate.getTime() - 5 * 24 * 60 * 60 * 1000); // 5 days ago
        final Date nextFiveDays = new Date(currentDate.getTime() + 5 * 24 * 60 * 60 * 1000); // 5 days from now
        return bondRepository.findByBondMaturityDateBetween(lastFiveDays, nextFiveDays);
    }

    @Override
    public List<Bond> findBondsDueForMaturityInLastAndNextFiveWorkDaysByDate(String givenDate) {
        final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(System.currentTimeMillis());

        try {
            java.util.Date utilDate = inputDateFormat.parse(givenDate);
            currentDate = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        List<Bond> bonds = new ArrayList<>();

        // Find previous five working days
        for (int i = 0; i < 5; i++) {
            do {
                calendar.add(Calendar.DAY_OF_WEEK, -1);
            } while (!isWorkingDay(calendar)); // Skip weekends
        }
        final Date lastFiveDays = new Date(calendar.getTimeInMillis());

        calendar.setTime(currentDate);

        // Find next five working days
        for (int i = 0; i < 5; i++) {
            do {
                calendar.add(Calendar.DAY_OF_WEEK, 1);
            } while (!isWorkingDay(calendar)); // Skip weekends
        }
        final Date nextFiveDays = new Date(calendar.getTimeInMillis());

        return bondRepository.findByBondMaturityDateBetween(lastFiveDays, nextFiveDays);
    }

    private boolean isWorkingDay(final Calendar calendar) {
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
    }


    @Override
    public List<Bond> findBondsDueForMaturityInLastAndNextFiveDaysByDate(final String givenDate) {
        final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = inputDateFormat.parse(givenDate);
            Date currentDate = new Date(utilDate.getTime());
            Date lastFiveDays = new Date(currentDate.getTime() - 5 * 24 * 60 * 60 * 1000); // 5 days ago
            Date nextFiveDays = new Date(currentDate.getTime() + 5 * 24 * 60 * 60 * 1000); // 5 days from now
            return bondRepository.findByBondMaturityDateBetween(lastFiveDays, nextFiveDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Optional<Bond> findByIsin(final String isin) {
        return bondRepository.findByIsin(isin);
    }

    @Override
    public Map<String, String> getBondIsinIssuerMap() {
        final List<Bond> bonds = bondRepository.findAll();
        return bonds.stream().collect(Collectors.toMap(Bond::getIsin, Bond::getIssuerName));
    }
}
