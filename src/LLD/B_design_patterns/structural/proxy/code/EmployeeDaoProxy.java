package LLD.B_design_patterns.structural.proxy.code;

public class EmployeeDaoProxy implements EmployeeDao {

    // Real Object
    private final EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        // In general proxies create and manage the whole lifecycle of the Real Objects
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, Employee employee) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDao.create(client, employee);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public void delete(String client, String employeeId) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDao.delete(client, employeeId);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public Employee get(String client, String employeeId) throws Exception {
        if (client.equals("ADMIN") || client.equals("USER")) {
            return employeeDao.get(client, employeeId);
        }
        throw new Exception("Access denied");
    }
}
