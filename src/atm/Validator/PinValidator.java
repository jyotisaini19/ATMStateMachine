package atm.Validator;

import atm.Bank.Bank;

import javax.xml.bind.ValidationException;

/**
 * Class for atm pin validation.
 */
public class PinValidator implements ValidatorInterface<Integer>
{

    private Bank bank;

    public PinValidator()
    {
        bank = new Bank();
    }

    @Override
    public boolean validate(Integer pin) throws ValidationException
    {
        if (pin.toString().length() == 4)
        {
            return bank.isUserValid(pin);
        }
        else
        {
            throw new ValidationException("Pin is incorrect!");
        }
    }
}
