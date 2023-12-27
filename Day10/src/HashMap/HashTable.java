import java.util.LinkedList;
public class HashTable {
    private static final int SIZE = 10;
    LinkedList<Node>[] array;

    public HashTable() {
        array = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = new LinkedList<>();
        }
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void insert(String key) {
        int index = getHash(key.toLowerCase()); // Convert the key to lowercase
        LinkedList<Node> list = array[index];

        // Check if the word already exists in the linked list
        for (Node node : list) {
            if (node.key.equals(key.toLowerCase())) {
                node.value++;
                return;
            }
        }

        // If the word doesn't exist, add a new node to the linked list
        list.add(new Node(key.toLowerCase(), 1));
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            LinkedList<Node> list = array[i];
            for (Node node : list) {
                System.out.println("Word: " + node.key + ", Frequency: " + node.value);
            }
        }
    }

    public void remove(String key) {
        int index = getHash(key);
        LinkedList<Node> list = array[index];

        // Find and remove the node with the specified key
        list.removeIf(node -> node.key.equals(key));
    }
}