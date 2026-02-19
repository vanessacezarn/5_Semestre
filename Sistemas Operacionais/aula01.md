## Competências da disciplina
### unidade 01 - fundamentos e estruturas dos sistemas operacionais
- compreender os fundamentos dos sistemas operacionais, necessários às diferentes gerências que propiciam a multiprogramação, de forma assertiva
### unidade 02 - processos, threads e escalonamento
* analisar processos, threads e escalonamento do processador no ambiente multiprogramado, de forma precisa
### unidade 03 - sincronização de processos e dealocks
* aplicar a sincronização de processos de threads na programação concorrente, de forma precisa
### unidade 04 - memória ram, memória virtual e sistemas de arquivos
* compreender a organização da memória real, memória virtual e dos sistesmas de arquivos, nas gerências dos sistemas operacionais, de forma construtiva
---
# SISTEMAS OPERACIONAIS
* **definição:** é um programa colocado entre o hardware do computador e os programas do usuário
* comunicação com usuário ➜ torna o computardor conveniente
* gerência de recursos ➜ uso eficiente do hardware
* controla e coordena o uso do hardware entre os vários programas, aplicativos para os vários usuários
* SO é :
  * alocador de recursos
  * programa de controle
* proporcionar a execução de programas do usuário e facilitar a resolução de problemas do usuário
* é um programa que está sempre executando - kernel (núcleo), gerência do processador da memória principal e comunicação entre processos
* SO e a arquitetura dos computadores tiveram influência mútua
* oferece ao usuário um ambiente conveniente para o desenvolvimento e execução de programas
* gerencia os recursos de um sistema de computação de forma a garantir a correta e eficiente utilização dos mesmo
* 
### Tipos de Sistema Operacionais
#### 1 - SISTEMAS DE GRANDE PORTE
* usado na mainframes
* **Sistemas em lote (batch)** ➜ processamento sequencial jobs, monoprogramado, monousuário
    * máquinas grandes, operadas a partir de um console
    * dispositivos de entrada ➜ leitoras de cartões e unidades de fitas
    * disposivos de saída ➜ impressoras, unidades de fita e perfuradoreas de cartões
    * usuário não interagia diretamente com a máquina ➜ operadores profissionais agrupavam as tarefas
    * SO era simples ➜ transferia o controle de um job para outro
* **Sistemas multiprogramados**
    * sistema batch com os discos ➜ todas as tarefas no disco
    * e com as interrupções ➜ escalonamento de job ➜ multiprogramação
    * tarefa pode esperar por evento ou e/s
    * vários jobs na memória ➜ sobrepor operações de e/s com processamento
    * SO precisa tomar decisões
    * Pool de Jobs no disco
    * escalonamento de Jobs
    * escalonamento de cpu
    * gerência de memória
* **Sistemas de tempo compartilhado** ou sistemas Timesharing
    * multiusuário
    * cpu executa vários jobs alternando entre eles
        * as trocas ocorrem com frequência
        * os usuários podem interagir com o programa em execução ➜ possuem terminal
        * tarefas curtas (em termos de processamento) = muitas e/s
    * há uma divisão do tempo de processamento entre os vários usuários ➜ tempo de resposta
        * permite aos usuários compartilharem o computador ao mesmo tempo
    * multiprogramação
        * cada usuário tem um programa na mémoria
        * compartilhamento de tempo
        * sistema interativo
        * escalonamento de cpu
        * gerência de memória
        * memória virtual
        * sistema de arquivos
    * tornaram-se comuns no início da década de 70
#### 2 - SISTEMAS DE COMPUTADORES PESSOAIS (PC) OU DESKTOP
* inicialmente não possuíam recursos para proteger o SO, não eram multiusuário, nem multitarefas

#### 3 -SISTEMAS PARALELOS
* vários processadores (multiprocessadores) compartilhando barramento, clock, memória
* fortemente acoplados
* comunicação através da memória
* motivos:
    * maior througput
    * mais trabalho em menos tempo
    * maior confiabilidade
* multiprocessamento simétrico
    * todos processadores são iguais
    * um processo mestre controla o sistema
    * a maioria dos SO suporta SMP Symmetric Multi-Processing) através de multithreading
    * sistemas operacionais como Win Nt, Solaris, Unix, Linux, OS/2 possuem suporte a SMP  
#### 4 - SISTEMAS DISTRIBUIDOS 
* 1990 - crescimento das redes de computadores
* coleção de computadores que não compartilham memória ou clock, interconectados e trabalham de forma a disponibilizar um serviço
* sistemas fracamente acoplados
* comunicação acontece por trocas de mensagens
    * linha de comunicação: barramento, linhas telefônicas
* sistema cliente-servidor
* sistemas peer-to-peer
* sistemas operacionais distribuídos
#### 5 -SISTEMAS DE TEMPO REAL
* sistemas com próposito específico
* aplicação dedicada
* processamento precida ser feito dentro dos limites de tempo definidos
* quase não é encontrada memória virtual nestes sistemas
#### 6 - SISTEMAS PARA DISPOSITOVOS MÓVEIS
