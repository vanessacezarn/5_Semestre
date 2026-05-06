# MOTORES DE RACIOCÍNIO - Métodos de Busca
- algortimo que buscam solução de problema
    - Força bruta ou cega 
        - mais processamento e mais consumo de memória ➜ sempre chega na melhor solução

    - heurística 
        - menos processamento e menos consumo de memória ➜ nem sempre chega na melhor solução (depende da heurística)
- solucionar um problema com métodos de busca exige a **modelagem** de:
    - estados
    - regras de transição
    - restrições
    - visitantes (lista ou hash)
    - função objetivo (saber se o sistema atingiu a solução)
- para mudanças de estados sempre fazer 3 perguntas:
   1) heValido?
    2) já foi visitado?
    3) ehMeta?
- racuicínios: 
    -  indutivo: específico ➜ geral global/geral/total
    -  dedutivo: geral/global/total ➜ específico/
- para avaliar algoritmos de busca utiliza-se 4 critérios principais focados em:
    - completude: o algoritmo garante encontrar uma solução caso ela exista
    - otimicidade: o algoritmo encontra a solução de menor custo entre todas as disponíveis
    - complexidade de tempo: quanto tempo ou nós o algoritmo leva para encontar a solução
    - complexidade de espaço: quanta memória é necessária para realizar a busca
---
<div align="center">

# Força bruta ou cega
</div>

### ➥ profundidade
- percorrer todo galho antes de voltar para o nó principal
- nem sempre entrega a melhor solução = sempre entrega a primeira solução que encontra
- na IA não pode usar recursão quando for profundidade
- vai "cortando" os caminhos que não atendem as 3 perguntas da mudança de estado ➜ logo não consome tanta memória
- usa pilha
```
        1
  2      5      8
3  4    6  7   9  10
```
### ➥ amplitude
- percorre por "nivel" a árvore
- acha todas as soluções possiveis
- a que mais consome memória
- **em geral é mais utilizada** ➜ nos problemas estudados em sala geralmente utiliza-se este
- usa fila
```
         1
  2      3       4
5  6    7  8   9  10
```

--- 
### Estrutura de dados - revisão
- equals()
    - é chamado quando utiliza equals, contains, indexOf  ➜ principalmente em listas
    - é preciso reescreve-lo para comparar as variaveis que não podem se repetir, se não reescrever ele vai utilizar o equals padrão
- hashCode()
    - add()
    - principalmente no hashSet().
- variavel com final na frente é para impedir que o programador mexa na matriz original , sempre vai obriga-lo a fazer um clone
- ao usar recursão dentro do codigo está sendo usado profundidade 
---
<div align="center">

# Heurística
</div>

- dica, informação ➜ nem sempre as dicas dadas geram/proporcionam o melhor caminho
- **custo real - g(n)** ➜ quanto ele consome e gasta para percorrer um caminho,
    - sempre procura seguir pelo caminho de menor custo, não que ele seja o melhor ou mais adequado (exemplo ir de sm para poa por são pedro)
- **custo estimado/heurístico - h(n)** ➜ alguém estimou ou através de cálculos matemáticos os custos para fazer os caminhos = dica

Serão estudados 3 tipos:

#### ➥ Subida de Encosta/montanha (climb hill)
- profundidade ➜ pilha recursiva
- visitados
- custo real - g(n) 
#### ➥ Guloso
- amplitude/largura ➜ fila
- visitados
- custo estimado h(n) ➜ se preocupa com as dicas forncecidas e dentro delas escolhe a menor
    - antes de definir o proximo passo dentro da árvore sempre olha os irmãos do pai, se o tio tiver um custo menor então abre a árvore dele também e verifica se o caminho tem custo menor, se não tiver volta para onde estava
### ➥ A* 
- amplitude ➜ fila
- visitados
- combinação = custo real (acumulado) + custo estimado
    - aumenta o processamento mas "vale a pena"             
---


