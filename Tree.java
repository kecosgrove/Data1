package Data1;

/**
 * Created by User on 9/15/2014.
 */
public class Tree implements FiniteIntegerSet {

    private int data;
    private FiniteIntegerSet right;
    private FiniteIntegerSet left;

    public Tree(int data) {
        this.data = data;
        this.right = new EmptyTree();
        this.left = new EmptyTree();
    }

    public Tree(int data, FiniteIntegerSet right, FiniteIntegerSet left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public FiniteIntegerSet empty() {
        return new EmptyTree();
    }

    public int cardinality() {
        return 1 + right.cardinality() + left.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public boolean member(int data) {
        return ((this.data == data) || right.member(data) || left.member(data));
    }

    public FiniteIntegerSet add(int data) {
        if (this.data == data) return this;
        else if (this.data > data) return new Tree(this.data, this.right, this.left.add(data));
        else return new Tree(this.data, this.right.add(data), this.left);
    }

    public FiniteIntegerSet remove(int data) {
        if (this.data == data) return right.union(left);
        else if (this.data > data) return new Tree(this.data, this.right, this.left.remove(data));
        else return new Tree(this.data, this.right.remove(data), this.left);
    }

    public FiniteIntegerSet union(FiniteIntegerSet set) {
        return set.add(data).union(right).union(left);
    }

    public FiniteIntegerSet inter(FiniteIntegerSet set) {
        if (set.member(data)) return new Tree(this.data, this.right.inter(set), this.left.inter(set));
        else return this.remove(data).inter(set);
    }

    public FiniteIntegerSet diff(FiniteIntegerSet set) {
        if (set.member(data)) return this.remove(data).diff(set);
        else return new Tree(this.data, this.right.diff(set), this.left.diff(set));
    }
    //This Diff method is (this - set), not sure if it should be (set - this) instead

    public boolean equal(FiniteIntegerSet set) {
        return (set.diff(this).isEmptyHuh()) && (diff(set).isEmptyHuh());
    }

    public boolean subset(FiniteIntegerSet set) {
        return diff(set).isEmptyHuh();
    }
}