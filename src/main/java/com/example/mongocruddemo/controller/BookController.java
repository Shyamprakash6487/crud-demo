// src/main/java/com/example/mongocruddemo/controller/BookController.java
package com.example.mongocruddemo.controller;

import com.example.mongocruddemo.entity.Student;
import com.example.mongocruddemo.model.Book;
import com.example.mongocruddemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book updatedBook){
        return bookService.updateBook(id, updatedBook);
    }

    @GetMapping("/byAuthor")
    public List<Book> getBookByAuthor(@RequestParam String author) {
        return bookService.getBookByAuthor(author);
    }
    @GetMapping("/stu")
    public List<Student> getAllStudent(){
        return bookService.getAllStudentsFromStudentDetails();
    }

    @GetMapping("/title")
    public List<Student> getAllStudentByBookTitle(@RequestParam String bookTitle){
        return bookService.getByTitle(bookTitle);
    }

    @GetMapping("/student")
    public List<Book> getAllTitleByStudent(@RequestParam String student){
        return bookService.getByStudent(student);
    }
}
