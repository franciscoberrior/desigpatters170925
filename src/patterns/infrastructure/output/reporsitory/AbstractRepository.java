package patterns.infrastructure.output.reporsitory;

public interface AbstractRepository<T> {

  void save(T entity);

  T findById(Long id);

  void delete(T entity);

  void update(T entity);

}
