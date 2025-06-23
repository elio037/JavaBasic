package cart;

public class CartItemVO {

	private int bookNo;
	private int quantity;
	
	public CartItemVO(int bookNo, int quantity) {
		this.bookNo = bookNo;
		this.quantity = quantity;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[" + bookNo + "번 도서, " + quantity + "권]";
	}
	
	
}
