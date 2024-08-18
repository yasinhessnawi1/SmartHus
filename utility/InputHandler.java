package utility;

import java.util.Scanner;

/**
 * Checks input of user if it is valid.
 *
 * @author yasinhessnawi
 * @version 0.0.1 (03.11.22)
 */
public class InputHandler
{
    private final Scanner reader;
    private final PrintMessage printMessage;

    /**
     * constructor to reuse objects of scanner and print massage class from smartHusAs class.
     *
     * @param reader       gets scanner class from SmartHus class
     * @param printMessage gets print massage class from SmartHus class
     */
    public InputHandler(Scanner reader, PrintMessage printMessage)
    {
        this.reader = reader;
        this.printMessage = printMessage;
    }

    /**
     * reads and checks if integer input is valid.
     *
     * @return if input is valid
     */
    public int readAndCheckIfInputInt()
    {
        while (!reader.hasNextInt())
        {
            printMessage.printErrorMessage(
                "Your input is not accepted, please enter a number greater than 0. ");
            reader.next();
        }
        return reader.nextInt();
    }

    /**
     * reads and checks if float input is valid.
     *
     * @return if input is valid
     */
    public float readAndCheckIfInputFloat()
    {
        while (!reader.hasNextFloat())
        {
            printMessage.printErrorMessage(
                "Your input is not accepted, please enter a number greater than 0. ");
            reader.next();
        }
        return reader.nextFloat();
    }

    /**
     * reads and checks if string input is valid.
     *
     * @param massage      the massage to be printed to get user input
     * @param errorMassage the error message to be printed if the input was not string
     * @return a valid string
     */

    public String getStringInput(String massage, String errorMassage)
    {
        String stringInput;
        reader.useDelimiter("\n");
        boolean stringValid = false;
        do
        {
            printMessage.printMessage(massage + "\n" + ">>> ");
            stringInput = reader.next();

            if (CheckValid.checkString(stringInput))
            {
                stringValid = true;
            } else
            {
                printMessage.printErrorMessage(errorMassage);
            }
        } while (!stringValid);
        return stringInput;
    }

    /**
     * checks if an Integer input is valid.
     *
     * @param massage      the massage to be printed to get user input
     * @param errorMassage the error message to be printed if the input was not valid
     * @return a valid Integer
     */
    public int getIntInput(String massage, String errorMassage)
    {
        int intInput;
        boolean intValid = false;
        do
        {
            printMessage.printMessage(massage + "\n" + ">>> ");

            intInput = readAndCheckIfInputInt();
            if (CheckValid.checkInt(intInput))
            {
                intValid = true;
            } else
            {
                printMessage.printErrorMessage(errorMassage);

            }

        } while (!intValid);
        return intInput;
    }

    /**
     * checks if a float input is valid.
     *
     * @param massage      the massage to be printed to get user input
     * @param errorMassage the error message to be printed if the input was not valid
     * @return a valid float
     */
    public float getFloatInput(String massage, String errorMassage)
    {
        boolean stringValid = false;
        float floatInput;
        do
        {
            printMessage.printMessage(massage + "\n" + ">>> ");

            floatInput = readAndCheckIfInputFloat();
            if (CheckValid.checkFloat(floatInput))
            {
                stringValid = true;
            } else
            {
                printMessage.printErrorMessage(errorMassage);

            }
        } while (!stringValid);
        return floatInput;
    }

    /**
     * asks a user for item number and checks if the string input is valid.
     *
     * @return a valid string that is supposed to be an item number
     */
    public String getItemFromInput()
    {

        return getStringInput("Please type the item number of the item",
            "Please type a valid item number.");

    }


    /**
     * gets the minimum price input from the user.
     *
     * @param massage      the massage to be printed to get user input
     * @param errorMassage the error message to be printed if the input was not valid
     * @return a valid minimum price input
     */
    public int getMinimumPriceInput(String massage, String errorMassage)
    {
        int intInput;
        boolean intValid = false;
        do
        {
            printMessage.printMessage(massage + "\n" + ">>> ");

            intInput = readAndCheckIfInputInt();
            //couldn't use getIntInput method because here the Integer can be 0
            if (intInput >= 0)
            {
                intValid = true;
            } else
            {
                printMessage.printErrorMessage(errorMassage);

            }

        } while (!intValid);
        return intInput;
    }
}
