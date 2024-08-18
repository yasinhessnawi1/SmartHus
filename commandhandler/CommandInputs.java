package commandhandler;

import commandhandler.enumclasses.AdjustCommands;
import commandhandler.enumclasses.Commands;
import commandhandler.enumclasses.SearchForItemCommands;
import java.util.HashMap;
import java.util.Map;

/**
 * This class holds an enumeration of all command inputs known to the application.
 * It is used to recognise commands as they are typed in as Integers.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (05.11.22)
 */

public class CommandInputs
{

    private final Map<Integer, Commands> validCommands;
    private final Map<Integer, AdjustCommands> adjustValidCommands;
    private final Map<Integer, SearchForItemCommands> searchForItemCommands;

    /**
     * Constructor - initialise  command inputs.
     */
    public CommandInputs()
    {
        validCommands = new HashMap<>();
        adjustValidCommands = new HashMap<>();
        searchForItemCommands = new HashMap<>();

        for (Commands command : Commands.values())
        {
            if (command != Commands.UNKNOWN)
            {
                validCommands.put(command.ordinal(), command);
            }
        }
        for (AdjustCommands adjustCommand : AdjustCommands.values())
        {
            if (adjustCommand != AdjustCommands.UNKNOWN)
            {
                adjustValidCommands.put(adjustCommand.ordinal(), adjustCommand);
            }
        }
        for (SearchForItemCommands searchForItemCommand : SearchForItemCommands.values())
        {
            if (searchForItemCommand != SearchForItemCommands.UNKNOWN)
            {
                this.searchForItemCommands.put(searchForItemCommand.ordinal(),
                    searchForItemCommand);
            }
        }
    }

    /**
     * Find the command ordinal associated with a main menu enum command words.
     *
     * @param commandInput The integer to look up.
     * @return The CommandWord corresponding to Command input ordinal, or UNKNOWN
     *        if it is not a valid command input.
     */
    public Commands getCommandInput(int commandInput)
    {
        Commands command = validCommands.get(commandInput);
        if (commandInput > 0 && commandInput <= validCommands.size())
        {
            return command;
        } else
        {
            return Commands.UNKNOWN;
        }
    }

    /**
     * Find the adjustCommand ordinal associated with adjust enum command words.
     *
     * @param commandInput The integer to look up.
     * @return The CommandWord corresponding to adjust command input ordinal, or UNKNOWN
     *        if it is not a valid command word.
     */
    public AdjustCommands getAdjustCommandInput(int commandInput)
    {
        AdjustCommands adjustCommand = adjustValidCommands.get(commandInput);
        if (commandInput > 0 && commandInput <= adjustValidCommands.size())
        {
            return adjustCommand;
        } else
        {
            return AdjustCommands.UNKNOWN;
        }
    }

    /**
     * Find the searchCommand ordinal associated with search enum command words.
     *
     * @param commandInput The integer to look up.
     * @return The CommandWord corresponding to searchCommand input ordinal, or UNKNOWN
     *        if it is not a valid command word.
     */
    public SearchForItemCommands getSearchForItemCommandInput(int commandInput)
    {
        SearchForItemCommands command = searchForItemCommands.get(commandInput);
        if (commandInput > 0 && commandInput <= searchForItemCommands.size())
        {
            return command;
        } else
        {
            return SearchForItemCommands.UNKNOWN;
        }
    }

}
