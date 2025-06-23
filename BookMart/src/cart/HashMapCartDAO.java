package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCartDAO implements CartDAO {
	
	Map<Integer, CartItemVO> cartDB = new HashMap<>();

	@Override
	public boolean insertCartItem(CartItemVO item) {
		cartDB.put(item.getBookNo(), item);
		return true;
	}

	@Override
	public CartItemVO selectCartItem(int bookNo) {
		
		return cartDB.get(bookNo);
	}

	@Override
	public List<CartItemVO> selectAllCartItem() {
		return new ArrayList<>(cartDB.values());
	}

	@Override
	public boolean deleteCartItem(int bookNo) {
		return cartDB.remove(bookNo) != null;
	}

	@Override
	public boolean clear() {
		cartDB.clear();
		return true;
	}

}
