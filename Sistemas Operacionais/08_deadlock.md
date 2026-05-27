<div align="center">

  # DeadLock - impasse
</div>

- em um ambiente multiprogramado vários processos podem competir por um número finito de recursos
- se um processo requisita recursos e estes não estiverem disponíveis, o processo entra em estado de “espera”. Pode acontecer deste processo nunca mudar de estado, quando os recursos requisitados estão retidos por outros processos no estado de espera.
- maioria dos SO modernos não provê facilidades de prevenção de deadlock
 - no sistema há uma quantidade finita de recursos a serem usados por vários processos concorrentes ➜ os recursos são de diferentes tipos e cada um possui uma quantidade de instâncias:
   - físico ➜ impressora, fita, memória, CPU
   - lógico ➜ variáveis, estruturas, semáforos, arquivos, operações com objetos, monitores
- para um processo utilizar um recurso  
  1) pedido ➜ se não for aceito, o processo que solicitou entra em estado de espera
  2) uso
  3) liberação
  - pedido e liberação de recursos são chamadas ao sistemas:
    - request/release device, open/close file, allocate/free memory
- **um conjunto de processo está em Deadlock quando todos os processos no conjunto estão esperando por um evento ou recurso de outro processo do mesmo conjunto** 
- definição ➜ n processos estão em DeadLock quando cada um dos n estiver bloqueado à espera de um evento que somente pode ser causado por um dos n processos do conjunto


<div align="center">
  
  ## Condições necessárias para ocorrência de Deadlock
</div>

1) Exclusão Mútua
  - os processos possuem seção crítica de código ➜ a seção crítica deve ser executada com exclusão mútua
  - um processo que solicita um recurso compartilhado não poderá utilizá-lo, se este estiver em uso, e deverá esperar até o recurso ser liberado
2) Posse e Espera ➜ um processo tem a posse de um recurso e espera por outro recurso alocado a outro processo
3) Não-preempção ➜ recursos não podem ser preemptados
    - o processo somente libera recursos após o término da tarefa
4) Espera circular
  + - existe um conjunto de processos e há uma espera circular entre os processos:
    - P0 espera pelo recurso mantido por P1, que espera pelo recurso mantido por P2, que aguarda pelo recurso Pn-1 que aguarda pelo recurso P0 ➜ ciclo de espera não necessariamente é nessa ordem
  

<div align="center">
  
  ## Grafo de alocação de recursos
</div>

utilizado para descrever deadlocks

- conjunto de vértices (processos): P = {P1, P2,...,Pn}
- conjunto de recursos: R = {R1, R2,...,Rn}
- arestas:
  - pedido: P1 solicitou R1 e está esperando pelo recurso 
  - atribuição ou alocação: R1 foi alocado ao processo P1

<div align="center">
  <img width="470" height="229" alt="{108AE3AB-0560-4241-904E-75B54C6FFD8D}" src="https://github.com/user-attachments/assets/8c548399-598c-423b-a233-c77094299713" />
</div>

- se um grafo de alocação não possuir um ciclo, o sistema não entrará em deadlock
- se houver um ciclo, sistema pode ou não estar em deadlock, para estar em deadlock as 4 condições de ocorrência devem estar presentes

<div align="center">
  
  ## Métodos para tentar tratar Deadlock
</div>
  
### ➥ Prevenção
- garantir que o sistema nunca entrará em deadlock ➜ eliminar uma das 4 condições para ocorrência do deadlock
  - exclusão mútua ➜ muito dificil de remover
  - posse e espera ➜ dificil de remover
    - baixa utilização dos recursos ➜ recursos alocados e não utilizados por período longo
    - possibilidade de paralização  
  - não-preenpção ➜ escolha a ser feita no desenvolvimento
  - espera circular
    - para não ocorrer ➜ impor ordem total sobre todos os tipos de recursos e exigir que cada processo solicite o recurso em ordem ascendente de enumeração
    - desvantagem:
      - baixa utilização dos recursos
      - througput reduzido (taxa de transmissão reduzida)
      - paralização do sistema    
