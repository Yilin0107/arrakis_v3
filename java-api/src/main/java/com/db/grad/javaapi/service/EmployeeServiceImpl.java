package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.EmployeeRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BondRepository bondRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository, BondRepository bondRepository, TradeRepository tradeRepository) {
        this.employeeRepository = employeeRepository;
        this.bondRepository = bondRepository;
    }

    public void initializeEmployeesPasswordHash() {
        final List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees) {
            employee.setEmployeePasswordHash("defaultPassword"+employee.getEmployeeName());
            employeeRepository.save(employee);
        }
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Bond> getBondsByEmployeeId(int employeeId) {
        return bondRepository.findByEmployee_EmployeeId(employeeId);
    }

    @Override
    public Employee findByEmployeeEmail(String email) {
        return employeeRepository.findByEmployeeEmail(email);
    }

    @Override
    public Map<String, List<Bond>> findBondsByEmployeeIdGroupedByBook(int employeeId) {
        final Map<String, List<Bond>> result = new HashMap<>();

        final Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            for (Bond bond : employee.getBonds()) {
                for (Trade trade : bond.getTrades()) {
                    String bookName = trade.getBookName();

                    result.putIfAbsent(bookName, new ArrayList<>());
                    result.get(bookName).add(bond);
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> findBooksByEmployeeId(int employeeId) {
        final Set<String> result = new HashSet<>();

        final Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            for (final Bond bond : employee.getBonds()) {
                for (Trade trade : bond.getTrades()) {
                    result.add(trade.getBookName());
                }
            }
        }
        return result;
    }
}
