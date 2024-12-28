package LLD.C_interview_questions.a_parking_lot.udit_agarwal.my_solution;

import java.util.Objects;

public class ParkingLot {

    private Integer numberOfSlots;
    private Slot[] slots;
    private static ParkingLot instance;
    private Integer filledSlots;

    private ParkingLot(Integer numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        this.slots = new Slot[numberOfSlots + 1];
        this.filledSlots = 0;

        for (int i = 1; i <= numberOfSlots; i++) {
            this.slots[i] = new Slot();
        }

        System.out.println("Created a parking lot with " + numberOfSlots + " slots");
    }

    private Boolean isParkingLotFull() {
        return Objects.equals(filledSlots, numberOfSlots);
    }

    public void parkCar(String registrationNo, String color) {
        if (isParkingLotFull()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        Vehicle vehicle = new Vehicle(registrationNo, color);
        for (int i = 1; i <= numberOfSlots; i++) {
            if (slots[i].getIsEmpty()) {
                slots[i].setIsEmpty(false);
                slots[i].setVehicle(vehicle);
                this.filledSlots++;
                System.out.println("Allocated slot number: " + i);
                break;
            }
        }
    }

    public void unParkCar(Integer slotNumber) {
        Slot parkingSlot = slots[slotNumber];
        parkingSlot.setIsEmpty(true);
        parkingSlot.setVehicle(null);
        this.filledSlots--;
        System.out.println("Slot number " + slotNumber + " is free");
    }

    public void printStatus() {
        System.out.println("Slot No. Registration No Color");
        for (int i = 1; i <= numberOfSlots; i++) {
            if (!slots[i].getIsEmpty()) {
                System.out.println(i + " " + slots[i].getVehicle().getRegistrationNo() + " " + slots[i].getVehicle().getColor());
            }
        }
    }

    public void printDetailByColor(String color, Boolean discoverRegistrationNo, Boolean discoverSlotNo) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= numberOfSlots; i++) {
            Slot slot = slots[i];
            if (!slot.getIsEmpty() && slot.getVehicle().getColor().equals(color)) {
                if (!builder.isEmpty()) {
                    if (discoverRegistrationNo) {
                        builder.append(", ").append(slot.getVehicle().getRegistrationNo());
                    } else {
                        builder.append(", ").append(i);
                    }
                } else {
                    if (discoverRegistrationNo) {
                        builder.append(slot.getVehicle().getRegistrationNo());
                    } else {
                        builder.append(i);
                    }
                }
            }
        }
        System.out.println(builder.toString());
    }

    public void printSlotNoForRegistrationNo(String registrationNo) {
        for (int i = 1; i <= numberOfSlots; i++) {
            Slot slot = slots[i];
            if (slot.getVehicle().getRegistrationNo().equals(registrationNo)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static ParkingLot getInstance(Integer size) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot(size);
                }
            }
        }
        return instance;
    }
}
