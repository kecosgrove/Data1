package Data1old;

import Data1old.Utilities.*;

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

    public FiniteIntegerSet union(FiniteIntegerSet t) {
        Tree<Integer> copy = tree;
        return new FiniteIntegerSet(treeUnion(t.getTree(), copy));
    }

    private Tree<Integer> getTree() {
        return tree;
    }

    private Tree<Integer> treeUnion(Tree<Integer> t, Tree<Integer> u) {
        List<Integer> contents = toList(u);
        Tree<Integer> newTree = t;
        while (contents != null) {
            Integer data = contents.getData();
            contents = contents.rest();
            newTree = addHelper(data, newTree);
        }
        return newTree;
    }

    private List<Integer> toList(Tree<Integer> tree) {
        if (tree == null) return null;
        else {
            return append(new List(tree.getData()), append(toList(tree.getLeft()), toList(tree.getRight())));
        }

    }

    private static List<Integer> append(List<Integer> list1, List<Integer> list2) {
        if (list2 == null) return list1;
        else if (list1 == null) return list2;
        else {
            return append(list1.cons(list2.getData()),list2.rest());
        }
    }

    public static void main(String[] args) {
        System.out.println(append(null, new List(1)).getData());
    }

}
