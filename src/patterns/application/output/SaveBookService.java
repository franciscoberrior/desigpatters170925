package patterns.application.output;


import patterns.domain.model.Book;

public interface SaveBookService {

  void saveBook(Book book);
}
