## AUTÔMATO FINITO NÃO DETERMINÍSTICO (AFND ou AFN)
- a função programa de um autômato finito não-determinístico ao processar uma entrada (estado corrente e símbolo lido) tem como resultado um conjunto de novos estados
- exemplo: estado q0 ao processar o símbolo 'a' pode assumir os estados q1,q2 ou qn:
  - notação matemática: $\sigma(q0,a) = {q1,q2,q3}$ 
```mermaid
      graph TD;
        q0--|a|--> q1;
        q0--|a|-->q2;
        q0--|a|-->q3;
```
- assume um conjunto de estados alternativos, como sr houvesse uma multiplicação de unidades de controle, uma para cada alternativa, processando independentemente, sem compartilhar recursos.
  - o processamento de um caminho não influi no estado, símbolo lido e posição da cabeça da fita para os demais caminhos alternativos.
  - o processamento de um AFN M para um conjunto de estados, ao ler um símbolo, é a união dos resultados da função programa aplicada a cada estado alternativo
- mesmo que a facilidade do não-determinístico seja aparente ele não aumenta o poder computacional do autômato  
- **definição:** autômato finito não-determinístico é um 5-upla:  M = { $\sum$, Q, $\sigma$, q0, F}, em que:
  - $\sigma$ é a funçãpo programa ou função de transição. $\sigma: Qx \sum  🡺 2 ^Q$

---
#### minhas anotações
- um mesmo estado tem transição para dois estados diferentes utilizando um mesmo caractere do alfabeto
- para ele aceitar uma palavra pelo menos um dos caminhos tem que aceitar a palavra, mas pode ter caminhos que não são aceitos
- na representação da função programa o resultado é um conjunto de estados
---
