# ESTRUTURA DO SISTEMA OPERACIONAL
* análise de um Sistema Operacional ➜ nem todos os sistema possuem a mesma estrutura, mas existem alguns aspectos comuns aos quais dão suporte
    * serviços fornecidos
    * interfaces fornecidas a usuários e programadores
    * componentes e interconexões
<div align="center">
  <img width="300" height="270" alt="{DFC00E19-4100-422B-89D0-1B5B89FD5243}" src="https://github.com/user-attachments/assets/e8f4a087-795d-406a-ba8a-61742067e851" />
</div>

---  

## Mecanismos de interrupções
* um contralor de periférico que precisa enviar dados ao processador pode:
   * aguardar até que o processador esteja livre e o mesmo o consulte para verificar se há alguma informação para o processador
   * gerar uma interrução (IRQ- requisição de interrupção) por meio do barramento de controle
* **O MECANISMO DE INTERRUPÇÕES TORNA EFICIENTE A INTERAÇÃO DO PROCESSADOR COM OS PERIFÉRICOS E PERMITE I/O ASSÍNCRONA**
* sinalizar ocorrência de eventos
* tratador de interrupção
* interrupção pode ser ocasionada por hardware, software ou por uma exceção (exemplo: overflow, divisão por erro)
* vetor ou tabela de interrupções = número da interrupção (IRQ) e o endereço da rotina
* excução/tratamento da interrupção
    * transfere o controle para o tratador - salva o contexto da execução
    * desvia controle para o tratador
    * retorna execução - restaura o contexto de execução
* chamada de sistema = processo em que usuário solicita serviços ao sistema operacional ➜ interrupções de software (traps)

---

## Proteção
- o SO deve garantir a correta utilização dos recursos computacionais e propiciar a execução das aplicações no computador
- são necessários mecanismos de proteção para que as aplicações não consigam acessar o hardware diretamente
   - esse acesso é mediado pelo SO 
- de memória
- de CPU
- Há diferentes modos de execução/privilégios que constituem o Modo de Dual de operação
#### Modo Dual de operação
- a arquitetura de processadores oferece mecanismos para diferenciar dois modos de operação
    - modo supervisor (privilegiado)
       - modo de execução sistema operacional - instruções privilegiadas
       - execução de todas as instruções do processador 
    - modo usuário
        - execução dos processos usuários
        -  somente um subconjunto de instruções do processador, registradores e portas de I/O estão disponíveis
        - caso o código em execução tenta executar uma instrução não disponível, será gerada uma exceção
- chaveamento de modos
    - interrupção (modo usuário ➜  modo supervisor)
    - instrução (modo supervisor ➜  modo usuário)

---

## Estrutura dos Sistemas Operacionais
SO deve ser divido em pequenos componentes e não ser um sistema monolítico
#### principais componentes:
- núcleo (kernel) ➜ gerência do processador, gerência da memória principal (RAM) e comunicação
- drivers ➜ códigos específicos para acessar os dispositivos físicos, exemplos: disco rígido, porta USB, placa de vídeo
- códigos de inicialização ➜ Reconhecer, testar e configurar os dispositivos instalados. Carregar o núcleo do SO e iniciar a execução
- programas utilitários ➜ funcionalidades complementares do SO

### KERNEL
- é a parte do SO executada com interrupções desabilitadas(enquanto tiver executando não responde a interrupções) e no modo privilegiados (todos comando estão disponíveis)
- nos trechos críticos não há interrupções, ex: inserção de um processo na fila de prontos
- pode ser monolíticos
    - quanto todos os componentes do SO são executados com interrupções desabilitadas e no modo privilegiado
    -  toda e qualquer parte do SO é executada da maneira indivisível
      - cada trap (chamada do sistema) ou interrupção desabilita o sistema de interrupções 
    - desvantagens:
      - pode haver muita espera
      - complexidade da estrutura de organização do kernel
- é um pequeno monitor monolítico que recebe o controle quando ocorrem chamadas ao sistema ou interrupções
- os serviços são implementados fora do kernel
   - por processos específicos
   - um processo para controlar o dispositivo = driver de dispositivo
- mantém o descritor do processo e implementa funções para sincronização e comunicação
- pode ser microkernel ou monitor monolítico 
 
### Como os componentes são combinados e interconectados
#### ➥ Estruta simples
- sistemas sem estrutura bem definida
   - iniciaram pequenos, simples e limitados ➜ cresceram
   - exemplo: MS-DOS
      - fornecer funcionalidade máxima no menor espaço possível, hardware base ficou acessível, programas aplicativos podem acessar as rotinas básicas de I/O para escrever diretamente na tela e nas unidades de disco 
