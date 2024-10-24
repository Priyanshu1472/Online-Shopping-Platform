package Project;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Servlet implementation class changeMobileNumberAction
 */
@WebServlet("/changeMobileNumberAction")
public class changeMobileNumberAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeMobileNumberAction() {
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
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		String mobileNumber = request.getParameter("mobileNumber");
		String password = request.getParameter("password");

		int check=0;
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where email='"+email+"' and password='"+password+"'");
			while (rs.next()) {
				check = 1;
				st.executeUpdate("update users set mobileNumber='"+mobileNumber+"' where email='"+email+"'");
				response.sendRedirect("changeMobileNumber.jsp?msg=done");
			}
			if(check== 0)
				response.sendRedirect("changeMobileNumber.jsp?msg=wrong");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
