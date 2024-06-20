package livraria.controller;

import livraria.model.Produto;
import livraria.repository.LivrariaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivrariaController implements LivrariaRepository<Produto> {
	private Map<String, List<Produto>> productsByCategory = new HashMap<>();

	@Override
	public void add(Produto item) {
		String category = item.getCategory();
		if (!productsByCategory.containsKey(category)) {
			productsByCategory.put(category, new ArrayList<>());
		}
		productsByCategory.get(category).add(item);
	}

	@Override
	public void update(int code, Produto item) {
		Produto p = findByCode(code);
		if (p != null) {
			String category = p.getCategory();
			List<Produto> products = productsByCategory.get(category);
			int index = products.indexOf(p);
			products.set(index, item);
		}
	}

	@Override
	public void delete(int code) {
		Produto p = findByCode(code);
		if (p != null) {
			String category = p.getCategory();
			productsByCategory.get(category).remove(p);
		}
	}

	@Override
	public Produto findByCode(int code) {
		for (List<Produto> products : productsByCategory.values()) {
			for (Produto p : products) {
				if (p.getCode() == code) {
					return p;
				}
			}
		}
		return null;
	}

	@Override
	public List<Produto> findAll() {
		List<Produto> allProducts = new ArrayList<>();
		for (List<Produto> products : productsByCategory.values()) {
			allProducts.addAll(products);
		}
		return allProducts;
	}

	public List<Produto> findByCategory(String category) {
		return productsByCategory.getOrDefault(category, new ArrayList<>());
	}
}