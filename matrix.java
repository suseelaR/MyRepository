/*
Develop a matrix class with sufficient data members and methods.
Write a client code to create the matrix objects A and B using parameter constructor and get the data values of these matrix objects. Evaluate the expression as given below to print the resultant matrix R.
R = ( -A+B) - (A*B)
*/

import java.util.Scanner;

class Matrix {

    private int[][] mat;
    private int rows, cols;

    // Parameter Constructor
    public Matrix(int r, int c) {
        rows = r;
        cols = c;
        mat = new int[rows][cols];
    }

    // Get matrix values
    public void getData(Scanner sc) {
        System.out.println("Enter matrix values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    // Display matrix
    public void show() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Negation (-A)
    public Matrix negate() {
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.mat[i][j] = -this.mat[i][j];
            }
        }
        return result;
    }

    // Addition
    public Matrix add(Matrix b) {
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.mat[i][j] = this.mat[i][j] + b.mat[i][j];
            }
        }
        return result;
    }

    // Subtraction
    public Matrix subtract(Matrix b) {
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.mat[i][j] = this.mat[i][j] - b.mat[i][j];
            }
        }
        return result;
    }

    // Multiplication
    public Matrix multiply(Matrix b) {
        Matrix result = new Matrix(this.rows, b.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.mat[i][j] += this.mat[i][k] * b.mat[k][j];
                }
            }
        }
        return result;
    }
}


public class matrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r, c;

        System.out.print("Enter rows and columns: ");
        r = sc.nextInt();
        c = sc.nextInt();

        // Create matrices using parameter constructor
        Matrix A = new Matrix(r, c);
        Matrix B = new Matrix(r, c);

        System.out.println("Enter Matrix A:");
        A.getData(sc);

        System.out.println("Enter Matrix B:");
        B.getData(sc);

        // R = (-A + B) - (A * B)

        Matrix negA = A.negate();        // -A
        Matrix part1 = negA.add(B);      // -A + B
        Matrix part2 = A.multiply(B);    // A * B
        Matrix R = part1.subtract(part2); // Final result

        System.out.println("\nResult Matrix R:");
        R.show();

        sc.close();
    }
}
