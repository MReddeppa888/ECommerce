package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOImpl.ProductDAOImpl;
import DAOImpl.UserDAOImpl;
import Models.Product;
import Models.User;

@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
    	String password=req.getParameter("password");
    	
    	HttpSession session = req.getSession();
    	UserDAOImpl userDAOImpl = new UserDAOImpl();
    	User user = userDAOImpl.getUser(email);
    	
    	//System.out.println(user);
    	if(user !=null&& (password.equals(user.getPassword())))
    	{
    		if(user.getRole().equals("user"))
    		{
    			session.setAttribute("session_user", user);
    			resp.sendRedirect("ProductServlet");
    		}
    		else if(user.getRole().equals("admin"))
    		{
    			List<Product> allProduct = new ProductDAOImpl().getAllProduct();
    			session.setAttribute("all_products", allProduct);
    			resp.sendRedirect("adminPage.jsp");
    		}
    		else
    		{
    			System.out.println("please Login Try Again");
    		}
    	}
    	else 
    	{
    		resp.sendRedirect("registration.jsp");
    	}
	}
}
