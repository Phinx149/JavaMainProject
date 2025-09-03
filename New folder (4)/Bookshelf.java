public class Bookshelf {
    Book[] bookshelf;
    public int size = 0;

    public Bookshelf() {
        bookshelf = new Book[20];
    }

    public Bookshelf(int size) {
        bookshelf = new Book[size];
    }

    public Bookshelf(Book[] books) {
        bookshelf = books;
        while (size <= books.length && books[size] != null) {
            size++;
        }
    }

    public boolean add(Book newBook) {
        if (size <= bookshelf.length) {
            bookshelf[size] = newBook;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public Bookshelf getBooksByAuthor(String author) {
        Book[] bookAuthor = new Book[bookshelf.length];
        for (int i = 0; i < size; i++) {
            if (bookshelf[i].getAuthor().equals(author)) {
                bookAuthor[i] = bookshelf[i];
            }
        }
        return new Bookshelf(bookAuthor);
    }

    public String toString() {
        String bookString = "";
        for (int i = 0; i < size; i++) {
            bookString = bookString + bookshelf[i] + "\n";
        }
        return bookString;
    }

    public void sort(char sortBy) {
        System.out.println(size);
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && (bookshelf[j].compareTo(bookshelf[j - 1], sortBy) <= 0); j--) {
                Book temp = bookshelf[j];
                bookshelf[j] = bookshelf[j - 1];
                bookshelf[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        System.out.println(bs);
        bs.sort('r');
        System.out.println(bs);
        System.out.println(bs.getBooksByAuthor("Christopher Paolini"));
    }
}
