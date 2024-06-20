package livraria.repository;

import java.util.List;

public interface LivrariaRepository {
	void add(T item);
    void update(int code, T item);
    void delete(int code);
    T findByCode(int code);
    List<T> findAll();
}
