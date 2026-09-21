
import java.util.Scanner;

public class CarFleetManagerCO3 {

    static Scanner sc = new Scanner(System.in);

    static String[] vehicleId = {
        "KA01-ECO-1",
        "KA09-SUV-3",
        "KA05-LUX-7"
    };

    static String[] vehicleClass = {
        "Economy",
        "SUV",
        "Luxury"
    };

    static double[] dailyRate = {
        1500,
        2500,
        5000
    };

    static double[] odometer = {
        20000,
        39000,
        15000
    };

    // 2-D array
    // Rows = vehicles
    // Columns = rental information
    static int[][] rentalData = new int[3][2];


    // Method to display one vehicle
    static void displayVehicle(int index) {

        System.out.println(
                "Vehicle ID: " + vehicleId[index]);

        System.out.println(
                "Class: " + vehicleClass[index]);

        System.out.println(
                "Daily Rate: Rs." + dailyRate[index]);

        System.out.println(
                "Odometer: " + odometer[index] + " km");

        System.out.println();
    }


    // Recursive method
    static void displayVehicles(int index) {

        if (index == vehicleId.length) {
            return;
        }

        displayVehicle(index);

        displayVehicles(index + 1);
    }


    // Method to calculate rental charge
    static double calculateCharge(
            int days,
            double rate,
            double distance,
            double kmRate) {

        double baseCharge = days * rate;

        double mileageCharge =
                distance * kmRate;

        return baseCharge + mileageCharge;
    }


    // Method to search vehicle
    static int searchVehicle(String id) {

        for (int i = 0; i < vehicleId.length; i++) {

            if (vehicleId[i].equalsIgnoreCase(id)) {

                return i;
            }
        }

        return -1;
    }


    // Method to display all vehicles
    static void showFleet() {

        System.out.println("\n===== VEHICLE FLEET =====");

        displayVehicles(0);
    }


    public static void main(String[] args) {

        int choice;

        do {

            System.out.println(
                    "\n===== CAR RENTAL FLEET MANAGER =====");

            System.out.println("1. Display Fleet");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Display Rental Data");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();


            switch (choice) {

                case 1:

                    showFleet();

                    break;


                case 2:

                    System.out.print(
                            "Enter vehicle ID: ");

                    String id = sc.next();

                    int index = searchVehicle(id);

                    if (index == -1) {

                        System.out.println(
                                "Vehicle not found.");

                    } else {

                        displayVehicle(index);
                    }

                    break;


                case 3:

                    System.out.print(
                            "Enter vehicle number (1-3): ");

                    int vehicleNumber =
                            sc.nextInt();

                    if (vehicleNumber < 1 ||
                            vehicleNumber > 3) {

                        System.out.println(
                                "Invalid vehicle.");

                        break;
                    }

                    int vehicleIndex =
                            vehicleNumber - 1;

                    System.out.print(
                            "Enter rental days: ");

                    int days = sc.nextInt();

                    System.out.print(
                            "Enter distance travelled: ");

                    double distance =
                            sc.nextDouble();

                    double kmRate;

                    if (vehicleClass[vehicleIndex]
                            .equals("Economy")) {

                        kmRate = 5;

                    } else if (
                            vehicleClass[vehicleIndex]
                                    .equals("SUV")) {

                        kmRate = 8;

                    } else {

                        kmRate = 12;
                    }

                    double charge =
                            calculateCharge(
                                    days,
                                    dailyRate[vehicleIndex],
                                    distance,
                                    kmRate);

                    rentalData[vehicleIndex][0] =
                            days;

                    rentalData[vehicleIndex][1] =
                            (int) distance;

                    System.out.println(
                            "\nRental Successful");

                    System.out.println(
                            "Vehicle: "
                                    + vehicleId[vehicleIndex]);

                    System.out.println(
                            "Class: "
                                    + vehicleClass[vehicleIndex]);

                    System.out.println(
                            "Total Charge: Rs."
                                    + charge);

                    break;


                case 4:

                    System.out.println(
                            "\n===== RENTAL DATA =====");

                    for (int i = 0;
                         i < rentalData.length;
                         i++) {

                        System.out.println(
                                vehicleId[i]);

                        System.out.println(
                                "Rental Days: "
                                        + rentalData[i][0]);

                        System.out.println(
                                "Distance: "
                                        + rentalData[i][1]
                                        + " km");

                        System.out.println();
                    }

                    break;


                case 5:

                    System.out.println(
                            "Thank you!");

                    break;


                default:

                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}