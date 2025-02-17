package Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editProductAction
 */
@WebServlet("/editProductAction")
public class editProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProductAction() {
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
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		String price=request.getParameter("price");
		String active=request.getParameter("active");

		try{
			Connection con = ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("update product set name='"+name+"', category='"+category+"', price='"+price+"', active='"+active+"' where id='"+id+"'");
			if(active.equals("No")) {
				st.executeUpdate("delete from cart where product_id='" + id + "' and address is NULL");
			}
			response.sendRedirect("admin/allProductEditProduct.jsp?msg=done");
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("admin/allProductEditProduct.jsp?msg=wrong");
		}
	}

}
