package com.example.demomidtermtest;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date hireDate;
    private String jobCode;
    private int salary;

    public Employee(int employeeId, String firstName, String lastName, String phoneNumber, Date hireDate, String jobCode){
        setEmployeeId(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setHireDate(hireDate);
        setJobCode(jobCode);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId < 0) {
            throw new IllegalArgumentException("The employeeId must be a non-negative integer.");
        }
        this.employeeId = employeeId; // Assign if valid
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() > 1) {

            this.firstName = firstName;
        }
        else{
            throw new IllegalArgumentException("length of first name must be greater than one");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() > 1) {
            this.lastName = lastName;
        }
        else{
            throw new IllegalArgumentException("Length Must be longer than 1 character");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;

    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^\\d{3}\\.\\d{3}\\.\\d{4}$")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must be in the format XXX.XXX.XXXX");
        }
    }

    public Date getHireDate() {
        return hireDate;
    }
    private final Date today = new Date();
    public void setHireDate(Date hireDate) {
        
        if(hireDate.before(today)) {
            this.hireDate = hireDate;
        }
        else{
            throw new IllegalArgumentException("Date must be before present");
        }
    }


    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {


        if (jobCode.toUpperCase().equals(jobCode) && jobCode.contains("_") && jobCode.indexOf('_') == jobCode.lastIndexOf('_')) {
           this.jobCode = jobCode;
        }
        else {
            throw new IllegalArgumentException("Must be all capitals and contain one underscore");
        }
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    //extra


}
