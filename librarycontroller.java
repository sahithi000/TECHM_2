package com.example.library.controller;
import com.example.library.model.*;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/library")
public class LibraryController {
 @Autowired
 private LibraryService service;
 @PostMapping("/books")
 public Book addBook(@RequestBody Book book) {
 return service.addBook(book);
 }
 @DeleteMapping("/books/{id}")
 public void deleteBook(@PathVariable Long id) {
 service.deleteBook(id);
 }
 @PostMapping("/users")
 public User addUser(@RequestBody User user) {
 return service.addUser(user);
 }
 @DeleteMapping("/users/{id}")
 public void deleteUser(@PathVariable Long id) {
 service.deleteUser(id);
 }
 @PostMapping("/issue")
 public Transaction issueBook(@RequestParam Long bookId, @RequestParam Long userId) {
 return service.issueBook(bookId, userId);
 }
 @PostMapping("/return")
 public Transaction returnBook(@RequestParam Long transactionId) {
 return service.returnBook(transactionId);
 }
 @GetMapping("/search/title")
 public List<Book> searchByTitle(@RequestParam String title) {
 return service.searchByTitle(title);
 }
 @GetMapping("/search/author")
 public List<Book> searchByAuthor(@RequestParam String author) {
 return service.searchByAuthor(author);
 }
 @GetMapping("/search/category")
 public List<Book> searchByCategory(@RequestParam String category) {
 return service.searchByCategory(category);
 }
 @GetMapping("/reports/overdue")
 public List<Transaction> overdueReports() {
 return service.getOverdueTransactions();
 }
 @GetMapping("/reports/user/{id}")
 public List<Transaction> userHistory(@PathVariable Long id) {
 return service.getUserTransactions(id);
 }
}
