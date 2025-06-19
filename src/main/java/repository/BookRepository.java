package repository;

import entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b " +
            "WHERE (:status IS NULL OR b.status = :status) " +
            "AND (:author IS NULL OR b.author LIKE %:author%) " +
            "AND (:title IS NULL OR b.title LIKE %:title%) " +
            "AND (:createdAt IS NULL OR b.createdDate = :createdAt)")
    List<Book> searchBooks(
            @Param("status") String status,
            @Param("createdAt") LocalDate createdAt,
            @Param("author") String author,
            @Param("title") String title
    );

}
