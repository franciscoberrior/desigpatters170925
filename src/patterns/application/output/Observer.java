package patterns.application.output;

import patterns.domain.model.Book;

public interface Observer {

  void updateBook(Book book);

}
