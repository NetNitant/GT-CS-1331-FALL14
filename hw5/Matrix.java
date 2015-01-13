/**
 * Immutable abstraction of Matrix.
 *
 * @author Nitant Dandekar
 * @version 1.3
 */
public class Matrix {
    private final double[][] matrix;
    private final int height;
    private final int width;

    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.height = this.matrix.length;
        this.width = this.matrix[0].length;
    }

    /**
     * Gets value located at specified row and column
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     */
    public double get(int i, int j) {
        if (i < 0 || i >= getHeight() || j < 0 || j >= getWidth()) {
            throw new MatrixIndexOutOfBoundsException("Attempted to access "
                + "element at position (" + i + ", " + j + ") in a "
                + getHeight() + " x " + getWidth() + " matrix.");
        }

        return matrix[i][j];
    }

    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get's the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String output = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output += matrix[i][j];
                output += "\t";
            }

            output += "\n";
        }

        return output;
    }
}
