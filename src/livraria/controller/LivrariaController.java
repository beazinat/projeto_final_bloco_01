package livraria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import livraria.model.Produto;
import livraria.repository.LivrariaRepository;

public class LivrariaController implements LivrariaRepository<Produto> {
	private List<Produto> produtos = new ArrayList<>();

	@Override
	public void add(Produto item) {
		produtos.add(item);
	}

	@Override
	public void update(int code, Produto item) {
		Produto produto = findByCode(code);
		if (produto != null) {
			int index = produtos.indexOf(produto);
			produtos.set(index, item);
		}
	}

	@Override
	public void delete(int code) {
		Produto produto = findByCode(code);
		if (produto != null) {
			produtos.remove(produto);
		}
	}

	@Override
	public Produto findByCode(int code) {
		try {
			return produtos.stream().filter(p -> p.getCode() == code).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<Produto> findAll() {
		return new ArrayList<>(produtos);
	}
}