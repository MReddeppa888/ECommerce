package Controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOImpl.CartItemDAO;
import DAOImpl.ProductDAOImpl;
import Models.CartItem;
import Models.Product;



@WebServlet("/cart")
@SuppressWarnings("serial")
public class CartServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Integer, CartItem> items = null;
		HttpSession session = req.getSession();
		
		CartItemDAO cart =(CartItemDAO) session.getAttribute("cart");
		
		if(cart==null)
		{
			cart=new CartItemDAO();
			session.setAttribute("cart", cart);
		}
		
		String itemId = req.getParameter("itemId");
		String action = req.getParameter("action");
		if("add".equals(action))
		{
			 items = addItemToCart(req,cart);
		}
		else if("update".equals(action))
		{
			items=updateCartItem(req,cart);
		}
		else if("remove".equals(action))
		{
			 items = removeItemFromCart(req,cart);
		}
		else if("CheckOutUpdate".equals(action))
		{
			items = updateCartItem(req,cart);
			session.setAttribute("session_cart", items);
			resp.sendRedirect("checkOut.jsp");
		}
		else if("homeCart".equals(action))
		{
			items = addItemToCart(req,cart);
			session.setAttribute("session_cart", items);
			resp.sendRedirect("cart.jsp");
		}
		if(!("CheckOutUpdate".equals(action))&& !("homeCart".equals(action)))
		{
			session.setAttribute("session_cart", items);
			resp.sendRedirect("cart.jsp");
		}
		
		
		
		
	}	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
		
	}
	
	
	private Map<Integer, CartItem> addItemToCart(HttpServletRequest req, CartItemDAO cart) {

		
		Map<Integer, CartItem> items = null;
		
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		 ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		
		 Product product = productDAOImpl.getProduct(itemId);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("productId",product.getProductId() );		
		if(product !=null)
		{
			CartItem item=new CartItem(product.getProductId(),product.getProductname(),
					product.getProductCategory(),product.getProducteDscription(),product.getProductPrice(),product.getProductStock());
			
			items = cart.addItem(item);
			
		}
		return items;
	}
	
	private Map<Integer, CartItem> updateCartItem(HttpServletRequest req, CartItemDAO cart) {
		
		int itemId = (Integer.parseInt(req.getParameter("itemId")));
		int quantiry = (Integer.parseInt(req.getParameter("quantity")));
		
		Map<Integer, CartItem> items = cart.updateItem(itemId, quantiry);
		
		return items;
	}
	
		
	private Map<Integer, CartItem> removeItemFromCart(HttpServletRequest req, CartItemDAO cart) {

		int itemId=(Integer.parseInt(req.getParameter("itemId")));
		
		Map<Integer, CartItem> items=cart.removeItem(itemId);
		return items;
	}


	

	
}