import java.sql.*;

public class EmployeeDAO {

    // Add Employee
    public void addEmployee(Employee employee) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(
                    "INSERT INTO employee VALUES(?,?,?)"
            );

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setDouble(3, employee.getSalary());


            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee Added Successfully!");
            } else {
                System.out.println("Employee Not Added!");
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                System.out.println("Error while closing resources.");
            }
        }

    }

    // View Employee
    public void viewEmployee() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {


            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(
                    "SELECT * FROM employee"
            );
            rs = ps.executeQuery();
            System.out.println("----------------------------------------");
            System.out.printf("%-8s %-15s %s%n", "ID", "NAME", "SALARY");
            System.out.println("----------------------------------------");


            while (rs.next()) {

                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                );

                System.out.printf("%-8d %-15s %.2f%n",
                        emp.getId(),
                        emp.getName(),
                        emp.getSalary());
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed!");
        } finally {
            try {
                if (

                        rs != null)
                    rs.close();

                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                System.out.println("Error while closing resources.");

            }
        }
    }

    // Update Employee
    public void updateEmployee(Employee employee) {
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(
                    "UPDATE employee SET salary=? WHERE id=?"
            );

            ps.setDouble(1, employee.getSalary());
            ps.setInt(2, employee.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Updated Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }
        } catch (SQLException e) {

            System.out.println("Database operation failed!");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();

            } catch (Exception es) {
                System.out.println("Database operation failed!");
            }
        }

    }

    // Delete Employee
    public void deleteEmployee(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(
                    "DELETE FROM employee WHERE id=?"
            );

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Deleted Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
        } finally {
            try {
                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();
            } catch (SQLException ex) {

                System.out.println("Error while closing resources.");
            }

        }
    }

    public void searchEmployee(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(
                    "SELECT * FROM employee WHERE id=?"
            );

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                );

                System.out.println("ID : " + emp.getId());
                System.out.println("Name : " + emp.getName());
                System.out.println("Salary : " + emp.getSalary());

            } else {
                System.out.println("Employee Not Found!");
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null)
                    ps.close();

                if (con != null)
                    con.close();

                if (rs != null)
                    rs.close();

            } catch (SQLException ex) {

                System.out.println("Error while closing resources.");
            }


        }


    }


}










