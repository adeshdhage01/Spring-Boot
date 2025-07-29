package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.book.entities.Book;

@Service
public class BookService {

    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(151, "The Complete Java Reference", "XYZ"));
        bookList.add(new Book(152, "WEB Technologies", "ABC"));
        bookList.add(new Book(153, "Linux System Programming", "MNO"));
    }

    public List<Book> getAllBooks() {
        return bookList;
        }

    public Book getBookById(int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book b) {
        bookList.add(b);
        return b;
    }

    public void deleteBook(int bookId) {
        List<Book> updatedList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getId() != bookId) {
                updatedList.add(book);
            }
        }
        bookList = updatedList;
    }

    public Book updateBook(Book updatedBook, int bookId) {
        for (Book b : bookList) {
            if (b.getId() == bookId) {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                return b;
            }
        }
        return null;
    }

}
