package Data1;

/**
 * Created by User on 9/15/2014.
 */
public interface FiniteIntegerSet {

    public int cardinality();
    //Returns the number of elements in the set
    public boolean isEmptyHuh();
    //Returns true if the set is empty, returns false otherwise
    public boolean member(int data);
    //Returns true if data is an element of the set. Returns false otherwise
    public FiniteIntegerSet add(int data);
    //Returns a new set containing all the elements of the parent set and data.
    public FiniteIntegerSet remove(int data);
    //Returns a new set containing all the elements of the parent set except for data.
    public FiniteIntegerSet union(FiniteIntegerSet set);
    //Returns a new set containing all the elements of both the parent set and the input set.
    public FiniteIntegerSet inter(FiniteIntegerSet set);
    //Returns a new set containing all the elements which are in both the parent set and the input set
    public FiniteIntegerSet diff(FiniteIntegerSet set);
    //Returns a new set containing everything in set except those elements also in the parent
    public boolean equal(FiniteIntegerSet set);
    //Returns true if set contains exactly the elements of the parent. Returns false otherwise.
    public boolean subset(FiniteIntegerSet set);
    //Returns true if all elements of the parent are also elements of set

}
