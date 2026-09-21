import java.util.Scanner;

public class CarFleetManagerCO2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== CAR RENTAL FLEET MANAGER =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Check Vehicle");
            System.out.println("3. Calculate Rental Charge");
            System.out.println("4. Display Vehicle Classes");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n--- RENT A CAR ---");

                    System.out.print("Enter vehicle ID: ");
                    String vehicleId = sc.next();

                    System.out.println("Vehicle Classes:");
                    System.out.println("1. Economy");
                    System.out.println("2. SUV");
                    System.out.println("3. Luxury");

                    System.out.print("Choose class: ");
                    int vehicleChoice = sc.nextInt();

                    String vehicleClass;
                    double dailyRate;

                    if (vehicleChoice == 1) {

                        vehicleClass = "Economy";
                        dailyRate = 1500;

                    } else if (vehicleChoice == 2) {

                        vehicleClass = "SUV";
                        dailyRate = 2500;

                    } else if (vehicleChoice == 3) {

                        vehicleClass = "Luxury";
                        dailyRate = 5000;

                    } else {

                        System.out.println("Invalid vehicle class.");
                        break;
                    }

                    System.out.print("Enter rental days: ");
                    int days = sc.nextInt();

                    if (days <= 0) {

                        System.out.println("Invalid number of days.");

                    } else {

                        double charge = days * dailyRate;

                        System.out.println("\nRental Successful");
                        System.out.println("Vehicle ID: " + vehicleId);
                        System.out.println("Class: " + vehicleClass);
                        System.out.println("Days: " + days);
                        System.out.println("Total Charge: Rs." + charge);
                    }

                    break;


                case 2:

                    System.out.println("\n--- CHECK VEHICLE ---");

                    System.out.print("Enter current odometer: ");
                    double odometer = sc.nextDouble();

                    if (odometer >= 40000) {

                        System.out.println(
                                "Vehicle requires service.");
                        System.out.println(
                                "Rental is BLOCKED.");

                    } else {

                        System.out.println(
                                "Vehicle is available for rental.");
                    }

                    break;


                case 3:

                    System.out.println("\n--- RENTAL CHARGE ---");

                    System.out.print("Enter rental days: ");
                    int rentalDays = sc.nextInt();

                    System.out.print("Enter daily rate: ");
                    double rate = sc.nextDouble();

                    System.out.print("Enter distance travelled: ");
                    double distance = sc.nextDouble();

                    System.out.print("Enter rate per km: ");
                    double kmRate = sc.nextDouble();

                    double baseCharge =
                            rentalDays * rate;

                    double mileageCharge =
                            distance * kmRate;

                    double total =
                            baseCharge + mileageCharge;

                    System.out.println(
                            "Base Charge: Rs." + baseCharge);

                    System.out.println(
                            "Mileage Charge: Rs." + mileageCharge);

                    System.out.println(
                            "Total Charge: Rs." + total);

                    break;


                case 4:

                    System.out.println(
                            "\n--- VEHICLE CLASSES ---");

                    System.out.println(
                            "1. Economy - Rs.1500/day");

                    System.out.println(
                            "2. SUV - Rs.2500/day");

                    System.out.println(
                            "3. Luxury - Rs.5000/day");

                    break;


                case 5:

                    System.out.println(
                            "Thank you for using the system.");

                    break;


                default:

                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}