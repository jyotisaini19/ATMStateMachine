package atm.States;

import atm.Bank.Bank;
import atm.Machine;
import atm.Validator.PinValidator;

import javax.xml.bind.ValidationException;
import java.util.Scanner;

/**
 * Class for state when the machine has card.
 */
public class CardInsertedState extends AbstractState
{

    private Machine machine;
    private Bank bank;
    private PinValidator validator;
    private int pinAttempts;

    public CardInsertedState(Machine machine)
    {
        this.machine = machine;
        this.validator = new PinValidator();
        this.bank = new Bank();
    }
    @Override
    public void init()
    {
        verifyUser();
    }

    private void verifyUser()
    {
        if (pinAttempts >= 3)
        {
            System.out.println("Your attempts are finished.");
            pinAttempts = 0;
            machine.changeState(machine.getHomeState());
        }
        int pin  = enterPin();
        this.pinAttempts = this.pinAttempts + 1;
        if (isValidPin(pin))
        {
            moveToNextAction();
        }

    }

    private int enterPin()
    {
        return takePinInput();
    }

    private boolean isValidPin(int pin)
    {
        try
        {
           return this.validator.validate(pin);
        }
        catch (ValidationException e)
        {
            System.out.println(e.getMessage());
            verifyUser();
        }
        return false;
    }

    private void moveToNextAction()
    {
        int input = takeNextActionInput();
        if (input == 1)
        {
            machine.changeState(machine.getWithdrawalState());
        }
        else if (input == 4)
        {
            machine.cancel();
        }
        else
        {
            System.out.println("Invalid Input");
            moveToNextAction();
        }

    }

    private int takeNextActionInput()
    {
        System.out.println("Please choose from the following");
        System.out.println("1. Withdrawal");
        System.out.println("2. Check balance");
        System.out.println("3. Chaneg ATM Pin");
        System.out.println("4. Cancel");
        Scanner input = new Scanner(System.in);
        int cardInsertInput = input.nextInt();
        return cardInsertInput;
    }

    private int takePinInput()
    {
        System.out.println("Please enter 4 digit pin");
        Scanner input = new Scanner(System.in);
        int pin = input.nextInt();
        return pin;
    }
}
