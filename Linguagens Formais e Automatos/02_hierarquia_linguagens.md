# Hierarquia de classes de linguagens ou de chomsky
<div align="center">
  <img width="540" height="257" alt="{A056F914-5778-4199-9D3E-C3E1677AA0BE}" src="https://github.com/user-attachments/assets/c0d3b8f6-176f-40de-b558-5db38dbb1861" />  
</div>

## ➢ Linguagens regulares ou tipo 3
- contemplam a classe das linguagens mais simples e são abordadas por meio de 3 formalismo:
    - operacional ou reconhecedor  ➜ autômato finito (determínistico, não-deterministico, com movimento vazio)
    - axiomático ou gerador ➜ gramática regular
    - denotacional ➜ expressão regular
- “Uma das principais características das
Linguagens Regulares é o fato de serem
representadas por formalismos de pouca
complexidade, grande eficiência e fácil
implementação. Entretanto, por ser uma classe
relativamente simples, é restrita e limitada...” (Menezes,2000, pág60)
- análise léxica
### ➥ propiedades da linguagem regular :
#### 1) Como determinar se uma linguagem é regular
- é suficiente representá-la usando um dos formalismos estudados: autômato finito | expressão regular | grámatica regular
- para mostrar que uma linguagem **não** é regular a prova é feita para cada caso usando o Lema do Bombeamento
##### Lema do Bombeamento
- se uma linguagem é regular, então é aceita por um AFD, o qual possui um número finito de estados
- se o AFD reconhece uma entrada W com tamanho maior que número de estado que ele possui, em algum momento, há um ciclo na função programa do AFD
- assim, W pode ser dividida em 3 subpalavra W=uvz tal que |uv|<n e |v| >1. Portanto i>=0, $uv^iz$ é palavra da linguagem
- então, se L é uma linguagem regular e supondo que n é a quantidade de estados em que um AFD e W a palavra de entrada:
  - |W| >= n, W = uvz em que:
    - |uv| <=n e |v|>=1 ➜ para todo i>=0 $uv^iz$ é palavra de L
#### 2) Como verificar se um Linguagem Regular é finita, infinita ou vazia
- se L é uma Linguagem Regular aceita por AF, M = ($\Sigma, Q,\sigma, q0,F$) com n estados, então L é:
   - vazia ➜ se, e somente se, M não aceita qualquer palavra w tal que |w| < n
   - finita ➜ se, e somente se, M não aceita uma palavra w tal que n <= |w| <2n
   - infintia ➜ se, e somente se, M aceita uma palavra w tal que n <= |w| <2n

#### 3) Como verificar se duas linguagens são iguais
- duas linguagens regulares são iguais se os formalismos que as reconhecem são equivalentes


---
## ➢ Linguagens Livre de Contexto ou tipo 2
- universo mais amplo do que o universo da Linguagem Regular: trata questões como parênteses balanceados e construções bloco estruturadas
- algoritmo reconhecedores e geradores que implementam as Linguagens Livres do Contexto são simples e eficientes
- analisadores sintáticos, tradutores, compiladores, processadores de texto são implementadas com o uso dos formalismos das Linguagens Livre do Contexto
- possui dois formalismos
  - Autômato com Pilha
  - Grámatica Livre de Contexto
