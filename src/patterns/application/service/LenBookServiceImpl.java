package patterns.application.service;

import patterns.application.input.LenBookInputService;
import patterns.application.output.Subject;
import patterns.application.output.UpdateBookOutputService;
import patterns.domain.enums.BookStatusEnum;

public class LenBookServiceImpl implements LenBookInputService {

  private final UpdateBookOutputService updateBookOutputService;
  private final Subject subject;

  public LenBookServiceImpl(UpdateBookOutputService updateBookOutputService, Subject subject) {
    this.updateBookOutputService = updateBookOutputService;
    this.subject = subject;
  }

  @Override
  public void lendBook(Long id) {
    var book = updateBookOutputService.updateBookStatus(id, BookStatusEnum.BORROWED);
    subject.notifyUpdate(book);
  }
}
