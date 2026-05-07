package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tamanho da população: ");
        int tamanhoPopulacao = scanner.nextInt();
        String estadoFinal = "123456789";
        System.out.print("Taxa de seleção (entre 20 a 40%): ");
        int taxaSelecao = scanner.nextInt();
        int taxaReproducao = 100 - taxaSelecao;
        System.out.print("Taxa de mutação (entre 5 a 10%): ");
        int taxaMutacao = scanner.nextInt();
        System.out.print("Quantidade de gerações: ");
        int qtdGeracoes = scanner.nextInt();

        List<Cromossomo> populacao = new ArrayList<>();
        List<Cromossomo> novaPopulacao = new ArrayList<>();

        Ag.gerarPopulacao(populacao, tamanhoPopulacao, estadoFinal);
        Collections.sort(populacao);

        System.out.println("Geração 1 ");
        Ag.exibir(populacao);

        /*producao das geracoes*/
        for (int i = 1; i < qtdGeracoes; i++) {
            Ag.selecionarTorneio(populacao, novaPopulacao, taxaSelecao);
            Ag.reproduzir(populacao, novaPopulacao, taxaReproducao, estadoFinal);

            if (i % (populacao.size() / taxaMutacao) == 0) {
                Ag.mutar(novaPopulacao, estadoFinal);
            }

            populacao.clear();
            populacao.addAll(novaPopulacao); // Copia os elementos da nova para a atual
            novaPopulacao.clear();
            Collections.sort(populacao);
            System.out.println("\n\nGeração " + (i + 1));
            Ag.exibir(populacao);
        }
        scanner.close();
    }
}