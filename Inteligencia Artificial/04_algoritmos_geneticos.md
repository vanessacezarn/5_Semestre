# Computação Evolutiva: Algoritmos Genéticos (AG)
- é um método de busca para problemas de **ALTA COMPLEXIDADE** 
    - complexidade = esforço ➜ o que gera o aumento: restrições e heurística
    - heuristico = 'atalho/dica'
        - dinâmico ➜ cálculo aptidão (fitness)
            - pontos para quem (estado/cromossomo/individuos) se aproxima da solução ➜ problemas acadêmicos
            - pontos para quem se AFASTA das restrições (o quão longe tu está da falha é melhor) é mais utilizado
    - bastante utilizado quando não se sabe o estado final e há muitas restrições (ifs)
- não faz diagnostico ➜ AG não trabalha com amostra  
- é um modelo computacional baseados nas teorias de seleção natural e hereditariedade
    - baseado na teoria da evolução Charles Darwin
        - método de seleção natural ➜ os mais aptos ou mais perto da solução ou com os menos restrições feridas irão passar para a próxima geração
        - método de cruzamento/crossover ➜ vai eleger dois estados para cruzarem/reproduzirem ➜ MÉTODO QUE CRIA INDIVIDUOS (único)
        - método de mutação ➜ método que cria individuos a partir da alteração de outro
        - eletismo ➜ tem relação com a seleção, ou seja, o melhor indivíduo sempre é selecionado para a próxima geração  
    - evolução = convergir para a solução, se ele estagna pode ocorrer uma mutação (pode ocorrer uma melhora ou piora) 
- é uma tecnica de IA de motores de Raciocínio parecido com é um método de busca A*
    - diferença para A*, é que o A* gera e testa um por vez
    - AG produz estados como os métodos de busca, entretanto, a produção não é linear, mas sim em paralelo (como se fosse um vetor/lista) ➜ a cada geração um AG pode produzir  N estados novos
        - "método de busca 'turbinado' com aleatoriedade (maior chute da paróquia) ➜ é um gerar e testar turbinado'/força bruta ➜ gera e testa vários ao mesmo tempo (uma população) "
### ➥ Contexto
- área de IA inspirada na teoria da Evolução Natural e na Genética
  - Sub-áreas:
    - algortimos genéticos
    - estratégias de evoulação
    - programação genética
---

## ➤ método de resolução de problemas
- toda tarefa de busca ou otimização possui:
    - estado inicial(ais) ou final(ais)
    - regras de transição ou operadores
    - espaço de busca ➜ possibilidade de solução de um problema
    - função de avaliação ➜ função de custo
- método de busca e otimização tradicional
  - candidato (estado inicial )
  - aplicações das regras de transição + heurítica ➜ processo iterativo e heuríticas estáticas
### ➥ método de resoluçaõ de problema em AG
- busca de soluções em espaço de estados
   - estados produzidos são prováveis soluções ou indivíduos da população, denominados **cromossomos**
   - os operadores ou regras de transição de estados são **mecanismos de seleção e de reprodução** que tentam encontrar melhores soluções ou indíviduos
     - sobrevivência do mais forte ➜ melhores soluções a cada geração
     - **cruzamento** ou reprodução ➜ crossover ➜ criar novos a partir de 2 existentes na geração anterior (70%) os outros 30% são selecionados(seria a 'passagem' de elemetos por inteiro da geração anterior para a próxima)
     - **mutação** ➜ alguma modificação 'sem explicação' de uma geração para outra 
- é possível operar sobre uma população de candidatos (espaço de estados) em paralelo
- usa a estratégia de gerar e testar
---

### ➤ Fluxograma básico
<div align="center">
  <img width="550" height="385" alt="{138B6E9D-34AF-41AA-9635-B10B34D9FAC6}" src="https://github.com/user-attachments/assets/84626781-c298-4bd6-948c-7eb9e8245a52" />
</div>

---
## ➤ Representação ou Codificação
- Cromosso: estrutura de dados
    - vetores ou cadeia de valores com o conjunto de parâmetros da função objetivo (custo)
    - conjunto de todas as configurações que o cromossomo pode assumir forma seu espaço de busca
    - é composto por genes (bits) que são responsáveis por determinadas características do indivíduo
