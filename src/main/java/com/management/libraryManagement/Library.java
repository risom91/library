package com.management.libraryManagement;

import com.management.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Library {
    private Map<String,List<Book>> departments;

    public Library(){
        this.departments = new HashMap<String, List<Book>>();
    }

    public boolean addBook(Book book){
        boolean added = false;
        List<String> bookDepartmentList = book.getDepartments();
        for(String de : bookDepartmentList) {
            if(departments.containsKey(de)){
                boolean containsBook = departments.get(de).stream().anyMatch((b) -> book.getISBN().equals(b.getISBN()));
                if(!containsBook){
                    departments.get(de).add(book);
                    added = true;
                }
            }
            else{
                List<Book> newList = new ArrayList();
                newList.add(book);
                departments.put(de,newList);
            }
        }
        // for(Map.Entry<String, List<Book>> m : departments.entrySet() ){
        //     System.out.println(m.getKey());
        //      m.getValue().forEach(System.out::println);
        // }
        return added;
    }
    
    public void removeBook(String ISBN){
        for(Map.Entry<String, List<Book>> entry : departments.entrySet()){
            entry.getValue().removeIf(b -> b.getISBN().equals(ISBN));
        }
    }

    public List<Book> findBooksByTitle(String title){
        Set<Book> bookList = new HashSet();
        for(Map.Entry<String, List<Book>> entry : departments.entrySet()){
            bookList.addAll(entry.getValue().stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).collect(Collectors.toSet()));
        }
        return new ArrayList<>(bookList);
    }

    public List<Book> findBooksByAuthor(String author){
        Set<Book> bookList = new HashSet();
        for(Map.Entry<String, List<Book>> entry : departments.entrySet()){
            bookList.addAll(entry.getValue().stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toSet()));
        }
        return new ArrayList<>(bookList);
    }
    
    public List<Book> listAllBooks(){
        Set<Book> bookList = new HashSet();
        for(Map.Entry<String, List<Book>> entry : departments.entrySet()){
            bookList.addAll(entry.getValue());
        }
        return new ArrayList<>(bookList);
    }

    public List<Book> listAllAvailableBooks(){
        Set<Book> bookList = new HashSet();
        for(Map.Entry<String, List<Book>> entry : departments.entrySet()){
            bookList.addAll(entry.getValue().stream().filter(b -> b.getAvailability()).collect(Collectors.toSet()));
        }
        return new ArrayList<>(bookList);
    }


}
