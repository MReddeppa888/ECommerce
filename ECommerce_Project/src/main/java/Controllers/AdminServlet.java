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

@WebServlet("/ProductController")
@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session ;
		
		String add =req.getParameter("edit");
		
		//System.out.println(add);
		if(add !=null)
		{
		if(add.equals("add"))
		{
			String productname = req.getParameter("productname");
			String productCategory = req.getParameter("productCategory");
			String producteDscription = req.getParameter("producteDscription");
			double productPrice = Double.parseDouble(req.getParameter("productPrice"));
			int productStock = Integer.parseInt(req.getParameter("productStock"));
			String image = req.getParameter("image");
			
			Product product = new Product(productname, productCategory, producteDscription, productPrice, productStock, null);
			ProductDAOImpl productDAOImpl = new ProductDAOImpl();
			int product2 = productDAOImpl.addProduct(product);
			if(product2==1);
			{
				List<Product> allProduct = new ProductDAOImpl().getAllProduct();
				session = req.getSession();
    			session.setAttribute("all_products", allProduct);
    			resp.sendRedirect("adminPage.jsp");
			}
		}
		else if(add.equals("update"))
		{
			//System.out.println(add);
			int id = Integer.parseInt(req.getParameter("id"));
			String productname = req.getParameter("productname");
			String productCategory = req.getParameter("productCategory");
			String producteDscription = req.getParameter("producteDscription");
			double productPrice = Double.parseDouble(req.getParameter("productPrice"));
			int productStock = Integer.parseInt(req.getParameter("productStock"));
			String image = req.getParameter("image");
			Product product = new Product(id, productname, productCategory, producteDscription, productPrice, productStock);
			ProductDAOImpl productDAOImpl = new ProductDAOImpl();
			int updateProduct = productDAOImpl.updateProduct(product);
			if(updateProduct==1)
			{
				List<Product> allProduct = new ProductDAOImpl().getAllProduct();
				session = req.getSession();
    			session.setAttribute("all_products", allProduct);
    			resp.sendRedirect("adminPage.jsp");
			}
		}
		else if(add.charAt(0)>0){
			int id=Integer.parseInt(add);
			ProductDAOImpl productDAOImpl = new ProductDAOImpl();
			Product product = productDAOImpl.getProduct(id);
			session = req.getSession();
			session.setAttribute("product", product);
			resp.sendRedirect("updatePage.jsp");
			
			}
		}
		else
		{
			int id = Integer.parseInt(req.getParameter("id"));
			
			int deleteProduct = new ProductDAOImpl().deleteProduct(id);
			//System.out.println(deleteProduct);
			List<Product> allProduct = new ProductDAOImpl().getAllProduct();
			session = req.getSession();
			session.setAttribute("all_products", allProduct);
			resp.sendRedirect("adminPage.jsp");
		}
	}
	
	
}
