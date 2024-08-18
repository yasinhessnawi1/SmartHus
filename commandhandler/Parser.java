package commandhandler;

import java.util.Scanner;
import utility.InputHandler;

/**
 * This parser reads user input and tries to interpret it as a menu
 * command.
 * The parser has a set of known command words. It checks user input against
 * the command word ordinal, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author Yasin Hessnaiw
 * @version 0.0.1 (08.11.2022)
 */
public class Parser
{
    private final CommandInputs commands;  // holds all valid command inputs
    private final Scanner reader; // source of command input
    private final InputHandler inputHandler;

    /**
     * Create a parser to read from the terminal window.
     *
     * @param reader       the reader from UserInterface
     * @param inputHandler the inputHandler from UserInterface
     */
    public Parser(Scanner reader, InputHandler inputHandler)
    {
        commands = new CommandInputs();
        this.reader = reader;
        this.inputHandler = inputHandler;
    }

    /**
     * Gets the command input from the user and returns the command word
     * associated with the command word ordinal.
     *
     * @return The next command from the user
     */
    public Command getCommand()
    {
        int commandInput =
            inputHandler.getIntInput("Please type a number as shown in the menu:",
                "Please type a valid number as shown in the menu.");
        return new Command(commands.getCommandInput(commandInput),
            commands.getAdjustCommandInput(commandInput),
            commands.getSearchForItemCommandInput(commandInput));
    }

}
