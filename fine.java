import java.util.Scanner;

public class final{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial inputs
        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        double totalFine = 0;
        double leaveFine = 0; // Tracks fine specifically for leaves
        int choice;

        do {
            System.out.println("\n--- Student Fine Menu ---");
            System.out.println("1. Not wearing ID (Rs 150/attempt)");
            System.out.println("2. Not wearing shoes (Rs 250/attempt)");
            System.out.println("3. Casual leave taken (Rs 10/day, >5 days)");
            System.out.println("4. Library book (Rs 20/book/day)");
            System.out.println("5. Lab item breakage (Rs 10,000/item)");
            System.out.println("6. Final Report & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Attempts: ");
                    totalFine += (sc.nextInt() * 150);
                    break;
                case 2:
                    System.out.print("Attempts: ");
                    totalFine += (sc.nextInt() * 250);
                    break;
                case 3:
                    System.out.print("Enter total leave days: ");
                    int days = sc.nextInt();
                    if (days > 5) {
                        double currentLeaveFine = days * 10;
                        leaveFine += currentLeaveFine; // Add to specific leave tracker
                        totalFine += currentLeaveFine; // Add to overall total
                    }
                    break;
                case 4:
                    System.out.print("Books: ");
                    int books = sc.nextInt();
                    System.out.print("Days delayed: ");
                    totalFine += (books * sc.nextInt() * 20);
                    break;
                case 5:
                    System.out.print("Broken items: ");
                    totalFine += (sc.nextInt() * 10000);
                    break;
                case 6:
                    System.out.println("\n--- FINAL FINE LIST ---");
                    System.out.println("Student: " + name + " (" + studentID + ")");
                    System.out.println("Total Fine Amount: Rs " + totalFine);
                    
                    // Trigger warning IF AND ONLY IF leave fine exceeds Rs 50
                    if (leaveFine > 50) {
                        System.out.println("!!! WARNING MESSAGE FOR SUSPENSION !!!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }
}