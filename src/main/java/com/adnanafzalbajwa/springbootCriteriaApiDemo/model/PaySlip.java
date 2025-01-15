package com.adnanafzalbajwa.springbootCriteriaApiDemo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PAYSLIP")
public class PaySlip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date periodStartDate;
    private Date periodEndDate;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "payslip_employee")
    @JsonIgnore
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Date getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(final Date periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public Date getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(final Date periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PaySlip{" +
                "id=" + id +
                ", periodStartDate=" + periodStartDate +
                ", periodEndDate=" + periodEndDate +
                ", salary=" + salary +
                ", employee=" + employee +
                '}';
    }
}
