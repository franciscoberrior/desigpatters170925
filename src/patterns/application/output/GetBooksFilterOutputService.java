package patterns.application.output;

import java.util.List;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;

public interface GetBooksFilterOutputService {

  FilterBookEnum fiter();

  List<Book> getBooks(String filter);

}
