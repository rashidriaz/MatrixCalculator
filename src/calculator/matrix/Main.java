package calculator.matrix;

import java.util.Scanner;

public class Main {
    private static final MatrixCalculator calculator = new MatrixCalculator();

    public static void main(String[] args) {
        char option = printMenu();
        while (performTask(option)) {
            option = printMenu();
        }// end of while loop
        System.out.println("\nProgram ended successfully!!\n");
    }

    private static boolean performTask(char option) {
        switch (option) {
            case '0':
                calculator.performBasicMathOperations(Operations.addition);
                return true;
            case '1':
                calculator.performBasicMathOperations(Operations.subtraction);
                return true;
            case '2':
                calculator.performBasicMathOperations(Operations.multiplication);
                return true;
            case '3':
                calculator.multiplyMatrixWithConstant();
                return true;
            case '4':
                calculator.divideMatrixWithConstant();
                return true;
            case '5':
                calculator.transpose();
                return true;
            case '6':
                calculator.checkSymmetry();
                return true;
            case '7':
                calculator.isDiagonal();
                return true;
            case '8':
                calculator.isScalar();
                return true;
            case '9':
                calculator.isIdentity();
                return true;
            default:
                return false;

        }// end of switch statement
    }

    private static char printMenu() {
        System.out.println("\nChoose an option:\t");
        System.out.println("0. Add two matrices");
        System.out.println("1. Subtract two matrices");
        System.out.println("2. Multiply two matrices");
        System.out.println("3. Multiply a matrix with a number");
        System.out.println("4. Divide a matrix by a number");
        System.out.println("5. Transpose a matrix");
        System.out.println("6. Check the symmetry of the matrix");
        System.out.println("7. Check whether the matrix is Diagonal or not");
        System.out.println("8. Check whether the matrix is Scalar or not");
        System.out.println("9. Check whether the matrix is Identity or not");
        System.out.println("Press any other key to exit");
        System.out.print("\n\tPlease select your option:\t");
        return new Scanner(System.in).next().toLowerCase().charAt(0);
    }
}
