/*

Develop a Stack Class with sufficient data members and code the following methods of stack:
•	Default constructor - initialize stack size & allocate memory for new object creation 
•	Parameter constructor - initialize stack size & allocate memory as per the client request for new object creation 
•	Copy constructor - create new object from the existing stack object
•	push()  -  Push an element X
•	pop()    -  Pop an element
•	show()   - Display the contents of the stack
•	search()  -  Perform Linear search
•	sort() -   Sort the elements of the stack
Write a menu driven client code to test the above class. 

*/

import java.util.Scanner;

class Stack {

    private int arr[];
    private int top;
    private int size;

    // Default Constructor
    public Stack() {
        size = 5;
        arr = new int[size];
        top = -1;
    }

    // Parameterized Constructor
    public Stack(int s) {
        size = s;
        arr = new int[size];
        top = -1;
    }

    // Copy Constructor
    public Stack(Stack s) {
        this.size = s.size;
        this.top = s.top;
        this.arr = new int[size];

        for (int i = 0; i <= top; i++) {
            this.arr[i] = s.arr[i];
        }
    }

    // Push
    public void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
        System.out.println("Element pushed successfully");
    }

    // Pop
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped element: " + arr[top--]);
    }

    // Show
    public void show() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print("Stack Elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Linear Search
    public void search(int key) {
        for (int i = 0; i <= top; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at position: " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    // Sort (Ascending)
    public void sort() {
        if (top == -1) {
            System.out.println("Stack Empty");
            return;
        }

        for (int i = 0; i <= top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Stack Sorted Successfully");
    }
}


public class stack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice, value, size;

        System.out.print("Enter stack size: ");
        size = sc.nextInt();

        Stack s1 = new Stack(size);   // Parameter constructor
        Stack s2 = new Stack(s1);     // Copy constructor

        do {
            System.out.println("\n----- STACK MENU -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Show");
            System.out.println("4. Search");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    s1.push(value);
                    break;

                case 2:
                    s1.pop();
                    break;

                case 3:
                    s1.show();
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    value = sc.nextInt();
                    s1.search(value);
                    break;

                case 5:
                    s1.sort();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
