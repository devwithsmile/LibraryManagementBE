package com.interview.practice.model;

import java.util.HashSet;
import java.util.Set;

public class Library {

    private Set<Book> books = new HashSet<>();
    private Set<Member> members = new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Member> getMembers() {
        return members;
    }

    // Add a book, increase quantity if it already exists
    public void addBook(Book book) {
        if (!books.add(book)) {
            for (Book b : books) {
                if (b.equals(book)) {
                    b.increaseQuantity(1);
                }
            }
        }
    }

    // Remove a book
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Add a member
    public void addMember(Member member) {
        members.add(member);
    }
}