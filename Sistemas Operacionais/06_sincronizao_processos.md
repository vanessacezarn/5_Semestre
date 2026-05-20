# Sincronização de processos
### ➤ Progamação concorrente
- caracteriza-se pela execução de vários processos que cooperam entre si para realização de uma determinada tarefa
- um programa executadoo por um único processo é dito programa sequencial
- um programa concorrente possui vários fluxos de execução de instruções e há necessidade de trocas de dados por estes fluxos
- arquiteturas com múltiplos processadores na execução de um programa concorrente ➜ acontece o paralelismo real
  - os vários processos ou threads são escalonados aos diferentes processadores ➜ tornando a execução paralela (simultânea)
  - cluster = diversos computadores ligados em paralelo
- arquitetura monoprocessador, a execução de um programa concorrente acontece alternadamente
  - os diferentes processos ou threads são escalonados à mesma CPU e não executam simultaneamente ➜ há um paralelismo aparente
#### ➥ motivação para o uso de programação concorrente
- permitir a exploração do paralelismo real existente em máquinas multiprocessadoras, consequentemente, o aumento de desempenho da aplicação
- permite realizar operações simultaneamente de processamento e I/O, ou seja, enquanto um fluxo de execução de instruções realiza operações de CPU, outro(s) executam operações de I/O
  - possibilita a obtenção de desempenho nas aplicações, diminuindo a ociosidade do processador enquanto operações de I/O são realizadas 
#### ➥ programação concorrente é mais complexa em relação à programação seqeuencial
- há necessidade de projetar e implementar as operações dos diferentes threads/processsos executando concorrentemente, de forma que os dados comuns a eles mantenham a consistência, os processos/threads mantenham a execução (não fique em espera indefinida) e o resultado final da aplicação seja correto, independente da velocidade de execução do processos
- a depuração de um programa concorrente é tarefa árdua comparada à execução sequencial
---
### ➤ Processos cooperativos
- processos concorrentes que podem afetar ou ser afetado diretamente pela execução uns dos outros
- são processos que cooperam para a realização de determinada atividade
- podem compartilhar diretamenteo mesmo espaço de endereçamento lógico (dados e código)
- por ser concorrentes, pode acontecer inconsistência ao serem acessados os dados compatilhados
--- 
### ➤ Problema do Produtor-Consumidor
- a programação concorrente implica no compartilhamento de recursos, como variáveis, estruturas de dados, registros, arquivos, banco de dados e etc
- o acesso aos recursos compartilhados devem ser feito mantendo-se o correto e coerente estado do sistema
- o problema do compartilhamento de recursos pode ser exemplificado com um problema clássico de sinronização em SO, chamado: problema do Produtor-Consumidor ou Problema do Buffer-limitado(bounded buffer)
- Segundo Silberschatz(2008) o problema possui:
  - um buffer de tamanho limitado compartilhado entre os processos
  - há um processo produtor que insere um item no buffer a cada execução
  - há um processo consumidor que remove um item do buffer a cada execução
  - há uma variável inteira (count) compartilhada entre os processos que é utilizada para contar quantos itens existem no buffer
<div align="center">
  <img width="481" height="189" alt="image" src="https://github.com/user-attachments/assets/8a1af096-e4e6-468f-9495-58d88f93ddc3" />
</div>  

- Esse problema mostra uma relação entre processos, bastante comum em SO, como por exemplo:
  - servidor de impressão: vários processos usuários com editor de texto e planilhas (produtores) produzem impressões e as enviam para uma fila (buffer limitado), o processo consumidor (servidor de impressão) organiza a fila, lê as impressões e as encaminha para a impressora
#### ➥ nesse problema, pode-se identificar as seguintes situações de sincronização
- quando o buffer estiver cheio
  - o processo produtor não poderá executar e deverá esperar até que exista espaço no buffer (até que um item seja consumido) 
- quando o buffer estiver vazio
  - o processo consumidor não poderá consumir e deverá esperar até que um item seja inserido no buffer
- quando um processo está atualizando dados compartilhados, nenhum outro poderá faze-lo
#### ➥ Thread Produtor X Thread Consumidor
<div align="center">
  <img width="478" height="265" alt="image" src="https://github.com/user-attachments/assets/2a928814-47d3-4e3a-9ef6-4e23d0220b63" />

</div>

---

### ➤ Condição de Corrida (Race Condition)
- como a execução dos processos é concorrente pode acontecer um erro com o valor da variável contadora
  - ao ser incrementada ou decrementada a variável cont, as instruções são traduzidas pelo compilador para:
   <div align="center">
      imagem
    </div>
- na execução sequencial, não há problema de concorrência à variável cont
- na execução concorrente, pode acontecer situações em que ambos os fluxos manipulem a variável **cont** concorrentemente e o valor final após a execução, pode ser inconsistente
  - exemplo: 
    <div align="center">
      <img width="375" height="124" alt="image" src="https://github.com/user-attachments/assets/12f99f2e-9da7-48b8-9a38-c5c2a070dc96" />

    </div>

    - no final o contador cont terminou valendo 1, mas deveria valer 2 ➜ produtor produziu 1 item e consumidor consumiu 1 item
    - se fosse invertida as 2 últimas linhas do exemplo ➜ produtor executasse a última instrução o contador cont terminaria valendo 3 ➜ valor ainda estaria incorreto
- **a condição de corrida acontece quando o valor dos dados compartilhados depende da ordem de execução dos fluxos de instruções e geralmente o valor resultante desta execução é um valor incorreto**    

---
### ➤ Seção Crítica
- é uma **seção (parte) de código de um processo ou thread** onde acontece a **manipulação de dados que são compartilhados** com outros processos ou threads e **deve executar de forma atômica com as interrupções desabilitadas**
- para evitar a Condição de Corrida ➜ deve-se proteger a seção crítica do código
- Quando vários threads possuem seção crítica, enquanto um deles estiver executando sua seção crítica, nenhum outro pode executar a sua, ou seja, o **acesso à seção crítica é mutuamente exclusivo**
#### ➥ requisitos para uma solução à Seção Crítica
uma solução deve  satisfazer aos seguintes requisitos (Considere Ti = thread ou processo = i)

1) **exclusão mútua**  ➜ dois ou mais processos não podem estar em sua seção crítica ao mesmo tempo.
    - exemplo: Se Ti está executando sua seção crítica, qualquer Tj , onde j≠i, não poderá executar sua seção crítica
2) **progresso** ➜ Somente threads executando sua seção não crítica participam da decisão de quem será o próximo a executar sua seção crítica; 
    - nenhum processo fora de sua seção crítica pode bloquear a execução de um outro processo
3) **espera limitada** ➜ deve existir um limite de espera ➜ processos não podem esperar indefinidamente para entrar em sua seção crítica
4) **solução independente da velocidade dos fluxos** ➜ solução deve ser independente da velocidade e quantidade de processos existentes e da quantidade de threads e processos

**soluções erradas ao problema da seção critica apresentam a possibilidade de deadlock, postergação indefinida ou inconsistência dos dados**

---
### ➤ Mecanismos de sincronização
- mecanismos **básicos** para obtenção da exclusão mútua ➜ mecanismos de sincronização
  - protocolos de acesso (em software puro)
  - Spin-lock
- mecanismos de **mais alto nível** para obtenção mútua são implementados a partir destes 3 mecanismos e são:
  - Mutex
  - Semáforos
  - Monitores


