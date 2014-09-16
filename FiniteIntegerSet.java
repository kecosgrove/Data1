package Data1;

/**
 * Created by User on 9/15/2014.
 */
public interface FiniteIntegerSet {

    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(int data);
    public FiniteIntegerSet add(int data);
    public FiniteIntegerSet remove(int data);
    public FiniteIntegerSet union(FiniteIntegerSet set);
    public FiniteIntegerSet inter(FiniteIntegerSet set);
    public FiniteIntegerSet diff(FiniteIntegerSet set);
    public boolean equal(FiniteIntegerSet set);
    public boolean subset(FiniteIntegerSet set);

}
