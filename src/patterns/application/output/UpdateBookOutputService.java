package patterns.application.output;

import patterns.domain.enums.BookStatusEnum;
import patterns.domain.model.Book;

public interface UpdateBookOutputService {

  Book updateBookStatus(Long bookId, BookStatusEnum status);
}
