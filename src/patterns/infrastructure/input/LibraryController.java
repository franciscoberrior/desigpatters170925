package patterns.infrastructure.input;

import java.util.List;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;

public interface LibraryController {

  void addBook(Book book);

  List<Book> getBooks(String filterData, FilterBookEnum filter);

  List<Book> getAllBooks();

  void lendBook(Long id);

}
