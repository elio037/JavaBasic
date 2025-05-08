package book;

import java.util.ArrayList;

public class bookService {
	
	private ArrayList<book> bookList = new ArrayList<>();
	
	public bookService() {
		loadBookList();
	}
	
	private void loadBookList() {
		bookList.add(new book(101, "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", 20000, true));
		bookList.add(new book(201, "나의 첫 알고리즘 + 자료구조", "코리 알트호프", "한빛미디어", 21000, true));
		bookList.add(new book(301, "Do It! HTML+CSS+자바스크립트", "고경희", "이지스퍼블리싱", 32000, true));
	}
	
	
	public ArrayList<book> listInstockBooks() {
		return listBooks(true);
	}
	
	public ArrayList<book> listRentBooks() {
		return listBooks(false);
	}
	
	private ArrayList<book> listBooks(boolean isInstock) {
		ArrayList<book> books = new ArrayList<>();
		
		for (book book : bookList) {
			if (book.isInstock() == isInstock)
				books.add(book);
		}
		
		return books;
	}

	// 도서 등록
	public void registBook(book newBook) {
	    bookList.add(newBook);
	    System.out.println("도서가 등록되었습니다.");
	}
	
	public void updateBook(int bookNo, int price) {
	    for (book b : bookList) {
	        if (b.getBookNo() == bookNo) {
	            try {
	                java.lang.reflect.Field priceField = book.class.getDeclaredField("price");
	                priceField.setAccessible(true);
	                priceField.setInt(b, price);
	                System.out.println("가격이 수정되었습니다.");
	                return;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    System.out.println("해당 도서 번호를 찾을 수 없습니다.");
	}
	
	public void removeBook(int bookNo) {
	    boolean removed = bookList.removeIf(b -> b.getBookNo() == bookNo);
	    if (removed) {
	        System.out.println("도서가 삭제되었습니다.");
	    } else {
	        System.out.println("해당 도서 번호를 찾을 수 없습니다.");
	    }
	}
	
	public boolean rentBook(int bookNo) {
		return changeRentStatus(bookNo, false);
	}
	
	public boolean returnBook(int bookNo) {
		return changeRentStatus(bookNo, true);
	}
	
	private boolean changeRentStatus(int bookNo, boolean isInstock) {
		for (book book : bookList) {
			if (book.getBookNo() == bookNo && book.isInstock() != isInstock) {
				book.setInstock(isInstock);
				return true;
			}
		}
		return false;
	}
}