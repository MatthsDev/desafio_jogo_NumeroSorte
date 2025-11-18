package br.com.projeto.controller;

import br.com.projeto.models.Bilhete;
import br.com.projeto.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AppController {

    private final Scanner scanner = new Scanner(System.in);

    // Lista principal com todos os bilhetes gerados
    private final List<Bilhete> bilhetes = new ArrayList<>();

    public void iniciar() {
        int opcao;

        do {
            Menu.exibirMenu();
            opcao = Menu.lerOpcao(scanner);

            switch (opcao) {
                case 1 -> gerarBilhetes();
                case 2 -> listarBilhetes();
                case 3 -> sortearBilhete();
                case 0 -> System.out.println("\nEncerrando o programa... Até a próxima! 👋");
                default -> System.out.println("Opção inválida.\n");
            }

        } while (opcao != 0);
    }

    /**
     * Gera X bilhetes e armazena na lista.
     */
    private void gerarBilhetes() {
        System.out.print("\nQuantos bilhetes deseja gerar? → ");
        int quantidade = Menu.lerOpcao(scanner);

        for (int i = 0; i < quantidade; i++) {
            Bilhete bilhete = GeradorDeBilhete.gerarBilhete();
            bilhetes.add(bilhete);
            GeradorDeBilhete.exibirBilhete(bilhete);
        }

        System.out.println("\n✔ Bilhetes gerados com sucesso!\n");
    }

    /**
     * Lista todos os bilhetes gerados.
     */
    private void listarBilhetes() {
        if (bilhetes.isEmpty()) {
            System.out.println("\n❌ Nenhum bilhete gerado ainda.\n");
            return;
        }

        System.out.println("\n--- LISTA DE BILHETES ---");
        bilhetes.forEach(b -> System.out.println("🎟️ " + b.getNumeroFormatado()));
        System.out.println();
    }

    /**
     * Gera um bilhete vencedor aleatório e verifica se alguém tem ele.
     */
    private void sortearBilhete() {
        if (bilhetes.isEmpty()) {
            System.out.println("\n❌ Não é possível sortear sem bilhetes gerados.\n");
            return;
        }

        Bilhete vencedor = GeradorDeBilhete.gerarBilhete();

        System.out.println("\n🏆 BILHETE PREMIDO → " + vencedor.getNumeroFormatado());

        boolean ganhou = bilhetes.stream()
                .anyMatch(b -> b.getNumeracao() == vencedor.getNumeracao());

        if (ganhou) {
            System.out.println("\n🎉 PARABÉNS! Você tem o bilhete premiado!\n");
        } else {
            System.out.println("\n😢 Não foi dessa vez... Tente novamente!\n");
        }
    }
}
