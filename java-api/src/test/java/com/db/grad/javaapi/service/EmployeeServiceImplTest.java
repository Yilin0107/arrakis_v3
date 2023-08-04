package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private BondRepository bondRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitializeEmployeesPasswordHash() {
        List<Employee> employees = new ArrayList<>();
        employees.add(createEmployee(1, "Murtaza", "Wani", "murtaza.wani@example.com", "HR", "Employee"));
        employees.add(createEmployee(2, "Mahreen", "Chaiwalaa", "mahreen.chaiwalaa@example.com", "Finance", "Manager"));

        when(employeeRepository.findAll()).thenReturn(employees);

        employeeService.initializeEmployeesPasswordHash();

        verify(employeeRepository, times(2)).save(any(Employee.class));
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(createEmployee(1, "Murtaza", "Wani", "murtaza.wani@example.com", "HR", "Employee"));
        employees.add(createEmployee(2, "Mahreen", "Chaiwalaa", "mahreen.chaiwalaa@example.com", "Finance", "Manager"));

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("Murtaza", result.get(0).getEmployeeName());
        assertEquals("mahreen.chaiwalaa@example.com", result.get(1).getEmployeeEmail());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = createEmployee(2, "Mahreen", "Chaiwalaa", "mahreen.chaiwalaa@example.com", "Finance", "Manager");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.getEmployeeById(1);

        assertEquals(true, result.isPresent());
        assertEquals("Mahreen", result.get().getEmployeeName());
        assertEquals("mahreen.chaiwalaa@example.com", result.get().getEmployeeEmail());
    }

    @Test
    public void testGetBondsByEmployeeId() {
        List<Bond> bonds = new ArrayList<>();
        bonds.add(createBond("ISIN1", "Issuer1"));
        bonds.add(createBond("ISIN2", "Issuer2"));

        when(bondRepository.findByEmployee_EmployeeId(1)).thenReturn(bonds);

        List<Bond> result = employeeService.getBondsByEmployeeId(1);

        assertEquals(2, result.size());
        assertEquals("ISIN1", result.get(0).getIsin());
        assertEquals("Issuer2", result.get(1).getIssuerName());
    }

    @Test
    public void testFindByEmployeeEmail() {
        Employee employee = createEmployee(2, "Mahreen", "Chaiwalaa", "mahreen.chaiwalaa@example.com", "Finance", "Manager");

        when(employeeRepository.findByEmployeeEmail("mahreen.chaiwalaa@example.com")).thenReturn(employee);

        Employee result = employeeService.findByEmployeeEmail("mahreen.chaiwalaa@example.com");

        assertEquals("Mahreen", result.getEmployeeName());
        assertEquals("Finance", result.getEmployeeDepartment());
    }

    private Employee createEmployee(int id, String name, String surname, String email, String department, String role) {
        Employee employee = new Employee();
        employee.setEmployee_id(id);
        employee.setEmployeeName(name);
        employee.setEmployeeSurname(surname);
        employee.setEmployeeEmail(email);
        employee.setEmployeeDepartment(department);
        employee.setEmployeeRole(role);
        return employee;
    }

    private Bond createBond(String isin, String issuerName) {
        Bond bond = new Bond();
        bond.setIsin(isin);
        bond.setIssuerName(issuerName);
        return bond;
    }
}
