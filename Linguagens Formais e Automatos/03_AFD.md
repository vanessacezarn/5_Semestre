# Autômato Finito Determinístico - AFD
- é um sistema de estados finitos
  - um modelo matemático de sistemas com entradas e saídas discretas
  - esse sistema pode assumir um número finito e conhecido de estados
  - cada estado mantém somente as informações passadas necessárias para determinar a ação para a próxima entrada 🡺 não possui memória de trabalho
- para armazenar informações, o AFD usa o conceitos de estados
  - os estados são representados por elipses ou circulos
    - são nomeados de 0,1,2...ou A,B,C... ou q0,q1,q2,...
    - transições entre estados são representadas por arcos que os ligam e têm um sentido 
      - nas transições é indicado o evento que proporciona a mudança de estado
      - há mais de uma opção de transição entre os estados, entretanto um estado ao ler um mesmo símbolo não pode ter transição para dois estados diferentes. Em outras palavras: para qualquer par (estado atual, símbolo), existe exatamente uma transição possível.
    - possui apenas um estado inicial (possui uma seta em cima de si)
    - possui um ou mais estados finais (circulo pequeno dentro de um circulo grande ou a borda é mais expessa que dos demais estados)
- nas linguagens formais é um formalismo Reconhecedor ou Operacional, pois ele irá perceber se as palavras pertencem ao dicionário da linguagem (análise lexica)
### ➥ AFD é composta por 3 partes:
  - **fita de entrada**
    - dispositivo de entrada que contém o dado a ser processado
    - fita é finita à esquerda e infinita à direita
    - cada célula da fita armazena um símbolo pertencente a um alfabeto de entrada
    - não é possível gravar sobre a fita  🡺 somente leitura de um símbolo por vez
    - inicialmente a palavra de entrada ocupa toda fita.
  - **unidade de controle**
    - reflete o estado corrente da máquina
    - possui uma unidade de leitura (cabeça da fita) que acessa uma célula da fita de cada vez e movimenta-se exclusivamente para a direita (uma célula)
    - a unidade de leitura sempre inicia à esquerda da fita 
  - **programa ou função de transição ou função programa ($\sigma$)**
    - pode ser representada através de : diagrama, tabela, notação
    - comanda as leituras e define o estado da máquina, ou seja, é a parte que contém a lógica e que faz o processamento
    - é uma função parcial (cada elemento do domínio está relacionado com no máximo um elemento do contradomínio - estado e símbolo)
    - determina o novo estado do autômato
    - sempre inicial no símbolo mais a esquerda da palavra e lê um por um sem voltar
### ➥ Formalmente um AFD é uma 5-upla M 
- M = { $\Sigma$, Q, $\sigma$, q0, F} em que :
    -  $\Sigma$ =  alfabeto de entrada
    -  Q = conjunto dos estados possíveis do autômato (conjunto finito)
    -  $\sigma$ =  função programa ou função transição ou programa, definida: $\sigma$ = Q x $\Sigma$ 🡺 Q é uma função parcial
        - $\sigma$ pode ser representado por grafo(diagrama), tabela ou notação matemática
        - função parcial = não tem transição para todos os estados
    -  q0 = estado inicial
    -  F = conjunto de estados finais
### ➥ Parada de um AFD
- sempre para ao processar qualquer palavra
- a parada de um autômato pode ser de duas maneiras: aceitando ou rejeitando a palavra W
- condições de parada:
   - processa o último símbolo da fita e assume um estado final = **aceita**
   - processa o último símbolo da fita e assume um estado não final = **rejeita**
   - função programa indefinida para o argumento = **rejeita**

### ➥ Função Programa Estendida, Computação
- é usada para mostra formalmente a computação de um AF.
- seja um AFD  M = { $\Sigma$, Q, $\sigma$, q0, F}, a função Programa Estendida é denotada por : $\underline{\sigma} : Q x \Sigma* 🡺 Q$
  - $\sigma*$ ou $\underline{\sigma}$ representam a Função Programa Estendida
  - A função é indutivamente definida:
      - $\underline{\sigma} (q,\varepsilon)=q$
      - $\underline{\sigma} (q,aw)=\underline{\sigma}(\sigma(q,a),w)$
        - aw = palavra com pelo menos um caractere
        - a = primeiro caractere, w = restante da palavra
  - Portanto $\underline{\sigma}$ consiste na sucessiva aplicação da $\sigma$ à palavra de entrada.
  - W é aceita se no final da função programa estendida o resultado for um estado final
