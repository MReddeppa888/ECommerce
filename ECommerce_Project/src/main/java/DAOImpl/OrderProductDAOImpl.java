package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.OrderProduct;
import DataBase.Connect;
import Models.Order;

public class OrderProductDAOImpl implements OrderProduct{

	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	ArrayList<Order> userArrayList=new ArrayList<Order>();
	
	//orderId, userId, productId, quantity, price, subTotal, orderdate, paymentMethod, address
	
	private static final String ADD_OrderItem="insert into `ordertable`(`userId`,`productId`,`quantity`,`price`,`subTotal`,`paymentMethod`,`address`) values(?,?,?,?,?,?,?)";
	
	public OrderProductDAOImpl() 
	{
		try
		{
			con=Connect.connect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public int addOrderItem(Order o) {
		try {
			pstmt=con.prepareStatement(ADD_OrderItem);
			pstmt.setInt(1, o.getUserId());
			pstmt.setInt(2, o.getProductId());
			pstmt.setInt(3, o.getQuantity());
			pstmt.setDouble(4, o.getPrice());
			pstmt.setDouble(5, o.getSubTotal());
			pstmt.setString(6, o.getPaymentMethod());
			pstmt.setString(7, o.getAddress());
			status = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Order> getAllOrderItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrderItem(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
