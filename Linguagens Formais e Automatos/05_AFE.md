# Autômato Finito com Movimentos Vazios - $AF\varepsilon$ ou $AFN\varepsilon$
- movimentos vazios consituem uma generalização dos modelos de máquina não determinística 
- um movimento vazio é uma transição sem leitura de símbolo algum da fita, ou seja, há mudança de estado sem leitura de símbolo
- não aumenta o poder computacional do autômato
- AFD não contém movimento vazio
- qualquer $AF\varepsilon$ pode ser simulado por um AFND
- uma transição vazia é representada pela aplicação da função programa, em um estado q ao símbolo $\varepsilon$ (vazio)
    -  ```mermaid
          graph LR;
            q0--|a|--> q1;
            q0--|vazio|-->q2;
            q0--|b|--> q3;
            
        ```
- o processamento de umn $AF\varepsilon$ é análogo a um AFN
- o processamento de uma entrada vazia é não determinístico, ou seja, um AF ao processar a entrada assume simultaneamente os estados destino e origem (esse último é sempre um caminho alternativo)

### ➥ $AF\varepsilon$ é um 5-upla M
- M = { $\Sigma$, Q, $\sigma$, q0, F}, em que:
  - $\Sigma$ =  alfabeto de entrada
  - Q = conjunto dos estados possíveis do autômato (conjunto finito)
  - $\sigma$ é a função programa ou função de transição. $\sigma: Q x \Sigma  🡺 2 ^Q$
    - $\sigma$ pode ser representado por grafo(diagrama), tabela ou notação matemática
  - q0 = estado inicial
  - F = conjunto de estados finais 
### Exemplo
1) $L1={a^nb^k| n>=0 e k>=0}$
    - grafo
         ```mermaid
          graph LR;
            q0--|a|--> q0;
            q0--|vazio|-->q1;
            q1--|b|--> q1;
            
        ```
    - tabela
        | $\sigma$| a | b |$\varepsilon$
        |:---:|:---:|:---:|:---:|
        | q0 | {q0}| - |{q1}
        | q1 | - | {q1} | - |
        
