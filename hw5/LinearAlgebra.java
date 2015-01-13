/**
 * linear algebra math
 *
 * @author Nitant Dandekar
 * @version 1
 */
public class LinearAlgebra {
    public static Vector matrixVectorMultiply(Matrix m, Vector v)
        throws IllegalOperandException {
        if (m.getWidth() != v.getLength()) {
            throw new IllegalOperandException("The length of the vector ("
                + v.getLength() + ") is not equal to the width of the matrix ("
                + m.getWidth() + ").");
        }

        double[] result = new double[v.getLength()];

        for (int i = 0; i < m.getHeight(); i++) {
            for (int j = 0; j < m.getWidth(); j++) {
                result[j] += m.get(i, j) * v.get(j);
            }
        }

        return new Vector(result);
    }

    public static Matrix matrixAdd(Matrix m1, Matrix m2)
        throws IllegalOperandException {
        if (m1.getWidth() != m2.getWidth()
            || m1.getHeight() != m2.getHeight()) {
            throw new IllegalOperandException("The dimensions of the first "
                + "matrix (" + m1.getHeight() + " x " + m1.getWidth() + ") are "
                + "not equal to the dimensions of the second matrix ("
                + m2.getHeight() + " x " + m2.getWidth() + ").");
        }

        double[][] result = new double[m1.getHeight()][m1.getWidth()];

        for (int i = 0; i < m1.getHeight(); i++) {
            for (int j = 0; j < m1.getWidth(); j++) {
                result[i][j] += m1.get(i, j) + m2.get(i, j);
            }
        }

        return new Matrix(result);
    }

    public static double dotProduct(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("The length of the first vector ("
                + v1.getLength() + ") is not equal to the length of the second "
                + "vector (" + v1.getLength() + ").");
        }

        double result = 0;

        for (int i = 0; i < v1.getLength(); i++) {
            result += v1.get(i) * v2.get(i);
        }

        return result;
    }

    public static Vector vectorAdd(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("The length of the first vector ("
                + v1.getLength() + ") is not equal to the length of the second "
                + "vector (" + v2.getLength() + ").");
        }

        double[] result = new double[v1.getLength()];

        for (int i = 0; i < v1.getLength(); i++) {
            result[i] = v1.get(i) + v2.get(i);
        }

        return new Vector(result);
    }
}
