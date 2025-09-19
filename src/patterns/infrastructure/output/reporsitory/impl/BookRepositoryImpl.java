package patterns.infrastructure.output.reporsitory.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import patterns.infrastructure.config.DatabaseConfig;
import patterns.infrastructure.output.reporsitory.BookRepository;
import patterns.infrastructure.output.reporsitory.entity.BookEntity;

public class BookRepositoryImpl implements BookRepository {

  @Override
  public void save(BookEntity entity) {
    String sql = "INSERT INTO books ("
                 + "title, "
                 + "author,"
                 + "type,"
                 + "format,"
                 + "status,"
                 + ") "
                 + "VALUES ("
                 + "?, "
                 + "?,"
                 + "?,"
                 + "?,"
                 + "?"
                 + ")";
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, entity.getTitle());
      stmt.setString(2, entity.getAuthor());
      stmt.setString(3, entity.getType());
      stmt.setString(4, entity.getFormat());
      stmt.setString(5, entity.getStatus());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public BookEntity findById(Long id) {
    String sql = "SELECT * FROM books WHERE id = ?";
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return mapToEntity(rs);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void delete(BookEntity entity) {
    String sql = "DELETE FROM books WHERE id = ?";
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, entity.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(BookEntity entity) {
    String sql = "UPDATE books SET title = ?, author = ?, type = ?, format = ?, status = ? WHERE id = ?";
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, entity.getTitle());
      stmt.setString(2, entity.getAuthor());
      stmt.setString(3, entity.getType());
      stmt.setString(4, entity.getFormat());
      stmt.setString(5, entity.getStatus());
      stmt.setLong(6, entity.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<BookEntity> findByTitle(String title) {
    String sql = "SELECT * FROM books WHERE title = ?";
    List<BookEntity> books = new ArrayList<>();
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, title);
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          books.add(mapToEntity(rs));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }

  @Override
  public List<BookEntity> findByAuthor(String author) {
    String sql = "SELECT * FROM books WHERE author = ?";
    List<BookEntity> books = new ArrayList<>();
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, author);
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          books.add(mapToEntity(rs));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }

  @Override
  public List<BookEntity> findAll() {
    String sql = "SELECT * FROM books";
    List<BookEntity> books = new ArrayList<>();
    try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          books.add(mapToEntity(rs));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }

  private BookEntity mapToEntity(ResultSet rs) throws SQLException {
    return BookEntity.builder()
        .id(rs.getLong("id"))
        .title(rs.getString("title"))
        .author(rs.getString("author"))
        .type(rs.getString("type"))
        .format(rs.getString("format"))
        .status(rs.getString("status"))
        .build();
  }

}
