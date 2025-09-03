public class Color implements Comparable<Color> {
    private short red;
    private short green;
    private short blue;
 
    Color(short red, short green, short blue) {
       this.red = red;
       this.green = green;
       this.blue = blue;
    }
 
    @Override
    public int compareTo(Color otherColor) {
       if (red > otherColor.red) {
          return 1;
       }
       else if (red < otherColor.red) {
          return -1;
       }
       else if (green > otherColor.green) {
          return 1;
       }
       else if (green < otherColor.green) {
          return -1;
       }
       else if (blue > otherColor.blue) {
          return 1;
       }
       else if (blue < otherColor.blue) {
          return -1;
       }
       else {
          return 0;
       }
    }
 
    @Override
    public String toString() {
       return String.format("(%d, %d, %d)", red, green, blue);
    }
 }