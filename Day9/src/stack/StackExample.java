package stack; // Correct package declaration

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(70);
        stack.push(30);
        stack.push(56);

        System.out.println("Stack elements:");
        stack.display();

        while(!stack.isEmpty()){
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack elements after pop:");
        stack.display();
        }
       
    }
}