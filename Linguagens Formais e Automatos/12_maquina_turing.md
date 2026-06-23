# MÁQUINA DE TURING
- início do século XX
  - definir um modelo computacional suficientemente genérico, capaz de implementar qualquer função computável
  - viabilizar a exploração dos limites do que pode ser computado
  - 1936 ➜ Alan Turing propôs um formalismo para representação de procedimentos efetivos
    - "O trabalho de Turing é particularmente significativo por ter sido o primeiro a identificar programas escritos para uma "máquina computacional", como noções intuitivas do efetivamente computável." Menezes, 2011
- máquina de Turing é usada como modelo teórico de computação ➜ atualmente, é aceita como uma formalização de um procedimento efetivo (algoritmo ou função computável)
  - a intenção do modelo foi simular as atitudes humanas relacionadas à computação ➜ trouxe a fundamentação teórica para o desenvolvimento do computador, com a organização conhecida atualmente
- tese ou hipótese de Church (1936) ➜ é assumida como uma hipótese para toda a teoria da computação
  - Alonzo Church ➜ qualquer função computável pode ser processada por uma máquina de Turing, ou seja, existe um procedimento expresso na forma de uma máquina de Turing capaz de processar tal função
  - como a noção intuitiva de procedimentos não é matematicamente precisa, é impossível demonstrar formalmente se a máquina de Turing é, de fato, o mais genérico dispositivo de computação ➜ todos os demais modelos propostos possuem, no máximo, a mesma capacidade computacional dessa máquina
---
### Partes da Máquina de Turing 
- fita ➜ dispositivo de entrada e saída (armazenamento) de dados
  - dividida em células e cada célula armazena um dado
- unidade de controle ➜ reflete o estado corrente da máquina
  - possui uma unidade de leitura e gravação que acessa uma célula da fita de cada vez e pode movimentar-se uma célula para esquerda ou direita
- programa, função programa ou função transição ➜ função que comanda a máquina, define a sua lógica de funcionamento  
----
### Definição
- Máquina de Turing é 8-upla M { $\Sigma$, Q, $\sigma$, q0, F, V, $\beta$, &#9447;} em que :
  -  $\Sigma$ =  alfabeto de símbolos de entrada
  -  Q = conjunto dos estados da máquina
  -  $\sigma$ =  função programa ou função transição ou programa, definida: $\sigma$ = Q x ( $\Sigma \cup V \cup$ { $\beta , &#9447;$}) ➜ Q x ( $\Sigma \cup V \cup \beta , &#9447;$ ) x {E, D} em que E representa o movimento para esquerda da cabeça da fita e D o movimento para a direita 
  -  q0 = estado inicial, indica o ponto inicial do processamento
  -  F = conjunto de estados finais
  -  V = alfabeto auxiliar (conjunto de símbolos usados para gravação na fita da máquina)
  -  $\Sigma$ = símbolo especial que representa as células em branco na fita, pois a dita é infinita
  -  &#9447; = marcador de inicío da fita, estando sempre na célula mais à esquerda
