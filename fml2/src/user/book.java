package user;

public class book {
	private String id;
	private String name;
	private String author;
	 
	public book(String id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public book() {
		// TODO Auto-generated constructor stub
	}
	public String getid() {
		return id;
	}
	public String getname() {
		return name;
	}
	public String getauthor() {
		return author;
	}

}
