package userinterface;

import utility.PrintMessage;

/**
 * holds control of the menus and UserInterface long Strings.
 */
public class UserInterfaceStrings
{
    private final PrintMessage printMessage;

    /**
     * constructor to initialize printMassage.
     *
     * @param printMessage the object of print massage from UserInterface
     */
    public UserInterfaceStrings(PrintMessage printMessage)
    {
        this.printMessage = printMessage;
    }

    /**
     * prints the main menu string.
     */
    public void printMainMenu()
    {
        printMessage.printMessage("""
                        
            *******************************************************************************
            * [1]Type number 1 to create an item and added to your list.                  *
            * [2]Type number 2 to adjust an item.(increase or decrease quantity available,*
            *    discount,change price, color, category, height, length, weight...).      *
            * [3]Type number 3 to search for an item.                                     *
            * [4]Type number 4 to show all the items in your list.                        *
            * [5]Type number 5 to show all the items in a category.                       *
            * [6]Type number 6 to remove an item from your list.                          *
            * [7]Type number 7 to show all items with category OTHER.                     *
            * [8]Type number 8 to quite the application.                                  *
            *******************************************************************************
            """);
    }

    /**
     * prints adjust menu string.
     */
    public void printAdjustMenu()
    {
        printMessage.printMessage("""
                        
            *******************************************************
            * [1]Type 1 to make a discount on item.               *
            * [2]Type 2 to increase quantity available of an item.*
            * [3]Type 3 to decrease quantity available of an item.*
            * [4]Type 4 to change the price of an item.           *
            * [5]Type 5 to change the brand name of an item.      *
            * [6]Type 6 to change the color of an item.           *
            * [7]Type 7 to change the height of an item.          *
            * [8]Type 8 to change the weight of an item.          *
            * [9]Type 9 to change the length of an item.          *
            * [10]Type 10 to change the category of an item.      *
            * [11]Type 11 to go Back.                             *
            *******************************************************
                        
            """);
    }

    /**
     * prints the help massage to the user.
     */
    public void printHelp()
    {
        printMessage.printMessage("""
                        
            *************************************************************************************
            * The application is easy to use, please follow the instructions.                   *
            * In the menus please enter the number asked in order to to perform an action.      *
            * Type the number after the symbol ">>>"                                            *
            * If you enter any thing and gets a red massage, check your input and try again.    *
            * To use the functions of this application you have at least to make 1 item. To make*
            * one please type number 1 in the first menu                                        *
            *************************************************************************************
                        
            """);
    }

    /**
     * prints search for item menu string.
     */
    public void printSearchForItem()
    {
        printMessage.printMessage("""
                        
            ******************************************************************
            * [1]Type 1 to search for an item by it's name.                  *
            * [2]Type 2 to search for an item by it's Number.                *
            * [3]Type 3 to search for an item by it's brand name.            *
            * [4]Type 4 to search for an item by it's category.              *
            * [5]Type 5 to search for an item by it's color.                 *
            * [6]Type 6 to search for a color to a specific item.            *
            * [7]Type 7 to search for a color to a specific brand.           *
            * [8]Type 8 to search for a color to a specific category.        *
            * [9]Type 9 to search for a brand name in a specific price range.*
            * [10]Type 10 to search in a category in a specific price rage.  *
            * [11]Type 11 to go back.                                        *
            ******************************************************************
                       
            """);
    }

    /**
     * prints a welcome string massage of the application.
     */
    public void printWelcome()
    {
        printMessage.printMessage("""
                        
            ***********************Smart Hus AS************************
            * Welcome to Smart Hus AS application!                    *
            * This application is called warehouse management system, *
            * and  will help you manage your inventory.               *
            ***********************************************************
                        
            """);


    }

    /**
     * prints unknown input error message.
     */
    public void printUnknownInput()
    {
        printMessage.printErrorMessage("Unknown number. Please type a number from the menu.");
    }

    /**
     * prints quit massage string.
     */
    public void printQuitMassage()
    {
        printMessage.printMessage("""
                        
            ***************************************
            * Thank you for using the application.*
            * Have a nice day. Good bye.          *
            ***************************************
                        
            """);
    }

    /**
     * prints a category menu for displaying items in a category.
     *
     * @return the menu of categories
     */

    public String displayItemsInCategoryChoices()
    {
        return (""" 
                
            Please enter the number of the category :
            *********************************************************************************
            * [1]Please enter 1 if you want to display all items in floor laminates.        *
            * [2]Please enter 2 if you want to display all items in windows.                *
            * [3]Please enter 3 if you want to display all items in doors.                  *
            * [4]Please enter 4 if you want to display all items in lumber.                 *
            *********************************************************************************
                        
            """);
    }

    /**
     * prints a category menu to know witch Integer belongs to witch category.
     *
     * @return the menu of categories
     */
    public String whereCategoryBelongsChoices()
    {
        return """
                        
            Please enter the number of the category :
            *****************************************************************************
            * [1]Please enter 1 if the item belongs to floor laminates.                 *
            * [2]Please enter 2 if the item belongs to windows.                         *
            * [3]Please enter 3 if the item belongs to doors.                           *
            * [4]Please enter 4 if the item belongs to lumber.                          *
            *****************************************************************************
                        
            """;
    }

    /**
     * prints a category menu to be used for create item method.
     *
     * @return the menu of categories
     */
    public String creatItemCategoryChoices()
    {
        return """
                        
            Please enter item category.
            **************************************************************************
            * [1]Please enter 1 if the item belongs to floor laminates.              *
            * [2]Please enter 2 if the item belongs to windows.                      *
            * [3]Please enter 3 if the item belongs to doors.                        *
            * [4]Please enter 4 if the item belongs to lumber.                       *
            * (If you type other numbers your item category will be sett to OTHER.   *
            * You can change it again in adjust menu).                               *
            **************************************************************************
                        
            """;
    }

    /**
     * prints an invalid input error message.
     */
    public void invalidInput()
    {
        printMessage.printMessage("Your input was not accepted, please try again");
    }

}
