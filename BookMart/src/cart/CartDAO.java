package cart;

import java.util.List;

public interface CartDAO {
	boolean insertCartItem(CartItemVO item);
	CartItemVO selectCartItem(int bookNo);
	List<CartItemVO> selectAllCartItem();
	boolean deleteCartItem(int bookNo);
	boolean clear();
}
