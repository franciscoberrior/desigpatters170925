package patterns.infrastructure.output.adapter;

import java.util.List;
import patterns.application.output.Observer;
import patterns.application.output.Subject;
import patterns.domain.model.Book;

public class MessagePublisher implements Subject {

  private final List<Observer> observers;

  public MessagePublisher(List<Observer> observers) {
    this.observers = observers;
  }

  @Override
  public void attach(Observer o) {
    observers.add(o);
  }

  @Override
  public void detach(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyUpdate(Book book) {
    for (Observer o : observers) {
      o.updateBook(book);
    }
  }
}
