package br.com.projeto.controller;

import br.com.projeto.models.Bilhete;
import br.com.projeto.services.BilheteService;
import br.com.projeto.services.SorteioService;
import br.com.projeto.view.Menu;

import java.util.List;
import java.util.Scanner;

/**
 * Controller principal: orquestra a aplicação.
 * Não contém lógica de geração nem de sorteio: delega para serviços especializados.
 */
public class AppController {

    private final Scanner scanner = new Scanner(System.in);
    private final BilheteService bilheteService;
    private final SorteioService sorteioService;

    // Injeção de dependências via construtor — facilita testes e substituições.
    public AppController(BilheteService bilheteService, SorteioService sorteioService) {
        this.bilheteService = bilheteService;
        this.sorteioService = sorteioService;
    }

    /**
     * Loop principal da aplicação.
     */
    public void iniciar() {
        int opcao;

        do {
            Menu.exibirMenuPrincipal();
            opcao = Menu.lerOpcao(scanner);

            switch (opcao) {
                case 1 -> executarGerarBilhetes();
                case 2 -> executarListarBilhetes();
                case 3 -> executarSorteio();
                case 0 -> System.out.println("\nEncerrando o programa... Até a próxima! 👋");
                default -> System.out.println("\nOpção inválida.\n");
            }

        } while (opcao != 0);
    }

    // -------------------------
    // Operações orquestradas
    // -------------------------

    private void executarGerarBilhetes() {
        int quantidade = Menu.solicitarQuantidadeBilhetes(scanner);

        if (quantidade <= 0) {
            System.out.println("\nQuantidade deve ser maior que 0.\n");
            return;
        }

        List<Bilhete> gerados = bilheteService.gerarMultiplosBilhetes(quantidade);
        System.out.println();
        gerados.forEach(b -> System.out.println("🎟️ " + b.getNumeroFormatado()));
        System.out.println("\n✔ Foram gerados " + gerados.size() + " bilhete(s).\n");

        Menu.pressionarEnterParaContinuar(scanner);
    }

    private void executarListarBilhetes() {
        List<Bilhete> lista = bilheteService.listarBilhetes();
        if (lista.isEmpty()) {
            System.out.println("\n❌ Nenhum bilhete gerado ainda.\n");
        } else {
            System.out.println("\n--- SEUS BILHETES ---");
            lista.forEach(b -> System.out.println("🎟️ " + b.getNumeroFormatado()));
            System.out.println();
        }
        Menu.pressionarEnterParaContinuar(scanner);
    }

    private void executarSorteio() {
        List<Bilhete> lista = bilheteService.listarBilhetes();
        if (lista.isEmpty()) {
            System.out.println("\n❌ Gere bilhetes antes de realizar o sorteio.\n");
            Menu.pressionarEnterParaContinuar(scanner);
            return;
        }

        // Sorteia um bilhete (número) e verifica se está entre os bilhetes do usuário
        Bilhete vencedor = sorteioService.sortearBilhete();

        System.out.println("\n================= RESULTADO DO SORTEIO =================");
        System.out.println("🎯 Número sorteado: " + vencedor.getNumeroFormatado());

        boolean ganhou = bilheteService.existeNumero(vencedor.getNumeracao());
        if (ganhou) {
            System.out.println("\n🎉 PARABÉNS! Você tem um bilhete premiado!");
        } else {
            System.out.println("\n😢 Não foi dessa vez... mais sorte na próxima!");
            System.out.println("\nBilhete premiado: " + vencedor.getNumeroFormatado());
        }

        System.out.println("=======================================================\n");

        Menu.pressionarEnterParaContinuar(scanner);
    }
}
