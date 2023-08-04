package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/bonds")
public class BondController {

    private final BondServiceImpl bondServiceImpl;

    @Autowired
    public BondController(final BondServiceImpl bondServiceImpl) {
        this.bondServiceImpl = bondServiceImpl;
    }

    @GetMapping
    public List<Bond> getAllBonds() {
        return bondServiceImpl.getAllActiveBonds();
    }

    @GetMapping("/{isin}")
    public ResponseEntity<?> getBondByIsin(@PathVariable String isin) {
        Optional<Bond> bond = bondServiceImpl.findByIsin(isin);
        if (bond.isPresent()){
            return ResponseEntity.ok(bond);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bond with ISIN " + isin + " not found");
    }

    @GetMapping("/maturity")
    public ResponseEntity<List<Bond>> getBondsDueForMaturityInLastAndNextFiveDays() {
        List<Bond> bonds = bondServiceImpl.findBondsDueForMaturityInLastAndNextFiveDays();
        if (bonds.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(bonds);
        }
    }

    @PostMapping("/maturity/date")
    public ResponseEntity<List<Bond>> getBondsDueForMaturityInLastAndNextFiveDaysByDate(@RequestParam String dateStr) {
        List<Bond> bonds = bondServiceImpl.findBondsDueForMaturityInLastAndNextFiveDaysByDate(dateStr);
        if (bonds.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(bonds);
        }
    }

    @PostMapping("/maturity/workday/date")
    public ResponseEntity<List<Bond>> getBondsDueForMaturityInLastAndNextFiveWorkDaysByDate(@RequestParam String dateStr) {
        List<Bond> bonds = bondServiceImpl.findBondsDueForMaturityInLastAndNextFiveWorkDaysByDate(dateStr);
        if (bonds.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(bonds);
        }
    }

    @GetMapping("/issuers")
    public ResponseEntity<Map<String, String>> getBondIsinIssuerMap() {
        Map<String, String> bondIsinIssuerMap = bondServiceImpl.getBondIsinIssuerMap();

        if (!bondIsinIssuerMap.isEmpty()) {
            return ResponseEntity.ok(bondIsinIssuerMap);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
