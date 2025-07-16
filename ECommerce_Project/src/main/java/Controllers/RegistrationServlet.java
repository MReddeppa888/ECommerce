package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DAOImpl.UserDAOImpl;
import Models.User;



@SuppressWarnings("serial")
@WebServlet("/registerUser")
public class RegistrationServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("name");
		String email=req.getParameter("email");
		Long phonenumber=Long.parseLong(req.getParameter("phoneNumber"));
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		String address=req.getParameter("address");
		
		//System.out.println(username+" "+email+" "+phonenumber+" "+password+" "+role+" "+address);
		User u=new Models.User(username, email, phonenumber, password, role, address);
		//System.out.println(u.toString());
		UserDAO userDAO =new  UserDAOImpl();
		int x=userDAO.addUser(u);
		System.out.println(x);
		if(x==1)
		{
			resp.sendRedirect("registrationSuccess.jsp");
		}
		else
		{
			resp.sendRedirect("registrationFailure.jsp");
		}
	}
}
