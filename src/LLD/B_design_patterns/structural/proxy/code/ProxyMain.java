package LLD.B_design_patterns.structural.proxy.code;

public class ProxyMain {

    public static void main(String[] args) {
        // Proxy Object
        EmployeeDaoProxy employeeDaoProxy = new EmployeeDaoProxy();

        try {
            employeeDaoProxy.get("USER", "1");
            employeeDaoProxy.create("USER", new Employee("2", "Yum", "mini@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
