package stockmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stockmanager.entities.BookData;

import java.util.Optional;

@Repository
public interface BookDataRepository extends JpaRepository<BookData, String> {

    Optional<BookData> findByBookId (String bookId);


}
