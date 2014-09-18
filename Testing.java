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
        FiniteIntegerSet set = Tree.empty();
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

    public static void main(String[] args) {
        emptyCardTest(5);
        nonemptyCardTest(5);
        isEmptyHuhTest1(5);
        isEmptyHuhTest2(5);
        addMemberTest(5);
    }

}
