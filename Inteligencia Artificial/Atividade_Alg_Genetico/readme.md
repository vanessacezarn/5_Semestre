<div align="center">
  
  # Trabalho sobre Algoritmos Genético (AG)
</div>
Tendo como base os código estudados em aula sobre Algoritmo Genético, que trata da aplicação de AG em palavras.

### Modelar e implementar (na sua linguagem de preferência) o problema de roteamento.
- Imagine que existam 9 cidades (1, 2, 3, 4, 5, 6, 7, 8 e 9), representadas em um grafo/mapa imaginário.
- A rota perfeita, para este problema, é 123456789.
- O cálculo de aptidão é baseado em restrições:
  - uma cidade de número maior vier primeiro que uma cidade de número menor, deve ter restrição com nota 10;
  - se na rota aparecer mais de uma vez a mesma cidade (número); para cada par de ocorrência dar nota 20.


#### ➥ exemplo
- Uma rota [2, 8, 4, 0, 1, 5, 3, 6, 7]
  - Qual seria a nota de aptidao? 10+10+10 = 30
- Imaginem um filhos gerados a partir: pai [6, 5, 3, 2, 0, 1, 4, 7, 8] e  mãe [2, 6, 4, 8, 0, 1, 3, 7, 5]
  - filho1 [6, 5, 3, 2, 0, 1, 3, 7, 5]
   -  Qual seria a nota de aptidao?  10+10+10+10+10+20+20 = 90
