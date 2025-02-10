
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    public abstract int getLoanDuration();
}


interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}


class Book extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

   
    public int getLoanDuration() {
        return 14; 
    }

   
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    
    public boolean checkAvailability() {
        return !isReserved;
    }
}


class Magazine extends LibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; 
    }
}


class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    
    public int getLoanDuration() {
        return 5; 
    }

   
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }


    public boolean checkAvailability() {
        return !isReserved;
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Magazine(102, "National Geographic", "Various"),
            new DVD(103, "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println("Availability: " + ((Reservable) item).checkAvailability());
            }
            
        }
    }
}
