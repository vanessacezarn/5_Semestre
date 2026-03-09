# Hierarquia de classes de linguagens ou hierarquia de chomsky
<div align="center">
  <img width="540" height="257" alt="{A056F914-5778-4199-9D3E-C3E1677AA0BE}" src="https://github.com/user-attachments/assets/c0d3b8f6-176f-40de-b558-5db38dbb1861" />  
</div>

# Linguagens regulares ou tipo 3
- contemplam a classe das linguagens mais simples e são abordadas por meio de 3 formalismo:
    - operacional ou reconhecedor  🡺 autômato finito
    - axiomático ou gerador 🡺 gramática regular
    - denotacional 🡺 expressão regular
## AUTÔMATO FINITO
- é uma quíntupla M = { $\sum$, Q, $\sigma$, q0, F} em que :
    -  $\sum$ =  alfabeto
    -  Q = conjunto dos estados
    -  $\sigma$ =  função programa ou função transição ou programa, definida: $\sigma$ = Q x $\sum$ 🡺 Q
    -  q0 = estado inicial
    -  F = conjunto de estados finais
- exemplos:
1) L5 = { W ∈ { a,b,c}+ | W tem prefixo aacc e |w| = 5}
   - M5 = ({a,b,c} , {q0,q1,q2,q3,q4,q5}, $\sigma$, q0, {q5})
   - ```mermaid
        graph LR;
          q0--|a|--> q1;
          q1--|a|--> q2;
          q2 --|c|--> q3;
          q3 --|c|--> q4;
          q4--|a,b,c|-->q5;
          q5--|a,b,c|-->q5;
      ```
2) L6 = { W ∈ {0,1}+ | W tem tamanho ímpar}
    - M6 = ({0,1}, {q0,q1,q2}, $\sigma$, q0, {q1})
    - ```mermaid
        graph LR;
          q0--|0,1|--> q1;
          q1--|0,1|--> q2;
          q2 --|0,1|--> q1;
      ```
3) L7 = { W ∈ { a,b}+ | ab é uma subpalavra de W}
    - M7 = ({a,b}, {q0,q1,q2}, $\sigma$ ,q0,{q2})
    - ```mermaid
        graph LR;
          q0--|a|--> q1;
          q0--|b|-->q0;
          q1--|b|--> q2;
          q1--|a|-->q1;
          q2 --|a,b|--> q2;
      ```
4) L8 = { W ∈ {a,b}+ | W tem subpalavra aaa}
     - M8 = ({a,b}, {q0,q1,q2}, $\sigma$, q0, {q3})
     - ```mermaid
          graph LR;
          q0--|a|--> q1;
          q0--|b|-->q0;
          q1--|a|--> q2;
          q1--|b|-->q0;
          q2--|a|--> q3;
          q2--|b|-->q0;
          q3--|a,b|-->q3;
      ```
5) L9 = { W ∈ {1,0}+ | W tem sufixo 10}
     - M9 = ({0,1}, {q0,q1,q2}, $\sigma$, q0, {q2})
     - ```mermaid
        graph LR;
          q0--|0|--> q0;
          q0--|1|--> q1;
          q1--|0|--> q2;
          q1--|1|--> q1;
          q2--|1|--> q1;
          q2--|0|--> q0;
      ```
