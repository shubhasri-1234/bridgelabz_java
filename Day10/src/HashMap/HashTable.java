package HashMap;

public class HashTable {
    private static final int SIZE = 10;
    Node[] array;

    public HashTable() {
        array = new Node[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = null;
        }
    }
//The hash code is computed using the getHash method,
    private int getHash(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void insert(String key) {
        int index = getHash(key.toLowerCase());
        Node newNode = new Node(key.toLowerCase(), 1);

        if (array[index] == null) {
            array[index] = newNode;
        } 
        //// Check the last node in the linked list
        else {
            Node current = array[index];
            while (current.next != null) {
                if (current.key.equals(key.toLowerCase())) {
                    current.value++;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key.toLowerCase())) {
                current.value++;
            } else {
                current.next = newNode;
            }
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            Node current = array[i];
            while (current != null) {
                System.out.println("Word: " + current.key + ", Frequency: " + current.value);
                current = current.next;
            }
        }
    }

    public void remove(String key) {
        int index = getHash(key.toLowerCase());

        if (array[index] == null) {
            return;
        }

        Node current = array[index];
        Node prev = null;

        while (current != null && !current.key.equals(key.toLowerCase())) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev == null) {
                // Node to be removed is the head of the linked list
                array[index] = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }
}