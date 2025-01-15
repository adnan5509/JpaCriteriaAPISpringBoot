package com.adnanafzalbajwa.springbootCriteriaApiDemo.dto;

import java.util.Date;

public class getAllEmployeesDashboardDetailsResponse {


    public getAllEmployeesDashboardDetailsResponse() {
    }

    public getAllEmployeesDashboardDetailsResponse(final String employeeName, final int employeeAge, final double salary, final boolean hasValidAccess, final Date joiningDate,
                                                   final double totalSalaryWithdrawn) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.hasValidAccess = hasValidAccess;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.totalSalaryWithdrawn = totalSalaryWithdrawn;
    }

    private String employeeName;
    private int employeeAge;
    private boolean hasValidAccess;
    private double salary;

    private Date joiningDate;
    private double totalSalaryWithdrawn;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(final int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public boolean isHasValidAccess() {
        return hasValidAccess;
    }

    public void setHasValidAccess(final boolean hasValidAccess) {
        this.hasValidAccess = hasValidAccess;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(final Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getTotalSalaryWithdrawn() {
        return totalSalaryWithdrawn;
    }

    public void setTotalSalaryWithdrawn(final double totalSalaryWithdrawn) {
        this.totalSalaryWithdrawn = totalSalaryWithdrawn;
    }
}
