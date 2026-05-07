# Gramática Livre do Contexto (GLC)
- é um formalismo gerador das Linguagens Livres de Contexto
- é uma quádrupla ordenada G = (V,T,P,S), em que:
  - V = conjunto de símbolos variáveis ou não terminais ➜  convenção: sempre em letras maiúsculas
  - T = conjunto de símbolos terminais disjuntos de V  - ($\Sigma$) ➜  convenção: sempre em letras minúsculas
  - P = conjunto finito de pares, denominados regras de produção tal que a primeira componente é a palavra de (V  $\cup$  T)+ e a segunda é a palavra de (V $\cup$ T)* 
  - S = elemento de V denominado variável inicial
- **Regra de Produção**: $S ➜ \beta$
  - $S \in V$ e $\beta \in (V \cup T)^*$
### Árvore de Derivação
permite a representação da derivação de palavras de uma linguagem para determinada Gramátican Livre do Contexto.

- A Derivação inicia pela Variável Inicial da Gramática e é feita até as folhas da Árvore de Derivação possuírem apenas símbolos terminais (Σ).
