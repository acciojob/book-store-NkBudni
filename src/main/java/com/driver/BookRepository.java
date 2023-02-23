package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    Map<String,Book> bookMap= new HashMap<>();
    public BookRepository(){
        
    }

    public Book save(Book book){
        if(!bookMap.containsKey(book)){
            bookMap.put(book.getName(), book);
        }
        return null;
    }

    public Book findBookById(int id){
        for(Book book : bookMap.values()){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll(){
        List<Book>l= new ArrayList<>();
        if(bookMap.size()!=0){
            for(Book book : bookMap.values()){
                l.add(book);
            }
            return l;
        }
        return null;
    }

    public void deleteBookById(int id){
        for(Book book : bookMap.values()){
            if(book.getId()==id){
                bookMap.remove(book.getName());
            }
        }
        return;
    }

    public void deleteAll(){
        bookMap.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book>l = new ArrayList<>();
        for(Book book : bookMap.values()){
            if(book.getAuthor()==author){
                l.add(book);
            }
        }
        return null;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book>l = new ArrayList<>();
        for(Book book : bookMap.values()){
            if(book.getGenre()==genre){
                l.add(book);
            }
        }
        return null;
    }
}
