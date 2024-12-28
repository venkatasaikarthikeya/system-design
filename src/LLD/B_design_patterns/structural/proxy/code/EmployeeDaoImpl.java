package LLD.B_design_patterns.structural.proxy.code;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, Employee employee) throws Exception {
        System.out.println("Created new row in the employee table");
    }

    @Override
    public void delete(String client, String employeeId) throws Exception {
        System.out.println("Deleted row in the employee table with id " + employeeId);
    }

    @Override
    public Employee get(String client, String employeeId) throws Exception {
        System.out.println("fetching the data from DB");
        return new Employee("1", "Sai", "sai@gmail.com");
    }
}
