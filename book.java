class Book{
    private String title;
    private String author;
    private int price;

    Book(){
         this.title = "random book";
         this.author = "random author";
         this.price = 123;
    }

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void show(){
        System.out.println(this.title);
        System.out.println(this.author);
        System.out.println(this.price);
    }

    public static void main(String[] args){
        Book book1 = new Book();
        Book book2 = new Book("Balidan","Swapnil pandey",450);
        book1.show();
        book2.show();
    }

}
