package app;

import java.util.ArrayList;
import java.util.Scanner;

import book.Book;
import book.BookService;

public class BookRentConsoleApp {

	BookService bs = new BookService();
	
	public static void main(String[] args) {
		// BookRentConsoleApp 객체 생성
		BookRentConsoleApp app = new BookRentConsoleApp();
		
		// 환영 인사
		app.displayWelcome();
		
		// 선택 메뉴에 따라 기능 수행
		app.controlMenu();

	}

	private void displayWelcome() {
		System.out.println("************************************");
		System.out.println("*     도서 대여점에 오신 것을 환영합니다.    *");
		System.out.println("************************************");
	}
	
	private void controlMenu() {
		int menu;
		do {
			// 메뉴 출력
			menu = getMenu();
			// 메뉴 번호에 따라 기능 수행
			switch (menu) {
				case 1: menuBookList(); break;
				case 2: menuBookRent(); break;
				case 3: menuBookRentList(); break;
				case 4: menuBookReturn(); break;
				case 0: menuExit(); break;
				default: System.out.println("없는 메뉴입니다.");
			}
			
		} while(menu != 0); 
	}

	private void menuBookRentList() {
		ArrayList<Book> bookList = bs.listRentBooks();
		displayBookList(bookList);
	}

	private void menuBookList() {
		ArrayList<Book> bookList = bs.listInstockBooks();
		displayBookList(bookList);
	}
	
	private void displayBookList(ArrayList<Book> bookList) {
		System.out.println("---------------------------------------");
		if(bookList.isEmpty()) {
			System.out.println("책이 없습니다.");
		}
		else {
			for(Book book : bookList) {
				System.out.println(book);
			}
		}
		System.out.println("---------------------------------------");
	}
	
	private void menuBookRent() {
		displayBookList(bs.listInstockBooks());
		
		Scanner scan = new Scanner(System.in);
		System.out.print(">> 대여할 도서 번호 : ");
		int bookNo = scan.nextInt();
		
		if(bs.rentBook(bookNo)){
			displayBookList(bs.listRentBooks());
		}
		else {
			System.out.println("[오류] 없는 도서이거나 이미 대여한 도서입니다.");
		}
		
	}

	private void menuBookReturn() {
		displayBookList(bs.listRentBooks());
		Scanner scan = new Scanner(System.in);
		System.out.println(">> 반납할 도서 번호 : ");
		int bookNo = scan.nextInt();
		
		if(bs.returnBook(bookNo)) {
			displayBookList(bs.listRentBooks());
		}
		else {
			System.out.println("[오류] 없는 도서이거나 이미 대여한 도서입니다.");
		}
	}
	
	private int getMenu() {
		// 메뉴 출력
		System.out.println("=========================");
		System.out.println("1. 도서 목록 보기");
		System.out.println("2. 도서 대여");
		System.out.println("3. 도서 대여 현황 보기");
		System.out.println("4. 도서 반납");
		System.out.println("0. 종료");
		System.out.println("=========================");
		System.out.print(">> 메뉴 선택 : ");

		// 메뉴 번호 입력
		Scanner scan  = new Scanner(System.in);
		int menu = scan.nextInt();
				
		return menu;
	}
	
	private void menuExit() {
		System.out.println("*** 도서 대여점 종료 ***");
	}
	
	
}

