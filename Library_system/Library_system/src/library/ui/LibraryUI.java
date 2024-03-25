package library.ui;

import java.util.Scanner;

import library.service.LibraryServiceImpl;
import library.vo.Book;
import library.vo.Customer;

public class LibraryUI {
	 Scanner scanner = new Scanner(System.in);
	 LibraryServiceImpl service = new LibraryServiceImpl();
	// 관리자 번호
	 private final String password = "manager1";
	 
	 // 생성자
	 public LibraryUI() {
		 int menuNum = 0;
		 
		 while(true) {
			 mainMenu();
			 
			 menuNum = scanner.nextInt();
			 
			 switch(menuNum) {
			 	case 1:
			 		inputCustomer();
			 		break;
			 	case 2:
			 		readCustomer();
			 		break;
			 	case 3:
			 		updateCustomer();
			 		break;
			 	case 4:
			 		deleteCustomer();
			 		break;
			 	case 5: 
			 		readBook();
			 		break;
			 	case 6:
			 		borrowabook();
			 		break;
			 	case 7:
			 		returnabook();
			 		break;
			 	case 8:
			 		managerMenu();
			 		break;
			 	case 0:
			 		System.out.println("프로그램을 종료합니다.");
			 		System.exit(0);
			 }
		 }
	 }
	 
	public void  mainMenu() {
		 System.out.println("---------------------------");
		 System.out.println("--[ DIMA 도서관 프로그램 ]--");
		 System.out.println("1. 회원 가입");
		 System.out.println("2. 회원 정보 조회");
		 System.out.println("3. 회원 정보 수정");
		 System.out.println("4. 회원 탈퇴");
		 System.out.println("5. 도서 검색");
		 System.out.println("6. 도서 대출");
		 System.out.println("7. 도서 반납");
		 System.out.println("8. 관리자 메뉴");
		 System.out.println("0. 종료");
		 System.out.println("---------------------------");
		 System.out.print(" > 메뉴 선택: ");
	 }
		 
	public void inputCustomer() {
		Customer customer = new Customer();
		
		System.out.println("\n----[ 회원 가입 ]----");
		System.out.print("> 아이디를 입력하세요: ");
		String id = scanner.next();
		
		int searchIndex = service.searchIndex(id);
		if(searchIndex != -1) {
			System.out.println("\n> [error]  이미 존재하는 아이디입니다 !");
			return;
		}
		
		System.out.print("> 이름을 입력하세요: ");
		String name = scanner.next();
		
		customer.setId(id);
		customer.setName(name);
		
		if (service.insert(customer))
			System.out.println("\n회원 가입이 완료되었습니다.");
	}
	 
	private void readCustomer() {
		Customer customer = new Customer();
		
		System.out.println("\n----[ 회원 정보 조회 ]----");
		
		System.out.print("> 아이디를 입력하세요 ");
		String id = scanner.next();
		
		int searchIndex = service.searchIndex(id);
		if(searchIndex == -1) {
			System.out.println("\n> [error] 존재하지 않는 아이디입니다 !");
			return;
		}
		
		customer = service.searchCustomer(id);
		System.out.println(customer);
		
		}
	
	private void updateCustomer() {
		Customer customer = new Customer();
		
		System.out.println("\n----[ 회원 정보 수정 ]----");
		System.out.print("> 아이디를 입력하세요 ");
		String id = scanner.next();
		
		int searchIndex = service.searchIndex(id);
		if(searchIndex == -1) {
			System.out.println("\n> [error] 존재하지 않는 아이디입니다 !");
			return;
		}
		
		customer.setId(id);
		
		System.out.print("> 수정할 이름을 입력하세요 ");
		String name = scanner.next();
		customer.setName(name);
		
		if(service.update(customer)) System.out.println("\n 정보 수정이 완료되었습니다 !");
	}
	
	private void deleteCustomer() {
		System.out.println("\n----[ 회원 탈퇴 ]----");
		System.out.print("> 아이디를 입력하세요 ");
		String id = scanner.next();
		
		int searchIndex = service.searchIndex(id);
		if(searchIndex == -1) {
			System.out.println("\n> [error] 존재하지 않는 아이디입니다 !");
			return;
		}
		
		if(service.delete(id)) System.out.println("\n> 회원 탈퇴가 완료되었습니다 !");
	}
	
