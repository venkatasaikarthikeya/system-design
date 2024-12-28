package LLD.C_interview_questions.a_parking_lot.udit_agarwal.my_solution;

public class Slot {

    private Vehicle vehicle;
    private Boolean isEmpty;

    public Slot() {
        this.isEmpty = true;
        this.vehicle = null;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Boolean getIsEmpty() {
        return this.isEmpty;
    }
}
