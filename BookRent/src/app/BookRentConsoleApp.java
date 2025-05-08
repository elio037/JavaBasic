package app;

import java.util.ArrayList;
import java.util.Scanner;

import book.book;
import book.bookService;

public class BookRentConsoleApp {
	
	bookService bs = new bookService();

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
		System.out.println("*    도서 대여점에 오신 걸 환영합니다.    *");
		System.out.println("************************************");
	}
	
	private void controlMenu() {
		int menu;
		do {
			menu = getMenu(); // 메뉴 출력하고 메뉴 번호를 입력 받음
			switch (menu) {
			case 1: menuBookList(); break;
			case 2: menuBookRent(); break;
			case 3: menuBookRentList(); break;
			case 4: menuBookReturn(); break;
			case 5:
			    Scanner sc5 = new Scanner(System.in);
			    System.out.print("도서 번호: ");
			    int no = sc5.nextInt();
			    sc5.nextLine();
			    System.out.print("도서 제목: ");
			    String title = sc5.nextLine();
			    System.out.print("저자: ");
			    String author = sc5.nextLine();
			    System.out.print("출판사: ");
			    String publisher = sc5.nextLine();
			    System.out.print("가격: ");
			    int price = sc5.nextInt();
			    boolean instock = true; // 등록 시 기본값

			    book newBook = new book(no, title, author, publisher, price, instock);
			    bs.registBook(newBook);
			    break;

			case 6:
			    Scanner sc6 = new Scanner(System.in);
			    System.out.print("가격을 수정할 도서 번호: ");
			    int bookNoToUpdate = sc6.nextInt();
			    System.out.print("새로운 가격: ");
			    int newPrice = sc6.nextInt();
			    bs.updateBook(bookNoToUpdate, newPrice);
			    break;

			case 7:
			    Scanner sc7 = new Scanner(System.in);
			    System.out.print("삭제할 도서 번호: ");
			    int bookNoToRemove = sc7.nextInt();
			    bs.removeBook(bookNoToRemove);
			    break;
			case 0: menuExit();	break;
			default: System.out.println("없는 메뉴입니다.");
			}
		} while (menu != 0);
	}
	
	private void menuBookList() {
		ArrayList<book> bookList = bs.listInstockBooks();
		displayBookList(bookList);
	}
	
	private void menuBookRentList() {
		ArrayList<book> bookList = bs.listRentBooks();
		displayBookList(bookList);
	}
	
	private void displayBookList(ArrayList<book> bookList) {
		System.out.println("--------------------------------------------");
		if (bookList.isEmpty()) {
			System.out.println("책이 없습니다.");
		} else {
			for (book book : bookList) {
				System.out.println(book.toString());
			}
		}
		System.out.println("--------------------------------------------");
	}
	
	private void menuBookRent() {
		
		displayBookList(bs.listInstockBooks());
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 대여할 도서 번호 : ");
		int bookNo = sc.nextInt();
		
		if (bs.rentBook(bookNo)) {
			displayBookList(bs.listRentBooks());
		} else {
			System.out.println("[오류] 없는 도서이거나 이미 대여한 도서입니다.");
		}
	}
	
	private void menuBookReturn() {
		displayBookList(bs.listRentBooks());
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 반납할 도서 번호 : ");
		int bookNo = sc.nextInt();
		
		if (bs.returnBook(bookNo)) {
			displayBookList(bs.listRentBooks());
		} else {
			System.out.println("[오류] 없는 도서이거나 이미 반납한 도서입니다.");
		}
	}
	
	private int getMenu() {
		// 메뉴 출력
		System.out.println("=================================");
		System.out.println("1. 도서 목록 보기");
		System.out.println("2. 도서 대여");
		System.out.println("3. 도서 대여 현황 보기");
		System.out.println("4. 도서 반납");
		System.out.println("5. 도서 추가 등록");
		System.out.println("6. 도서 가격 수정");
		System.out.println("7. 도서 삭제");
		System.out.println("0. 종료");
		System.out.println("=================================");
		System.out.print(">> 메뉴 선택 : ");
		
		// 메뉴 번호 입력
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();	
		return menu;
	}
	
	private void menuExit() {
		System.out.println("*** 도서 대여점 종료 ***");
	}
}