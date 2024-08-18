package commandhandler.enumclasses;

/**
 * Representations for all the valid command words for the search menu
 * along with an int that shows command ordinal.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (20.11.22)
 */
public enum SearchForItemCommands
{
    UNKNOWN(0), DESCRIPTION(1), NUMBER(2),
    BRAND(3), CATEGORY(4), COLOR(5),
    COLOR_DESCRIPTION(6), COLOR_BRAND(7), COLOR_CATEGORY(8),
    PRICE_BRAND(9), PRICE_CATEGORY(10), BACK(11);


    // The searchCommand input.
    private final int commandInput;

    /**
     * Initialise with the corresponding searchCommand input.
     *
     * @param commandInput The command input.
     */
    private SearchForItemCommands(int commandInput)
    {
        this.commandInput = commandInput;
    }


}
