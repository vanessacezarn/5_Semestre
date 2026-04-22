## AUTÔMATO FINITO NÃO DETERMINÍSTICO (AFND ou AFN)
- a função programa de um autômato finito não-determinístico ao processar uma entrada (estado corrente e símbolo lido) tem como resultado um conjunto de novos estados
- exemplo: estado q0 ao processar o símbolo 'a' pode assumir os estados q1,q2 ou qn:
  - notação matemática: $\sigma(q0,a) = {q1,q2,q3}$ 
```mermaid
      graph TD;
        q0--|a|--> q1;
        q0--|a|-->q2;
        q0--|a|-->q3;
```
- assume um conjunto de estados alternativos, como se houvesse uma multiplicação de unidades de controle, uma para cada alternativa, processando independentemente, sem compartilhar recursos.
  - o processamento de um caminho não influi no estado, símbolo lido e posição da cabeça da fita para os demais caminhos alternativos.
  - o processamento de um AFN M para um conjunto de estados, ao ler um símbolo, é a união dos resultados da função programa aplicada a cada estado alternativo
- mesmo que a facilidade do não-determinístico seja aparente ele não aumenta o poder computacional do autômato
- qualque AFN pode ser simulado por um AFD, e ao contrário também
### ➥ AFND é um 5-upla M
- M = { $\Sigma$, Q, $\sigma$, q0, F}, em que:
  - $\Sigma$ =  alfabeto de entrada
  - Q = conjunto dos estados possíveis do autômato (conjunto finito)
  - $\sigma$ é a função programa ou função de transição. $\sigma: Qx \Sigma  🡺 2 ^Q$
    - $\sigma$ pode ser representado por grafo(diagrama), tabela ou notação matemática
    - função parcial = não tem transição para todos os estados
  - q0 = estado inicial
  - F = conjunto de estados finais 
### ➥ Exemplo:
1) L ={W ∈ {a,b}* | W possui aa ou bb como subpalavra}
    - M = ({a,b},{q0,q1,q2,q3}, $\sigma$,q0,{q3})
    - tabela da função programa
      - | $\sigma$| a | b |
        |:---:|:---:|:---:|
        | q0 | {q0,q1}| {q0,q2}|
        | q1 | {q3} | - |
        | q2 | - | {q3} |
        | q3 | {q3} | {q3} |
    - notação matemática da função programa
        - $\sigma$ (q0,a)= q0  |  $\sigma$ (q0,a)= q1 | $\sigma$ (q0,b)= q0  |  $\sigma$ (q0,b)= q2 
        - $\sigma$ (q1,a)= q3
        - $\sigma$ (q2,b)= q3
        - $\sigma$ (q3,a)= q3  |  $\sigma$ (q3,b)= q3    

    - grafo da função programa
        ```mermaid
          graph LR;
            q0--|a|--> q1;
            q0--|b|--> q2;
            q0--|a,b|--> q0;
            q1--|a|--> q3;
            q2 --|b|--> q3;
            q3 --|a,b|--> q3;
        ```

2) L ={W ∈ {a,b}* | W possui aaa como sufixo}
    - M = ({a,b},{q0,q1,q2,q3}, $\sigma$,q0,{q3})
    - tabela da função programa
      - | $\sigma$| a | b |
        |:---:|:---:|:---:|
        | q0 | {q0,q1}| {q0}|
        | q1 | {q2} | - |
        | q2 | {q3} | - |
        | q3 | - | - |
    - - notação matemática da função programa
        - $\sigma$ (q0,a)= q0  |  $\sigma$ (q0,a)= q1 |  $\sigma$ (q0,b)= q0 
        - $\sigma$ (q1,a)= q2
        - $\sigma$ (q2,a)= q3

    - grafo:
        ```mermaid
          graph LR;
            q0--|a|--> q1;
            q0--|a,b|--> q0;
            q1--|a|--> q2;
            q2 --|a|--> q3;
        ```

---
#### ➥ anotações
- um mesmo estado tem transição para dois estados diferentes utilizando um mesmo caractere do alfabeto
- para ele aceitar uma palavra pelo menos um dos caminhos tem que aceitar a palavra, mas pode ter caminhos que não são aceitos
- na representação da função programa o resultado é um conjunto de estados
---
