<div align="center">

  # Memória Virtual </div>

- perite a execução de programas que não são carregados completamente na memória física
- exemplo:
  - programa com funções raramente utilizadas
  - rotinas de tratamento de exceções ou acessos a arquivos
- tanto a paginação quanto a segmentação podem ser estendidas para o uso de memória virtual
- foco: paginação por demanda ➜ mecanismo básico de paginação ➜ todas as páginas lógicas são carregada na memória



<div align="center">

## Conceitos Iniciais </div>
### ➥ Mecanismos Básicos de Páginação
- tabela de página ➜ há um bit de validação de cada página
  - V ➜ página válida ➜ página carregada na memória
  - I ➜ página inválida ➜ página não carregada na memória ou fora do espaço de 
- ao acontecer um acesso à memória
  - busca tabela de páginas 
  - bit v ➜ faz mapeamento para endereço físico
  - bit i ➜ MMU gera interrupção de proteção ao SO
    - no PCB há informação se a página está fora do espaço de endereçamento de um processo ou se houve falta de página 

### ➥ Page Fault (falta de página)
ao ocorrer falta de página a SO:

- suspende o processo e seu PCB vai para a 'fila de processos esperando por página lógica'
- uma página física livre deve ser alocada
- a página lógica do processo deve ser localizada no disco
- leitura no disco: endereço da página lógica e endereço da página física alocada
- atualiza a tabela de páginas
- retira  processo da fila de espera e aloca na fila de prontos
- processo repete a instrução que causou a falta de páginas 


### ➥ Paginação por Demanda

<div align="center">
  <img width="408" height="183" alt="image" src="https://github.com/user-attachments/assets/29cf7fc6-468c-455a-ab88-4c0bc27674e5" />
</div>

- pager ➜ parte do SO responsável por carregar uma página específica de um processo do disco para a memória 


<div align="center">

## Substituição de páginas na memória </div>
- ao acontecer Page Fault há necessidade de uma página livre na memória física, para isso o SO deve:
  - escolher uma página lógica (página vítima)
  - copiar o conteúdo dessa página para o disco
  - marcar a página como inválida, na tabela de página   
- exemplo processo 2 tenta acessar sua página lógica 3:
  - MMU gera interrupção de proteção ➜ algoritmo de substituição de páginas ➜ escolhe a página
  - atualiza a tabela de páginas
  - copia o conteúdo da página para o disco
  - página física livre continua o processo normalmente
<div align="center">
  <img width="414" height="283" alt="image" src="https://github.com/user-attachments/assets/6a5ab403-949a-4544-a43b-af1e6b153fd0" />

</div>

