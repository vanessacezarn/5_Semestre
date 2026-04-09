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
jogador('A/lexandre',45).
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
--- 
#### aula 09/04 - prova de prolog da turma de ia da noite
➤ **Dominio: Sistema escolar**
1) pré-requisito: crie fatos disciplina(Nome) e pre_requisito(Anterior,Posterior). Escreva uma regra pode_cursar(Aluno,Disciplina) que verifica se o aluno já completou os requisitos necessários.

```prolog
/*disciplina(Nome)*/
disciplina("Inteligência Artificial").
disciplina("Estrutura de Dados").
disciplina("Algoritmos B").

/*pre_requisito(Anterior,Posterior)*/
pre_requisito("Algoritmo B", "Estrutura de Dados").
pre_requisito("Estrutura de Dados","Inteligência Artificial").

 /*estava implicito no comando da questão*/
ja_cursou("Freitas","Algoritmo B").
ja_cursou("Henriques","Estrutura de Dados").
/*se adiconar uma inverdadade 'destroi' tudo, Henriques não poderia ter feito ED sem algoritmoB*/


pode_cursar(Aluno,Disciplina):-
    ja_cursou(Aluno, Pre),
  	pre_requisito(Pre,Disciplina).
```
2) Aprovação: com fatos nota(Aluno, Disciplina,Valor), crie a regra aprovado (Aluno, Disciplina) (nota>=7) e reprovado (Aluno, Disciplina) (nota<7)

```prolog
/*nota(Aluno, Disciplina,Valor)*/
nota("Vanessa","Algoritmos B",8).
nota("luiza","Algoritmos B",5).

/*aprovado(Aluno,Disciplina) nota>=7*/
aprovado(Aluno,Disciplina):-
    nota(Aluno, Disciplina,Valor),
    Valor >= 7.

/*aprovado(Aluno,Disciplina) nota<7*/
reprovado(Aluno,Disciplina):-
    nota(Aluno, Disciplina,Valor),
    Valor <7.

```
➤ **Dominio: Logística e Localização**

3) conectividade de cidades: defina fatos estrada(CidadeA, CidadeB). Crie a regra pode_viajar(De,Para) que indica se há uma conexão direta.
    * bônus: discuta por que estrada(a,b) não implica automaticamente estrada(b,a) sem uma regra de simetria.
4) localização: use fatos esta_em(Objeto, Comodo) e comodo_em(Comodo, Casa). Crie a regra localizacao_geral (Objeto,Casa) para inferir onde o objeto está no nível da propiedade.

➤ **Dominio: Recomendação e Preferências**

5) cardapio: crie fatos ingrediente(Prato,Item) e vegano(Item). Escreva a regra prato_vegano(Prato) que é verdadeira apenas se todos os ingredientes forem veganos (útil para introduzir o conceito de negação ou falha)
6) streaming: com fatos filme(Nome,Genero) e usuario_gosta(Usuario,Genero), crie a regra recomendar(Filme,Usuario)

➤ **Dominio: Mundo de Blocos (clássico de IA)**

7) empilhamento: use fatos sobre(BlocoA, BlocoB) (A está em cima de B) e no_chao(BlocoB). Crie a regra abaixo(X,Y) e a regra bloco_livre(X) (se não há nada sobre ele)

➤ **Dominio: Mundo de Blocos (clássico de IA)**

8) Zoologia Básica: crie fatos sobre características (ex: tem_penas(pinguim), poe_ovos(pinguim)) e regras para classificar: ave(X) :- tem_penas(X), poe_ovos(X).
9) E-commerce: com fatos clientes(Nome, Saldo) e produto(Item,Preco), crie a regra pode_comprar(Nome,Item).
10) Torneio de jogos: com fatos venceu(JogadorA, JogadorB), crie uma regra invicto(Jogador) que verifica se ninguém venceu aquele jogador
 
---



