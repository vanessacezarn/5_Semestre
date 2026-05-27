# Caso de Uso
- técnica para fazer levantamento de requisitos
    - requisito ➜ como o usuário gostaria de utilizar o sistema
- passos necessários para realizar ou executar um tarefa
    - passo a passo para usar a funcionalidade ➜ indica o que fazer e que páginas devem ser redirecionadas ➜ pode ser uma lista ou texto corrido
---

## Diagrama de Caso de Uso
- todos os requisitos funcionais do sistema e quem interage com ele 
- não representa o fluxo do sistema
- elementos do diagrama:
    - ator
        - quem deverá executar a funcionalidade
    - caso de uso   
        - ação ➜  o que a funcionalidade faz
        - no máximo 3 palavra (tem que ter verbo)
    - include
        - ação obrigatória
    - extends
        - ação opcional
    - comunicação 'linha preenchida'
        - ator interage com a funcionalidade
    - herança
---

## Descritivo de caso de uso
documentação textual ➜ deve ter descritivo para cada caso de uso
- sumário ➜  descrição da funcionalidade
- ator ➜ quem está ligado a funcionalidade
- pré-condições ➜ o que é necessário para realizar a funcionalidade
    - condições muito obvias, como abrir sistema, não são necessárias
- pós-condições ➜  o que espera-se que aconteça 
    - pode ser uma condição esperada, como atualizar banco de dados, ou um 'caminho' para outro caso de uso (utilização do < include>)
- base sequence ➜ descrição textual ou lista da menor quantidade de passos para realizar a funcionalidade com sucesso
- branch sequence ➜  sequência alternativa para a execução da funcionalidade ➜ apesar de algum 'problema' o usuário ainda consegue realizar a funcionalidade com sucesso
- exception sequence ➜ a funcionalidade não consegue ser executada
    - exemplo na funcionalidade editar o usuário tentar realizar uma edição mas não tem permissão para isso 
- sub use-case ➜ se tiver < include> indica para qual próximo caso de uso ir após concluir esse caso de uso
- note ➜  regra de negócios ou anotações que julgar importante 