package LLD.C_interview_questions.a_parking_lot.udit_agarwal.my_solution;

import java.util.Scanner;

public class ParkingLotSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean closeConsole = false;

        ParkingLot parkingLot = null;

        while (true) {

            String input = sc.nextLine();

            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "create_parking_lot":
                    parkingLot = ParkingLot.getInstance(Integer.parseInt(parts[1]));
                    break;
                case "park":
                    if (parkingLot != null) {
                        parkingLot.parkCar(parts[1], parts[2]);
                    }
                    break;
                case "leave":
                    if (parkingLot != null) {
                        parkingLot.unParkCar(Integer.parseInt(parts[1]));
                    }
                    break;
                case "status":
                    if (parkingLot != null) {
                        parkingLot.printStatus();
                    }
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        parkingLot.printDetailByColor(parts[1], true, false);
                    }
                    break;
                case "slot_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        parkingLot.printDetailByColor(parts[1], false, true);
                    }
                    break;
                case "slot_number_for_registration_number":
                    if (parkingLot != null) {
                        parkingLot.printSlotNoForRegistrationNo(parts[1]);
                    }
                    break;
                case "exit":
                    closeConsole = true;
                    System.out.println("exit");
                    break;
                default:
                    closeConsole = true;
                    System.out.println("exit");
                    break;
            }
            if (closeConsole) {
                break;
            }
        }
    }
}
