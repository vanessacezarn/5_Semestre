# PROCESSOS DO SISTEMA OPERACIONAL
- é um conjunto de instruções que está sendo executado
- cada processo é uma estrutura de dados
- é uma entidade ativa no sistema 
- primeiros sistemas ➜ um programa por vez
- atualmente ➜ multiprogramação = muitos programas carregados na memória executados de forma concorrente        
- processos que executam concorrentemente ➜ selecionado pela CPU a fim de tornar o computador mais produtivo

### MULTIPROGRAMAÇÃO
#### Mecanismos de interrupções
- permite que um controlador de periféricos chame a atenção do processador
- interrupção sinaliza a ocorrência de algum evento
- ...
- diagrama de tempo de uma operação E/S:
<div align="center">
  <img width="608" height="177" alt="image" src="https://github.com/user-attachments/assets/2d2aab0d-9015-4450-93fc-6648d3f07882" />
</div> 

- as interrupções possuem um tipo (0...255) definidos pelo projetistas do sistema
  - há uma relação de prioridade entre as interrupções
- em alguns momentos não podem ocorrer interrupções ➜ habilitar/desabilitar interrupções
  - evitar acesso a valores incorretos
#### Processos
- unidade de trabalho
- programa em execução
- ....
- é um conceito utilizado em SO para identificar um elemento que concorre à execuçãõ
  - um memso programa pode estar sendo executado por vários usuários, ao mesmo tempo, mas para cada usuário existe um processo
  - cada processo trabalha sobre uma área de memória privativa
- é uma sequência de instruções ➜ entidade passiva
- um processo altera seu estado à medida que executa um programa ➜ entidade ativa
##### diagrama de estados de um processo - ciclo de vida
<div align="center">
  <img width="619" height="291" alt="image" src="https://github.com/user-attachments/assets/d5d6629e-0482-4982-8520-0defde9862cd" />
</div>

- "novo" ➜ fila de novos
- pode haver vários processo na etapa "pronto"(RAM) ➜ fila de prontos ➜ processador
- "em espera" também pode haver vários processos em espera ➜ fila dos dispositivos
- em execução (CPU)
- sempre que tenham fila de processos, independente de onde ela estiver, há escalonador de processos
  
