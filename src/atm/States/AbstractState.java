package atm.States;

/**
 * Abstract class for atm.States of an ATM.
 */
public abstract class AbstractState
{
    /**
     * start method for a particular state.
     */
    public abstract void init();

    /**
     * Method to perform cancellation of transaction at any point of time.
     */
    public void cancel()
    {
        //cancel transaction
        cancelTransaction();
        //eject card.
        ejectCard();
    }

    private void cancelTransaction()
    {
        System.out.println("Transaction cancelled!!");
    }

    private void ejectCard()
    {
        System.out.println("Card Ejected! Collect your card.");
    }
}
