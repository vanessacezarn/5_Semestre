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
- instrução SWAP - trocar conteúdo de uma posição de memória com o conteúdo de registrador, sem interrupção
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

- ferramenta de sincronização
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
  - usado para controlar o acesso à seção crítica e também para estabelecer a precedência de execução de operações em processos concorrentes
- binário ➜ valor 0 e 1
  - usado somente para controlar o acesso à seção crítica em processos ou threads

### Proteção da Seção crítica com semáforos
- valor inicial do semafor = 1
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

- monitores são mecanismos de sincronização eficientes, porém seu uso incorreto por parte dos programadores pode causar comportamentos imprevisíveis nos processos/threads cooperativos: espera indefinida, deadlock, condição de corrida
- monitor é um conjunto de rotinas, variaveis e estrura de dados (toda agrupada em um tipo especial de módulos ou pacotes)
- processos podem chamar as rotinas presentes em um monitor sempre que quiserem, mas não podem acessar diretamente as estruturas de dados internas do monitor a partir das rotinas declaradas fora dele
- propiedade importante que torna monitores úteis para obter exclusão mútua
  - a qualquer instante apenas um processo pode estar ativo em um monitor
-     






