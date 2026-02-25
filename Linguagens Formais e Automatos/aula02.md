* correção atividade de conceitos iniciais
## Sistema de Estados Finitos
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
      ```mermaid
        graph LR;
          subsolo[Subsolo]
          terreo[Térreo]
          n1[1º Andar]
          n2[2º Andar]
          n3[3º Andar]
      
          subsolo --|apertar_T|--> terreo
          subsolo --|apertar_1|--> n1
          subsolo --|apertar_2|--> n2
          subsolo --|apertar_3|--> n3
      
          terreo --|apertar_S|--> subsolo
          terreo --|apertar_1|--> n1
          terreo --|apertar_2|--> n2
          terreo --|apertar_3|--> n3
      
          n1 --|apertar_S|--> subsolo
          n1 --|apertar_T|--> terreo
          n1 --|apertar_2|--> n2
          n1 --|apertar_3|--> n3
      
          n2 --|apertar_S|--> subsolo
          n2 --|apertar_T|--> terreo
          n2 --|apertar_1|--> n1
          n2 --|apertar_3|--> n3
      
          n3 --|apertar_S|--> subsolo
          n3 --|apertar_T|--> terreo
          n3 --|apertar_1|--> n1
          n3 --|apertar_2|--> n2

        linkStyle 0 stroke:red,stroke-width:3px;
        linkStyle 1 stroke:red,stroke-width:3px;
        linkStyle 2 stroke:red,stroke-width:3px;
        linkStyle 3 stroke:red,stroke-width:3px;
        linkStyle 4 stroke:blue,stroke-width:3px;
        linkStyle 5 stroke:blue,stroke-width:3px;
        linkStyle 6 stroke:blue,stroke-width:3px;
        linkStyle 7 stroke:blue,stroke-width:3px;
        linkStyle 8 stroke:green,stroke-width:3px;
        linkStyle 9 stroke:green,stroke-width:3px;
        linkStyle 10 stroke:green,stroke-width:3px;
        linkStyle 11 stroke:green,stroke-width:3px;
        linkStyle 12 stroke:black,stroke-width:3px;
        linkStyle 13 stroke:black,stroke-width:3px;
        linkStyle 14 stroke:black,stroke-width:3px;
        linkStyle 15 stroke:black,stroke-width:3px;
        linkStyle 16 stroke:yellow,stroke-width:3px;
        linkStyle 17 stroke:yellow,stroke-width:3px;
        linkStyle 18 stroke:yellow,stroke-width:3px;
        linkStyle 19 stroke:yellow,stroke-width:3px;
      

  
      ```
## Autômatos Finitos Determinístico
- é um sistema de estados finitos
- nas linguagens formais é um **formalismo Reconhecedor ou Operacional**, pois vão perceber se as palavras pertencem ao dicionario da linguagem (análise lexica)
- estado é indicado por q --> no diagrama é representado por um circulo
- tem apenas um estado inicial (q0)
- pode ter mais de um estado final --> circulo pequeno dentro do circulo do estado
- função programa ou de transição : parte que contém a lógica, que faz o processamento
        - sempre inicial na parte mais esquerda da palavra e lê uma por uma sem voltar  
- dada uma palavra de entrada 🡺 autômato finito 🡺 saída (aceita ou rejeita)
- exemplos:
1)  L = {aa}
    - fita de entrada: | a| a| é aceita, se a fita de entrada fosse |a|b| não seria aceita pois na linguagem não tem b
    
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
   - L3={10, 100, 1001, 1010, 10110, 1011, 10011, ...}
    ```mermaid
        graph LR;
          q0--|1|--> q1;
          q1--|0|--> q2;
          q2--|1,0|--> q2;
    ```
4) L4 = {W  ∈ {a,b}+| |w|>=2 e tem prefixo b}
   - L4 = {bb, ba, bba, baa, bab, babb, baaa, bbbb,...} 
     ```mermaid
          graph LR;
            q0--|b|--> q1;
            q1--|a|--> q2;
            q1--|b|--> q2;
            q2--|a,b|--> q2;
     ```
