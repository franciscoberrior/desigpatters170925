package patterns.application.output;

import patterns.domain.model.Book;

public interface Subject {
  void attach(Observer o);
  void detach(Observer o);
  void notifyUpdate(Book book);
}
