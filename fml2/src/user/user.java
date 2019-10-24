package user;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


/**
 * Servlet implementation class user
 */
@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("date");
		MongoCollection<Document> collection = database.getCollection("libraryweb1");
		
		
		List<book> book2=new LinkedList<>();
		MongoCursor<Document> cursor =  collection.find().iterator();
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();

			book book1 = new book(d.getString("id"), d.getString("Book name"), d.getString("author"));
			book2.add(book1);		
			}
		request.setAttribute("book", book2);
		
		//request.getRequestDispatcher("user.jsp").forward(request, response);
		
	/*	catch(Exception ie) {
		String option=request.getParameter("button");
		switch(option) {
		case "view":
			response.sendRedirect("view.jsp");
			break;
		case "add":
			response.sendRedirect("add.jsp");
			break;
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("date");
		MongoCollection<Document> collection = database.getCollection("libraryweb1");
		String option=request.getParameter("button");
		
		switch(option) {
		case "add": 
			response.sendRedirect("add.jsp");
			break;
		case "view":
			response.sendRedirect("view.jsp");
			break;
		default : request.getRequestDispatcher("user.jsp").forward(request, response);
		break;
		
		}
		
			}
	}
	


