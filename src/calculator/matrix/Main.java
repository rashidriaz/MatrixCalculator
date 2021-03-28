package calculator.matrix;

import java.util.Scanner;

public class Main {
    private static final MatrixCalculator calculator = new MatrixCalculator();

    public static void main(String[] args) {
        char option = printMainMenu();
        while (performTask(option)) {
            option = printMainMenu();
        }// end of while loop
        System.out.println("\nProgram ended successfully!!\n");
    }

    private static char printMainMenu() {
        System.out.println("\nChoose an option:\t");
        System.out.println("1. Add two matrices");
        System.out.println("2. Subtract two matrices");
        System.out.println("3. Multiply two matrices");
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

    private static boolean performTask(char option) {
        switch (option) {
            case '1':
                performAddition();
                return true;
            case '2':
                performSubtraction();
                return true;
            case '3':
                performMultiplication();
                return true;
            case '4':
                calculator.performBasicMathOperationWithConstant(Operations.DIVISION);
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

    private static void performAddition() {
        System.out.println("Choose an option:");
        System.out.println("1. Add two matrix");
        System.out.println("Press any other key to Add a number to a matrix");
        System.out.print("\nEnter your choice");
        char option = new Scanner(System.in).next().charAt(0);
        if (option == '1') {
            calculator.performBasicMathOperations(Operations.ADDITION);
        } else {
            calculator.performBasicMathOperationWithConstant(Operations.ADDITION);
        }//end if else
    }

    private static void performSubtraction() {
        System.out.println("Choose an option:");
        System.out.println("1. Subtract a matrix from the other matrix");
        System.out.println("Press any other key to subtract a number from a matrix");
        System.out.print("\nEnter your choice");
        char option = new Scanner(System.in).next().charAt(0);
        if (option == '1') {
            calculator.performBasicMathOperations(Operations.SUBTRACTION);
        } else {
            calculator.performBasicMathOperationWithConstant(Operations.SUBTRACTION);
        }//end if else
    }

    private static void performMultiplication() {
        System.out.println("Choose an option:");
        System.out.println("1. Multiply two matrix");
        System.out.println("Press any other key to multiply a number with a matrix");
        System.out.print("\nEnter your choice");
        char option = new Scanner(System.in).next().charAt(0);
        if (option == '1') {
            calculator.performBasicMathOperations(Operations.MULTIPLICATION);
        } else {
            calculator.performBasicMathOperationWithConstant(Operations.MULTIPLICATION);
        }//end if else
    }
}
