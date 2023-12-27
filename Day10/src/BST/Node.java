package BST;

public class Node <T extends Comparable<T>>{
    T data;
    Node<T> right;
    Node<T> left;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
