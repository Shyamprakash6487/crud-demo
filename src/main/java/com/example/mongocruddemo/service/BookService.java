// src/main/java/com/example/mongocruddemo/service/BookService.java
package com.example.mongocruddemo.service;

import com.example.mongocruddemo.entity.Student;
import com.example.mongocruddemo.feignclient.BookFeignClient;
import com.example.mongocruddemo.model.Book;
import com.example.mongocruddemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookFeignClient bookFeignClient;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(String id,Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());

            return bookRepository.save(existingBook);
        }
        return null;
    }
    public List<Book> getBookByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Student> getAllStudentsFromStudentDetails(){
        return bookFeignClient.getAllStudents();
    }
    public List<Student> getByTitle(String bookTitle){
        return bookFeignClient.getByBooktitle(bookTitle);
    }
    public  List<Book> getByStudent(String student){
        return bookRepository.findByStudent(student);
    }
}
