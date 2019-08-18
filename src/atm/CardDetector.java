package atm;

import java.util.Random;

/**
 * Class for detecting if the card is present in the machine or not.
 */
public class CardDetector
{

    public static boolean isCardPresent()
    {
        Random rd = new Random();
        return rd.nextBoolean();
    }

}