- bits auxiliares são adicionados à tabela de páginas para auxiliar a substituição:
  - bit de sujeira (dirty bit) ➜ indica quando a página foi alterada durante a execução do processo (é zerado quando a página é carregada, 'ligado' quando acontece a escrita
  - bit de referência (reference bit) ➜ indica quando a página foi acessada pelo processo, é inicializado com ZERO quando a página é carregada e recebe 1 quando a página é usada
  - bit de tranca (lock bit) ➜ é usado para trancar uma página lógica na memória física (a página bloqueada não pode ser escolhida como vítima) 

<div align="center">
  <img width="298" height="76" alt="image" src="https://github.com/user-attachments/assets/3e459af1-8c8e-4a24-886b-d6111d89ed6b" />

</div>


<div align="center">

## Algoritmos de Substituição de Página (Page-Replace Algor ) 
Objetivo é gerar a menor taxa de falta de páginas
</div>

- para determinar o número de faltas de páginas:
   - string de referência ➜ série de referências à memória
   - quadros ➜ saber o número de quadros disponíveis

#### ➥ Algortimo Ótimo
- coloca a falta de página em um futuro mais longe ➜ menor taxa de falta de páginas
- conhecido com OPT ou MIN
- consiste em substituir a página que não será usada pelo perído mais longo
- para tanto, é necessário conhecer as próximas referências às páginas (dificil de implementar) 

#### ➥ FIFO ou FCFS
- a página escolhida para ser substituída é a página que está há mais tempo na memória
- MMU deve ter uma lista com os números das páginas lógicas ➜ quando uma página é carregada na memória, seu número é colocado no final da lista
- desempenho ruim ➜ não considera que a página foi acessada

#### ➥ LRU (Least Recently Used)
- escolhe a página que a mais tempo não é usada ➜ considera que as páginas acessadas recentemente por um processo serão acessadas novamente num futuro próximo
- exige suporte de hardware ➜ registradores adicionais
- alto custo para manter na tabela de páginas o momento exato do último acesso 


<div align="center">

## Buffer de páginas </div>
- usado em conjunto com um algoritmo de substituição de páginas
- pode ser usado mesmo quando a MMU não implementa o bit de referência
- há um apontador que percorre a lista circular de páginas
- a gerência de memória mantém um conjunto de quadro livre (pool), quando há necessidade de substituição, remove um desses quadros livres
- a página indicada pelo apontador é marcada como inválida, atualizada no disco e incluída no conjunto de páginas livres, porém seu conteúdo não é alterado
- se for acessada em seguida, há falta de páginas, porém não é necessário acesso ao disco (oferece uma segunda chance de permanecer na memória e evitar acesso a disco) ➜ outra página deve ser escolhida como vítima
- sempre que uma página é escolhida como vítima e é gravada no disco, ela passa a fazer parte do pool de quadros livres

<div align="center">

## Alocação de Quadros </div>

- quadros = páginas físicas
- quantas páginas lógicas de cada processo devem ficar na memória física em cada momento? e quantos quadros cada processo obterá? ➜ definido pela arquitetura do computador e a quantidade máxima pela quantidade de memória disponível
#### ➥ algoritmo de alocação de quadros
- alocação igual
  - m ➜ número de quadros
  - p ➜ processos
  - exemplo: m=93 e p =5 ➜ cada processo receberá 18 quadros e os 3 restantes farão parte do buffer
- alocação proporcional
  - reconhecer diferentes quantidades de memória por processo
  - processos são tratados da mesma forma, independente da prioridade
  - a quantidade de quadros é alocada conforme a proporção ocupada de memória virtual
  - processo Pi tem Si de memória virtual ➜ m = número de quadros e ai ➜ número de quadro ao Pi ➜ ai = Si/S*m
      - exemplo: m = 62; P1,S1 = 10 páginas; P2,S2 = 127 páginas
        - S = 10 + 127 = 137
        - a1= 10/137*62 ➜ 4
        - a2 = 127/137*62 ➜ 57
- há duas formas de acontecer a substituição na falta de página
  - alocação local ➜ acontece entre as páginas do própios processo que gerou a falta
  - alocação global ➜ acontece entre as páginas de todos os processos (processos de prioridade mais baixa acabam perdendo para os processos de prioridade mais alta)  


<div align="center">

## Thrashing </div>
- ocorre quando a maior parte do tempo é usada para paginação ao inves de execução 
- tratamento de falta de páginas é mais lento que o acesso normal à memória
- quando um processo possui um número muito pequenos de páginas físicas para executar e sua taxa de falta de páginas aumenta, o processo para de realizar qualquer trabalho útil, pois se ocupa em tratar as faltas de páginas
- thrashing é um problema de desempenho
  - quando um processo tem um número pequeno de quadros ➜ há muita falta de página ➜ processo para e espera pela página ➜ consequência ➜ queda global de desempenho do sistema
- em  uma situação de thrashing, o SO “conclui” erradamente que estão faltando processos na fila de prontos, pois o uso da CPU está baixo ➜ então, insere novos processos na fila de prontos (escalonador de curto prazo) ➜ faz com que diminua a quantidade de quadros por processo ➜ agravando a situação 

<div align="center">
  <img width="329" height="200" alt="image" src="https://github.com/user-attachments/assets/ec0a08f7-e011-4c01-ad9f-83c38fcc1ac2" />

</div>

- para o usuário o thrashing se apresenta como:
   - congelamento do sistema ➜ para retirar o sistema de estado de thrashing é necessário suspender temporariamente alguns processos (Swapping)
     - com alocação local ➜ congelamento pode ser apenas com alguns processos
     - com alocação global ➜ congelamento pode ser de todo o sistema
   - com o swapping é possível manter na memória principal apenas um número de processos que conseguem executar de forma satisfatória ➜ a gerencia de memória realiza um revezamento entre os processos suspensos e aqueles executando
      - swapping não é algo desejável, pois aumenta o temmpo de resposta dos processos
      - a gerencia de memoria deve observar quando o thrashing irá acontecer para usar swapping ➜ usa a taxa mínima aceitável de faltas de páginas ou histórico de bits de referência ➜ o SO deve trabalhar de forma pró-ativa, evitando o thrashing
- para evitar thrashing ➜ procura designar ao processo o número de quadros necessários ➜ para saber o número de quadros ➜ estratégia do conjunto de trabalho (working-set) ➜ modelo de localidade
   - modelo de localidade ➜ quantos quadros um processo está realmente utilizando? e quais quadros estão sendo utilizados?
     - localidade ➜ conjunto de páginas usadas conjuntamente
     - programa pode ter várias localidades ➜ conforme a estrutura do programa e sua estrutura de dados  


----
#### anotações
- tabela de paginas faz o 'link' entre memoria logica e memoria fisica
- disco = memoria virtual --> quando não ha espaço na memoria fisica
  - vai pro disco e fica na espera por pagina ate 'abrir espaço' para que ele possa executar --> escolhe uma 'vitima' para substituir a pagina, a pagina escolhida vi para o disco, portanto libera uma pagina, e o processo que estava esperando passa a executar
