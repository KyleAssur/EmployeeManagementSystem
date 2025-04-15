package repository;

/*
 * EmployeeFactoryTest class
 * Author: [Kyle Assur] ([219070091])
 */

public interface Repository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}