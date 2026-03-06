# Metodos de Busca
* Nesta pasta encontra-se a solução de alguns problemas estudados em sala durante as aulas sobre métodos de busca. Foi utilizado nos códigos o JAR buscaJava disponibilizado pelo professor (ele encontra-se dentro da pasta lib).
---
## Problema da Jarra
Há duas jarras, uma jarra1 com 4 litros e outra jarra2 com 3 litros, também há uma torneira que jorra água infinitamente. o problema é deixar 2 litros em alguma das jarras.
    
#### modelagem do método de busca:
1) estados
    - estado inicial : jarra1 = 0 e jarra2 = 0 
2) regras de transição
    1) encher a jarra1
    2) encher a jarra2
    3) esvaziar jarra1
    4) esvaziar jarra2
    5) despejar jarra1 em jarra2
    6) despejar jarra2 em jarra1 
3) restrições
    - não há      
4) visitantes(já foi visitado)
    - armazenar os estados que já foram visitados
5) função objetivo (foi alcançado o objetio)
    - jarra1 == 2 && jarra2 == 0 || jarra1 == 0 e jarra2 == 2 

---

## Travessia do Rio
- Problema do Homem, Lobo, Alface e Carneiro
    - Duas margens de rio com uma canoa. O único que rema é o homem. O objetivo é levar todos da margem esquera para margem direita.
    - Entretanto, só um passageiro com o remador (homem) é possível. E não se pode deixar sozinhos na margem um Carneiro com alface e um Carneiro com o lobo.
    -  qual é a sequencia de passos necessários para levar todos para a outra margem.
#### Modelagam
1) estados
    - estado inicial: H = "e", L = "e", A = "e" e C = "e"
        - sendo H = homem, L = lobo, A = alface e C = carneiro e todos do tipo char
        - se as variavéis receberem o valor "e" siginifica que está na margem esquerda do rio e se receber valor "d" é porque está na margem direita.

2) regras de transição
    1) levarNada
    2) levarLobo
    3) levarAlface
    4) levarCarneiro
3) restrições ➜ ehValido
    1) H != C && C != A ➜ Carneiro não pode ficar na mesma margem que a Alface sem o Homem
    2) H != L && L != C ➜ Lobo e o Carneiro não podem ficar na mesma margem sem o Homem
    3) H == L || H == A || H ==C ➜ para que possa ocorrer uma travessia o homem e quem será transportado tem que estarem na mesma margem 
4) visitados 
    - armazenar os estados já visitados
5) função objetivo
    -  H == 'd'&& L == 'd' && A == 'd' && C == 'd'➜ todos na margem direita do rio
