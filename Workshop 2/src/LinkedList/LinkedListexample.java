package LinkedList;
public class LinkedListexample {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        //Add linkedlist
        integerLinkedList.add(16);
        integerLinkedList.add(30);
        integerLinkedList.add(60);
        integerLinkedList.add(80);
        integerLinkedList.add(90);
        integerLinkedList.add(20);
        integerLinkedList.add(10);


        System.out.println("LinkedList");
        integerLinkedList.display();
        integerLinkedList.size();
        //reverse linkedlist
        integerLinkedList.reverse();
        System.out.println("Reversed LinkedList");
        integerLinkedList.display();
        integerLinkedList.size();
        integerLinkedList.clear();
    }
}