- Representaçãoes (codificações de variáveis):
    - Codificação Binária (mais utilizada) 
        - simples
        - cada cromossomo é uma série de bits 0 ou 1
            - representação genotípica ➜ vetores e alfabetos de tamanho finitos
    - Codificação por Permutação
        - utilizada em problemas que envolvem ordenação
        - cada cromosso é uma sequência de números que representa uma sequência
        - exemplo: problema do caixante viajante ➜ cromosso representa a ordem em que o caixeiro visitará as cidades
            - cromossomo A : 1 5 3 2 6 4 7 9 8
            - cromossomo B : 8 5 6 7 2 3 1 4 9
    - Codificação de Valores
        - pode ser usado em problemas que são usados valores mais complicado 
        - cada cromossomo é uma sequência de alguns valores
        - é uma boa escolha para problemas especiais
            - entrentanto, geralmente é necessário desenvolver métod de cruzamento e mutação específico
    - Codificação em Árvore
        - utilizado para desnvolver programas ou expressões
        - cada cromossomo é uma árvore de alguns objetos

## ➤ Seleção
- princípio básico de funcionamento de AG
    - mecanismo que depois de muitas gerações, gerará indivíduos mais aptos
    1) AG começa com uma população inicial N cromossomos
    2) Novos cromossomos são gerados aleatoriamente (novo espaço de busca) - mais aptos
- uso da função de aptidão (fintess) ➜ nota a partir de quão bons são os genes do cromossomo, ou seja, relativa a função objetivo (custo)
    - Função de aptidão relativa ➜ função de aptidão de uma indivíduo dividida pela soma de todas as aptidões dos indivíduos
### ➥ Métodos 
- Roleta    
    - mais simples e utilizado
    - indivíduos são selecionados a partir de uma roleta ➜ como em jogo de azar
    - cada indivíduo, via sua aptidão, ocupa mais ou menos espaço na roleta
    - a roleta é girada a quantidade de vezes que se queira selecionar indivíduos para a nova geração
- Torneio
    - N indivíduos da população são escolhidos aleatoriamente, com a mesma probabilidade
    - o cromossomo com maior aptidão entre os N é selecionado para população intermediária
    - o processo ocorre até que a população intermediária seja preenchida
    - em geral, a quantidade de selecionados pelo método do torneio e 3, ou seja, N = 3
    - dar prefrência pelo tornerio quando a população for muito grande
        - metodo roleta é bom apenas para população pequenas, enquanto a aptidão relativa ficar abaixo de 0,..% fica mto ruim de faze a distribuição.  
- Amostragem estocátistica
    - variação do método da roleta
    - a quantidade de 'agulhas' será a quantidade de indivíduos que se quer selecionar para a nova geração

---
## ➤ Operadores genéticos
- são as regras de transição ou produção de novos estados (ou espaço de estados)
- operadores
    - Crossover | Cruzamento | Reprodução
        - gareante hereditariedade
    - Mutação
        - garante a diversidade
        - alteração arbitrária de um ou mais genes (componentes da estrutura)
- para garantir que os melhores perpetuem 
    - eletismo ➜ os melhores indivíduos são colocados na próxima geração

---
## ➤ Parâmetros
- taxa de mutação
    - valor alto ➜ busca se torna essencialmente aleatória
    - valor baixo ➜ previne que uma dada posição fique estagnada em um valor, além de possibilitar que se chegue em qualquer ponto do espaço de busca
- taxa de cruzamento/crossover
    - controla a quantidade da população que será substituída
    - valor alto ➜ pode-se perder os melhores indivíduos
    - valor baixo ➜ com valores muito baixos o AG pode se tornar lento
- ponto de corte
    - valor alto ➜ haverá um acréscimo de novas estruturas na população
        - se for muito alta ➜ pode-se perder bons indivíduos
    - valor baixo ➜ com um valor baixo o AG pode ficar muito lento
- tamanho da população
    - valor alto ➜ geralmente fornece uma melhor cobertura do espaço de soluções
        - necessita de mais recursos computacionais
    - valor baixo ➜ fornece uma pequena diversidade de soluções ➜ pode ficar preso em máximos locais
- eletismo
    - não é propiamente um parâmetro do AG, mas ao copiar o(s) melhor(es) indivíduo(s) para a próxima geração, ganha-se em desempenho, pois garante que o melhor fitness (aptidão) somente melhore.
---
## ➤ Aplicações de AG
- O desempenho do algoritmo tem apresentado excelentes resultados para problemas de otimização de grande escala;
- Simplicidade na formulação e solução de problemas de otimização
- Roteamento de Telecomunicações
- Planejamento dos Jogos Olímpicos
- Avaliação de Crédito e Análise de Risco
- Particionamento de circuitos
- Jogos
- Tunning em SGBD – por exemplo, auto tunning do Oracle
--- 
## ➤ Problema acadêmico 
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
- classe util
    ``` java

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
    ```
- classe cromossomo
    ``` java
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
    ```
- classe AG
    ``` java
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
