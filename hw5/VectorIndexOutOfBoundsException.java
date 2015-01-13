/**
 * out of bounds for a vector
 *
 * @author Nitant Dandekar
 * @version 1
 */
public class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    /**
     * an VectorIndexOutOfBoundsException
     */
    public VectorIndexOutOfBoundsException() {
    }

    /**
     * an VectorIndexOutOfBoundsException with a message
     * @param  message the message for the exception
     */
    public VectorIndexOutOfBoundsException(String message) {
        super(message);
    }
}
