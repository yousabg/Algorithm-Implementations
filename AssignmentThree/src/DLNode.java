public class DLNode<T> {
    T data;
    DLNode next;
    DLNode previous;

    public DLNode(T data) {
        this.data = data;
        next = null;
        previous = null;
    }
}
