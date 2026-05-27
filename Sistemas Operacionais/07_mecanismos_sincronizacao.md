<div align="center">

# Mecanismos de Sincronização
</div>

- mecanismos básicos para obtenção da exclusão mútua 
  - Protocolos de Acesso (protocolo em software puro)
  - Spin-lock
- mecanismo de mais alto nível para obtenção da exclusão mútua:
  - Mutex
  - Semáforos
  - Monitores
----
<div align="center">

  ## Protocolos de Acesso ou Soluções em Software Puro
</div>


- soluções para apenas 2 tarefas
- consiste em códigos implementados (sem utilzar chamadas ao sistema) antes da entrada na seção crítica e na saída da seção crítica, fazendo o controle de acesso aos dados compartilhados
- esses protocolos possuem espera ocupada (busy waiting) para entrada na seção crítica, fazendo com que mesmo que o processo esteja esperando permaneça utilizando o processador. Assim, são soluções aplicáveis a seções críticas pequenas
- consitem em métodos ou funções que definem:
  - Entrada_SC() ➜ somente entra se tiver permissão
  - Saida_SC () ➜ saída da seção crítica
  - Seção crítica ➜ locais onde cada processo ou thread realiza sua seção crítica
- ao todo, são 3 formas de implementar os Protocolos de acesso 
  - algoritmo 1 e 2 ➜ propostos por E.W.Dikstra
  - algoritmo 3 ➜ conhecido como algoritmo de Petterson (1981)
  - não incluem chamadas ao SO
### ➥ Algoritmo 1
- as threads compartilham uma variável inteira x iniciailizada em 0 ou 1
- se x =i, então Ti pode executar sua seção crítica
- garante que apenas uma thread de cada vez esteja executando sua seção crítica
``` c
  Entrada_SC(i){
    while(x!=i){
      //espera
    }
  }
  Saida_SC(i){
    x=1-i;
  }
```
- não retém informações sobre o estado de cada thread ➜ apenas lembra qual thread tem permissão para entrar na seção crítica
### ➥ Algoritmo 2 
- a váriavel x é substituída pelo vetor booleano flag (compatilhado entre as threads) ➜ boolean flag[2]={false,false}
- se flag[i]=true ➜ Ti está pronta para entrar em sua seção crítica
- requisito de exclusão mútua é atendido, mas os demais ainda não:
  - T0 define flag[0]=true indicando que quer entrar em sua seção crítica
  - antes de entrar no while, ocorre troca de contexto e T1 define flag[1]=true
  - ambas as threads entrarão em um laço infinito
``` c
  Entrada_SC(i){
    int outro;
    outro=1-i;
    flag[i]=true;
    while(flag[outro]==true){
      //espera
    }
  }
  Saida_SC(i){
    flag[i]=false;
  }
```
### ➥ Algoritmo 3 - de Peterson
- combinação dos algoritmos 1 e 2 atendendo os requisitos de uma solução ao problema da Seção Crítica
- threads compartilham a variável inteira e o vetor booleano
  -   ```
      int x; //Pode ser inicializado com 1 ou 0
       boolean flag[2] = {false, false}
      ```
- para entrar em sua seção critica (Ti)
  - define flag[1]=true
  - declara que é a vez da outra thread entrar também (x=outro)
- se ambas thread tentarem entrar ao mesmo tempo, x é definio como i e como j praticamente ao mesmo tempo
- apenas uma dessas atribuições perdura
- o valor final de x decide qual das duas threads terá permissão para entrar em sua seção crítica primeiro
``` c
  Entrada_SC(i){
    flag[i]=true;
    int outro = 1-i;
    x = outro.
    while((flag[outro]==true)&&( x == other)){
      //espera
    }
  }
  Saida_SC(i){
    flag[i]=false;
    x = 1- id;
  }
```

### ➥ Desabilitar interrupções
- solução mais simples para proteção da Seção Crítica
  - cada processo desativar todas as interrupções para entrar na seção crítica e reativá-las imediatamente após sair dela
- pode ser usado em sistema embarcados
- não é um método genérico ➜ não é aconselhável dar a processos de usuário a permissão para desabilitar interrupções
  - um processo de usuário pode desabilitar as interrupções e não habilitá-las 
- não usado em máquinas multiprocessadas ➜ apenas a CPU que realiza a instrução é afetada, as demais continuarão executando e poderão acessar a memória compartilhada
- técnica útil no SO em si, pois, por exemplo, o sistema desativa interrupções enquanto atualiza variáveis ou listas
- para processos de usuário, como mecanismo de exclusão mútua, não é apropiada
---
<div align="center">

  ## Spin-lock ou test-and-set
</div>

