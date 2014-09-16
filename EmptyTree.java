package Data1;

/**
 * Created by User on 9/15/2014.
 */
public class EmptyTree implements FiniteIntegerSet {

    public static FiniteIntegerSet empty() {
        return new EmptyTree();
    }

    public int cardinality() {
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }

    public boolean member(int data) {
        return false;
    }

    public FiniteIntegerSet add(int data) {
        return new Tree(data, this, this);
    }

    public FiniteIntegerSet remove(int data) {
        return this;
    }

    public FiniteIntegerSet union(FiniteIntegerSet set) {
        return set;
    }

    public FiniteIntegerSet inter(FiniteIntegerSet set) {
        return this;
    }

    public FiniteIntegerSet diff(FiniteIntegerSet set) {
        return set;
    }

    public boolean equal(FiniteIntegerSet set) {
        return set.isEmptyHuh();
    }

    public boolean subset(FiniteIntegerSet set) {
        return true;
    }

}
