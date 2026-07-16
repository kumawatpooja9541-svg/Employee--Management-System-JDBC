
import java.sql.SQLException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();


        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
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
                    dao.addEmployee(emp);
                    break;
                case 2:
                    dao.viewEmployee();
                    break;
                case 3:

                    System.out.print("Enter Employee ID : ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Salary : ");
                    double newSalary = sc.nextDouble();

                    Employee updateEmp = new Employee(updateId, "", newSalary);

                    dao.updateEmployee(updateEmp);

                    break;
                case 4:
                    System.out.print("Enter Employee ID : ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Employee ID : ");
                    int searchId = sc.nextInt();
                    dao.searchEmployee(searchId);

                    break;
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