package livraria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.util.Cores;

public class Menu {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int option, code, quantity, type;
        String title, genre = "", author = "";
        double price;
        
        
        while (true) {
            
            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND 
                             + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                    LIVRARIA GEN                     ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Adicionar Produto                    ");
            System.out.println("            2 - Listar Todos os Produtos             ");
            System.out.println("            3 - Consultar Estoque                    ");
            System.out.println("            4 - Editar Estoque                       ");
            System.out.println("            5 - Apagar Produto                       ");
            System.out.println("            9 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                sc.nextLine();
                option = 0;
            }

            if (option == 9) {
                System.out.println(Cores.TEXT_BLUE_BOLD + "\nLivraria Gen - Conhecimento de gerações!");
                about();
                sc.close();
                System.exit(0);
            }

            switch (option) {
                case 1:
                    System.out.println(Cores.TEXT_BLUE + "Adicionar Produto\n\n");
                    
                    do {
                        System.out.println("Digite o Tipo do Produto (1- Livro | 2- Revista): ");
                        type = sc.nextInt();
                        sc.nextLine();
                        
                        if(type == 1) {
                            System.out.println("Digite o Autor: ");
                            author = sc.nextLine();
                            System.out.println("Digite o Gênero: ");
                            genre = sc.nextLine();
                        }
                    } while(type < 1 || type > 2);
                    
                    System.out.println("Digite o Título: ");
                    title = sc.nextLine();
                    System.out.println("Digite a quantidade: ");
                    quantity = sc.nextInt();
                    System.out.println("Digite o Preço: ");
                    price = sc.nextDouble();
                    
                    System.out.println("Produto adicionado com sucesso!");
                    keyPress();
                    break;
                case 2:
                    System.out.println(Cores.TEXT_BLUE + "Listar Todos os Produtos\n\n");
                    
                    System.out.println("Lista de produtos ...");
                    keyPress();
                    break;
                case 3:
                    System.out.println(Cores.TEXT_BLUE + "Consultar Estoque - Por Código do Produto\n\n");
                    
                    System.out.println("Digite o Código do Produto: ");
                    code = sc.nextInt();
                    System.out.println("Produto consultado ...");
                    keyPress();
                    break;
                case 4:
                    System.out.println(Cores.TEXT_BLUE + "Editar Estoque\n\n");
                    
                    System.out.println("Digite o Código do Produto: ");
                    code = sc.nextInt();
                    System.out.println("Digite a nova quantidade: ");
                    quantity = sc.nextInt();
                    System.out.println("Estoque editado ...");
                    keyPress();
                    break;
                case 5:
                    System.out.println(Cores.TEXT_BLUE + "Apagar Produto\n\n");
                    
                    System.out.println("Digite o Código do Produto: ");
                    code = sc.nextInt();
                    System.out.println("Produto apagado ...");
                    keyPress();
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
                    break;
            }
        }
    }
    
    public static void about() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Beazinat Gonçalves");
        System.out.println("E-mail - beazinat@outlook.com");
        System.out.println("github.com/beazinat");
        System.out.println("*********************************************************");
    }
    
    public static void keyPress() {

        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
