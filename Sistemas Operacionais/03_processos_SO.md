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
- controlador de periféricos: conecta o periférico ao processador, traduz sinais ao dispositivo
- processador: ler, escrever dados, ler status do dispositivo, reiniciar, escrever comandos
- diagrama de tempo de uma operação E/S:
<div align="center">
  <img width="608" height="177" alt="image" src="https://github.com/user-attachments/assets/2d2aab0d-9015-4450-93fc-6648d3f07882" />
</div> 

- as interrupções possuem um tipo (0...255) definidos pelo projetistas do sistema
  - há uma relação de prioridade entre as interrupções
- em alguns momentos não podem ocorrer interrupções ➜ habilitar/desabilitar interrupções
  - evitar acesso a valores incorretos
# Processos
- unidade de trabalho
- programa em execução
- processos:
  - SO
  - usuário
- CPU multiplexada entre os processos
- um programa por si só não é um processo
  - programa ➜ sequência de instruções ➜ entidade passiva (disco)
  - processo ➜ altera seu estado à medida que executa um programa ➜ entidade ativa: Program Counter(PC) indica próxima instrução e possui um conjunto de recurso associados
- é um conceito utilizado em SO para identificar um elemento que concorre à execução
  - um mesmo programa pode estar sendo executado por vários usuários, ao mesmo tempo, mas para cada usuário existe um processo
  - cada processo trabalha sobre uma área de memória privativa
- é representado pelo :
  - espaço de endereçamento ➜ armazenamento da imagem do processo
  - estrutura internas do sistema ➜ áreas de memórias, tabelas internas
  - contexto de execução ➜ pilhas, dados

<div align="center">
  imagem
</div>

- processos são criados e destruídos
  - depende do SO
  - alguns casos:
    - um processo para cada terminal ➜ criados na inicialização e destruídos quando o sistema é desligado
    - um processo para cada sessão de trabalho 
    - criar livremente através de chamadas ao sistema
- processos do sistema (daemon)
- cpu-bound ➜ tempo de execução predominantemente definido pelo tempo dos ciclos de processador
- I/O-bound ➜ tempo de execução predominantemente definido pelas operações de I/O
### ➥ Proteção entre processos
- dois modos de operação:
  - usuário ➜ algumas instruções não podem ser executadas
  - supervisor ➜ instruções privilegiadas
- as interrupções chaveiam o processador no modo supervisor
- proteção de periféricos
- proteção de memória

#### ➥ Modelo de processo UNIX (Linux)


<div align="center">
  imagem
</div>

### ➥ Estados do processo
- novo(new), em execução(running), em espera(waiting), pronto(ready), encerrado(terminated)
- conforme um processo é executado ele muda de estado
- apenas um processo executa em qualquer processador a cada instante
- muitos processos podem estar prontos ou em espera


### ➥ Diagrama de estados de um processo - ciclo de vida
<div align="center">
  <img width="619" height="291" alt="image" src="https://github.com/user-attachments/assets/d5d6629e-0482-4982-8520-0defde9862cd" />
</div>

- "novo" ➜ fila de novos
- pode haver vários processo na etapa "pronto"(RAM) ➜ fila de prontos ➜ processador
- "em espera" também pode haver vários processos em espera ➜ fila dos dispositivos
- em execução (CPU)
- sempre que tenham fila de processos, independente de onde ela estiver, há escalonador de processos

### ➥ Bloco de controle de processos - PCB (Process Control Block)
- repositório de informações de cada processo
- cada processo é representado pelo SO por um PCB
  - estado do processo
  - contador de programa
  - regristradores do processador
  - pilha
  - seção de dados (variáveis globais)
  - seção de texto (código)
  - informações para o escalonamento
  - informações sobre o gerenciamento de memória
  - informações sobre a contabilização
  - informações sobre status de I/O
- exemplo de estrutura de PCB:
```
struct desc_proc{
char estado_atual;
int prioridade;
unsigned inicio_memoria;
unsigned tamanho_memoria;
struct arquivo arq_aberto[20];
unsigned tempo_gasto_cpu;
unsigned proc_pc;
unsigned proc_sp;
unsigned proc_acc;
unsigned proc_rx;
//Lista de descritores
struct desc_proc *prox;
struct desc_proc *livre;
struct desc_proc *espera_CPU;
struct desc_proc *usando_cpu;
}
```
- durante o ciclo de vida do processo no PCB
  - criação:
    - alocação de área de memória para código, dados e pilha do processo e estruturas do SO
    - inicialização do PCB e inserção na fila
  - execução
    - execução das instruções da área de código (há interação com o SO)
    - atualização dos estados e recursos do processo no PCB
  - término
    - liberação de recursos e estruturas de dados utilizadas

