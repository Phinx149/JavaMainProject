import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String fileName) {
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
        } catch (Exception e) {
            return null;
        }
        Bookshelf bookshelf = new Bookshelf();
        while (file.hasNextLine()) {
            String[] lines = file.nextLine().split(", ");
            if (lines.length < 3) {
                return bookshelf;
            }
            Book lineBook = new Book(lines[0], lines[1], Double.parseDouble(lines[2]));
            bookshelf.add(lineBook);
        }
        return bookshelf;
    }

    public static boolean writeShelfToFile(Bookshelf b, String fileName) {
        PrintWriter printer = null;
        try {
            if (b == null) {
                return false;
            }
            printer = new PrintWriter(new File(fileName));
            printer.print(b.toString());
            printer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Bookshelf b = readBooksFromFile("C:\\Users\\user\\Downloads\\New folder (4)\\bookinput.txt");
        b.sort('r');
        System.out.println(writeShelfToFile(b, "C:\\Users\\user\\Downloads\\New folder (4)\\outPut.txt"));
    }
}
