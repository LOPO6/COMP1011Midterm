package com.example.demomidtermtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;
import java.util.Properties;

public class DBUtility {
    private static String user;
    private static String password;
    private static String connectURL="jdbc:mysql://sql5.freesqldatabase.com:3306/sql5736297";;

    /*
    *To Do: Update this method to get all or filtered Employees from the database
    * */
    public static ArrayList<Employee> getEmployees(String... sqls) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        //query from the database
        String sql= "SELECT * FROM sql5736297.employee;";
        if (sqls.length>0) sql=sqls[0];
        try (
                Connection connection =DriverManager.getConnection(connectURL,user,password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ){
            while(resultSet.next())
            {
                int employeeID = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                Date hireDate = resultSet.getDate("hireDate");
                String jobCode= resultSet.getString("jobCode");

                Employee employee = new Employee(employeeID,firstName,lastName,phoneNumber,hireDate,jobCode);
                employees.add(employee);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return employees;
    }

    /*
     *To Do: Update this method to get the area codes for the combo Box list
     * */
    public static ArrayList<String> getAreaCodes()
    {
        String sql2 = "SELECT SUBSTRING(phoneNumber, 1, 3) AS area_code FROM employee WHERE phoneNumber LIKE '___.___.____'";
        ArrayList<String> areaCodes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectURL,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql2)) {
            while (rs.next()) {
                areaCodes.add(rs.getString("area_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  areaCodes;
    }

    /*
     *To Do: Update this method to get the area codes for the combo Box list
     * */
    public static ArrayList<Employee> filterEmployees(boolean isSenior, boolean isIT, String areaCode ) throws SQLException {
        String sql = "SELECT * FROM employee WHERE 1=1 "; // Base query
        if (isSenior) {
            sql += " AND jobCode LIKE '%Senior%'"; // Filter by Senior
        }
        if (isIT) {
            sql += " AND jobCode LIKE '%IT%'"; // Filter by IT
        }
        if (areaCode != null && !areaCode.isEmpty()) {
            sql += " AND phoneNumber LIKE '" + areaCode + "-%'"; // Filter by area code
        }
        return getEmployees("sql");
    }

    static void getCredentials() {
        try {
            String configFilePath = "src/main/resources/config.properties"; // Path to your properties file
            FileInputStream propsInput = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(propsInput);
            user = prop.getProperty("DB_USER");
            password = prop.getProperty("DB_PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
