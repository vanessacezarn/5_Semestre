<div align="center">

  # DeadLock
</div>

- em um ambiente multiprogramado vários processos podem competir por um número finito de recursos
- Se um processo requisita recursos e estes não estiverem disponíveis, o processo entra em estado de “espera”. Pode acontecer deste processo nunca mudar de estado, quando os recursos requisitados estão retidos por outros processos no estado de espera.
- maioria dos SO modernos não provê facilidades de prevenção de deadlock
 - no sistema há uma quantidade finita de recursos a serem usados por vários processos concorrentes ➜ os recursos são de diferentes tipos e cada um possui uma quantidade de instâncias:
   - físico ➜ impressora, fita, memória, CPU
   - lógico ➜ variáveis, estruturas, semáforos, arquivos, operações com objetos, monitores
 
 
<div align="center">
  
  ## Condições necessárias para ocorrência de Deadlock
</div>

1) Exclusão Mútua
  - os processos possuem seção crítica de código ➜ a seção crítica deve ser executada com exclusão mútua
  - um processo que solicita um recurso compartilhado não poderá utilizá-lo, se este estiver em uso, e deverá esperar até o recurso ser liberado
2) Posse e Espera
3) Não-preempção
4) Espera circular

<div align="center">
  
  ## Grafo de alocação de recursos
</div>

utilizado para descrever deadlocks

- conjunto de vértices (processos): P = {P1, P2,...,Pn}
- conjunto de recursos: R = {R1, R2,...,Rn}
- arestas:
  - pedido:
  - atribuição ou alocação

<div align="center">
  <img width="470" height="229" alt="{108AE3AB-0560-4241-904E-75B54C6FFD8D}" src="https://github.com/user-attachments/assets/8c548399-598c-423b-a233-c77094299713" />
</div>

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
exige que o SO receba informações antecipadas sobre a alocação dos recursos

### ➥ Detecção e Recuperação
permitir que o sistema entre em deadlock: detectá-lo e recuperá-lo ou ignorar o problema e fingir que os deadlocks nunca ocorrem (Unix e Windowns)







