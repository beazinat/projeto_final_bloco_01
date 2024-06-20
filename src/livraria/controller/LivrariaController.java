package livraria.controller;

import livraria.model.Produto;
import livraria.repository.LivrariaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivrariaController implements LivrariaRepository<Produto> {
	private Map<String, List<Produto>> productsByCategory = new HashMap<>();

	@Override
	public void add(Produto item) {
		String category = item.getCategory();
		productsByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
	}

	@Override
	public void update(int code, Produto item) {
		Optional.ofNullable(findByCode(code)).ifPresent(p -> {
			String category = p.getCategory();
			List<Produto> products = productsByCategory.get(category);
			if (products != null) {
				int index = products.indexOf(p);
				if (index != -1) {
					products.set(index, item);
				}
			}
		});
	}

	@Override
	public void delete(int code) {
		Optional.ofNullable(findByCode(code)).ifPresent(p -> {
			String category = p.getCategory();
			List<Produto> products = productsByCategory.get(category);
			if (products != null) {
				products.remove(p);
			}
		});
	}

	@Override
	public Produto findByCode(int code) {
		return productsByCategory.values().stream().flatMap(List::stream).filter(p -> p.getCode() == code).findFirst()
				.orElse(null);
	}

	@Override
	public List<Produto> findAll() {
		return productsByCategory.values().stream().flatMap(List::stream).collect(Collectors.toList());
	}

	public List<Produto> findByCategory(String category) {
		return productsByCategory.getOrDefault(category, new ArrayList<>());
	}
}