package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BondServiceImplTest {

    @Mock
    private BondRepository bondRepository;

    @InjectMocks
    private BondServiceImpl bondService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private Bond createBond(String isin, String issuerName, Date bondMaturityDate) {
        Bond bond = new Bond();
        bond.setIsin(isin);
        bond.setIssuerName(issuerName);
        bond.setBondMaturityDate(bondMaturityDate);
        // Set other fields if needed
        return bond;
    }

    @Test
    public void testGetAllActiveBonds() {
        List<Bond> bonds = new ArrayList<>();
        bonds.add(createBond("ISIN1", "Issuer1", Date.valueOf("2023-08-04")));
        bonds.add(createBond("ISIN2", "Issuer2", Date.valueOf("2023-08-10")));

        when(bondRepository.findAll()).thenReturn(bonds);

        List<Bond> result = bondService.getAllActiveBonds();

        assertEquals(2, result.size());
        assertEquals("ISIN1", result.get(0).getIsin());
        assertEquals("Issuer1", result.get(0).getIssuerName());
        assertEquals(Date.valueOf("2023-08-04"), result.get(0).getBondMaturityDate());
    }

    @Test
    public void testFindBondsDueForMaturityInLastAndNextFiveDays() {
        List<Bond> bonds = new ArrayList<>();
        bonds.add(createBond("ISIN1", "Issuer1", Date.valueOf("2023-08-04")));
        bonds.add(createBond("ISIN2", "Issuer2", Date.valueOf("2023-08-10")));

        when(bondRepository.findByBondMaturityDateBetween(any(Date.class), any(Date.class))).thenReturn(bonds);

        List<Bond> result = bondService.findBondsDueForMaturityInLastAndNextFiveDays();

        assertEquals(2, result.size());
        assertEquals("ISIN1", result.get(0).getIsin());
        assertEquals("Issuer1", result.get(0).getIssuerName());
        assertEquals(Date.valueOf("2023-08-04"), result.get(0).getBondMaturityDate());
    }

    @Test
    public void testFindBondsDueForMaturityInLastAndNextFiveDaysByDate() throws ParseException {
        String givenDate = "2023-08-05";
        List<Bond> bonds = new ArrayList<>();
        bonds.add(createBond("ISIN1", "Issuer1", Date.valueOf("2023-08-04")));
        bonds.add(createBond("ISIN2", "Issuer2", Date.valueOf("2023-08-10")));

        when(bondRepository.findByBondMaturityDateBetween(any(Date.class), any(Date.class))).thenReturn(bonds);

        List<Bond> result = bondService.findBondsDueForMaturityInLastAndNextFiveDaysByDate(givenDate);

        assertEquals(2, result.size());
        assertEquals("ISIN1", result.get(0).getIsin());
        assertEquals("Issuer1", result.get(0).getIssuerName());
        assertEquals(Date.valueOf("2023-08-04"), result.get(0).getBondMaturityDate());
    }

    @Test
    public void testFindByIsin() {
        Bond bond = createBond("ISIN1", "Issuer1", Date.valueOf("2023-08-04"));

        when(bondRepository.findByIsin("ISIN1")).thenReturn(Optional.of(bond));

        Optional<Bond> result = bondService.findByIsin("ISIN1");

        assertEquals(true, result.isPresent());
        assertEquals("ISIN1", result.get().getIsin());
        assertEquals("Issuer1", result.get().getIssuerName());
        assertEquals(Date.valueOf("2023-08-04"), result.get().getBondMaturityDate());
    }

    @Test
    public void testGetBondIsinIssuerMap() {
        List<Bond> bonds = new ArrayList<>();
        bonds.add(createBond("ISIN1", "Issuer1", Date.valueOf("2023-08-04")));
        bonds.add(createBond("ISIN2", "Issuer2", Date.valueOf("2023-08-10")));

        when(bondRepository.findAll()).thenReturn(bonds);

        Map<String, String> result = bondService.getBondIsinIssuerMap();

        assertEquals(2, result.size());
        assertEquals("Issuer1", result.get("ISIN1"));
        assertEquals("Issuer2", result.get("ISIN2"));
    }
}