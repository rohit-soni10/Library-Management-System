package com.example.library;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook(String title, String author, int year, String isbn) {
        books.add(new Book(nextId++, title, author, year, isbn));
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    public boolean issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isIssued()) {
                book.setIssued(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isIssued()) {
                book.setIssued(false);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
