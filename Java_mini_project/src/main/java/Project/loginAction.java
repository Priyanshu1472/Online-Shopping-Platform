package Project;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;


/**
 * Servlet implementation class loginAction
 */
@WebServlet("/loginAction")
public class loginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAction() {
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
		String password = request.getParameter("password");
		if("admin@gmail.com".equals(email) && "admin".equals(password))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email",email);	
		    response.sendRedirect("admin/adminHome.jsp");
		}
		else {
			int z=0;
			try{
				Connection con=ConnectionProvider.getCon();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from users where email='"+email+"' and password='"+password+"'");
				while(rs.next())
		        {
					z=1;
					HttpSession session=request.getSession();
					session.setAttribute("email",email);
		            response.sendRedirect("home.jsp");
		        }
				if(z==0)
					response.sendRedirect("login.jsp?msg=UserNotFound");
			}
			catch(Exception e)
		    {
		        System.out.println(e);
		        response.sendRedirect("login.jsp?msg=invalid");
		    }
		}
	}

}
