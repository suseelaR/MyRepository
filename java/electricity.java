/*
	To write a Java code to read the customer details, previous reading and current reading and connect type. Print the electricity bill for the total amount of units consumed as per the following criteria:
--------------------------------------------------------------
Consumer Type	Usage Slab (Units)	Rate per Unit (in Rs.)
--------------------------------------------------------------
Domestic	     Up to 100	         	4.80
	             101 – 200		 	5.80
		     Above 200			6.50
--------------------------------------------------------------
Non-Domestic	     Up to 100			6.05
--------------------------------------------------------------
*/
import java.util.Scanner;
public class electricity 
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Previous Reading: ");
        double previous = sc.nextDouble();
        System.out.print("Enter Current Reading: ");
        double current = sc.nextDouble();
        System.out.print("Enter Connection Type (Domestic/Non-Domestic): ");
        String type = sc.next();
        double units = current - previous;
        double billAmount = 0;
        if (type.equalsIgnoreCase("Domestic")) 
{
            if (units >= 0 && units <= 100)
 {
                billAmount = units * 4.80;
            }
            if (units > 100 && units <= 200) {
                billAmount = (100 * 4.80) + (units - 100) * 5.80;
            } 
                        if (units > 200) {
                billAmount = (100 * 4.80) + (100 * 5.80) + (units - 200) * 6.50;
            }
        } 
	else if (type.equalsIgnoreCase("Non-Domestic")) {
                       if (units >= 0 && units <= 100) {
                billAmount = units * 6.05;
            } 
}
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Customer Name  : " + name);
        System.out.println("Units Consumed : " + units);
        System.out.println("Total Amount   : Rs. " + billAmount);
        sc.close();
    }
}
