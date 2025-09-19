package patterns.application.input;

import patterns.domain.model.Book;

public interface SaveBookInputService {
  void saveBook(Book book);
}
