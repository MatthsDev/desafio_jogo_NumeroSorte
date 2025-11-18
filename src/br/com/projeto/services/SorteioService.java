package br.com.projeto.services;

import br.com.projeto.models.Bilhete;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Serviço que encapsula a lógica do sorteio.
 * Mantém responsabilidade única: sortear e retornar o bilhete vencedor.
 *
 * Observação: o sorteio não altera o BilheteService; ele apenas retorna um bilhete vencedor.
 */
public class SorteioService {

    /**
     * Sorteia um número aleatório entre 0 e 9999 e retorna como Bilhete.
     *
     * @return Bilhete vencedor (nova instância)
     */
    public Bilhete sortearBilhete() {
        int numero = ThreadLocalRandom.current().nextInt(0, 10000);
        return new Bilhete(numero);
    }
}
