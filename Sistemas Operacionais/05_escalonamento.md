# ESCALONAMENTO
- é a base para SO Multiprogramados
- escalonamento de: processos e threads (nível do Kernel)
- é função fundamental dos SO
  - quase todos os recursos são escalonados antes do uso
  - CPU é o principal recurso ➜ ponto central para o projeto de SO
- CPU sem trabalho útil ➜ tempo perdido (ociosidade)
- processos passam para o Estado 'em espera', a CPU pode ocupar-se com outros processamento
- multiprogramação
  - procura utilizar o tempo de forma produtiva
  - vários processos na memória para executar   
---
### Ciclos de CPU/IO
- a execução de um processo alterna entre:
  - ciclos de CPU
  - ciclos de I/O
- processo limitado por I/O
  - possui muitos ciclos de surtos curto de CPU (processamentos curtos)   
- processo limitado por CPU
  - ciclos de surtos longos de CPU (processamentos longos - 'sensação de travamento')    
-  essa distribuição deve ser observada para escolha do algoritmo de escalonamento
---
### Escalonador de CPU
- executado pelo Escalonador de Curto Prazo
- escolhe um processo na **fila de processos prontos**
- objetivos
  - aumentar a produção do sistema (througput)
  - diminuir o tempo de resposta aos usuários
  - manter o processador ocupado o máximo possível
  - diminuir o tempo médio de espera na fila do processador (turnaroundtime)
- uma fila de escalonamento não necessariamente é implementada como FIFO, ela pode ser:
  - fila de prioridade
  - lista encadeada desordenada
  - árvore
- situações que geram escolha de um processo
<div align="center">
  <img width="587" height="236" alt="image" src="https://github.com/user-attachments/assets/e69f66ab-b101-4878-8141-fdf07f6b6dad" />

</div>

---
### Escalonamento
#### Preemptivo
- as interrupções estão habilitadas ➜ a execução pode ser interrompida
- há custo associado à coordenação do acesso aos dados compartilhados (parar e quando voltar ter que ler novamente)
- influencia no projeto do kernel do SO
  - chamada ao sistema: o kernel pode estar ocupado com outro processo
  - podem gerar mudanças em dados compartilhados
  - é necessária a conclusão de uma chamada ao sistema ou operação I/O antes de fazer a troca de contexto
- alguns SO são implementados de forma a esperar a conclusão de uma chamada ao sistema ou de um bloco de operação de I/O antes de ser efetuada a troca de contexto:
  - simplicidade do kernel
  - versões do Unix
  - não eficiente para sistemas de tempo real
    - sistema de tempo real ➜ sistema responde em um tempo máximo pré-definido
- há possibilidade de habilitar/desabilitar as interrupções a fim de proteger uma seção de código
#### Não-preemptivo ou Cooperativo
- o processo, após ter a CPU alocada, mantém o uso até liberá-la
- término da execução
- passagem para o estado Em espera
- não é necessário o temporizador de hardware   
---
### Dispatcher = Executor
- módulo que dá o controle da CPU ao processo escalonado
- faz:
  - passagem para o modo usuário/supervisor
  - troca de contexto:
    - salva no descritor de processo ou na pilha do processo
    - ao ser restaurado, o Program Counter (PC) indica o ponto de continuação da execução
    - mudança para posição adequada no programa do usuário conforme o Program Counter (PC)
---
### Critérios de escalonamento
- são critérios utilizados para comparação de algoritmos/políticas de escalonamento
- o escalonamento procura maximizar os seguintes critérios
   - 
- escalonamento procura minimizar os seguintes critérios:
  - tempo de retorno: tempo entre a submissão e a conclusão do processo, envolve o tempo na fila de prontos, em execução, usando  dispositivos
  - tempo de espera
  - tempo de resposta
---
### Políticas de Escalonamento
---
### Algoritmos de escalonamento
#### First-Come, First-Served (FCFS) ou First-In, First-Out (FIFO)
- é o algoritmo mais simples de implementar
  - processo que solicita a CPU primeiro ➜ recebe primeiro, ou seja, conforme os processos vão chegando são inseridos no fim da fila de prontos
- é implementado por uma FIFO: um processo entra na fila de processos prontos e seu PCB é ligado ao final da fila
- o processo utiliza CPU até o término do processamento, ou realize uma chamada ao sistema ➜ quando a CPU é liberada, ela é alocada ao processo que está no início da fila
- o processo entra em execução é removido da fila de prontos
- geralmente, apresenta tempo de espera longo ➜ pois não favorece os processos I/O bound

<div align="center">
  <img width="459" height="213" alt="image" src="https://github.com/user-attachments/assets/93c58d17-2aa6-4fdb-939d-3191fe0662fa" />
</div>

- situação dinâmica
  - um processo limitado pela CPU: obtém e detém a CPU

#### Shortest Job First - SJF
- para cada processo é associado a duração de seu próximo ciclo de surto de CPU
- quando a CPU está disponível, o processo a ser escalonado é o que tem surto de menor duração
  - se houver empate usa-se o escalonamento FCFS
