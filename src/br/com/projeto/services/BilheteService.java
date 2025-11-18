package br.com.projeto.services;

import br.com.projeto.models.Bilhete;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Serviço responsável por gerenciar bilhetes do usuário.
 *
 * Racional:
 * - Responsabilidade única: manter/gerar/listar bilhetes.
 */
public class BilheteService {

    private final List<Bilhete> bilhetes = new ArrayList<>();
    public Bilhete gerarBilheteUnico() {
        int numero;
        do {
            numero = ThreadLocalRandom.current().nextInt(0, 10000);
        } while (existeNumero(numero));

        Bilhete bilhete = new Bilhete(numero);
        bilhetes.add(bilhete);
        return bilhete;
    }

    /**
     * Gera N bilhetes únicos e retorna a lista gerada.
     *
     * @param quantidade quantidade de bilhetes a gerar (assume >= 0)
     * @return lista com os bilhetes gerados
     */
    public List<Bilhete> gerarMultiplosBilhetes(int quantidade) {
        List<Bilhete> gerados = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            gerados.add(gerarBilheteUnico());
        }
        return gerados;
    }

    /**
     * Retorna cópia imutável da lista de bilhetes (evita exposição do estado interno).
     */
    public List<Bilhete> listarBilhetes() {
        return new ArrayList<>(bilhetes);
    }

    /**
     * Verifica se já existe um bilhete com o número especificado.
     */
    public boolean existeNumero(int numero) {
        return bilhetes.stream().anyMatch(b -> b.getNumeracao() == numero);
    }

    /**
     * Limpa todos os bilhetes (útil para testes ou reiniciar sessão).
     */
    public void limparBilhetes() {
        bilhetes.clear();
    }
}
