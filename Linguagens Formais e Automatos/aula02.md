* correção atividade de conceitos iniciais
### Sistema de Estados Finitos
- modelado por diagramas de estado
- exemplo:
  1) modelar os estados de uma lâmpada
      -  🡻 (indica o estado inicial) = nesse caso desligado
      - pressionar interruptor = evento para mudar o estado
      - Os dois estados não coexistem ao mesmo tempo
      ```mermaid
        graph LR;
          DESLIGADO--|interruptor|--> LIGADO;
          LIGADO --|interruptor|--> DESLIGADO;
      ```
  2) elevador prédio 04

## Autômatos Finitos Determinístico
- é um sistema de estados finitos
- nas linguagens formais é um formalismo Reconhecedor ou Operacional, pois vão perceber se as palavras pertencem ao dicionario da linguagem (análise lexica)
- estado é indicado por q --> no diagrama é representado por um circulo
- tem apenas um estado inicial (q0)
- pode ter mais de um estado final --> circulo pequeno dentro do circulo do estado
- dada uma palavra de entrada 🡺 autômato finito 🡺 saída (aceita ou rejeita)
- exemplos:
1)  L = {aa}
    - fita de entrada: | a| a| é aceita, se a fita de entrada fosse |a|b| não seria aceita pois na linguagem não tem b
    - função programa ou de transição : parte que contém a lógica, que faz o processamento
        - sempre inicial na parte mais esquerda da palavra e lê uma por uma sem voltar  
      ```mermaid
        graph LR;
          q0--|a|--> q1;
          q1 --|a|--> q2;
      ```
2) L2 = {aa, ab, ba, bb}
      ```mermaid
        graph LR;
          q0--|a|--> q1;
          q0--|b|--> q1;
          q1 --|a|--> q2;
          q1 --|b|--> q2;
      ```
      * se a fita de entrada for:
          * |b|a| ou |a|b| ou |a|a| ou |b|b|  🡺 aceita
          * |a|a|b| 🡺 rejeita, pois q2 não tem saida
3) L3 = {W  ∈ {0,1}+| w tem prefixo 10}
4) L4 = {W  ∈ {a,b}+| |w|>=2 e tem prefixo b}
