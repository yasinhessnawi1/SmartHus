package itemdirector;

import utility.CheckValid;

/**
 * Represents items in the warehouse.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (06.10.2022)
 */


public class Item
{
    private String itemNumber;
    private int quantityAvailable;
    private float price;
    private String itemDescription;
    private String brandName;
    private float weight;
    private float length;
    private float height;
    private String color;
    private Category category;


    /**
     * a constructor to initialise important fields.
     *
     * @param itemNumber        item number value
     * @param price             item's price
     * @param quantityAvailable total available quantity of item
     * @param itemDescription   item's description
     * @param brandName         item's brand name
     * @param category          item's category
     * @param color             item's color
     */
    public Item(String itemNumber, float price, int quantityAvailable, String itemDescription,
                int category, String color, String brandName)
    {
        setItemNumber(itemNumber);
        setItemDescription(itemDescription);
        setPrice(price);
        setQuantityAvailable(quantityAvailable);
        setCategory(category);
        setColor(color);
        setBrandName(brandName);

    }

    /**
     * Gets the item's number.
     *
     * @return the item's number
     */
    public String getItemNumber()
    {
        return itemNumber;
    }

    /**
     * Set's or change item's number.
     *
     * @param itemNumber the item number to be set
     */
    private void setItemNumber(String itemNumber)
    {
        if (CheckValid.checkString(itemNumber))
        {
            this.itemNumber = itemNumber;
        }
    }

    /**
     * Gets the item's description.
     *
     * @return the item's description
     */

    public String getItemDescription()
    {
        return itemDescription;
    }

    /**
     * Set's or change item's description.
     *
     * @param itemDescription the description to be set
     */

    private void setItemDescription(String itemDescription)
    {
        if (CheckValid.checkString(itemDescription))
        {
            this.itemDescription = itemDescription;
        }
    }

    /**
     * Gets the item's brand name.
     *
     * @return the item's brand name
     */

    public String getBrandName()
    {
        return brandName;
    }

    /**
     * Set's or change item's brand name.
     *
     * @param brandName the brand name to be set
     */

    public void setBrandName(String brandName)
    {
        if (CheckValid.checkString(brandName))
        {
            this.brandName = brandName;
        }
    }

    /**
     * Gets the item's price.
     *
     * @return the item's price
     */

    public float getPrice()
    {
        return price;
    }

    /**
     * Set's or change item's price.
     *
     * @param price the price to be set
     */
    public void setPrice(float price)
    {
        if (CheckValid.checkFloat(price))
        {
            this.price = price;
        }
    }

    /**
     * Gets the item's weight.
     *
     * @return the item's weight
     */

    public float getWeight()
    {
        return weight;
    }

    /**
     * Set's or change item's weight.
     *
     * @param weight the weight to be set
     */

    public void setWeight(float weight)
    {
        if (CheckValid.checkFloat(weight))
        {
            this.weight = weight;
        }
    }

    /**
     * Gets the item's height.
     *
     * @return the item's height
     */

    public float getHeight()
    {
        return height;
    }

    /**
     * Set's or change item's height.
     *
     * @param height the height to be set
     */

    public void setHeight(float height)
    {
        if (CheckValid.checkFloat(height))
        {
            this.height = height;
        }
    }

    /**
     * Gets the item's length.
     *
     * @return the item's length
     */

    public float getLength()
    {
        return length;
    }

    /**
     * Set's or change item's length.
     *
     * @param length the length to be set
     */

    public void setLength(float length)
    {
        if (CheckValid.checkFloat(length))
        {
            this.length = length;
        }
    }

    /**
     * Gets the item's color.
     *
     * @return the item's color
     */

    public String getColor()
    {
        return color;
    }

    /**
     * Set's or change item's color.
     *
     * @param color the color to be set
     */

    public void setColor(String color)
    {
        if (CheckValid.checkString(color))
        {
            this.color = color;
        }
    }

    /**
     * Gets the quantity available of an item.
     *
     * @return the quantity available of an item
     */

    public int getQuantityAvailable()
    {
        return quantityAvailable;
    }

    /**
     * Set's or change the number of quantity available of an  items.
     *
     * @param quantityAvailable the number of available items to be set
     */

    private void setQuantityAvailable(int quantityAvailable)
    {
        if (CheckValid.checkInt(quantityAvailable))
        {
            this.quantityAvailable = quantityAvailable;
        }
    }

    /**
     * Gets the item's category.
     *
     * @return the item's category
     */

    public String getCategory()
    {
        return category.name();
    }

    /**
     * Set's or change item's category.
     *
     * @param categoryNr the category to be set
     */

    public void setCategory(int categoryNr)
    {
        CategoryHandler categories = new CategoryHandler();
        this.category = categories.getCategoryInput(categoryNr);

    }

    /**
     * Gets the item's category.
     *
     * @return the item's category
     */

    public int getCategoryOrdinal()
    {
        return category.ordinal();
    }

    /**
     * Returns item information for printing them out.
     *
     * @return returns item information
     */
    public String getInformationOfItem()
    {

        StringBuilder itemInfo = new StringBuilder();
        itemInfo.append("\n");
        itemInfo.append(String.format("|" + "%-19.19s", getItemNumber()));
        itemInfo.append(String.format("|" + "%-19.19s", getItemDescription()));
        itemInfo.append(String.format("|" + "%-19.19s", getQuantityAvailable()));
        itemInfo.append(String.format("|" + "%-19.19s", getPrice()));
        itemInfo.append(String.format("|" + "%-19.19s", getColor()));
        itemInfo.append(String.format("|" + "%-19.19s", getBrandName()));
        itemInfo.append(String.format("|" + "%-19.19s", getCategory()));
        itemInfo.append(String.format("|" + "%-19.19s", getHeight()));
        itemInfo.append(String.format("|" + "%-19.19s", getLength()));
        itemInfo.append(String.format("|" + "%-19.19s", getWeight())).append("|");
        itemInfo.append("\n");
        itemInfo.append("********************".repeat(10));
        return String.valueOf(itemInfo);
    }


    /**
     * Increase the quantity of available item.
     *
     * @param amount the amount to be added to quantity available
     */

    public void increaseQuantityAvailable(int amount)
    {
        if (CheckValid.checkInt(amount))
        {
            quantityAvailable += amount;
        }
    }

    /**
     * Decrease the quantity of available item.
     *
     * @param amount the amount to be subtracted from quantity available
     */
    public void decreaseQuantityAvailable(int amount)
    {
        if (CheckValid.checkInt(amount))
        {
            quantityAvailable -= amount;
        }
    }

    /**
     * Makes a discount for an item.
     *
     * @param amount the amount of discount
     */
    public void discount(int amount)
    {

        if (amount > 0 && amount <= 100)
        {
            float discountPrice = (price * amount) / 100;
            this.price -= discountPrice;
        }
    }


}

