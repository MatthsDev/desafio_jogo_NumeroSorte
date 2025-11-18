package br.com.projeto;

import br.com.projeto.controller.AppController;
import br.com.projeto.services.BilheteService;
import br.com.projeto.services.SorteioService;

/**
 * Entry point - apenas orquestra a criação dos serviços e do controller.
 * Mantemos Main o mais simples possível (Single Responsibility).
 */
public class Main {
    public static void main(String[] args) {
        // Cria serviços (não estáticos) - facilita testes e extensão futura
        BilheteService bilheteService = new BilheteService();
        SorteioService sorteioService = new SorteioService();

        // Injeta serviços no controller
        AppController controller = new AppController(bilheteService, sorteioService);
        controller.iniciar();
    }
}
