package patterns.infrastructure.output.reporsitory;

import java.util.List;
import patterns.infrastructure.output.reporsitory.entity.BookEntity;

public interface BookRepository extends AbstractRepository<BookEntity> {

  List<BookEntity> findByTitle(String title);

  List<BookEntity> findByAuthor(String author);

  List<BookEntity> findAll();
}
