# Arquitetura
- arquitetura de software representa a estrutura do sistema, seus componentes, suas interações e as decisões de projeto que definem seu funcionamento
  - Presssum: destaca que é a estrutura de dados e componentes + inter-relações
  - Sommerville: enfatiza que é uma organização de componentes com responsabilidades definidas
- arquitetura ➜ como o sistema é organizado por dentro
- importância da arquitetura
  - segundo Pressum: facilita a comunicação entre equipes, define decisões críticas desde o início, reduz riscos do projeto e serve como modelo do sistema
  - segundo Sommerville: impacta diretamente no desempenho, segurança, disponibilidade e manutenção
- vem logo após os requisitos: requisitos ➜ arquitetura ➜ projeto detalhado ➜ implementação
- arquitetura não é código ➜  é uma abstração de alto nível

### Decisões arquiteturais: 
1) existe uma arquitetura de aplicação genérica que possa agir como um template para o sistema que está sendo projetado?
2) como o sistema será distribuído entre os núcleos ou processadores de hardware?
3) quais padrões ou estilos de arquitetura poderiam ser utilizados?
4) qual será a abordagem fundamental utilizada para estruturar o sistema?
5) qual estratégia será utilizada para controlar a operação dos componentes no sistema?
6) como os componentes estruturais no sistema serão decompostos em subcomponentes?
7) qual é a melhor organização da arquitetura para entregar os requisitos não funcionais do sistema?
8) como a arquitetura do sistema deve ser documentada?

### Visões de arquitetura
- visão lógica ➜ funcionalidades
  - mostra as abstrações fundamentais do sistema como objetos ou classes
  - deve ser possível relacionar os requisitos do sistema às suas entidades 
- visão de processo ➜ execução e concorrência
  - mostra como, no tempo de execução, o sistema é composto de processos que interagem
  - visão útil para fazer julgamentos sobre características não funcionais do sistema, como o desempenho e a disponibilidade 
- visão de desenvolvimento ➜ organização de código
  - mostra como o software é decomposto para desenvolvimento: divisão em componentes que são implementados por um único desenvolvedor ou time de desenvolvimento
  - visão útil para gerentes e programadores de software 
- visão física ➜  infraestrutura/hardware
  - mostra o hardware do sistema e como os componentes de software estão distribuidos pelos processadores no sistema
  - é útil para os engenheiros que estão planejando uma implantação do sistema
 
## Estilos/padrões de arquitetura
- padrão geral de organização do sistema
### ➥ Arquitetura em camadas
- organiza o sistema em camadas, com funcionalidades associadas a cada uma
  - uma camada fornece serviços para a camada acima dela
  - as camadas inferiores representam serviços essenciais que tendem a ser utilizados em todo o sistema
- utilizada quando:
  -  se cria novos recursos em um sistema já existente
  -  o desenvolvimento é distribuido por vários times, cada um responsável por uma camada de funcionalidade
  -  há necessidade de segurança da informação em múltiplos níveis
-  vantagens:
  - permite substituir camadas inteiras contanto que a interface seja mantida
  - recursos redundantes podem ser fornecidos em cada camada para aumentar a dependabilidade do sistema  
-  desvantagens:
  - muito dificil de proporcionar uma separaçõa clara entre as camadas, de modo que a camada dos níveis mais alto podem ter de interagir diretamente com as dos níveis mais baixo em vez das imediatamentes inferiores a elas
  - desemepenho pode ser um problema por causa dos múltiplos níveis de interpretação de uma requisição de serviço à medida que essa requisição é processada em cada camada
<div align="center">
  <img width="487" height="184" alt="image" src="https://github.com/user-attachments/assets/55b4f326-df42-4412-9a9b-eaa0ecbe0bbb" />

</div>

### ➥ Arquitetura de repositório/centralizada em dados
- todos os dados em um sistema são gerenciados em um repositório central que é acessível a todos os componentes do sistema
- os componentes não interagem diretamente, apenas por meio do repositório
- é utilizado em :
  - sistemas no qual são gerados grandes volumes de dados de informações que precisam ser armazenados por muito tempo
  - sistemas dirigidos por dados, cuja inclusão no repositório dispara uma ação ou ferramenta 
- vantagens:
  - componentes podem ser independentes, não precisam saber da existência um do outro
  - mudança feita por um dos componentes pode ser propagada para todos os demais
  - todos os dados podem ser gerenciados de modo consistente, já que estão todos em um só lugar
- desvantagens:
  - o repositório é um único ponto de falha  ➜ os problemas no repositório afetam o sistema inteiro
  - pode haver ineficiência em organizar toda a comunicação por meio do repositório
  - pode ser difícil distribuir o repositório por vários computadores
<div align="center">
  <img width="475" height="281" alt="image" src="https://github.com/user-attachments/assets/6b5486ef-2b5a-46c5-9b92-7113f80ae357" />
</div>

### ➥ Arquitetura cliente-servidor
- é organizado como um conjunto de serviços e servidores associados e de clientes que acessam e usam esses serviços
- principais componentes do modelo:
  - conjunto de servidores que oferecem serviços para outros componentes
  - conjunto de clientes que demanda os serviços oferecidos pelos servidores
  - uma rede que permite que os clientes acessem esses serviços
- o sistema é apresentado como um conjunto de serviços, e cada serviço é fornecido por um servidor separado, os clientes são usuários desses serviços e acessam os servidores para usá-los
- utilização:
  -  quando os dados em um banco de dados compartilhado têm de ser acessado a partir de diversos locais
  -  quando a carga em sistema for variável, já que os servidores podem ser replicados
- vantagens: servidores podem ser distribuidos em rede ➜  a funcionalidade geral pode estar disponível para todos os clientes e não precisa ser implementada por todos os serviços
- desvantagem:
  - cada serviço é um único ponto de falha ➜ sucescetível a ataques de negação de serviço ou falha de servidor
  - desempenho pode ser imprevisível ➜ depende da rede e também do sistema
  - podem surgir problemas de gerenciamento se os servidores forem de propiedade de organizações diferentes
<div align="center">
  <img width="456" height="260" alt="image" src="https://github.com/user-attachments/assets/ab3604eb-45dd-4c46-97aa-341497af4d7b" />
</div>

### ➥ Arquitetura duto e filtro
- o processamento de dados em um sistema é organizado de modo que cada componente de processamento(filtro) é discreto e executa um tipo de transformação dos dados e os dados fluem (como em um duto) de um componente para outro para serem processados
- utilização: frequentemente nas aplicações de processamento de dados (tanto em lotes, tanto em transações) em que as entradas são processadas em estágios separados, gerando saídas relacionadas
- vantagens:
  - facíl de entender e permite o reuso de transformações
  - o eestilo do fluxo de trabalho corresponde à estrutura de muitos processos de negócio
  - a evolução por meio da adição de transformações é direta
  - pode ser implementada como um sistema sequencial ou concorrentes
- desvantagens:
  
  - formato da transferência de dados tem de ser acordado entre as transformações que se comunicam
  - Cada transformação deve analisar sua entrada e devolver a saída para a forma acordada
    - aumenta a sobrecarga do sistema e pode significar que é impossível reusar componentes arquiteturais que usam estruturas de dados incompatíveis ➜ reutilização desse tipo de sistema é muito baixa
 <div align="center">
  <img width="620" height="265" alt="image" src="https://github.com/user-attachments/assets/636646b6-8b16-4dae-8e8d-a47e0b29da02" />
   <img width="512" height="250" alt="image" src="https://github.com/user-attachments/assets/a489d3fb-14fe-4a4c-b45c-85889463a9d6" />

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
