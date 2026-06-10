<div align="center">

  # Gerência de Memória </div>

- multiprogramação: vários processos prontos para execução concorrem à CPU
  - para que a troca de contexto seja rápida, os processos devem estar na memória principal
- deve prover mecanismos para que os processos utilizem a memória de forma segura e eficiente
- há várias técnicas de gerência
- cada SO emprega uma técnica em particular e isto depende fortemente de arquitetura do computador
- **memória** = vetor de palavras ou bytes com seus endereços
  - a cpu busca instruções da memória, de acordo com o valor do Contador de Programa (de busca ou armazenamento em endereços de memória específicos)
- todo endereço de memória gerado pela CPU deve ser verificado em termos de legalidade e possivelmente ser mapeado em um endereço físico
- a verificação não pode ser implementada de forma eficiente no software (limitado pelo hardware)


---
<div align="center">

  ## Ciclo de Execução de Instrução </div>

<div align="center">
  <img width="279" height="146" alt="{711CC047-2D2F-4E3E-A467-60F2CB616F27}" src="https://github.com/user-attachments/assets/82ca53a4-1dc2-46fb-8f81-8f955863cd25" />

</div>

- a unidade de memória vê apenas um fluxo de endereços de memória (não sabe como são gerados ou para que servem)

---
<div align="center">  
  
  ## Mapeamento de Endereço</div>

- fila de entrada ➜ coleção de processos nos disco esperando para serem carregados na memória
- procedimento normal
  - selecionar um dos processos na fila de entrada e carregá-lo na memória ➜ função do escalonador de longo prazo
  - a medida em que o processo é executado, ele acessa instruções e dados da memória ➜ ao terminar seu espaço de memória é disponibilizado
- o espaço de endereços no computador começa em 00000 ➜ mas o primeiro endereço de um processo de usuário não precisa ser 00000
  - isto afeta os endereços que o programa do usuário vai usar

- um programa do usuário passa por várias etapas antes de se executado

<div align="center">
  <img width="486" height="274" alt="{2C2F9190-53EC-4508-AE59-1D8FDC6F1A51}" src="https://github.com/user-attachments/assets/aba1a691-5dbb-4ffa-8cc9-d809851f76c8" />

</div>

- os endereços podem ser representados de diferentes formas durante essas etapas e mapeados também em momentos diferentes
- cada associação é um mapeamento de um espaço de endereço para outro e pode ser feita em etapas diferentes
  - em tempo de compilação
    - se sabe-se antecipadamente que um processo de usuário reside na posição X da memória, o código compilado iniciará nessa posição (se a posição de início mudar é necessário recompilar o código) ➜ Código absoluto
      - carregador absoluto ➜ endereços do processo não são alterados na carga
  - em tempo de carga
    - o compilador deve gerar um código relocável ➜ a associação de final dos endereços é retardada até o instante de carga ➜ se o endereço de início mudar, os endereços do processo são corrigidos pelo carregador para que o programa execute corretamente no local onde foi carregado
      - carregador relocador
  - em tempo de execução
    - se o processo durante sua execução pode ser movido de um segmento de memória para outro, a associação dos endereços é feita em tempo de execução 
    - a maioria dos SO de uso geral usa esse método, é necessário um hardware (faz o mapeamento de endereços lógicos para endereços físicos) de uso geral para que isso funcione 

---

<div align="center">

  ## Espaço de Endereçamento - Lógico X Físico </div>

- memória lógica ➜ é aquela que o processo enxerga
  - os endereços manipulados pelo processo são endereços lógicos
  - cada processo possui sua memória lógica, independente da memória lógica de outros processos
  - espaço de endereçamento lógico ou virtual de um processo ➜ conjunto de endereços lógicos que esse processo pode endereçar (enxergar) ➜ há um espaço de endereçamento lógico por processo
- memória física ➜  implementada pelos circuitos integrados de memória
  - endereço físico ➜ endereçar os circuitos integrados
  - espaço de endereçamento físico ➜ todos os endereços aceitos pelos circuitos integrados de memória

