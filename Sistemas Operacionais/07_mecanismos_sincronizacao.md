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

  ## Protocolos de Acesso 
</div>

- também chamada de soluções em software puro
- soluções para apenas 2 tarefas
### Algoritmo 3 - de Peterson
- combinação dos algoritmos 1 e 2 atendendo os requisitos de uma solução ao problema da Seção Crítica
- threads compartilham a variável inteira e o vetor booleano
  -   ```
      int x; //Pode ser inicializado com 1 ou 0
       boolean flag[2] = {false, false}
      ```
- para entrar em sua seção critica (Ti)
  - define flag[1]=true
  - declara que
### Desabilitar interrupções
- solução mais simples para proteção da Seção Crítica
- cada processo desativar todas as interrupções para entrar na seção crítica e reativá-las imediatamente após sair dela
- pode ser usado em sistema embarcados
- não é um método genérico ➜ não é aconselhável dar a processos de usuário a permissão para desabilitar interrupções
  - um processo de usuário pode desabilitar as interrupções e não habilitá-las 
---
<div align="center">

  ## Spin-lock
</div>

- hardware de sincronização
- algumas máquinas fornecem hardware especial 
  - permitem testar e modificar o conteúdo de uma palavra ou trocar o conteúdo de duas palavras (de forma atômica)
- instrução de máquina que executa de forma atômica
- vantagens:
  - simplicidade
  - instrução de máquina presente na maioria dos processadores
- desvantagens:
  - busy-waiting ➜ processo no laço de espera ocupa o processador
  - se existem vários processos, pode haver postergação indefinida
  - uso limitado a problemas com seção crítica pequena

---
<div align="center">

  ## Mutex
</div>

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
- operação V

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
- binário ➜ valor 0 e 1

### Proteção da Seção crítica com semáforos

---

<div align="center">
  
  ## Monitores
</div>
