
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

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();
                    if(id <= 0){
                        System.out.println("Invalid ID");
                        break;
                    }
                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    if(name.trim().isEmpty()){
                        System.out.println("Name cannot be empty");
                        break;
                    }

                    System.out.print("Enter Salary : ");
                    double salary = sc.nextDouble();
                    if(salary <= 0){
                        System.out.println("Salary must be greater than 0");
                        break;
                    }

                    Employee emp = new Employee(id, name, salary);
                    dao.addEmployee(emp);
                    break;
                case 2:
                    dao.viewEmployee();
                    break;
                case 3:

                    System.out.print("Enter Employee ID : ");
                    int updateId = sc.nextInt();
                    if(updateId <= 0){
                        System.out.println("Invalid ID");
                        break;
                    }
                    sc.nextLine();


                    System.out.print("Enter New Name : ");
                    String newName = sc.nextLine();
                    if(newName.trim().isEmpty()){
                        System.out.println("Name cannot be empty");
                        break;
                    }


                    System.out.print("Enter New Salary : ");
                    double newSalary = sc.nextDouble();
                    if(newSalary <= 0){
                        System.out.println("Salary must be greater than 0");
                        break;
                    }

                    Employee updateEmp = new Employee(updateId, newName, newSalary);

                    dao.updateEmployee(updateEmp);

                    break;
                case 4:
                    System.out.print("Enter Employee ID : ");
                    int deleteId = sc.nextInt();
                    if(deleteId <= 0){
                        System.out.println("Invalid ID");
                        break;

                    }
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Employee ID : ");
                    int searchId = sc.nextInt();
                    if(searchId <= 0){
                        System.out.println("Invalid ID");
                        break;
                    }
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