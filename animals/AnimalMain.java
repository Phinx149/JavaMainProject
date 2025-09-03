import java.util.*;

public class AnimalMain {
    public static void main(String[] args) {
      
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 25; i++) {
            stack.push(i);
        }
        System.out.println("Stack: " + stack);
        
        System.out.println("Removed element from stack: " + stack.pop());
        System.out.println("Removed second element from stack: " + stack.pop());
        System.out.println("Top element in stack: " + stack.peek());
        System.out.println("Stack after operations: " + stack);

        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= 25; i++) {
            queue.add(i);
        }
        System.out.println("Queue: " + queue);
        
        System.out.println("Removed element from queue: " + queue.remove());
        System.out.println("Removed second element from queue: " + queue.remove());
        System.out.println("Top element in queue: " + queue.peek());
        System.out.println("Queue after operations: " + queue);
    }
}