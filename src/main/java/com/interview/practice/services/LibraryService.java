package com.interview.practice.services;

import com.interview.practice.exceptions.BookNotAvailableException;
import com.interview.practice.model.Book;
import com.interview.practice.model.Library;
import com.interview.practice.model.Member;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LibraryService {

    private final Library library = new Library();

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(int bookId) {
        Book book = library.getBooks().stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        library.removeBook(book);
    }

    public synchronized void borrowBook(int memberId, int bookId) {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        // Check if book is available
        if (book.getQuantity() <= 0) {
            throw new BookNotAvailableException("No copies of the book are available for borrowing");
        }

        // Borrow the book (decrease quantity)
        book.setQuantity(book.getQuantity() - 1);
        member.addBorrowedBook(book);
    }

    public void returnBook(int memberId, int bookId) {
        Member member = getMemberById(memberId);
        Book book = member.getBorrowedBooks().stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not borrowed by this member"));

        // Return the book (increase quantity)
        book.setQuantity(book.getQuantity() + 1);
        member.removeBorrowedBook(book);
    }

    public Set<Book> getAllBooks() {
        return library.getBooks();
    }

    private Book getBookById(int bookId) {
        return library.getBooks().stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    private Member getMemberById(int memberId) {
        return library.getMembers().stream()
                .filter(member -> member.getId() == memberId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

    public void addMember(Member member) {
        library.addMember(member);
    }
}