package calculator.matrix;

import java.util.Locale;
import java.util.Scanner;

public class MatrixCalculator {
    private static final Scanner input = new Scanner(System.in);
    private Matrix firstMatrix = null;
    private Matrix secondMatrix = null;

    /*
   -------------------------------------------------------------------------------
   -------------------------------------------------------------------------------
   -----------------------------PUBLIC METHODS------------------------------------
   -------------------------------------------------------------------------------
   -------------------------------------------------------------------------------
    */
    /*
    This method takes an enum as parameter,provided enum represents the operation to
    be performed. based on that the method call the concerned function and performs
    the given task.
     */
    public void performBasicMathOperations(Operations operation) {
        if (!usePreviousMatrices()) {
            System.out.println("For matrix 1");
            firstMatrix = createMatrix();
            if (firstMatrix == null) {
                return;
            }//end if
            System.out.println("For matrix 2");
            secondMatrix = createMatrix();
            if (secondMatrix == null) {
                return;
            }//end if
            System.out.println("For First Matrix, Enter values");
            firstMatrix.setMatrixValues();
            System.out.println("For Second Matrix, Enter values");
            secondMatrix.setMatrixValues();
        }//end if
        Matrix resultingMatrix = performBasicOperation(operation);
        if (resultingMatrix == null) {
            System.out.println("Error! Something went wrong. Try again later!");
            return;
        }//end if
        System.out.println("\nResults: \n");
        System.out.println("\nFirst Matrix :");
        firstMatrix.printMatrix();
        System.out.println("\nSecond Matrix : ");
        secondMatrix.printMatrix();
        System.out.println("\nResulting Matrix: ");
        resultingMatrix.printMatrix();
    }


    /*
    The functionality of this method is to multiply the given matrix with the given
    constant and print the results on the screen
     */
    public void multiplyMatrixWithConstant() {
        Matrix firstMatrix = getSingleMatrix();
        if (firstMatrix == null) {
            return;
        }//end if
        if (!firstMatrix.containsValues) {
            firstMatrix.setMatrixValues();
        }//end if
        int constantValue = getNumber("\nPlease enter the number you want the matrix to be multiplied with:\t");
        for (int i = 0; i < firstMatrix.rows; i++) {
            for (int j = 0; j < firstMatrix.columns; j++) {
                firstMatrix.matrix[i][j] *= constantValue;
            }//end of for loop
        }//end of for loop
        System.out.println("Resulting matrix is: ");
        firstMatrix.printMatrix();
    }

    /*
    The functionality of this method is to divide the given matrix with the given
    constant and print the results on the screen
     */
    public void divideMatrixWithConstant() {
        Matrix firstMatrix = getSingleMatrix();
        if (firstMatrix == null) {
            return;
        }//end if
        if (!firstMatrix.containsValues) {
            firstMatrix.setMatrixValues();
        }//end if
        int constantValue = getNumber("\nPlease enter the number you want the matrix to be divided with:\t");
        if (constantValue == 0) {
            System.out.println("Error! Division is not possible when the denominator is 0");
            return;
        }//end if
        for (int i = 0; i < firstMatrix.rows; i++) {
            for (int j = 0; j < firstMatrix.columns; j++) {
                firstMatrix.matrix[i][j] = firstMatrix.matrix[i][j] / constantValue;
            }//end of for loop
        }//end of for loop
        System.out.println("Resulting matrix is: ");
        firstMatrix.printMatrix();
    }

