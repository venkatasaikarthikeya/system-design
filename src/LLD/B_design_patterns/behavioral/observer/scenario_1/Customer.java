package LLD.B_design_patterns.behavioral.observer.scenario_1;

import LLD.B_design_patterns.behavioral.observer.Subscriber;

public class Customer implements Subscriber {

    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void notify(String event, String data) {
        System.out.println("Notification to " + name + "-> Event: " + event + " with message " + data);
    }
}
