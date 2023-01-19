package ru.eltech.courseServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltech.courseServer.entity.BookEntity;
import ru.eltech.courseServer.repository.BookRepo;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<BookEntity> getBooks() throws SQLException {
        return bookRepo.findAll();
    }

    public BookEntity createBook(String title, String author, int price) throws SQLException {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(title);
        bookEntity.setAuthor(author);
        bookEntity.setPrice(price);
        return bookRepo.save(bookEntity);
    }

    public void updateBook(int id, String title, String author, int price) throws SQLException {
        bookRepo.update(title, author, price, id);
    }

    public void deleteBook(int id) throws SQLException {
        bookRepo.delete(id);
    }
}
