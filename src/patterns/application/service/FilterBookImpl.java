package patterns.application.service;

import java.util.List;
import patterns.application.input.GetBooksInputService;
import patterns.application.output.GetBooksFilterOutputService;
import patterns.application.output.GetBooksOutputService;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;
import patterns.infrastructure.exception.FilterNotFoundException;

public class FilterBookImpl implements GetBooksInputService {

  private final List<GetBooksFilterOutputService> filters;
  private final GetBooksOutputService getBooksOutputService;

  public FilterBookImpl(List<GetBooksFilterOutputService> filters,
      GetBooksOutputService getBooksOutputService) {
    this.filters = filters;
    this.getBooksOutputService = getBooksOutputService;
  }

  @Override
  public List<Book> getBooks(String filterData, FilterBookEnum filter) {
    return filters.stream().filter(f -> f.fiter().equals(filter))
        .findFirst()
        .orElseThrow(FilterNotFoundException::new)
        .getBooks(filterData);
  }

  @Override
  public List<Book> getAllBooks() {
    return getBooksOutputService.getBooks();
  }
}
