package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
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

    private final BondService bondService;

    @Autowired
    public BondController(final BondService bondService) {
        this.bondService = bondService;
    }

    @GetMapping
    public List<Bond> getAllBonds() {
        return bondService.getAllActiveBonds();
    }

    @GetMapping("/{isin}")
    public ResponseEntity<?> getBondByIsin(@PathVariable String isin) {
        Optional<Bond> bond = bondService.findByIsin(isin);
        if (bond.isPresent()){
            return ResponseEntity.ok(bond);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bond with ISIN " + isin + " not found");
    }

    @GetMapping("/maturity")
    public ResponseEntity<List<Bond>> getBondsDueForMaturityInLastAndNextFiveDays() {
        List<Bond> bonds = bondService.findBondsDueForMaturityInLastAndNextFiveDays();
        if (bonds.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(bonds);
        }
    }

    @GetMapping("/issuers")
    public ResponseEntity<Map<String, String>> getBondIsinIssuerMap() {
        Map<String, String> bondIsinIssuerMap = bondService.getBondIsinIssuerMap();

        if (!bondIsinIssuerMap.isEmpty()) {
            return ResponseEntity.ok(bondIsinIssuerMap);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
