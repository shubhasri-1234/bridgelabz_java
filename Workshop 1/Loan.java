import java.time.LocalDate;
public class Loan{
   private Book book;
    private Member member;
    private LocalDate dueDate;

    public Loan(Book book, Member member, LocalDate dueDate) {
        this.book = book;
        this.member = member;
        this.dueDate = LocalDate.now().minusDays(3);
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }
     // Define the isOverdue() method
     public boolean isOverdue() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(dueDate);
    }

    // Example of a method to calculate overdue fines
    public double calculateOverdueFine() {
        if (isOverdue()) {
            long overdueDays = 3;
            int finePerDay = 1; 
            return overdueDays * finePerDay;
        } else {
            return 0.0; // No fine if not overdue
        }
    }

}