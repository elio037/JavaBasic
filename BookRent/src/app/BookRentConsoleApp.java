package app;

import java.util.Scanner;

public class BookRentConsoleApp {

	// 도서 정보
	static final int RENT_STATUS_IDX = 5;
	static final String STATUS_STOCK = "stock";
	static final String STATUS_RENT = "rent";

	static String[][] bookList = { 
			{ "1", "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", "20,000원", STATUS_STOCK },
			{ "2", "나의 첫 알고리즘 + 자료구조", "코리 알트호프", "한빛미디어", "21,000원", STATUS_STOCK },
			{ "3", "Do It! HTML+CSS+자바스크립트", "고경희", "이지스퍼블리싱", "32,000원", STATUS_STOCK } };
	
	
	public static void main(String[] args) {

		// 환영인사
		displayWelcome();
		
		// 종료 조건 정의
		boolean isQuit = false;
		
		while (!isQuit) {
			// 메뉴 출력하고 메뉴 번호를 입력 받음
			int menu = getMenu();
			
			// 메뉴 번호에 따라 기능 수행
			switch (menu) {
			case 1: // 도서 목록 보기
				menuBookList();
				break;
			case 2: // 도서 대여
				menuBookRent();
				break;
			case 3: // 도서 대여 현황 보기
				menuBookRentList();
				break;
			case 4: // 도서 반납
				menuBookReturn();
				break;
			case 0: // 종료
				menuExit();
				isQuit = true;
				break;
			default:
				System.out.println("없는 메뉴입니다.");
			}
		}

	}
	
	static void menuBookList() {
		System.out.println("*** 도서 목록 ***");
		// bookList 출력 if 대여 가능 책만
		displayBookList(STATUS_STOCK);
	}
	
	static void displayBookList(String status) {
		// bookList
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i][RENT_STATUS_IDX].equals(status))
				displayBookInfo(i);
		}
	}
	
	static void displayBookInfo(int index) {
		for (int i = 0; i < RENT_STATUS_IDX; i++) {
			System.out.print(bookList[index][i] + ", ");
		}
		System.out.println();
	}
	
	
	static void menuBookRentList() {
		System.out.println("*** 도서 대여 현황 ***");
		displayBookList(STATUS_RENT);
	}
	
	
	static void menuExit() {
		System.out.println("*** 도서 대여점 종료 ***");
	}
	
	static void displayWelcome() {
		System.out.println("************************************");
		System.out.println("*     도서 대여점에 오신 걸 환영합니다.     *");
		System.out.println("************************************");
	}
	
	static int getMenu() {
	    // 메뉴 출력
	    System.out.println("=================================");
	    System.out.println("1. 도서 목록 보기");
	    System.out.println("2. 도서 대여");
	    System.out.println("3. 도서 대여 현황 보기");
	    System.out.println("4. 도서 반납");
	    System.out.println("0. 종료");
	    System.out.println("=================================");
	    System.out.print(">> 메뉴 선택 : ");

	    Scanner sc = new Scanner(System.in);
	    int menu = -1;
	    try {
	        menu = sc.nextInt();
	    } catch (Exception e) {
	        System.out.println("⚠️ 숫자를 입력하세요.");
	        sc.nextLine(); // 입력 버퍼 비우기
	    }
	    return menu;
	}

	static void menuBookRent() {
	    System.out.println("*** 도서 대여 ***");
	    displayBookList(STATUS_STOCK);

	    System.out.print(">> 대여할 도서 번호 입력 : ");
	    Scanner sc = new Scanner(System.in);
	    try {
	        int bookNo = sc.nextInt();

	        if (bookNo > 0 && bookNo <= bookList.length &&
	                bookList[bookNo - 1][RENT_STATUS_IDX] == STATUS_STOCK) {
	            bookList[bookNo - 1][RENT_STATUS_IDX] = STATUS_RENT;
	            displayBookList(STATUS_RENT);
	        } else {
	            System.out.println("잘못된 도서 번호입니다.");
	        }
	    } catch (Exception e) {
	        System.out.println("⚠️ 숫자를 입력하세요.");
	        sc.nextLine();
	    }
	}

	static void menuBookReturn() {
	    System.out.println("*** 도서 반납 ***");
	    displayBookList(STATUS_RENT);

	    System.out.print(">> 반납할 도서 번호 입력 : ");
	    Scanner sc = new Scanner(System.in);
	    try {
	        int bookNo = sc.nextInt();

	        if (bookNo > 0 && bookNo <= bookList.length &&
	                bookList[bookNo - 1][RENT_STATUS_IDX] == STATUS_RENT) {
	            bookList[bookNo - 1][RENT_STATUS_IDX] = STATUS_STOCK;
	        } else {
	            System.out.println("잘못된 도서입니다.");
	        }
	        displayBookList(STATUS_RENT);
	    } catch (Exception e) {
	        System.out.println("⚠️ 숫자를 입력하세요.");
	        sc.nextLine();
	    }
	}

}