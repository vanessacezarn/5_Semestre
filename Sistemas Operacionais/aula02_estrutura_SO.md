* DISCUSSÃO SOBRE O ESTUDO DIRIGIDO DA AULA ANTERIOR
* análise de um Sistema Operacional = nem todos os sistema possuem a mesma estrutura, mas existem alguns aspectos comuns
    * serviços fornecidos
    * interfaces fornecidas a usuários e programadores
    * componentes e interconexões
<div align="center">
  <img width="474" height="444" alt="{DFC00E19-4100-422B-89D0-1B5B89FD5243}" src="https://github.com/user-attachments/assets/e8f4a087-795d-406a-ba8a-61742067e851" />
</div>
  
### Mecanismos de interrupções
* um contralor de periférico que precisa enviar dados ao processador pode:
* ...
* sinalizar ocorrência de eventos
* tratador de interrupção
* interrupção pode ser ocasionada por hardware, software ou por uma exceção (exemplo: overflow, divisão por erro)
* vetor ou tabela de interrupções = número da interrupção (IRQ) e o endereço da rotina
* excução/tratamento da interrupção
    * transfere o controle para o tratador - salva o contexto da execução
    * desvia controle para o tratador
    * retorna execução - restaura o contexto de execução
* chamada de sistema = processo em que usuário solicita serviços ao sistema operacional --> interrupções de software (traps)
### PROTEÇÃO
*...
- de memória
- de CPU
#### Modo DUAL de operação
- a arquitetura de processadores oferece mecanismos para diferenciar dois modos de operação
    - modo supervisor (privilegiado)
    - modo usuário
        - caso o código em execução tenta executar uma instrução não disponível, será gerada uma exceção
- chaveamento de modos
    - interrupção (modo usuário ➜  modo supervisor)
    - instrução (modo supervisor ➜  modo usuário)

# Estrutura dos Sistemas Operacionais
- SO deve ser divido em pequenos componentes e não ser um sistema monolítico
## principais componentes:
- núcleo (kernel) ➜ gerência do processador, gerência da memória principal (RAM) e comunicação
- drivers ➜ códigos específicos para acessar os dispositivos físicos, exemplos: disco rígido, porta USB
- códigos de inicialização ➜ Reconhecer, testar e configurar os dispositivos instalados. Carregar o núcleo do SO e iniciar a execução
- programas utilitários ➜ funcionalidades complementares do SO

### KERNEL
- é a parte do SO executada com interrupções desabilitadas(enquanto tiver executando não responde a interrupções) e no modo privilegiados (todos comando estão disponíveis)
- pode ser monolíticos
    - toda e qualquer parte do SO é executada da maneira indivisível
      - cada trap (chamada do sistema) ou interrupção desabilita o sistema de interrupções 
    - desvantagens:
      - pode haver muita espera
      - complexidade da estrutura de organização do kernel
- ...
 
## como os componentes são combinados e interconectados
### estruta simples
- sistemas sem estrutura bem definida
- iniciaram pequenos, simples e limitados ➜ cresceram
<div align="center">
  <img width="645" height="371" alt="{E9F70F38-CB8B-4BA2-8C84-50E8D5AE702E}" src="https://github.com/user-attachments/assets/2e1690c5-0e30-4d38-8baf-6f017d88d438" />
</div>
- estrutura do unix

### camadas
- forma de modularização de um sistema
- é uma implementação de um objeto abstrato
- consiste em estruturas de dados e rotinas que podem ser chamadas por chamadas superiores
- ...
- menos eficientes devido à hierarquia de camadas
- permite maior controle do hardware em relaçao à abordagem simples

### microkernels ou micronúcleo
- com a expansão do unix, o kernel tornou-se grande e difícil de gerenciar
- 1980 - sistema operacional mach ➜ abordagem microkernel
    - implementa  somente os componentes essenciais do SO no Kernel, os demais são implementados como programas de sisemas e de usuário
    - retirou-se do kernel o código de alto nível
    - os componentes do SO comunica-se por meio de trocas de mensagens
    - kernel menor
    - facilidade de manutenção
- fornecem:
    - gerência mínima de memória e processos
    - um recurso de comunicação entre programas do usuário e serviços que estão em execução também no espaço de usuário
    - 

### módulos
### máquinas virtuais

---
## Atividade para próxima aula - estrutura de sistemas operacionais
1) Cada grupo escolhe um sistema operacional (Mac OS, Solaris, Linux, Windows...) para estudar a estrutura de seus componentes.
2) Realizar uma pesquisa bibliográfica sobre a Estrutura do Sistema Operacional escolhido.
3) Descrever sua estrutura e cada um de seus componentes.
4) Representar graficamente esta estrutura.
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
- 3 métodos para passar parâmetros às chamadas
   - registradores (mais simples)
   - bloco ou tabela na memória e o endereço do bloco é passado ao registrados
   - inseridos (push) na pilha do sistema pelo programa e lidos/removidos (pop) pelo SO
   - * segunda e terceira não limitam a quantidade de parâmetros
- 5 categorias de chamadas ao sistema
   - controle de processo
   - gerência de arquivos
   - gerência de dispositivos
   - manutenção de informações
   - comunicação
### Controle de processo
### Gerência de arquivos
- exemplos de chamadas: create/delete file, open, close, read, write,...
- atributos de arquivos: nome, tipo, código de proteção, tamanho,...
### Gerência de Dispositivos
- exemplos de chamadas: request/release device, read, write, reposition, get/set, 
### Gerência de informações
### Comunicação





