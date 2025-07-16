package Models;

import java.sql.Blob;

public class CartItem {
	
	private int itemId;
	private String productname;
	private String productCategory;
	private String producteDscription;
	private double productPrice;
	private int productStock;
	private java.sql.Blob image;
	
	public CartItem() {
		super();
	}

	public CartItem(String productname, String productCategory, String producteDscription, double productPrice,
			int productStock, Blob image) {
		super();
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.image = image;
	}

	public CartItem(int itemId, String productname, String productCategory, String producteDscription,
			double productPrice, int productStock, Blob image) {
		super();
		this.itemId = itemId;
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.image = image;
	}

	public CartItem(int itemId, String productname, String productCategory, String producteDscription,
			double productPrice, int productStock) {
		super();
		this.itemId = itemId;
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	public CartItem(String productname, String productCategory, String producteDscription, double productPrice,
			int productStock) {
		super();
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProducteDscription() {
		return producteDscription;
	}

	public void setProducteDscription(String producteDscription) {
		this.producteDscription = producteDscription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public java.sql.Blob getImage() {
		return image;
	}

	public void setImage(java.sql.Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", productname=" + productname + ", productCategory=" + productCategory
				+ ", producteDscription=" + producteDscription + ", productPrice=" + productPrice + ", productStock="
				+ productStock + ", image=" + image + "]";
	}
	
	
     
     
}
