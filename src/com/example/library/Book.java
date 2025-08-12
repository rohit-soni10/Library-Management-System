package com.example.library;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String isbn;
    private boolean issued;

    public Book(int id, String title, String author, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.issued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getIsbn() { return isbn; }
    public boolean isIssued() { return issued; }

    public void setIssued(boolean issued) { this.issued = issued; }

    @Override
    public String toString() {
        return "ID:" + id + " | " + title + " by " + author + " | year:" + year + " | isbn:" + isbn + " | issued:" + issued;
    }
}
