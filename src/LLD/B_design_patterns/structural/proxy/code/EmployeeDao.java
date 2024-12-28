package LLD.B_design_patterns.structural.proxy.code;

public interface EmployeeDao {
    void create(String client, Employee employee) throws Exception;
    void delete(String client, String employeeId) throws Exception;
    Employee get(String client, String employeeId) throws Exception;
}
