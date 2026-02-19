# LINGUAGENS FORMAIS E AUTÔMATOS
* unidade 1 - fundamentos das linguagens formais e autômatos
* unidade 2 - linguagens, gramáticas e expressões regulares, autômatos finitos
* unidade 3 - linguagens livres do contexto
* unidade 4 - linguagens enumeráveis recursivamente, linguagens sensíveis ao contexto e introdução aos compiladores
## Teoria das linguagens formais 
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
## Terminologia
* léxico ➜ relacionado ao dicionário
* sintático ➜ gramática, a forma da linguagem, formato
* semântica ➜ significado, sentido
## Formalismos usados
* Formalismo Operacional ou Reconhecedor
  * autômato = máquina abstrata
* Formalismo Axiomático ou Gerador
  * gramática = regras associadas ao comportamento da linguagem
* Formalismo Denotacional
  * expressão regular
## CONCEITOS INICIAIS - notações
* Alfabetos ($\sum$) ➜ conjunto finitos de símbolos, ex: letras e dígitos
    * Exemplo:
      * $\sum_1$ = {a,b,c,...,x,y,z}
      * $\sum_2$ = {vazio,1}
      * $\sum_3$ = {a,b,c}
* Palavra ($\omega$), cadeia de caracteres ou sentença ➜ sequência finita de símbolos (do alfabeto) justapostos
  * $\varepsilon$ = representa a palavra vazia, sem símbolo
  * $\sum^*$ = representa todas as palavras possíveis sobre um $\sum$, incluindo palavras vazias
  * $\sum^+$ = representa todas as palavras possíveis sobre $\sum$ executando-se $\varepsilon$, ou seja,  $\sum^+ = \sum^* - {\varepsilon}$
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
