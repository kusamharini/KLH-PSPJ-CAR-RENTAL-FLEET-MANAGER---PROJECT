import java.util.Scanner;

public class CarFleetManagerCO1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String customerName;
        String vehicleId;
        String vehicleClass;

        int rentalDays;

        double dailyRate;
        double distanceTravelled;
        double ratePerKm;
        double fuelCharge;

        System.out.println("===== CAR RENTAL FLEET MANAGER =====");

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();

        System.out.print("Enter Vehicle ID: ");
        vehicleId = sc.nextLine();

        System.out.print("Enter Vehicle Class: ");
        vehicleClass = sc.nextLine();

        System.out.print("Enter Number of Rental Days: ");
        rentalDays = sc.nextInt();

        System.out.print("Enter Daily Rental Rate: ");
        dailyRate = sc.nextDouble();

        System.out.print("Enter Distance Travelled (km): ");
        distanceTravelled = sc.nextDouble();

        System.out.print("Enter Rate Per Km: ");
        ratePerKm = sc.nextDouble();

        System.out.print("Enter Fuel Charge: ");
        fuelCharge = sc.nextDouble();

        double rentalCharge = rentalDays * dailyRate;

        double mileageCharge =
                distanceTravelled * ratePerKm;

        double totalCharge =
                rentalCharge + mileageCharge + fuelCharge;

        System.out.println("\n===== RENTAL DETAILS =====");

        System.out.println("Customer Name: " + customerName);
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Vehicle Class: " + vehicleClass);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: Rs." + dailyRate);
        System.out.println("Distance: " + distanceTravelled + " km");

        System.out.println("Rental Charge: Rs." + rentalCharge);
        System.out.println("Mileage Charge: Rs." + mileageCharge);
        System.out.println("Fuel Charge: Rs." + fuelCharge);

        System.out.println("----------------------------");
        System.out.println("Total Charge: Rs." + totalCharge);

        sc.close();
    }
}