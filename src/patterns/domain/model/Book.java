package patterns.domain.model;

import patterns.domain.enums.BookFormatEnum;
import patterns.domain.enums.BookStatusEnum;
import patterns.domain.enums.BookTypeEnum;

public class Book {

  private Long id;
  private String title;
  private String author;
  private BookTypeEnum type;
  private BookFormatEnum format;
  private BookStatusEnum status;

  private Book() {
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public BookTypeEnum getType() {
    return type;
  }

  public BookFormatEnum getFormat() {
    return format;
  }

  public BookStatusEnum getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "Book{" +
           "id=" + id +
           ", title='" + title + '\'' +
           ", author='" + author + '\'' +
           ", type=" + type +
           ", format=" + format +
           ", status=" + status +
           '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Long id;
    private String title;
    private String author;
    private BookTypeEnum type;
    private BookFormatEnum format;
    private BookStatusEnum status;

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder author(String author) {
      this.author = author;
      return this;
    }

    public Builder type(BookTypeEnum type) {
      this.type = type;
      return this;
    }

    public Builder format(BookFormatEnum format) {
      this.format = format;
      return this;
    }

    public Builder status(BookStatusEnum status) {
      this.status = status;
      return this;
    }

    public Book build() {
      Book book = new Book();
      book.id = this.id;
      book.title = this.title;
      book.author = this.author;
      book.type = this.type;
      book.format = this.format;
      book.status = this.status;
      return book;
    }
  }

}
