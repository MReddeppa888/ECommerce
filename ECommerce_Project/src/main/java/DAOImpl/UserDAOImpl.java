package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DataBase.Connect;

import Models.User;

public class UserDAOImpl implements DAO.UserDAO 
{
	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	ArrayList<User> userArrayList=new ArrayList<User>();
	private User user;
	
	private static final String ADD_USER="insert into `users`(`username`,`email`,`phonenumber`,`password`,`role`,`address`) values(?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `users`";
	private static final String SELECT_ON_EMAIL="select * from `users` where `email`=?";
	private static final String UPDATE_ON_EMAIL="update `users` set `username`=?,`phonenumber`=?`address`=?,`password`=? where `email`=?";         
	private static final String DELETE_ON_EMAIL="delete  from `users` where `email`=?";
	
	public UserDAOImpl()
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
	
	public int addUser(User u) 
{
		try {
			
			pstmt=con.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setLong(3, u.getPhonenumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getRole());
			pstmt.setString(6, u.getAddress());
			status = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<User> getAllUsers() 
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userArrayList=extractUserFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userArrayList;
		
	}

	@Override
	public User getUser(String email) 
{
		

		try
		{
			pstmt=con.prepareStatement(SELECT_ON_EMAIL);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			userArrayList=extractUserFromResultSet(resultSet);
			user=userArrayList.get(0);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public int updateUser(User u) 
{
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_EMAIL);
			pstmt.setString(1, u.getUsername());
			pstmt.setLong(2, u.getPhonenumber());
			pstmt.setString(3, u.getAddress());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getEmail());
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteUser(String email) 
	{
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_EMAIL);
			pstmt.setString(1, email);
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	ArrayList<User> extractUserFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				userArrayList.add(new User(resultSet.getInt("userid"),
						resultSet.getString("username"),
						resultSet.getString("email"),
						resultSet.getLong("phonenumber"),
						resultSet.getString("password"),
						resultSet.getString("role"),
						resultSet.getString("address")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userArrayList;
	}

	
	
}



















