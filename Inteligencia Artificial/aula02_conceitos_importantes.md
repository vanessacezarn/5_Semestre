## Conceitos que é necessário aprender até o fim do semestre
### 1)  que tipos de problemas a IA resolve :
   1) problemas que é necessário a presença de especialista, muitas vezes por causa da quantidade de restrições
   2) problema em que não se sabe o estaddo final ou problemas em que se precisa saber o passo-a-passo(como fazer) da solução
### 2)  o que é inteligência artificial

área da computação com metodologia, técnicas e algoritmos para resolver aqueles tipos de problemas

### 3)  principais subáreas de inteligência artificial
  1) métodos de busca
      * são motores de raciocínio (dedutivo e indutivo)
          * "motor" de força bruta ➜ amplitude e/ou profundidade
          * "motor" heurísticos ➜ guloso, subida de encosta, A*, algoritmos genéricos 
  2) redes neurais
  3) sitemas multiagentes
  4) representação de conhecimento ➜ prolog
  5) processamento de língua natural ➜ "português"

### 4) o que é um sistema de comportamento inteligente (S.I.C) 
 
  * Um sistema composto por:
     * base de conhecimento (fatos e regras, ou crença e plano)
     * Raciocínio Automatizado (dedução e indução)
     * Apredizadao de máquina (treinamento por repetição ou amostra)
  
### 5) que tipo de problema RNA (redes neurias) resolve

  Problemas de reconhecimento de padrões ou em que a presença do especialista é fundamental

### 6) quais as características que um problema apresenta quando ele tem alta complexidade
  1) restrições
  2) desconhecimento do estado final
    
### 7) no processo de modelagem da solução de problemas na área de IA, o que se deve modelar
  1) estados: iniciais e finais ➜ é uma possível solução, é um instante do processo de solução
        * atributos 
  2) regras de transição
        * métodos
  3) restrições
  4) lista de visitados
  5) função meta ou objetivo

---
### Anotações
* validação de um dado deve começar a ser feito procurando o erro/restrição e não o acerto
* IA resolve  problema de diagnostico (especialista) ➜ reconhecimento de padrões, a partir das amostra que IA teve acesso
    * quando maior a amostra que uma IA teve acesso mais especialista em algo ela se torna, ou seja, maior sua base de conhecimento
--- 
#### Jogo da Rainha ➜ modelagem da solução de problemas na área de IA
- uma tabuleiro com N x N de xadrez precisa receber N rainhas. O objetivo é colocar as N rainhas no tabuleiro, uma a uma, de forma que nenhuma rainha "coma" outra rainha (regras do xadres)
##### passos de modelagem:
 1) estado do problema (inicial, final e os intermediarios)
      * objetivo de uma classe com atributos diferentes em casa momento da solução
          - a) matriz N x N de inteiros, onde 0 indica que não há rainhas e 1 indica que há rainhas naquela posição
          - b) variaveis contabilizando o total de rainhas que estão no tabuleiro(int)
          
      * estado inicial ➜ matriz inicialiazada com 0, assumindo que N é 4
      * estado final (objetivo/meta) ➜ qtd rainhas = 4
```
0  0  0  0
0  0  0  0
0  0  0  0
0  0  0  0
``` 

2) regras de transição == métodos == operações
    * exemplo: colocar uma rainha em um slot vazio ou célula == 0
3) restrições ou métodos ehValido()
    * exemplo: procurar se o estado é inválido
4) visitados
    * tradicionais = lista
    * arrojada = árvores
    * ideal = hash
5) função meta ou objetivo
    * função para saber se chegou ao estado final desejado ➜ qtsRainhas = 4

```java
public class Rainha {
  static List<Rainha> visitados = new LinkedList<>();
  
  int matriz[][];
  int qtdRainhas;

  public Rainha(int tamanhoTabuleiro){
    this.matriz = int(tamanhoTabuleiro, tamanhoTabuleiro);
    this.qtdRainha = 0;
    for (int i =0; i <this.matriz.size(); i++){
      for (int j=0; j <this.matriz.size(); j++){
          matriz[i][j]
      }
    }
  }
  public Rainha (int proximaRainha){
    // metodo para percorrer as celulas para encontra uma celula vazinha e então depositar a rainha (linha, coluna)
  }
  public boolean ehMeta(int tamanhoTabuleiro)
    return this.qtdRainha === tamanhoTabuleiro
  }
  public boolean ehValido(Rainhanovo){
      // metodo que avelie a matriz do novo verificando se ha mais de uma rainha: na linha, na coluna, na diagonal principal e na diagonal secundaria
  }

}
```
