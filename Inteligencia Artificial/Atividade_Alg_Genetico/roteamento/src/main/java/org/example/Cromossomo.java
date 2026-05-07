package org.example;
import java.util.Objects;

/**
 * classe Cromosso é responsavel por armazenar uma rota e sua respectiva aptidao
 */
public class Cromossomo implements Comparable<Cromossomo> {

    private String valor;     /*representa a sequência de cidades da rota*/
    private int aptidao;
    public Cromossomo(String valor, String estadoFinal) {
        this.valor = valor;
        this.aptidao = calcularAptidao(estadoFinal);
    }

    public String getValor() { return valor;}

    public int getAptidao() { return aptidao;}

    /**
     *  Calcula a aptidão do cromossomo com base nas restrições definidas pelo problema.
     * @param estadoFinal rota ideal utilizada como referencia
     * @return valor da aptidao
     */
    public int calcularAptidao(String estadoFinal) {
        int nota = 0;
        /**
         * restriscao 1 : uma cidade de número maior vier primeiro que uma cidade de número menor,
         * deve ter restrição com nota 10;
         */
        for  (int i = 0; i < (estadoFinal.length() -1 ); i++) {
            if (valor.charAt(i) > valor.charAt(i+1)) {
                nota+=10;
            }
        }
        /**
         * restricao 2 : se na rota aparecer mais de uma vez a mesma cidade (número); para cada
         * par de ocorrência dar nota 20.
         */
        for (int i = 0; i < (estadoFinal.length()); i++) {
            for (int j = 0; j < (estadoFinal.length()); j++) {
                if (valor.charAt(i) == valor.charAt(j) && i != j) {
                    nota +=20;
                }
            }
        }
        return nota;
    }

    /**
     * verifica se dois cromossomos são iguais
     * @param o   the reference object with which to compare.
     * @return true se forem iguais ou false se forem diferentes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cromossomo)) return false;
        Cromossomo that = (Cromossomo) o;
        return Objects.equals(valor, that.valor);
    }

    /**
     * compara dois cromossomos com base na aptidao
     * @param outro = cromossomo a ser comparado
     * @return valor negativo se este cromossomo possuir menor aptidão, zero se forem iguais,
     *          ou valor positivo se possuir maior aptidão
     */
    @Override
    public int compareTo(Cromossomo outro) {
        return Integer.compare(this.aptidao, outro.aptidao);
    }

    @Override
    public String toString() {
        return "Valor= " + valor + ';' +" Aptidao=  "+ aptidao;
    }
}
