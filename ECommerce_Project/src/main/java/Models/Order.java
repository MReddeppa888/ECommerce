package Models;

public class Order {
    private int orderId;
    private int userId;
    private int productId;
    private int quantity;
    private double price;
    private double subTotal;
    private String orderDate;
    private String paymentMethod;
    private String address;

    // Constructors
    public Order(long userId, int productId, int quantity, double price, String address, String paymentMethod) {
    	this.userId = (int) userId;
    	this.productId = productId;
    	this.quantity = quantity;
    	this.price = price;
    	 this.paymentMethod = paymentMethod;
    	 this.address = address;
    }

    public Order(int orderId, int userId, int productId, int quantity, double price,
                 double subTotal, String orderDate, String paymentMethod, String address) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.address = address;
    }
    
    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", price=" + price + ", subTotal=" + subTotal + ", orderDate=" + orderDate
				+ ", paymentMethod=" + paymentMethod + ", address=" + address + "]";
	}
    
}
