package Data1old.Utilities;

/**
 * Created by User on 9/9/2014.
 */
public class Tree<T> {

    private T data;
    private Tree<T> left;
    private Tree<T> right;

    public Tree() {
    }

    public Tree(T data) {
        this.data = data;
    }

    public Tree(Tree<T> left, T data, Tree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree<T> getLeft(){
        return left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }
}
