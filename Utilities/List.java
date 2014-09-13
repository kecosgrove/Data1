package Data1old.Utilities;

/**
 * Created by User on 9/10/2014.
 */
public class List<T> {

    private T data;
    private List<T> next;

    public List() {
    }

    public List(T data) {
        this.data = data;
    }

    public List<T> cons(T data) {
        List<T> newList = new List(data);
        newList.next = this;
        return newList;
    }

    public List<T> rest() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
