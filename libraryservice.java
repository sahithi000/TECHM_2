package com.example.library.service;
import com.example.library.model.*;
import com.example.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class LibraryService {
 @Autowired
 private BookRepository bookRepo;
 @Autowired
 private UserRepository userRepo;
 @Autowired
 private TransactionRepository transactionRepo;
 public Book addBook(Book book) {
 book.setAvailability(true);
 return bookRepo.save(book);
 }
 public void deleteBook(Long bookId) {
 bookRepo
}
 public User addUser(User user) {
 return userRepo.save(user);
 }
 public void deleteUser(Long userId) {
 userRepo.deleteById(userId);
 }
 public Transaction issueBook(Long bookId, Long userId) {
 Book book = bookRepo.findById(bookId).orElseThrow();
 if (!book.isAvailability()) throw new RuntimeException("Book not available");
 User user = userRepo.findById(userId).orElseThrow();
 Transaction transaction = new Transaction(null, book, user, LocalDate.now(),
LocalDate.now().plusDays(14), "ISSUED");
 book.setAvailability(false);
 bookRepo.save(book);
 return transactionRepo.save(transaction);
 }
 public Transaction returnBook(Long transactionId) {
 Transaction transaction = transactionRepo.findById(transactionId).orElseThrow();
 transaction.setStatus("RETURNED");
 transaction.getBook().setAvailability(true);
 bookRepo.save(transaction.getBook());
 return transactionRepo.save(transaction);
 }
 public List<Book> searchByTitle(String title) {
 return bookRepo.findByTitleContaining(title);
