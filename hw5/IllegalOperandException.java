/**
 * operand is improper for some reason
 *
 * @author Nitant Dandekar
 * @version 1
 */
public class IllegalOperandException extends Exception {
    /**
     * an IllegalOperandException
     */
    public IllegalOperandException() {
    }

    /**
     * an IllegalOperandException with a message
     * @param  message the message for the exception
     */
    public IllegalOperandException(String message) {
        super(message);
    }
}
