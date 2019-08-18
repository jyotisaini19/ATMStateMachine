package atm.Validator;

/**
 * Interface for a validator.
 */
public interface ValidatorInterface<T>
{

    boolean validate(T obj) throws Exception;
}
