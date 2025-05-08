package book;

public class Book {

    int id;
    String title;
    String author;
    String publisher;
    String price;
    String status;

    public Book(int id, String title, String author, String publisher, String price, String status) {
       
    	
    	this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.status = status;
    
    }

    public void printInfo() {
    	
        System.out.println(id + ". " + title + ", " + author + ", " + publisher + ", " + price + ", 상태: " + status);
    
    }

    public void setStatus(String status) {
    	
        this.status = status;
    
    }

    public String getStatus() {
    	
        return status;
    
    }

    public int getId() {
    	
        return id;
    
    }
}
