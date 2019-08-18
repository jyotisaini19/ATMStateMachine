package atm.States;

import atm.Machine;

/**
 * State to check the balance of user bank account.
 */
public class CheckBalanceState extends AbstractState
{
    private Machine machine;

    public CheckBalanceState(Machine machine)
    {
        this.machine = machine;
    }

    @Override
    public void init()
    {

    }
}
