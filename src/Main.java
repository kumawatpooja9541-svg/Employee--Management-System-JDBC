
import java.sql.SQLException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary : ");
                    double salary = sc.nextDouble();
                    Employee emp = new Employee(id, name, salary);
                    try {
                        service.addEmployee(emp);
                    } catch (InvalidEmployeeException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    service.viewEmployee();
                    break;
                case 3:

                    System.out.print("Enter Employee ID : ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name : ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Salary : ");
                    double newSalary = sc.nextDouble();

                    Employee updateEmp = new Employee(updateId, newName, newSalary);

                    try {
                        service.updateEmployee(updateEmp);
                    } catch (InvalidEmployeeException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    System.out.print("Enter Employee ID : ");
                    int deleteId = sc.nextInt();
                    try {
                        service.deleteEmployee(deleteId);
                    } catch (InvalidEmployeeException e) {
                        System.out.println(e.getMessage());
                    }

                case 5:
                    System.out.print("Enter Employee ID : ");
                    int searchId = sc.nextInt();

                    try {
                        service.searchEmployee(searchId);
                    }
                    catch (InvalidEmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                case 6:
                    System.out.println("Thank You! Exiting Program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;


            }
        }
    }
}