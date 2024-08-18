package userinterface;

import commandhandler.Command;
import commandhandler.Parser;
import commandhandler.enumclasses.AdjustCommands;
import commandhandler.enumclasses.Commands;
import commandhandler.enumclasses.SearchForItemCommands;
import itemdirector.Item;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import register.ItemRegister;
import utility.InputHandler;
import utility.PrintMessage;

/**
 * the heart of the application, every thing in this application is being controlled from here
 * makes the first page the user sees and makes the inputs and outputs works
 * binds other classes together to do all the work the application supposed to do
 * all the functions in the application is also controlled here.
 */
public class UserInterface
{

    private final UserInterfaceStrings strings;
    private final ItemRegister itemRegister;
    private final Scanner reader;
    private final InputHandler inputHandler;
    private final Parser parser;
    private final PrintMessage printMessage;

    /**
     * the constructor to initialize the objects of other classes being used here.
     */
    public UserInterface()
    {
        itemRegister = new ItemRegister();
        reader = new Scanner(System.in);
        printMessage = new PrintMessage();
        inputHandler = new InputHandler(reader, printMessage);
        parser = new Parser(reader, inputHandler);
        strings = new UserInterfaceStrings(printMessage);

    }

    /**
     * starts the application, prints the welcome, help and main menu massages.
     */
    public void startApplication()
    {
        strings.printWelcome();
        strings.printHelp();
        strings.printMainMenu();
        mainMenu();
    }

    /**
     * closes the application if the user wants otherwise it keeps the application running.
     */
    private void mainMenu()
    {

        boolean finished = false;
        while (!finished)
        {
            Command command = parser.getCommand();
            finished = processMainMenuCommand(command);
        }
        strings.printQuitMassage();
        reader.close();
    }

    /**
     * keeps the user in adjust menu until they decide to go back to main menu.
     */
    private void adjustMenu()
    {
        strings.printAdjustMenu();
        boolean goBack = false;
        while (!goBack)
        {
            Command command = parser.getCommand();
            goBack = processAdjustMenuCommand(command);
        }
        strings.printMainMenu();
    }

    /**
     * keeps the user in search menu until they decide to go back to main menu.
     */
    private void searchMenu()
    {
        strings.printSearchForItem();
        boolean goBack = false;
        while (!goBack)
        {
            Command command = parser.getCommand();
            goBack = processSearchMenuCommand(command);
        }
        strings.printMainMenu();
    }

    /**
     * Uses other methods to provide functions that can be used of the user.
     *
     * @param command the command Integer to perform to match with the functions
     * @return if the user wants to quite the application
     */
    private boolean processMainMenuCommand(Command command)
    {
        boolean wantToQuit = false;

        Commands commandInput = command.getCommandInput();

        switch (commandInput)
        {
            case UNKNOWN -> strings.printUnknownInput();
            case ADJUST -> adjustMenu();
            case SEARCH -> searchMenu();
            case SHOW_ALL -> printAllItemsInRegister();
            case SHOW_ALL_IN_CATEGORY ->
            {
                searchForItemsWithSameCategory();
                strings.printMainMenu();
            }
            case REMOVE -> removeAnItem();
            case CREATE -> createItem();
            case SHOW_ALL_IN_OTHER_CATEGORY -> printAllItemsInOtherCategory();
            case QUIT -> wantToQuit = true;
            default -> strings.invalidInput();
        }
        return wantToQuit;
    }

    /**
     * Uses other methods to provide functions that can be used of the user.
     *
     * @param command the command Integer to perform to match with the functions
     * @return if the user wants to go back to Previous menu
     */
    private boolean processAdjustMenuCommand(Command command)
    {
        boolean goBack = false;

        AdjustCommands commandInput = command.getCommandAdjustInput();

        switch (commandInput)
        {
            case UNKNOWN -> strings.printUnknownInput();
            case DISCOUNT -> makeDiscount();
            case INCREASE -> increaseQuantityAvailable();
            case DECREASE -> decreaseQuantityAvailable();
            case PRICE -> editPrice();
            case BRAND -> editBrand();
            case COLOR -> editColor();
            case HEIGHT -> editHeight();
            case WEIGHT -> editWeight();
            case LENGTH -> editLength();
            case CATEGORY -> editCategory();
            case BACK -> goBack = true;
            default -> strings.invalidInput();
        }
        return goBack;
    }

