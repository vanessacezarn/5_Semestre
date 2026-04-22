# LINGUAGENS FORMAIS E AUTÔMATOS

### ➤ Competências da disciplina
#### ➥ unidade 1 - fundamentos das linguagens formais e autômatos
* compreender fundamentos das linguagens formais e autômatos, necessários ao reconhecimento de linguagens, de forma assertiva
#### ➥ unidade 2 - linguagens, gramáticas e expressões regulares, autômatos finitos
* aplicar os formalismos da classe das linguagens regulares na análise léxica, de forma precisa
#### ➥ unidade 3 - linguagens livres do contexto
* aplicar os formalismos da classe das linguagens livres do contexto na análise sintática, de forma precisa
#### ➥ unidade 4 - linguagens enumeráveis recursivamente, linguagens sensíveis ao contexto e introdução aos compiladores
* aplicar os formalismos das diferentes classes de linguagens, no desenvolvimento da etapa de análise nos tradutores de linguagens de programação, de forma construtiva
---

### ➤ Teoria das Linguagens Formais 
* 1936 - Allan Turing ➜ máquina de Turing (autômato) ➜máquina mais geral ➜ tudo que ela conseguir processar existe algoritmos sequenciais 
* década de 50
    * desenvolvimento de teorias relacionadas com linguagens naturais: importância para o estudo das linguagens artificiais
    * Chomsky: gramáticas formais
* principais aplicações:
    * análise léxica e sintática ➜ tradutores de linguagens de programação (compiladores, interpretador, montador (assemble))
    * protocolos de comunicação (modelos)
    * modelos de sistemas biológicos
    * procura em corpo de texto, ocorrência de palavras, frases,...
    * desenho de hardware (circuitos digitais)    
### Terminologia
* léxico ➜ relacionado ao dicionário
* sintático ➜ gramática, a forma da linguagem, formato
* semântica ➜ significado, sentido
### Formalismos 
- é uso de um conjunto de regras matemáticas e símbolos precisos para definir uma linguagem ou o comportamento de uma máquina, sem deixar margem para ambiguidades
- formalismos utilizados:
  * Formalismo Operacional ou Reconhecedor ➜ define a linguagem através de uma "máquina" teórica que aceita ou rejeita cadeia de símbolos
    * autômato = máquina abstrata
  * Formalismo Axiomático ou Gerador ➜ define a linguagem através de regras de produção
    * gramática = regras associadas ao comportamento da linguagem
  * Formalismo Denotacional ➜ define a linguagem através de padrões
    * expressão regular
--- 
### ➤ Conceitos Iniciais - notações
* Alfabetos ($\Sigma$) ➜ conjunto finitos de símbolos, ex: letras e dígitos
    * Exemplo:
      * $\Sigma_1$ = {a,b,c,...,x,y,z}
      * $\Sigma_2$ = {vazio,1}
      * $\Sigma_3$ = {a,b,c}
* Palavra ($\omega$), cadeia de caracteres ou sentença ➜ sequência finita de símbolos (do alfabeto) justapostos
  * $\varepsilon$ = representa a palavra vazia, sem símbolo
  * $\Sigma^*$ = representa todas as palavras possíveis sobre um $\Sigma$, incluindo palavras vazias
  * $\Sigma^+$ = representa todas as palavras possíveis sobre $\Sigma$ executando-se $\varepsilon$, ou seja,  $\Sigma^+ = \Sigma^* - {\varepsilon}$
* Tamanho ou comprimento ➜ de uma palavra ($\omega$) é o número de símbolos que esta palavra contém e representado por | $\omega$ |
* Prefixo ➜ qualquer sequência inicial de símbolos da palavra
* Sufixo ➜ qualquer sequÊncia final de símbolos da palavras
* Subpalavra ➜ qualquer sequência de símbolos contígua da palavra
* Linguagem Formal ➜ é um conjunto de palavras sobre um alfabeto 
* Concatenação ➜ é uma operação binária que associa a cada par de palavras uma terceira palavra formada por pela justaposição da primeira com a segunda
  * essa operação satisfaz as seguintes propiedades (considerando v,w,t palavras)
       * 1) associativa: v(wt) = (vw)t
         2) elemento neutro à esquerda e à direita:   $\varepsilon \omega = \omega = \omega \varepsilon$
  * obs: a concatenação de duas palavras de uma determinada linguagem não necessariamente resulta em uma palavra desta mesma linguagem (não é operação fechada sobre a linguagem).
* Concatenação Sucessiva ➜ é a concatenação sucessiva de uma palavra com ela mesma, $\omega^n$, é definida:
  * 1) $\omega \neq \varepsilon $
         *  $\omega^0 = \varepsilon $
         *   $\omega^n = \omega ^(n-1) \omega$, para n>0
    2) $\omega = \varepsilon $
         * $\omega^0$ é indefinida
         * $\omega^n = \varepsilon$, para n>0

---


### ➤ Sistema de Estados Finitos
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
