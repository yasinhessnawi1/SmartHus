import userinterface.UserInterface;

/**
 * the application main class, it starts the application and runs everything.
 */
public class SmartHusAs
{
    /**
     * the main function that starts the application.
     *
     * @param args The command line parameters.
     */
    public static void main(String[] args)
    {
        UserInterface userInterface = new UserInterface();
        userInterface.startApplication();

    }
}
