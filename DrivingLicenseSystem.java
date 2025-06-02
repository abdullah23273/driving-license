package drivingLicense;
import java.util.Scanner;
import java.util.UUID;

public class DrivingLicenseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Driving License Management System =====");
            System.out.println("1. Apply for Learning License");
            System.out.println("2. Apply for Permanent License");
            System.out.println("3. Renew Existing License");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    LearningLicense ll = new LearningLicense();
                    ll.collectInfo(sc);
                    ll.displayLicense();
                }
                case 2 -> {
                    PermanentLicense pl = new PermanentLicense();
                    pl.collectInfo(sc);
                    pl.displayLicense();
                }
                case 3 -> {
                    LicenseRenewal rl = new LicenseRenewal();
                    rl.collectInfo(sc);
                    rl.displayRenewal();
                }
                case 4 -> System.out.println("✅ Thank you for using the system!");
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}