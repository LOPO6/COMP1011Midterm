package com.example.demomidtermtest;

import java.util.ArrayList;
import java.sql.*;

public class DBUtility {
    private static String user="student";
    private static String password="student";
    private static String connectionURL="jdbc:mysql://localhost:3306/javatest";

    /*
    *To Do: Update this method to get all or filtered Employees from the database
    * */
    public static ArrayList<Employee> getEmployees(String... sql) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();

        return employees;
    }

    /*
     *To Do: Update this method to get the area codes for the combo Box list
     * */
    public static ArrayList<String> getAreaCodes()
    {
        ArrayList<String> areaCodes = new ArrayList<>();
        return  areaCodes;
    }

    /*
     *To Do: Update this method to get the area codes for the combo Box list
     * */
    public static ArrayList<Employee> filterEmployees(boolean isSenior, boolean isIT, String areaCode ) throws SQLException {

        return getEmployees("sql");
    }

}
