package patterns.infrastructure.output.adapter;

import java.util.List;
import patterns.application.output.GetBooksOutputService;
import patterns.application.output.SaveBookService;
import patterns.application.output.UpdateBookOutputService;
import patterns.domain.enums.BookStatusEnum;
import patterns.domain.model.Book;
import patterns.infrastructure.output.reporsitory.BookRepository;
import patterns.infrastructure.output.reporsitory.entity.BookEntity;
import patterns.infrastructure.output.reporsitory.mapper.AbstractMapper;

public class BookAdapter implements SaveBookService,
    GetBooksOutputService,
    UpdateBookOutputService {

  public final BookRepository bookRepository;
  public final AbstractMapper<BookEntity, Book> bookMapper;

  public BookAdapter(BookRepository bookRepository,
      AbstractMapper<BookEntity, Book> bookMapper) {
    this.bookRepository = bookRepository;
    this.bookMapper = bookMapper;
  }


  @Override
  public void saveBook(Book book) {
    bookRepository.save(bookMapper.toEntity(book));
  }

  @Override
  public List<Book> getBooks() {
    return bookMapper.toDomain(bookRepository.findAll());
  }

  @Override
  public Book updateBookStatus(Long bookId, BookStatusEnum status) {
    var bookEntity = bookRepository.findById(bookId);
    bookEntity.setStatus(status.name());
    bookRepository.update(bookEntity);
    return bookMapper.toDomain(bookEntity);
  }
}
