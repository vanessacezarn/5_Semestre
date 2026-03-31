### Linguagens Regulares
- formalismo reconhecedor ou operacional: AFD, AFND, AF $\varepsilon$
- Formalismo denotacional: ER
- Formalismo gerador ou axiomático: GR
---
# GRAMÁTICA REGULAR
- é um formalismo gerador ou formalismo axiomático das Linguagens Regulares
- é uma quádrupla ordenada G = (V,T,P,S), em que:
  - V = conjunto de símbolos variáveis ou não terminais ➜  convenção: sempre em letras maiúsculas
  - T = conjunto de símbolos terminais disjuntos de V  - ($\sum$) ➜  convenção: sempre em letras minúsculas
  - P = conjunto finito de pares, denominados regras de produção tal que a primeira componente é a palavra de (V  $\cup$  T)+ e a segunda é a palavra de (V $\cup$ T)* 
  - S = elemento de V denominado variável inicial
- é um formalismo de geração pois permite gerar todas as palavras da linguagem que representa
- exemplo: A ➜ ab => derivação de palavras: A deriva ab
