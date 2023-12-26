package linkedlist;
public class LinkedList<T> {

    Node<T> head;
    public void clear() {
        head = null;
    }

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        } else{
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    
    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        } 
        else{
        newNode.next = head;
        head = newNode;
        }
    }

    public void display(){
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        int count = 0;
        Node<T> temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAt(int position, T data) {
        if(position < 0 || position > size()){
            System.out.println("Invalid Position");
            return;
        }
        Node<T> newNode = new Node<>(data);
        if(position == 0){
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> temp = head;
            for(int i = 0; i < position - 1; i++){
                    temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

      public void poplast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void insertAfter(T key, T newData) {
       Node<T> newNode = new Node<>(newData);
        Node<T> current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found in the linked list.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }


    public void removeFrom(int position) {
        if(isEmpty() || position < 0 || position >= size()){
            System.out.println("Invalid Position");
            return;
        }
        if(position == 0 ){
            head = head.next;
        } else {
            Node<T> temp = head;
            for(int i = 0; i < position - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void delete(T key) {
       Node<T> current = head;
        Node<T> prev = null;

        // Find the node to delete and its previous node
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If the node to delete is the head
        if (current == head) {
            head = head.next;
        } else if (current != null) {
            // If the node to delete is not the head
            prev.next = current.next;
        }
    }

    public int find(T data) {
        Node<T> temp = head;
        int position = 0;
        while(temp != null){
            if(temp.data.equals(data)){
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1;
    }
}
