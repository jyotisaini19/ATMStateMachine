package atm.Bank;

/**
 * Class to interact with the bank server.
 */
public class Bank
{

    /**
     * Method to check if the user entered pin is valid atm pin.
     * @param pin
     * @return true when pin is valid false otherwise.
     */
    public boolean isUserValid(int pin)
    {
        return true;
    }

    /**
     * Method to return the current balance.
     * @return
     */
    public String giveAccountBalance()
    {
        return "1000";
    }

    /**
     * Method to check if the transaction is under the limit of account holder balance.
     * @return true when valid.
     */
    public boolean isValidTransaction(long amount)
    {
        return true;
    }
}
