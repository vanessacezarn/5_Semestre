# Computação Evolutiva: Algoritmos Genéticos 
---
### Anotações
- método de busca 'turbinado' com aleatoriedade ... maior chute da paróquia ➜ é um gerar e testar turbinado'/força bruta ➜ gera e testa vários ao mesmo tempo (uma população) 
- é uma tecnica de IA de motores de Raciocínio parecido com é um método de busca A*
  - diferença para A*, é que o A* gera e testa um por vez
- é um método de busca com heuristíca  dinâmica 
- bastante utilizado quando não se sabe o estado final e há muitas restrições (ifs)
- ? o quão longe tu está da falha é melhor
- produz estados como os métodos de busca, entretanto, a produção não é linear, mas sim em paralelo (como se fosse um vetor/lista) ➜ a cada geração um AG pode produzir  N estados novos
- evolução = convergir para a solução, se ele estagna pode ocorrer uma mutação (pode ocorrer uma melhora ou piora) 
#### aula 30/04
- AG é um método de busca para problemas de ALTA COMPLEXIDADE (esforço) (aumenta a complexidade: restrições e heurística)
  - heuristico = 'atalho/dica'
    - dinâmico ➜ cálculo aptidão (fitness)
       - pontos para quem (estado/cromossomo/individuos) se aproxima da solução ➜ problemas acadêmicos
       - pontos para quem se AFASTA das restrições
  - não faz diagnostico ➜ AG não trabalha com amostra  
----
### ➥ Contexto
- área de IA inspirada na teoria da Evolução Natural e na Genética
  - Sub-áreas:
    - algortimos genéticos
    - estratégias de evoulação
    - programação genética
- AG é um modelo computacional baseados nas teorias de seleção natural e hereditariedade
  - baseado na teoria da evolução Charles Darwin
    - método de seleção natural ➜ os mais aptos ou mais perto da solução ou com os menos restrições feridas irão passar para a próxima geração
    - método de cruzamento/crossover ➜ vai eleger dois estados para cruzarem/reproduzirem ➜ MÉTODO QUE CRIA INDIVIDUOS (único)
    - método de mutação ➜ método que cria individuos a partir da alteração de outro
    - eletismo ➜ tem relação com a seleção, ou seja, o melhor indivíduo sempre é selecionado para a próxima geração  
### ➥ método de resolução de problemas
- toda tarefa de busca ou otimização possui:
    - estado inicial(ais) ou final(ais)
    - regras de transição ou operadores
    - espaço de busca ➜ possibilidade de solução de um problema
    - função de avaliação ➜ função de custo
- método de busca e otimização tradicional
  - candidato (estado inicial )
  - aplicações das regras de transição + heurítica ➜ processo iterativo e heuríticas estáticas
#### ➤ método de resoluçaõ de problema em AG
- busca de soluções em espaço de estados
   - estados produzidos são prováveis soluções ou indivíduos da população, denominados **cromossomos**
   - os operadores ou regras de transição de estados são **mecanismos de seleção e de reprodução** que tentam encontrar melhores soluções ou indíviduos
     - sobrevivência do mais forte ➜ melhores soluções a cada geração
     - cruzamento ou reprodução ➜ crossover ➜ criar novos a partir de 2 existentes na geração anterior (70%) os outros 30% são selecionados(seria a 'passagem' de elemetos por inteiro da geração anterior para a próxima)
     - mutação ➜ alguma modificação 'sem explicação' de uma geração para outra 
- é possível operar sobre uma população de candidatos (espaço de estados) em paralelo
- usa a estratégia de gerar e testar
### ➥ fluxograma básico
<div align="center">
  <img width="550" height="385" alt="{138B6E9D-34AF-41AA-9635-B10B34D9FAC6}" src="https://github.com/user-attachments/assets/84626781-c298-4bd6-948c-7eb9e8245a52" />
</div>

- em seleção dar prefrência pelo tornerio quando a população for muito grande
  - metodo roleta é bom apenas para população pequenas, enquanto a aptidão relativa ficar abaixo de 0,..% fica mto ruim de faze a distribuição.   

---
### Problema acadêmico 
em problemas acadêmicos sabe-se o estado final desejado 
- para gerar rotas é diferente de gerar palavras
  - gerar rotas precisa usar ''shuffle' para embaralhar as rotas e não gerar, pois não pode haver uma rota de 5-5
### ➥ geração de palavras em evolução até chegar numa palavra de estado final
#### entradas: 
- tamanhoPopulação
- quantidadeGeracoes
- taxaSelecao/taxaReproducao
- taxaMutacao
- neste caso em especial, a palavraFinal
#### Pensar Orientado a Objetos
- criar a classe Cromossomo (representa um estado ou individuo)
  - atributos
  - construtor
  - cálculo de aptidão (heurítica) ➜ 'pulo do gato'
- criar uma classe Util como métodos utilitários ao problema
- criar uma classe para aplicar o AG
  - tamanhoPopulacao
  - quantidadeGeracoes
  - taxaSelecao / taxaReproducao
  - taxaMutacao
  - neste caso em especial, a palavraFinal
