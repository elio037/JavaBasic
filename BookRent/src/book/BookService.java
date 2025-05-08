package book;

public class BookService {

    Book[] books;

    public BookService() {
        books = new Book[3];
        books[0] = new Book(1, "쉽게 배우는 자바", "우종정", "한빛아카데미", "999,000원", "book");
        books[1] = new Book(2, "나의 첫 알고리즘", "코리 알트호프", "한빛미디어", "99999,000원", "book");
        books[2] = new Book(3, "Do It! HTML+CSS", "고경희", "이지스퍼블리싱", "65757656756,000원", "book");
    }

    public void showAllBooks() {
        for (Book b : books) {
            b.printInfo();
        }
    }

    public boolean rentBook(int inputId) {
        for (Book b : books) {
            if (b.getId() == inputId) {
                if (b.getStatus().equals("book")) {
                    b.setStatus("rent");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean returnBook(int inputId) {
        for (Book b : books) {
            if (b.getId() == inputId) {
                if (b.getStatus().equals("rent")) {
                    b.setStatus("book");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
