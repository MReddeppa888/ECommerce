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
import Models.Product;
@WebServlet("/find")
@SuppressWarnings("serial")
public class FetchProduct extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("search");
		System.out.println(search);
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		
		List<Product> searchItems = productDAOImpl.searchItems(search);
		HttpSession session = req.getSession();
		session.setAttribute("search_list", searchItems);
		//System.out.println(searchItems);
		resp.sendRedirect("searchItems.jsp");
		
	}
}
