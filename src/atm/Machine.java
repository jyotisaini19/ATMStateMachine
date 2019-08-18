package atm;

import atm.States.AbstractState;
import atm.States.CardInsertedState;
import atm.States.CheckBalanceState;
import atm.States.HomeState;
import atm.States.WithdrawalState;

/**
 * Class to represent an ATM machine.
 */
public class Machine
{
    public AbstractState getWithdrawalState()
    {
        return withdrawalState;
    }

    public AbstractState getCheckBalananceState()
    {
        return checkBalananceState;
    }

    public AbstractState getHomeState()
    {
        return homeState;
    }

    private AbstractState withdrawalState;
    private AbstractState cardInsertdState;
    private AbstractState checkBalananceState;
    private AbstractState homeState;
    private AbstractState state;

    public Machine()
    {
        this.homeState = new HomeState(this);
        this.cardInsertdState = new CardInsertedState(this);
        this.checkBalananceState = new CheckBalanceState(this);
        this.withdrawalState = new WithdrawalState(this);

        if (CardDetector.isCardPresent())
        {
            changeState(cardInsertdState);
        }
        else
        {
            changeState(homeState);
        }
    }

    public void cancel()
    {
        this.state.cancel();
    }

    public void changeState(AbstractState state)
    {
        System.out.println("State changed to: " + state.getClass());
        this.state = state;
        this.state.init();
    }

    public AbstractState getCardInsertdState() {
        return cardInsertdState;
    }

}
