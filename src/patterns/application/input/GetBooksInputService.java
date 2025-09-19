package patterns.application.input;

import java.util.List;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;

public interface GetBooksInputService {

  List<Book> getBooks(String filterData, FilterBookEnum filter);

  List<Book> getAllBooks();

}
