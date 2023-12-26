package queue;

public class QueueExample{
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("Queue elements:");
        queue.display();

        while(!queue.isEmpty()){
        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Queue elements after dequeue:");
        queue.display();
        }
    }

}

