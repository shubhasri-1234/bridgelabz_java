import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class LibrarySystem {
      private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    //operations
    //Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }
    //Add a new member to the library
    public void addMember(Member member) {
        members.add(member);
    }

    public void checkOutBook(Book book, Member member) {
        LocalDate dueDate = LocalDate.now().plusDays(30);

        // Create a new loan and add it to the list of loans
        Loan loan = new Loan(book, member, dueDate);
        loans.add(loan);
    
        System.out.println("Book checked out successfully.");
    }
      // Helper method to find a book by title
      public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find a member by name
    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public void checkInBook(Book book) {
        Loan loanToRemove = null;

        // Find the loan associated with the specified book
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loanToRemove = loan;
                break;
            }
        }

        // Remove the loan from the list of loans
        if (loanToRemove != null) {
            loans.remove(loanToRemove);
            System.out.println("Book checked in successfully.");
        } else {
            System.out.println("Book is not checked out or not found.");
        }
    }

    public double calculateOverdueFines(Member member) {
        double totalFines = 0.0;

        for (Loan loan : loans) {
            if (loan.isOverdue() && loan.getMember().equals(member)) {
                totalFines += loan.calculateOverdueFine();
            }
        }

        return totalFines;
    }

    public List<Book> getAllOverdueBooks(Member member) {
        List<Book> overdueBooks = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.isOverdue() && loan.getMember().equals(member)) {
                overdueBooks.add(loan.getBook());
            }
        }

        return overdueBooks;
    }
  

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public List<Loan> getAllCheckedOutBooks() {
        return loans;
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Adding books
        while (true){
            System.out.println("1. Add a new book");
            System.out.println("2. Add a new member");
            System.out.println("3. checkout a book to a member");
            System.out.println("4. List of checkedout books");
            System.out.println("5. Check in a book");
            System.out.println("6. Calculate overduefine for member");
            System.out.println("7. List of overdue books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                System.out.println("Enter book details:");
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Publisher: ");
                String publisher = scanner.nextLine();
                System.out.print("Genre: ");
                String genre = scanner.nextLine();
                System.out.print("Number of Pages: ");
                int numberOfPages = scanner.nextInt();

                Book book = new Book(title, author, publisher, genre, numberOfPages);
                library.addBook(book);
                break;

                case 2:
                System.out.println("\nEnter member details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Email Address: ");
                String emailAddress = scanner.nextLine();

                Member member = new Member(name, address, phoneNumber, emailAddress);
                library.addMember(member);
                break;

                case 3:
                System.out.println("Enter book title to check out:");
                String checkoutTitle = scanner.nextLine();
                System.out.println("Enter member name:");
                String memberName = scanner.nextLine();

                Book checkoutBook = library.findBookByTitle(checkoutTitle);
                Member checkoutMember = library.findMemberByName(memberName);

                if (checkoutBook != null && checkoutMember != null) {
                    library.checkOutBook(checkoutBook, checkoutMember);
                } else {
                    System.out.println("Book or member not found. Please check the title and member name.");
                }
                break;

                case 4:
                // List all books currently checked out
                List<Loan> checkedOutBooks = library.getAllCheckedOutBooks();
                System.out.println("\nBooks currently checked out:");
                for (Loan loan : checkedOutBooks) {
                    System.out.println(loan.getBook());
                }
                break;

                case 5:
                System.out.println("Enter book title to check in:");
                String checkInTitle = scanner.nextLine();
                Book checkInBook = library.findBookByTitle(checkInTitle);

                if (checkInBook != null) {
                    library.checkInBook(checkInBook);
                } else {
                        System.out.println("Book not found. Please check the title.");
                }
                break;

                case 6:
                System.out.println("Enter member name:");
                String memberNameForFines = scanner.nextLine();
                Member memberForFines = library.findMemberByName(memberNameForFines);

                if (memberForFines != null) {
                    double overdueFines = library.calculateOverdueFines(memberForFines);
                    System.out.println("Overdue fines for " + memberForFines.getName()+ "is "+ overdueFines);
                } else {
                    System.out.println("Member not found. Please check the name.");
                }
                break;
                
                case 7:
                System.out.println("Enter member name:");
                String memberNameForOverdue = scanner.nextLine();
                Member memberForOverdue = library.findMemberByName(memberNameForOverdue);

                if (memberForOverdue != null) {
                    List<Book> overdueBooks = library.getAllOverdueBooks(memberForOverdue);
                    System.out.println("\nOverdue books for " + memberForOverdue.getName() + ":");
                    for (Book overdueBook : overdueBooks) {
                        System.out.println(overdueBook);
                    }
                } else {
                    System.out.println("Member not found. Please check the name.");
                }
                break;

                case 8:
                System.out.println("Exiting the Library System. Goodbye!");
                System.exit(0);
                scanner.close();
                break;

                default:
                System.out.println("Invalid choice. Please enter a valid option.");
              
        }
         System.out.println("\nAll Books: " + library.getAllBooks());
         System.out.println("\nAll Members: " + library.getAllMembers());
    
    }
  }
}
