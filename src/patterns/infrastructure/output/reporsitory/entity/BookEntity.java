package patterns.infrastructure.output.reporsitory.entity;

public class BookEntity {

  private Long id;
  private String title;
  private String author;
  private String type;
  private String format;
  private String status;

  private BookEntity() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getType() {
    return type;
  }

  public String getFormat() {
    return format;
  }

  public String getStatus() {
    return status;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Long id;
    private String title;
    private String author;
    private String type;
    private String format;
    private String status;

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

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder format(String format) {
      this.format = format;
      return this;
    }

    public Builder status(String status) {
      this.status = status;
      return this;
    }

    public BookEntity build() {
      BookEntity book = new BookEntity();
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
