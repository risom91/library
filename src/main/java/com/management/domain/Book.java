package com.management.domain;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private int publicationYear;
    private List<String> departments;
    private boolean availability;

    public Book(String title, String author, String ISBN, String genre, int publicationYear, List<String> departments,
            boolean availability) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.departments = departments;
        this.availability = availability;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
