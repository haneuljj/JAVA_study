package library.vo;

public class Book {
	// 책 아이디
	private String bookId;
	// 책 제목 
	private String bookTitle;
	// 책 저자
	private String bookAuthor;
	// 책의 대출 현황
	private String bookAvailable;
	
	// 생성자
	public Book() {
		super();
	}

	public Book(String bookId, String bookTitle, String bookAuthor, String bookAvailable) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookAvailable = bookAvailable;
	}
	
	// getter, setter
	public String getBookId() {
		return bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookAvailable() {
		return bookAvailable;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookAvailable(String bookAvailable) {
		this.bookAvailable = bookAvailable;
	}

	@Override
	public String toString() {
		return "아이디: " + bookId + "     제목: " + bookTitle + "     저자: " + bookAuthor + "     대출현황: "
				+ bookAvailable ;
	}
	
	
	
}
