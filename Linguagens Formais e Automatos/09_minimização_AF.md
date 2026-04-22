# Minimização de AF
- consiste em encontrar o AF equivalente com o menor número possível de estados ➜ autômato mínimo (ele é único)
- pré-requisitos para aplicar o algoritmo de minimização
    1) O AF deve ser determinístico: caso não seja deve ser transformado em AFD
    2) O AF não deve conter estados inacessíveis (estados que não podem ser alcançados a partir de q0)
    3) A função programa do AF deve ser total (para cada estado do AF, devem existir transições com todos os símbolos do alfabeto). Caso não seja:
         1) inserir um estado 'd' não final
         2) criar as transições com símbolos faltantes, tendo como destino o estado 'd'
         3) criar um ciclo em 'd' com os símbolos do alfabeto     
- irá procurar estados equivalentes no AF ➜ a procura é por exclusão
- os estados equivalentes serão unificados, ao término do processo de minimização

### Passos do algoritmo de minimização
**1) construção da tabela**: construir uma tabela, relacionado os estados distintos, sendo que cada par (não ordenado) de estados ocorre somente uma vez.
    - exemplo:
<div align="center">
  <img width="293" height="274" alt="{54AFE3EE-4390-487C-B089-28F44437995F}" src="https://github.com/user-attachments/assets/425582ce-5387-4dec-9fe6-5c8b1b4951fa" />
</div>

**2) marcação dos estados trivialmente não equivalentes**: marcar todos os pares do tipo {estado final, estado não final), pois obviamente, estados finais não são equivalentes a não finais

**3) marcação dos estados não equivalentes**, para cada par {q_u,q_v} não marcado e para cada símbolo $a \in \Sigma$, suponha que: $\sigma(q_u,a) = pu$ e $\sigma(q_v,a)=pv$, assim:
     1) se $p_u$ = $p_v$, então $q_u$ é equivalente a $q_v$ para o símbolo 'a' e não deve ser marcado
     2) se $p_u$ != $p_v$, e o par {$p_u, p_v$} não está marcado, então {$q_u, q_v$) é incluído em uma lista a partir de {$p_u, p_v$} para posterior análise
     3) se $p_u$ != $p_v$, e o par {$p_u, p_v$} está marcado, então:
        1) {$q_u, q_v$) não é equivalente e deve ser marcado
        2) se {$q_u, q_v$) encabeça uma lista de pares, então marcar todos os pares da lista (e, recursivamente, se algum par da lista encabeça outra lista)

**4) unificação do estados equivalentes** ➜ os estados dos pares não marcados são equivalentes e podem ser unificados como segue:
   1) a equivalência de estados é transitiva
   2) pares de estados não finais equivalentes podem ser unificados como um único estado não final
   3) pares de estados finais equivalentes podem ser unificados como um único estado final
   4) se algum dos estados equivalentes é inicial, então o correspondente estado unificado é inicial
   5) todas as transições com origem (respectivamente, com destino) es um estado equivalente são preservadas, mas passam a ter origem (respectivamente, destino) no correspondente estado unificado

**5) exclusão dos estados inúteis**: os estados chamados inúteis devem ser excluídos, um estado 'q' é dito um estado inútil se é não final e a partir de 'q' não é possível atingir um estado final. Deve-se observar que o estado d (se incluido) sempre é inútil. Todas as transições com origem ou destino em um estado inútil são excluídas.
