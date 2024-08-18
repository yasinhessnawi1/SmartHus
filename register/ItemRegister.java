package register;

import itemdirector.Item;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Holds control of items when created. Holds control of the list items were puts in.
 *
 * @author yasinhessnawi
 * @version 0.0.1 (26.10.22)
 */
public class ItemRegister

{
    private final Set<Item> listOfItems;
    private final ArrayList<String> searchResult;


    /**
     * Constructor without parameters that makes new list of items and a list for search results.
     */
    public ItemRegister()
    {
        listOfItems = new HashSet<>();
        searchResult = new ArrayList<>();

    }

    /**
     * Returns the list of items to other classes.
     *
     * @return list of items iterator
     */
    public Iterator<Item> getListOfItems()
    {
        return listOfItems.iterator();
    }


    /**
     * checks if the new item is valid.
     *
     * @param newItem the item to be checked
     * @return the item is valid or not
     */
    private boolean checkItem(Item newItem)
    {
        Iterator<Item> iterator = listOfItems.iterator();
        boolean validItem = false;
        if (listOfItems.isEmpty())
        {
            listOfItems.add(newItem);
            validItem = true;
            return validItem;
        } else
        {
            while (iterator.hasNext())
            {
                Item item = iterator.next();
                if (!item.getItemNumber().equalsIgnoreCase(newItem.getItemNumber())
                    && (!item.getItemDescription().equalsIgnoreCase(newItem.getItemDescription())
                    || !item.getBrandName().equalsIgnoreCase(newItem.getBrandName())
                    || item.getPrice() != newItem.getPrice()
                    || !item.getColor().equalsIgnoreCase(newItem.getColor())
                    || item.getHeight() != newItem.getHeight()
                    || item.getLength() != newItem.getLength()
                    || item.getWeight() != newItem.getWeight()))
                {
                    validItem = true;

                } else
                {
                    validItem = false;
                    return validItem;
                }
            }
        }
        return validItem;
    }

    /**
     * Adds a new item to list of items.
     *
     * @param newItem the item to be added to list of items
     * @return the item was added or not
     */
    public boolean addItem(Item newItem)
    {
        if (checkItem(newItem))
        {
            listOfItems.add(newItem);
            return true;
        }
        return false;
    }


    /**
     * Searches for an item by its description.
     *
     * @param descriptionToSearchFor the description to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByDescription(String descriptionToSearchFor)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if (item.getItemDescription().contains(descriptionToSearchFor)
                || item.getItemDescription().equalsIgnoreCase(descriptionToSearchFor))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;

    }


    /**
     * Searches for an item by its number.
     *
     * @param numberToSearchFor the item number to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByNumber(String numberToSearchFor)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if (item.getItemNumber().contains(numberToSearchFor)
                || item.getItemNumber().equalsIgnoreCase(numberToSearchFor))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for an item by its brand name.
     *
     * @param brandToSearchFor the item brand name to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByBrand(String brandToSearchFor)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if (item.getBrandName().contains(brandToSearchFor)
                || item.getBrandName().equalsIgnoreCase(brandToSearchFor))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for an item by its category.
     *
     * @param categoryToSearchFor the item category to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByCategory(int categoryToSearchFor)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if (item.getCategoryOrdinal() == categoryToSearchFor)
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }


    /**
     * Searches for an item by its color.
     *
     * @param colorToSearchFor the item color to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByColor(String colorToSearchFor)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if (item.getColor().contains(colorToSearchFor)
                || item.getColor().equalsIgnoreCase(colorToSearchFor))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for a color to a specific item.
     *
     * @param itemDescription the item description to be searched for a specific color for
     * @param color           the items color to be searched for
     * @return list of found items
     */
    public List<String> searchForItemDescriptionAndColor(String itemDescription, String color)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if ((item.getItemDescription().equalsIgnoreCase(itemDescription)
                || item.getItemDescription().contains(itemDescription))
                && (item.getColor().equalsIgnoreCase(color) || item.getColor().contains(color)))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for items with same color to a specific brand.
     *
     * @param brand the item brand name to be searched for a specific color for
     * @param color the items color to be searched for
     * @return list of found items
     */
    public List<String> searchForBrandAndColor(String brand, String color)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if ((item.getBrandName().equalsIgnoreCase(brand)
                || item.getBrandName().contains(brand))
                && (item.getColor().equalsIgnoreCase(color) || item.getColor().contains(color)))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for items with same color in a category.
     *
     * @param category the item category to be searched for a specific color for
     * @param color    the items color to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByColorAndCategory(int category, String color)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if ((item.getCategoryOrdinal() == category)
                && (item.getColor().equalsIgnoreCase(color) || item.getColor().contains(color)))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for items in a specific brand in a price range.
     *
     * @param brand    the item brand to be searched for
     * @param minPrice the minimum price to be searched for
     * @param maxPrice the maximum price to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByPriceInBrand(String brand, int minPrice, int maxPrice)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if ((item.getPrice() >= minPrice && item.getPrice() <= maxPrice)
                && (item.getBrandName().equalsIgnoreCase(brand)
                || item.getBrandName().contains(brand)))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * Searches for items in a category in price range.
     *
     * @param category the item category to be searched for
     * @param minPrice the minimum price to be searched for
     * @param maxPrice the maximum price to be searched for
     * @return list of found items
     */
    public List<String> searchForItemByPriceInCategory(int category, int minPrice, int maxPrice)
    {
        searchResult.clear();
        for (Item item : listOfItems)
        {
            if ((item.getPrice() >= minPrice && item.getPrice() <= maxPrice)
                && (item.getCategoryOrdinal() == category))
            {
                searchResult.add(item.getInformationOfItem());
            }
        }
        return searchResult;
    }

    /**
     * checks if an item is in the list.
     *
     * @param itemToSearchFor the item to be checked
     * @return the item if it is found or null if not
     */
    public Item findItem(String itemToSearchFor)
    {
        for (Item item : listOfItems)
        {
            if (item.getItemNumber().contains(itemToSearchFor)
                || item.getItemNumber().equalsIgnoreCase(itemToSearchFor))
            {
                return item;
            }
        }
        return null;
    }

    /**
     * removes chosen item from list of items.
     *
     * @param itemToRemove item number of the item to remove from list of items
     * @return true if the item was removed and false if not
     */
    public boolean removeItemByNumber(String itemToRemove)
    {
        boolean itemRemoved = false;
        Iterator<Item> itemListIterator = listOfItems.iterator();
        while (itemListIterator.hasNext())
        {
            if (itemListIterator.next().getItemNumber().equalsIgnoreCase(itemToRemove))
            {
                itemListIterator.remove();
                itemRemoved = true;
            } else
            {
                itemRemoved = false;
            }
        }
        return itemRemoved;
    }
}