- exemplo: L = {W ∈ {0,1}+ | W é de tamanho ímpar e termina em 1 }
  - grafo: (q1 é estado final)
    ```mermaid
        graph LR;
          q0--|1|--> q1;
          q1--|0,1|--> q0;
          q0--|0|-->q2;
          q2 --|0,1|--> q0;
    ```
  - tabela da $\sigma$
      - | $\sigma$| 0 | 1 |
        |:---:|:---:|:---:|
        | q0 | {q2}| {q1} |
        | q1 |{q0}|{q0}|
        | q2 |{q0}|{q0}|
  - função matemática da $\sigma$
    - $\sigma$ (q0,0)= q2 |  $\sigma$ (q0,1)= q1 
    - $\sigma$ (q1,0)= q0 |  $\sigma$ (q1,1)= q0
    - $\sigma$ (q2,0)= q0 |  $\sigma$ (q2,1)= q0
  - $\underline{\sigma}$: M1 = ({0,1},{q0,q1,q2},$\sigma$,q0,{q1}) e W=101
    - $\underline{\sigma}$(q0,101) = $\underline{\sigma}$ ($\sigma$(q0,1),01)
    - $\underline{\sigma}$(q1,01) = $\underline{\sigma}$ ($\sigma$(q1,0),1)
    - $\underline{\sigma}$(q0,1) = $\underline{\sigma}$ ($\sigma$(q0,1),$\varepsilon$)
    - $\underline{\sigma}$(q1,$\varepsilon$) = q1
      - q1 é estado final, logo W foi aceita

### ➥ Exemplos de AFD 
1)  L = {aa}
    - grafo da função progrma
      ```mermaid
        graph LR;
          q0--|a|--> q1;
          q1 --|a|--> q2;
      ```
    - tabela da função programa:
      - | $\sigma$| a | 
        |:---:|:---:|
        | q0 | {q1}| 
        | q1 | {q2} |
    - notação matemática da função programa:
      - $\sigma$ (q0,a)= q1 
      - $\sigma$ (q1,a)= q2
    - exemplos de fitas de entradas:
      - |a|a| 🡺 aceita
      - |a|b| 🡺 rejeita,  pois na linguagem não tem b
    
2) L2 = {aa, ab, ba, bb}
    - grafo de $\sigma$
        ```mermaid
          graph LR;
            q0--|a|--> q1;
            q0--|b|--> q1;
            q1 --|a|--> q2;
            q1 --|b|--> q2;
        ```
    - tabela da $\sigma$
        - | $\sigma$| a | b |
          |:---:|:---:|:---:|
          | q0 | {q1}| {q1} |
          | q1 |{q2}|{q2}|
    - função matemática da $\sigma$
      - $\sigma$ (q0,a)= q1 
      - $\sigma$ (q0,b)= q1 
      - $\sigma$ (q1,a)= q2 
      - $\sigma$ (q1,b)= q2
    * se a fita de entrada for:
        * |b|a| ou |a|b| ou |a|a| ou |b|b|  🡺 aceita
        * |a|a|b| 🡺 rejeita, pois q2 não tem saída

3) L3 = {W  ∈ {0,1}+| w tem prefixo 10}
   - L3={10, 100, 1001, 1010, 10110, 1011, 10011, ...}
   - grafo da $\sigma$
      ```mermaid
          graph LR;
            q0--|1|--> q1;
            q1--|0|--> q2;
            q2--|1,0|--> q2;
      ```
    - tabela da $\sigma$
      - | $\sigma$| 0 | 1 |
        |:---:|:---:|:---:|
        | q0 | -| {q1} |
        | q1 | {q2}| -|
        | q2 |{q2}|{q2}|
    - função matemática da $\sigma$
      - $\sigma$ (q0,1)= q1 
      - $\sigma$ (q1,0)= q2
      - $\sigma$ (q2,0)= q2 
      - $\sigma$ (q2,1)= q2
4) L4 = {W  ∈ {a,b}+| |w|>=2 e tem prefixo b}
   - L4 = {bb, ba, bba, baa, bab, babb, baaa, bbbb,...} 
     ```mermaid
          graph LR;
            q0--|b|--> q1;
            q1--|a|--> q2;
            q1--|b|--> q2;
            q2--|a,b|--> q2;
     ```
5) L5 = { W ∈ { a,b,c}+ | W tem prefixo aacc e |w| = 5}
   - M5 = ({a,b,c} , {q0,q1,q2,q3,q4,q5}, $\sigma$, q0, {q5})
      ```mermaid
          graph LR;
            q0--|a|--> q1;
            q1--|a|--> q2;
            q2 --|c|--> q3;
            q3 --|c|--> q4;
            q4--|a,b,c|-->q5;
            q5--|a,b,c|-->q5;
      ```
6) L6 = { W ∈ {0,1}+ | W tem tamanho ímpar}
    - M6 = ({0,1}, {q0,q1,q2}, $\sigma$, q0, {q1})
      ```mermaid
          graph LR;
            q0--|0,1|--> q1;
            q1--|0,1|--> q2;
            q2 --|0,1|--> q1;
      ```
      - q1 é estado final
7) L7 = { W ∈ { a,b}+ | ab é uma subpalavra de W}
    - M7 = ({a,b}, {q0,q1,q2}, $\sigma$ ,q0,{q2})
      ```mermaid
          graph LR;
            q0--|a|--> q1;
            q0--|b|-->q0;
            q1--|b|--> q2;
            q1--|a|-->q1;
            q2 --|a,b|--> q2;
      ```