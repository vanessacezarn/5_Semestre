### Revisão 
- IA ➜ metodologia e técnica/método para projeção e construção de **sistemas com compartamentos inteligentes**
    - base de conhecimento (PROLOG; SMA ; RNA)
        - estruturada = banco de dados
        - não estrurada  fatos, regras, experiência
    -  motores de raciocínio (Métodos de busca ; Sistemas Multi Agentes)
        - dedução ou indução
          - profundidade e largura (força bruta)
          - subida de encosta, guloso, A*, Algoritmos Genéricos (heurísticas (dica))
    - aprendizado de máquina ou reconhecimento de padrão por amostra (redes neurais articiais)
        - repetição e volume de amostras
- tipos de problemas adequado para IA
    - diagnóstico ➜ reconhecimento de padrões (substituir o especialista)
    - 'empacotamento' ➜ descobrir o estado final e/ou os passos até o estado final
--- 
# MOTORES DE RACIOCÍNIO - métodos de busca
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
### aula 05/03
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
### aula 06/03
#### Estrutura de dados - revisão
- equals()
    - é chamado quando utiliza equals, contains, indexOf  ➜ principalmente em listas
    - é preciso reescreve-lo para comparar as variaveis que não podem se repetir, se não reescrever ele vai utilizar o equals padrão
- hashCode()
    - add()
    - principalmente no hashSet().
- variavel com final na frente é para impedir que o programador mexa na matriz original , sempre vai obriga-lo a fazer um clone
---
### aula 07/03
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