<div align="center">
  <img width="400" height="196" alt="{E9F70F38-CB8B-4BA2-8C84-50E8D5AE702E}" src="https://github.com/user-attachments/assets/2e1690c5-0e30-4d38-8baf-6f017d88d438" />
</div>

##### Estrutura do Unix
- o Unix originalmente foi limitado pela funcionalidade de hardware
- dividido em duas partes
   - Kernel
      - inclui interfaces e drivers de dispositivos (adicionados com a evolução)
      - está abaixo da interface de chamadas ao sistema e acima do hardware
      - fornece: sistemas de arquivos, escalonamento de CPU, gerência de memória, funções do SO através de chamadas ao sistema
   - Programas de sistema
<div align="center">
   <img width="554" height="279" alt="image" src="https://github.com/user-attachments/assets/e3305bad-5af3-447a-89fa-0807353b29d6" />

</div>

#### ➥ Camadas
- forma de **modularização** de um sistema
- uma camada de SO
   - é uma implementação de um objeto abstrato
   - consiste em estruturas de dados e rotinas que podem ser chamadas por chamadas superiores
- as camadas são construídas de forma que somente utilizem os serviços das camadas de nível mais baixo
   - simplifica a verificação e depuração do sistema 
- menos eficientes devido à hierarquia de camadas
- permite maior controle do hardware em relaçao à abordagem simples
- a primeira camada pode ser depurada sem preocupação com o resto do sistema, porque utiliza somente o hardware básico para implementar suas funções
- a primeira camada pode ser depurada sem preocupação com o resto do sistema, porque utiliza somente o hardware básico para implementar suas funções
- dificuldade: definição adequada das camadas
- tendem a ser menos eficiente que outros tipos ➜ em cada camada, os parâmetros podem ser modificados, os dados precisam ser transferidos...custos são acrescentados ➜ maior tempo na chamada ao sistema
- OS/2
   - acrescentou camadas, operações multitarefas e em modo dual
   - não permite ao usuário acesso aos recursos de baixo nível
   - sistema operacional tem mais controle sobre o hardware e programas em execução
- MULTICS
- Windows NT(parcialmente)
   - implementa camada inferior de abstração do harware - HAL(Hardware Abstraction Layer) 

<div align="center">
   <img width="369" height="235" alt="image" src="https://github.com/user-attachments/assets/5edb3a2c-ba44-4518-bfb7-38ecf9b3a083" />

</div>

#### ➥ Microkernels ou micronúcleo
- com a expansão do unix, o kernel tornou-se grande e difícil de gerenciar
- 1980 - sistema operacional Mach (Carnegie Mellon University) ➜ abordagem microkernel
    - implementa  somente os componentes essenciais do SO no Kernel, os demais são implementados como programas de sisemas e de usuário
    - retirou-se do kernel o código de 'alto nível'
    - os componentes do SO comunica-se por meio de trocas de mensagens
    - kernel menor
    - facilidade de manutenção
- fornecem:
    - gerência mínima de memória e processos
    - um recurso de comunicação entre programas do usuário e serviços que estão em execução também no espaço de usuário
- proporcionam:
   - facilidade de expansão do sistema ➜ novos serviços são adicionados ao espaço do usuário
   - modificações facilitadas no kernel
   - maior segurança e confiabilidade em caso de falhas
- possibilitar a comunicação entre o programa cliente e os diversos serviços disponibilizados
   - trocas de mensagens
   - o programa cliente e o serviço não interagem diretamente e sim via microkernel
- sistemas baseados no kernel do Mach
   - UNIX Digital
   - Apple MacOS X     

<div align="center">
   <img width="436" height="261" alt="image" src="https://github.com/user-attachments/assets/f659ced5-ca5b-4489-847d-106bb4720de6" />

</div>

#### ➥ Módulos
- POO ➜ Kernel modular
- há um kernel básico e módulos carregáveis dinamicamente
- a interface entre os módulos é claramente definida
- Solaris, Linux, MacOS X
- flexibilidade 

### Máquinas Virtuais
- o SO possibilita que um processo 'possua' seu próprio processador com sua própia memória ➜ técnicas de escalonamento e memória virtual
- cada processo recebe uma cópia do computador básico
- o computador físico compartilha seus recursos para que isto ocorra ➜ escalonamento de CPU pode criar a aparência que cada usuário possui seu própio proccessador
- atualmente é utilizada para portabilidade dos sistemas
- vantagens: isolamento dos recursos da máquina virtual e testes
- desvantagens: difícil de implementar

<div align="center">
   <img width="274" height="197" alt="image" src="https://github.com/user-attachments/assets/41e678d3-c1c4-474b-985e-6b608e6e5bca" />

</div>
   
