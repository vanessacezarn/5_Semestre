# Gramática Livre do Contexto (GLC)
- é um formalismo gerador das Linguagens Livres de Contexto
- é uma quádrupla ordenada G = (V,T,P,S), em que:
  - V = conjunto de símbolos variáveis ou não terminais ➜  convenção: sempre em letras maiúsculas
  - T = conjunto de símbolos terminais disjuntos de V  - ($\Sigma$) ➜  convenção: sempre em letras minúsculas
  - P = conjunto finito de pares, denominados regras de produção tal que a primeira componente é a palavra de (V  $\cup$  T)+ e a segunda é a palavra de (V $\cup$ T)* 
  - S = elemento de V denominado variável inicial
- **Regra de Produção**: $S ➜ \beta$
  - $S \in V$ e $\beta \in (V \cup T)^*$
- exemplo de GLC que gera as palavras de L = { $a^n$ $b^n$ | n >= 1
  - G =({A}, {a,b}, P, A) em que P = {A ➜aAb | ab} 
### Árvore de Derivação
permite a representação da derivação de palavras de uma linguagem para determinada Gramática Livre do Contexto.

- A Derivação inicia pela Variável Inicial da Gramática e é feita até as folhas da Árvore de Derivação possuírem apenas símbolos terminais (Σ).
- exemplo de árvore de derivação: palavra aaaabbbb e a gramática do exemplo acima
<div align ="center">
  <img width="103" height="195" alt="image" src="https://github.com/user-attachments/assets/5bf3ed1a-296d-4496-9df4-96485d2ef482" />

</div>

  - nas folhas da árvore está a palavra derivada

### Gramática Ambígua
- uma GLC é ambígua, se existe uma palavra que possua duas ou mais árvores de derivação
