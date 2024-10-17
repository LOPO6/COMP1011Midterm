package com.example.demomidtermtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class EmployeeTableViewController implements Initializable {

    @FXML
    private CheckBox checkIT;

    @FXML
    private CheckBox checkSenior;

    @FXML
    private TableColumn<Employee, Integer> colEmployeeId;

    @FXML
    private TableColumn<Employee, String> colFirstName;

    @FXML
    private TableColumn<Employee, Date> colHireDate;

    @FXML
    private TableColumn<Employee, String> colJobCode;

    @FXML
    private TableColumn<Employee, String> colLastName;

    @FXML
    private TableColumn<Employee, String> colPhoneNumber;

    @FXML
    private ComboBox<String> combAreaCode;

    @FXML
    private Label lableTotal;

    @FXML
    private TableView<Employee> tableEmployees;
    /*
    * When start the window,show all employees and initial the combobox list
    * */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colHireDate.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colJobCode.setCellValueFactory(new PropertyValueFactory<>("jobCode"));

        DBUtility.getCredentials();
        ArrayList<Employee> employees = null;
        try {
            employees = DBUtility.getEmployees();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableEmployees.getItems().addAll(employees);



    }


    /*
    * Update this method to update the Tableview control
    * */
    @FXML
    public void updateTableView (ActionEvent event) throws SQLException
    {
        boolean isSenior = checkSenior.isSelected();
        boolean isIT = checkIT.isSelected();
        String areaCode = combAreaCode.getSelectionModel().getSelectedItem();
        ArrayList<Employee> filteredEmployees = DBUtility.filterEmployees(isSenior, isIT, areaCode);
        // Update the ListView with the filteredEmployees
        tableEmployees.getItems().clear(); // Clear existing items
        tableEmployees.getItems().addAll(filteredEmployees);

        lableTotal.setText(" "+filteredEmployees.size());


    }
}