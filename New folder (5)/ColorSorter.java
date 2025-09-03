import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ColorSorter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_ELEMENTS = 5;
      ArrayList<Color> colors = new ArrayList<Color>();
      int i;
      short red;
      short green;
      short blue;

      for (i = 0; i < NUM_ELEMENTS; ++i) {
         red = (short)(scnr.nextShort());
         green = (short)scnr.nextShort();
         blue = (short)scnr.nextShort();
         colors.add(new Color(red, green, blue));
      }

      Collections.sort(colors);

      for (i = 0; i < NUM_ELEMENTS; ++i) {
         System.out.println(colors.get(i));
      }
   }
}