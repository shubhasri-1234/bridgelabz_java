package linkedlist;
public class SortedList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null || head.data.compareTo(data) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}