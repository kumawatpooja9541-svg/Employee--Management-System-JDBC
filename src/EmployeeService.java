public class EmployeeService {

   private  EmployeeDAO dao = new EmployeeDAO();

    public void addEmployee(Employee employee)throws InvalidEmployeeException {
        if (employee.getId() <= 0) {
            throw new InvalidEmployeeException("Invalid ID");
        }
        if (employee.getName().trim().isEmpty()) {
            throw new InvalidEmployeeException("Name cannot be empty");
        }
        if (employee.getSalary() <= 0) {
            throw new InvalidEmployeeException("Salary must be greater than 0");

        }
        dao.addEmployee(employee);
    }

    public void viewEmployee()  {
            dao.viewEmployee();
    }
    public void updateEmployee(Employee employee) throws InvalidEmployeeException{
        if (employee.getId() <= 0) {
            throw new InvalidEmployeeException("Invalid ID");
        }
        if (employee.getName().trim().isEmpty()) {
            throw new InvalidEmployeeException("Name cannot be empty");
        }
        if (employee.getSalary() <= 0) {
            throw new InvalidEmployeeException("Salary must be greater than 0");
        }
        dao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) throws InvalidEmployeeException{
        if(id<=0){
            throw new InvalidEmployeeException("Invalid ID");
        }
        dao.deleteEmployee(id);

    }

    public void searchEmployee(int id) throws InvalidEmployeeException{

        if(id<=0){
            throw new InvalidEmployeeException("Invalid ID");
        }
        dao.searchEmployee(id);

    }
}


