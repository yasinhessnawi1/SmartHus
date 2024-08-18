package commandhandler;

import commandhandler.enumclasses.AdjustCommands;
import commandhandler.enumclasses.Commands;
import commandhandler.enumclasses.SearchForItemCommands;

/**
 * Holds information about a command input that was issued by the user.
 * A command currently consists of an integer for all the menus.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (06.11.22)
 */

public class Command
{
    private final Commands commands;
    private final AdjustCommands adjustCommands;
    private final SearchForItemCommands searchForItemCommands;

    /**
     * Create commands enums objects.
     *
     * @param commands the main menu commands
     * @param adjustCommands the Adjust menu Commands
     * @param searchForItemCommands  the search menu Commands
     */
    public Command(Commands commands, AdjustCommands adjustCommands,
                    SearchForItemCommands searchForItemCommands)
    {
        this.commands = commands;
        this.adjustCommands = adjustCommands;

        this.searchForItemCommands = searchForItemCommands;

    }

    /**
     * Return the command words of the main menu.
     *
     * @return The command words.
     */
    public Commands getCommandInput()
    {
        return commands;
    }

    /**
     * Return the command words of the adjust menu.
     *
     * @return The command word.
     */
    public AdjustCommands getCommandAdjustInput()
    {
        return adjustCommands;
    }


    /**
     * Return the command words of search menu.
     *
     * @return The command word.
     */
    public SearchForItemCommands getSearchCommandInput()
    {
        return searchForItemCommands;
    }



}




