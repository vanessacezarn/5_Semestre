package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestaShuffle {
    public static void main(String[] args) {
        // Correção na tipagem da população para maior segurança
        List<List<Integer>> populacao = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            // Cria uma nova ArrayList mutável a cada iteração
            List<Integer> cromossomo = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

            // Agora o shuffle funciona pois a lista permite modificações
            Collections.shuffle(cromossomo);

            populacao.add(cromossomo);
        }

        for (List<Integer> lista : populacao) {
            System.out.println(lista);
        }

    }
}
