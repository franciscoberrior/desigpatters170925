package patterns.infrastructure.input.impl;

import java.util.List;
import patterns.application.input.GetBooksInputService;
import patterns.application.input.LenBookInputService;
import patterns.application.input.SaveBookInputService;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;
import patterns.infrastructure.input.LibraryController;

public class LibraryControllerImplement implements LibraryController {

  private final SaveBookInputService saveBookInputService;
  private final GetBooksInputService getBooksInputService;
  private final LenBookInputService lenBookInputService;

  public LibraryControllerImplement(SaveBookInputService saveBookInputService,
      GetBooksInputService getBooksInputService, LenBookInputService lenBookInputService) {
    this.saveBookInputService = saveBookInputService;
    this.getBooksInputService = getBooksInputService;
    this.lenBookInputService = lenBookInputService;
  }

  @Override
  public void addBook(Book book) {
    saveBookInputService.saveBook(book);
  }

  @Override
  public List<Book> getBooks(String filterData, FilterBookEnum filter) {
    return getBooksInputService.getBooks(filterData, filter);
  }

  @Override
  public List<Book> getAllBooks() {
    return List.of();
  }

  @Override
  public void lendBook(Long id) {
    lenBookInputService.lendBook(id);
  }
}
