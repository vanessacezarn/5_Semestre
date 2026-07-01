# MÁQUINA DE TURING
- 1900 - Problemas de Hilbert ➜ 23 maiores problemas em aberto
- 1936 - Alan Turing desenvolve a máquina de Turing como resposta para o problema Entscheidungsproblem ou Problema de Decisão
  - "Se existe um método mecânico (automático) para determinar se uma dada sentença lógica segue ou não de um conjunto de axiomas?"
    -  Turing demonstrou, por meio de sua máquina, que o problema pode não ter solução ➜ Existem problemas matemáticos bem formulados para os quais não se pode dizer se tem ou não solução, são os problemas indecidíveis
- A Máquina de Turing é considerada “uma proposta de definição formal da noção intuitiva de algoritmo” (MENEZES, 2010, p.222).
- Como a noção de algoritmo não é demonstrável é assumida a Hipótese de Church ou de Turing-Church em que tem-se: “A capacidade de computação representada pela máquina de Turing é o limite máximo que pode ser atingido por qualquer dispositivo de computação.” (MENEZES, 2010, p.222)
- Todo problema que pode ser resolvido por uma Máquina de Turing é um problema com uma solução que possui um algoritmo que executará em tempo polinomial, em um computador real (HOPCROFT; ULLMAN; MOTWANI, 2002).
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
  -  $\beta$ = símbolo especial que representa as células em branco na fita, pois a dita é infinita
  -  &#9447; = marcador de inicío da fita, estando sempre na célula mais à esquerda
----
### Função Programa
- o diagrama possui os estados da máquina representados em forma de elipses e as transições são as arestas entre as elipses, cujo conteúdo define a troca de estado conforme a entrada que está na fita
<div align="center">
  <img width="315" height="182" alt="image" src="https://github.com/user-attachments/assets/06694148-4bcd-4a17-bac3-8709f401dbb8" />

</div>

- a transição possui 3 elementos:
  - a ➜ símbolo lido da fita
  - x ➜ símbolo que será gravado na fita
  - D ➜ indica o movimento da cabeça de leitura (esquerda ou direita)

----
### Critério de parada da Máquina de Turing
- se o processamento atingir:
  - um estado final ➜ indica que a palavra de entrada é ACEITA (reconhecida)
  - um estado não final ➜ a palava de entrada é REJEITADA (não reconhecida)
  - loop infinito ➜ máquina fica infinitamente em processamento
