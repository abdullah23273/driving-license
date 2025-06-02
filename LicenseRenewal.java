package drivingLicense;
import java.util.Scanner;
import java.util.UUID;

class LicenseRenewal {
    String cnic, oldLicenseId, renewedLicenseId, newAddress, newContact;

    public void collectInfo(Scanner sc) {
        System.out.println("=== License Renewal ===");

        cnic = getValidCNIC(sc);

        System.out.print("Enter Old Permanent License ID: ");
        oldLicenseId = sc.nextLine();

        System.out.print("Enter New Address (or press Enter to skip): ");
        newAddress = sc.nextLine();

        System.out.print("Enter New Contact Number (or press Enter to skip): ");
        newContact = sc.nextLine();

        renewedLicenseId = "RL-" + UUID.randomUUID().toString().substring(0, 8);
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

    public void displayRenewal() {
        System.out.println("\n--- License Renewed Successfully ---");
        System.out.println("Old License ID   : " + oldLicenseId);
        System.out.println("New License ID   : " + renewedLicenseId);
        System.out.println("CNIC             : " + cnic);
        System.out.println("New Address      : " + (newAddress.isEmpty() ? "No Change" : newAddress));
        System.out.println("New Contact No.  : " + (newContact.isEmpty() ? "No Change" : newContact));
        System.out.println("-------------------------------------");
    }
}