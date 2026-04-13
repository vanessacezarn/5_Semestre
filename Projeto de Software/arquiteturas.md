# Arquitetura
- arquitetura ➜ como o sistema é organizado por dentro
- importância, segundo Pressum:
  - facilita a comunicação entre equipes
  - define decisões críticas desde o início
  - reduz riscos do projeto
  - serve como modelo do sistema
-  segundo Sommerville, arquitetura impacta diretamente no desempenho, segurança, disponibilidade e manutenção
- vem logo após os requisitos: requisitos ➜ arquitetura ➜ projeto detalhado ➜ implementação
- arquitetura não é código ➜  é uma abstração de alto nível

### decisões arquiteturais: 
1) existe uma arquitetura de aplicação genérica que possa agir como um template para o sistema que está sendo projetado?
2) como o sistema será distribuído entre os núcleos ou processadores de hardware?
3) quais padrões ou estilos de arquitetura poderiam
4) ...

### visões de arquitetura
- visão lógica ➜ funcionalidades
- visão de processo ➜ execução e concorrência
  - mostra como, no tempo de execução, o sistema é composto de processos que interagem
  - visão útil para fazer julgamentos sobre características não funcionais do sistema, como o desempenho e a disponibilidade 
- visão de desenvolvimento ➜ organização de código
- visão física ➜  infraestrutura/hardware
  - mostra o hardware do sistema
 
## Estilos/padrões de arquitetura
- padrão geral de organização do sistema
### ➥ Arquitetura em camadas
- organiza o sistema em camadas, com funcionalidades associadas a cada uma
  - uma camada fornece serviços para a camada acima dela
  - as camadas inferiores representam serviços essenciais
- utilizada quando:
  -  se cria novos recursos em um sistema já existente
  -  o desenvolvimento é distribuido por vários times, cada um responsável por uma parte do sistema
  -  segurança
-  vantagens:
-  desvantagens:
  - muito dificil de proporcionar uma separaçõa clara entre as camadas, de modo que a camada dos níveis mais alto podem ter de interagir diretamente com as dos níveis mais baixo em vez das imediatamentes inferiores a elas
  - desemepenho pode ser
<div align="center">
  imagem
</div>

### ➥ Arquitetura de repositório/centralizada em dados
- todos os dados em um sistema são gerenciados em um repositório central que é acessível a todos os componentes do sistema
- os componentes não interagem
- é utilizado em sistemas no qual são gerados grandes volumes de dados
- vantagens:
  - componentes podem ser independentes
- desvantagens:
  - o repositório é um único ponto de falha  ➜ os problemas no repositório afetam o sistema inteiro
  - pode haver ineficiência em organizar toda a comunicação por meio do repositório
  - pode ser difícil distribuir o repositório por vários computadores
<div align="center">
  imagem
</div>

### ➥ Arquitetura cliente-servidor
- é organizado como um conjunto de serviços e servidores associados e de clientes que acessam a usam esses serviços
- principais componentes do modelo:
  - conjunto de servidores que oferecem serviços para outros componentes
- o servidor é apresentado como
- utilização: quando os dados
- vantagens: servidores podem ser distribuidos em rede
- desvantagem:
  - cada serviço é um único ponto de falha
  - sucescetível a ataques de negação de serviço ou falha de servidor
  - desempenho pode ser imprevisível ➜ depende da rede e também do sistema
<div align="center">
  imagem
</div>

### ➥ Arquitetura duto e filtro
- o processamento de dados em um sistema é organizado de modo que cada componente de processamento(filtro) é discreto e executa um tipo de transformação dos dados
- os dados fluem (como em um duto) de um componente para outro para serem processados
- utilização: frequentemente
- vantagens:
  - facíl de enteder
- desvantagens:
  - reutilização desse tipo de sistema é muito baixa
 <div align="center">
  imagem
</div>

### ➥ Arquitetura MVC - Model View Controller
- separa a aparesentação e a interação dos dados do sistema
- o sistema é estruturado em 3 componentes lógicos que interagem entre si
  - componente modelo
  - componente visão
  - componente controle
-  uitilização:
-  vantagens:
-  desvantagens: pode envolver mais código e aumentar sua complexidade 
<div align="center">
  imagem
</div>

### ➥ Arquitetura de aplicações
- modelos genéricos reutilizáveis que descrevem a estrutura
