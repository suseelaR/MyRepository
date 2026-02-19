/*
Develop an interface “Transformations “ to declare the various transformations like translation, scaling and rotation. Derive an implementation class “point” with sufficient data and methods. Also define a method “calculate()” to find the distance between two points. Write a Java client code to generate “N” point objects and test all the methods of point class.
*/

import java.util.Scanner;

interface Transformations {

    void translate(double tx, double ty);

    void scale(double sx, double sy);

    void rotate(double angle);   // angle in degrees
}


class Point implements Transformations {

    private double x, y;

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    public void show() {
        System.out.println("Point: (" + x + ", " + y + ")");
    }

       public void translate(double tx, double ty) {
        x = x + tx;
        y = y + ty;
    }

        public void scale(double sx, double sy) {
        x = x * sx;
        y = y * sy;
    }

       public void rotate(double angle) {

        double rad = Math.toRadians(angle);

        double newX = x * Math.cos(rad) - y * Math.sin(rad);
        double newY = x * Math.sin(rad) + y * Math.cos(rad);

        x = newX;
        y = newY;
    }

    // Distance between two points
    public double calculate(Point p) {

        double dx = this.x - p.x;
        double dy = this.y - p.y;

        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class pointinterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        Point[] points = new Point[n];

        // Create N point objects
        for (int i = 0; i < n; i++) {

            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            points[i] = new Point(x, y);
        }

        // Test transformations
        for (int i = 0; i < n; i++) {

            System.out.println("\nOriginal:");
            points[i].show();

            points[i].translate(2, 3);
            System.out.println("After Translation (2,3):");
            points[i].show();

            points[i].scale(2, 2);
            System.out.println("After Scaling (2,2):");
            points[i].show();

            points[i].rotate(45);
            System.out.println("After Rotation (45 deg):");
            points[i].show();
        }

        // Distance between first two points
        if (n >= 2) {
            double dist = points[0].calculate(points[1]);
            System.out.println("\nDistance between Point 1 and Point 2: " + dist);
        }

        sc.close();
    }
}
