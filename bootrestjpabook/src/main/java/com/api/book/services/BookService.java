package com.api.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {

	@Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book b) {
        return bookRepository.save(b);
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(Book updatedBook, int bookId) {
        if (bookRepository.existsById(bookId)) {
            updatedBook.setId(bookId);
            return bookRepository.save(updatedBook);
        }
        return null;
    }
}
