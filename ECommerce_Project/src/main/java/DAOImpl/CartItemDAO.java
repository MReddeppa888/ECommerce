package DAOImpl;

import java.util.LinkedHashMap;
import java.util.Map;

import Models.CartItem;

public class CartItemDAO {
	
	//The cart items,stored as a map of item add to cartItems objects
	public static Map<Integer, CartItem>  items;
	
	
	public CartItemDAO()
	{
		items=new LinkedHashMap<Integer, CartItem>();
	}
	int itemId;
	
	// Add an item to the cart
	public Map<Integer, CartItem> addItem(CartItem item)
	{
		 itemId= item.getItemId();
		if(items.containsKey(itemId))
		{
			// if item already exits,increase the quantity
			CartItem existingItem = items.get(itemId);
			existingItem.setProductStock(existingItem.getProductStock()+item.getProductStock());
			
		}
		else
		{
			// if item is new ,add to cart
			items.put(itemId, item);
		}
		return items;
	}
	
	
	 //Update the quantity of an item in the cart
	public Map<Integer, CartItem> updateItem(int itemId,int quantity)
	{
		if(items.containsKey(itemId))
		{
			if(quantity<=0)
			{
				items.remove(itemId);
			}
			else
			{
				items.get(itemId).setProductStock(quantity);
			}
		}
		return items;
	}
	
	 //Remove an item from the cart
		public Map<Integer, CartItem> removeItem(int itemId)
		{
			items.remove(itemId);
			return items;
		}
		
		
	// Get all items in the cart
		public Map<Integer, CartItem> getItems()
		{
			return items;
		}
		
	// Clear the Cart 
		public Map<Integer, CartItem> clearCart()
		{
			items.clear();
			return items;
		}
}







