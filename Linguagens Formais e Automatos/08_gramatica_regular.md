
# Gramática Regular
- é um formalismo gerador ou axiomático das Linguagens Regulares
   - pois permite gerar todas as palavras da linguagem que representa
- é uma quádrupla ordenada G = (V,T,P,S), em que:
  - V = conjunto de símbolos variáveis ou não terminais ➜  convenção: sempre em letras maiúsculas
  - T = conjunto de símbolos terminais disjuntos de V  - ($\Sigma$) ➜  convenção: sempre em letras minúsculas
  - P = conjunto finito de pares, denominados regras de produção tal que a primeira componente é a palavra de (V  $\cup$  T)+ e a segunda é a palavra de (V $\cup$ T)* 
  - S = elemento de V denominado variável inicial

- uma regra de produção ($\alpha$ , $\beta$) é representada por $\alpha$ ➜ $\beta$ (lê-se $\alpha$ produz $\beta$) e definem as condições de geração das palavras da linguagem
- $\alpha ➜ \beta1, \alpha ➜ \beta2, \alpha ➜ \beta3$ pode ser abreviada como $\alpha ➜ \beta1 | \beta2 | \beta3$
- a aplicação de uma regra de produção é denominada **derivação** de uma palavra
- a aplicação sucessiva de regras de produção permite derivar as palavras da linguagem representada pela gramática
- exemplo: P = {A ➜ ab} => derivação de palavras: A deriva ab
  - G = ({A}, {a,b}, P, A)
- é qualquer grámatica linear
- a classe das gramáticas regulares denota a classe das linguagens regulares
---
### ➥ Derivação
- seja G = (V,T,P,S) uma gramática, uma derivação é um par da relação denotada por => com domíniio (V $\cup$ T)+ e contradomínio (V $\cup$ T)*
   - um par ($\alpha$ , $\beta$) é representado de forma infixada por $\alpha$ => $\beta$
- a relação é definida indutivamente:
  - para toda produção na forma S ➜ $\beta$, tem-se que S => $\beta$
  - para todo par S => $\beta$, em que $\beta$ = $\beta_u \beta_t \beta_w$, se $\beta_t ➜ \beta_v$ então $\beta => \beta_u \beta_v \beta_w$
- uma derivação é a substituição de uma subpalavra de acordo com uma regra de produção da gramática.
---
### ➥ Gramáticas lineares
- nas regras de produção das gramáticas lineares, o lado direito é constituído por, no máximo, uma variável
- há 4 formalismos equivalente (seja G = ({A,B}, T, P, S) uma gramática e w uma palavra de T*), então G:
1) **gramática linear à direita (GLD)**
   - se todas as regras de produção são da forma: A ➜ wB ou A ➜ w
2) **gramática linear à esquerda (GLE)**
   - se todas as regras de produção são da forma: A ➜ Bw ou A ➜ w
3) **gramática linear unitária à direita (GLUD)**
   - se é uma gramática linear à direita e |w| <=1
4) **gramática linear unitária à esquerda (GLUE)**
   - se é uma gramática linear à esquerda e |w| <=1
- a linguagem gerada por uma gramática G é denotada por L(G) ou GERA(G)
