# Expressões Regulares (ER)
- é um formalismo denotacional das linguagens regulares
- também é considerado um formalismo gerador, pois por meio de ER é possível gerar as palavras de um linguagem regular
- ER é definida a partir de conjuntos básicos e operações de concatenação e união
- uma linguagem gerada por uma expressão regular é representada por L(r) ou GERA(r)
### ➥ Definição: uma ER sobre um alfabeto ($\Sigma$)
- $\varnothing$ é uma ER e denota a linguagem vazia ➜ L = {}
- $\varepsilon$ é uma ER e denota a linguagem que possui apenas palavra vazia ➜ L = { $\varepsilon$ }
- qualquer símbolo x $\in$ $\Sigma$ é uma ER e denota a linguagem ➜ L = {x}
- se 'r' e 's' são ER e denotam as lingugens R e S, então:
    - (r+s) é ER e denota a lingugem $R\cup S$➜ L = {r,s}
    - (rs) é ER e denota a lingugem RS ➜ L = {uv | u $\in$ R e v $\in$ S   }
    - (r*) é ER e denota a lingugem R* ➜ L = {$r^n$ | n >= 0 }
### ➥ Exemplo: seja $\Sigma$ = {a, b}
| Expressão Regular  | Linguagem  |
|:---:|:---:|
| aa  | L1 = {aa}  |
| ba*  | L2 = {todas as palavras que iniciam por b e possuem 0 ou mais a's na sequência}  |
| (a+b)*  | L3 = {todas as palavras sobre {a, b} }  |
| (a+b)∗aa(a+b)∗  | L4 = {w possui aa como subpalavra} |
| a∗ba∗ba∗ | L5 = {possui apenas dois b's} |
| (a+b)∗(aa+bb)  | L6 = {w | w possui aa ou bb como sufixo}  

### ➥ Classe das liguagens regulares
- a classe das ER denota exatamente a classe das Linguagens Regulares, ou seja:
    1) se r é uma ER, então GERA(r) é uma Linguagem Regular
    2) se L é uma Linguagem Regular, então existe uma ER r tal que GERA(r) = L
- uma linguagem é regular se e somente se é possível construir um AFD ou AFND ou $AF\varepsilon$ que reconheça a linguagem. Assim, construir um AF apartir de uma ER tal que ACEITA(M) = GERA(r), prova que uma ER gera uma Linguagem Regular
