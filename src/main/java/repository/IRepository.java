package repository;

/**
 * Generic IRepository interface for CRUD operations.
 * @param <T> - Entity type
 * @param <ID> - Identifier type
 */
public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
