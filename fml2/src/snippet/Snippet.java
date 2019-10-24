package snippet;

public class Snippet {
	public static void main(String[] args) {
		if(id.equals("admin")&&pwd.equals("12345678")) {
					
					response.sendRedirect("library.jsp");
					
				}
				else {
					String lol="wrong pass";
					request.setAttribute("pas", lol);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
					
					
					
				}
	}
}

