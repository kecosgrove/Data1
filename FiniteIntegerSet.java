package Data1;

/**
 * Created by User on 9/15/2014.
 */
public interface FiniteIntegerSet {

    public FiniteIntegerSet empty();
    //I have no idea how to make this static. The interface wants a body for static methods but
    //doesn't let me use constructors. Is there another way to create a function without inputs?
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
