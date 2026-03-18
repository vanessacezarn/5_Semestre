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
  - desvia a execução da posição atual para uma outra rotina
  - **tratador de interrupção** ➜ realiza as ações necessárias em função da ocorrência da interrupção ➜ quando termina volta à rotina interrompida.
  - pode ser ativada por hardware ou software
- alguns processadores salvam automaticamente os registradores quando ocorre uma interrupção; outros salvam apenas alguns e a rotina de interrupção encarrega-se de salvar os demais
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

### Escalonamento de processos
- Fila de jobs
- Filas de Processos Prontos
- Fila de dispositivos ou I/O
- Lista encadeada
#### Diagrama de processos
<div align="center">
    <img width="701" height="506" alt="image" src="https://github.com/user-attachments/assets/a3aa3b43-95e3-4f8a-a7b8-f015cb472a6a" />
</div>

#### Escalonador (scheduler)
- há varios escalonadores: dos dispositivos, da memoria, da cpu, ...
- é responsável por selecionar o processo **(nas filas)** que será alocado na CPU.
- processo migram entre as várias filas de escalonamento durante sua vida
- 3 tipos de escalonadores : se diferenciam pela frequência em que são chamados
  - de longo prazo
      - seleciona processos e os carrega na memória para execução
      - é executado com muito menos frequência - minutos
      - deve selecionar processos com cuidado a fim de balancear a carga do sitema ➜ tem que ir diferenciando os tipos de processo que vão ser executados, não somente colocar na fila processos que utilizam a cpu, se não eles não iram ser executados de forma eficiente
        - seleciona uma boa combinação de processo I/O Bound ➜ muito desse deixa a fila de prontos vazia. e processos CPU Bond ➜ muitos desse deixa a fila de I/O vazia e dispositivos sem usos 
      - controla o grau de multiprogramação
          - número de processos na memória
          - grau estável ➜ taxa média de criação = taxa média de saída de processos no sistema
      - chamado somente quando os processos saem do sistema
  - de curto prazo é muito mais utilizado/chamado que os demais, mais chamado pela cpu
  - de médio prazo
      - nível intermediário de escalonamento
      - swapping

### Descritor de processos ou PCB (Process Control Block)
- estrutura de dados que vai para a fila
<div align="center">
  <img width="403" height="202" alt="image" src="https://github.com/user-attachments/assets/80ed206f-0231-4b5b-9540-471bf1afcec3" />
</div>

- cada processo é representado pelo SO por um PCB
  - estado do processo
  - contador de programa
  - ... 

### OPERAÇÕES NOS PROCESSOS
- COMANDOS
  - fork
    - permite a criação de um segundo fluxo de execução --> um processo filho
  - exit
    - quem executa é imediatamente terminado
    - executado por uma chamada de sistema 
  - wait
  -  
