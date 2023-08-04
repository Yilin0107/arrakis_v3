package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.EmployeeRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BondRepository bondRepository;
    private final TradeRepository tradeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository, BondRepository bondRepository, TradeRepository tradeRepository) {
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
}
