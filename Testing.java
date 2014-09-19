package Data1;
import java.util.Random;
/**
 * Created by User on 9/18/2014.
 */
public class Testing {

    //The cardinality of the empty set is 0
    public static void emptyCardTest(int repeat) {
        for (int i = 0; i < repeat; i++) {
            if (Tree.empty().cardinality() == 0) {
                System.out.println("The set is empty. The cardinality of the set is "
                        + Tree.empty().cardinality() + ". PASS");
            }
        }
    }

    //The cardinality of the empty set after x elements have been added to it is x
    public static void nonemptyCardTest(int repeat) {
        for (int i = 0; i < repeat; i++){
            Random rng = new Random();
            int randomInt = rng.nextInt() % 100;
            while (randomInt < 0) randomInt = rng.nextInt() % 100;
            FiniteIntegerSet set = Tree.empty();
            for (int j = 0; j < randomInt; j++) {
                set = set.add(rng.nextInt());
            }
            if (randomInt == set.cardinality())
                System.out.println(randomInt + " elements added to the set. The set's cardinality is " +
                set.cardinality() + ". PASS");
            else System.out.println(randomInt + " elements added to the set. The set's cardinality is " +
                    set.cardinality() + ". FAIL");
        }
    }

    //the empty set is empty...
    public static void isEmptyHuhTest1(int repeat) {
        for (int i = 0; i < repeat; i++){
            if (Tree.empty().isEmptyHuh()) System.out.println("The empty set is empty. PASS");
            else System.out.println("The empty set is not empty. FAIL");
        }
    }

    //Adding any number of elements to a set makes it not empty
    public static void isEmptyHuhTest2(int repeat) {
        for (int i = 0; i < repeat; i++){
            Random rng = new Random();
            int randomInt = rng.nextInt() % 100;
            while (randomInt < 1) randomInt = rng.nextInt() % 100;
            FiniteIntegerSet set = Tree.empty();
            for (int j = 0; j < randomInt; j++) {
                set = set.add(rng.nextInt());
            }
            if (!set.isEmptyHuh())
                System.out.println(randomInt + " elements added to the set. The set is not empty. PASS");
            else System.out.println(randomInt + " elements added to the set. The set is empty. FAIL");
        }
    }

    //Adding an element to a set causes that element to be a member of that set.
    public static void addMemberTest(int repeat) {
        Random rng = new Random();
        FiniteIntegerSet set = randomBST(100, 100);
        for (int i = 0; i < repeat; i++) {
            int randomInt = rng.nextInt();
            set = set.add(randomInt);
            if (set.member(randomInt))
            System.out.println(randomInt + " has been added to the set. " + randomInt +
                    " is a member of the set. PASS");
            else System.out.println(randomInt + " has been added to the set. " + randomInt +
                    " is not a member of the set. FAIL");
        }
    }

    //The intersection of two sets x and y is a subset of the union of those two sets
    public static void subsetUnion1(int repeat) {
        for (int i = 0; i < repeat; i++) {
        FiniteIntegerSet x = randomBST(10, 10);
        FiniteIntegerSet y = randomBST(10, 10);
        if (x.inter(y).subset(x.union(y)))
            System.out.println("The intersection of random sets x and y is a subset of the union of x and y. PASS");
        else
            System.out.println("The intersection of random sets x and y isn't a subset of the union of x and y. FAIL");
        }
    }

    ///The difference of two sets x and y is a subset of the union of those two sets
    public static void subsetUnion2(int repeat) {
        for (int i = 0; i < repeat; i++) {
            FiniteIntegerSet x = randomBST(10, 10);
            FiniteIntegerSet y = randomBST(10, 10);
            if (y.diff(x).subset(y.union(x)))
                System.out.println("The difference of random sets x and y is a subset of the union of x and y. PASS");
            else
                System.out.println("The difference of random sets x and y isn't a subset of the union of x and y. FAIL");
        }
    }

