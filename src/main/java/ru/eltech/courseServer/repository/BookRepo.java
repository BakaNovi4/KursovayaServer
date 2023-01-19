package ru.eltech.courseServer.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.eltech.courseServer.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE book SET title = ?1, author = ?2, price = ?3 WHERE id = ?4")
    void update(String title, String author, int price, int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM book WHERE id = ?1")
    void delete(int id);
}
