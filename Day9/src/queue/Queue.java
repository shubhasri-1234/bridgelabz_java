package queue;
import java.util.EmptyStackException;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T dequeuedData = front.data;
        front = front.next;

        if (front == null) {
            // If the queue becomes empty, update rear as well
            rear = null;
        }

        return dequeuedData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return front.data;
    }

    public void display() {
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }
}

