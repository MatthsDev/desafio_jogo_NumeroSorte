package br.com.projeto.controller;

import br.com.projeto.models.Bilhete;

import java.util.concurrent.ThreadLocalRandom;

public class GeradorNumeroSorteado {
    public static Bilhete gerarBilhetePremiado() {

        int numero = ThreadLocalRandom.current().nextInt(0, 10000);

        Bilhete bilhetePremiado = new Bilhete();
        bilhetePremiado.setNumeracao(numero);

        return bilhetePremiado;
    }

    public static void exibirBilhetePremiado() {
        System.out.println("============= O bilhete sorteado foi: " + gerarBilhetePremiado().getNumeracao()+" =============");
    }
}