### ➥ Hierarquia de processos
- alguns SO permitem trabalhar com o conceito de grupos de processos
  - permite aplicar a mesma operação sobre todo o conjunto de processos ➜ direitos do processo
- processos podem ser criados por outros processos através de chamadas ao sistema
  - processo que faz a chamada: **processo PAI**
  - processo criado: **processo FILHO**

<div align="center">
  imagem
</div>

- P1 é o processo inicial do sistema ➜ criado durante a inicialização
- os demais processos foram criados através de chamadas ao sistema
- a hierarquia muda com o passar do tempo

### ➥ Escalonamento de processos
#### Multiprogramação
- processos em execução o tempo todo
- otimizar CPU
#### Tempo compartilhado
- alternar a CPU entre processos (frequentemente)
- transparente para usuário
#### Uniprocessador
- escalonamento
#### Filas de escalonamento
  - Fila de jobs ➜ todo processo que entra no sistema é colocado nessa fila
  - Filas de Processos Prontos ➜ processos que estão na memória e estão prontos para serem executados
  - Fila de dispositivos ou I/O (cada dispositivo tem a sua) 
    - lista de processos esperando por um determinado dispositivo
    - quando o dispositivo está ocupado, o processo é colocado na fila do dispositivo
  - Lista encadeada
    - cabeçalho ➜ ponteiro para o início e o fim da lista
    - PCB ➜ ponteiros para o próximo processo da lista
#### Diagrama de filas
<div align="center">
    <img width="351" height="256" alt="image" src="https://github.com/user-attachments/assets/a3aa3b43-95e3-4f8a-a7b8-f015cb472a6a" />
</div>

#### Escalonador (scheduler)
- há varios escalonadores: dos dispositivos, da memoria, da cpu, ...
- é responsável por selecionar o processo **(nas filas)** que será alocado na CPU
- processo migram entre as várias filas de escalonamento durante sua vida
- 3 tipos de escalonadores : se diferenciam pela frequência em que são chamados
##### escalonador de longo prazo - Long-Term
- seleciona processos e os carrega na memória para execução
- é executado com muito menos frequência - minutos
- deve selecionar processos com cuidado a fim de balancear a carga do sitema ➜ tem que ir diferenciando os tipos de processo que vão ser executados, não somente colocar na fila processos que utilizam a cpu, se não eles não iram ser executados de forma eficiente
  - seleciona uma boa combinação de processo I/O Bound ➜ muito desse deixa a fila de prontos vazia. e processos CPU Bond ➜ muitos desse deixa a fila de I/O vazia e dispositivos sem usos 
- controla o grau de multiprogramação
    - número de processos na memória
    - grau estável ➜ taxa média de criação = taxa média de saída de processos no sistema
- chamado somente quando os processos saem do sistema
##### escalonador de curto prazo- Short-Term
- é muito mais utilizado/chamado que os demais, mais chamado pela cpu
- seleciona processos a partir da fila de prontos ➜ processos que concorrem á CPU
- principal diferença entre ele e o de longo prazo é a frequência de execução
- deve selecionar processos com bastante frequência ➜ milisegundos
- deve ser bastante rápido pois pode-se perder mais de 10% do tempo somente com escalonamento
##### escalonador de médio prazo - Medium-Term
- nível intermediário de escalonamento
- usa a ideia de que às vezes pode-se ter vantangens em remover o processo da memória reduzindo o nível de multiprogramação ➜ posteriormente retorna ao ponto onde parou a execução
- útil para:
  - melhorar a combinação de processos
  - mudança de requisitos durante a execução dos processos compromete a memória disponível
- swapping


### ➥ Operações nos processos
- COMANDOS
  - fork
    - permite a criação de um segundo fluxo de execução --> um processo filho
  - exit
    - quem executa é imediatamente terminado
    - executado por uma chamada de sistema 
  - wait
  -  