### ➥ Impedimento ou evitar deadlock
- exige que o SO receba informações antecipadas sobre a alocação dos recursos
  - processo fornece informações adicionais: como os recursos estão sendo solicitados
- modelo mais simples e útil de impedimento
  - cada processo declara o número máximo de recursos de cada tipo
  - conhecendo isso pode-se fazer um algoritmo de impedimento de deadlock
- o algortimo examina o estado (disponivel, alocado, para quem) de alocação de recursos para garantir que não aconteça espera circular
- estado: número de recursos alocados e disponíveis, demanda dos próximos processos
  - sistema em estado seguro ➜ se há uma sequência segura de alocação de recursos (ou seja, não há ciclo no grafo de alocação)
  - sistema em estado inseguro ➜ não necessariamente está em deadlock (mas, um estado com deadlock é um estado inseguro)

### ➥ Detecção e Recuperação
- se não é empregada a prevenção ou o impedimento de Deadlock no algoritmo, então uma situação de deadlock poderá ocorrer, o sistema pode detectá-lo e recuperá-lo ou ignorar o problema e fingir que os deadlocks nunca ocorrem (Unix e Windowns)
- detecção 
  - utiliza grafos de espera 
    - mostra a dependência entre os processos
    - as arestas do grafo são somente de processos
  - existe deadlock se houver um ciclo no grafo de espera 
  - algoritmo de procura de ciclos no grafo de espera tem complexidade O(n2), em que n é a quantidade de vértices no grafo
  - algortimos de detecão (custo elevado) devem ser chamados:
    - se os deadlocks ocorrem com frequência ➜ o algoritmo também deve ser chamado com frequência
    - quando o pedido não pode ser atendido imediatamente (pode ser um deadlock)
    - 1x/hora
    - utilização da CPU < 40%
- recuperação
  - quando detectadoo deadlock
    - deixar o operador tratar o problema manualmente
    - o sistema recupera o deadlock automaticamente
      - término do processo (interrompe a espera circular)
      - preempção de recursos
  - para recuperar deadlock, pode-se fazer a preempção sucessiva de alguns recursos e esses recursos são designados a outros processos até que o ciclo de deadlock seja quebrado, para isso 3 questões devem ser analisadas:
    - Seleção de uma vítima
      - quais recursos e processos devem ser submetidos a preempção 
      - determinar a ordem de preempção para minimizar custos (nº de recursos mantidos e quantidade de tempo que já consumiu em execução)
    - Rollback (reversão)
      - ao efetuar preempção em um recurso de um processo, esse deve ser retornado a um estado seguro (rollback total - abortar o processo e reiniciá-lo)
    - Starvation (paralisação)
      - como garantir que o processo que sofrerá preempção não será sempre o mesmo, até porque utiliza-se o menor custo? este processo poderá sofrer paralisação
      - o processo não consegue terminar sua execução
      - incluir o número de rollbacks no custo
- término do processo
  - sistema recupera todos os recursos alocados aos processos terminados
  - sistema pode:
    - abortar todos os processos em deadlock ➜ alto custo, pois descarta toda a computação até o momento
    - abortar um processo de cada vez até eliminar o ciclo de deadlock  ➜ alto custo, a cada processo abortado, o algoritmo de detecção deverá ser chamado
  - se o término for parcial é preciso determinar quais processos serão abortados ➜ geralmente, opta-se por terminar os processos de custo mínimo
  - fatores para escolha:
    - qual a prioridade do processo?
    - quanto tempo de computação já foi realizado e quanto tempo necessita para terminar 
    - quantos e que tipo de recurso foi utilizado (são de facil preempção)?
    - quantos recursos o processo ainda precisa?
    - quantos processos precisarão ser terminados?
    - o processo é interativo ou em batch?