- mapeamento de endereços em tempo de compilação e de carga resultam em endereçamento lógicos e físicos iguais
- o mapeamento de tempo de execução dos endereços lógicos para físicos é feito pela Unidade de Gerência de Memória (MMU - Memory Management Unit)
- a MMU é um componente do hardware
<div align="center">
  <img width="364" height="93" alt="{C98B5048-7EC2-4BB8-BEBA-047688E0C492}" src="https://github.com/user-attachments/assets/8a1b2e71-2e2c-4d24-bd82-f5ade4a9045f" />

</div>

---

<div align="center">

  ## Proteção de Memória </div>

- realizado pela MMU
- exemplo com registradores de limites
  - considera que os endereços lógicos e físicos são idênticos
  - o conteúdo dos Registradores Limite define o espaço de endereçamento lógico do processo
  - nesses exemplo: espaço de endereçamento lógico é de 100 a 799   

<div align="center">
  <img width="344" height="110" alt="{717A1531-3E95-4686-B57D-A0C6FF18CC75}" src="https://github.com/user-attachments/assets/4fd0cf12-e26b-43ae-8424-1583f6eaf513" />

</div>

- exemplo com registrador limite e registrador base
  - considera que os endereços lógicos e físicos são diferentes
  - o espaço de endereçamento lógico do processo vai de zero até o Registrador Limite
  - a área de memória física do processo inicia no valor do registrador base e tem o tamanho da memória lógica do processo (limite)

- registrador base e limite
  - devem ser protegidos (acessados somente no modo supervisor)
  - fazem parte do contexto do processo e devem ser mantidos no PCB do processo
  - troca de contexto: os valores dos registradores são copiados do PCB para os registradores da MMU

<div align="center">
  <img width="367" height="110" alt="{A65B0338-8AB7-4927-A13D-6406577F853A}" src="https://github.com/user-attachments/assets/efba79cf-10e5-4572-bf20-8537f1ab1791" />

</div>

---

<div align="center">

  ## Swapping (troca)</div>

- um processo pode ser removido da memória temporariamente para um armazenamento auxiliar e retomado à memória para continuar a execução
- liberar memória
<div align="center">
  <img width="330" height="205" alt="{17F2D7F7-51A1-4606-818D-9A697A462490}" src="https://github.com/user-attachments/assets/d007c3c2-b770-4cfa-b611-b60009ab76fd" />
</div>

- geralmente, um processo que é descarregado será carregado no mesmo espaço de memória que ocupava anteriormente, isto é determinado pelo método de resolução de endereço
  - se for na carga ou montagem: processo não pode ser movido para posições diferentes
  - se for em tempo de execução: é possível passar para posições diferentes porque endereços físicos são calculados em tempo de execução   
- troca requer armazenamento auxiliar ➜ disco rápido e grande o sufuciente para acomodar cópias de todas as imagens de memória para os usuários e fornecer acesso direto a essas imagens na memória
- SO mantém fila de processos prontos ➜ processos cujas imagens de memória estão no dispositivo de armazenamento auxiliar ou na memória principal prontos para executar
- sempre que o escalonador de CPU buscar um processo, chama o dispatcher para fazer a troca de contexto
  - verifica se o próximo processo na fila está na memória ➜ se não houver região de memória livre ➜ descarrega um processo de memória (**swap out**) ➜ carrega o processo desejado em seu lugar (**swap in**) ➜ recarrega os registradores e transfere o controle para o processo selecionado
- tempo de troca de contexto com swapping é relativamente alto (transferência do processo: memória ➜ disco ➜ memória)
  - processo de um usuário = 1 MB
  - taxa de transfêrencia do disco rígido = 5MB
  - para 1 MB ➜ 200 ms + latência (8ms) = 208 ms
  - carga e descarga = 208 * 2 = 416 ms
  - o tempo de execução deve ser longo em relação ao tempo de troca, nesse exemplo no RR, quantum > 0,416s 
  - parte principal do tempo de troca ➜ tempo de transferência (proporcional a quantidade de memória trocada)
- é útil saber quanto de memória cada processo está usando
- para descarregar um processo é necessário ter certeza que ele está completamente inativo
- SO em geral possuem um espaço em disco para swap, separado do espaço para os arquivos