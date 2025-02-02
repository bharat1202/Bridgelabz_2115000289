
public class Book2 {
    // Public ISBN field
    public String ISBN;

    // Protected title field
    protected String title;

    // Private author field
    private String author;

    // Constructor for the Book class
    public Book2(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Method to set the author's name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to get the author's name
    public String getAuthor() {
        return this.author;
    }
}

// Subclass EBook
public class EBook extends Book2 {

    // Constructor for EBook class
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author); // Call the constructor of the parent class
    }

    // Method to access ISBN and title from the parent class
    public void displayInfo() {
        System.out.println("ISBN: " + ISBN); // ISBN is public, so accessible
        System.out.println("Title: " + title); // Title is protected, so accessible in subclass
        // System.out.println("Author: " + author); // Cannot access 'author' directly, it's private in the parent class
    }

    public static void main(String[] args) {
        // Create an instance of EBook
        EBook myEBook = new EBook("978-3-16-148410-0", "Java Programming", "John Doe");

        // Display ISBN and title
        myEBook.displayInfo();

        // Access and modify the author's name using the getter and setter methods
        System.out.println("Author (via getter): " + myEBook.getAuthor());
        myEBook.setAuthor("Jane Doe");
        System.out.println("Updated Author (via getter): " + myEBook.getAuthor());
    }
}




