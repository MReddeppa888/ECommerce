package DAO;

import java.util.List;

import Models.Product;


public interface ProductDAO {

	int addProduct(Product r);
	List<Product> getAllProduct();
	 int updateProduct(Product r);
	 int updateProductImage(String imagePath,int x);
	 int deleteProduct(int getRestaurantId);
	Product getProduct(int productId);
	public List<Product> searchItems(String search);
}