- hardware de sincronização
- algumas máquinas fornecem hardware especial 
  - permitem testar e modificar o conteúdo de uma palavra ou trocar o conteúdo de duas palavras (de forma atômica)
- instrução de máquina que executa de forma atômica
- instrução SWAP -  operação usada para trocar os valores de duas variáveis, registradores ou posições de memória ➜  sem interrupção
  - seção crítica está protegida por uma variável em [mem]=lock(fechadura)
  - lock = zero ➜ seção crítica livre
  - lock = 1 ➜ seção crítica ocupada
``` c
  Swap(reg,mem)
    [mem] -> aux
    reg -> [mem]
    aux -> reg
```
- antes de entrar na seção crítica, um processo precisa 'fechar a porta' ➜ lock = 1
  - somente pode fazer isso se lock = 0, ou seja, seção crítica livre
``` c
  // entrada na seção critica 
  do{
    reg =1;
    swap(reg,lock);
  }while(reg==1);
  // saida da seção critica
  lock = 0;
```

- vantagens:
  - simplicidade
  - instrução de máquina presente na maioria dos processadores
- desvantagens:
  - busy-waiting ➜ processo no laço de espera ocupa o processador
  - se existem vários processos, pode haver postergação indefinida
  - uso limitado a problemas com seção crítica pequena


---
<div align="center">

  ## Semáforos
</div>

- ferramenta de sincronização utilizada para controlar o acesso a recursos comuns em ambientes de programação concorrente
- é um tipo abstrato de dado que possui:
  - um valor inteiro
  - uma fila de processos
  - duas operações sobre o semáforo:
    - P ➜  proberen (testar – wait – down – wait)
    - V ➜ verhogen (incrementar – signal – up – post)

### Operações sobre semáforos
P e V são operações atômicas

- operação P 
  - decrementa em 1 o valor do semáforo
  - testa o valor do semáforo
    - se o valor é negativo ➜ processo é bloqueado e colocado no fim da fila do semáforo
- operação V
  - incrementa em 1 o valor do semáforo
  - sinaliza caso exista processo na fila do semáforo
    - retira o 1º processo da fila do semáforo  e acorda o processo

A implentação das operações P e V são feitas por meio de chamadas ao sistema. Há necessidade de desabilitar interrupções e de ter acesso aos descritores de processo.

``` c
struct Semáforo{
  int valor;
int *PCB;
}
Semáforo S;

// Operação P(S)
S.valor = S.valor – 1;
// Se S.valor < 0 bloqueia o processo que executou a operação P(S); coloca o processo na fila de S;
// Senão continua execução;

// Operação V(S)
S.valor = S.valor + 1;
// Se S.valor <= 0 retira um processo da fila de S; acorda o processo que foi removido da fila;
// Senão continua execução;

```
### Tipos de Semáforos
- de contagem ➜ pode assumir qualquer valor
  - usado para controlar o acesso à seção crítica (definem quantas threads podem acessar um recurso simultaneamente) e também para estabelecer a precedência de execução de operações em processos concorrentes
- binário ➜ valor 0 e 1
  - usado somente para controlar o acesso à seção crítica em processos ou threads

### Proteção da Seção crítica com semáforos
- valor inicial do semáforo = 1
- seção crítica estará protegida pelo uso das operações P, antes da seção crítica, e V, após a seção crítica
- para estabelecimento da precedência de operações entre threads, para cada par de thread, um semáforo inicializado com 0 deve ser utilizado
  - thread que precisa esperar deve efetuar a operação P
  - thread que deve executar primeiro, executa a operação V após a operação
- exemplo:  Suponha que a Thread 1 deve executar a operação Consulta() após a Thread 2 executar a operação AtualizaBD(). A solução para com semáforos é:
``` c
  Semaforo S =0;
  //Thread 1 
  P(S);
  Consulta();
  //Thread 2
  AtualizaBD();
  V(S);
```

- um semáforo mantém um conjunto de permissões:
  - acquire (adquirir) ➜ uma thread tenta obter uma permissão 
    - se nenhuma permissão estiver disponível ➜ thread é bloqueada até que uma permissão seja liberada por outra thread
  - release (liberar) ➜ uma thread libera uma permissão, tornando-a disponível para outra thread que possa estar esperando

---
<div align="center">

  ## Mutex
</div>
versão simplificada do semáforo, ou seja, não possui a capacidade de contar

- usados para proteção da seção crítica (fazer a exclusão mútua de recursos compartilhados entre processos ou threads cooperativos)
- fáceis de usar e eficientes
- é uma variável que pode ter dois estados: livre ou ocupado
  - apenas um bit é necessário para representá-lo
  - o valor zero representa o estado livre
  - valores diferentes de zero representam o estado ocupado       
