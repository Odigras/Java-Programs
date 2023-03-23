package Matrix;

/**
 *
 * @author Odigras
 */
import java.util.Scanner;

public class Matrix {

    private final int rows;
    private final int columns;
    private final double values[][];
    private static int totalNbOfInputMatrices = 0;
    private static int totalNbOfMatrices = 0;
    private Scanner input = new Scanner(System.in);

    public Matrix(int rows, int columns, int io) throws IllegalArgumentException {
        this.rows = rows;
        this.columns = columns;
        values = new double[rows][columns];
        switch (io) {
            case 0 -> {
                totalNbOfInputMatrices++;
                totalNbOfMatrices++;
                fill();
            }
            case 1 -> {
                totalNbOfMatrices++;
            }
            default ->
                throw new IllegalArgumentException("problem matrix constructor!!");
        }
    }

    public static int getTotalNbOfInputMatrices() {
        return totalNbOfInputMatrices;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    /**
     * Displays the matrix after filling it by calling the displayMatrix()
     * method
     *
     * @return void
     */
    private void fill() {

        for (int i = 0; i < rows; i++) {
            System.out.println("\nRow " + (i + 1));
            for (int j = 0; j < columns; j++) {
                this.values[i][j] = input.nextInt();
            }
        }
        System.out.print("\nMatrix " + MatrixCalculator.matrixNamer + ": ");
        displayMatrix();
    }

    private String displayMatrix() {
        String matrix = "";
        for (int i = 0; i < rows; i++) {
            matrix += "    \n";
            for (int j = 0; j < columns; j++) {
                matrix += (values[i][j] + " ");
            }
        }

        return matrix + "\n\n";
    }

    /**
     * Returns null if matrices cannot be added
     *
     * @param matrix1
     * @return Matrix result of adding two matrices
     */
    public Matrix add(Matrix matrix1) {
        //check if addable, return null if not
        if (matrix1.rows != this.rows || matrix1.columns != this.columns) {
            return null;
        }
        //result matrix
        Matrix result = new Matrix(matrix1.rows, matrix1.columns, 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = this.values[i][j] + matrix1.values[i][j];
            }
        }
        return result;
    }

    /**
     * Returns null if matrices cannot be subtracted
     *
     * @param matrix1
     * @return Matrix result of subtracting two matrices
     */
    public Matrix sub(Matrix matrix1) {
        //check if subtractable, return null if not
        if (matrix1.rows != this.rows || matrix1.columns != this.columns) {
            return null;
        }
        Matrix result = new Matrix(matrix1.rows, matrix1.columns, 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = this.values[i][j] - matrix1.values[i][j];
            }
        }
        return result;
    }

    /**
     * Returns null if matrices cannot be multiplied
     *
     * @param matrix1
     * @return Matrix result of multiplying two matrices
     */
    public Matrix mul(Matrix matrix1) {
        //check if multipliable, return null if not
        if (this.columns != matrix1.rows) {
            return null;
        }
        Matrix result = new Matrix(this.rows, matrix1.columns, 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix1.columns; j++) {
                for (int k = 0; k < matrix1.rows; k++) {
                    result.values[i][j] += this.values[i][k] * matrix1.values[k][j];
                }
            }
        }

        return result;
    }

    /**
     * displays a matrix
     */
    @Override
    public String toString() {
        return displayMatrix();
    }

}
