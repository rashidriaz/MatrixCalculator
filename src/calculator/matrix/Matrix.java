package calculator.matrix;

import java.util.Scanner;

public class Matrix {
    public final int rows;// tells the total number of rows of the matrix
    public final int columns;// tells the total number of columns of the matrix
    public final int[][] matrix;
    public boolean containsValues = false; //this attribute will turn to true when the user will call the setValues method

    /*
    Constructor: This constructor takes two parameters a Row and a Column
    and verifies if the value of row or column if less than 1 than it
    automatically assigns them the value 1.
     */
    public Matrix(int rows, int columns) {
        if (rows < 1) {
            rows = 1;
        }//end if
        if (columns < 1) {
            columns = 1;
        }//end if
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    /*
    When this function gets called, it iterates through the rows and the columns
    of the given matrix and stores the entered numbers at the position
     */
    public void setMatrixValues() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {// iterates through rows
            System.out.println("\t\t\tAdding number at Row " + (i + 1));
            for (int j = 0; j < columns; j++) {// iterates through columns
                System.out.print("\nAt position " + (i + 1) + "X" + (j + 1) + "\nEnter a number:\t");
                matrix[i][j] = input.nextInt();
                input.nextLine();
            }//end for Loop
        }//end for loop
        containsValues = true;// turned to true as the matrix now contains the values
    }

    /*
    The functionality of this method is to print the values of the matrix if it contains any
     */
    public void printMatrix() {
        if (!containsValues) {
            System.out.println("There's nothing to show!");
            return;
        }//end if
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }//end for loop
        }// end of for loop
    }

}