- antes de entrar na seção crítica é preciso chamar **mutex_lock**
  - mutex estiver livre ➜ processo entra na seção crítica
  - mutex ocupado ➜ processo que fez a chamada é bloqueado até que o processo que se encontra na sua região crítica termine e chame mutex_unlock()
- ao sair da seção crítica **mutex_unlock**
  - se vários processos estiverem bloqueado no mutex, um deles será escolhido aleatoriamente e poderá entrar na região crítica   
---

<div align="center">
  
  ## Monitores
</div>
Brinch Hansen e Hoare propuseram uma primitiva de sincronismo de mais alto nível, para tornar mais fácil a sincronização de processos

- monitores são mecanismos de sincronização eficientes, de alto nível, usadas em programação concorrente para evitar condições de corrida quando múltiplos processos ou threads acessam recursos compartilhados
  - porém seu uso incorreto por parte dos programadores pode causar comportamentos imprevisíveis nos processos/threads cooperativos: espera indefinida, deadlock, condição de corrida
- monitor é um conjunto de rotinas, variáveis e estrutura de dados (toda agrupada em um tipo especial de módulos ou pacotes) ➜ encapsula as variáveis compartilhadas ou recursos e os procedimentos que operam sobre esses recursos, garantindo que apens uma thread execute dentro do monitor em um dado momento
- processos podem chamar as rotinas presentes em um monitor sempre que quiserem, mas não podem acessar diretamente as estruturas de dados internas do monitor a partir das rotinas declaradas fora dele
- propiedade importante que torna monitores úteis para obter exclusão mútua
  - a qualquer instante apenas um processo pode estar ativo em um monitor
- monitores são uma construção de linguagem de programação, onde o compilador sabe que são especiais e pode manipular chamadas às rotinas do monitor de forma diferente de outras chamadas de procedimento
- quando um processo chama uma rotina do monitor
  - verifica-se se algum outro processo está ativo dentro do monitor
    - se sim ➜ processo que faz a chamada fica suspenso até que o outro processo tenha saído do monitor
    - se nenhum processo estiver usando o monitor, o  processo que fez a chamada poderá entrar
- compilador implementa a exclusão mútua em entradas de monitor
  - como é o compilador que faz os preparativos para a exclusão mútua é menos provável a ocorrência de erros
- **operações concorrentes implementadas dentro de um monitor sempre serão executadas de forma a ter exclusão mútua**
- para estabelecer a precedência de operações ➜ **variáveis de condição** junto com duas operações sobre elas: wait e signal
  -  variável de condição ➜ usada dentro do monitor para suspender threads até que alguma condição seja verdadeira
    - útil para controlar o acesso e a ordem das threads que precisam de recursos compartilhados
  - se a rotina do monitor não pode continuar ➜ **wait** ➜ causa o bloqueio do processo
  - para desbloquear ➜ outro processo deve executar **signal** na variável de condição que está esperando
- após operação **signal**
  - hoare ➜ deixa o processo recentemente desbloqueado executar, suspendendo outro
  - Brinch Hanse ➜ refinar o problema, exigindo que um processo que execute uma operação signal deve sair do monitor imediatamente. 
    - se uma variável signal é executada em uma variável de condição em que vários processos estão esperando, apenas um deles é desbloqueado (determinado pelo escalonador do SO)
- se uma variável de condição é sinalizada sem ninguém esperando nela, o sinal é perdido
- linguagem Java suporta monitores
  - na declaração do método ➜ synchronized
    - garante que qualquer thread que estiver começando a executar este método, nenhuma thread poderá realizar qualquer outro método synchronized nessa classe
    - métodos sincronizados não possuem variáveis de condição
    - possui dois métodos: wait e notify ➜ semelhante a sleep e wakeup
      - quando usados dentro do monitor não estão sujeitas às condições de corrida

- semáforos e monitores não foram projetados para ambientes de memória compartilhada (1 ou + CPUs)
  - em sistemas distribuidos ➜ memória distribuída
    - esses mecanismos não são aplicáveis
    - uso de passagem de mensagens:
      - comunicação síncrona x assíncrona
      - RPC - Remote Procedure Call
      - RMI - Remote Method Invocation


---
<div align="center">
  
  ## BlockingQueue
</div>
é uma estrutura da biblioteca java.util.concurrent muito utilizada no desenvolvimento concorrente moderno

- implementa automaticamente:
  - sincronização
  - espera por espaço livre
  - espera por itens disponíveis
  - comunicação entre threads

- funcionamento:
  - inserção: fila.put(item);
    - se a fila estiver cheia ➜ thread espera automaticamente
  - remoção : fila.take();
    - se a fila estiver vazia ➜ thread espera automaticamente
  - **a própia estrutura controla a sincronização**