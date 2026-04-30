# Autômato com Pilha (AP)
- é um formalismo reconhecedor aplicado às Linguagens Livre do Contexto
- utiliza memória auxiliar ➜ memória do tipo pilha
- é uma autômato não determinístico
- **PILHA**
  - é infinita e independente da fita de entrada
  - sentido de crescimento da pilha ➜ de baixo para cima
  - topo da pilha é variável e define a posição do último símbolo gravado na pilha
  - base da pilha é fixa
  - último símbolo gravado na pilha é o primeiro a ser lido 
### ➥ um autômato com pilha é uma máquina composta por: fita de entrada, pilha e unidade de controle
1) Fita de Entrada

2) Pilha

3) Unidade de Controle

### ➥ Definição 

### ➥ Função Programa 
representada por um grafo finito:
<div align="center">
  <img width="608" height="272" alt="{2A380770-93EA-4487-A4EE-380A0FF1A235}" src="https://github.com/user-attachments/assets/c6202dd9-e98e-4151-a6e8-71112136a4e2" />
</div>

### ➥ Critério de Parada do Autômato com Pilha
há duas abordagens que podem ser utilizadas como critério
1) a pilha está vazia e o autômato aceita a palavra quando chegar ao estado final ($q_f$)
2) a pilha possui um valor especial (símbolo inicial) e não há estado final no autômato. A palavra é aceita qunado a pilha não possuir o símbolo inicial

**Nas aulas será adotada a 1º abordagem como critério de parada do AP**

- o processamento de um AP consiste na sucessiva aplicação da função programa para cada símbolo da palavra de entrada (da esquerda para direita) até ocorre a parada
- as palavras podem pertencer a um dos três conjuntos:
  - **ACEITA(M) ou L(M)** ➜ palavras de $\Sigma^*$ aceitas ➜ um dos caminhos do AP assume $q_f $
  - **REJEITA(M)** ➜ palavras de $\Sigma^*$ rejeitadas ➜ todos os caminhos do AP rejeitam a palavra
