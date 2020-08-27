package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Child extends Person{
    private String sertificateNumber;
    private LocalDate issueDate;
    private String issueDepartment;

    public String getSertificateNumber() {
        return sertificateNumber;
    }

    public void setSertificateNumber(String sertificateNumber) {
        this.sertificateNumber = sertificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
