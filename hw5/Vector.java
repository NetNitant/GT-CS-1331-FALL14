/**
 * Immutable abstraction for Vector
 *
 * @author Nitant Dandekar
 * @version 1.3
 */
public class Vector {
    private final double[] vector;
    private final int length;

    /**
     * Initialize instance variables
     * @param vector array representation of vector
     */
    public Vector(double[] vector) {
        this.vector = vector;
        this.length = this.vector.length;
    }

    /**
     * Gets value located at specified index
     * @param i index in vector
     * @return double located at index 'i' in vector
     */
    public double get(int i) {
        if (i < 0 || i >= getLength()) {
            throw new VectorIndexOutOfBoundsException("Attempted to access "
                + "element at position " + i + " in a vector of length"
                + getLength() + ".");
        }

        return vector[i];
    }

    /**
     * Get's the length of the Vector.
     * @return number of components in vector
     */
    public int getLength() {
        return length;
    }

    /**
     * String representation of vector with components
     * separated by tabs
     * @return String representation of vector
     */
    public String toString() {
        String output = "";

        for (int i = 0; i < vector.length; i++) {
            output += vector[i];
            output += "\t";
        }

        return output;
    }
}
