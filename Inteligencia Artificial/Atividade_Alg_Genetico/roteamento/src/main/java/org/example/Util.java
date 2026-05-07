package org.example;

import java.util.Random;

public class Util {
    private static String cidade = "123456789";
    private static int tamanho =  cidade.length();
    private static Random rand = new Random();

    public static String getCidade() { return cidade; }
    public static int getTamanho() { return tamanho; }

    /**
     * metodo que ira gerar um sequencia aleatoria de caracteres baseado no cidade
     * @param n = quantidade de caracteres (cidades) que a rota deverá ter
     * @return string que representa a rota gerada
     */
    public static String gerarRota(int n){
        String rota = "";
        for(int i = 0; i < n; i++){
            /*
            * gera um número aleatorio entre 0 e o tamanho-1 e pega o caractere que esta na posicao do numero sorteado
            * e o adiciona o caractere no final da string rotas
            */
            rota += cidade.charAt(rand.nextInt(tamanho));
        }
        return rota;
    }
}
