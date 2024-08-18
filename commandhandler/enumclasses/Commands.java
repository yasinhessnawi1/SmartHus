package commandhandler.enumclasses;

/**
 * Representations for all the valid command words for the main menu
 * along with an int that shows command ordinal.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (06.11.22)
 */
public enum Commands
{
    // A value for each command word along with its
    // corresponding user interface string.
    UNKNOWN(0), CREATE(1), ADJUST(2), SEARCH(3),
    SHOW_ALL(4), SHOW_ALL_IN_CATEGORY(5), REMOVE(6),
    SHOW_ALL_IN_OTHER_CATEGORY(7), QUIT(8);

    // The main menu command input.
    private final int commandInput;

    /**
     * Initialise with the corresponding command input.
     *
     * @param commandInput The command input.
     */
    private Commands(int commandInput)
    {
        this.commandInput = commandInput;
    }

}
    

