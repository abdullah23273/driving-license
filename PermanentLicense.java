package drivingLicense;
import java.util.Scanner;
import java.util.UUID;

class PermanentLicense {
    String cnic, fullName, learningLicenseId, permanentLicenseId, vehicleType;

    public void collectInfo(Scanner sc) {
        System.out.println("=== Permanent Driving License Registration ===");

        cnic = getValidCNIC(sc);

        System.out.print("Do you have a valid Learning License? (yes/no): ");
        String hasLL = sc.nextLine();

        if (!hasLL.equalsIgnoreCase("yes")) {
            System.out.println("❌ You must have a valid Learning License to apply.");
            return;
        }

        System.out.print("Enter Learning License ID: ");
        learningLicenseId = sc.nextLine();

        System.out.print("Enter Full Name: ");
        fullName = sc.nextLine();

        System.out.println("Select Vehicle Type:\n1. Bike\n2. Car\n3. Both");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        vehicleType = switch (choice) {
            case 1 -> "Bike";
            case 2 -> "Car";
            case 3 -> "Bike and Car";
            default -> "Unknown";
        };

        permanentLicenseId = "PL-" + UUID.randomUUID().toString().substring(0, 8);
    }

    private String getValidCNIC(Scanner sc) {
        String input;
        while (true) {
            System.out.print("Enter CNIC (13 digits, no dashes): ");
            input = sc.nextLine();
            if (input.matches("\\d{13}")) return input;
            System.out.println("❌ Invalid CNIC. Must be 13 numeric digits.");
        }
    }

    public void displayLicense() {
        if (permanentLicenseId == null) return;

        System.out.println("\n--- Permanent License Issued ---");
        System.out.println("License ID   : " + permanentLicenseId);
        System.out.println("CNIC         : " + cnic);
        System.out.println("Name         : " + fullName);
        System.out.println("Learning ID  : " + learningLicenseId);
        System.out.println("Vehicle Type : " + vehicleType);
        System.out.println("---------------------------------");
    }
}