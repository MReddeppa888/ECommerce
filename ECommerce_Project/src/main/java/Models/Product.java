package Models;

import java.sql.Blob;

public class Product {
	
	private int productId;
	private String productname;
	private String productCategory;
	private String producteDscription;
	private double productPrice;
	private int productStock;
	private java.sql.Blob image;
	
	public Product(int productId, String productname, String productCategory, String producteDscription,
			double productPrice, int productStock) {
		
		super();
		this.productId = productId;
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		
	}

	public Product(int productId, String productname, String productCategory, String producteDscription,
			double productPrice, int productStock, Blob image) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.image = image;
	}

	public Product(String productname, String productCategory, String producteDscription, double productPrice,
			int productStock, Blob image) {
		super();
		this.productname = productname;
		this.productCategory = productCategory;
		this.producteDscription = producteDscription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.image = image;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
		return "Product [productId=" + productId + ", productname=" + productname + ", productCategory="
				+ productCategory + ", producteDscription=" + producteDscription + ", productPrice=" + productPrice
				+ ", productStock=" + productStock + ", image=" + image + "]";
	}
	
	
}
