package patterns.infrastructure.output.reporsitory.mapper.impl;

import java.util.List;
import patterns.domain.enums.BookFormatEnum;
import patterns.domain.enums.BookStatusEnum;
import patterns.domain.enums.BookTypeEnum;
import patterns.domain.model.Book;
import patterns.infrastructure.output.reporsitory.entity.BookEntity;
import patterns.infrastructure.output.reporsitory.mapper.AbstractMapper;

public class BookMapperImpl implements AbstractMapper<BookEntity, Book> {

  @Override
  public BookEntity toEntity(Book domain) {
    return BookEntity.builder()
        .id(domain.getId())
        .title(domain.getTitle())
        .author(domain.getAuthor())
        .type(domain.getType().name())
        .format(domain.getFormat().name())
        .status(domain.getStatus().name())
        .build();
  }

  @Override
  public Book toDomain(BookEntity entity) {
    return Book.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .author(entity.getAuthor())
        .type(BookTypeEnum.fromString(entity.getType()))
        .format(BookFormatEnum.fromString(entity.getFormat()))
        .status(BookStatusEnum.fromString(entity.getStatus()))
        .build();
  }

  @Override
  public List<Book> toDomain(List<BookEntity> entity) {
    return entity.stream().map(this::toDomain).toList();
  }
}