```
inicializarPopulacao(populacao,tamanhoPopulacao,palavraFinal)
  ordenarPopulacao(populacao) //decrescente pela aptidao
  exibirPopulacao(populacao)

  laço 1 até quantidadeGeracoes
    selecionarPopulacao(populacao,novaPopulacao,taxaSelecao)
    reproduzirPopulacao(populacao,novaPopulacao,taxaReproducao,palavraFinal)
    
    mutarPopulacao(novaPopulacao,palavraFinal) //verificar a taxa ou a frequencia
    ordenarPopulacao(novaPopulacao)
    exibirPopulacao(novaPopulacao)

    apagar(populacao)
    mover(novaPopulacao,populacao)
    apagar(novaPopulacao)
```
### codigo em java
```.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

class Util {
    
    static String letras = "abcdefghijklmnopqrstuvxwyz ABCDEFGHIJHIJKLMNOPQRSTUVXWYZ";
    static int tamanho = letras.length();

    /*método para gerar palavras aleatórias a partir das letras fornecidas*/
    public static StringBuffer gerarPalavra(int n) {
        StringBuffer palavra = new StringBuffer();
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            palavra.append(letras.charAt(gerador.nextInt(tamanho)));
        }
        return palavra;
    }
}

final class Cromossomo implements Comparable<Cromossomo> {

    StringBuffer valor; //guardar a palavra
    int aptidao;        //fitness do individuo baseado no cálculo da heurística 
    int aptidaoPorcentagem;  //usado no processo de seleção - distribuir 'fichas' de sorteio para a seleção

    /*constutor sem calcular a aptidao*/
    public Cromossomo(StringBuffer valor, int aptidao) {
        this.valor = valor;
        this.aptidao = aptidao;
    }

    /*calcula a aptidao da palavra*/
    public Cromossomo(StringBuffer valor, String estadoFinal) {
        this.valor = valor;
        this.aptidao = calcularAptidao(estadoFinal);
    }

    /*método que calcula a aptidão da palavra gerada*/
    int calcularAptidao(String estadoFinal) {
        int nota = 0;
        for (int i = 0; i < estadoFinal.length(); i++) {
            /*se a letra faz parte da palavra final*/
            if (this.valor.toString().contains(estadoFinal.charAt(i) + "")) {
                nota += 5;
            }
            /*se a letra estiver na posição correta da palavra final*/
            if (this.valor.toString().charAt(i) == estadoFinal.charAt(i)) {
                nota += 50;
            }
        }
        return nota;
    }

    @Override
    public int compareTo(Cromossomo cromossomo) {
        if (this.aptidao > cromossomo.aptidao) {
            return -1;
        }
        return 1;
    }
}

public class AG_SugestaoFinal {

    static void gerarPopulacao(List<Cromossomo> populacao, int n, String estadoFinal) {
        for (int i = 0; i < n; i++) {
            populacao.add(new Cromossomo(Util.gerarPalavra(estadoFinal.length()), estadoFinal));
        }
    }

    static void ordenarPopulacao(List<Cromossomo> populacao) {
        //Collections.sort(populacao);
        boolean houveTroca;
        Cromossomo tmp;
        int distancia = populacao.size();

        do {
            distancia = (int) (distancia / 1.3);
            if (distancia <= 0) {
                distancia = 1;
            }
            houveTroca = false;
            for (int i = 0; i < populacao.size() - distancia; i++) {
                if (populacao.get(i).aptidao < populacao.get(i + distancia).aptidao) {
                    tmp = populacao.get(i);
                    populacao.set(i, populacao.get(i + distancia));
                    populacao.set(i + distancia, tmp);
                    houveTroca = true;
                }
            }
        } while (distancia > 1 || houveTroca);
    }

    static void exibirPopulacao(List<Cromossomo> populacao) {
        for (int i = 0; i < populacao.size(); i++) {
            System.out.println(populacao.get(i).valor + "  " + populacao.get(i).aptidao);
        }
    }

    static void gerarSelecao(List<Cromossomo> populacao, List<Cromossomo> novaPopulacao, int taxaSelecao) {
        //método da roleta

        //calcular a aptidao total
        int aptidaoTotal = 0;
        for (int i = 0; i < populacao.size(); i++) {
            aptidaoTotal += populacao.get(i).aptidao;
        }

        //aptidaoTotal -> 100
        //aptidao      -> aptidaoPorcentagem
        //aptidaoPorcentagem = aptidao * 100 / aptidaoTotal;
        for (int i = 0; i < populacao.size(); i++) {
            populacao.get(i).aptidaoPorcentagem = populacao.get(i).aptidao * 100 / aptidaoTotal;
            if (populacao.get(i).aptidaoPorcentagem == 0) {
                populacao.get(i).aptidaoPorcentagem = 1;
            }
        }

        List<Cromossomo> sorteio = new ArrayList<>();
        for (int i = 0; i < populacao.size(); i++) {
            for (int j = 0; j < populacao.get(i).aptidaoPorcentagem; j++) {
                sorteio.add(populacao.get(i));
            }
        }

        Random gerador = new Random();
        int posicaoSorteio;
        
        //populacao.size()	->	100
        //qtdSelecionados	-> 	taxaSelecao
        int qtdSelecionados = taxaSelecao * populacao.size() / 100;
        
        //elitismo
        novaPopulacao.add(populacao.get(0));
        Cromossomo selecionado;

        for (int i = 1; i <= qtdSelecionados; i++) {
            posicaoSorteio = gerador.nextInt(sorteio.size());
            selecionado = sorteio.get(posicaoSorteio);

            novaPopulacao.add(selecionado);

            while (sorteio.remove(selecionado)){} //controle dos visitados
        }
    }

    static void gerarReproducao(List<Cromossomo> populacao, List<Cromossomo> novaPopulacao, int taxaReproducao, String estadoFinal) {
        Random gerador = new Random();
        int posicaoMae, posicaoPai;
        String mae, pai, filho1, filho2;

        int frequencia = taxaReproducao * populacao.size() / 100;

        for (int i = 0; i <= frequencia / 2 + 1; i++) {
            posicaoPai = gerador.nextInt(populacao.size());
            do {
                posicaoMae = gerador.nextInt(populacao.size());
            } while (posicaoPai == posicaoMae);

            pai = (populacao.get(posicaoPai).valor).toString();
            mae = (populacao.get(posicaoMae).valor).toString();

            filho1 = pai.substring(0, pai.length() / 2) + mae.substring(mae.length() / 2, mae.length());
            filho2 = mae.substring(0, mae.length() / 2) + pai.substring(pai.length() / 2, pai.length());

            novaPopulacao.add(new Cromossomo(new StringBuffer(filho1), estadoFinal));
            novaPopulacao.add(new Cromossomo(new StringBuffer(filho2), estadoFinal));
        }
        //aparar o final da lista novaPopulacao para que fique do tamanho padrao
        while (novaPopulacao.size() > populacao.size()) {
            novaPopulacao.remove(novaPopulacao.size() - 1);
        }
        //System.out.println(novaPopulacao.size());
    }

    static void gerarMutacao(List<Cromossomo> novaPopulacao, String estadoFinal) {
        Random gerador = new Random();
        int qtdMutantes = gerador.nextInt(novaPopulacao.size()/10);
        Cromossomo mutante;
        int posicaoMutante;

        for (; qtdMutantes > 0; qtdMutantes--) {
            posicaoMutante = gerador.nextInt(novaPopulacao.size());
            mutante = novaPopulacao.get(posicaoMutante);
            //JOptionPane.showMessageDialog(null,"vai mutar " + mutante.valor + "  " + mutante.aptidao);
            //mudando
            String valorMutado = mutante.valor.toString();
            char caracterMutante = mutante.valor.charAt(gerador.nextInt(mutante.valor.length()));
            char caracterSorteado = Util.letras.charAt(gerador.nextInt(Util.tamanho));
            valorMutado = valorMutado.replace(caracterMutante, caracterSorteado);          
            mutante = new Cromossomo(new StringBuffer(valorMutado), estadoFinal);
            JOptionPane.showMessageDialog(null, "mudado " + mutante.valor + "  " + mutante.aptidao);
            //recalculando sua aptidao
            novaPopulacao.set(posicaoMutante, mutante);
        }
    }

    public static void main(String[] args) {
        int tamanhoPopulacao = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o tamanho da populacao"));
        int taxaSelecao = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a taxa de selecao"));
        int taxaMutacao = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a taxa de mutacao"));
        int qtdGeracoes = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a quantidade de geracoes"));
        String estadoFinal = JOptionPane.showInputDialog(null,"Informe a palavra desejada");

        List<Cromossomo> populacao = new ArrayList<>();
        List<Cromossomo> novaPopulacao = new ArrayList<>();

        gerarPopulacao(populacao, tamanhoPopulacao, estadoFinal);
        ordenarPopulacao(populacao);
        System.out.println("Geração 0");
        exibirPopulacao(populacao);

        /*utilizada para saber qual a frequncia que precisa gerar mutações na população
        regra de 3
          qtdGeracoes -> 100
          frequencia -> taxaMutacao
        */
        int frequencia = qtdGeracoes * (100 - taxaMutacao) / 100;

        for (int i = 1; i < qtdGeracoes; i++) {
            //selecionar
            gerarSelecao(populacao, novaPopulacao, taxaSelecao);

            //reproduzir
            gerarReproducao(populacao, novaPopulacao, 100 - taxaSelecao, estadoFinal);

            //mutar de tempos em tempos
            if (i % frequencia == 0) {
                System.out.println("Nessa geração haverá mutação!!\n\n");
                //JOptionPane.showMessageDialog(null, "Nessa geração haverá mutação!!\n\n");
                gerarMutacao(novaPopulacao, estadoFinal);               
            }

            populacao.clear();
            populacao.addAll(novaPopulacao);
            novaPopulacao.clear();

            ordenarPopulacao(populacao);
            System.out.println("Geração " + i);
            exibirPopulacao(populacao);
        }

    }
}
```
