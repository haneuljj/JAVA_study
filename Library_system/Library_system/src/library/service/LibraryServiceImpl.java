package library.service;

import java.util.ArrayList;
import java.util.List;

import library.vo.Book;
import library.vo.Customer;

public class LibraryServiceImpl implements LibraryService{
	
	// 회원 정보를 저장할 리스트
	List<Customer> customerList = new ArrayList<>();
	// 책 정보를 저장할 리스트
	List<Book> bookList = new ArrayList<>();
	
	
	@Override
	public boolean insert(Customer customer) {
		boolean result = false;
		customerList.add(customer);	
		result = true;
		
		return result;
	}

	@Override
	public Customer searchCustomer(String id) {
		int index = searchIndex(id);
		return customerList.get(index);
	}

	@Override
	public boolean update(Customer customer) {
		boolean result = false;
		int index = searchIndex(customer.getId());
		
		customerList.get(index).setName(customer.getName());
		result = true;
		
		return result;
	}

	@Override
	public boolean delete(String id) {
		boolean result = false;
		int index = searchIndex(id);
		
		customerList.remove(index);
		result = true;
		
		return result;
	}

	@Override
	public int searchIndex(String id) {
		int index = -1;
		for (int i=0; i<customerList.size(); ++i) {
			if(customerList.get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public int searchBookIndex(String bookId) {
		int index = -1;
		for (int i=0; i<bookList.size(); ++i) {
			if(bookList.get(i).getBookId().equals(bookId)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public boolean insertBook(String bookId, String bookTitle, String bookAuthor) {
		Book book = new Book(bookId, bookTitle, bookAuthor, "대출가능");
		bookList.add(book);
		return true;
	}

	@Override
	public Book searchBookTitle(String bookTitle) {
		Book book = null;
		
		for(int i=0; i<bookList.size(); ++i) {
			if(bookList.get(i).getBookTitle().equals(bookTitle)) {
				book = bookList.get(i);
				break;
			}
		}
		return book;
	}
	
	@Override
	public Book searchBookAuthor(String bookAuthor) {
		Book book = null;
		
		for(int i=0; i<bookList.size(); ++i) {
			if(bookList.get(i).getBookAuthor().equals(bookAuthor)) {
				book = bookList.get(i);
				break;
			}
		}
		return book;
	}

	@Override
	public boolean borrowBook(String bookId, String id) {
		boolean result = false;
		Book book = null;
		
		int bookIndex = searchBookIndex(bookId);
		book = bookList.get(bookIndex);
		
		if (book.getBookAvailable().equals("대출불가"))
				result = false;

		
		
		if (book.getBookAvailable().equals("대출가능")) {
			// 회원 객체 속성 중 대출중인 책 리스트에 책 객체 추가
			int custIndex = searchIndex(id);
			customerList.get(custIndex).getBorrowingBook().add(book);
			
			// 책의 대출 현황을 대출 불가로 바꾸기
			book.setBookAvailable("대출불가");
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean returnBook(String bookId, String id) {
		Book book = null;
		Customer customer = null;
		
		int bookIndex = searchBookIndex(bookId);
		book = bookList.get(bookIndex);
		
		int custIndex = searchIndex(id);
		customer = customerList.get(custIndex);
		
		// 	입력한 회원 아이디에 해당하는 회원 객체의 대출 하는책의 리스트가 비어있을 경우
		if (customer.getBorrowingBook().isEmpty()) {
			return false;
		}
			
		// 입력한 회원 아이디에 해당하는 회원 객체의 대출 하는 책 리스트에 해당하는 책이 없을 경우
		if (!customer.getBorrowingBook().contains(book)) {
			return false;
		}
		
		// 회원의 대출 책 리스트에서 해당하는 책 제거 
		customer.getBorrowingBook().remove(bookIndex);
		// 책의 대출 현황을 대출 가능으로 바꾸기
		book.setBookAvailable("대출가능");
		
		return true;
	}

	
}