    /*
    The functionality of this method is to take a matrix from the user and find its
    transpose and then print the results in the end
     */
    public void transpose() {
        Matrix matrix = getSingleMatrix();
        if (matrix == null) {
            return;
        }//end if
        if (!matrix.containsValues) {
            matrix.setMatrixValues();
        }
        Matrix transposeMatrix = new Matrix(matrix.columns, matrix.rows);

        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                transposeMatrix.matrix[j][i] = matrix.matrix[i][j];
            }//end of for loop
        }//end of for loop
        System.out.println("Given Matrix: ");
        matrix.printMatrix();
        System.out.println("Transpose:");
        matrix.printMatrix();
    }

    public void checkSymmetry() {
        Matrix matrix = getSingleMatrix();
        if (matrix == null) {
            return;
        }//end if
        if (!matrix.containsValues) {
            matrix.setMatrixValues();
        }//end if
        boolean isSymmetric = false;
        boolean isSkewSymmetric = false;
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                isSymmetric = matrix.matrix[i][j] == matrix.matrix[j][i];
                isSkewSymmetric = matrix.matrix[i][j] == (matrix.matrix[j][i] * (-1));
            }//end of for loop
        }//end of for loop
        if (isSymmetric) {
            System.out.println("The given matrix is a \"Symmetric Matrix\"");
        } else if (isSkewSymmetric) {
            System.out.println("The given matrix is a \"Skew-Symmetric Matrix\"");
        } else {
            System.out.println("The given matrix is neither Symmetric nor skew-Symmetric");
        }
    }


    /*
    The functionality of this function is to take a matrix from the user and check
    whether the given matrix is diagonal or not
     */
    public void isDiagonal() {
        Matrix matrix = getSingleMatrix();
        if (matrix == null) {
            return;
        }//end if
        if (matrix.rows != matrix.columns) {
            System.out.println("The given matrix can't be a diagonal matrix as it is not square");
            return;
        }// end if
        if (!matrix.containsValues) {
            matrix.setMatrixValues();
        }//end if
        boolean isDiagonal = false;

        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                if (i == j) {
                    if (matrix.matrix[i][j] != 0) {
                        isDiagonal = true;
                    }//end if
                } else {
                    if (matrix.matrix[i][j] != 0) {
                        isDiagonal = false;
                        break;
                    }// end if
                }//end if
            }//end of for loop
        }//end of for loop
        if (isDiagonal) {
            System.out.println("The given matrix is a Diagonal Matrix");
            return;
        }//end if
        System.out.println("The given matrix is not a Diagonal Matrix");
    }

    /*
    The functionality of this function is to take a matrix from the user and check
    whether the given matrix is Identity Matrix or not
     */
    public void isIdentity() {
        Matrix matrix = getSingleMatrix();
        if (matrix == null) {
            return;
        }//end if
        if (matrix.rows != matrix.columns) {
            System.out.println("The given matrix can't be a diagonal matrix as it is not square");
            return;
        }// end if
        if (!matrix.containsValues) {
            matrix.setMatrixValues();
        }//end if
        boolean isIdentity = true;

        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                if (i == j) {
                    if (matrix.matrix[i][j] != 1) {
                        isIdentity = false;
                        break;
                    }//end if
                } else {
                    if (matrix.matrix[i][j] != 0) {
                        isIdentity = false;
                        break;
                    }// end if
                }//end if
            }//end of for loop
        }//end of for loop
        if (isIdentity) {
            System.out.println("The given matrix is an Identity Matrix");
            return;
        }//end if
        System.out.println("The given matrix is not an Identity Matrix");
    }

    /*
        The functionality of this function is to take a matrix from the user and check
        whether the given matrix is Identity Matrix or not
         */
    public void isScalar() {
        Matrix matrix = getSingleMatrix();
        if (matrix == null) {
            return;
        }//end if
        if (matrix.rows != matrix.columns) {
            System.out.println("The given matrix can't be a diagonal matrix as it is not square");
            return;
        }// end if
        if (!matrix.containsValues) {
            matrix.setMatrixValues();
        }//end if
        boolean isScalar = true;
        int diagonalNumber = matrix.matrix[0][0];
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                if (i == j) {
                    if (matrix.matrix[i][j] != diagonalNumber) {
                        isScalar = false;
                        break;
                    }//end if
                } else {
                    if (matrix.matrix[i][j] != 0) {
                        isScalar = false;
                        break;
                    }// end if
                }//end if
            }//end of for loop
        }//end of for loop
        if (isScalar) {
            System.out.println("The given matrix is an Identity Matrix");
            return;
        }//end if
        System.out.println("The given matrix is not an Identity Matrix");
    }
    /*
   -------------------------------------------------------------------------------
   -------------------------------------------------------------------------------
   -----------------------------PRIVATE METHODS------------------------------------
   -------------------------------------------------------------------------------
   -------------------------------------------------------------------------------
    */

    private Matrix performBasicOperation(Operations operation) {
        switch (operation) {
            case addition:
                return addMatrices(firstMatrix, secondMatrix);
            case subtraction:
                return subtractMatrices(firstMatrix, secondMatrix);
            case multiplication:
                return multiplyMatrices(firstMatrix, secondMatrix);
        }
        return null;
    }

    /*
    The functionality of this method is to take two matrices as parameters, add them
    and return the resulting matrix
     */
    private Matrix addMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        if (!orderOfMatricesIsSame(firstMatrix, secondMatrix)) {
            System.out.println("Error! Both the given matrices are not suitable for" +
                    " addition as their order is different");
            return null;
        }//end if
        Matrix resultingMatrix = new Matrix(firstMatrix.rows, firstMatrix.columns);
        for (int i = 0; i < firstMatrix.rows; i++) {//iterates through rows
            for (int j = 0; j < firstMatrix.columns; j++) {//iterates through columns
                resultingMatrix.matrix[i][j] = firstMatrix.matrix[i][j] + secondMatrix.matrix[i][j];
            }//end of for loop
        }// end of for loop
        resultingMatrix.containsValues = true;
        return resultingMatrix;
    }

    /*
    The functionality of this method is to take two matrices as parameters, subtract them
    and return the resulting matrix
    */
    private Matrix subtractMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        if (!orderOfMatricesIsSame(firstMatrix, secondMatrix)) {
            System.out.println("Error! Both the given matrices are not suitable for" +
                    " subtraction as their order is different");
            return null;
        }//end if
        Matrix resultingMatrix = new Matrix(firstMatrix.rows, firstMatrix.columns);
        for (int i = 0; i < firstMatrix.rows; i++) {//iterates through rows
            for (int j = 0; j < firstMatrix.columns; j++) {//iterates through columns
                resultingMatrix.matrix[i][j] = firstMatrix.matrix[i][j] - secondMatrix.matrix[i][j];
            }//end of for loop
        }// end of for loop
        resultingMatrix.containsValues = true;
        return resultingMatrix;
    }

    /*
        The functionality of this method is to take two matrices as parameters, add them
        and return the resulting matrix
         */
    private Matrix multiplyMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        if (!suitableForMultiplication(firstMatrix, secondMatrix)) {
            System.out.println("Error! Both the given matrices are not suitable for" +
                    " multiplication due to their order");
            return null;
        }//end if
        Matrix resultingMatrix = new Matrix(firstMatrix.rows, secondMatrix.columns);
        for (int i = 0; i < firstMatrix.rows; i++) {
            for (int j = 0; j < secondMatrix.columns; j++) {
                for (int k = 0; k < firstMatrix.columns; k++) {
                    resultingMatrix.matrix[i][j] += firstMatrix.matrix[i][k] * secondMatrix.matrix[k][j];
                }//end of for loop
            }// end of for loop
        }// end of for loop
        resultingMatrix.containsValues = true;
        return resultingMatrix;
    }

    /*
    The functionality of this method is to take 2 integers from the user and verify their
    validity if any of the number is invalid or out of range this method will return a null
    and if the numbers are valid, it will return an instance of a matrix class
     */
    private Matrix createMatrix() {
        int rows = getNumber("\n Enter the number of rows:\t");
        if (rows < 1) {
            System.out.println("Error! Number of rows can't be less than 1.");
            return null;
        }//end if
        int columns = getNumber("\n Enter the number of columns:\t");
        if (columns < 1) {
            System.out.println("Error! Number of rows can't be less than 1.");
            return null;
        }// end if
        return new Matrix(rows, columns);
    }

    /*
    This function takes two matrices as parameters and check whether the order of
     both the given matrices is same or not.
     */
    private boolean orderOfMatricesIsSame(Matrix firstMatrix, Matrix secondMatrix) {
        return ((firstMatrix.rows == secondMatrix.rows) && (firstMatrix.columns == secondMatrix.columns));
    }

    /*
     This function takes two matrices as parameters and check whether the given
     matrices are suitable for multiplication or not.
      */
    private boolean suitableForMultiplication(Matrix firstMatrix, Matrix secondMatrix) {
        return (firstMatrix.columns == secondMatrix.rows);
    }

    /*
    The functionality of this method is to prompt the user to enter a number
    and returns the entered number
     */
    private int getNumber(String message) {
        System.out.print(message);
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    /*
    The functionality of this method is to check whether the first and second matrix are null or not
    and based on that prompts the user and ask whether they would like to use the previous matrices
    or not
     */
    private boolean usePreviousMatrices() {
        if (firstMatrix != null && secondMatrix != null) {
            System.out.println("Would you like to use previously entered matrices? Press \"Y for yes\"" +
                    " or press any other key for \"No\":\t");
            char option = input.next().toLowerCase(Locale.ROOT).charAt(0);
            return option == 'y';
        }//end if
        return false;
    }

    /*
    The functionality of this method is to check whether the first and second matrix are null or not
    and based on that prompts the user and ask whether they would like to use the previous matrices
    or not in case where only one matrix is needed.
    The method will return 0 or any other number except 1 and 2 if the user do not want to use any
    previous matrix. and will return 1 in case if the user wants to use the firstMatrix and 2 for secondMatrix
     */
    private char usePreviousMatrix() {
        if (firstMatrix != null && secondMatrix != null) {
            System.out.println("Would you like to use previously entered matrices? Press \"Y for yes\"" +
                    " or press any other key for \"No\":\t");
            char option = input.next().toLowerCase(Locale.ROOT).charAt(0);
            if (option == 'y') {
                System.out.println("Matrix 1");
                firstMatrix.printMatrix();
                System.out.println("Matrix 2");
                secondMatrix.printMatrix();
                System.out.println("\n1. to choose first matrix");
                System.out.println("2. to choose second matrix");
                System.out.println("Enter any other number for a new matrix");
                System.out.print("\nEnter your choice:\t");
                return input.next().charAt(0);
            }
        }//end if
        return '0';
    }

    /*
    The functionality of this method is to ask user regarding which matrix they want to use
    either previous matrix or a new matrix, and then return the matrix desired by the user
     */
    private Matrix getSingleMatrix() {
        char usePreviousMatrix = usePreviousMatrix();
        if (usePreviousMatrix == '1') {
            return this.firstMatrix;
        } else if (usePreviousMatrix == '2') {
            return this.secondMatrix;
        } //end if else
        return null;
    }
}

enum Operations {
    addition,
    subtraction,
    multiplication,
}