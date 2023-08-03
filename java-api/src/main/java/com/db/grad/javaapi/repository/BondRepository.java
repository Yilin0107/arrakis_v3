package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BondRepository extends JpaRepository<Bond, String> {

    Optional<Bond> findByIsin(String isin);

    @Query("SELECT b FROM Bond b WHERE b.bond_maturity_date >= ?1 AND b.bond_maturity_date <= ?2")
    List<Bond> findByBondMaturityDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT b.cusip FROM Bond b WHERE b.isin = :isin")
    String findCUSIPByISIN(@Param("isin") String isin);

    @Query("SELECT b.issuer_name FROM Bond b WHERE b.isin = :isin")
    String findIssuerByISIN(@Param("isin") String isin);

    @Query("SELECT t.bondHolder FROM Trade t WHERE t.isin = :isin")
    List<String> findDistinctBondHoldersByISIN(@Param("isin") String isin);

    @Query("SELECT b FROM Bond b WHERE b.employee.employee_id = :employeeId")
    List<Bond> findByEmployee_EmployeeId(int employeeId);

}