package br.com.projeto.models;

/**
 * Representa um bilhete com uma numeração única (0 - 9999).
 * É uma classe simples de domínio, seguindo o padrão POJO.
 */

public class Bilhete {

    // Número do bilhete (sempre inteiro entre 0000 e 9999)
    private int numeracao;

    /**
     * Construtor padrão.
     * Mantemos um construtor vazio por simplicidade
     * caso o bilhete seja preenchido depois.
     */
    public Bilhete() {}

    /**
     * Construtor alternativo: permite criar já com um número.
     */
    public Bilhete(int numeracao) {
        this.numeracao = numeracao;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    /**
     * Retorna o número formatado no padrão de bilhetes:
     * - Sempre 4 dígitos
     * - Exemplo: 7 → "0007"
     */
    public String getNumeroFormatado() {
        return String.format("%04d", numeracao);
    }

    /**
     * Sobrescrita padrão: permite imprimir Bilhete diretamente.
     */
    @Override
    public String toString() {
        return "Bilhete nº " + getNumeroFormatado();
    }
}
