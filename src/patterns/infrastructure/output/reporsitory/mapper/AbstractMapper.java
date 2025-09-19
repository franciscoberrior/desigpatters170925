package patterns.infrastructure.output.reporsitory.mapper;

import java.util.List;

public interface AbstractMapper<E, D> {

  E toEntity(D domain);

  D toDomain(E entity);

  List<D> toDomain(List<E> entity);

}
