package com.adnanafzalbajwa.springbootCriteriaApiDemo.repository;

import com.adnanafzalbajwa.springbootCriteriaApiDemo.dto.getAllEmployeesDashboardDetailsResponse;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.AccessCard;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.Employee;
import com.adnanafzalbajwa.springbootCriteriaApiDemo.model.PaySlip;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Transactional(readOnly = true)
    public Optional<Employee> findEmployeeById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = cq.from(Employee.class);
        cq.select(employeeRoot)
                .where(cb.equal(employeeRoot.get("id"), id));

        TypedQuery<Employee> query = entityManager.createQuery(cq);
        return Optional.ofNullable(query.getResultList().get(0));
    }

    @Transactional
    public int updateEmployee(int employeeId, Employee employee) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaUpdate<Employee> criteriaUpdate = cb.createCriteriaUpdate(Employee.class);

        Root<Employee> employeeRoot = criteriaUpdate.from(Employee.class);

        criteriaUpdate.set(employeeRoot.get("name"), employee.getName());
        criteriaUpdate.set(employeeRoot.get("age"), employee.getAge());
        criteriaUpdate.set(employeeRoot.get("salary"), employee.getSalary());
        criteriaUpdate.where(cb.equal(employeeRoot.get("id"), employeeId));

        return entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employeeRoot = cq.from(Employee.class);

        Order orderByName = cb.asc(employeeRoot.get("name"));

        TypedQuery<Employee> employeeGetAllQuery = entityManager.createQuery(cq.select(employeeRoot).orderBy(orderByName));
        return employeeGetAllQuery.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeesHavingSalaryMoreThanGivenAmount(final double salary) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employeeRoot = cq.from(Employee.class);

        Predicate salaryPredicate = cb.greaterThan(employeeRoot.get("salary"), salary);
        cq.where(salaryPredicate);

        TypedQuery<Employee> employeesHavingSalaryMoreThanGivenAmountQuery = entityManager.createQuery(cq.select(employeeRoot));
        return employeesHavingSalaryMoreThanGivenAmountQuery.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeesWithAccessDenied() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employeeRoot = cq.from(Employee.class);
        Join<Employee, AccessCard> accessCard = employeeRoot.join("accessCard");


        Predicate isValidAccessPredicate = cb.equal(accessCard.get("isActive"), false);

        cq.where(isValidAccessPredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq.select(employeeRoot));
        return query.getResultList();

    }

    @Transactional(readOnly = true)
    public List<PaySlip> getEmployeePaySlips(final int employeeId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PaySlip> cq = cb.createQuery(PaySlip.class);

        Root<PaySlip> paySlipRoot = cq.from(PaySlip.class);
        Join<PaySlip, Employee> employeeJoin = paySlipRoot.join("employee");

        Predicate employeePredicate = cb.equal(employeeJoin.get("id"), employeeId);
        cq.where(employeePredicate);

        TypedQuery<PaySlip> query = entityManager.createQuery(cq.select(paySlipRoot));
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Double getEmployeeTotalWithdrawnSalary(final int employeeId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);

        Root<PaySlip> paySlipRoot = cq.from(PaySlip.class);

        Join<PaySlip, Employee> employeeJoin = paySlipRoot.join("employee");

        cq.multiselect(cb.sum(paySlipRoot.get("salary")))
                .groupBy(paySlipRoot.get("employee"))
                .having(cb.equal(employeeJoin.get("id"), employeeId));

        TypedQuery<Double> query = entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }

    @Transactional(readOnly = true)
    public List<getAllEmployeesDashboardDetailsResponse> getAllEmployeesDashboardDetails(final int page, final int size) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<getAllEmployeesDashboardDetailsResponse> cq = cb.createQuery(getAllEmployeesDashboardDetailsResponse.class);
//        SELECT e.name,e.salary,a.is_active,a.issue_date, sum(p.salary) FROM EMPLOYEE e
//        JOIN ACCESS_CARD a ON e.id = a.employee_id
//        JOIN payslip p ON e.id = p.payslip_employee
//        GROUP BY  e.name, e.salary, a.is_active, a.issue_date;
        Root<Employee> employeeRoot = cq.from(Employee.class);

        Join<Employee, AccessCard> employeeAccessCardJoin = employeeRoot.join("accessCard");
        Join<Employee, PaySlip> employeePaySlipJoin = employeeRoot.join("paySlips");


        cq.multiselect(
                        employeeRoot.get("name"),
                        employeeRoot.get("age"),
                        employeeRoot.get("salary"),
                        employeeAccessCardJoin.get("isActive"),
                        employeeAccessCardJoin.get("issueDate"),
                        cb.sum(employeePaySlipJoin.get("salary"))
                )
                .groupBy(employeeRoot.get("name"))
                .groupBy(employeeRoot.get("age"))
                .groupBy(employeeRoot.get("salary"))
                .groupBy(employeeAccessCardJoin.get("isActive"))
                .groupBy(employeeAccessCardJoin.get("issueDate"))
                .orderBy(cb.asc(employeeRoot.get("name")));

        TypedQuery<getAllEmployeesDashboardDetailsResponse> query = entityManager.createQuery(cq);
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        return query.getResultList();


    }
}
