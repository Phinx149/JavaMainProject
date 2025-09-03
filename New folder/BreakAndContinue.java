import java.util.Scanner;

public class BreakAndContinue {
   public static void main(String [] args){
      Scanner scnr = new Scanner(System.in);
      int result;
      int stop;
      int a;
      int b;
      stop = scnr.nextInt();
      result = 0;
      
      for (a = 1; a < 4; ++a) {
         System.out.print(a + ": ");
         
         for (b = 0; b < 2; ++b) {
            result += a;
            
            if (result > stop) {
               System.out.print("_ ");
               continue;
            }
            
            System.out.print(result + ",");
         }
         
         System.out.println();
      }
   }
}