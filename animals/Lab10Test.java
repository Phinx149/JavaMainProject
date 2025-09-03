
import java.util.*;

public class Lab10Test{
    
    
    public static void testStack() {
        Stack<Integer> stack = new Stack<>();
       
        stack.push(5);
        if (5==stack.peek()){
            System.out.println("Firt test passed");
        }else{
            System.out.println("Test failed");
        }
        stack.push(10);
        if ((int)stack.pop()==10){
            System.out.println("Second test passed");

        }else{
            System.out.println("Second test failde");
        }
        if ( (int)stack.peek()==5){
            System.out.println("Third test passed");

        }else{
            System.out.println("Third test failde");
        }
    }
    
 
    public static void testQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        if (queue.peek() == 5) {
            System.out.println("First test passed");
       } else {
        System.out.println("First test failed");
       }
    
       queue.add(10);
       if (queue.remove() == 5) {
        System.out.println("Second test passed");
     } else {
        System.out.println("Second test failed");
    }
    
      if (queue.peek() == 10) {
        System.out.println("Third test passed");
    } else {
        System.out.println("Third test failed");
    } 
}
    public static void main(String [] args){
        testStack();
        testQueue();
    }
}