package patterns.application.output;

import java.util.List;
import patterns.domain.model.Book;

public interface GetBooksOutputService {

  List<Book> getBooks();

}
