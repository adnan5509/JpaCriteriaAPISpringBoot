package com.adnanafzalbajwa.springbootCriteriaApiDemo.controller;

import com.adnanafzalbajwa.springbootCriteriaApiDemo.dto.SalaryGreaterEmployeesRequest;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.dto.getAllEmployeesDashboardDetailsResponse;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.Employee;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.PaySlip;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        Optional<Employee> fetchedEmployee = employeeService.getEmployee(id);
        if (fetchedEmployee.isPresent()) {
            return ResponseEntity.ok(fetchedEmployee.get());
        } else {
            return (ResponseEntity<Employee>) ResponseEntity.notFound();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        employeeService.updateEmployee(id, employeeDetails);
        Optional<Employee> employee = employeeService.getEmployee(id);
        return ResponseEntity.ok(employee.get());
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> fetchedEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(fetchedEmployees);

    }

    @GetMapping("/salaryGreater")
    public ResponseEntity<List<Employee>> getEmployeesHavingSalaryMoreThanGivenAmount(@RequestBody SalaryGreaterEmployeesRequest request) {
        List<Employee> employeesHavingSalaryMoreThanGivenAmount = employeeService.getEmployeesHavingSalaryMoreThanGivenAmount(request.getSalary());
        return ResponseEntity.ok(employeesHavingSalaryMoreThanGivenAmount);
    }

    @GetMapping("/employeesAccessDenied")
    public ResponseEntity<List<Employee>> getEmployeesWithAccessDenied() {
        List<Employee> employeesWithAccessDenied = employeeService.getEmployeesWithAccessDenied();
        return ResponseEntity.ok(employeesWithAccessDenied);
    }

    @GetMapping("/payslips/{employeeId}")
    public ResponseEntity<List<PaySlip>> getEmployeePaySlips(@PathVariable int employeeId) {
        List<PaySlip> employeePaySlips = employeeService.getEmployeePaySlips(employeeId);
        return ResponseEntity.ok(employeePaySlips);
    }

    @GetMapping("/payslips/sum/{employeeId}")
    public ResponseEntity<Double> getEmployeeTotalWithdrawnSalary(@PathVariable int employeeId) {
        Double employeeTotalWithdrawnSalary = employeeService.getEmployeeTotalWithdrawnSalary(employeeId);
        return ResponseEntity.ok(employeeTotalWithdrawnSalary);
    }

    @GetMapping("/allEmployeeDetails")
    public ResponseEntity<List<getAllEmployeesDashboardDetailsResponse>> getAllEmployeesDashboardDetails
            (@RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        List<getAllEmployeesDashboardDetailsResponse> fetchedEmployeesDetails = employeeService.getAllEmployeesDashboardDetails(page, size);
        return ResponseEntity.ok(fetchedEmployeesDetails);

    }

}