    //Iff two sets are equal, then they are also both subsets of each other.
    public static void equalityBySubset(int repeat) {
        for (int i = 0; i < repeat; i++) {
            FiniteIntegerSet x = randomBST(20, 5);
            FiniteIntegerSet y = randomBST(20, 5);
            if (x.equal(y) && (x.subset(y) && y.subset(x)))
                System.out.println("The two random sets are equal and are also subsets of each other. PASS");
            else if (x.equal(y))
                System.out.println("The two random sets are equal but are not subsets of each other. FAIL");
            else if (x.subset(y) && y.subset(x))
                System.out.println("The two random sets are subsets of each other but are not equal. FAIL");
            else
                System.out.println("The two random sets are not equal or subsets of each other. PASS");
        }
    }

    //Iff set x is a subset of set y, the union of x and y is equal to y
    public static void setSubsetUnion(int repeat) {
        for (int i = 0; i < repeat; i++) {
            FiniteIntegerSet x = randomBST(5, 20);
            FiniteIntegerSet y = randomBST(5, 20);
            if ((x.subset(y) && y.equal(x.union(y))) || (y.subset(x) && x.equal(y.union(x))))
                System.out.println("One random set is a subset of the other and their union is equal to the other set. PASS");
            else if (x.subset(y) || y.subset(x))
                System.out.println("One random set is a subset of the other but their union is not equal to the other set. FAIL");
            else if (y.equal(x.union(y)) || x.equal(y.union(x)))
                System.out.println("The union of the two random sets is equal to one of them but the other is not a subset to that one. FAIL");
            else
                System.out.println("Neither of the two sets is a subset of the other or equal to their union. PASS");
        }
    }

    //the union of the intersection of x and y, the difference of x and y and the difference of y and x equals the union of x and y
    public static void componentUnion(int repeat) {
        for (int i = 0; i < repeat; i++) {
            FiniteIntegerSet x = randomBST(20, 20);
            FiniteIntegerSet y = randomBST(20, 20);
            if (x.diff(y).union(y.diff(x)).union(x.inter(y)).equal(x.union(y)))
                System.out.println("The union of the intersection of x and y, x-y, and y-x equals the union of x and y. PASS");
            else
                System.out.println("The union of the intersection of x and y, y-y, and y-x does not equal the union of x and y. FAIL");
        }
    }

    //If x is a subset of y, then the cardinality of x must be less than or equal to the cardinality of y
    public static void subsetCardinality(int repeat) {
        for (int i = 0; i < repeat; i++) {
            FiniteIntegerSet x = randomBST(10, 10);
            FiniteIntegerSet y = randomBST(10, 10);
            if ((x.subset(y) && (x.cardinality() <= y.cardinality())) || (y.subset(x) && (y.cardinality() <= x.cardinality())))
                System.out.println("A random set is a subset of the other random set and the cardinality of the first set is not greater than the cardinality of the second set. PASS");
            else if (x.subset(y) || y.subset(x))
                System.out.println("A random set is a subset of the other random set but has a greater cardinality than the second set. FAIL");
            else
                System.out.println("The random pair of sets are not subsets. PASS");
        }
    }

    private static FiniteIntegerSet randomBST(int maxsize, int maxelement) {
        Random rng = new Random();
        int size = rng.nextInt() % (maxsize + 1);
        FiniteIntegerSet set = Tree.empty();
        for (int i = 0; i < size; i++) set = set.add(rng.nextInt() % (maxelement + 1));
        return set;
    }



    public static void main(String[] args) {
        emptyCardTest(5);
        nonemptyCardTest(5);
        isEmptyHuhTest1(5);
        isEmptyHuhTest2(5);
        addMemberTest(5);
        subsetUnion1(5);
        subsetUnion2(5);
        equalityBySubset(10);
        setSubsetUnion(10);
        componentUnion(5);
        subsetCardinality(5);
    }

}
