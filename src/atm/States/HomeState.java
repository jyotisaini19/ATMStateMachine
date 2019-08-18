package atm.States;

import atm.Machine;

import java.util.Scanner;

/**
 * Class for home state.
 */
public class HomeState extends AbstractState
{
    private Machine machine;

    public HomeState(Machine machine)
    {
        this.machine = machine;
    }

    @Override
    public void init()
    {
        insertCard();
    }

    private void insertCard()
    {
        boolean isCardInserted = false;

        while(!isCardInserted)
        {
            isCardInserted = askForCardInsertion();
        }

        if (isCardInserted)
        {
            machine.changeState(machine.getCardInsertdState());
        }
        else
        {
            askForCardInsertion();
        }

    }
    private boolean askForCardInsertion()
    {
        System.out.println("Please insert card");
        System.out.println("Inserted (Y/N)");
        Scanner input = new Scanner(System.in);
        String cardInsertInput = input.next();
        return cardInsertInput.equals("Y");
    }
}
