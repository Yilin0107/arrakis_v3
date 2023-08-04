package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.EmployeeRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BondRepository bondRepository;
    private final TradeRepository tradeRepository;

    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepository, BondRepository bondRepository, TradeRepository tradeRepository) {
        this.employeeRepository = employeeRepository;
        this.bondRepository = bondRepository;
        this.tradeRepository = tradeRepository;
    }

    public void initializeEmployeesPasswordHash() {
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees) {
            employee.setEmployeePasswordHash("defaultPassword"+employee.getEmployeeName());
            employeeRepository.save(employee);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Bond> getBondsByEmployeeId(int employeeId) {
        return bondRepository.findByEmployee_EmployeeId(employeeId);
    }

    public Employee findByEmployeeEmail(String email) {
        return employeeRepository.findByEmployeeEmail(email);
    }
}
