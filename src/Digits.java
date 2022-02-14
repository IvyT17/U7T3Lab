import java.util.ArrayList;
public class Digits
{
    /** The list of digits from the number used to construct this object.
     * The digits appear in the list in the same order in which they appear in the original number.
     */

    private ArrayList<Integer> digitList;

    /** Constructs a Digits object that represents num.
     * Precondition: num >= 0
     */
    public Digits(int num)
    {
        digitList = new ArrayList<Integer>();
        if (num == 0)
        {
            digitList.add(0);
        }
        while (num > 0)
        {
            digitList.add(0, num % 10);
            num /= 10;
        }
    }

    /** Returns true if the digits in this Digits object are in strictly increasing order;
     * false otherwise.
     */
    public boolean isStrictlyIncreasing()
    {
        int first = digitList.get(0);
        for (int i = 1; i < digitList.size(); i++)
        {
            if (digitList.get(i) > first)
            {
                first = digitList.get(i);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getDigitList()
    {
        return digitList;
    }
}