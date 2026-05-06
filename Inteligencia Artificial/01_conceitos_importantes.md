## Competências da disciplina
### unidade 1: método de busca
- construir programas que apliquem os diferentes métodos de busca existentes em contextos reais da programação
### unidade 2: representação de conhecimento
- aplicar as diferentes formas de representação de conhecimento e seus motores de raciocínio em problemas reais
### unidade 3: sistemas multiagentes
- construir sistemas multi-agentes, aplicando os conceitos e práticas para que o sistema tenha comportamento inteligente e emergente
### unidade 4: redes neurais
- contruir programas utilizando técnicas de Redes Neurais para reconhecimento de padrões em situações mais reais possíveis
---
<div align="center">

#  INTELIGÊNCIA ARTIFICIAL (IA)
</div>

IA = técnica e metodologia para contrução de Sistemas com Comportamento Inteligente
* base de conhecimento = experiência (B,C)
* raciocínio (A,C)
* aprendizado de máquina = reconhecer padrões (C,D)
    * métodos de busca (A)
    * representação de conhecimento (B)
    * algortimos genéricos (A)
    * sistemas inteligentes (C)
    * redes neurais (D) ➜ reconhecimento, diagnóstico
* tipos de problemas ideais para IA
   * diagnósticos  ➜ análise, reconhecimento, encaminhamento
   * 'empacotamento' ➜ problemas que a solução está em um conjunto de passos


## Conceitos que é necessário aprender
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

