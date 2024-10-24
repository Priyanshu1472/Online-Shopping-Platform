package Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class addressPaymentForOrderAction
 */
@WebServlet("/addressPaymentForOrderAction")
public class addressPaymentForOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addressPaymentForOrderAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email = session.getAttribute("email").toString();
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String mobileNumber = request.getParameter("mobileNumber");
		String paymentMethod = request.getParameter("paymentMethod");
		String transactionId = "";
		transactionId = request.getParameter("transactionId");
		String status = "bill";

		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps = con.prepareStatement("update users set address=?, city=?, state=?, country=?, mobileNumber=? where email=?");
			ps.setString(1, address);
			ps.setString(2, city);
			ps.setString(3, state);
			ps.setString(4, country);
			ps.setString(5, mobileNumber);
			ps.setString(6, email);
		    ps.executeUpdate();
		    
		    PreparedStatement ps1 = con.prepareStatement("update cart set address=?, city=?, state=?, country=?, mobileNumber=?, orderDate=now(), deliveryDate=DATE_ADD(orderDate,INTERVAL 7 DAY), paymentMethod=?, transactionId=?, status=? where email=? and address is NULL");
		    ps1.setString(1, address);
		    ps1.setString(2, city);
		    ps1.setString(3, state);
		    ps1.setString(4, country);
		    ps1.setString(5, mobileNumber);
		    ps1.setString(6, paymentMethod);
		    ps1.setString(7, transactionId);
		    ps1.setString(8, status);
		    ps1.setString(9, email);
		    ps1.executeUpdate();
		    response.sendRedirect("bill.jsp");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
