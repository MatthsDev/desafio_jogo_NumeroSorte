package br.com.projeto.view;

import java.util.Scanner;

/**
 * Classe responsável apenas pela interação textual com o usuário (exibir menu e ler opções).
 */
public class Menu {

    /**
     * Exibe o menu inicial.
     */
    public static void exibirMenu() {
        System.out.print("""
                =============================================================
                                SISTEMA DE BILHETES DA SORTE
                =============================================================
                Cada bilhete é um número aleatório entre 0000 e 9999.
                
                Escolha uma opção:
                1 - Gerar bilhetes
                2 - Listar bilhetes gerados
                3 - Sortear bilhete vencedor
                0 - Sair
                =============================================================
                → """);
    }

    /**
     * Lê uma opção numérica do usuário com segurança.
     */
    public static int lerOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite uma opção válida: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
