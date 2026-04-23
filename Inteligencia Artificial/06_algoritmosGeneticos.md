# Computação Evolutiva: Algoritmos Genéticos 
---
### Anotações
- 'é um gerar e testar turbinado' ➜ gera e testa vários ao mesmo tempo (uma população) 
- é uma tecnica de IA de motores de Raciocínio parecido com é um método de busca A*
  - diferença para A*, é que o A* gera e testa um por vez
- é um método de busca com heuristíca  dinâmica 
- bastante utilizado quando não se sabe o estado final e há muitas restrições
----
### Contexto
- área de Ia inspirada na teoria da Evolução Natural e na Genética
- Sub-áreas:
  - algortimos genéticos
  - estratégias de evoulação
  - programação genética
## Algoritmos Genéticos (AG) 
- modelo computacional baseados nas teorias de seleção natural e hereditariedade
- método de resolução de problemas
  - toda tarefa de busca ou otimização possui:
    - estado inicial(ais) ou final(ais)
    - regras de transição ou operadores
    - espaço de busca ➜ possibilidade de solução de um problema
    - função de avaliação ➜ função de custo
- método de busca e otimização tradicional
  - candidato (estado inicial )
  - aplicações das regras de transição + heurítica ➜ processo iterativo e heuríticas estáticas
### ➥ método de resoluçaõ de problema em AG
- busca de soluções em espaço de estados
   - estados produzidos são prováveis soluções ou indivíduos da população, denominados **cromossomos**
   - os operadores ou regras de transição de estados são **mecanismos de seleção e de reprodução** que tentam encontrar melhores soluções ou indíviduos
     - sobrevivência do mais forte ➜ melhores soluções a cada geração
     - cruzamento ou reprodução ➜ crossover ➜ criar novos a partir de 2 existentes na geração anterior (70%) os outros 30% seria a 'passagem' de elemetos por inteiro da geração anterior   
     - mutação ➜ alguma modificação 'sem explicação' de uma geração para outra 
- é possível operar sobre uma população de candidatos (espaço de estados) em paralelo
- usa a estratégia de gerar e testar
### ➥ fluxograma básico
<div align="center">
  <img width="550" height="385" alt="{138B6E9D-34AF-41AA-9635-B10B34D9FAC6}" src="https://github.com/user-attachments/assets/84626781-c298-4bd6-948c-7eb9e8245a52" />
</div>

### ➥ representação ou codificação
