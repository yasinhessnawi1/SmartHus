package itemdirector;

/**
 *Representations for all the valid categories along with a string with category name.
 *
 * @author Yasin Hessnawi
 * @version 0.0.1 (26.11.22)
 */
public enum Category
{
    OTHER("Other"), FLOOR_LAMINATES("Floor laminates"),
    WINDOWS("Windows"), DOORS("Doors"),
    LUMBER("Lumber");


    private final String categoryInput;

    /**
     * Initialise with the corresponding category input.
     *
     * @param categoryInput The category input.
     */
    private Category(String categoryInput)
    {
        this.categoryInput = categoryInput;
    }

}


