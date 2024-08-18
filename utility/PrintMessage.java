package utility;

/**
 * Prints normal and error messages.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1(03.11.22)
 */
public class PrintMessage
{

    /**
     * empty constructor.
     */
    public PrintMessage()
    {
       //nothing to initialize here. Just to not get a default constructor.
    }

    /**
     * Prints an error message.
     *
     * @param message the error message to be printed out
     */
    public void printErrorMessage(String message)
    {
        System.err.println(message);
    }

    /**
     * Prints a message.
     *
     * @param message the message to be printed out
     */
    public void printMessageLn(String message)
    {
        System.out.println(message);
    }

    /**
     * Prints a message without a line shift.
     *
     * @param message the message to be printed out
     */
    public void printMessage(String message)
    {
        System.out.print(message);
    }

}
