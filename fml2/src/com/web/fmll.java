package com.web;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
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
 * Servlet implementation class fmll
 */
@WebServlet("/fmll")
public class fmll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fmll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String name;
		String id;
		String author;
		String option=request.getParameter("button");
		List<book> book2=new LinkedList<>();
		
		switch(option) {
		case "add": name=request.getParameter("name");
		author=request.getParameter("author");
		id=request.getParameter("id");
		
		Document doc=new Document("name","books").append("id", id).append("Book name",name).append("author",author).append("comments",new Document());
		collection.insertOne(doc);
		
		
		MongoCursor<Document> cursor =  collection.find().iterator();
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();

			book book1 = new book(d.getString("id"), d.getString("Book name"), d.getString("author"));
			book2.add(book1);		
			}
		request.setAttribute("book", book2);
		break;
		case "delete":

			String n3=request.getParameter("id");
			collection.deleteMany(Filters.eq("id",n3));
			//List<book> book3=new LinkedList<>();
			MongoCursor<Document> cursor1 =  collection.find().iterator();
			while (cursor1.hasNext()) {
				Document d = (Document) cursor1.next();

				book book1 = new book(d.getString("id"), d.getString("Book name"), d.getString("author"));
				book2.add(book1);		
				}
			request.setAttribute("book", book2);
			break;
		case "update":
			String n4=request.getParameter("id");
			String booku=request.getParameter("name");
			String authoru=request.getParameter("author");
			collection.updateOne(Filters.eq("id",n4),Updates.combine(Updates.set("Book name",booku),Updates.set("author",authoru)));
			MongoCursor<Document> cursor3 =  collection.find().iterator();
			while (cursor3.hasNext()) {
				Document d = (Document) cursor3.next();

				book book1 = new book(d.getString("id"), d.getString("Book name"), d.getString("author"));
				book2.add(book1);	
			
		
		}
			request.setAttribute("book", book2);

			break;
		}
		
		
		
		
		//request.setAttribute("book", book2);
		request.getRequestDispatcher("library.jsp").forward(request, response);
		
	}

}
