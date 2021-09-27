package stockmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stockmanager.entities.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {


    Book findByTitle(String title);



}
