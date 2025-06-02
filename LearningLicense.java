package drivingLicense;
import java.util.Scanner;
import java.util.UUID;

class LearningLicense {
    String cnic, fullName, fatherName, dob, address, contactNumber, bloodGroup, vehicleType, licenseId;

    public void collectInfo(Scanner sc) {
        System.out.println("=== Learning Driving License Registration ===");
        cnic = getValidCNIC(sc);

        System.out.print("Enter Full Name: ");
        fullName = sc.nextLine();

        System.out.print("Enter Father's Name: ");
        fatherName = sc.nextLine();

        System.out.print("Enter Date of Birth (dd-mm-yyyy): ");
        dob = sc.nextLine();

        System.out.print("Enter Address: ");
        address = sc.nextLine();

        System.out.print("Enter Contact Number: ");
        contactNumber = sc.nextLine();

        System.out.print("Enter Blood Group (optional): ");
        bloodGroup = sc.nextLine();

        System.out.println("Select Vehicle Type:\n1. Bike\n2. Car\n3. Both");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        vehicleType = switch (choice) {
            case 1 -> "Bike";
            case 2 -> "Car";
            case 3 -> "Bike and Car";
            default -> "Unknown";
        };

        licenseId = "LL-" + UUID.randomUUID().toString().substring(0, 8);
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
        System.out.println("\n--- Learning License Issued ---");
        System.out.println("License ID   : " + licenseId);
        System.out.println("CNIC         : " + cnic);
        System.out.println("Name         : " + fullName);
        System.out.println("Father Name  : " + fatherName);
        System.out.println("DOB          : " + dob);
        System.out.println("Address      : " + address);
        System.out.println("Contact No.  : " + contactNumber);
        System.out.println("Blood Group  : " + bloodGroup);
        System.out.println("Vehicle Type : " + vehicleType);
        System.out.println("---------------------------------");
    }
}