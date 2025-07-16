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
@WebServlet("/ProductServlet")
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Prooooooooooo");
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		List<Product> allProducts = productDAOImpl.getAllProduct();
		HttpSession session = req.getSession();
		session.setAttribute("product_list", allProducts);
		
		resp.sendRedirect("productsAll.jsp");
		
	}
}
