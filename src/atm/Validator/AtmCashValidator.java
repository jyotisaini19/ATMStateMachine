package atm.Validator;

import javax.xml.bind.ValidationException;

public class AtmCashValidator implements ValidatorInterface<Long>
{

    @Override
    public boolean validate(Long obj) throws ValidationException
    {
        return true;
    }
}
