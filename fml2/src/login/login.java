package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String id1=request.getParameter("id1");
		String pwd1=request.getParameter("pwd1");
		String opt=request.getParameter("button");
		switch(opt) {
		case "admin":if(id.equals("admin")&&pwd.equals("12345678")) {
			
			request.getRequestDispatcher("fmll").forward(request, response);
			
		}
		else {
			String lol="wrong password";
			request.setAttribute("pas", lol);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
			
			
		}
		break;
		case "user":if(id1.equals("user")&&pwd1.equals("12345678")) {
			
			request.getRequestDispatcher("user").forward(request, response);
			
		}
		else {
			String lol="wrong password";
			request.setAttribute("pas", lol);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
			
			
		}
			
		}
				
		
		
	}

}
