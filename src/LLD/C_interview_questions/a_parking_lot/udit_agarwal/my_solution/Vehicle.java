package LLD.C_interview_questions.a_parking_lot.udit_agarwal.my_solution;

public class Vehicle {

    private final String registrationNo;
    private final String color;

    public Vehicle(String registrationNo, String color) {
        this.registrationNo = registrationNo;
        this.color = color;
    }

    public String getRegistrationNo() {
        return this.registrationNo;
    }

    public String getColor() {
        return this.color;
    }
}
