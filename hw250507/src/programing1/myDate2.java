package programing1;

public class myDate2 {

	public static void main(String[] args) {
		myDate d = null;
		try {
			System.out.printf("%d년 %d월 %d일\n", d.year, d.month, d.day);
			
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		}
		
		d = new myDate();
		System.out.printf("%d년 %d월 %d일\n", d.year, d.month, d.day);
		
	}

	public static class myDate {
		int year = 2035;
		int month = 12;
		int day = 25;
	}

}