- é um algoritmo ótimo
  - tempo de espera médio é mínimo
<div align="center">
  <img width="503" height="294" alt="image" src="https://github.com/user-attachments/assets/e040250c-68d4-4903-8abe-22106c05b524" />
</div>

- problema:
  - para o escalonamento de CPU não existe como saber a duração do próximo ciclo de surto de CPU
  - em sistemas batch, o usuário pode especificar esse tempo quando submete o job
  - pode-se fazer uma previsão: espera-se que o próximo ciclo de surto de CPU seja semelhante em duração aos anteriores

#### Escalonamento por prioridade
- SJF é um caso de escalonamento por prioridade
  - prioridade é dada aos processos de menores ciclos de surtos de CPU
- na política de escalonamento por Prioridade, uma prioridade é associada a cada processo e a CPU é alocada ao processo de mais alta prioridade
  - se houver empate, o escalonamento FCFS é utilizado  
- prioridades são definidas em faixas de valores: 0...100 | 0...255
- é pré-definido se a prioridade mais alta é determinada pelo maior ou menor número
  - consideramos o menor número como sendo a prioridade mais alta   
- podem ser de dois tipos:
  - interna: representam alguma quantidade mensurável para calcular a prioridade do processo (tempo, memória, arquivos abertos, razão entre surtos I/O  e CPU)   
  - externa: definida por critérios externos ao SO (importância do proceso, tipo, quantidade paga pelo uso no computador, departamento)
<div align="center">
   <img width="530" height="258" alt="image" src="https://github.com/user-attachments/assets/016f27d9-a186-45a9-bc0f-c586fc32ef8b" />
</div>

- pode ser não-preemtivo ou preemtivo
  - exemplo: um processo chegou no sistema durante a execução de outro e o processo que chegou tem prioridade mais alta
    - não-preemptivo: o processo é colocado no início da fila, pois tem prioridade mais alta
    - preemtivo: o processo em execução é interrompida e a CPU é alocada ao novo processo
- problema: bloqueio por tempo indefinido ou starvation ou postergação indefinida
  - processos de baixa prioridade podem ficar esperando pela CPU indefinidamente 
- solução: técnica de envelhicimento (conhecida como aging)
  - consiste em aumentar gradativamente a prioridade dos processos que estão na fila de Prontos durante muito tempo, para favorecer sua execução 

#### Escalonamento Round – Robin (RR) ou Revezamento Circular ou Fatia de Tempo
- adequado para sistemas de tempo compartilhado
- é o escalonamento FCFS acrescido da preempção para alternar entre os processos
- o sistema define um quantum de tempo(fatia): 10, 100ms
- o processador percorre a Fila de Prontos, alocando os processos por um intervalo de tempo de até um quantum
- é mantido por FIFO: novos processos são adicionados ao final da fila
- escalonar ➜ seleciona o primeiro processo da fila ➜ aciona um temporizador para interromper o processamento depois de um quantum ➜ submete o processo à CPU  
  - enquanto esse ciclo ocorre podem ocorrer duas situações:
    - Surto de CPU de menos de um quantum
      - o própio processo libera CPU
      - o próximo processo é escalonado
    - Surto de CPU excede um quantum
      - temporizador esgotará o tempo de execuçaõ do processo atual
      - acontece interrupção do SO
      - há troca de contexto dos processos
      - processo interrompido vai para o final da fila de prontos
      - o próximo processo é escalonado
<div align="center">
  <img width="688" height="323" alt="image" src="https://github.com/user-attachments/assets/a00f6327-9b42-4c52-bcb5-93a62d87b963" />
</div> 

- Algoritmo Round-Robin é preemptivo
  - se houver n processos na Fila de Prontos e q quantum
    - cada processo terá 1/n do tempo da CPU em lotes de no máximo q unidades de tempo
    - cada processo deve esperar no máximo (n-1) q unidades de tempo até o próximo quantum
- desempenho depende do tamanho do quantum
  - quantum muito grande ➜ semelhante ao FCFS
  - quantum muito pequeno ➜ compartilhamento de processador ➜ como se cada um dos n processos tivesse seu própio processador executando a 1/n da velocidade real do processador(execução com travamento)
- tempo de retorno também depende do tamanho do quantum
- 80% dos surtos de CPU < quantum
#### Escalonamento por Múltiplas Filas
- ...
- 
#### Escalonamento por Múltiplas Filas com realimentação
- no caso anterior, os processos não se movem entre as filas. Apesar de apresentar um baixo custo de escalonamento, não é um processo flexível.
- nesse escalonamento:
  - processo se move entre as filas
  - processos são separados por diferentes ciclos de surtos de CPU
- se um processo utilizar surto de CPU excessivo, é movido para uma fila de menor prioridade
- logo, os processos limitados por I/O estão nas filas de prioridade mais alta
- possui técnica de envelhecimento: processo que espera demais na fila de baixa prioridade passa para uma fila de maior prioridade
<div align="center">
  <img width="559" height="184" alt="image" src="https://github.com/user-attachments/assets/e5683bdb-d4fb-4294-991d-4fbca7dd13a0" />

</div> 