	private void readBook() {
		Book book = null;
		int menu = 0;
		
		System.out.println("\n----[ 도서 검색 ]----");
		System.out.println("1. 제목으로 검색");
		System.out.println("2. 저자로 검색");
		System.out.println("> 메뉴입력: ");
		menu = scanner.nextInt();
		
		if (menu == 1) {
			System.out.print("> 제목을 입력하세요: ");
			scanner.nextLine();
			String title = scanner.nextLine();
			
			book = service.searchBookTitle(title);
			
			if(book == null) {
				System.out.println("> [error] 도서가 존재하지 않습니다.");
				return;
			}
		}
		
		if (menu == 2) {
			System.out.print("> 저자를 입력하세요: ");
			scanner.nextLine();
			String author = scanner.nextLine();
			
			book = service.searchBookAuthor(author);
			
			if(book == null) {
				System.out.println("> [error] 도서가 존재하지 않습니다.");
				return;
			}
			
		}
		System.out.println(book);
		System.out.println(" > 1. 도서 대출하기");
		System.out.println(" > 2. 메뉴로 돌아가기");
		int menu2 = scanner.nextInt();
		
		if(menu2 == 1) {
			System.out.println("> 회원 아이디를 입력하세요: ");
			String id = scanner.next();
			
			if(service.searchIndex(id) == -1) {
				System.out.println("\n> [error]  존재하지 않는 아이디입니다 !");
				return;
			}
			
			if(!service.borrowBook(book.getBookId(), id)) {
				System.out.println("\n> [error] 대출이 불가한 도서입니다 !");
				return;
			}
			
			else if(service.borrowBook(book.getBookId(), id))
				System.out.println("\n> 도서 대출이 완료되었습니다 !");
		}

		if(menu2 == 2) return;
		
		
	}
	
	 private void managerMenu() {
		 
		System.out.println("\n----[ 관리자 메뉴 ]----");
		System.out.println("> 관리자 비밀번호를 입력하세요. ");
		String pw = scanner.next();
		
		if(!pw.equals(password)) {
			System.out.println("\n> [error] 잘못된 비밀번호 입니다 !");
			return;
		}
		
		System.out.println("> 도서 아이디 입력: ");
		String id = scanner.next();
		scanner.nextLine();
		System.out.println("> 도서 제목 입력: ");
		String title = scanner.nextLine();
		System.out.println("> 도서 저자 입력: ");
		String author = scanner.nextLine();
		
		service.insertBook(id, title, author);
		System.out.println("\n> 도서 등록이 완료되었습니다 !");
	}

	private void borrowabook() {
		System.out.println("\n----[ 도서 대출 ]----");
		System.out.println("> 도서 아이디를 입력하세요:  ");
		String bookId = scanner.next();
		
		if(service.searchBookIndex(bookId) == -1) {
			System.out.println("\n> [error]  존재하지 않는 도서 아이디입니다 !");
			return;
		}
		
		System.out.println("> 회원 아이디를 입력하세요:  ");
		String id = scanner.next();
		
		if(service.searchIndex(id) == -1) {
			System.out.println("\n> [error]  존재하지 않는 아이디입니다 !");
			return;
		}
		
		if(!service.borrowBook(bookId, id)) {
			System.out.println("\n> [error] 대출이 불가한 도서입니다 !");
			return;
		}
		
		System.out.println("\n> 도서 대출이 완료되었습니다 !");
		
	}
	
	
	private void returnabook() {
		System.out.println("\n----[ 도서 반납 ]----");
		System.out.println("> 도서 아이디를 입력하세요:  ");
		String bookId = scanner.next();
		
		if(service.searchBookIndex(bookId) == -1) {
			System.out.println("\n> [error]  존재하지 않는 도서 아이디입니다 !");
			return;
		}
		
		System.out.println("> 회원 아이디를 입력하세요:  ");
		String id = scanner.next();
		
		if(service.searchIndex(id) == -1) {
			System.out.println("\n> [error]  존재하지 않는 아이디입니다 !");
			return;
		}
		
		if(!service.returnBook(bookId, id)) {
			System.out.println("\n> [error] 반납이 불가합니다 !");
			return;
		}
		
		System.out.println("\n> 도서 반납이 완료되었습니다 !");
		
	}

} // end of class
