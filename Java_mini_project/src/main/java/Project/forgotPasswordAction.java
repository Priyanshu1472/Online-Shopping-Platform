package Project;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

/**
 * Servlet implementation class forgotPasswordAction
 */
@WebServlet("/forgotPasswordAction")
public class forgotPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotPasswordAction() {
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
		String email=request.getParameter("email");
		String mobileNumber=request.getParameter("mobileNumber");
		String securityQuestion=request.getParameter("securityQuestion");
		String answer=request.getParameter("answer");
		String newPassword=request.getParameter("newPassword");
		int check=0;
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where email='" + email + "' and mobileNumber='" + mobileNumber + "' and securityQuestions='" + securityQuestion + "' and answer='" + answer + "'");
			while (rs.next()) {
				check = 1;
				st.executeUpdate("update users set password='" + newPassword + "' where email='" + email + "'");
				response.sendRedirect("forgotPassword.jsp?msg=done");
			}
			if (check == 0)
			{
				response.sendRedirect("forgotPassword.jsp?msg=invalid");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
