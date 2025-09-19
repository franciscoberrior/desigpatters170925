package patterns.infrastructure.output.adapter;

import java.util.List;
import patterns.application.output.GetBooksFilterOutputService;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;
import patterns.infrastructure.output.reporsitory.BookRepository;
import patterns.infrastructure.output.reporsitory.entity.BookEntity;
import patterns.infrastructure.output.reporsitory.mapper.AbstractMapper;

public class FilterBookAuthorAdapter implements GetBooksFilterOutputService {

  public final BookRepository repository;
  public final AbstractMapper<BookEntity, Book> bookMapper;

  public FilterBookAuthorAdapter(BookRepository repository, AbstractMapper<BookEntity, Book> bookMapper) {
    this.repository = repository;
    this.bookMapper = bookMapper;
  }

  @Override
  public FilterBookEnum fiter() {
    return FilterBookEnum.NAME_AUTHOR;
  }

  @Override
  public List<Book> getBooks(String filter) {
    return bookMapper.toDomain(repository.findByAuthor(filter));
  }
}
