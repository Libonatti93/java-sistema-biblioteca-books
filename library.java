import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void loanBook(String bookTitle, String memberId, String loanDate) {
        Book book = findBookByTitle(bookTitle);
        Member member = findMemberById(memberId);

        if (book != null && member != null && book.isAvailable()) {
            Loan loan = new Loan(book, member, loanDate);
            loans.add(loan);
            System.out.println("Book loaned successfully!");
        } else {
            System.out.println("Cannot loan the book. It might be unavailable or not found.");
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void listMembers() {
        System.out.println("Library Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        // Adicionando livros
        library.addBook(new Book("O Senhor dos Anéis", "J.R.R. Tolkien"));
        library.addBook(new Book("Harry Potter", "J.K. Rowling"));

        // Adicionando membros
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        // Listando livros disponíveis
        library.listAvailableBooks();

        // Realizando empréstimo de um livro
        library.loanBook("Harry Potter", "M001", "2024-09-06");

        // Listando livros disponíveis após o empréstimo
        library.listAvailableBooks();

        // Listando membros
        library.listMembers();
    }
}
