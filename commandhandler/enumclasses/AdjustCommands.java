package commandhandler.enumclasses;

/**
 *Representations for all the valid command words for the adjust menu
 *along with an int that shows command ordinal.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (06.11.22)
 */
public enum AdjustCommands
{
    // A value for each command word along with its
    // corresponding user interface string.
    UNKNOWN(0), DISCOUNT(1), INCREASE(2), DECREASE(3), PRICE(4), BRAND(5), COLOR(6), HEIGHT(7),
    WEIGHT(8), LENGTH(9), CATEGORY(10), BACK(11);

    // The command input of adjust menu.
    private final int adjustCommandInput;

    /**
     * Initialise with the corresponding adjustCommand input.
     *
     * @param adjustCommandInput The command input.
     */
    private AdjustCommands(int adjustCommandInput)
    {
        this.adjustCommandInput = adjustCommandInput;
    }

}
    

