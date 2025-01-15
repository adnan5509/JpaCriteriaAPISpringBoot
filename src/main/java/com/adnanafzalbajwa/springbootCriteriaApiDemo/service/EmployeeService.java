package com.adnanafzalbajwa.springbootCriteriaApiDemo.service;

import com.adnanafzalbajwa.springbootCriteriaApiDemo.dto.getAllEmployeesDashboardDetailsResponse;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.Employee;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.PaySlip;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void createEmployee(final Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    public Optional<Employee> getEmployee(final int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Transactional
    public int updateEmployee(final int id, final Employee employeeDetails) {
        return employeeRepository.updateEmployee(id, employeeDetails);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public List<Employee> getEmployeesHavingSalaryMoreThanGivenAmount(final double salary) {
        return employeeRepository.getEmployeesHavingSalaryMoreThanGivenAmount(salary);
    }

    public List<Employee> getEmployeesWithAccessDenied() {
        return employeeRepository.getEmployeesWithAccessDenied();
    }

    public List<PaySlip> getEmployeePaySlips(final int employeeId) {
        return employeeRepository.getEmployeePaySlips(employeeId);
    }

    public Double getEmployeeTotalWithdrawnSalary(final int employeeId) {
        return employeeRepository.getEmployeeTotalWithdrawnSalary(employeeId);
    }

    public List<getAllEmployeesDashboardDetailsResponse> getAllEmployeesDashboardDetails(final int page, final int size) {
        return employeeRepository.getAllEmployeesDashboardDetails(page, size);
    }
}
