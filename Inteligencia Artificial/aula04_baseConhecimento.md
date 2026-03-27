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
    - REGRAS ➜ hipóteses ou consultas com  :- (se e somente se) e variáveis
  
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


