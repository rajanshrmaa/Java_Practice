package com;

import java.sql.*;
import java.util.Collection;

public class EmployeeCRUD {
    
    // MySQL connection details
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "Password@123";

    // Establishing connection with the database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Create - Insert new employee
    public static void createEmployee(String name, String department, double salary) throws SQLException {
        String query = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        }
    }

    // Read - Retrieve employee data
    public static void readEmployees() throws SQLException {
        String query = "SELECT * FROM employee";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                System.out.println(id + " | " + name + " | " + department + " | " + salary);
            }
        }
    }

    // Update - Modify employee data
    public static void updateEmployee(int id, String name, String department, double salary) throws SQLException {
        String query = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        try (Collection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Employee updated successfully!");
        }
    }

    // Delete - Remove employee from the table
    public static void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully!");
        }
    }

    public static void main(String[] args) {
        try {
            // Example operations
            createEmployee("John Doe", "Engineering", 75000);
            createEmployee("Jane Smith", "HR", 55000);
            
            System.out.println("Employee List:");
            readEmployees();
            
            updateEmployee(1, "John Doe", "Engineering", 80000);
            
            System.out.println("Updated Employee List:");
            readEmployees();
            
            deleteEmployee(2);
            
            System.out.println("Final Employee List:");
            readEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