- abordagens: camadas, microkernel, modulos e máquinas virtuais não são mutuamente exclusivas     

---

## Chamadas ao sistema (System call)
- utilizada para que as rotinas oferecidas pelo núcleo possam acessar ao hardware
- fornecem a interface entre um processo e o sistema operacional, ou seja, é a interface de programação para os serviços fornecidos pelo SO
- instruções em assembly, mas podem ser escritas em linguagens de mais alto nível, como C e C ++
- programa de alto nível ➜ pode gerar outras chamadas
- In-line
- é necessário o mecanismo de interrupções
- API disponíveis aos compiladores pelos SO
   - exemplo API para manipulação de arquivos na linguagem C
      - exemplo: copiar 2 arquivos (o que está em negrito são chamadas)
         1) **criar** o novo arquivo copia.txt (abrir - criando em modo de escrita)
         2) **abrir** o arquivo original.txt em modo de leitura
         3) **ler** uma linha no arquivo original.txt
         4) **gravar** no arquivo copia.txt
         5) repetir passos 3 e 4 enquanto não for o fim do arquivo
         6) **fechar** o arquivo original.txt
         7) **fechar** o arquivo copia.txt
- a API para as chamadas ao sistema invocam as chamadas ao Kernel do SO
- a maioria das linguagens oferece interface mais simples:
   - detalhes da interface do SO são ocultos ao programador através do compilador e do pacote de suporte à execução
   - não é necessário conhecer como a system call é implementada

<div align="center">
   imagem
</div>

- 3 métodos para passar parâmetros às chamadas
   - registradores (mais simples)
   - bloco ou tabela na memória e o endereço do bloco é passado ao registrados
   - inseridos (push) na pilha do sistema pelo programa e lidos/removidos (pop) pelo SO
   - * segunda e terceira não limitam a quantidade de parâmetros
### 5 categorias de chamadas ao sistema
  

#### ➥ Controle de processo
- exemplo de chamadas: end, abort, load, execute, create/terminate process, get/set process attributes, wait for time, wait/signal event, allocate/free memory
- MS-DOS ➜ monotarefa
   - interpretador de comandos chamado quando o computador é iniciado
   - executa novo programa sem criar um processo
      - carrega programa na memória, gravando sobre si mesmo, para permitir maior quantidade possível de memória
      - sistema define ponteiro de instruções para a primeira instrução
      - programa executa até um erro acontecer ou parar
   - pequena parte do interpretador, não sobreposta, recomeça a execução
- UNIX ➜ multitarefa
   - interpretador de comandos é chamado quando um usuário efetua o logon no sistema (shell do usuário é executado)
      - shell continua a execução enquanto outro programa é executado
   - para iniciar um processo, o shell executa a chamada ao sistema fork
   - programa é carregado na memória pela chamada exec (o programa é executado)
   - dependendo da forma que o comando foi emitido, o shell espera o processo ser finalizado ou executa o processo em 'segundo plano' (não pode receber entrada diretamente pelo teclado; o shell está livre para receber outras chamadas)
   - processo terminado ➜ executa chamada 'exit' ➜ passa ao programa que o criou código de status zero ou código de erro diferente de zero
<div align="center">
   imagem
</div>

#### ➥ Gerência de arquivos
- exemplos de chamadas: create/delete file, open, close, read, write, reposition, get file attributes, set file attributes
- atributos de arquivos: nome, tipo, código de proteção, tamanho,...
#### ➥ Gerência de Dispositivos
- exemplos de chamadas: request/release device, read, write, reposition, get/set device attributes, logically attach decives
- programa em execução pode precisar de recursos adicionais para prosseguir ➜ memória, unidades de fita, acesso a arquivos
- a similaridade entre dispositivos de I/O e arquivos é tão grande que muitos sistemas operacionais, como UNIX e MS-DOS, combinam os dois em uma estrutura de arquivo-dispositivo ➜ dispositivos de I/O são identificados por nomes de arquivos
#### ➥ Gerência ou Manutenção de informações
- refere-se às informações trocadas entre o programa de usuário e o sistema operacional
   - chamadas ao sistema:
      - data e hora atuais (get/set date, time)
      - número de usuários atuais, versões do SO, memória livre
      - sistemas operacionais mantém informações sobre todos os processos (get/set process/file/device/attributes)
#### ➥ Comunicação
- exemplo de chamadas: create, delete communication connection, send/receive messages, transfer status information, attach remote devices
- modelo de troca de mensagens ➜ recurso de comunicação oferecido pelo SO
- modelo de memória compartilhada ➜ os processos também são responsáveis por garantir a consistência da memória compartilhada
#### EXEMPLOS DE CHAMADAS AO SISTEMA
<div align="center">
   imagem
</div>





