package DAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DAO.ProductDAO;
import DataBase.Connect;
import Models.Product;

public class ProductDAOImpl implements ProductDAO {

	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	String imagePath = null; // Change to your image path
	
	
	List<Product> list=new ArrayList<Product>();
	private Product product;
	
	//productId, productname, productCategory, producteDscription, productPrice, productStock, image

	private static final String ADD_PRODUCT="insert into `product`(`productname`,`productCategory`,`producteDscription`,`productPrice`,`productStock`) values(?,?,?,?,?)";
	private static final String SELECT_ALL_PRODUCT="select * from `product`";
	private static final String SELECT_ON_PRODUCTId="select * from `product` where `productId`=?";
	private static final String UPDATE_ON_productId="update `product` set `productname`=?,`productCategory`=?,`producteDscription`=?,`productPrice`=?,`productStock`=? where `productId`=?";         
	private static final String DELETE_ON_productId="delete  from `product` where `productId`=?";
	private static final String SEARCH_ON_NAME="SELECT * FROM product WHERE `productname` LIKE ?";
	
	public ProductDAOImpl()
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
	public int addProduct(Product r) {
		try {
			pstmt=con.prepareStatement(ADD_PRODUCT);
			pstmt.setString(1, r.getProductname());
			pstmt.setString(2, r.getProductCategory());
			pstmt.setString(3, r.getProducteDscription());
			pstmt.setDouble(4, r.getProductPrice());
			pstmt.setInt(5, r.getProductStock());
			//pstmt.setBinaryStream(6, r.getImage());
			status = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Product> getAllProduct() {
		try
		{
			
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL_PRODUCT);
			list=extractUserFromResultSet(resultSet);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProduct(int productId) {
		
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_PRODUCTId);
			pstmt.setInt(1, productId);
			
			resultSet=pstmt.executeQuery();
			list=extractUserFromResultSet(resultSet);
			product=list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public int updateProduct(Product r) {
		System.out.println(r);
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_productId);
			pstmt.setString(1, r.getProductname());
			pstmt.setString(2, r.getProductCategory());
			pstmt.setString(3, r.getProducteDscription());
			pstmt.setDouble(4, r.getProductPrice());
			pstmt.setInt(5, r.getProductStock());
			//pstmt.setBinaryStream(6, r.getImage());
			pstmt.setInt(6, r.getProductId());
			System.out.println(status);
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateProductImage(String imagePath, int x) {
		try
		{
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteProduct(int productId) {
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_productId);
			pstmt.setInt(1, productId);
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public List<Product> searchItems(String search) {
			
		try
		{
			pstmt=con.prepareStatement(SEARCH_ON_NAME);
			pstmt.setString(1,"%"+search+"%");
			
			resultSet=pstmt.executeQuery();
			list=extractUserFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	List<Product> extractUserFromResultSet(ResultSet resultSet)
	{
		
		try
		{
			while(resultSet.next())
			{
				
				int  productId=resultSet.getInt("productId");
				String productname=resultSet.getString("productname");
				String	productCategory=resultSet.getString("productCategory");
				String	producteDscription=resultSet.getString("producteDscription");
				Double	productPrice=resultSet.getDouble("productPrice");
				int	 productStock=resultSet.getInt("productStock");
				Blob	image=resultSet.getBlob("image");
				
				//System.out.println(imagePath);
			
				list.add(new Product(productId, productname, productCategory, producteDscription, productId, productStock, image));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
