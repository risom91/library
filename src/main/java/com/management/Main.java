package com.management;

import com.management.libraryManagement.Library;

import java.util.List;
import java.util.Scanner;

import com.management.domain.Book;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid entry, enter again");
                    printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nLibrary Menu:");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Find Book by the Title");
        System.out.println("4. Find Book by the Author Name");
        System.out.println("5. List all the Books");
        System.out.println("6. List all the available Books");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter publication year: ");
        int publicationYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter departments (give comma in between): ");
        String departmentsInput = scanner.nextLine();
        List<String> departments = List.of(departmentsInput.split(","));

        System.out.print("Is the book available (true/false): ");
        boolean availability = Boolean.parseBoolean(scanner.nextLine());

        Book book = new Book(title, author, ISBN, genre, publicationYear, departments, availability);
        boolean added = library.addBook(book);
        if(added) System.out.println("Book added");

    }

    private static void removeBook() {
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
        System.out.println("Book removed");
    }

    private static void findBookByTitle() {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        List<Book> books = library.findBooksByTitle(title);

        if (books.isEmpty()) {
            System.out.println("No books found ");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void findBookByAuthor() {
        System.out.print("Enter author's name: ");
        String author = scanner.nextLine();

        List<Book> books = library.findBooksByAuthor(author);

        if (books.isEmpty()) {
            System.out.println("No books found");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void listAllBooks() {
        List<Book> books = library.listAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void listAvailableBooks() {
        List<Book> books = library.listAllAvailableBooks();

        if (books.isEmpty()) {
            System.out.println("No available books ");
        } else {
            books.forEach(System.out::println);
        }
    }
}
