package Data1;

import Data1.Utilities.*;

/**
 * Created by User on 9/9/2014.
 */
public class FiniteIntegerSet {

    private Tree<Integer> tree;

    public FiniteIntegerSet() {
    }

    public FiniteIntegerSet(Tree<Integer> tree) {
        this.tree = tree;
    }

    public static FiniteIntegerSet empty() {
        return new FiniteIntegerSet();
    }

    public int cardinality() {
        return cardinalityHelper(tree);
    }

    private int cardinalityHelper(Tree<Integer> tree) {
        if (tree == null) return 0;
        else return 1 + cardinalityHelper(tree.getLeft()) + cardinalityHelper(tree.getRight());
    }

    public boolean isEmptyHuh() {
        return tree == null;
    }

    public boolean member(Integer data) {
        return memberHelper(data, tree);
    }

    private boolean memberHelper(Integer data, Tree<Integer> tree) {
        if (tree == null) return false;
        Integer current = tree.getData();
        if (current == data) return true;
        else if (current > data) return memberHelper(data, tree.getRight());
        else return memberHelper(data, tree.getLeft());
    }

    public FiniteIntegerSet add(Integer data) {
        Tree<Integer> copy = tree;
        return new FiniteIntegerSet(addHelper(data, copy));
    }

    private Tree<Integer> addHelper(Integer data, Tree<Integer> tree) {
        if (tree == null) return new Tree(data);
        Integer current = tree.getData();
        if (current == data) return tree;
        else if (current > data) {
            tree.setRight(addHelper(data, tree.getRight()));
            return tree;
        }
        else {
            tree.setLeft(addHelper(data, tree.getLeft()));
            return tree;
        }
    }

}
