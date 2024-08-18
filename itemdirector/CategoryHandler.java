package itemdirector;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds information about a category input that was issued by the user.
 * A category currently consists of an integer for the values and names of the categories.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (26.11.22)
 */
public class CategoryHandler
{
    private final Map<Integer, Category> validCategory;

    /**
     * Create category enum object.
     */
    public CategoryHandler()
    {
        validCategory = new HashMap<>();
        for (Category category : Category.values())
        {
            if (category != Category.OTHER)
            {
                validCategory.put(category.ordinal(), category);
            }
        }
    }

    /**
     * Find the category ordinal associated with categories name from the enum.
     *
     * @param categoryInput The integer to look up.
     * @return The category corresponding to category name ordinal, or OTHER
     *        if it is not a valid category.
     */
    public Category getCategoryInput(int categoryInput)
    {
        Category category = validCategory.get(categoryInput);
        if (categoryInput > 0 && categoryInput <= validCategory.size())
        {
            return category;
        } else
        {
            return Category.OTHER;
        }
    }

}
