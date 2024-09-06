public class Loan {
    private Book book;
    private Member member;
    private String loanDate;

    public Loan(Book book, Member member, String loanDate) {
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        book.setAvailable(false);
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public String getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", member=" + member +
                ", loanDate='" + loanDate + '\'' +
                '}';
    }
}
