package com.interview.practice.controllers;

import com.interview.practice.model.Book;
import com.interview.practice.model.Member;
import com.interview.practice.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    @PostMapping("/books")
    public String addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return "Book added to catalog successfully!";
    }


    @DeleteMapping("/books/{bookId}")
    public String removeBook(@PathVariable int bookId) {
        libraryService.removeBook(bookId);
        return "Book removed from catalog successfully!";
    }


    @GetMapping("/books")
    public Set<Book> getBooks() {
        return libraryService.getAllBooks();
    }


    @PostMapping("/members/{memberId}/borrow/{bookId}")
    public String borrowBook(@PathVariable int memberId, @PathVariable int bookId) {
        libraryService.borrowBook(memberId, bookId);
        return "Book borrowed successfully!";
    }

    @PostMapping("/members/{memberId}/return/{bookId}")
    public String returnBook(@PathVariable int memberId, @PathVariable int bookId) {
        libraryService.returnBook(memberId, bookId);
        return "Book returned successfully!";
    }

    @PostMapping("/members")
    public String addMember(@RequestBody Member member) {
        libraryService.addMember(member);
        return "Member added successfully!";
    }
}