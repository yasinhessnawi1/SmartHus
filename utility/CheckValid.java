package utility;

/**
 * Checks if datatype are valid.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (06.10.2022)
 */
public class CheckValid
{
    /**
     * empty constructor.
     */
    private CheckValid()
    {
        //nothing to initialize here. Just to not get a default constructor.
    }

    /**
     * Check's if a string is valid or not.
     *
     * @param stringToCheck the string to be checked
     * @return validString returns if string is valid
     */

    public static boolean checkString(String stringToCheck)
    {
        boolean validString;
        validString = !stringToCheck.isEmpty()
            && !stringToCheck.isBlank();
        return validString;
    }


    /**
     * Check's if an integer is valid or not.
     *
     * @param intToCheck the integer to be checked
     * @return validInt check if integer is valid
     */
    public static boolean checkInt(int intToCheck)
    {
        boolean validInt;
        validInt = intToCheck > 0;
        return validInt;
    }

    /**
     * Check's if a float is valid or not.
     *
     * @param floatToCheck the float to be checked
     * @return validFloat returns if float is valid
     */

    public static boolean checkFloat(float floatToCheck)
    {
        boolean validFloat;
        validFloat = floatToCheck > 0;
        return validFloat;
    }


}
