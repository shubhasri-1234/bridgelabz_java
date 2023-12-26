package linkedlist;
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        System.out.println("Is list Empty: " +integerLinkedList.isEmpty());

        //UC2
        //70 is first created
        integerLinkedList.addToFront(70);
        integerLinkedList.addToFront(30);
        integerLinkedList.addToFront(56);

        integerLinkedList.display();
        integerLinkedList.clear();

        //UC3
        //56 is first created
        integerLinkedList.add(56);
        integerLinkedList.add(30);
        integerLinkedList.add(70);

        integerLinkedList.display();
        integerLinkedList.clear();
        
        System.out.println("Size of linked List: " +integerLinkedList.size());
        integerLinkedList.add(56);
        integerLinkedList.add(70);
        //UC4
        System.out.println("Size of linked List: " +integerLinkedList.size());
        integerLinkedList.insertAt(1,30);
        integerLinkedList.display();
        System.out.println("Size of linked List: " +integerLinkedList.size());

        //UC5
        integerLinkedList.pop();
        integerLinkedList.display();
        System.out.println("Size of linked List: " +integerLinkedList.size());
        integerLinkedList.addToFront(56);

        //UC6
        integerLinkedList.poplast();
        integerLinkedList.display();
        System.out.println("Size of linked List: " +integerLinkedList.size());

        //UC7
        int position = integerLinkedList.find(30);
        System.out.println("Position of Element: " +position);
        integerLinkedList.add(70);


        //UC8
        integerLinkedList.insertAfter(30,40 );
        integerLinkedList.display();
        System.out.println("Size of linked List: " +integerLinkedList.size());

        //UC9
        integerLinkedList.delete(40);
        integerLinkedList.display();
        System.out.println("Size of linked List: " +integerLinkedList.size());
        
        //UC10
        SortedList<Integer> integerList = new  SortedList<>();
        integerList.add(56);
        integerList.add(30);
        integerList.add(40);
        integerList.add(70);
        System.out.println("Ordered Linked List:");
        integerList.display();
        System.out.println("Size of linked List: " + integerList.size());

    }
}
