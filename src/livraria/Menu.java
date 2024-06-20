package livraria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import livraria.controller.LivrariaController;
import livraria.model.Livro;
import livraria.model.Produto;
import livraria.model.Revista;
import livraria.util.*;

public class Menu {
	private static final Scanner sc = new Scanner(System.in);
	private static final LivrariaController livrariaController = new LivrariaController();

	public static void main(String[] args) {
		int option;

		while (true) {
			printMenu();
			try {
				option = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Digite um número válido!");
				sc.nextLine();
				continue;
			}

			switch (option) {
			case 1:
				addProduct();
				break;
			case 2:
				listAllProducts();
				break;
			case 3:
				listProductsByCategory();
				break;
			case 4:
				consultStock();
				break;
			case 5:
				editStock();
				break;
			case 6:
				deleteProduct();
				break;
			case 9:
				System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "\nSaindo...");
				sc.close();
				System.exit(0);
			default:
				System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Opção inválida!");
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
                +"\n*****************************************************");
		System.out.println(Cores.TEXT_PURPLE_BOLD +
				"                  LIVRARIA GEN                       ");
		System.out.println(Cores.TEXT_YELLOW_BOLD 
				+ "*****************************************************");
		System.out.println(Cores.TEXT_PURPLE_BOLD +
				"            1 - Adicionar Produto                    ");
		System.out.println("            2 - Listar Todos os Produtos             ");
		System.out.println("            3 - Listar Produtos por Categoria        ");
		System.out.println("            4 - Consultar Estoque                    ");
		System.out.println("            5 - Editar Estoque                       ");
		System.out.println("            6 - Apagar Produto                       ");
		System.out.println("            9 - Sair                                 ");
		System.out.println(Cores.TEXT_YELLOW_BOLD 
				+ "*****************************************************");
		System.out.print("Entre com a opção desejada: ");
	}

	private static void addProduct() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\nAdicionar Produto\n");

		int type;
		do {
			System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "Digite o Tipo do Produto (1- Livro | 2- Revista): ");
			type = sc.nextInt();
			sc.nextLine();
		} while (type != 1 && type != 2);

		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite o Título: ");
		String title = sc.nextLine();
		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite a Quantidade: ");
		int quantity = sc.nextInt();
		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite o Preço: ");
		double price = sc.nextDouble();
		sc.nextLine();

		if (type == 1) {
			System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "Digite o Autor: ");
			String author = sc.nextLine();
			System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "Digite o Gênero: ");
			String genre = sc.nextLine();
			Livro livro = new Livro(title, price, quantity, author, genre);
			livrariaController.add(livro);
		} else if (type == 2) {
			System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "Digite a Edição da Revista: ");
			String edition = sc.nextLine();
			Revista revista = new Revista(title, price, quantity, edition);
			livrariaController.add(revista);
		}

		System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
				+ "Produto adicionado com sucesso!");
		keyPress();
	}

	private static void listAllProducts() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\nListar Todos os Produtos\n");
		List<Produto> listProducts = livrariaController.findAll();
		if (!listProducts.isEmpty()) {
			listProducts.forEach(Produto::displayDetails);
		} else {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "Nenhum produto encontrado!");
		}
		keyPress();
	}

	private static void listProductsByCategory() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\nListar Produtos por Categoria\n");

		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite a Categoria (Livro ou Revista): ");
		String category = sc.nextLine();

		List<Produto> productsByCategory = livrariaController.findByCategory(category);
		if (!productsByCategory.isEmpty()) {
			productsByCategory.forEach(Produto::displayDetails);
		} else {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "Nenhum produto encontrado para a categoria: " + category);
		}

		keyPress();
	}

	private static void consultStock() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\nConsultar Estoque - Por Código do Produto\n");

		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite o Código do Produto: ");
		int code = sc.nextInt();
		sc.nextLine();

		Produto consultedProduct = livrariaController.findByCode(code);
		if (consultedProduct != null) {
			consultedProduct.displayDetails();
		} else {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "Produto não encontrado!");
		}

		keyPress();
	}

	private static void editStock() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\nEditar Estoque\n");

		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite o Código do Produto: ");
		int code = sc.nextInt();
		sc.nextLine();
		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite a nova quantidade: ");
		int quantity = sc.nextInt();
		sc.nextLine();

		Produto editedProduct = livrariaController.findByCode(code);
		if (editedProduct != null) {
			editedProduct.setQuantity(quantity);
			livrariaController.update(code, editedProduct);
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "Estoque editado com sucesso!");
		} else {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "Produto não encontrado!");
		}

		keyPress();
	}

	private static void deleteProduct() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\nApagar Produto\n");

		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "Digite o Código do Produto: ");
		int code = sc.nextInt();
		sc.nextLine();

		livrariaController.delete(code);
		System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
				+ "Produto apagado com sucesso!");

		keyPress();
	}

	private static void keyPress() {
		try {
			System.out.println(Cores.TEXT_PURPLE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "Você pressionou uma tecla diferente de Enter!");
		}
	}
}