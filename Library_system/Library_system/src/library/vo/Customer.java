package library.vo;

import java.util.ArrayList;

public class Customer {
	// 회원 이름
	private String name;
	// 회원 아이디
	private String id;
	// 회원이 대출중인 책의 객체 배열 
	private ArrayList<Book> borrowingBook = new ArrayList<Book>();
	
	// 생성자
	public Customer() {
		super();
	}

	public Customer(String name, String id, ArrayList<Book> borrowingBook) {
		super();
		this.name = name;
		this.id = id;
		this.borrowingBook = borrowingBook;
	}
	
	// setter, getter
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Book> getBorrowingBook() {
		return borrowingBook;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBorrowingBook(ArrayList<Book> borrowingBook) {
		this.borrowingBook = borrowingBook;
	}

	@Override
	public String toString() {
		return "회원아이디: " + id +"    이름: " + name + 
				"    대출중인책: " + borrowingBook ;
	}
	
	
	
}
