/**
 * out of bounds for a matrix
 *
 * @author Nitant Dandekar
 * @version 1
 */
public class MatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {
    /**
     * an MatrixIndexOutOfBoundsException
     */
    public MatrixIndexOutOfBoundsException() {
    }

    /**
     * an MatrixIndexOutOfBoundsException with a message
     * @param  message the message for the exception
     */
    public MatrixIndexOutOfBoundsException(String message) {
        super(message);
    }
}
