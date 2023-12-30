package LinkedList;
public class LinkedList<T> {

    Node<T> head;
    public void clear() {
        head = null;
    }

    public LinkedList() {
        this.head = null;
    }

    //Add
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

     //reverse
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            //reverse
            current.next = prev; 
            prev = current;      
            current = next;      
        }

        head = prev;
    }

    
    //display
    public void display(){
        if(head==null)  System.out.print("Empty Linkedlist");
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


}

