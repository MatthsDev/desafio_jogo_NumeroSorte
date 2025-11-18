package br.com.projeto.models;

import java.util.Objects;

/**
 * Entidade Bilhete: representa um bilhete com numeração entre 0 e 9999.
 * Mantemos encapsulamento e implemetamos equals/hashCode para permitir comparações corretas.
 */
public class Bilhete {

    // Mantemos o campo como final quando possível para evitar mutabilidade desnecessária.
    private final int numeracao;

    /**
     * Construtor principal.
     *
     * @param numeracao numero do bilhete (0..9999)
     */
    public Bilhete(int numeracao) {
        this.numeracao = numeracao;
    }

    public int getNumeracao() {
        return numeracao;
    }

    /**
     * Retorna o número formatado com 4 dígitos (ex: 7 -> "0007")
     */
    public String getNumeroFormatado() {
        return String.format("%04d", numeracao);
    }

    @Override
    public String toString() {
        return "Bilhete nº " + getNumeroFormatado();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bilhete bilhete = (Bilhete) o;
        return numeracao == bilhete.numeracao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeracao);
    }
}
