package com.adnanafzalbajwa.springbootCriteriaApiDemo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date issueDate;
    private boolean isActive;
    private String firmwareVersion;
    @OneToOne
    @JsonIgnore
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(final Date issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(final boolean active) {
        isActive = active;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    public void setFirmwareVersion(final String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
}
