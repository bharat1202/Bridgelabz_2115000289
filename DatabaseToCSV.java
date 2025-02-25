import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/company_db"; // Update your database URL
        String dbUser = "root"; // Update your username
        String dbPassword = "password"; // Update your password
        String csvFile = "employees_report.csv";

        exportEmployeesToCSV(jdbcURL, dbUser, dbPassword, csvFile);
    }

    public static void exportEmployeesToCSV(String jdbcURL, String dbUser, String dbPassword, String csvFile) {
        String query = "SELECT id, name, department, salary FROM employees"; // Change table name if needed

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            // Write CSV header
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Write data rows
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
