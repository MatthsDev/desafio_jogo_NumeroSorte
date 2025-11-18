package br.com.projeto.view;

import java.util.Scanner;

/**
 * Menu de interação com o usuário (apenas exibição e leitura).
 * e não dependem de estado de instância.
 */
public class Menu {

    public static void exibirMenuPrincipal() {
        System.out.print("""
                =============================================================
                               🎯 PROJETO DO NÚMERO DA SORTE
                =============================================================
                Cada bilhete é um número entre 0000 e 9999.
                
                1 - Gerar bilhetes
                2 - Listar bilhetes gerados
                3 - Sortear bilhete vencedor
                0 - Sair
                =============================================================
                Escolha uma opção:
                → """);
    }

    /**
     * Lê uma opção numérica do usuário com validação básica.
     */
    public static int lerOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite uma opção válida: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Solicita a quantidade de bilhetes a gerar.
     */
    public static int solicitarQuantidadeBilhetes(Scanner scanner) {
        System.out.print("\nQuantos bilhetes deseja gerar? → ");
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número inteiro válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Pausa até o ENTER — utilitário simples de UX no console.
     */
    public static void pressionarEnterParaContinuar(Scanner scanner) {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine(); // limpar buffer se necessário
        scanner.nextLine(); // aguarda ENTER
    }
}
