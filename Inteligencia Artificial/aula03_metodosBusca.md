# MOTORES DE RACIOCÍNIO - Métodos de Busca
- algortimo que buscam solução de problema
    - busca de força bruta (mais processamento e mais consumo de memória) ➜ SEMPRE CHEGA NA SOLUÇÃO MELHOR
    - busca de heurística (menos processamento e menos consumo de memória) ➜ NEM SEMPRE CHEGA NA MEHOR SOLUÇÃO (depende da herítica)
- solucionar um problema com métodos de busca exige a **modelagem** de:
    - estados
    - regras de transição
    - restrições
    - visitantes (lista ou hash)
    - função objetivo (saber se o sistema atingiu a solução)

#### Problema da Jarra
* Há duas jarras, uma jarra1 com 4 litros e outra jarra2 com 3 litros, também há uma torneira que jorra água infinitamente. o problema é deixar 2 litros em alguma das jarras.
* Sua modelagem e código esta na pasta CodigosMetBusca

---

### ➤ aula 05/03
- para mudanças de estados sempre fazer 3 perguntas:
  - 1) heValido
    2) já foi visitado
    3) ehMeta
- **profundidade** = percorrer todo galho antes de voltar para o nó principal
  - nem sempre entrega a melhor solução = sempre entrega a primeira solução que encontra
  - na IA não pode usar recursão queando for profundidade
  - vai "cortando" os caminhos que não atendem as 3 perguntas da mudança de estado = logo não consome tanta memória
  - usa pilha
```
        1
  2      5      8
3  4    6  7   9  10
```
- **amplitude** = percorre por "nivel" a árvore
  - acha todas as soluções possiveis
  - a que mais consome memória
  - em geral é mais utilizada
  - usa fila
  - nos problemas estudados em sala geralmente utilizare este
```
         1
  2      3       4
5  6    7  8   9  10
```
#### Problema Travessia do Rio
- Problema do Homem, Lobo, Alface e Carneiro
    - Duas margens de rio com uma canoa. O único que rema é o homem. O objetivo é levar todos da margem esquera para margem direita.
    - Entretanto, só um passageiro com o remador (homem) é possível. E não se pode deixar sozinhos na margem um Carneiro com alface e um Carneiro com o lobo.
    -  qual é a sequencia de passos necessários para levar todos para a outra margem.
- Sua modelagem e código está na pasta CodigosMetBusca
--- 

### ➤ aula 06/03
#### Estrutura de dados - revisão
- equals()
    - é chamado quando utiliza equals, contains, indexOf  ➜ principalmente em listas
    - é preciso reescreve-lo para comparar as variaveis que não podem se repetir, se não reescrever ele vai utilizar o equals padrão
- hashCode()
    - add()
    - principalmente no hashSet().
- variavel com final na frente é para impedir que o programador mexa na matriz original , sempre vai obriga-lo a fazer um clone
---

### ➤ aula 13/03
- pesquisar sobre IA generativa
    - LLM (Large Language Models) = base de conhecimento da IA
    - transformes
- ao usar recursão dentro do codigo está sendo usado profundidade 
#### SUDOKU
- matriz 9x9 de inteiros = é formado por 9 blocos 3x3 que podem ser preenchidos com inteiros de 1 a 9.
- estado inicial = matriz com números aleatórios em posições aleatórias
    - inicia em tempo de programação
    - inicia vindo arquivo
- estado final = variável totalVazio = 0 && nenhuma restrição ferida
- regras de transição :
    - tentar inserir nº de 1 a 9
    - sempre começar pelo 1º slot vazio     
- restrições:
  1) avaliar restrições
  2) avaliar coluna
  3) avaliar box
---

### ➤ aula 14/03
- O que foi trabalhado até agora em **Métodos de busca**
    - cega = força bruta
        - dedutivo ➜ profundidade
            - pilha (recursiva S.O)
            - visitados 
        - largura/amplitude
            - fila      { árvore
            - visitados { completa
    - Heuristicos = informação = dica ➜ **Próximas aulas**
## HEURISTICA
- custo real - g(n), quanto ele consome e gasta para percorrer um caminho,
    - sempre procura seguir pelo caminho de menor custo, não que ele seja o melhor ou mais adequado (exemplo ir de sm para poa por são pedro)
- custo estimado/heurístico - h(n) ➜ alguém estimou ou através de cálculos matemáticos os custos para fazer os caminhos = dica
- nem sempre as dicas dadas geram/proporcionam o melhor caminho
- 3 tipo que serão estudados
#### subida de encosta/montanha (climb hill)
- profundidade ➜ pilha recursiva
- visitados
- custo real - g(n) 
#### Guloso
- amplitude/largura ➜ fila
- visitados
- custo estimado h(n) ➜ se preocupa com as dicas forncecidas e dentro delas escolhe a menor
    - antes de definir o proximo passo dentro da arvore sempre olha os tios do pai, se o tio tiver um custo menor abre a arvore dele tambem e verifica se o caminho tem custo menor, se não tiver volta para onde estava
### A* 
- amplitude ➜ fila
- visitados
- combinação = custo real (acumulado) + custo estimado
    - aumenta o processamento mas "vale a pena"             
---
### ➤ aula 27/03
- Trabalhando no código do Mapa da Romenia
- revisão dos métodos de busca
- para avaliar algoritmos de busca utiliza-se 4 critérios principais focados em:
    - completude: o algoritmo garante encontrar uma solução caso ela exista
    - complexidade de tempo: quanto tempo ou nós o algoritmo leva para encontar a solução
    - * pesquisar para os métodos estudados:
