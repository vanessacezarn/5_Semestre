# BASE DE CONHECIMENTO
- desafio ➜ representar o conhecimento de forma que o computador consiga interpretar
## PROLOG
- linguagem no contexto do PARADIGMA LÓGICO ➜ lógica de 1ª ordem
  - dentro de uma sentaça há parâmetros ou argumentos
    - objeto: zeno, golfinho, mamífero
    - literal: "Zeno", "Golfinho", "Mamífero"
    - variável: palavra ou letra em maisculo ➜ não tem tipo e não tem instanciação
  - sentenças ou assertivas ou predicados
    - FATOS ➜ verdades incontestáveis na base
      - progenitor(zeno,jurandir)
      - disciplina(alex,ia,cc,2026)
      - eh(vaca,mamifero,terrestre)
      - eh(golfinho,mamifero,aquatico) 
    - REGRAS ➜ hipóteses ou consultas com  **:- (se e somente se)** e variáveis
  
``` prolog
progenitor(zeno,jurandir),
progenitor(zeno,abilio),
progenitor(abilio,ivete),
progenitor(jurandir,alex),
progenitor(jurandir,tina).

irmaos(A,B) :- progenitor(Pai,A),
                progenitor(Pai,B),
                A \= B.
primos(A,B) :- progenitor(PA,A),    
                progenitor(PB,B),
                irmaos(PA,PB)  
```
#### ➤  PARADIGMAS DE PROGRAMAÇÃO
linguagens: C | C# | C++ | Java | Python | SQL | JS | PHP | HasKell

programação: instruir = intruções em sequêncial | equipamentos = ações
|Imperativo|Lógico (PROLOG)|Funcional (HasKell)|
|:---:|:---:|:---:|
|o que fazer, como fazer e quando fazer|o que fazer e quando fazer| o que fazer e quando fazer por meio de FUNÇÕES|

---
#### aula 02/04
- PROLOG é uma linguagem do paradigma lógico - o programador implementa o que quer e quando quer
- usa como motor de raciocinio o método de busca por PROFUNDIDADE (recursivo e de força bruta)
- baseado em sentenças ou predicados ou assertivas ou cláusulas
- o mais comum é usar PREDICADO = relação entre os objetos de sentença
- um argumento/parâmetro pode ser: OBJETO, LITERAL, VARIÁVEL(1ºletra é maiúscula
- não possui qualquer controle de restrição
- utilizando plataforma [SWISH](https://swi-prolog.org)

``` prolog
# fato no predicado jogador(nome,idade)
jogador('Alexandre',45).
jogador('Luiz Friess',19).
jogador('Victor',19).
jogador('Maria',55).

# fato no predicado homem(nome)
homem('Alexandre').
homem('Luiz Friess').
homem('Victor').

# regra no predicado mulher(nome). :- significa se somente se | , significa &
mulher(M) :- jogador(M,_),
             not(homem(M)).

# fato no predicado joga(nome, tipo)
joga('Alexandre','RPG').
joga('Luiz Friess', 'FPS').
joga('Victor','FPS').
joga('Victor','MMO').
joga('Maria','MMO').
joga('Maria','RPG').

# fato no predicado jogo(nomeJogo, tipo, classificacaoEtaria)
jogo('The Witcher 3', 'RPG', 18).
jogo('Bioshock', 'FPS', 16).
jogo('WOW','MMO',0).

# regra no predicado recomendaRPG(nome,jogo)
recomendaRPG(Pessoa,Jogo) :- jogador(Pessoa, IdadeJogador),
                             joga(Pessoa,'RPG'),
                             jogo(Jogo,'RPG',IdadeCensura),
                             IdadeJogador >= IdadeCensura.

censura(Pessoa, jogo) :- jogador(Pessoa, IdadeJogador),
                         joga(Pessoa, Tipo),
                         jogo(Jogo, tipo, IdadeIndicativa),
                         IdadeJogador >= IdadeIndicativa.
# >= maior ou igual
```




