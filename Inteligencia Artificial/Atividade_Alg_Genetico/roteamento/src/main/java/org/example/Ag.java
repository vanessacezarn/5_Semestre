package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * classe que realiza as operaçõs do algoritmo genético
 * implementa os métodos de geração da população, seleção por torneio, reproduçao e mutação
 */
public class Ag {
    private static Random rand = new Random();

    /**
     * Metodo que gera a população inicial
     * cada cromossomo rece uma rota aleatoria (classe Util)
     * @param populacao = lista, onde os cromossomos serão adicionados
     * @param tamanhoPopulacao = quantidade de individuos da população
     * @param estadoFinal = rota ideal utilizada para calculo da aptidao
     */
    public static void gerarPopulacao(List<Cromossomo> populacao, int tamanhoPopulacao, String estadoFinal){
        String rota;
        for(int i = 0; i < tamanhoPopulacao; i++){
            rota = Util.gerarRota(estadoFinal.length());
            populacao.add(new Cromossomo(rota, estadoFinal));
        }
    }

    /**
     * metodo que exibe os cromossomos da populacao
     * @param populacao = lista de cromossos
     */
    public static void exibir(List<Cromossomo>populacao){
        for (Cromossomo c : populacao) {
            System.out.println(c);
        }
    }

    /**
     * Metodo que realiza a selecao dos individuos utilizando o metodo de torneio
     * @param populacao = lista da populacao atual
     * @param novaPopulacao = lista de populacao que recebera os sorteados
     * @param taxaSelecao = percentual de individuos selecionados
     */
    public static void selecionarTorneio(List<Cromossomo> populacao,List<Cromossomo> novaPopulacao, int taxaSelecao){
        List<Cromossomo> torneio = new ArrayList<>();
        /*calcula quantos devem ser selecionados a partir do tamanho da populacao com a taxa_selecao   */
        int qtdSelecionados = (int) (taxaSelecao * populacao.size() / 100);

        Collections.sort(populacao); /*ordena pela melhor aptidao*/
        novaPopulacao.add(populacao.get(0));/*eletismo = preserva o melhor individuo*/

        int i =1;
        while (i <= qtdSelecionados){
            for (int j = 0; j < 3; j++) {
                torneio.add(populacao.get(rand.nextInt(populacao.size())));
            }

            Collections.sort(torneio); /*ordena pela melhor aptidao, logo o mais apto ficara no inicio*/
            Cromossomo selecionado = torneio.get(0);

            /*evitar repetição de rotas*/
            if (!novaPopulacao.contains(selecionado)) {
                novaPopulacao.add(selecionado);
                i++;
            }
            torneio.clear();
        }
    }

    /**
     * Metodo que realiza a reproducao dos cromossomos --> gera 2 filhos
     * Crossover --> filho é gerado a partir da metade da mãe e de metade do pai
     * @param populacao = lista da populacao atual
     * @param novaPopulacao = lista de populacao que receberá os filhos
     * @param taxaReproducao = percentual de reproducao
     * @param estadoFinal = rota ideal utilizada para calculo da aptidao
     */
    public static void reproduzir(List<Cromossomo> populacao, List<Cromossomo> novaPopulacao, int taxaReproducao, String estadoFinal) {
        int qtdReproduzidos = (int) (taxaReproducao * populacao.size() / 100);

        for (int i = 0; i < qtdReproduzidos; i += 2) {
            /*escolhe aleatoriamente um pai e uma mãe*/
            Cromossomo pai = populacao.get(rand.nextInt(populacao.size()));
            Cromossomo mae = populacao.get(rand.nextInt(populacao.size()));

            /*pega os valores das rotas*/
            String sPai = pai.getValor();
            String sMae = mae.getValor();
            int meio = sPai.length() / 2; /*calcula o ponto de corte*/

            // Crossover (Corte no meio)
            String sFilho1 = sPai.substring(0, meio) + sMae.substring(meio);
            String sFilho2 = sMae.substring(0, meio) + sPai.substring(meio);

            novaPopulacao.add(new Cromossomo(sFilho1, estadoFinal));
            novaPopulacao.add(new Cromossomo(sFilho2, estadoFinal));
        }

        // Poda: Garante que a nova população não exceda o tamanho da original
        while (novaPopulacao.size() > populacao.size()) {
            novaPopulacao.remove(novaPopulacao.size() - 1);
        }
    }

    /**
     * metodo que realiza mutacao aleatoria na populacao
     * @param populacao = lista da populacao atual
     * @param estadoFinal =  rota ideal utilizada para calculo da aptidao
     */
    public static void mutar(List<Cromossomo> populacao, String estadoFinal) {
        /* calcula quantos individuos vão sofre mutaçao (até 20% da população sofre mutação)*/
        int qtdMutantes = rand.nextInt(Math.max(1, populacao.size() / 5));

        while (qtdMutantes > 0) {
            /*escolhe um individuo de forma aleatoria*/
            int posicaoMutante = rand.nextInt(populacao.size());
            Cromossomo mutante = populacao.get(posicaoMutante);
            /*transforma a string em vetor de caractere*/
            char[] genes = mutante.getValor().toCharArray();
            // Escolhe uma posição aleatória para mudar
            int indexGene = rand.nextInt(genes.length);
            genes[indexGene] = Util.getCidade().charAt(rand.nextInt(Util.getTamanho()));
            /*substitui o antigo cromossomo pelo mutado*/
            populacao.set(posicaoMutante, new Cromossomo(new String(genes), estadoFinal));
            qtdMutantes--;
        }
    }
}