    /**
     * Uses other methods to provide functions that can be used of the user.
     *
     * @param command the command Integer to perform to match with the functions
     * @return if the user wants to go back to Previous menu
     */
    private boolean processSearchMenuCommand(Command command)
    {
        boolean goBack = false;

        SearchForItemCommands commandInput = command.getSearchCommandInput();

        switch (commandInput)
        {
            case UNKNOWN -> strings.printUnknownInput();
            case DESCRIPTION -> searchItemByDescription();
            case NUMBER -> searchForAnItemWithNumber();
            case BRAND -> searchForItemsWithSameBrand();
            case CATEGORY ->
            {
                searchForItemsWithSameCategory();
                strings.printSearchForItem();
            }
            case COLOR -> searchForItemsWithSameColor();
            case COLOR_DESCRIPTION -> searchForColorsToAnItem();
            case COLOR_BRAND -> searchForColorInBrand();
            case COLOR_CATEGORY -> searchForColorInCategory();
            case PRICE_BRAND -> searchInPriceRangeWithBrand();
            case PRICE_CATEGORY -> searchInPriceRangeInCategory();
            case BACK -> goBack = true;
            default -> strings.invalidInput();
        }
        return goBack;
    }

    /**
     * A function used in Adjust menu to make a discount on an item.
     */
    private void makeDiscount()
    {
        String itemToMakeDiscountTo = inputHandler.getItemFromInput();
        int amountDiscount =
            inputHandler.getIntInput("Please type the amount of discount with numbers",
                "Please type an amount from 1 to 100");
        if (amountDiscount <= 100)
        {
            if (itemRegister.findItem(itemToMakeDiscountTo) != null)
            {
                itemRegister.findItem(itemToMakeDiscountTo).discount(amountDiscount);
                printMessage.printMessageLn("Price changed successfully");
                printMessage.printMessageLn(tableForGetInformation());
                printMessage.printMessageLn(
                    itemRegister.findItem(itemToMakeDiscountTo).getInformationOfItem());
                strings.printAdjustMenu();
            } else
            {
                printMessage.printErrorMessage(
                    "The item  you trying to do discount to was not found, try again.");
                strings.printAdjustMenu();
            }
        } else
        {
            printMessage.printErrorMessage("The amount you typed is bigger than 100, "
                + "Please choose another number and try again");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to increase quantity available of an item.
     */

    private void increaseQuantityAvailable()
    {
        String itemToIncreaseQuantityAvailableTo = inputHandler.getItemFromInput();
        int amountIncrement = inputHandler.getIntInput("Please type the amount of increment",
            "Please type an increment number greater than 0.");
        if (itemRegister.findItem(itemToIncreaseQuantityAvailableTo) != null)
        {
            itemRegister.findItem(itemToIncreaseQuantityAvailableTo).increaseQuantityAvailable(
                amountIncrement);
            printMessage.printMessageLn("Quantity available changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToIncreaseQuantityAvailableTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to increase quantity to was not found, try again.");
            strings.printAdjustMenu();

        }
    }

    /**
     * A function used in Adjust menu to decrease quantity available of an item.
     */
    private void decreaseQuantityAvailable()
    {
        String itemToDecreaseQuantityAvailableTo = inputHandler.getItemFromInput();
        int amountDecrement = inputHandler.getIntInput("Please type the amount of decrement",
            "Please type an amount greater than 0.");
        if (itemRegister.findItem(itemToDecreaseQuantityAvailableTo) != null)
        {
            if (amountDecrement <= itemRegister.findItem(
                itemToDecreaseQuantityAvailableTo).getQuantityAvailable())
            {

                itemRegister.findItem(
                    itemToDecreaseQuantityAvailableTo).decreaseQuantityAvailable(amountDecrement);
                printMessage.printMessageLn("Quantity available changed successfully");
                printMessage.printMessageLn(tableForGetInformation());
                printMessage.printMessageLn(
                    itemRegister.findItem(
                        itemToDecreaseQuantityAvailableTo).getInformationOfItem());
                strings.printAdjustMenu();
            } else
            {
                printMessage.printErrorMessage("The number you typed is bigger than quantity "
                    + "available of the item " + itemToDecreaseQuantityAvailableTo
                    + ". Check your input and try again.");
                strings.printAdjustMenu();
            }
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to decrease quantity" + " to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the price of an item.
     */
    private void editPrice()
    {
        String itemToChangePriceTo = inputHandler.getItemFromInput();
        float newPrice = inputHandler.getIntInput("Please type the new price.",
            "Please type a price, it should be greater than 0.");
        if (itemRegister.findItem(itemToChangePriceTo) != null)
        {
            itemRegister.findItem(itemToChangePriceTo).setPrice(newPrice);
            printMessage.printMessageLn("Price changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangePriceTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change price to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the brand name of an item.
     */
    private void editBrand()
    {
        String itemToChangeBrandTo = inputHandler.getItemFromInput();
        String newBrand = inputHandler.getStringInput("Please type the new brand name.",
            "Please type a number greater than 0.");
        if (itemRegister.findItem(itemToChangeBrandTo) != null)
        {
            itemRegister.findItem(itemToChangeBrandTo).setBrandName(newBrand);
            printMessage.printMessageLn("Brand name changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangeBrandTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change brand name" + " to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the color of an item.
     */
    private void editColor()
    {
        String itemToChangeColorTo = inputHandler.getItemFromInput();
        String newColor =
            inputHandler.getStringInput("Please type the new color.", "Please type a valid color.");
        if (itemRegister.findItem(itemToChangeColorTo) != null)
        {
            itemRegister.findItem(itemToChangeColorTo).setColor(newColor);
            printMessage.printMessageLn("Color changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangeColorTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change color to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the height of an item.
     */
    private void editHeight()
    {
        String itemToChangeHeightTo = inputHandler.getItemFromInput();
        float newHeight = inputHandler.getFloatInput("Please type the new height of the item",
            "Please type a height greater than 0.");
        if (itemRegister.findItem(itemToChangeHeightTo) != null)
        {
            itemRegister.findItem(itemToChangeHeightTo).setHeight(newHeight);
            printMessage.printMessageLn("Height changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangeHeightTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change height to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the weight of an item.
     */
    private void editWeight()
    {
        String itemToChangeWeightTo = inputHandler.getItemFromInput();
        float newWeight = inputHandler.getFloatInput("Please type the new weight of the item",
            "Please type a weight greater than 0.");
        if (itemRegister.findItem(itemToChangeWeightTo) != null)
        {
            itemRegister.findItem(itemToChangeWeightTo).setWeight(newWeight);
            printMessage.printMessageLn("Weight changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangeWeightTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change weight to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the length of an item.
     */
    private void editLength()
    {
        String itemToChangeLengthTo = inputHandler.getItemFromInput();
        float newLength = inputHandler.getFloatInput("Please type the new length of the item",
            "Please type a length greater than 0.");
        if (itemRegister.findItem(itemToChangeLengthTo) != null)
        {
            itemRegister.findItem(itemToChangeLengthTo).setLength(newLength);
            printMessage.printMessageLn("Length changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangeLengthTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change length to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in Adjust menu to edit the category of an item.
     */
    private void editCategory()
    {
        String itemToChangeCategoryTo = inputHandler.getItemFromInput();
        int newCategory = inputHandler.getIntInput("Please type a category number",
            "Please type a number from 1 to 4.");
        if (itemRegister.findItem(itemToChangeCategoryTo) != null)
        {
            itemRegister.findItem(itemToChangeCategoryTo).setCategory(newCategory);
            printMessage.printMessageLn("Category changed successfully");
            printMessage.printMessageLn(tableForGetInformation());
            printMessage.printMessageLn(
                itemRegister.findItem(itemToChangeCategoryTo).getInformationOfItem());
            strings.printAdjustMenu();
        } else
        {
            printMessage.printErrorMessage(
                "The item you trying to change category to was not found, try again.");
            strings.printAdjustMenu();
        }
    }

    /**
     * A function used in main menu to remove an item from the register (list).
     */

    private void removeAnItem()
    {
        String itemToRemove = inputHandler.getStringInput("Please type the item number of the item",
            "Please type a valid item name or item number.");
        if (!itemRegister.removeItemByNumber(itemToRemove))
        {
            printMessage.printErrorMessage("The item you want to remove was not found");
            strings.printMainMenu();
        } else
        {
            itemRegister.removeItemByNumber(itemToRemove);
            printMessage.printMessageLn("The item " + itemToRemove
                + " is removed from your list");
            strings.printMainMenu();
        }
    }

    /**
     * A function used in search menu to search for an item by its name.
     */
    private void searchItemByDescription()
    {
        String itemToSearchForDescriptionTo = inputHandler.getItemFromInput();
        List<String> foundItemsByDescription =
            itemRegister.searchForItemByDescription(itemToSearchForDescriptionTo);
        int amountFound = 0;
        if (!foundItemsByDescription.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByDescription)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn("I found totally " + amountFound
                + " item(s) with the name: " + itemToSearchForDescriptionTo);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given name");
            strings.printSearchForItem();
        }
    }

    /**
     * A function used in search menu to search for an item by its number.
     */
    private void searchForAnItemWithNumber()
    {
        String itemToSearchForNumberTo = inputHandler.getItemFromInput();
        List<String> foundItemsByNumber =
            itemRegister.searchForItemByNumber(itemToSearchForNumberTo);
        int amountFound = 0;
        if (!foundItemsByNumber.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByNumber)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "I found all " + amountFound + " item(s) with the item number: "
                    + itemToSearchForNumberTo);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given number");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for an item by its brand.
     */
    private void searchForItemsWithSameBrand()
    {
        String itemToSearchForBrandTo = inputHandler.getStringInput("Please type a brand name:",
            "Brand name you typed is invalid. Please type a valid brand name");
        List<String> foundItemsByBrand = itemRegister.searchForItemByBrand(itemToSearchForBrandTo);
        int amountFound = 0;
        if (!foundItemsByBrand.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByBrand)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "I found totally " + amountFound + "  item(s)with the brand name: "
                    + itemToSearchForBrandTo);
            strings.printSearchForItem();

        } else
        {
            printMessage.printErrorMessage("No item was found by the given brand name");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for items with same category.
     */
    private void searchForItemsWithSameCategory()
    {
        int itemToSearchForCategoryTo =
            inputHandler.getIntInput(strings.displayItemsInCategoryChoices(),
                "Your input is not accepted, please type a number form the menu");
        List<String> foundItemsByCategory =
            itemRegister.searchForItemByCategory(itemToSearchForCategoryTo);
        int amountFound = 0;
        if (!foundItemsByCategory.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByCategory)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "I found all " + amountFound + " item(s) in category: "
                    + itemToSearchForCategoryTo);

        } else
        {
            printMessage.printErrorMessage("No item was found in the given category");
        }
    }

    /**
     * A function used in search menu to search for items with same color.
     */
    private void searchForItemsWithSameColor()
    {
        String itemToSearchForColorTo =
            inputHandler.getStringInput("Please type " + "the color you want",
                "Please Check your input and try again");
        List<String> foundItemsByColor = itemRegister.searchForItemByColor(itemToSearchForColorTo);
        int amountFound = 0;
        if (!foundItemsByColor.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByColor)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "I found these " + amountFound + " item(s) with the color: "
                    + itemToSearchForColorTo);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given color");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for item with specific color.
     */
    private void searchForColorsToAnItem()
    {
        String itemName = inputHandler.getStringInput("Please type the item " + "description",
            "Please type a valid item description");
        String colorToFind =
            inputHandler.getStringInput("Please type in a color", "please type a valid color");
        List<String> foundItemsByColorAndName =
            itemRegister.searchForItemDescriptionAndColor(itemName, colorToFind);
        int amountFound = 0;
        if (!foundItemsByColorAndName.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByColorAndName)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "There is totally " + amountFound + " item(s) of the item " + itemName
                    + " with the color: " + colorToFind);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given color and description");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for a specific color in a brand.
     */
    private void searchForColorInBrand()
    {
        String itemBrand = inputHandler.getStringInput("Please type the brand name:",
            "Please type a valid brand name");
        String itemColor =
            inputHandler.getStringInput("Please type the color", "Please type a valid color");
        List<String> foundItemsByColorAndBrand =
            itemRegister.searchForBrandAndColor(itemBrand, itemColor);
        int amountFound = 0;
        if (!foundItemsByColorAndBrand.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByColorAndBrand)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "Here is all " + amountFound + " item(s) with the brand name " + itemBrand
                    + " and the color: " + itemColor);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given color");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for a specific color in a category.
     */
    private void searchForColorInCategory()
    {
        int category = inputHandler.getIntInput(strings.whereCategoryBelongsChoices(),
            "Your input is not accepted, please type a number as shown in menu");
        String color =
            inputHandler.getStringInput("Please type the color", "Please type a valid color");
        List<String> foundItemsByColorAndCategory =
            itemRegister.searchForItemByColorAndCategory(category, color);
        int amountFound = 0;
        if (!foundItemsByColorAndCategory.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByColorAndCategory)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "There is totally " + amountFound + " item(s) in category "
                    + category + " with the color: " + color);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given category");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for items with same brand in a price range.
     */
    private void searchInPriceRangeWithBrand()
    {
        String brandName = inputHandler.getStringInput("Please type the brand name",
            "Please type a valid brand name");
        int minPrice = inputHandler.getMinimumPriceInput("Please type a minimum price",
            "The number you typed was not accepted, please try again");
        int maxPrice = inputHandler.getIntInput(
            "Please type the maximum price.Should be greater than minimum price)",
            "Your input was not accepted, please try a number greater than 0");
        List<String> foundItemsByPriceBrand =
            itemRegister.searchForItemByPriceInBrand(brandName, minPrice, maxPrice);
        int amountFound = 0;
        if (!foundItemsByPriceBrand.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByPriceBrand)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "I found " + amountFound + " item(s) with the brand name " + brandName
                    + " in the price range from: " + minPrice + " to" + maxPrice);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given brand name");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in search menu to search for items with same category ina price range.
     */
    private void searchInPriceRangeInCategory()
    {
        int category = inputHandler.getIntInput(strings.whereCategoryBelongsChoices(),
            "Your input is not accepted, please type a number from the menu");
        int minPriceCategory = inputHandler.getMinimumPriceInput(
            "Please type the minimum price", "Please type a number bigger than 0");
        int maxPriceCategory = inputHandler.getIntInput(
            "Please type the maximum price." + "(Should be greater than minimum price",
            "Please type a number bigger than 0");
        if (minPriceCategory >= maxPriceCategory)
        {
            minPriceCategory = inputHandler.getIntInput("Please type the minimum price",
                "Please type a number greater than 0");
            maxPriceCategory = inputHandler.getIntInput(
                "Please type the maximum price." + "(Should be greater than minimum price",
                "Please type a number greater than 0");
        }
        List<String> foundItemsByPriceAndCategory =
            itemRegister.searchForItemByPriceInCategory(category, minPriceCategory,
                maxPriceCategory);
        int amountFound = 0;
        if (!foundItemsByPriceAndCategory.isEmpty())
        {
            printMessage.printMessageLn(tableForGetInformation());
            for (String item : foundItemsByPriceAndCategory)
            {
                printMessage.printMessageLn(item);
                amountFound += 1;
            }
            printMessage.printMessageLn(
                "I found " + amountFound + " item(s) in category " + category
                    + " in the price range from: " + minPriceCategory + " to: " + maxPriceCategory);
            strings.printSearchForItem();
        } else
        {
            printMessage.printErrorMessage("No item was found by the given category.");
            strings.printSearchForItem();

        }
    }

    /**
     * A function used in main menu to create a new item and add it to the register(list).
     */
    private void createItem()
    {
        String descriptionInput =
            inputHandler.getStringInput("Please type the item description. ",
                "Description should contains numbers and characters and not empty. ");
        String itemNumberInput = inputHandler.getStringInput(
            "Please type the item number. ",
            "Please type a valid item number. Number should \n"
                + " contains numbers and characters and not empty. ");
        String brandNameInput = inputHandler.getStringInput("Please type the brand name. ",
            "Brand name should contain characters and not numbers or empty. ");
        String colorInput = inputHandler.getStringInput("Please type the item color. ",
            "Color should contain characters and not numbers or empty. ");
        float priceInput = inputHandler.getFloatInput("Please type the item price. ",
            "Your input is not accepted, please type a valid color. "
                + "Color should contain characters. ");
        int quantityAvailableInput =
            inputHandler.getIntInput("Please type the item quantity Available. ",
                "Your quantity available input is not accepted,"
                    + " please type a number greater than 0. ");
        float lengthInput = inputHandler.getFloatInput("Please type the item length.",
            "Please type a valid length. Length should be a number greater than 0.");
        float heightInput = inputHandler.getFloatInput("Please type the item height.",
            "Please type a valid height. Height should be a number greater than 0.");
        float weightInput = inputHandler.getFloatInput("Please type the item weight.",
            "Please type a valid weight. Weight should be a number greater than 0.");
        int categoryInput = inputHandler.getIntInput(strings.creatItemCategoryChoices(),
            "Your input is not accepted, please type a number between 1 and 4.");
        Item itemToCreate =
            new Item(itemNumberInput, priceInput, quantityAvailableInput, descriptionInput,
                categoryInput, colorInput, brandNameInput);
        itemToCreate.setLength(lengthInput);
        itemToCreate.setWeight(weightInput);
        itemToCreate.setHeight(heightInput);
        if (itemRegister.addItem(itemToCreate))
        {
            printMessage.printMessageLn("Item added successfully.");
            printMessage.printMessageLn(
                tableForGetInformation() + itemToCreate.getInformationOfItem());
            strings.printMainMenu();
        } else
        {
            printMessage.printErrorMessage("Item already exist try again.");
            strings.printMainMenu();
        }

    }

    /**
     * A function used in main menu to print all the items in the register(list).
     */
    private void printAllItemsInRegister()
    {
        Iterator<Item> listIterator = itemRegister.getListOfItems();
        int foundItems = 0;
        if (listIterator.hasNext())
        {
            printMessage.printMessageLn(tableForGetInformation());
            while (listIterator.hasNext())
            {
                printMessage.printMessageLn(listIterator.next().getInformationOfItem());
                foundItems += 1;
            }
            printMessage.printMessageLn("There is " + foundItems + " item(s) in you list.");

        } else
        {
            printMessage.printErrorMessage("The list is empty, try create some items first.");
        }

        strings.printMainMenu();
    }

    /**
     * Searches for the items with category OTHER.
     */
    public void printAllItemsInOtherCategory()
    {

        Iterator<Item> listIterator = itemRegister.getListOfItems();
        int foundItems = 0;
        if (listIterator.hasNext())
        {
            printMessage.printMessageLn(tableForGetInformation());
            while (listIterator.hasNext())
            {
                Item item = listIterator.next();
                if (item.getCategory().equalsIgnoreCase("UNKNOWN"))
                {
                    printMessage.printMessageLn(item.getInformationOfItem());
                    foundItems += 1;
                }
            }
            printMessage.printMessageLn("There is " + foundItems
                + " item(s) with unknown category.");
        } else
        {
            printMessage.printErrorMessage("There is no items with unknown category.");
        }
        strings.printMainMenu();
    }

    /**
     * a table to be printed tha shows the header of the information names of items so that then
     * item's Information could be printed.
     *
     * @return a string that represents a table with information names of items
     */
    private String tableForGetInformation()
    {
        StringBuilder itemTableInfo = new StringBuilder();
        itemTableInfo.append("********************".repeat(10));
        itemTableInfo.append("\n");
        itemTableInfo.append(String.format("|" + "%-19s", "Item number"));
        itemTableInfo.append(String.format("|" + "%-19s", "Item description"));
        itemTableInfo.append(String.format("|" + "%-19s", "Quantity available"));
        itemTableInfo.append(String.format("|" + "%-19s", "Price"));
        itemTableInfo.append(String.format("|" + "%-19s", "Color"));
        itemTableInfo.append(String.format("|" + "%-19s", "Brand Name"));
        itemTableInfo.append(String.format("|" + "%-19s", "Category"));
        itemTableInfo.append(String.format("|" + "%-19s", "Height"));
        itemTableInfo.append(String.format("|" + "%-19s", "Length"));
        itemTableInfo.append(String.format("|" + "%-19s", "Weight")).append("|");
        itemTableInfo.append("\n");
        itemTableInfo.append("********************".repeat(10));
        return String.valueOf(itemTableInfo);
    }
}
