package patterns.infrastructure.output.adapter;

import patterns.application.output.Observer;
import patterns.domain.model.Book;

public class AdministratorLibraryObserver implements Observer {

  @Override
  public void updateBook(Book book) {
      System.out.println("Administrator notified: Book " + book.getTitle() + " has been lent.");
  }
}
