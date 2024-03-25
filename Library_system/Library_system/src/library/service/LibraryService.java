package library.service;

import library.vo.Book;
import library.vo.Customer;

/**
 * LibraryServiceImpl에서 구현할 인터페이스 정의
 */
public interface LibraryService {
		
		/**
		 * 	전달받은 Customer 객체를 배열에 추가
		 * @param customer 배열에 추가할 customer 객체
		 * @return 전달받은 정보가 배열에 추가되면 true, 그렇지 않으면 false
		 */
		public boolean insert(Customer customer);
		
		/**
		 * 전달받은 customer객체의 id로 그 아이디에 해당하는 customer정보를 리턴
		 * @param 회원 id
		 * @return 전달받은 id에 해당하는 회원 객체
		 */
		public Customer searchCustomer(String id);
		
		/**
		 * 전달받은 customer객체의 id로 그 아이디에 해당하는 customer정보를 수정
		 * @param 수정된 정보를 담은 회원 객체
		 * @return  정보 수정을 성공하면 true, 정보 수정이 실패되면 false 
		 */
		public boolean update(Customer customer);
		
		/**
		 * 회원의 아이디를 입력받아 해당하는 객체를 배열에서 삭제
		 * @param 회원 id
		 * @return 회원 삭제가 성공하면 true, 회원 삭제가 실패되면 false 
		 */
		public boolean delete(String id);
		
		/**
		 * 전달받은 번호를 customer 배열에서 검색한다
		 * @param 검색할 회원 번호
		 * @return 배열에서 찾은 인덱스 번호, 없으면 -1
		 */
		public int searchIndex(String id);
		
		/**
		 * 전달받은 번호를 book 배열에서 검색한다
		 * @param 검색할 책 아이디
		 * @return 배열에서 찾은 인덱스 번호, 없으면 -1
		 */
		public int searchBookIndex(String id);
		
		/**
		 * 전달받은 book객체를배열에 추가
		 * @param book 객체
		 * @return 객체가 성공적으로 배열에 추가되면 true, 안되면 false
		 */
		public boolean insertBook(String bookId, String bookTitle, String bookAuthor);
		
		/**
		 * 입력받은 책 제목으로 배열에서 해당하는 책 정보 검색
		 * @param 검색할 책의 제목
		 * @return 책에 제목에 해당하는 책 정보, 없으면 null
		 */
		public Book searchBookTitle(String bookTitle);
		
		/**
		 * 입력받은 책 제목으로 배열에서 해당하는 책 정보 검색
		 * @param 검색할 책의 제목
		 * @return 책에 제목에 해당하는 책 정보, 없으면 null
		 */
		public Book searchBookAuthor(String bookAuthor);
		
		/**
		 * 책아이디를 입력받아 회원 객체 속성인 대출중인 책 배열에 추가하고, 
		 * 책 배열에서 해당하는 책을 찾아 대출중으로 현황 변경
 		 * @param 대출할 책의 아이디
		 * @return 대출 성공시 true, 실패시 false
		 */
		public boolean borrowBook(String bookI, String id);
		
		/**
		 *  책아이디를 입력받아 회원 객체 속성인 대출중인 책 배열에서 삭제하고, 
		 * 책 배열에서 해당하는 책을 찾아 대출가능으로 현황 변경
		 * @param 반납할 책의 아이디
		 * @return 반납 성공시 true, 실패시 false
		 */
		public boolean returnBook(String bookId, String id);
}
