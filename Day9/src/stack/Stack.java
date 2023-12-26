package stack;
import java.util.EmptyStackException;

class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if(top == null){
            top = newNode;
        } else{
        newNode.next = top;
        top = newNode;
      }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public void display() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }
}