package br.com.projeto.controller;

import br.com.projeto.models.Bilhete;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe responsável por gerar bilhetes.
 * Mantida com métodos estáticos para simplificar o uso no projeto.
 */
public class GeradorDeBilhete {

    /**
     * Gera um bilhete com numeração aleatória entre 0000 e 9999.
     * Este método NÃO garante unicidade.
     * A responsabilidade de controlar duplicados deve ser do AppController.
     */
    public static Bilhete gerarBilhete() {

        // Gera número seguro e eficiente (ThreadLocalRandom é o recomendado)
        int numero = ThreadLocalRandom.current().nextInt(0, 10000);

        // Cria o bilhete já com o número
        return new Bilhete(numero);
    }

    /**
     * Exibe o bilhete em um formato amigável.
     */
    public static void exibirBilhete(Bilhete bilhete) {
        System.out.println("🎟️ Bilhete gerado: " + bilhete.getNumeroFormatado());
    }
}
