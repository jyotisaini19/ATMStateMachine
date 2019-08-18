package atm.States;

import atm.Bank.Bank;
import atm.Machine;
import atm.Validator.AtmCashValidator;

import javax.xml.bind.ValidationException;
import java.util.Scanner;

/**
 * Class for cash withdrawal.
 */
public class WithdrawalState extends AbstractState
{

    private Machine machine;
    private Bank bank;
    private AtmCashValidator atmCashValidator;

    public WithdrawalState(Machine machine)
    {
        this.machine = machine;
        this.bank = new Bank();
        this.atmCashValidator = new AtmCashValidator();
    }

    @Override
    public void init()
    {
        withdrawCash();
    }

    private void withdrawCash()
    {
        long amount = enterAmount();
        checkIfEnoughMoney(amount);
        checkUserHasMoney(amount);
        giveOutCash();
    }

    private long enterAmount()
    {
        System.out.println("Please enter amount");
        Scanner input = new Scanner(System.in);
        long amount = input.nextLong();
        return amount;
    }

    private  void checkIfEnoughMoney(long amount)
    {
        try
        {
            this.atmCashValidator.validate(amount);
        }
        catch (ValidationException e)
        {
            System.out.println(e.getMessage());
            withdrawCash();
        }
    }

    private void checkUserHasMoney(long amount)
    {
        if (!this.bank.isValidTransaction(amount))
        {
            System.out.println("Insufficient balance.");
            machine.cancel();
            machine.changeState(machine.getHomeState());
        }
    }

    private void giveOutCash()
    {
        System.out.println("Cash has been given out. Please collect.");
        machine.cancel();
    }
}
