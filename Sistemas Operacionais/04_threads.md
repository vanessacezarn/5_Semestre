# THREADS
- processo
  - um único fluxo de execução
  - espaço de endereçamento, descritores de arquivos abertos, permissões de acessos,
- threads
  - multiplos fluxos de execução
  - multithreading: associar vários fluxos de execução a um único processo
    - mesmo espaço de endereçamento
  - um fluxo de instrução é implementado através do Contador de Programa (PC) e do Stack Pointer (SP)
  - estruturas comuns compartilhadas entre os threads: código, dados, descritor de processo
  - vários fluxos de execução em um único processo
  - processo leve
  - unidade básica de utilização da CPU
  - existem no interior de um processo
      - Descritor de threads
        - id Thread
        - prioridade
        - contador de programa
        - registradores
        - pilha
      - Compartilha com threads do mesmo processo
        - espaço de endereçamento (seção de dados, seção de código, arquivos abertos, recursos do SO)
        - gerência é mais leve
        - chaveamento de contexto mais rápido
  - aplicação em PCs ➜ multithreading
      - thread único ➜ um cliente por vez
      - multithread ➜aceita requisição de vários clientes
      - navegador web
      - servidor web

#### Benefícios do uso de threads
- capacidade de resposta ➜ navegador web
- compartilhamento de recursos
  - mesmo espaço de endereçamento do processo
  - memória, recursos do processo que pertence
- economia ➜ troca de contexto de threads(alocação de memória e recursos) x processos
- aplicações multiprocessador ➜ paralelismo

### Threads de usuário
- implementadas através de biblioteca ligada ao programa do usuário (thread de usuário ou de nível de usuário)
- visíveis ao programador e desconhecidos do Kernel
- gerenciamento (criação/escalonamento) através de biblioteca de threads
  - Pthreads - Posix | C-threads - Mach | threads - Solaris
- gerenciamento mais rápido (kernel não envolvido)

### Threads de Kernel
- o SO suporta diretamente o conceito de thread
  - a gerência do SO é voltada ao conceito de thread
- gerenciamento através do Kernel
- são escalonados para execução nos vários processadores
- mais lentos
- suportados diretamente pelo SO

**os SO fornecem suporte a threads de usuário e de kernel**  

### Modelos de Multithreading
#### ➥ N:1 - Muitos-para-um (many-to-one)
- gerenciamento de threads é feito no espaço do usuário - aplicação
  - são implementados no espaço do usuário (uso de biblioteca ligada ao programa) 
  - API para uso de threads
- chaveamento de contexto mais rápido
- menor custo para criação/destruição
- o SO divide o tempo entre os processos ➜ são manipuladas através de um único fluxo de instrução pertencente a um processo
- a troca de contexto entre thread é feita no modo usuário pelo escalonador embutido na biblioteca
- se um thread está efetuando I/O, acontece o bloqueio de todas as threads do sistema
- não é possível utilizar multiprocessadores
- um thread é escalonado de cada vez

<div align="center">
  imagem
</div>

#### ➥ 1:1 - Um-para-Um (one-to-one)
- maior concorrência
- threads a níveel do sistema ➜ o SO mantém informações sobre processos e threads
- maior custo de gerenciamento 
  - exigem chamadas ao SO
  - troca de contexto exige a intervenção do SO
- é possível a execução paralela - ambiente multiprocessado
- permite sobrepor operações de processamento com I/O 
- desempenho da aplicação ➜ depende do número de threads suportas pelo sistema

<div align="center">
  imagem
</div>

#### ➥ M:N - Muitos-para-Muitos (many-to-many)
- combina os modelos N:1 e 1:1
- M threads do usuário e N threads do SO
- multiplexa threads de usuário em um número menor ou igual de threads de kernel
- escalonamento de 2 níveis: nível de usuário e nível de sistema
- é possível criar tantos threads quantos forem necessárias
- há um número de threads específico por aplicação ou máquina
- bloqueio ➜ escalonar outra para execução
- há paralelismo

<div align="center">
  imagem
</div>

### Vantagens de Multithreads
- Threads x Processos
  - tempo de criação/destruição
  - troca de contexto
  - threads compartilham o mesmo espaço de endereçamento do processo que as criou, assim é possível o compartilhamento de memória sem a interação com o núcleo do sistema

--- 

### Parte prática
#### threads em java
- pode-se especificar fluxos de execução (threads), designando uma parte de um programa que pode ser executado simultaneamente com outras threads
- multithreading é a parte da própia linguagem (pacote java.lang)
- cada thread tem uma prioridade
- duas formas para uso de threads
  - criar um subclasse da classe Threads (herança) e reescrever o método run()
    - A classe Thread implementa a interface Runnable
    - O método run é o “corpo” da Thread
  - criar uma classe que implementa a interface ➜ Runnable
- Classe Thread 
  - alguns métodos
    - construtores
    - run()
    - start()
    - sleep()
    - join()

- estados da threads
<div align="center">
  imagem
</div>

--- 
## POSIX Threads ou Pthreads
- é um padrão estabelecido pela IEEE em 1995 que define uma interface padronizada para a criação e gerenciamento de threads
- o padrão é amplamente utilizado em sistemas operacionais baseados em Unix e Linux, permitindo a execução concorrente de múltiplos fluxos de execução dentro de um mesmo processo
-  Para utilizar Pthreads em programas escritos em linguagem C, é necessário  incluir a biblioteca por meio da diretiva #include < pthread.h>
- As principais funções da biblioteca estão relacionadas à criação, ao término e à sincronização de threads, destacando-se o uso de pthread_create, pthread_exit e pthread_join.
#### pthread_create
- é responsável por criar uma nova thread, permitindo a execução concorrente dentro do programa.
-  Seu protótipo recebe quatro parâmetros: 
  - o identificador da thread,
  - os atributos (que podem ser definidos como padrão com NULL), 
  - a função que será executada pela thread 
  - o argumento que será passado para essa função
```
#include <pthread.h>
int pthread_create (pthread_t * thread, pthread_attr_t * attr, void * (*start_routine)(void *), void *arg);
```

#### pthread_exit
- utilizada para finalizar a execução de uma thread, podendo retornar um valor que posteriormente pode ser recuperado por outra thread.

```
include <stdlib.h>
 void pthread_exit (void *retval)
```
#### pthread_join
-  é responsável por fazer com que uma thread aguarde o término de outra, garantindo sincronização entre elas; caso haja um valor de retorno, este pode ser armazenado para uso posterior por meio do parâmetro thread_return.
- ou seja,  suspende a execução da thread que a chamou até que a thread especificada como argumento seja finalizada.

```
#include <stdlib.h>
  int pthread_join (pthread_t th, void **thread_return);
```

- tanto pthread_exit tano pthread_join  são funções  fundamentais para o controle do ciclo de vida e da coordenação entre threads em aplicações concorrentes