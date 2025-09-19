package patterns;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import patterns.application.input.GetBooksInputService;
import patterns.application.input.LenBookInputService;
import patterns.application.input.SaveBookInputService;
import patterns.application.output.GetBooksFilterOutputService;
import patterns.application.output.GetBooksOutputService;
import patterns.application.output.Observer;
import patterns.application.output.SaveBookService;
import patterns.application.output.Subject;
import patterns.application.output.UpdateBookOutputService;
import patterns.application.service.FilterBookImpl;
import patterns.application.service.LenBookServiceImpl;
import patterns.application.service.SaveBookServiceImpl;
import patterns.domain.enums.BookFormatEnum;
import patterns.domain.enums.BookStatusEnum;
import patterns.domain.enums.BookTypeEnum;
import patterns.domain.enums.FilterBookEnum;
import patterns.domain.model.Book;
import patterns.infrastructure.config.DatabaseConfig;
import patterns.infrastructure.input.LibraryController;
import patterns.infrastructure.input.impl.LibraryControllerImplement;
import patterns.infrastructure.output.adapter.AdministratorLibraryObserver;
import patterns.infrastructure.output.adapter.BookAdapter;
import patterns.infrastructure.output.adapter.FilterBookAuthorAdapter;
import patterns.infrastructure.output.adapter.FilterBookTittleAdapter;
import patterns.infrastructure.output.adapter.MessagePublisher;
import patterns.infrastructure.output.reporsitory.BookRepository;
import patterns.infrastructure.output.reporsitory.entity.BookEntity;
import patterns.infrastructure.output.reporsitory.impl.BookRepositoryImpl;
import patterns.infrastructure.output.reporsitory.mapper.AbstractMapper;
import patterns.infrastructure.output.reporsitory.mapper.impl.BookMapperImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {

    try (Connection conn = DatabaseConfig.getConnection();
        Statement stmt = conn.createStatement()) {
      stmt.execute("CREATE TABLE books ("
                   + "id INT AUTO_INCREMENT PRIMARY KEY, "
                   + "title VARCHAR(255), "
                   + "author VARCHAR(255),"
                   + "type VARCHAR(255),"
                   + "format VARCHAR(255),"
                   + "status VARCHAR(255)"
                   + ")");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    BookRepository bookRepository = new BookRepositoryImpl();
    AbstractMapper<BookEntity, Book> bookMapper = new BookMapperImpl();

    UpdateBookOutputService updateBookOutputService = new BookAdapter(bookRepository, bookMapper);
    GetBooksFilterOutputService filterByTittle = new FilterBookTittleAdapter(bookRepository, bookMapper);
    GetBooksFilterOutputService filterByAuthor = new FilterBookAuthorAdapter(bookRepository, bookMapper);

    List<GetBooksFilterOutputService> getBooksFilterOutputServices = List.of(filterByTittle, filterByAuthor);

    GetBooksOutputService getBooksOutputService = new BookAdapter(bookRepository, bookMapper);

    SaveBookService bookService = new BookAdapter(bookRepository, bookMapper);
    GetBooksInputService getBooksInputService = new FilterBookImpl(getBooksFilterOutputServices, getBooksOutputService);

    SaveBookInputService saveBookInputService = new SaveBookServiceImpl(bookService);

    Observer libraryAdmin = new AdministratorLibraryObserver();

    List<Observer> observers = List.of(libraryAdmin);

    Subject subject = new MessagePublisher(observers);

    LenBookInputService lenBookInputService = new LenBookServiceImpl(updateBookOutputService, subject);

    LibraryController libraryController = new LibraryControllerImplement(
        saveBookInputService,
        getBooksInputService,
        lenBookInputService
    );

    libraryController.addBook(Book.builder()
        .id(1L)
        .title("The Great Gatsby")
        .author("F. Scott Fitzgerald")
        .type(BookTypeEnum.FICTION)
        .format(BookFormatEnum.DIGITAL)
        .status(BookStatusEnum.AVAILABLE)
        .build());

    libraryController.addBook(Book.builder()
        .id(1L)
        .title("The Great Gatsby 2")
        .author("F. Scott Fitzgerald")
        .type(BookTypeEnum.FICTION)
        .format(BookFormatEnum.DIGITAL)
        .status(BookStatusEnum.AVAILABLE)
        .build());

    libraryController.addBook(Book.builder()
        .id(1L)
        .title("The Great Gatsby 3")
        .author("F. Scott Fitzgerald")
        .type(BookTypeEnum.FICTION)
        .format(BookFormatEnum.DIGITAL)
        .status(BookStatusEnum.AVAILABLE)
        .build());

    List<Book> booksByTittle = libraryController.getBooks("The Great Gatsby 3",
        FilterBookEnum.TITTLE);
    for (Book bookFiltered : booksByTittle) {
      System.out.println("Book: " + bookFiltered.getTitle() + " - " + bookFiltered.getAuthor());
      System.out.println(bookFiltered.toString());
      System.out.println("--------------------------------");
    }

    List<Book> booksByAuthor = libraryController.getBooks("F. Scott Fitzgerald",
        FilterBookEnum.NAME_AUTHOR);
    for (Book bookFiltered : booksByAuthor) {
      System.out.println("Book: " + bookFiltered.getTitle() + " - " + bookFiltered.getAuthor());
      System.out.println(bookFiltered.toString());
      System.out.println("--------------------------------");
    }

    List<Book> allBooks = libraryController.getAllBooks();
    for (Book bookFiltered : booksByAuthor) {
      System.out.println("Book: " + bookFiltered.getTitle() + " - " + bookFiltered.getAuthor());
      System.out.println(bookFiltered.toString());
      System.out.println("--------------------------------");
    }

    libraryController.lendBook(booksByTittle.get(0).getId());

    booksByTittle = libraryController.getBooks("The Great Gatsby 3",
        FilterBookEnum.TITTLE);
    for (Book bookFiltered : booksByTittle) {
      System.out.println("Book: " + bookFiltered.getTitle() + " - " + bookFiltered.getAuthor());
      System.out.println(bookFiltered.toString());
      System.out.println("--------------------------------");
    }


  }

}