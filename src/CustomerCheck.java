import java.util.ArrayList;
public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double total = 0;
        for (int i = 0; i < check.size(); i++)
        {
            total += check.get(i).getPrice();
        }
        return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        if (totalPrices() < 40)
        {
            return false;
        }
        for (int i = 0; i < check.size(); i++)
        {
            if (check.get(i).isDailySpecial())
            {
                return false;
            }
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double finalCheck = totalPrices();
        int people = 0;
        if (couponApplies())
        {
            finalCheck -= 0.25 * totalPrices();
        }
        for (int i = 0; i < check.size(); i++)
        {
            if (check.get(i).isEntree())
            {
                people++;
            }
        }
        if (people >= 6)
        {
            finalCheck += 0.20 * totalPrices();
        }
        return finalCheck;
    }
}