# THREADS
- processo
  - um único fluxo de execução
  - espaço de endereçamento, descritores de arquivos abertos, permissões de acessos,
- threads
  - ff
  - multithreading: associar vários fluxos de execução a um único processo
  - um fluxo de instrução é implementado através do Contador de Programa (PC) e do Stack Pointer (SP)
  - processo leve
  - unidade básica de utilização da CPU
  - existem no interior de um processo
      - Descritor de threads
      - Compartilha com threads do mesmo processo
        - espaço de endereçamento
        - gerência é mais leve
        - chaveamento de contexto mais rápido
  - aplicação em PCs --> multithreading
      - thread único --> um cliente por vez
      - multithread --> aceita requisição de vários clientes

#### Benefícios do uso de threads
- capacidade de resposta --> navegador web
- compartilhamento de recursos
  - mesmo espaço de endereçamento do processo
  - memória, recursos do processo que pertence
- economia
  - troca de contexto de threads(alocação de memória e recursos) x processos
- aplicações multiprocessador
  - paralelismo

### Threads de usuário
- implementadas através de biblioteca ligada ao programa do usuário (thread de usuário ou de nível de usuário)
- visíveis ao programador e desconhecidos do Kernel
- gerenciamento (criação/escalonamento) através de biblioteca de threads
- gerenciamento mais rápido

### Threads de Kernel
- o SO suporta diretamente o conceito de thread
  - a gerência do SO é voltada ao conceito de thread
- gerenciamento através do Kernel
- são escalonados para execução nos vários processadores
- mais lentos
- suportados diretamente pelo SO

**os SO fornecem suporte a threads de usuário e de kernel**  

### Modelos de Multithreading
#### N:1 - Muitos-para-um (many-to-one)
  - gerenciamento de threads é feito no espaço do usuário - aplicação
 
  - a troca de contexto entre thread é feita no modo usuário
#### 1:1 - Um-para-Um (one-to-one)
  - é possível a execução paralela - ambiente multiprocessado
  - permite sobrepor operações

#### M:N - Muitos-para-Muitos (many-to-many)
- combina os modelos N:1 e 1:1
- M threads do usuário
- é possível criar tantos threads quantos forem necessárias

### Vantagens de Multithreads

--- 

### Parte prática
#### threads em java
- duas formas para uso de threads
  - criar um subclasse da classe Threads (herança) e reescrever o método run()
- Classe Thread
  - alguns métodos
    - construtores
    - run()
    - start()
    - sleep()
    -         
- 
