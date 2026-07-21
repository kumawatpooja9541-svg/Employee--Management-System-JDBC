import java.sql.*;

public class EmployeeDAO {

    // Add Employee
    public void addEmployee(Employee employee) {

        try
            (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee VALUES(?,?,?)"
            );
       ) {
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
        }

    }

    // View Employee
    public void viewEmployee() {

        try
                ( Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM employee");
                  ResultSet rs = ps.executeQuery();

                ) {
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
        }
    }

    // Update Employee
    public void updateEmployee(Employee employee) {

        try(
                Connection  con = DatabaseConnection.getConnection();
                PreparedStatement  ps = con.prepareStatement(
                    "UPDATE employee SET name=?,salary=? WHERE id=?"
            );
       ){
            ps.setString(1, employee.getName());
            ps.setDouble(2, employee.getSalary());
            ps.setInt(3, employee.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Updated Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }
        } catch (SQLException e) {

            System.out.println("Database operation failed!");
            System.out.println(e.getMessage());
        }

    }

    // Delete Employee
    public void deleteEmployee(int id) {

        try
            (Connection con = DatabaseConnection.getConnection();
            PreparedStatement  ps = con.prepareStatement(
                    "DELETE FROM employee WHERE id=?"
            );
            )
        {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Deleted Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
        }
    }

    public void searchEmployee(int id) {



        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM employee where id=?");

        )
        {

            ps.setInt(1, id);
try( ResultSet rs = ps.executeQuery();) {
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
}
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            System.out.println(e.getMessage());
        }


    }


}










