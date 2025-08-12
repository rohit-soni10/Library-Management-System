package com.example.library;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Management (CLI) ===");
            System.out.println("1) List books  2) Add book  3) Search  4) Issue  5) Return  6) Delete  0) Exit");
            System.out.print("Choose: ");
            int choice = parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> library.listBooks();
                case 2 -> addBook();
                case 3 -> searchBook();
                case 4 -> issueBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 0 -> {
                    running = false;
                    System.out.println("Bye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = parseInt(scanner.nextLine());
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        library.addBook(title, author, year, isbn);
    }

    private static void searchBook() {
        System.out.print("Keyword: ");
        String keyword = scanner.nextLine();
        Book book = library.searchBook(keyword);
        if (book != null) System.out.println(book);
        else System.out.println("Not found.");
    }

    private static void issueBook() {
        System.out.print("Book ID: ");
        int id = parseInt(scanner.nextLine());
        if (library.issueBook(id)) System.out.println("Book issued.");
        else System.out.println("Not available.");
    }

    private static void returnBook() {
        System.out.print("Book ID: ");
        int id = parseInt(scanner.nextLine());
        if (library.returnBook(id)) System.out.println("Book returned.");
        else System.out.println("Invalid ID.");
    }

    private static void deleteBook() {
        System.out.print("Book ID: ");
        int id = parseInt(scanner.nextLine());
        if (library.deleteBook(id)) System.out.println("Book deleted.");
        else System.out.println("Invalid ID.");
    }

    private static int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (Exception e) { return 0; }
    }
}
