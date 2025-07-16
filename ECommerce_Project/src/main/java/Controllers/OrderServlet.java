package Controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOImpl.OrderProductDAOImpl;
import Models.CartItem;
import Models.Order;
import Models.Product;
import Models.User;

@WebServlet("/placeOrder")
@SuppressWarnings("serial")
public class OrderServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");
		List<Product> products = (List<Product>) session.getAttribute("product_list");
		User user = (User) session.getAttribute("session_user");

		long userId=user.getUserId();
		String address = user.getAddress();
		Collection<CartItem> values = cartItems.values();
		
		OrderProductDAOImpl orderProductDAOImpl = new OrderProductDAOImpl();
		
		String paymentMethod=req.getParameter("paymentMethod");
		
		//System.out.println(user);
		//System.out.println(products);
		//System.out.println(cartItems);
		
		Iterator<CartItem> iterator = values.iterator();

		
		while (iterator.hasNext()) {
		    CartItem cartItem = iterator.next();  // Fetch only once per iteration
		    
		    
		    
		    int itemId2 = cartItem.getItemId();
		    int quantity = cartItem.getProductStock();
		    double price = cartItem.getProductPrice();
		    String productCategory = cartItem.getProductCategory();
		    String productDiscription = cartItem.getProducteDscription();
		    
		    Order order = new Order(userId, itemId2, quantity, price,address, paymentMethod);
		    
		    int orderItem = orderProductDAOImpl.addOrderItem(order);
		    System.out.println();
		    
		    
		    if(orderItem==1)
		    {
		    	resp.sendRedirect("orderSuccess.jsp");
		    }
		    
		}
		
		
		
	}
}
















