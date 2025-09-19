package patterns.application.service;

import patterns.application.input.SaveBookInputService;
import patterns.application.output.SaveBookService;
import patterns.domain.model.Book;

public class SaveBookServiceImpl implements SaveBookInputService {

  private final SaveBookService bookService;

  public SaveBookServiceImpl(SaveBookService bookService) {
    this.bookService = bookService;
  }

  @Override
  public void saveBook(Book book) {
    bookService.saveBook(book);
  }
}
